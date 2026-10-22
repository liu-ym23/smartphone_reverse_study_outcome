package com.bytedance.flow_audio.impl.business.asr;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class FlowAsrFileReplayController$sendFileAudioData$frameSender$1 extends FunctionReferenceImpl implements Function1<rw5.d, Integer> {
    public FlowAsrFileReplayController$sendFileAudioData$frameSender$1(Object r100) {
        super(1, r100, r.class, "sendAudio", "sendAudio(Lcom/bytedance/flow_audio/api/foundation/player/FlowAudioData;)I", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Integer invoke2(rw5.d r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return Integer.valueOf(((r) this.receiver).d(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(rw5.d r100) {
        return invoke2(r100);
    }
}
