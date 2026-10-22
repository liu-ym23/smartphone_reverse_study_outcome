package com.bytedance.lark.view_flow_wrapper.util;

import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.lark.view_flow_wrapper.util.SideEffectFlowImpl", f = "ConsumeAsSideEffect.kt", i = {}, l = {49}, m = ShareChannel.COLLECT, n = {}, s = {})
final class SideEffectFlowImpl$collect$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a<Object> this$0;

    public SideEffectFlowImpl$collect$1(a<Object> r100, Continuation<? super SideEffectFlowImpl$collect$1> r101) {
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
