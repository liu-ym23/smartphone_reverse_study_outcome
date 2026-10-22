package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper.CommandMoltenServiceWrapper", f = "CommandMoltenServiceWrapper.kt", i = {}, l = {31}, m = "invoke-gIAlu-s", n = {}, s = {})
final class CommandMoltenServiceWrapper$invoke$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public CommandMoltenServiceWrapper$invoke$1(b r100, Continuation<? super CommandMoltenServiceWrapper$invoke$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        b r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        CommandMoltenServiceWrapper$invoke$1<T> r103 = this;
    L6:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L12;
        if (r106 != 1) goto L11;
        ResultKt.throwOnFailure(r104);
        Object r107 = ((Result) r104).m9458unboximpl();
    L15:
        r105 = r107;
    L17:
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        return r105;
    L20:
        return Result.m9448boximpl(r105);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r104);
        CommandMoltenServiceWrapper$invoke$2 r108 = new CommandMoltenServiceWrapper$invoke$2(null);
        r103.label = 1;
        r107 = r101.c(r108, r103);
        if (r107 != r105) goto L15;
    L5:
        r103 = new CommandMoltenServiceWrapper$invoke$1(r101, this);
        goto L6
    }
}
