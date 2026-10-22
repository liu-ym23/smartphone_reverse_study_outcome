package com.larus.im.internal.core.message.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.utils.MessageDispatcher", f = "MessageDispatcher.kt", i = {0, 0, 1, 1, 1}, l = {615, 616}, m = "transformToParent", n = {"result", "lefts", "result", "lefts", "destination$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3"})
final class MessageDispatcher$transformToParent$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageDispatcher this$0;

    public MessageDispatcher$transformToParent$2(MessageDispatcher r100, Continuation<? super MessageDispatcher$transformToParent$2> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MessageDispatcher.h(this.this$0, null, this);
    }
}
