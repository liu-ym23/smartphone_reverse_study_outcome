package vl4;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f555674a;

    public b(float r100) {
        this.f555674a = 0.5f;
        this.f555674a = r100;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r110) {
        boolean r100 = false;
        if (r110 != 0.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return r110;
    L8:
        if (r110 != 1.0f) goto L10;
        r100 = true;
    L10:
        if (r100 == true) goto L15;
        double r102 = Math.pow(2.0d, (-10) * r110);
        double r103 = r110;
        float r111 = this.f555674a;
        return (float) ((r102 * Math.sin(((r103 - (((double) r111) / 4.0d)) * 6.283185307179586d) / ((double) r111))) + ((double) 1));
    L15:
        return r110;
    L5:
        r101 = false;
        goto L6
    }
}
