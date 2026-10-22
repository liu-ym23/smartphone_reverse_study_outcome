package io.github.alexzhirkevich.compottie;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class LottiePainterKt$rememberLottiePainter$4 extends PropertyReference0Impl {
    public LottiePainterKt$rememberLottiePainter$4(Object r100) {
        super(r100, LottieAnimationState.class, "value", "getValue()Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((LottieAnimationState) this.receiver).getValue();
    }
}
