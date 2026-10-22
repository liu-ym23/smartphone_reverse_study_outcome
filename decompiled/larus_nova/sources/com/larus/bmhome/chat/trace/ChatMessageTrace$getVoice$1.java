package com.larus.bmhome.chat.trace;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatMessageTrace", f = "ChatMessageTrace.kt", i = {}, l = {273}, m = "getVoice", n = {}, s = {})
final class ChatMessageTrace$getVoice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatMessageTrace this$0;

    public ChatMessageTrace$getVoice$1(ChatMessageTrace r100, Continuation<? super ChatMessageTrace$getVoice$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ChatMessageTrace.b(this.this$0, null, this);
    }
}
