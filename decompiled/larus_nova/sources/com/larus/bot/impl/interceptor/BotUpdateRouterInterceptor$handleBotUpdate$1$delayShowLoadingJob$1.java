package com.larus.bot.impl.interceptor;

import android.app.Activity;
import com.larus.common_ui.dialog.l0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.interceptor.BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1", f = "BotUpdateRouterInterceptor.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
public final class BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $curActivity;
    final /* synthetic */ l0 $loadingDialog;
    int label;

    public BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1(Activity r100, l0 r101, Continuation<? super BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1> r102) {
        this.$curActivity = r100;
        this.$loadingDialog = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1(this.$curActivity, this.$loadingDialog, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_interceptor_BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        if (this.$curActivity.isFinishing() == true) goto L15;
        INVOKEVIRTUAL_com_larus_bot_impl_interceptor_BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.$loadingDialog);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        this.label = 1;
        if (DelayKt.delay(400, this) != r101) goto L12;
        return r101;
    }
}
