package com.larus.im.internal.network.link.service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes30.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/im/internal/network/link/service/FlowLinkErrorType;", "", "Companion", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface FlowLinkErrorType {
    public static final int A2DP_PLAYER = 11;
    public static final int ASR_SET = 3;
    public static final int AUDIO_DATA = 13;
    public static final int AUDIO_FOCUS = 10;
    public static final int CREATE_CALL = 14;
    public static final int CREATE_HANDLER = 6;
    public static final a Companion = null;
    public static final int INVALID = 0;
    public static final int RECONNECT = 2;
    public static final int SESSION_FAILED = 8;
    public static final int START_TASK = 1;
    public static final int TASK_FAILED = 7;
    public static final int TIME_OUT = 15;
    public static final int TRIGGER_BOT = 12;
    public static final int TTS_SET = 4;
    public static final int WS_CONNECT = 5;
    public static final int WS_STATE = 9;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f349502a = null;

        static {
            f349502a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f349502a;
    }
}
