package com.bytedance.lego.init.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes20.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface IdleTask {
    String desc();

    String id();

    boolean mustRunInMainThread();

    int priority() default 0;
}
