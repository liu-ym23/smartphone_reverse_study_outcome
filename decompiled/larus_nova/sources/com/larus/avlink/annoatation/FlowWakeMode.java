package com.larus.avlink.annoatation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes23.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/avlink/annoatation/FlowWakeMode;", "", "Companion", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface FlowWakeMode {
    public static final a Companion = null;
    public static final int ENV_OBSERVE = 11;
    public static final int EXPLORE = 5;
    public static final int GESTURE_NOTE = 21;
    public static final int INVALID = 0;
    public static final int KEY = 3;
    public static final int LIVE_AI_TOUCH = 7;
    public static final int LIVE_AI_VIDEO_STREAM = 32;
    public static final int LIVE_AI_VOICE = 6;
    public static final int ONBOARDING = 4;
    public static final int RADIO = 2;
    public static final int RECORD_MINUTES_CALL = 17;
    public static final int RECORD_MINUTES_GESTURE = 15;
    public static final int RECORD_MINUTES_GUI = 16;
    public static final int RECORD_MINUTES_IM = 13;
    public static final int RECORD_MINUTES_VUI = 14;
    public static final int SILENT_LAUNCH = 18;
    public static final int SIMUL_INTERPRET_GUI = 8;
    public static final int SIMUL_INTERPRET_TOUCH = 10;
    public static final int SIMUL_INTERPRET_VUI = 9;
    public static final int VOICE = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f291632a = null;

        static {
            f291632a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f291632a;
    }
}
