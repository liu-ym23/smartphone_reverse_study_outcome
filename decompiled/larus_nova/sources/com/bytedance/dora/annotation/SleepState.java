package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface SleepState {
    public static final int AR1_PENDING_SLEEP = 0;
    public static final int AR1_SLEEP = 1;
    public static final int AR1_WAKE_UP = 2;
    public static final int UNKNOWN = -1;
}
