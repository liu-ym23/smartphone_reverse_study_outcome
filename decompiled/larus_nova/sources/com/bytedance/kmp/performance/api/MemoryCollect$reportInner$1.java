package com.bytedance.kmp.performance.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.performance.api.MemoryCollect", f = "MemoryMonitor.kt", i = {0, 0, 0}, l = {70, 92}, m = "reportInner", n = {"info", "ctx", "immediately"}, s = {"L$0", "L$1", "Z$0"})
public final class MemoryCollect$reportInner$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MemoryCollect this$0;

    public MemoryCollect$reportInner$1(MemoryCollect r100, Continuation<? super MemoryCollect$reportInner$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MemoryCollect r101 = this.this$0;
        MemoryCollect r102 = MemoryCollect.f252592a;
        return r101.b(null, false, null, this);
    }
}
