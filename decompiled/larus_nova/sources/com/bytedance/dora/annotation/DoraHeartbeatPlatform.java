package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface DoraHeartbeatPlatform {
    public static final int HARMONY = 4;
    public static final int IOS = 3;
    public static final int MTK = 2;
    public static final int QUALCOMM = 1;
    public static final int UNKNOWN = 5;
}
