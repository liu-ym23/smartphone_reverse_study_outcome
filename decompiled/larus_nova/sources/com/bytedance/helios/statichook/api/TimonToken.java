package com.bytedance.helios.statichook.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes19.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface TimonToken {
    String[] extras() default {};

    String token();
}
