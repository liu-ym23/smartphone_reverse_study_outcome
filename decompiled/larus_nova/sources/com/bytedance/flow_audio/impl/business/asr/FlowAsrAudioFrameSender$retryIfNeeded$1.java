package com.bytedance.flow_audio.impl.business.asr;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow_audio.impl.business.asr.FlowAsrAudioFrameSender", f = "FlowAsrAudioFrameSender.kt", i = {0, 0}, l = {50}, m = "retryIfNeeded", n = {"frame", "retryIndex"}, s = {"L$0", "I$0"})
public final class FlowAsrAudioFrameSender$retryIfNeeded$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowAsrAudioFrameSender this$0;

    public FlowAsrAudioFrameSender$retryIfNeeded$1(FlowAsrAudioFrameSender r100, Continuation<? super FlowAsrAudioFrameSender$retryIfNeeded$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, 0, this);
    }
}
