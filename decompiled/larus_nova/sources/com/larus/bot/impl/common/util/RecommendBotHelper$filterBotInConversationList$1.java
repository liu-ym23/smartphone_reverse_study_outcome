package com.larus.bot.impl.common.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.common.util.RecommendBotHelper", f = "RecommendBotHelper.kt", i = {0, 0, 1, 1}, l = {19, 20}, m = "filterBotInConversationList", n = {"botList", "addedBotIdsMap", "botList", "addedBotIdsMap"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class RecommendBotHelper$filterBotInConversationList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecommendBotHelper this$0;

    public RecommendBotHelper$filterBotInConversationList$1(RecommendBotHelper r100, Continuation<? super RecommendBotHelper$filterBotInConversationList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
