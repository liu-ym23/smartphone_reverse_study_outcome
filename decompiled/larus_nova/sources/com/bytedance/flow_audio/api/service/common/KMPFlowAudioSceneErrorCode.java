package com.bytedance.flow_audio.api.service.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/flow_audio/api/service/common/KMPFlowAudioSceneErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "OCCUPIED_BY_OTHER", "SCENE_NOT_FOUND", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KMPFlowAudioSceneErrorCode extends Enum<KMPFlowAudioSceneErrorCode> {
    public static final KMPFlowAudioSceneErrorCode OCCUPIED_BY_OTHER = null;
    public static final KMPFlowAudioSceneErrorCode SCENE_NOT_FOUND = null;
    public static final KMPFlowAudioSceneErrorCode UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KMPFlowAudioSceneErrorCode[] f243734a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243735b = null;

    public static EnumEntries<KMPFlowAudioSceneErrorCode> getEntries() {
        return f243735b;
    }

    static {
        KMPFlowAudioSceneErrorCode r100 = new KMPFlowAudioSceneErrorCode("UNKNOWN", 0);
        UNKNOWN = r100;
        KMPFlowAudioSceneErrorCode r101 = new KMPFlowAudioSceneErrorCode("OCCUPIED_BY_OTHER", 1);
        OCCUPIED_BY_OTHER = r101;
        KMPFlowAudioSceneErrorCode r102 = new KMPFlowAudioSceneErrorCode("SCENE_NOT_FOUND", 2);
        SCENE_NOT_FOUND = r102;
        KMPFlowAudioSceneErrorCode[] r103 = {r100, r101, r102};
        f243734a = r103;
        f243735b = EnumEntriesKt.enumEntries(r103);
    }

    public static KMPFlowAudioSceneErrorCode[] values() {
        return (KMPFlowAudioSceneErrorCode[]) f243734a.clone();
    }

    public static KMPFlowAudioSceneErrorCode valueOf(String r100) {
        return (KMPFlowAudioSceneErrorCode) a.a(KMPFlowAudioSceneErrorCode.class, r100);
    }

    public KMPFlowAudioSceneErrorCode(String r100, int r101) {
        super(r100, r101);
    }
}
