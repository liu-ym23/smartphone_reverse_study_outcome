package com.bytedance.flow_audio.api.service.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/flow_audio/api/service/common/KMPFlowAudioSceneBroadcastEventType;", "", "<init>", "(Ljava/lang/String;I)V", "ASR_WAIT_REPLY_BEGIN", "ASR_WAIT_REPLY_END", "ENTER_SCENE", "LEAVE_SCENE", "CLEAR_CHAT_HISTORY", "RECEIVE_MESSAGE", "DORA_TTS_ARRIVE", "PLAYBACK_FINISH", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KMPFlowAudioSceneBroadcastEventType extends Enum<KMPFlowAudioSceneBroadcastEventType> {
    public static final KMPFlowAudioSceneBroadcastEventType ASR_WAIT_REPLY_BEGIN = null;
    public static final KMPFlowAudioSceneBroadcastEventType ASR_WAIT_REPLY_END = null;
    public static final KMPFlowAudioSceneBroadcastEventType CLEAR_CHAT_HISTORY = null;
    public static final KMPFlowAudioSceneBroadcastEventType DORA_TTS_ARRIVE = null;
    public static final KMPFlowAudioSceneBroadcastEventType ENTER_SCENE = null;
    public static final KMPFlowAudioSceneBroadcastEventType LEAVE_SCENE = null;
    public static final KMPFlowAudioSceneBroadcastEventType PLAYBACK_FINISH = null;
    public static final KMPFlowAudioSceneBroadcastEventType RECEIVE_MESSAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KMPFlowAudioSceneBroadcastEventType[] f243732a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243733b = null;

    public static EnumEntries<KMPFlowAudioSceneBroadcastEventType> getEntries() {
        return f243733b;
    }

    static {
        KMPFlowAudioSceneBroadcastEventType r100 = new KMPFlowAudioSceneBroadcastEventType("ASR_WAIT_REPLY_BEGIN", 0);
        ASR_WAIT_REPLY_BEGIN = r100;
        KMPFlowAudioSceneBroadcastEventType r101 = new KMPFlowAudioSceneBroadcastEventType("ASR_WAIT_REPLY_END", 1);
        ASR_WAIT_REPLY_END = r101;
        KMPFlowAudioSceneBroadcastEventType r102 = new KMPFlowAudioSceneBroadcastEventType("ENTER_SCENE", 2);
        ENTER_SCENE = r102;
        KMPFlowAudioSceneBroadcastEventType r103 = new KMPFlowAudioSceneBroadcastEventType("LEAVE_SCENE", 3);
        LEAVE_SCENE = r103;
        KMPFlowAudioSceneBroadcastEventType r104 = new KMPFlowAudioSceneBroadcastEventType("CLEAR_CHAT_HISTORY", 4);
        CLEAR_CHAT_HISTORY = r104;
        KMPFlowAudioSceneBroadcastEventType r105 = new KMPFlowAudioSceneBroadcastEventType("RECEIVE_MESSAGE", 5);
        RECEIVE_MESSAGE = r105;
        KMPFlowAudioSceneBroadcastEventType r110 = new KMPFlowAudioSceneBroadcastEventType("DORA_TTS_ARRIVE", 6);
        DORA_TTS_ARRIVE = r110;
        KMPFlowAudioSceneBroadcastEventType r111 = new KMPFlowAudioSceneBroadcastEventType("PLAYBACK_FINISH", 7);
        PLAYBACK_FINISH = r111;
        KMPFlowAudioSceneBroadcastEventType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f243732a = r112;
        f243733b = EnumEntriesKt.enumEntries(r112);
    }

    public static KMPFlowAudioSceneBroadcastEventType[] values() {
        return (KMPFlowAudioSceneBroadcastEventType[]) f243732a.clone();
    }

    public static KMPFlowAudioSceneBroadcastEventType valueOf(String r100) {
        return (KMPFlowAudioSceneBroadcastEventType) a.a(KMPFlowAudioSceneBroadcastEventType.class, r100);
    }

    public KMPFlowAudioSceneBroadcastEventType(String r100, int r101) {
        super(r100, r101);
    }
}
