package com.bytedance.dora.wlan.p2p;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface DoraWifiP2pEvent {
    public static final int EVENT_CLIENTS_EMPTY = 7;
    public static final int EVENT_CONNECT_FAILED = 4;
    public static final int EVENT_CONNECT_SUCCESS = 1;
    public static final int EVENT_DISCONNECT = 3;
    public static final int EVENT_DISCONNECT_REQUEST = 2;
    public static final int EVENT_NETWORK_DISCONNECTED = 6;
    public static final int EVENT_START = 0;
    public static final int EVENT_TIMEOUT = 5;
}
