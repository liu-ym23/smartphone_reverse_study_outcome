package com.larus.im.internal.core.message.utils.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.utils.sync.MultiMessageSyncLooper", f = "MultiMessageSyncLooper.kt", i = {0, 1, 1, 2}, l = {75, 85, 90}, m = "doSync", n = {"msgEntity", "msgEntity", "currentSeq", "currentSeq"}, s = {"L$0", "L$0", "I$0", "I$0"})
public final class MultiMessageSyncLooper$doSync$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiMessageSyncLooper this$0;

    public MultiMessageSyncLooper$doSync$1(MultiMessageSyncLooper r100, Continuation<? super MultiMessageSyncLooper$doSync$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MultiMessageSyncLooper r101 = this.this$0;
        int r102 = MultiMessageSyncLooper.f347890o;
        return r101.h(null, 0, this);
    }
}
