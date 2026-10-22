package com.bytedance.dora.protocol;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface VUIWakeMode {
    public static final int COMPANION_BY_GESTURE = 7;
    public static final int COMPANION_BY_INITIATIVE = 6;
    public static final int ENV_OBSER = 11;
    public static final int EXPLORE = 5;
    public static final int INVALID = 0;
    public static final int KEY = 3;
    public static final int LIVE_AI_VIDEO_STREAM = 32;
    public static final int ONBOARDING = 4;
    public static final int QUICK_NOTE = 21;
    public static final int RADIO = 2;
    public static final int RECORD_MINUTES_BUTTON = 15;
    public static final int RECORD_MINUTES_CALL = 17;
    public static final int RECORD_MINUTES_GUI = 16;
    public static final int RECORD_MINUTES_IM = 13;
    public static final int RECORD_MINUTES_INTENTION = 14;
    public static final int SILENT_LAUNCH = 18;
    public static final int SIMUL_INTERPRET_GUI = 8;
    public static final int SIMUL_INTERPRET_TOUCH = 10;
    public static final int SIMUL_INTERPRET_VUI = 9;
    public static final int VOICE = 1;
}
