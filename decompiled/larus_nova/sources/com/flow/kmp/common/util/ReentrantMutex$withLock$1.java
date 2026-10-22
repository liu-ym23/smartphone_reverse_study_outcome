package com.flow.kmp.common.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.flow.kmp.common.util.ReentrantMutex", f = "ReentrantMutex.kt", i = {1, 1, 1, 1, 1, 2, 2, 2}, l = {36, 86, 73}, m = "withLock", n = {"block", "lockIn", "lockOut", "job", "$this$withLock_u24default$iv", "lockOut", "job", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2"})
public final class ReentrantMutex$withLock$1<R> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReentrantMutex this$0;

    public ReentrantMutex$withLock$1(ReentrantMutex r100, Continuation<? super ReentrantMutex$withLock$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
