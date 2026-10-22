package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface WakeState {
    public static final int INVALID = 0;
    public static final int SLEEP = 1;
    public static final int WAKE = 2;
}
