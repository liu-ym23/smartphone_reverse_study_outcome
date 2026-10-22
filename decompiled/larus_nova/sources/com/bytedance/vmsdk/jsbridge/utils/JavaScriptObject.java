package com.bytedance.vmsdk.jsbridge.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes22.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface JavaScriptObject {
    String name() default "";
}
