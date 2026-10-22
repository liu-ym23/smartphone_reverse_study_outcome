package com.larus.bot.impl.feature.edit.feature.bgimage;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.BotBgImageEditViewModel", f = "BotBgImageEditViewModel.kt", i = {0}, l = {323}, m = "interceptShowGenActionSheetForBotInfoReview", n = {"delayShowLoadingJob"}, s = {"L$0"})
final class BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BotBgImageEditViewModel this$0;

    public BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1(BotBgImageEditViewModel r100, Continuation<? super BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return BotBgImageEditViewModel.q(this.this$0, null, null, this);
    }
}
