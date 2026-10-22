package com.ss.office.sdk.kmp.dpop;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.office.sdk.kmp.dpop.OfficeSDKDPoPCapacityAdapter", f = "OfficeSDKDPoPBridge.kt", i = {}, l = {22}, m = "getDPoPToken-0E7RQCE", n = {}, s = {})
final class OfficeSDKDPoPCapacityAdapter$getDPoPToken$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public OfficeSDKDPoPCapacityAdapter$getDPoPToken$1(a r100, Continuation<? super OfficeSDKDPoPCapacityAdapter$getDPoPToken$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        a r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        OfficeSDKDPoPCapacityAdapter$getDPoPToken$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L13;
        if (r105 != 1) goto L12;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L16
        Object r106 = Result.m9449constructorimpl((String) r104);     // Catch: Throwable -> L16
    L19:
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        return r106;
    L22:
        return Result.m9448boximpl(r106);
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r104);
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L16
        r103.label = 1;     // Catch: Throwable -> L16
        throw null;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L5:
        r103 = new OfficeSDKDPoPCapacityAdapter$getDPoPToken$1(r101, this);
        goto L6
    }
}
