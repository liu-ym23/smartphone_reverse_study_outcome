package com.bytedance.permissions.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes21.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionsRequest {
    boolean forceAllPermissionsRequest() default false;

    boolean[] forceRequest() default {false};

    String scene() default "";
}
