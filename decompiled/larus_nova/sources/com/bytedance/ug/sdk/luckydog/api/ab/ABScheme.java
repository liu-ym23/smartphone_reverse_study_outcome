package com.bytedance.ug.sdk.luckydog.api.ab;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ABScheme {
    boolean isDefault() default false;

    ABSchemeType schemeType();
}
