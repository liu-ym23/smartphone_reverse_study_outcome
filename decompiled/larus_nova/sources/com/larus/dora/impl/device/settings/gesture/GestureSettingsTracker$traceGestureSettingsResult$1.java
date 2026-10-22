package com.larus.dora.impl.device.settings.gesture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.GestureSettingsTracker", f = "GestureSettingsTracker.kt", i = {1, 1, 1}, l = {167, 171}, m = "traceGestureSettingsResult", n = {"map", "leftWakeType", "rightWakeType"}, s = {"L$0", "L$1", "L$2"})
public final class GestureSettingsTracker$traceGestureSettingsResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GestureSettingsTracker this$0;

    public GestureSettingsTracker$traceGestureSettingsResult$1(GestureSettingsTracker r100, Continuation<? super GestureSettingsTracker$traceGestureSettingsResult$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(this);
    }
}
