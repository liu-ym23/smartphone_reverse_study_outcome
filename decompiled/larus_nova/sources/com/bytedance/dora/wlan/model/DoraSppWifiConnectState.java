package com.bytedance.dora.wlan.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface DoraSppWifiConnectState {
    public static final int CONNECTED = 3;
    public static final int CONNECTING = 2;
    public static final int IDLE = 1;
    public static final int TBD = 4;
}
