package com.obric.assistant.state.api.v2.core;

import com.larus.bmhome.chat.bean.SuggestActionType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/state/api/v2/core/AssistantAliveReason;", "", "<init>", "(Ljava/lang/String;I)V", SuggestActionType.SEND_MSG, "RECEIVE_MSG", "INTENT_IN_PROGRESS", "COMPLEX_TASK_IN_PROGRESS", "REALTIME_CALL_IN_PROGRESS", "MSG_TTS_IN_PROGRESS", "AI_NOTE_IN_PROGRESS", "GLOBAL_AUDIO_IN_PROGRESS", "CLICK_TALK_IN_PROGRESS", "WAKEUP_IN_PROGRESS", "ALARM_TTS_IN_PROGRESS", "AIGC_GENERATION_IN_PROGRESS", "SELF_UPDATE_DOWNLOAD", "FORCE_EXIT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AssistantAliveReason extends Enum<AssistantAliveReason> {
    public static final AssistantAliveReason AIGC_GENERATION_IN_PROGRESS = null;
    public static final AssistantAliveReason AI_NOTE_IN_PROGRESS = null;
    public static final AssistantAliveReason ALARM_TTS_IN_PROGRESS = null;
    public static final AssistantAliveReason CLICK_TALK_IN_PROGRESS = null;
    public static final AssistantAliveReason COMPLEX_TASK_IN_PROGRESS = null;
    public static final AssistantAliveReason FORCE_EXIT = null;
    public static final AssistantAliveReason GLOBAL_AUDIO_IN_PROGRESS = null;
    public static final AssistantAliveReason INTENT_IN_PROGRESS = null;
    public static final AssistantAliveReason MSG_TTS_IN_PROGRESS = null;
    public static final AssistantAliveReason REALTIME_CALL_IN_PROGRESS = null;
    public static final AssistantAliveReason RECEIVE_MSG = null;
    public static final AssistantAliveReason SELF_UPDATE_DOWNLOAD = null;
    public static final AssistantAliveReason SEND_MSG = null;
    public static final AssistantAliveReason WAKEUP_IN_PROGRESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AssistantAliveReason[] f392963a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f392964b = null;

    public static EnumEntries<AssistantAliveReason> getEntries() {
        return f392964b;
    }

    static {
        AssistantAliveReason r100 = new AssistantAliveReason(SuggestActionType.SEND_MSG, 0);
        SEND_MSG = r100;
        AssistantAliveReason r101 = new AssistantAliveReason("RECEIVE_MSG", 1);
        RECEIVE_MSG = r101;
        AssistantAliveReason r102 = new AssistantAliveReason("INTENT_IN_PROGRESS", 2);
        INTENT_IN_PROGRESS = r102;
        AssistantAliveReason r103 = new AssistantAliveReason("COMPLEX_TASK_IN_PROGRESS", 3);
        COMPLEX_TASK_IN_PROGRESS = r103;
        AssistantAliveReason r104 = new AssistantAliveReason("REALTIME_CALL_IN_PROGRESS", 4);
        REALTIME_CALL_IN_PROGRESS = r104;
        AssistantAliveReason r105 = new AssistantAliveReason("MSG_TTS_IN_PROGRESS", 5);
        MSG_TTS_IN_PROGRESS = r105;
        AssistantAliveReason r110 = new AssistantAliveReason("AI_NOTE_IN_PROGRESS", 6);
        AI_NOTE_IN_PROGRESS = r110;
        AssistantAliveReason r111 = new AssistantAliveReason("GLOBAL_AUDIO_IN_PROGRESS", 7);
        GLOBAL_AUDIO_IN_PROGRESS = r111;
        AssistantAliveReason r112 = new AssistantAliveReason("CLICK_TALK_IN_PROGRESS", 8);
        CLICK_TALK_IN_PROGRESS = r112;
        AssistantAliveReason r113 = new AssistantAliveReason("WAKEUP_IN_PROGRESS", 9);
        WAKEUP_IN_PROGRESS = r113;
        AssistantAliveReason r114 = new AssistantAliveReason("ALARM_TTS_IN_PROGRESS", 10);
        ALARM_TTS_IN_PROGRESS = r114;
        AssistantAliveReason r115 = new AssistantAliveReason("AIGC_GENERATION_IN_PROGRESS", 11);
        AIGC_GENERATION_IN_PROGRESS = r115;
        AssistantAliveReason r106 = new AssistantAliveReason("SELF_UPDATE_DOWNLOAD", 12);
        SELF_UPDATE_DOWNLOAD = r106;
        AssistantAliveReason r107 = new AssistantAliveReason("FORCE_EXIT", 13);
        FORCE_EXIT = r107;
        AssistantAliveReason[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107};
        f392963a = r108;
        f392964b = EnumEntriesKt.enumEntries(r108);
    }

    public static AssistantAliveReason[] values() {
        return (AssistantAliveReason[]) f392963a.clone();
    }

    public static AssistantAliveReason valueOf(String r100) {
        return (AssistantAliveReason) a.a(AssistantAliveReason.class, r100);
    }

    public AssistantAliveReason(String r100, int r101) {
        super(r100, r101);
    }
}
