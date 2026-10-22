package com.ss.android.lark.passport.flow.mfa;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.mfa.FlowMfaRepository", f = "FlowMfaRepository.kt", i = {}, l = {102}, m = "verifyOtp", n = {}, s = {})
final class FlowMfaRepository$verifyOtp$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowMfaRepository this$0;

    public FlowMfaRepository$verifyOtp$1(FlowMfaRepository r100, Continuation<? super FlowMfaRepository$verifyOtp$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        FlowMfaRepository r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        FlowMfaRepository$verifyOtp$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 != 0) goto L9;
        ResultKt.throwOnFailure(r104);
        throw null;
    L9:
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        com.ss.android.lark.passport.flow.core.network.f r106 = (com.ss.android.lark.passport.flow.core.network.f) r104;
        r106.c();
        return r101.j(r106);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r103 = new FlowMfaRepository$verifyOtp$1(r101, this);
        goto L6
    }
}
