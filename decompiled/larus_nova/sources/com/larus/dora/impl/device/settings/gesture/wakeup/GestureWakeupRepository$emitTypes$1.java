package com.larus.dora.impl.device.settings.gesture.wakeup;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupRepository", f = "GestureWakeupRepository.kt", i = {}, l = {218, 222}, m = "emitTypes", n = {}, s = {})
public final class GestureWakeupRepository$emitTypes$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GestureWakeupRepository this$0;

    public GestureWakeupRepository$emitTypes$1(GestureWakeupRepository r100, Continuation<? super GestureWakeupRepository$emitTypes$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        GestureWakeupRepository r101 = this.this$0;
        GestureWakeupRepository r102 = GestureWakeupRepository.f334505a;
        return r101.d(null, this);
    }
}
