package com.larus.camera.impl.ui.component.capture.health;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.health.MedicalCaptureControlComponent", f = "MedicalCaptureControlComponent.kt", i = {}, l = {28}, m = "interceptResultPageOpen", n = {}, s = {})
final class MedicalCaptureControlComponent$interceptResultPageOpen$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MedicalCaptureControlComponent this$0;

    public MedicalCaptureControlComponent$interceptResultPageOpen$1(MedicalCaptureControlComponent r100, Continuation<? super MedicalCaptureControlComponent$interceptResultPageOpen$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MedicalCaptureControlComponent.B(this.this$0, null, this);
    }
}
