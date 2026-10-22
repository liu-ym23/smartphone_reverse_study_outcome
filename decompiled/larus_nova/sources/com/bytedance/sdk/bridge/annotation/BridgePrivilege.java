package com.bytedance.sdk.bridge.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes22.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface BridgePrivilege {
    public static final String PRIVATE = "private";
    public static final String PROTECTED = "protected";
    public static final String PUBLIC = "public";
}
