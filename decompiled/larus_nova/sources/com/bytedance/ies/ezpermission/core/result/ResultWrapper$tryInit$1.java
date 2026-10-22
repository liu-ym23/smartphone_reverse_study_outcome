package com.bytedance.ies.ezpermission.core.result;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0082@"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "continuation", "", "tryInit"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.ies.ezpermission.core.result.ResultWrapper", f = "ResultWrapper.kt", i = {}, l = {40, 42, 45}, m = "tryInit", n = {}, s = {})
public final class ResultWrapper$tryInit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResultWrapper this$0;

    public ResultWrapper$tryInit$1(ResultWrapper r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
