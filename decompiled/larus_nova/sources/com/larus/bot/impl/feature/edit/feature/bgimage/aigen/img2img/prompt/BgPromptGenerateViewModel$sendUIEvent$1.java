package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt;

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
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.BgPromptGenerateViewModel$sendUIEvent$1", f = "BgPromptGenerateViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS}, m = "invokeSuspend", n = {}, s = {})
public final class BgPromptGenerateViewModel$sendUIEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $event;
    int label;
    final /* synthetic */ BgPromptGenerateViewModel this$0;

    public BgPromptGenerateViewModel$sendUIEvent$1(BgPromptGenerateViewModel r100, e r101, Continuation<? super BgPromptGenerateViewModel$sendUIEvent$1> r102) {
        this.this$0 = r100;
        this.$event = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BgPromptGenerateViewModel$sendUIEvent$1(this.this$0, this.$event, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BgPromptGenerateViewModel$sendUIEvent$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        MutableSharedFlow<e> r103 = this.this$0.f318720g;
        e r104 = this.$event;
        this.label = 1;
        if (r103.emit(r104, this) != r101) goto L12;
        return r101;
    }
}
