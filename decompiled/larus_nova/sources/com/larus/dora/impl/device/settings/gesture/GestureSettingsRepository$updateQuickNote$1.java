package com.larus.dora.impl.device.settings.gesture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository", f = "GestureSettingsRepository.kt", i = {}, l = {204, 205, 208, 209, 214, 215, 218, 219}, m = "updateQuickNote", n = {}, s = {})
public final class GestureSettingsRepository$updateQuickNote$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GestureSettingsRepository this$0;

    public GestureSettingsRepository$updateQuickNote$1(GestureSettingsRepository r100, Continuation<? super GestureSettingsRepository$updateQuickNote$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        GestureSettingsRepository r101 = this.this$0;
        GestureSettingsRepository r102 = GestureSettingsRepository.f334402a;
        return r101.h(null, (byte) 0, this);
    }
}
