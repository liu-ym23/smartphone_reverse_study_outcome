package com.bytedance.flow_audio.impl.business.asr;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow_audio.impl.business.asr.FlowAsrRetryAttemptController", f = "FlowAsrRetryAttemptController.kt", i = {}, l = {78}, m = "runAttempt", n = {}, s = {})
public final class FlowAsrRetryAttemptController$runAttempt$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowAsrRetryAttemptController this$0;

    public FlowAsrRetryAttemptController$runAttempt$1(FlowAsrRetryAttemptController r100, Continuation<? super FlowAsrRetryAttemptController$runAttempt$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, this);
    }
}
