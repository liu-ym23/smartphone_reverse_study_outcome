package com.bytedance.flow_audio.impl.business.asr;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow_audio.impl.business.asr.FlowAsrAudioUplinkController", f = "FlowAsrAudioUplinkController.kt", i = {0}, l = {153}, m = "drainFrames", n = {"queuedFrame"}, s = {"L$0"})
final class FlowAsrAudioUplinkController$drainFrames$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowAsrAudioUplinkController this$0;

    public FlowAsrAudioUplinkController$drainFrames$1(FlowAsrAudioUplinkController r100, Continuation<? super FlowAsrAudioUplinkController$drainFrames$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return FlowAsrAudioUplinkController.a(this.this$0, this);
    }
}
