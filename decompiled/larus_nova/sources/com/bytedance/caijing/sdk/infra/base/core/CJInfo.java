package com.bytedance.caijing.sdk.infra.base.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes15.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface CJInfo {
    String category() default "";

    String desc() default "";

    String doc() default "";

    String owner();

    String title() default "";
}
