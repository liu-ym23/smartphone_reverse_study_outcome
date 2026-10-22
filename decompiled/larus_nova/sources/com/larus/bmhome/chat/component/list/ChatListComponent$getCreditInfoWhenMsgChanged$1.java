package com.larus.bmhome.chat.component.list;

import com.larus.commercecredit.api.CreditInfoScene;
import com.larus.commercecredit.api.ICommerceCreditService;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$getCreditInfoWhenMsgChanged$1", f = "ChatListComponent.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTM_SIGNAL_OFFER_CREATED_TIME}, m = "invokeSuspend", n = {}, s = {})
final class ChatListComponent$getCreditInfoWhenMsgChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreditInfoScene $scene;
    int label;

    public ChatListComponent$getCreditInfoWhenMsgChanged$1(CreditInfoScene r100, Continuation<? super ChatListComponent$getCreditInfoWhenMsgChanged$1> r101) {
        this.$scene = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChatListComponent$getCreditInfoWhenMsgChanged$1(this.$scene, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ChatListComponent$getCreditInfoWhenMsgChanged$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L15
    L19:
    L18:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        ICommerceCreditService.f325667a.getClass();     // Catch: Exception -> L15
        ICommerceCreditService r103 = ICommerceCreditService.a.a();     // Catch: Exception -> L15
        if (r103 == null) goto L19;
        CreditInfoScene r104 = this.$scene;     // Catch: Exception -> L15
        this.label = 1;     // Catch: Exception -> L15
        if (r103.m(r104, false, null, this) != r101) goto L19;
        return r101;
    L15:
        e = move-exception;
        FLogger.f375446a.e("streamService", "Failed to getAtomCreditInfo", e);
        goto L18
    }
}
