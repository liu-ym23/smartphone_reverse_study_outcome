package com.larus.bmhome.bot.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.bot.utils.PinBotShortcutLinkProcessor", f = "PinBotShortcutLinkProcessor.kt", i = {0}, l = {41, 52}, m = "findConversationIdByBot", n = {"botId"}, s = {"L$0"})
public final class PinBotShortcutLinkProcessor$findConversationIdByBot$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PinBotShortcutLinkProcessor this$0;

    public PinBotShortcutLinkProcessor$findConversationIdByBot$1(PinBotShortcutLinkProcessor r100, Continuation<? super PinBotShortcutLinkProcessor$findConversationIdByBot$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        PinBotShortcutLinkProcessor r101 = this.this$0;
        PinBotShortcutLinkProcessor r102 = PinBotShortcutLinkProcessor.f296774a;
        return r101.c(null, this);
    }
}
