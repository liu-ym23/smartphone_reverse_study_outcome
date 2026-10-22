package com.larus.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.network.FlowHttpConnection", f = "FlowHttpConnection.kt", i = {0, 0, 0, 0}, l = {251}, m = "safeCallReplaceBaseUrl", n = {"path", "metric", "needTrace", "sendStartTime"}, s = {"L$0", "L$1", "Z$0", "J$0"})
public final class FlowHttpConnection$safeCallReplaceBaseUrl$1<S, T> extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowHttpConnection this$0;

    public FlowHttpConnection$safeCallReplaceBaseUrl$1(FlowHttpConnection r100, Continuation<? super FlowHttpConnection$safeCallReplaceBaseUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(null, null, null, false, null, null, null, null, this);
    }
}
