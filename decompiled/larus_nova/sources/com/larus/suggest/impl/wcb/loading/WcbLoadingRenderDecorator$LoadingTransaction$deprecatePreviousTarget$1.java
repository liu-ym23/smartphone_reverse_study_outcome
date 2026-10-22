package com.larus.suggest.impl.wcb.loading;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.loading.WcbLoadingRenderDecorator$LoadingTransaction", f = "WcbLoadingRenderDecorator.kt", i = {}, l = {135}, m = "deprecatePreviousTarget", n = {}, s = {})
public final class WcbLoadingRenderDecorator$LoadingTransaction$deprecatePreviousTarget$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WcbLoadingRenderDecorator.LoadingTransaction this$0;

    public WcbLoadingRenderDecorator$LoadingTransaction$deprecatePreviousTarget$1(WcbLoadingRenderDecorator.LoadingTransaction r100, Continuation<? super WcbLoadingRenderDecorator$LoadingTransaction$deprecatePreviousTarget$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(this);
    }
}
