package com.larus.audio.call.dora;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/audio/call/dora/CommandStatus;", "", "Companion", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface CommandStatus {
    public static final int COMMAND_VUI_END = 5;
    public static final int COMMAND_VUI_END_SILENCE = 21;
    public static final int COMMAND_VUI_HANG_UP = 803;
    public static final int CONTINUOUS_TALK_STOP = 30;
    public static final a Companion = null;
    public static final int DORA_CONTINUE_LISTEN = 26;
    public static final int DORA_NEXT_CALL_ADD_CHAT_EXTRA = 51;
    public static final int DORA_NOISE_CONTROL = 900;
    public static final int DORA_NOTIFICATION_FINISH_AFTER_TTS = 16;
    public static final int DORA_NOTIFICATION_SUMMARY_NEED_ACK = 15;
    public static final int DORA_NOTIFICATION_SUMMARY_NEED_REPLY = 35;
    public static final int DORA_NO_SPEECH_BEFORE_END = 55;
    public static final int DORA_PICTURE_OCCLUSION = 22;
    public static final int DORA_REVERT_NEXT_CALL_ADD_CHAT_EXTRA = 52;
    public static final int DORA_STOP_LISTEN_NOW = 12;
    public static final int DORA_STOP_LISTEN_NOW_IF_NO_TTS = 13;
    public static final int DORA_STOP_LISTEN_SILENCE = 14;
    public static final int DORA_TRACE = 1000;
    public static final int DORA_TRIGGER_UPDATE_UI_CONTEXT = 50;
    public static final int DORA_VISION_INTENTION = 23;
    public static final int DORA_VISION_MODE_INTENTION = 24;
    public static final int DORA_WEARABLE_INTERACT_INTENTION = 27;
    public static final int GUIDE_HEAD_SET = 1;
    public static final int IDLE = -1;
    public static final int LLM_FIRST_PACK = 20;
    public static final int PLAY_MUSIC = 3;
    public static final int POP_UP_AUTH_WINDOW = 6;
    public static final int POP_UP_LOCATION_AUTH_WINDOW = 9;
    public static final int START_LOOPING_TO_UPDATE_LOCATION = 10;
    public static final int STOP_ON_BOARDING = 4;
    public static final int TRACING = 8;
    public static final int UPDATE_LOCATION_AND_RESEND_QUERY = 11;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f289108a = null;

        static {
            f289108a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f289108a;
    }
}
