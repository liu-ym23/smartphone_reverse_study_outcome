package com.larus.im.internal.memory.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.memory.cache.MessageCache", f = "MessageCache.kt", i = {0}, l = {165}, m = "addOrUpdate", n = {"entry"}, s = {"L$1"})
final class MessageCache$addOrUpdate$3 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageCache this$0;

    public MessageCache$addOrUpdate$3(MessageCache r100, Continuation<? super MessageCache$addOrUpdate$3> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MessageCache.Y(this.this$0, null, this);
    }
}
