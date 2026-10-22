package com.bytedance.sdk.xbridge.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes22.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface XBridgeMethod {
    String biz() default "";

    String name();

    String namespace() default "";

    String owner() default "";
}
