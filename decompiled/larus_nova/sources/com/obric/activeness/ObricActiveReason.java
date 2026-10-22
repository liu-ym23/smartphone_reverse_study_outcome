package com.obric.activeness;

import com.larus.bmhome.chat.bean.SuggestActionType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/activeness/ObricActiveReason;", "", "<init>", "(Ljava/lang/String;I)V", "DEVICE_SCREEN_ON", "APP_FOREGROUND", SuggestActionType.SEND_MSG, "GLOBAL_AUDIO_IN_PROGRESS", "MSG_TTS_IN_PROGRESS", "INTENT_IN_PROGRESS", "COMPLEX_TASK_IN_PROGRESS", "REALTIME_CALL_IN_PROGRESS", "AI_NOTE_IN_PROGRESS", "CLICK_TALK_IN_PROGRESS", "ALARM_TTS_IN_PROGRESS", "DORA_WAKEUP", "MEMORY_DATA_IN_USE", "OAUTO_FOREGROUND", "RECORD_MINUTES_IN_PROGRESS", "APP_UPDATE", "PLUGIN_UPDATE", "ACTIVE_TEST", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricActiveReason extends Enum<ObricActiveReason> {
    public static final ObricActiveReason ACTIVE_TEST = null;
    public static final ObricActiveReason AI_NOTE_IN_PROGRESS = null;
    public static final ObricActiveReason ALARM_TTS_IN_PROGRESS = null;
    public static final ObricActiveReason APP_FOREGROUND = null;
    public static final ObricActiveReason APP_UPDATE = null;
    public static final ObricActiveReason CLICK_TALK_IN_PROGRESS = null;
    public static final ObricActiveReason COMPLEX_TASK_IN_PROGRESS = null;
    public static final ObricActiveReason DEVICE_SCREEN_ON = null;
    public static final ObricActiveReason DORA_WAKEUP = null;
    public static final ObricActiveReason GLOBAL_AUDIO_IN_PROGRESS = null;
    public static final ObricActiveReason INTENT_IN_PROGRESS = null;
    public static final ObricActiveReason MEMORY_DATA_IN_USE = null;
    public static final ObricActiveReason MSG_TTS_IN_PROGRESS = null;
    public static final ObricActiveReason OAUTO_FOREGROUND = null;
    public static final ObricActiveReason PLUGIN_UPDATE = null;
    public static final ObricActiveReason REALTIME_CALL_IN_PROGRESS = null;
    public static final ObricActiveReason RECORD_MINUTES_IN_PROGRESS = null;
    public static final ObricActiveReason SEND_MSG = null;
    public static final ObricActiveReason UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricActiveReason[] f384393a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f384394b = null;

    public static EnumEntries<ObricActiveReason> getEntries() {
        return f384394b;
    }

    static {
        ObricActiveReason r100 = new ObricActiveReason("DEVICE_SCREEN_ON", 0);
        DEVICE_SCREEN_ON = r100;
        ObricActiveReason r101 = new ObricActiveReason("APP_FOREGROUND", 1);
        APP_FOREGROUND = r101;
        ObricActiveReason r102 = new ObricActiveReason(SuggestActionType.SEND_MSG, 2);
        SEND_MSG = r102;
        ObricActiveReason r103 = new ObricActiveReason("GLOBAL_AUDIO_IN_PROGRESS", 3);
        GLOBAL_AUDIO_IN_PROGRESS = r103;
        ObricActiveReason r104 = new ObricActiveReason("MSG_TTS_IN_PROGRESS", 4);
        MSG_TTS_IN_PROGRESS = r104;
        ObricActiveReason r105 = new ObricActiveReason("INTENT_IN_PROGRESS", 5);
        INTENT_IN_PROGRESS = r105;
        ObricActiveReason r110 = new ObricActiveReason("COMPLEX_TASK_IN_PROGRESS", 6);
        COMPLEX_TASK_IN_PROGRESS = r110;
        ObricActiveReason r111 = new ObricActiveReason("REALTIME_CALL_IN_PROGRESS", 7);
        REALTIME_CALL_IN_PROGRESS = r111;
        ObricActiveReason r112 = new ObricActiveReason("AI_NOTE_IN_PROGRESS", 8);
        AI_NOTE_IN_PROGRESS = r112;
        ObricActiveReason r113 = new ObricActiveReason("CLICK_TALK_IN_PROGRESS", 9);
        CLICK_TALK_IN_PROGRESS = r113;
        ObricActiveReason r114 = new ObricActiveReason("ALARM_TTS_IN_PROGRESS", 10);
        ALARM_TTS_IN_PROGRESS = r114;
        ObricActiveReason r115 = new ObricActiveReason("DORA_WAKEUP", 11);
        DORA_WAKEUP = r115;
        ObricActiveReason r106 = new ObricActiveReason("MEMORY_DATA_IN_USE", 12);
        MEMORY_DATA_IN_USE = r106;
        ObricActiveReason r107 = new ObricActiveReason("OAUTO_FOREGROUND", 13);
        OAUTO_FOREGROUND = r107;
        ObricActiveReason r108 = new ObricActiveReason("RECORD_MINUTES_IN_PROGRESS", 14);
        RECORD_MINUTES_IN_PROGRESS = r108;
        ObricActiveReason r109 = new ObricActiveReason("APP_UPDATE", 15);
        APP_UPDATE = r109;
        ObricActiveReason r116 = new ObricActiveReason("PLUGIN_UPDATE", 16);
        PLUGIN_UPDATE = r116;
        ObricActiveReason r117 = new ObricActiveReason("ACTIVE_TEST", 17);
        ACTIVE_TEST = r117;
        ObricActiveReason r118 = new ObricActiveReason("UNKNOWN", 18);
        UNKNOWN = r118;
        ObricActiveReason[] r119 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118};
        f384393a = r119;
        f384394b = EnumEntriesKt.enumEntries(r119);
    }

    public static ObricActiveReason[] values() {
        return (ObricActiveReason[]) f384393a.clone();
    }

    public static ObricActiveReason valueOf(String r100) {
        return (ObricActiveReason) a.a(ObricActiveReason.class, r100);
    }

    public ObricActiveReason(String r100, int r101) {
        super(r100, r101);
    }
}
