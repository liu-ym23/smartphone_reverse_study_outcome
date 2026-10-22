package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface DoraHeartbeatNetworkStatus {
    public static final int MOBILE = 1;
    public static final int NO_WIFI_NO_MOBILE = 0;
    public static final int WIFI_2_4G = 2;
    public static final int WIFI_2_4G_MOBILE = 3;
    public static final int WIFI_5G = 4;
    public static final int WIFI_5G_MOBILE = 5;
}
