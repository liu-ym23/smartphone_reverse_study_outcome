package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV2$dataPreloadContainer$1", f = "ChatAppContainerV2.kt", i = {}, l = {247}, m = "fetchChatData-gIAlu-s", n = {}, s = {})
public final class ChatAppContainerV2$dataPreloadContainer$1$fetchChatData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatAppContainerV2$dataPreloadContainer$1 this$0;

    public ChatAppContainerV2$dataPreloadContainer$1$fetchChatData$1(ChatAppContainerV2$dataPreloadContainer$1 r100, Continuation<? super ChatAppContainerV2$dataPreloadContainer$1$fetchChatData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.c(null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
