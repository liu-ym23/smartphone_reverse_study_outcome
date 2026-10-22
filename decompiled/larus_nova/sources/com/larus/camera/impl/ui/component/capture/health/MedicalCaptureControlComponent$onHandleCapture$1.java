package com.larus.camera.impl.ui.component.capture.health;

import com.larus.camera.api.params.OutputParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MedicalCaptureControlComponent$onHandleCapture$1 extends FunctionReferenceImpl implements Function3<List<? extends OutputParam>, Boolean, Continuation<? super Boolean>, Object>, SuspendFunction {
    public MedicalCaptureControlComponent$onHandleCapture$1(Object r100) {
        super(3, r100, MedicalCaptureControlComponent.class, "interceptResultPageOpen", "interceptResultPageOpen(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(List<? extends OutputParam> r100, Boolean r101, Continuation<? super Boolean> r102) {
        return invoke(r100, r101.booleanValue(), r102);
    }

    public final Object invoke(List<OutputParam> r100, boolean r101, Continuation<? super Boolean> r102) {
        return MedicalCaptureControlComponent.B((MedicalCaptureControlComponent) this.receiver, r100, r102);
    }
}
