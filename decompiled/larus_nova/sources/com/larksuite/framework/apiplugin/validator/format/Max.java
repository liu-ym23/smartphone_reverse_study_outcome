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
@Repeatable(MaxContainer.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Max {
    boolean gray() default false;

    boolean include() default true;

    double value();

    String warning() default "";
}
