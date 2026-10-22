package vsa;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements TimeInterpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r110) {
        double r100 = r110;
        double r101 = 1.0d - r100;
        double r102 = r100 * r100;
        return (float) ((((((r101 * r101) * 3.0d) * r100) * ((double) 0.0f)) + (((r101 * 3.0d) * r102) * ((double) 1.0f))) + (r102 * r100));
    }

    public a(float r100, float r101) {
    }
}
