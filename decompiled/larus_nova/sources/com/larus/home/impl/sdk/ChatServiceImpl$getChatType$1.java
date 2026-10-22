package com.larus.home.impl.sdk;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.sdk.ChatServiceImpl", f = "ChatServiceImpl.kt", i = {}, l = {28}, m = "getChatType", n = {}, s = {})
public final class ChatServiceImpl$getChatType$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatServiceImpl this$0;

    public ChatServiceImpl$getChatType$1(ChatServiceImpl r100, Continuation<? super ChatServiceImpl$getChatType$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, this);
    }
}
