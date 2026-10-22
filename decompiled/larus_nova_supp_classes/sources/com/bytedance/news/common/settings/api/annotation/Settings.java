package com.bytedance.news.common.settings.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Settings {
    boolean isSupportMultiProcess() default false;

    Class<Object>[] migrations() default {};

    String settingsId() default "";

    String storageKey();
}
