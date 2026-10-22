package com.obric.assistant.remote_card_container.widget;

import android.content.Context;
import android.os.Bundle;
import com.obric.aiagent.assistant_card.provider_core.ICardProviderService;
import com.obric.aiagent.assistant_card.provider_core.bean.CardAction;
import com.obric.assistant.remote_card_container.manager.CardProviderServices;
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

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.widget.RemoteCardContainer$handleCardActionClick$1", f = "RemoteCardContainer.kt", i = {}, l = {418}, m = "invokeSuspend", n = {}, s = {})
public final class RemoteCardContainer$handleCardActionClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CardAction $action;
    final /* synthetic */ String $cardUri;
    final /* synthetic */ Context $context;
    int label;

    public RemoteCardContainer$handleCardActionClick$1(Context r100, String r101, CardAction r102, Continuation<? super RemoteCardContainer$handleCardActionClick$1> r103) {
        this.$context = r100;
        this.$cardUri = r101;
        this.$action = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RemoteCardContainer$handleCardActionClick$1(this.$context, this.$cardUri, this.$action, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RemoteCardContainer$handleCardActionClick$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        ICardProviderService r103 = (ICardProviderService) r100;
        if (r103 != null) goto L14;
        p9a.b.b("RemoteCardContainer", "cardProviderService is null, failed to handle action");
    L27:
        return Unit.INSTANCE;
    L14:
        String r104 = this.$cardUri;
        CardAction r105 = this.$action;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L17
        Bundle r107 = new Bundle();     // Catch: Throwable -> L17
        r107.putString("card_uri", r104);     // Catch: Throwable -> L17
        Bundle r108 = new Bundle();     // Catch: Throwable -> L17
        r108.putString("action_name", r105.getActionName());     // Catch: Throwable -> L17
        r108.putString("action_params", r105.getActionParams());     // Catch: Throwable -> L17
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L17
        r107.putBundle("action", r108);     // Catch: Throwable -> L17
        r103.handleCardAction(r107);     // Catch: Throwable -> L17
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        String r111 = this.$cardUri;
        Throwable r112 = Result.m9452exceptionOrNullimpl(r110);
        if (r112 == null) goto L22;
        p9a.e r113 = p9a.b.f528329a;
        p9a.b.c("RemoteCardContainer", "handleCardAction failed " + r111 + ", " + r112.getMessage(), r112);
    L22:
        String r114 = this.$cardUri;
        CardAction r115 = this.$action;
        if (Result.m9456isSuccessimpl(r110) == false) goto L25;
        Unit r116 = (Unit) r110;
        p9a.e r117 = p9a.b.f528329a;
        p9a.b.a("RemoteCardContainer", "handleCardAction done " + r114 + ", action = " + r115);
    L25:
        Result.m9448boximpl(r110);
    L17:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        CardProviderServices r119 = CardProviderServices.f391269a;
        Context r120 = this.$context;
        String r121 = this.$cardUri;
        this.label = 1;
        r100 = r119.c(r120, r121, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
