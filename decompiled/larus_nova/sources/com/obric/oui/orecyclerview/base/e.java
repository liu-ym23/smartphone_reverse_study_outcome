package com.obric.oui.orecyclerview.base;

import android.view.animation.BaseInterpolator;

/* JADX INFO: loaded from: classes34.dex */
public final class e extends BaseInterpolator {
    public e() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        return Math.min(1.0f, (1.0f - (((9.06472f * r100) + 1.0f) * ((float) Math.exp(r100 * (-9.06472f))))) * 1.0011656f);
    }
}
