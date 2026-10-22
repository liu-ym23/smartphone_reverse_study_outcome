package com.obric.assistant.activation.presentation.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricListeningVisualView$fakeAmplitudePlayer$2$2 extends FunctionReferenceImpl implements Function1<Float, Unit> {
    public ObricListeningVisualView$fakeAmplitudePlayer$2$2(Object r100) {
        super(1, r100, ObricListeningVisualView.class, "applyAmplitude", "applyAmplitude(F)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Float r100) {
        invoke(r100.floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float r100) {
        ObricListeningVisualView r101 = (ObricListeningVisualView) this.receiver;
        int r102 = ObricListeningVisualView.f385560i;
        r101.a(r100);
    }
}
