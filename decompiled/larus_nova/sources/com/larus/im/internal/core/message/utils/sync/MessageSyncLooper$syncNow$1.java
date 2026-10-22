package com.larus.im.internal.core.message.utils.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.utils.sync.MessageSyncLooper", f = "MessageSyncLooper.kt", i = {0, 1}, l = {39, 41}, m = "syncNow", n = {"currentSeq", "currentSeq"}, s = {"I$0", "I$0"})
public final class MessageSyncLooper$syncNow$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageSyncLooper this$0;

    public MessageSyncLooper$syncNow$1(MessageSyncLooper r100, Continuation<? super MessageSyncLooper$syncNow$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(this);
    }
}
