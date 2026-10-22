package com.larus.bmhome.chat.component.bottom;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.ChatMessageComponent", f = "ChatMessageComponent.kt", i = {0}, l = {238}, m = "runSuspendSafely", n = {"functionName"}, s = {"L$0"})
public final class ChatMessageComponent$runSuspendSafely$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatMessageComponent this$0;

    public ChatMessageComponent$runSuspendSafely$1(ChatMessageComponent r100, Continuation<? super ChatMessageComponent$runSuspendSafely$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ChatMessageComponent r101 = this.this$0;
        int r102 = ChatMessageComponent.f297982j;
        return r101.P2(null, null, this);
    }
}
