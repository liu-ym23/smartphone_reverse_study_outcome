package com.larus.dora.impl.device.settings.gesture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository", f = "GestureSettingsRepository.kt", i = {0, 0, 1, 1, 1, 2, 2, 3}, l = {246, 112, 118, 120}, m = "load", n = {"$this$withLock_u24default$iv", "useCachedQuickNoteConfig", "$this$withLock_u24default$iv", "device", "useCachedQuickNoteConfig", "$this$withLock_u24default$iv", "rawMap", "$this$withLock_u24default$iv"}, s = {"L$0", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$0"})
public final class GestureSettingsRepository$load$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GestureSettingsRepository this$0;

    public GestureSettingsRepository$load$1(GestureSettingsRepository r100, Continuation<? super GestureSettingsRepository$load$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(false, this);
    }
}
