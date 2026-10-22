package com.ss.android.lark.appsetting.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes34.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AppConfig {
    String key();

    boolean needDiskCache() default true;

    String parse() default "";

    AppConfigPriority priority() default AppConfigPriority.SETTINGS_ONLY;
}
