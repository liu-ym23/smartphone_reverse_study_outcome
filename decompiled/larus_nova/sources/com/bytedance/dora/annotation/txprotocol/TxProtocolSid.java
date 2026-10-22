package com.bytedance.dora.annotation.txprotocol;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface TxProtocolSid {
    public static final int CROSS_SYSTEM = 32;
    public static final int DEVICE_MANAGEMENT = 1;
    public static final int DOU_BAO = 2;
    public static final int HEALTH_SERVICE = 8;
    public static final int H_PROTOCOL = 43;
    public static final int OTA = 3;
    public static final int TEST = 4;
}
