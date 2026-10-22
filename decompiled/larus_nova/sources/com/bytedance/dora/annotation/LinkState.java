package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface LinkState {
    public static final int CONNECTED = 2;
    public static final int CONNECTING = 1;
    public static final int DISCONNECTED = 0;
    public static final int DISCONNECTING = 3;
    public static final int UN_BONDED = -1;
}
