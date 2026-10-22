package com.larksuite.framework.apiplugin.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes24.dex */
@Target({ElementType.FIELD})
@Documented
@Repeatable(LKRequiredParamContainer.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface LKRequiredParam {
    boolean gray() default false;

    String warning() default "";
}
