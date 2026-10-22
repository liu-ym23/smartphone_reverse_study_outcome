package com.bytedance.flow_audio.impl.business.asr;

import com.bytedance.retrofit2.RetrofitMetrics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow_audio.impl.business.asr.FlowAsrFileReplayController", f = "FlowAsrFileReplayController.kt", i = {0, 0, 0, 0, 0, 0}, l = {150}, m = "sendFileAudioData", n = {"stream", "frameSender", "id", "sentFrameCount", RetrofitMetrics.ExtraKeys.SENT_BYTE_COUNT, "dataSize"}, s = {"L$0", "L$1", "L$2", "J$0", "J$1", "I$0"})
public final class FlowAsrFileReplayController$sendFileAudioData$2 extends ContinuationImpl {
    int I$0;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowAsrFileReplayController this$0;

    public FlowAsrFileReplayController$sendFileAudioData$2(FlowAsrFileReplayController r100, Continuation<? super FlowAsrFileReplayController$sendFileAudioData$2> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        FlowAsrFileReplayController r101 = this.this$0;
        String r102 = FlowAsrFileReplayController.f243781c;
        return r101.b(null, this);
    }
}
