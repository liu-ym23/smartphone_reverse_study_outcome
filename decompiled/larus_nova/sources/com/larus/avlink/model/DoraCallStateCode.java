package com.larus.avlink.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/avlink/model/DoraCallStateCode;", "", "Companion", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface DoraCallStateCode {
    public static final int CLIENT_INTENT = 205;
    public static final a Companion = null;
    public static final int DORA_NEW_USER_GUIDE = 201;
    public static final int DORA_OB_USER_END = 200;
    public static final int DOUBAO_CMD_12 = 112;
    public static final int DOUBAO_CMD_13 = 113;
    public static final int DOUBAO_CMD_14 = 114;
    public static final int DOUBAO_CMD_21 = 115;
    public static final int DOUBAO_CMD_5 = 111;
    public static final int DOUBAO_ENV_OBE_STOP_CONVERSATION = 140;
    public static final int DOUBAO_FOCUS_CHANGED = 162;
    public static final int DOUBAO_INTERRUPT = 163;
    public static final int DOUBAO_MOCK_STOP = 900;
    public static final int DOUBAO_NETWORK_ERROR_INVALID = 129;
    public static final int DOUBAO_RADIO_AUTO_END = 102;
    public static final int DOUBAO_RAPID_FLASHING_END = 170;
    public static final int DOUBAO_SESSION_TIMEOUT = 103;
    public static final int DOUBAO_START_LIVE_TUTOR = 172;
    public static final int DOUBAO_START_REALTIME_CALL = 171;
    public static final int DOUBAO_STOP_BY_DISCONNECT = 100;
    public static final int DOUBAO_STOP_CALL_BY_CONVERSATION_MODE = 301;
    public static final int DOUBAO_STOP_CALL_BY_SPRING_DEGRADE = 254;
    public static final int DOUBAO_STOP_RECORD_BY_EXCEPTION = 178;
    public static final int DOUBAO_STOP_RECORD_BY_GUI = 175;
    public static final int DOUBAO_STOP_RECORD_BY_IM = 177;
    public static final int DOUBAO_STOP_SI_BY_EXCEPTION = 169;
    public static final int DOUBAO_STOP_SI_BY_GUI = 164;
    public static final int DOUBAO_STOP_SI_BY_NOTIFICATION = 167;
    public static final int DOUBAO_STOP_SI_BY_TIMEOUT = 166;
    public static final int DOUBAO_STOP_SI_BY_VUI = 165;
    public static final int DOUBAO_VUI_ERROR = 130;
    public static final int DOUBAO_WEAR_STATE = 101;
    public static final int ENV_OBSERVE_AUTO_LINK_CONNECTED = 189;
    public static final int ENV_OBSERVE_AUTO_TIMER_ENTER_PAUSE = 186;
    public static final int ENV_OBSERVE_AUTO_TIMER_EXIT_PAUSE = 187;
    public static final int ENV_OBSERVE_AUTO_TIMER_HEARTBEAT = 188;
    public static final int ENV_OBSERVE_END = 180;
    public static final int ENV_OBSERVE_STOP_CONVERSATION_NOT_CONNECTED = 181;
    public static final int ENV_OBSERVE_STOP_CONVERSATION_NOT_STARTED = 182;
    public static final int ENV_OBSERVE_USER_SWITCH = 181;
    public static final int ENV_OBSERVE_USER_TIMER_END = 184;
    public static final int ENV_OBSERVE_USER_TIMER_START = 183;
    public static final int ENV_OBSERVE_USER_TIMER_SWITCH = 182;
    public static final int ENV_OBSERVE_USER_WIFI_CONFIG = 185;
    public static final int HARMORY_BG_STATE_CHANGE = 210;
    public static final int RTC_STOP = 199;
    public static final int RTC_STOP_FROM_P2P_FAILED = 198;
    public static final int RTOS_ASR_TIME_OUT = 4;
    public static final int RTOS_AUTO_CALL = 39;
    public static final int RTOS_EXCEPTION = 10;
    public static final int RTOS_HFP_CALLING = 9;
    public static final int RTOS_INTERRUPT_AND_NEW_CALL = 41;
    public static final int RTOS_INVALID = 0;
    public static final int RTOS_KEY_INTERRUPT = 6;
    public static final int RTOS_LONG_PRESS = 11;
    public static final int RTOS_LONG_PRESS_VUI_END = 32;
    public static final int RTOS_NETWORK_ERR_VUI_END = 33;
    public static final int RTOS_ONE_DRAG_TWO = 45;
    public static final int RTOS_RADIO = 1;
    public static final int RTOS_SINGLE_CLICK = 12;
    public static final int RTOS_STOP_SI_BY_GESTURE = 168;
    public static final int RTOS_TTS_TIME_OUT = 5;
    public static final int RTOS_VIDEOING = 35;
    public static final int RTOS_VOICE_TIME_OUT = 3;
    public static final int RTOS_WAKE_UP = 2;
    public static final int UNKNOWN = -1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f293407a = null;

        static {
            f293407a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f293407a;
    }
}
