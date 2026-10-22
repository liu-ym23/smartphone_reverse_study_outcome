package com.bytedance.lark.rustclient.api;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.lark.rustclient.api.RustFlowExtensionsKt", f = "RustFlowExtensions.kt", i = {0}, l = {86}, m = "collectDataOrTypedError", n = {"onOtherError"}, s = {"L$0"})
final class RustFlowExtensionsKt$collectDataOrTypedError$1<RAW, DATA> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public RustFlowExtensionsKt$collectDataOrTypedError$1(Continuation<? super RustFlowExtensionsKt$collectDataOrTypedError$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        RustFlowExtensionsKt$collectDataOrTypedError$1<RAW, DATA> r102 = this;
    L6:
        Object r103 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        Function1 r105 = (Function1) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L12
    L23:
        return Unit.INSTANCE;
    L12:
        Object th10 = th;
    L21:
        r105.invoke(th10);
        goto L23
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        r102.L$0 = null;     // Catch: Throwable -> L19
        r102.label = 1;     // Catch: Throwable -> L19
        throw null;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th10 = th;
        r105 = null;
        goto L21
    L5:
        r102 = new RustFlowExtensionsKt$collectDataOrTypedError$1(this);
        goto L6
    }
}
