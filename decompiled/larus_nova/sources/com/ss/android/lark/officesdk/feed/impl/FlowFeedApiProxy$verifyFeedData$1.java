package com.ss.android.lark.officesdk.feed.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.feed.impl.FlowFeedApiProxy", f = "FlowFeedApiProxy.kt", i = {}, l = {40}, m = "verifyFeedData", n = {}, s = {})
public final class FlowFeedApiProxy$verifyFeedData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowFeedApiProxy this$0;

    public FlowFeedApiProxy$verifyFeedData$1(FlowFeedApiProxy r100, Continuation<? super FlowFeedApiProxy$verifyFeedData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.z1(null, this);
    }
}
