package com.larksuite.framework.apiplugin.validator.format;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes24.dex */
@Target({ElementType.FIELD})
@Documented
@Repeatable(NumberEnumContainer.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberEnum {
    boolean gray() default false;

    double[] values() default {};

    String warning() default "";
}
