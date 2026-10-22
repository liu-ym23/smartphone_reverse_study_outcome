package com.bytedance.flow_audio.api.service.common;

import com.larus.media.MediaScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/flow_audio/api/service/common/KMPFlowAudioSceneInterruptReasonType;", "", "<init>", "(Ljava/lang/String;I)V", MediaScene.SYSTEM, "OTHER_SCENE_ACTIVATED", "FORCE", "UNKNOWN", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KMPFlowAudioSceneInterruptReasonType extends Enum<KMPFlowAudioSceneInterruptReasonType> {
    public static final KMPFlowAudioSceneInterruptReasonType FORCE = null;
    public static final KMPFlowAudioSceneInterruptReasonType OTHER_SCENE_ACTIVATED = null;
    public static final KMPFlowAudioSceneInterruptReasonType SYSTEM = null;
    public static final KMPFlowAudioSceneInterruptReasonType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KMPFlowAudioSceneInterruptReasonType[] f243736a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243737b = null;

    public static EnumEntries<KMPFlowAudioSceneInterruptReasonType> getEntries() {
        return f243737b;
    }

    static {
        KMPFlowAudioSceneInterruptReasonType r100 = new KMPFlowAudioSceneInterruptReasonType(MediaScene.SYSTEM, 0);
        SYSTEM = r100;
        KMPFlowAudioSceneInterruptReasonType r101 = new KMPFlowAudioSceneInterruptReasonType("OTHER_SCENE_ACTIVATED", 1);
        OTHER_SCENE_ACTIVATED = r101;
        KMPFlowAudioSceneInterruptReasonType r102 = new KMPFlowAudioSceneInterruptReasonType("FORCE", 2);
        FORCE = r102;
        KMPFlowAudioSceneInterruptReasonType r103 = new KMPFlowAudioSceneInterruptReasonType("UNKNOWN", 3);
        UNKNOWN = r103;
        KMPFlowAudioSceneInterruptReasonType[] r104 = {r100, r101, r102, r103};
        f243736a = r104;
        f243737b = EnumEntriesKt.enumEntries(r104);
    }

    public static KMPFlowAudioSceneInterruptReasonType[] values() {
        return (KMPFlowAudioSceneInterruptReasonType[]) f243736a.clone();
    }

    public static KMPFlowAudioSceneInterruptReasonType valueOf(String r100) {
        return (KMPFlowAudioSceneInterruptReasonType) a.a(KMPFlowAudioSceneInterruptReasonType.class, r100);
    }

    public KMPFlowAudioSceneInterruptReasonType(String r100, int r101) {
        super(r100, r101);
    }
}
