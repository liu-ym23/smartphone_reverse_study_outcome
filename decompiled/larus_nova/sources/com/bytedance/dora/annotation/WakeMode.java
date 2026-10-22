package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface WakeMode {
    public static final int EXPLORE = 5;
    public static final int INVALID = 0;
    public static final int KEY = 3;
    public static final int LIVE_TOUCH = 7;
    public static final int LIVE_VOICE = 6;
    public static final int ONBOARDING = 4;
    public static final int RADIO = 2;
    public static final int SIMUL_INTERPRET_BUTTON = 8;
    public static final int SIMUL_INTERPRET_TOUCH = 10;
    public static final int SIMUL_INTERPRET_VOICE = 9;
    public static final int VOICE = 1;
}
