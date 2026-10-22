package com.obric.aiagent.assistant_card.provider_core;

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

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.assistant_card.provider_core.CardProviderManager$notifyCardChanged$1", f = "CardProviderManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CardProviderManager$notifyCardChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $cardParams;
    final /* synthetic */ Uri $cardUri;
    private /* synthetic */ Object L$0;
    int label;

    public CardProviderManager$notifyCardChanged$1(Uri r100, JSONObject r101, Continuation<? super CardProviderManager$notifyCardChanged$1> r102) {
        this.$cardUri = r100;
        this.$cardParams = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CardProviderManager$notifyCardChanged$1 r102 = new CardProviderManager$notifyCardChanged$1(this.$cardUri, this.$cardParams, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CardProviderManager$notifyCardChanged$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L35;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Uri r102 = this.$cardUri;
        JSONObject r103 = this.$cardParams;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L24
        IHostApi r105 = c.f384642c;     // Catch: Throwable -> L24
        if (r105 != null) goto L36;
        p9a.b.a("CardProviderManager", "notifyDataChanged: hostApi is null, will use cp to notify");     // Catch: Throwable -> L24
        c.a(r102, r103);     // Catch: Throwable -> L24
        Object r106 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L22:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L24
    L26:
        Uri r108 = this.$cardUri;
        Throwable r109 = Result.m9452exceptionOrNullimpl(r107);
        if (r109 == null) goto L29;
        e r110 = p9a.b.f528329a;
        p9a.b.c("CardProviderManager", "notifyDataChanged: failed to notify " + r108, r109);
    L29:
        Uri r111 = this.$cardUri;
        if (Result.m9456isSuccessimpl(r107) == false) goto L33;
        e r112 = p9a.b.f528329a;
        p9a.b.a("CardProviderManager", "notifyDataChanged: notify " + r111 + " success");
    L33:
        return Unit.INSTANCE;
    L36:
        Bundle r113 = new Bundle();     // Catch: Throwable -> L13
        r113.putString("card_uri", r102.toString());     // Catch: Throwable -> L13
        if (r103 == null) goto L10;
        String r114 = r103.toString();     // Catch: Throwable -> L13
    L11:
        r113.putString("card_extra_params", r114);     // Catch: Throwable -> L13
        r105.notifyCardChanged(r113);     // Catch: Throwable -> L13
        Object r115 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);     // Catch: Throwable -> L24
        if (r116 == null) goto L18;
        e r117 = p9a.b.f528329a;     // Catch: Throwable -> L24
        p9a.b.c("CardProviderManager", "notifyDataChanged: failed to notify " + r102 + ", error: " + r116.getMessage(), r116);     // Catch: Throwable -> L24
    L18:
        r106 = r105;
        if (Result.m9456isSuccessimpl(r115) == false) goto L22;
        Unit r118 = (Unit) r115;     // Catch: Throwable -> L24
        p9a.b.a("CardProviderManager", "notifyDataChanged succeed");     // Catch: Throwable -> L24
        r106 = r105;
        goto L22
    L10:
        r114 = null;
    L13:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L24
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L35:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
