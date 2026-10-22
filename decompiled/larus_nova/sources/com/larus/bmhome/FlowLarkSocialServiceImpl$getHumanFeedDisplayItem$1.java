package com.larus.bmhome;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.FlowLarkSocialServiceImpl", f = "FlowLarkSocialServiceImpl.kt", i = {}, l = {24}, m = "getHumanFeedDisplayItem", n = {}, s = {})
public final class FlowLarkSocialServiceImpl$getHumanFeedDisplayItem$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowLarkSocialServiceImpl this$0;

    public FlowLarkSocialServiceImpl$getHumanFeedDisplayItem$1(FlowLarkSocialServiceImpl r100, Continuation<? super FlowLarkSocialServiceImpl$getHumanFeedDisplayItem$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
