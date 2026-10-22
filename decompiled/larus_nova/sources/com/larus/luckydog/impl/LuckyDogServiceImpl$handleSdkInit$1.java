package com.larus.luckydog.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.luckydog.impl.LuckyDogServiceImpl", f = "LuckyDogServiceImpl.kt", i = {}, l = {116}, m = "handleSdkInit", n = {}, s = {})
public final class LuckyDogServiceImpl$handleSdkInit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LuckyDogServiceImpl this$0;

    public LuckyDogServiceImpl$handleSdkInit$1(LuckyDogServiceImpl r100, Continuation<? super LuckyDogServiceImpl$handleSdkInit$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        LuckyDogServiceImpl r101 = this.this$0;
        int r102 = LuckyDogServiceImpl.f358405f;
        return r101.k(this);
    }
}
