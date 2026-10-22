package com.bytedance.dora.wlan.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface DoraWifiMode {
    public static final int CLOSE_WIFI = 1;
    public static final int P2P = 4;
    public static final int P2P_GC = 5;
    public static final int REMOVE_WIFI = 6;
    public static final int SOFT_AP = 3;
    public static final int STATION = 2;
}
