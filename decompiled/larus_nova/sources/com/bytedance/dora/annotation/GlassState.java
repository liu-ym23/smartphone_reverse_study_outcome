package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface GlassState {
    public static final int BOOTED = 2;
    public static final int FOLD = 4;
    public static final int HALTED = 3;
    public static final int OPEN = 5;
    public static final int POWER_OFF = 0;
    public static final int POWER_ON = 1;
    public static final int UNKNOWN = -1;
}
