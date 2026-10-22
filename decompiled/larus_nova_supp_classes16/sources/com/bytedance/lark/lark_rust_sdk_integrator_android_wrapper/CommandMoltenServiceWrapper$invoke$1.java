package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper.CommandMoltenServiceWrapper", f = "CommandMoltenServiceWrapper.kt", i = {}, l = {31}, m = "invoke-gIAlu-s", n = {}, s = {})
final class CommandMoltenServiceWrapper$invoke$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public CommandMoltenServiceWrapper$invoke$1(b r1, Continuation<? super CommandMoltenServiceWrapper$invoke$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r6) {
        this.result = r6;
        this.label |= ShareItemModel.SRC_TINT_UNDEFINED;
        b r7 = this.this$0;
        r7.getClass();
        int r1 = this.label;
        if ((r1 & ShareItemModel.SRC_TINT_UNDEFINED) == 0) goto L5;
        this.label = r1 - ShareItemModel.SRC_TINT_UNDEFINED;
        CommandMoltenServiceWrapper$invoke$1<T> r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L12;
        if (r4 != 1) goto L11;
        ResultKt.throwOnFailure(r2);
        Object r8 = ((Result) r2).unbox-impl();
    L15:
        r3 = r8;
    L17:
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        return r3;
    L20:
        return Result.box-impl(r3);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r2);
        CommandMoltenServiceWrapper$invoke$2 r5 = new CommandMoltenServiceWrapper$invoke$2(null);
        r0.label = 1;
        r8 = r7.c(r5, r0);
        if (r8 != r3) goto L15;
    L5:
        r0 = new CommandMoltenServiceWrapper$invoke$1(r7, this);
        goto L6
    }
}
