package com.ss.android.lark.inline.ai.logic.push;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter", f = "SmoothOutputFilter.kt", i = {0, 0, 1, 1, 1, 2}, l = {145, 181, 187}, m = "proceedResult", n = {"pushPrintParam", "$this$proceedResult_u24lambda_u244_u24lambda_u243", "pushPrintParam", "$this$proceedResult_u24lambda_u244_u24lambda_u243", "taskPrintParam", "pushPrintParam"}, s = {"L$0", "L$2", "L$0", "L$2", "L$3", "L$0"})
public final class SmoothOutputFilter$proceedResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SmoothOutputFilter this$0;

    public SmoothOutputFilter$proceedResult$1(SmoothOutputFilter r100, Continuation<? super SmoothOutputFilter$proceedResult$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        SmoothOutputFilter r101 = this.this$0;
        int r102 = SmoothOutputFilter.f427316f;
        return r101.d(null, this);
    }
}
