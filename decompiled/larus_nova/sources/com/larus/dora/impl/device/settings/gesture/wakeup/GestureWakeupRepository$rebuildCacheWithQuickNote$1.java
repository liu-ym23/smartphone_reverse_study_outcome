package com.larus.dora.impl.device.settings.gesture.wakeup;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupRepository", f = "GestureWakeupRepository.kt", i = {0, 1, 2}, l = {300, 210, 211}, m = "rebuildCacheWithQuickNote", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$0"})
final class GestureWakeupRepository$rebuildCacheWithQuickNote$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GestureWakeupRepository this$0;

    public GestureWakeupRepository$rebuildCacheWithQuickNote$1(GestureWakeupRepository r100, Continuation<? super GestureWakeupRepository$rebuildCacheWithQuickNote$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return GestureWakeupRepository.a(this.this$0, this);
    }
}
