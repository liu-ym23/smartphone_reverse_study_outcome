package com.larus.minor.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.minor.impl.MinorServiceImpl", f = "MinorServiceImpl.kt", i = {}, l = {75}, m = "requestMinorStatus", n = {}, s = {})
public final class MinorServiceImpl$requestMinorStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MinorServiceImpl this$0;

    public MinorServiceImpl$requestMinorStatus$1(MinorServiceImpl r100, Continuation<? super MinorServiceImpl$requestMinorStatus$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(this);
    }
}
