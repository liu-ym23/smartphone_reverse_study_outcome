package com.larus.common.account.platform.larkauth;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/dpop/DPoPTicketData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.platform.larkauth.AuthorizationFactory$getTicketAndTicketSignature$ticketData$1$1", f = "AuthorizationFactory.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
final class AuthorizationFactory$getTicketAndTicketSignature$ticketData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.bytedance.dpop.f>, Object> {
    final /* synthetic */ String $authorization;
    final /* synthetic */ com.bytedance.dpop.c $generator;
    final /* synthetic */ String $url;
    int label;

    public AuthorizationFactory$getTicketAndTicketSignature$ticketData$1$1(com.bytedance.dpop.c r100, String r101, String r102, Continuation<? super AuthorizationFactory$getTicketAndTicketSignature$ticketData$1$1> r103) {
        this.$generator = r100;
        this.$authorization = r101;
        this.$url = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AuthorizationFactory$getTicketAndTicketSignature$ticketData$1$1(this.$generator, this.$authorization, this.$url, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super com.bytedance.dpop.f> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super com.bytedance.dpop.f> r101) {
        return ((AuthorizationFactory$getTicketAndTicketSignature$ticketData$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
        Object r103 = ((Result) r100).m9458unboximpl();
    L12:
        if (Result.m9455isFailureimpl(r103) == false) goto L15;
        return null;
    L15:
        return r103;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        com.bytedance.dpop.e r104 = new com.bytedance.dpop.e(this.$generator);
        String r105 = this.$authorization;
        String r106 = this.$url;
        this.label = 1;
        r103 = r104.c(r105, r106);
        if (r103 != r101) goto L12;
        return r101;
    }
}
