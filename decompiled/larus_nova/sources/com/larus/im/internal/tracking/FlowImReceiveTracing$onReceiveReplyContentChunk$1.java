package com.larus.im.internal.tracking;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.tracking.FlowImReceiveTracing", f = "FlowImReceiveTracing.kt", i = {0, 0}, l = {234}, m = "onReceiveReplyContentChunk", n = {"msg", "firstChunkJson"}, s = {"L$0", "L$1"})
public final class FlowImReceiveTracing$onReceiveReplyContentChunk$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowImReceiveTracing this$0;

    public FlowImReceiveTracing$onReceiveReplyContentChunk$1(FlowImReceiveTracing r100, Continuation<? super FlowImReceiveTracing$onReceiveReplyContentChunk$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, this);
    }
}
