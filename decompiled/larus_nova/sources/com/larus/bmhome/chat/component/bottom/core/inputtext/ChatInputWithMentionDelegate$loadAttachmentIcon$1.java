package com.larus.bmhome.chat.component.bottom.core.inputtext;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate", f = "ChatInputWithMentionDelegate.kt", i = {}, l = {418}, m = "loadAttachmentIcon", n = {}, s = {})
final class ChatInputWithMentionDelegate$loadAttachmentIcon$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatInputWithMentionDelegate this$0;

    public ChatInputWithMentionDelegate$loadAttachmentIcon$1(ChatInputWithMentionDelegate r100, Continuation<? super ChatInputWithMentionDelegate$loadAttachmentIcon$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ChatInputWithMentionDelegate.c(this.this$0, null, this);
    }
}
