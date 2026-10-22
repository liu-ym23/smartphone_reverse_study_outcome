package com.bytedance.kmp.network.p009public;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.public.BizInterceptorManager", f = "BizInterceptorManager.kt", i = {0, 0, 0}, l = {62}, m = "intercept", n = {"queryMap", "headerMap", "reqContext"}, s = {"L$0", "L$1", "L$2"})
public final class BizInterceptorManager$intercept$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BizInterceptorManager this$0;

    public BizInterceptorManager$intercept$1(BizInterceptorManager r100, Continuation<? super BizInterceptorManager$intercept$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
