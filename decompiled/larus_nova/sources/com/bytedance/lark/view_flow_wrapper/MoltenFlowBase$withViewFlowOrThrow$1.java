package com.bytedance.lark.view_flow_wrapper;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.lark.view_flow_wrapper.MoltenFlowBase", f = "MoltenFlowBase.kt", i = {}, l = {223}, m = "withViewFlowOrThrow", n = {}, s = {})
final class MoltenFlowBase$withViewFlowOrThrow$1<R> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MoltenFlowBase<AutoCloseable> this$0;

    public MoltenFlowBase$withViewFlowOrThrow$1(MoltenFlowBase<AutoCloseable> r100, Continuation<? super MoltenFlowBase$withViewFlowOrThrow$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MoltenFlowBase<AutoCloseable> r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        MoltenFlowBase$withViewFlowOrThrow$1<R> r103 = this;
    L6:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L12;
        if (r106 != 1) goto L11;
        ResultKt.throwOnFailure(r104);
        Object r107 = ((Result) r104).m9458unboximpl();
    L15:
        Object r108 = r107;
        ResultKt.throwOnFailure(r108);
        return r108;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r104);
        r103.label = 1;
        r107 = r101.f(null, r103);
        if (r107 != r105) goto L15;
        return r105;
    L5:
        r103 = new MoltenFlowBase$withViewFlowOrThrow$1(r101, this);
        goto L6
    }
}
