package com.ss.android.lark.passport.flow.mfa;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.mfa.FlowMfaRepository", f = "FlowMfaRepository.kt", i = {}, l = {155}, m = "dispatchBidp", n = {}, s = {})
public final class FlowMfaRepository$dispatchBidp$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowMfaRepository this$0;

    public FlowMfaRepository$dispatchBidp$1(FlowMfaRepository r100, Continuation<? super FlowMfaRepository$dispatchBidp$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, null, this);
    }
}
