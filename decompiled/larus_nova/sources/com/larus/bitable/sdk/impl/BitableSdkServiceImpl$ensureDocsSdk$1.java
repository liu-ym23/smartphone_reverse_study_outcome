package com.larus.bitable.sdk.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bitable.sdk.impl.BitableSdkServiceImpl", f = "BitableSdkServiceImpl.kt", i = {}, l = {206}, m = "ensureDocsSdk", n = {}, s = {})
public final class BitableSdkServiceImpl$ensureDocsSdk$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BitableSdkServiceImpl this$0;

    public BitableSdkServiceImpl$ensureDocsSdk$1(BitableSdkServiceImpl r100, Continuation<? super BitableSdkServiceImpl$ensureDocsSdk$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        BitableSdkServiceImpl r101 = this.this$0;
        int r102 = BitableSdkServiceImpl.f294868c;
        return r101.X(this);
    }
}
