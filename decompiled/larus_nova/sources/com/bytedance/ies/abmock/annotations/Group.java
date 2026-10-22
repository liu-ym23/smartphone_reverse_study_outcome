package com.bytedance.ies.abmock.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes19.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Group {
    Class clazz() default Void.class;

    String english() default "";

    boolean isDefault() default false;

    float percent() default -1.0f;

    String value() default "";

    String vid() default "";
}
