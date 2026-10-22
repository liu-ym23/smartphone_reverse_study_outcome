package com.larus.audio.audiov3.task.sami.v2.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.audio.audiov3.task.sami.v2.flow.FlowMockSamiCore", f = "FlowMockSamiCore.kt", i = {}, l = {188}, m = "scheduleMockEvent", n = {}, s = {})
final class FlowMockSamiCore$scheduleMockEvent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowMockSamiCore this$0;

    public FlowMockSamiCore$scheduleMockEvent$1(FlowMockSamiCore r100, Continuation<? super FlowMockSamiCore$scheduleMockEvent$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return FlowMockSamiCore.j(this.this$0, this);
    }
}
