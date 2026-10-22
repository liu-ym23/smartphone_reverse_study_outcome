package com.larus.im.internal.core.message.utils.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.utils.sync.MultiMessageSyncLooper", f = "MultiMessageSyncLooper.kt", i = {0, 0, 0, 1}, l = {153, 159}, m = "concatMessage", n = {"newer", "appendFields", "messageId", "messageId"}, s = {"L$0", "L$1", "L$2", "L$0"})
public final class MultiMessageSyncLooper$concatMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiMessageSyncLooper this$0;

    public MultiMessageSyncLooper$concatMessage$1(MultiMessageSyncLooper r100, Continuation<? super MultiMessageSyncLooper$concatMessage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}
