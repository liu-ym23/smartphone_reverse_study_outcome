package com.bytedance.locallife.dito.interact;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements Interpolator {
    public e() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        float r101 = r100 - 1.0f;
        return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
    }
}
