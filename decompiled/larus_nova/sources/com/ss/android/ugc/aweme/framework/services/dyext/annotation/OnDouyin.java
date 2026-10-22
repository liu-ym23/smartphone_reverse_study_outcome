package com.ss.android.ugc.aweme.framework.services.dyext.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes40.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OnDouyin {
    boolean downgradable() default true;

    boolean enabled() default true;

    boolean needPlugin() default false;
}
