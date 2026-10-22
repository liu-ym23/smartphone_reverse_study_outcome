package com.obric.oui.texteffects;

import android.graphics.BlurMaskFilter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class OProtocolTextEffectTextView$drawTextLayer$2 extends FunctionReferenceImpl implements Function1<Float, BlurMaskFilter> {
    public OProtocolTextEffectTextView$drawTextLayer$2(Object r100) {
        super(1, r100, OProtocolTextEffectTextView.class, "getBlurMaskFilter", "getBlurMaskFilter(F)Landroid/graphics/BlurMaskFilter;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ BlurMaskFilter invoke(Float r100) {
        return invoke(r100.floatValue());
    }

    public final BlurMaskFilter invoke(float r100) {
        return ((OProtocolTextEffectTextView) this.receiver).n(r100);
    }
}
