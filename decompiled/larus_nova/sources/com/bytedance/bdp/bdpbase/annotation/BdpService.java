package com.bytedance.bdp.bdpbase.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes11.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface BdpService {
    String category() default "";

    String desc() default "";

    String owner() default "";

    String since() default "";

    String title() default "";
}
