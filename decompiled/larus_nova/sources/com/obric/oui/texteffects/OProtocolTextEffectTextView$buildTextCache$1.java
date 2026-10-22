package com.obric.oui.texteffects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class OProtocolTextEffectTextView$buildTextCache$1 extends FunctionReferenceImpl implements Function1<Float, Float> {
    public OProtocolTextEffectTextView$buildTextCache$1(Object r100) {
        super(1, r100, OProtocolTextEffectTextView.class, "computeStartX", "computeStartX(F)F", 0);
    }

    public final Float invoke(float r100) {
        return Float.valueOf(((OProtocolTextEffectTextView) this.receiver).f(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Float invoke(Float r100) {
        return invoke(r100.floatValue());
    }
}
