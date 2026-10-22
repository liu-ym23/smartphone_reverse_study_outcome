package com.obric.aiagent.assistant_card.provider_core;

import android.content.Context;
import android.net.Uri;
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
import org.json.JSONObject;
import p9a.e;
import p9a.f;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.assistant_card.provider_core.CardProviderManager$handleCardAction$1", f = "CardProviderManager.kt", i = {0, 0}, l = {230}, m = "invokeSuspend", n = {"actionName", "actionParams"}, s = {"L$0", "L$1"})
final class CardProviderManager$handleCardAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $cardAction;
    final /* synthetic */ Uri $cardUri;
    final /* synthetic */ Context $context;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public CardProviderManager$handleCardAction$1(Bundle r100, Uri r101, Context r102, Continuation<? super CardProviderManager$handleCardAction$1> r103) {
        this.$cardAction = r100;
        this.$cardUri = r101;
        this.$context = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CardProviderManager$handleCardAction$1(this.$cardAction, this.$cardUri, this.$context, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CardProviderManager$handleCardAction$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L12;
        if (r101 != 1) goto L11;
        Uri r102 = (Uri) this.L$2;
        JSONObject r103 = (JSONObject) this.L$1;
        String r104 = (String) this.L$0;
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L8
    L39:
        e r111 = p9a.b.f528329a;     // Catch: Throwable -> L8
        p9a.b.a("CardProviderManager", "handlePendingAction: finish cardUri = " + r102 + ", actionName = " + r104 + ", actionParams = " + r103);     // Catch: Throwable -> L8
    L40:
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L43:
        Uri r105 = this.$cardUri;
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L47;
        e r106 = p9a.b.f528329a;
        p9a.b.c("CardProviderManager", "handlePendingAction: failed " + r105, r113);
    L47:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r110);
        String r114 = this.$cardAction.getString("action_name");
        if (r114 != null) goto L15;
        r114 = "";
    L15:
        Bundle r107 = this.$cardAction;
        Object r108 = null;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L22
        String r109 = r107.getString("action_params");     // Catch: Throwable -> L22
        if (r109 == null) goto L19;
        JSONObject r116 = new JSONObject(r109);     // Catch: Throwable -> L22
    L20:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L22
    L24:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L28;
        p9a.b.c("CardProviderManager", "handleCardAction: failed to parse actionParams", r118);
    L28:
        if (Result.m9455isFailureimpl(r117) == true) goto L31;
        r108 = r117;
    L31:
        JSONObject r119 = (JSONObject) r108;
        Uri r120 = this.$cardUri;
        if (c.f384640a.get(f.a(r120)) != null) goto L35;
        e r121 = p9a.b.f528329a;     // Catch: Throwable -> L8
        p9a.b.b("CardProviderManager", "handlePendingAction: no cardProvider for cardType: ".concat(f.a(r120)));     // Catch: Throwable -> L8
        goto L40
    L35:
        e r122 = p9a.b.f528329a;     // Catch: Throwable -> L8
        p9a.b.a("CardProviderManager", "handlePendingAction: start cardUri = " + r120 + ", actionName = " + r114 + ", actionParams = " + r119);     // Catch: Throwable -> L8
        this.L$0 = r114;     // Catch: Throwable -> L8
        this.L$1 = r119;     // Catch: Throwable -> L8
        this.L$2 = r120;     // Catch: Throwable -> L8
        this.label = 1;     // Catch: Throwable -> L8
        if (Unit.INSTANCE != r100) goto L38;
        return r100;
    L38:
        r104 = r114;
        r103 = r119;
        r102 = r120;
        goto L39
    L19:
        r116 = null;
    L22:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L43
    }
}
