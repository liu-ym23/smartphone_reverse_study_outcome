package com.bytedance.router.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes21.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface RouteUri {
    Class<?> model() default Void.class;

    String[] value() default {""};
}
