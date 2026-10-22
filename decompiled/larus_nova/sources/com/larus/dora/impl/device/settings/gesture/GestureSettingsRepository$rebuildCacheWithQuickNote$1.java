package com.larus.dora.impl.device.settings.gesture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository", f = "GestureSettingsRepository.kt", i = {0, 1, 2}, l = {246, 170, 171}, m = "rebuildCacheWithQuickNote", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$0"})
final class GestureSettingsRepository$rebuildCacheWithQuickNote$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GestureSettingsRepository this$0;

    public GestureSettingsRepository$rebuildCacheWithQuickNote$1(GestureSettingsRepository r100, Continuation<? super GestureSettingsRepository$rebuildCacheWithQuickNote$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return GestureSettingsRepository.a(this.this$0, this);
    }
}
