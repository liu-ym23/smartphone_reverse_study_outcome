package com.bytedance.flow_audio.impl.business.tts;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow_audio.impl.business.tts.FlowTtsSession", f = "FlowTtsSession.kt", i = {0}, l = {310, 314}, m = "ttsStart", n = {"waitGroup"}, s = {"L$0"})
final class FlowTtsSession$ttsStart$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowTtsSession this$0;

    public FlowTtsSession$ttsStart$1(FlowTtsSession r100, Continuation<? super FlowTtsSession$ttsStart$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return FlowTtsSession.m3(this.this$0, null, this);
    }
}
