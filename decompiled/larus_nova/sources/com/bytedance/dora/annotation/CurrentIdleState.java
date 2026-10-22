package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface CurrentIdleState {
    public static final int A2DP = 1;
    public static final int HFP = 2;
    public static final int TTS = 4;
    public static final int UnSupport = -1;
}
