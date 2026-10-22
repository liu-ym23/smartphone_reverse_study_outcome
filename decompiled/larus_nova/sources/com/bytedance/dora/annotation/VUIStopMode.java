package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface VUIStopMode {
    public static final int END = 3;
    public static final int STOP_CONVERSATION = 8;
    public static final int STOP_CONVERSATION_SILENT = 9;
    public static final int STOP_ONBOARDING = 5;
}
