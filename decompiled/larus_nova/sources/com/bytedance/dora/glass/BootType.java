package com.bytedance.dora.glass;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface BootType {
    public static final int POWER_OFF = 1;
    public static final int POWER_ON = 2;
    public static final int REBOOT = 3;
}
