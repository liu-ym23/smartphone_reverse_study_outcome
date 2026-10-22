package com.larus.im.internal.memory.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.memory.cache.MessageCache", f = "MessageCache.kt", i = {1}, l = {129, 136}, m = "removeAllMessage", n = {"predicate"}, s = {"L$0"})
public final class MessageCache$removeAllMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageCache this$0;

    public MessageCache$removeAllMessage$1(MessageCache r100, Continuation<? super MessageCache$removeAllMessage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MessageCache r101 = this.this$0;
        int r102 = MessageCache.f348955m;
        return r101.h0(null, null, this);
    }
}
