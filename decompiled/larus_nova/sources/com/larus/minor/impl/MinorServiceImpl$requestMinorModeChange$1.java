package com.larus.minor.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.minor.impl.MinorServiceImpl", f = "MinorServiceImpl.kt", i = {0}, l = {90}, m = "requestMinorModeChange", n = {"enable"}, s = {"Z$0"})
final class MinorServiceImpl$requestMinorModeChange$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MinorServiceImpl this$0;

    public MinorServiceImpl$requestMinorModeChange$1(MinorServiceImpl r100, Continuation<? super MinorServiceImpl$requestMinorModeChange$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n(this);
    }
}
