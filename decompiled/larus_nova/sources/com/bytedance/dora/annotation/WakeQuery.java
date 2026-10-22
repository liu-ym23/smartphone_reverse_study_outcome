package com.bytedance.dora.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface WakeQuery {
    public static final int END = 3;
    public static final int INTERACTIVE_HANG_UP_REQUEST = 13;
    public static final int INTERACTIVE_PULL_REQUEST = 12;
    public static final int INTERACTIVE_PULL_REQUEST_STATE_REPORT = 11;
    public static final int INVALID = 0;
    public static final int LIVE_AI_MUTE = 5;
    public static final int LIVE_AI_UNMUTE = 6;
    public static final int REJECT_START_VUI = 10;
    public static final int START = 2;
    public static final int START_CONVERSATION = 7;
    public static final int STOP = 1;
    public static final int STOP_CONVERSATION = 8;
    public static final int TTS_BREAK = 4;
}
