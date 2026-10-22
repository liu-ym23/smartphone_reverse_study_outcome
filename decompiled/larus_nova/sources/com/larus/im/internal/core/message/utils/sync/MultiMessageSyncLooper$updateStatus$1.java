package com.larus.im.internal.core.message.utils.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.utils.sync.MultiMessageSyncLooper", f = "MultiMessageSyncLooper.kt", i = {0, 0, 1}, l = {169, 101}, m = "updateStatus", n = {"$this$withLock_u24default$iv", "status", "$this$withLock_u24default$iv"}, s = {"L$0", "I$0", "L$0"})
public final class MultiMessageSyncLooper$updateStatus$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiMessageSyncLooper this$0;

    public MultiMessageSyncLooper$updateStatus$1(MultiMessageSyncLooper r100, Continuation<? super MultiMessageSyncLooper$updateStatus$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(0, this);
    }
}
