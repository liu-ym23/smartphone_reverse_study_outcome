package com.larus.common.account.platform.larklogin;

import com.larus.common.account.platform.larkauth.AuthorizationFactory;
import com.larus.utils.t0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.platform.larklogin.LarkLogin$authorize$startResult$1$1$onSuccess$1", f = "LarkLogin.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
final class LarkLogin$authorize$startResult$1$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $osType;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ String $terminalType;
    private /* synthetic */ Object L$0;
    int label;

    public LarkLogin$authorize$startResult$1$1$onSuccess$1(String r100, String r101, String r102, Continuation<? super LarkLogin$authorize$startResult$1$1$onSuccess$1> r103) {
        this.$osType = r100;
        this.$terminalType = r101;
        this.$sessionId = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        LarkLogin$authorize$startResult$1$1$onSuccess$1 r102 = new LarkLogin$authorize$startResult$1$1$onSuccess$1(this.$osType, this.$terminalType, this.$sessionId, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((LarkLogin$authorize$startResult$1$1$onSuccess$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
    L13:
        Object r103 = Result.m9449constructorimpl((a09.a) r100);     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r103) == false) goto L20;
        r103 = null;
    L20:
        final a09.a r104 = (a09.a) r103;
        final String r105 = this.$sessionId;
        t0.c(new h(r104, r105));
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r106 = (CoroutineScope) this.L$0;
        String r107 = this.$osType;
        String r108 = this.$terminalType;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L15
        AuthorizationFactory r110 = AuthorizationFactory.f326109a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r100 = r110.c(r107, r108, this);     // Catch: Throwable -> L15
        if (r100 != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }
}
