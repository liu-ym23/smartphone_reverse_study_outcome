package com.bytedance.dora.wlan.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface DoraWifiErrorCode {
    public static final int NO_ERROR = 0;
    public static final int OTHER_ERROR = 2;
    public static final int PASSWORD_ERROR = 1;
}
