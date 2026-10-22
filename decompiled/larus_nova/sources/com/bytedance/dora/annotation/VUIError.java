package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface VUIError {
    public static final int A2DP_PLAYER = 11;
    public static final int ASR_SET = 3;
    public static final int AUDIO_DATA = 13;
    public static final int AUDIO_FOCUS = 10;
    public static final int CREATE_CALL = 14;
    public static final int CREATE_HANDLER = 6;
    public static final int INVALID = 0;
    public static final int RECONNECT = 2;
    public static final int SESSION_FAILED = 8;
    public static final int START_TASK = 1;
    public static final int TASK_FAILED = 7;
    public static final int TRIGGER_BOT = 12;
    public static final int TTS_SET = 4;
    public static final int WS_CONNECT = 5;
    public static final int WS_STATE = 9;
}
