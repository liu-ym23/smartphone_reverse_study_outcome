package com.bytedance.kmp.performance.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.performance.api.MemoryThresholdGcController", f = "MemoryThresholdActions.kt", i = {0, 0, 0, 0}, l = {104}, m = "triggerIfNeeded", n = {"memoryInfo", "config", "storage", "startTimeMs"}, s = {"L$0", "L$1", "L$2", "J$0"})
public final class MemoryThresholdGcController$triggerIfNeeded$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MemoryThresholdGcController this$0;

    public MemoryThresholdGcController$triggerIfNeeded$1(MemoryThresholdGcController r100, Continuation<? super MemoryThresholdGcController$triggerIfNeeded$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, this);
    }
}
