package com.larus.dora.api.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes27.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface CurrentIdleState {
    public static final int A2DP = 1;
    public static final int FOCUS = 32;
    public static final int HFP = 2;
    public static final int OTA = 16;
    public static final int TTS = 4;
    public static final int UnSupport = -1;
    public static final int VUI = 8;
}
