package com.bytedance.dora.wlan.softap;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface DoraWifiSoftApEvent {
    public static final int EVENT_AP_READY = 1;
    public static final int EVENT_CONNECT_FAILED = 5;
    public static final int EVENT_CONNECT_SUCCESS = 2;
    public static final int EVENT_DISCONNECT = 4;
    public static final int EVENT_DISCONNECT_REQUEST = 3;
    public static final int EVENT_ERROR = 7;
    public static final int EVENT_NETWORK_LOSS = 8;
    public static final int EVENT_START = 0;
    public static final int EVENT_TIMEOUT = 6;
}
