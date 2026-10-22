package com.bytedance.dora.wlan.trace;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface DoraConnectionFailedReason {
    public static final String STATION_CONNECT_FAILED = "stationConnectFailed";
    public static final String STATION_OPEN_CMD_SEND_FAILED = "stationOpenCMDSendFailed";
    public static final String STATION_OPEN_TIMEOUT = "stationOpenTimeout";
    public static final String STATION_UN_KNOWN_ERROR = "stationUnKnowError";
    public static final String WIFI_CONNECT_FORCE_CLOSED = "wifiConnectBeForceClosed";
}
