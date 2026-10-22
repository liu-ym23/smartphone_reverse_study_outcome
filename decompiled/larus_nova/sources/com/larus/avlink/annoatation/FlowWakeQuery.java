package com.larus.avlink.annoatation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes23.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/avlink/annoatation/FlowWakeQuery;", "", "Companion", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface FlowWakeQuery {
    public static final a Companion = null;
    public static final int END = 3;
    public static final int INTERACTIVE_PULL_REQUEST = 12;
    public static final int INVALID = 0;
    public static final int LIVE_AI_MUTE = 5;
    public static final int LIVE_AI_UNMUTE = 6;
    public static final int REJECT_START_VUI = 10;
    public static final int START = 2;
    public static final int START_CONVERSATION = 7;
    public static final int STOP = 1;
    public static final int STOP_CONVERSATION = 8;
    public static final int TTS_BREAK = 4;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f291633a = null;

        static {
            f291633a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f291633a;
    }
}
