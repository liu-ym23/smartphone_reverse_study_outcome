package com.obric.audio.continuous_talk;

import com.obric.assistant.spi.chat.IObricChatSPIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricContinuousTalkUIComponent$invokeOnSpeak$1$7", f = "ObricContinuousTalkUIComponent.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER}, m = "invokeSuspend", n = {}, s = {})
final class ObricContinuousTalkUIComponent$invokeOnSpeak$1$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $convId;
    int label;

    public ObricContinuousTalkUIComponent$invokeOnSpeak$1$7(String r100, Continuation<? super ObricContinuousTalkUIComponent$invokeOnSpeak$1$7> r101) {
        this.$convId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricContinuousTalkUIComponent$invokeOnSpeak$1$7(this.$convId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricContinuousTalkUIComponent$invokeOnSpeak$1$7) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L13:
        Boolean r111 = (Boolean) r110;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        IObricChatSPIService r102 = (IObricChatSPIService) ServiceManager.get().getService(IObricChatSPIService.class);
        if (r102 == null) goto L15;
        String r103 = this.$convId;
        this.label = 1;
        r110 = IObricChatSPIService.a.a(r102, r103, false, null, this, 6);
        if (r110 != r100) goto L13;
        return r100;
    }
}
