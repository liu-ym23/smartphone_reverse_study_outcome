package com.obric.sva.sdk.ui;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes34.dex */
public class CubicEaseInInterpolator implements Interpolator {
    public CubicEaseInInterpolator() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r100) {
        return (r100 * r100) * r100;
    }
}
