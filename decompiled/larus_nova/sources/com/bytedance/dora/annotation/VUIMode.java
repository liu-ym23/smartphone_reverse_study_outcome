package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface VUIMode {
    public static final int CONNECT_OK = 9;
    public static final int DISABLE = 1;
    public static final int ENABLE = 2;
    public static final int ENV_OBSER = 11;
    public static final int INVALID = 0;
    public static final int KEY_ONLY = 5;
    public static final int MANUAL = 3;
    public static final int ONBOARDING_CHECK_WEAR = 12;
    public static final int ONBOARDING_KEY_LONG_PRESS_ONLY = 11;
    public static final int ONBOARDING_LIVE_AI = 14;
    public static final int ONBOARDING_TAKE_PHOTO = 13;
    public static final int RADIO_ONLY = 7;
    public static final int RESET = 8;
    public static final int SIMUL_INTERPRET_GUI = 10;
    public static final int START_ONBOARDING = 4;
    public static final int VOICE_ONLY = 6;
}
