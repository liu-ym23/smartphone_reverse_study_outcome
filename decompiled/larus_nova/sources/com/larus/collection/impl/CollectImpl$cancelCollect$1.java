package com.larus.collection.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.collection.impl.CollectImpl", f = "CollectImpl.kt", i = {0}, l = {99}, m = "cancelCollect", n = {"collectionId"}, s = {"L$0"})
public final class CollectImpl$cancelCollect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CollectImpl this$0;

    public CollectImpl$cancelCollect$1(CollectImpl r100, Continuation<? super CollectImpl$cancelCollect$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
