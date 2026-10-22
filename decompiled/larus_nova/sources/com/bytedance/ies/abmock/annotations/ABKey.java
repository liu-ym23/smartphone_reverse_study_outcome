package com.bytedance.ies.abmock.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes19.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ABKey {
    boolean clientExperiment() default false;

    boolean exposure() default true;

    boolean preciseExperiment() default false;

    String value();
}
