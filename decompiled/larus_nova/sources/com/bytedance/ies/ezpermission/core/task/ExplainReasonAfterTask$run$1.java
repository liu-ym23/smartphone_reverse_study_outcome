package com.bytedance.ies.ezpermission.core.task;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0096@"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "continuation", "", "run"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.ies.ezpermission.core.task.ExplainReasonAfterTask", f = "ExplainReasonAfterTask.kt", i = {1, 1, 1, 2}, l = {15, 27, 32, 37, 42}, m = "run", n = {"this", "listener", "$this$apply", "this"}, s = {"L$0", "L$2", "L$4", "L$0"})
public final class ExplainReasonAfterTask$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExplainReasonAfterTask this$0;

    public ExplainReasonAfterTask$run$1(ExplainReasonAfterTask r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
