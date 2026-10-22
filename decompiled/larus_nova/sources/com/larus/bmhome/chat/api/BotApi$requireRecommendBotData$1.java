package com.larus.bmhome.chat.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.api.BotApi", f = "BotApi.kt", i = {0}, l = {74}, m = "requireRecommendBotData", n = {"recommendType"}, s = {"I$0"})
public final class BotApi$requireRecommendBotData$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BotApi this$0;

    public BotApi$requireRecommendBotData$1(BotApi r100, Continuation<? super BotApi$requireRecommendBotData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(0, 0, 0, null, false, null, null, null, null, null, this);
    }
}
