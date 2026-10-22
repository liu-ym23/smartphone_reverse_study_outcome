package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.chain.PreCheckInterceptor", f = "PreCheckInterceptor.kt", i = {0, 0}, l = {105}, m = "intercept", n = {"models", DyPayConstant.KEY_START_TIME}, s = {"L$0", "J$0"})
final class PreCheckInterceptor$intercept$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public PreCheckInterceptor$intercept$1(d r100, Continuation<? super PreCheckInterceptor$intercept$1> r101) {
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
