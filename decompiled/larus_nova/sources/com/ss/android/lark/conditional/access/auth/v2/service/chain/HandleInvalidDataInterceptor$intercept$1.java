package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.chain.HandleInvalidDataInterceptor", f = "HandleInvalidDataInterceptor.kt", i = {0}, l = {172}, m = "intercept", n = {"models"}, s = {"L$0"})
final class HandleInvalidDataInterceptor$intercept$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HandleInvalidDataInterceptor this$0;

    public HandleInvalidDataInterceptor$intercept$1(HandleInvalidDataInterceptor r100, Continuation<? super HandleInvalidDataInterceptor$intercept$1> r101) {
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
