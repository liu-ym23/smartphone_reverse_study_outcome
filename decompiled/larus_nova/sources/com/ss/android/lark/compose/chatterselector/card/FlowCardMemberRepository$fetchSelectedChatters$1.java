package com.ss.android.lark.compose.chatterselector.card;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatterselector.card.FlowCardMemberRepository", f = "FlowCardMemberRepository.kt", i = {0, 0}, l = {45}, m = "fetchSelectedChatters", n = {"selectedIds", "chatId"}, s = {"L$0", "L$1"})
public final class FlowCardMemberRepository$fetchSelectedChatters$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowCardMemberRepository this$0;

    public FlowCardMemberRepository$fetchSelectedChatters$1(FlowCardMemberRepository r100, Continuation<? super FlowCardMemberRepository$fetchSelectedChatters$1> r101) {
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
