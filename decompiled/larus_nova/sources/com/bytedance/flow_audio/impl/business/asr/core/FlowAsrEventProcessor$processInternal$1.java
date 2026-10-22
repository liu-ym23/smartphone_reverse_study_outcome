package com.bytedance.flow_audio.impl.business.asr.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow_audio.impl.business.asr.core.FlowAsrEventProcessor", f = "FlowAsrEventProcessor.kt", i = {0, 0, 1, 1, 1}, l = {122, 124, 128, 132}, m = "processInternal", n = {"event", "shouldLog", "event", "decision", "shouldLog"}, s = {"L$0", "Z$0", "L$0", "L$1", "Z$0"})
public final class FlowAsrEventProcessor$processInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowAsrEventProcessor this$0;

    public FlowAsrEventProcessor$processInternal$1(FlowAsrEventProcessor r100, Continuation<? super FlowAsrEventProcessor$processInternal$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        FlowAsrEventProcessor r101 = this.this$0;
        String r102 = FlowAsrEventProcessor.f243814f;
        return r101.b(null, this);
    }
}
