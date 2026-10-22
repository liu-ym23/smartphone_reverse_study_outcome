package com.larus.bmhome.chat.outerinput;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.outerinput.OuterChatInputController", f = "OuterChatInputController.kt", i = {0, 1}, l = {126, 130, 135}, m = "getMainBotConversationInfo", n = {"callback", "callback"}, s = {"L$0", "L$0"})
final class OuterChatInputController$getMainBotConversationInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OuterChatInputController this$0;

    public OuterChatInputController$getMainBotConversationInfo$1(OuterChatInputController r100, Continuation<? super OuterChatInputController$getMainBotConversationInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return OuterChatInputController.d(this.this$0, null, this);
    }
}
