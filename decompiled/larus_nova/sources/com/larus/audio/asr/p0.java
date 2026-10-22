package com.larus.audio.asr;

import com.bytedance.flow_audio.api.service.common.KMPFlowAudioSceneBroadcastEventType;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f288448a = null;

    static {
        int[] r100 = new int[KMPFlowAudioSceneBroadcastEventType.values().length];
        r100[KMPFlowAudioSceneBroadcastEventType.ASR_WAIT_REPLY_BEGIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r100[KMPFlowAudioSceneBroadcastEventType.ASR_WAIT_REPLY_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        f288448a = r100;
    }
}
