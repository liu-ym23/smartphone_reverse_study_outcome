package com.bytedance.flow_audio.api.service.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/flow_audio/api/service/common/KMPFlowAudioSceneASRReplyEndReason;", "", "<init>", "(Ljava/lang/String;I)V", "CANCEL", "FAIL", "MESSAGE_RECEIVED", "FINISH_PLAY", "FINISH_RECORD", "NO_AUDIO_DATA", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KMPFlowAudioSceneASRReplyEndReason extends Enum<KMPFlowAudioSceneASRReplyEndReason> {
    public static final KMPFlowAudioSceneASRReplyEndReason CANCEL = null;
    public static final KMPFlowAudioSceneASRReplyEndReason FAIL = null;
    public static final KMPFlowAudioSceneASRReplyEndReason FINISH_PLAY = null;
    public static final KMPFlowAudioSceneASRReplyEndReason FINISH_RECORD = null;
    public static final KMPFlowAudioSceneASRReplyEndReason MESSAGE_RECEIVED = null;
    public static final KMPFlowAudioSceneASRReplyEndReason NO_AUDIO_DATA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KMPFlowAudioSceneASRReplyEndReason[] f243730a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243731b = null;

    public static EnumEntries<KMPFlowAudioSceneASRReplyEndReason> getEntries() {
        return f243731b;
    }

    static {
        KMPFlowAudioSceneASRReplyEndReason r100 = new KMPFlowAudioSceneASRReplyEndReason("CANCEL", 0);
        CANCEL = r100;
        KMPFlowAudioSceneASRReplyEndReason r101 = new KMPFlowAudioSceneASRReplyEndReason("FAIL", 1);
        FAIL = r101;
        KMPFlowAudioSceneASRReplyEndReason r102 = new KMPFlowAudioSceneASRReplyEndReason("MESSAGE_RECEIVED", 2);
        MESSAGE_RECEIVED = r102;
        KMPFlowAudioSceneASRReplyEndReason r103 = new KMPFlowAudioSceneASRReplyEndReason("FINISH_PLAY", 3);
        FINISH_PLAY = r103;
        KMPFlowAudioSceneASRReplyEndReason r104 = new KMPFlowAudioSceneASRReplyEndReason("FINISH_RECORD", 4);
        FINISH_RECORD = r104;
        KMPFlowAudioSceneASRReplyEndReason r105 = new KMPFlowAudioSceneASRReplyEndReason("NO_AUDIO_DATA", 5);
        NO_AUDIO_DATA = r105;
        KMPFlowAudioSceneASRReplyEndReason[] r110 = {r100, r101, r102, r103, r104, r105};
        f243730a = r110;
        f243731b = EnumEntriesKt.enumEntries(r110);
    }

    public static KMPFlowAudioSceneASRReplyEndReason[] values() {
        return (KMPFlowAudioSceneASRReplyEndReason[]) f243730a.clone();
    }

    public static KMPFlowAudioSceneASRReplyEndReason valueOf(String r100) {
        return (KMPFlowAudioSceneASRReplyEndReason) a.a(KMPFlowAudioSceneASRReplyEndReason.class, r100);
    }

    public KMPFlowAudioSceneASRReplyEndReason(String r100, int r101) {
        super(r100, r101);
    }
}
