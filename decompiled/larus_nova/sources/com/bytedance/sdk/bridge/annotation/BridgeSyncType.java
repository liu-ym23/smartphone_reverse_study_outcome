package com.bytedance.sdk.bridge.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes22.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface BridgeSyncType {
    public static final String ASYNC = "ASYNC";
    public static final String SYNC = "SYNC";
}
