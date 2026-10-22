package com.obric.aiagent.assistant_card.provider_core;

import android.os.Bundle;
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
import p9a.e;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.assistant_card.provider_core.CardProviderManager$callHostMethod$1", f = "CardProviderManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CardProviderManager$callHostMethod$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $methodName;
    final /* synthetic */ Bundle $methodParams;
    private /* synthetic */ Object L$0;
    int label;

    public CardProviderManager$callHostMethod$1(String r100, Bundle r101, Continuation<? super CardProviderManager$callHostMethod$1> r102) {
        this.$methodName = r100;
        this.$methodParams = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CardProviderManager$callHostMethod$1 r102 = new CardProviderManager$callHostMethod$1(this.$methodName, this.$methodParams, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CardProviderManager$callHostMethod$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        String r102 = this.$methodName;
        Bundle r103 = this.$methodParams;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        IHostApi r105 = c.f384642c;     // Catch: Throwable -> L11
        if (r105 == null) goto L8;
        r105.callMethod(r102, r103);     // Catch: Throwable -> L11
        Object r106 = r105;
    L9:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L11
    L13:
        String r108 = this.$methodName;
        Throwable r109 = Result.m9452exceptionOrNullimpl(r107);
        if (r109 == null) goto L17;
        e r110 = p9a.b.f528329a;
        p9a.b.c("CardProviderManager", "callHostMethod: failed to call " + r108, r109);
    L17:
        return Unit.INSTANCE;
    L8:
        e r111 = p9a.b.f528329a;     // Catch: Throwable -> L11
        p9a.b.b("CardProviderManager", "callHostMethod: failed to call " + r102 + ", hostApi is null");     // Catch: Throwable -> L11
        r106 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
