package com.larus.luckydog.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.luckydog.impl.LuckyDogServiceImpl", f = "LuckyDogServiceImpl.kt", i = {0, 1}, l = {438, 91}, m = "checkInit", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
final class LuckyDogServiceImpl$checkInit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LuckyDogServiceImpl this$0;

    public LuckyDogServiceImpl$checkInit$1(LuckyDogServiceImpl r100, Continuation<? super LuckyDogServiceImpl$checkInit$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return LuckyDogServiceImpl.j(this.this$0, this);
    }
}
