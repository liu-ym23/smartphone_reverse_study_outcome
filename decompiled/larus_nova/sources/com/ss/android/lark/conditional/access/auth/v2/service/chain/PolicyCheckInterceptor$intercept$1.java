package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.chain.PolicyCheckInterceptor", f = "PolicyCheckInterceptor.kt", i = {0, 0}, l = {32}, m = "intercept", n = {"models", "preTraceId$iv$iv"}, s = {"L$0", "L$1"})
final class PolicyCheckInterceptor$intercept$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    public PolicyCheckInterceptor$intercept$1(c r100, Continuation<? super PolicyCheckInterceptor$intercept$1> r101) {
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
