package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** @EnableDiscoveryClient和@EnableEurekaClient共同点就是：都是能够让注册中心能够发现，扫描到服务。
不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心(eureka, consul, zookeeper)。
*/
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class Client1Application {

    public static void main(String[] args) {
        SpringApplication.run(Client1Application.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home()
    {
        //return "hi " + name + ",i am from port:" + port;

        String testJson = "{\"Name\" : \"战神\",\"sex\" : [\"男\",\"女\",\"人妖\"],\"Education\":{\"GradeSchool\" : \"第一小学\",\"MiddleSchool\" : [\"第一初中\" , \"第一高中\"], \"University\" :{ \"Name\" : \"哈佛大学\", \"Specialty\" : [\"一年级\",\"二年级\"]}}}";
        return testJson;
    }
}
