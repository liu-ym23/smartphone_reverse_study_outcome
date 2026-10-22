package com.larus.im.internal.core.conversation.bot;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.bot.GetBotsProcessor", f = "GetBotsProcessor.kt", i = {0, 0}, l = {56, 60}, m = "fetchNetBots", n = {"needFetchBotIds", "localMap"}, s = {"L$0", "L$1"})
public final class GetBotsProcessor$fetchNetBots$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetBotsProcessor this$0;

    public GetBotsProcessor$fetchNetBots$1(GetBotsProcessor r100, Continuation<? super GetBotsProcessor$fetchNetBots$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}
