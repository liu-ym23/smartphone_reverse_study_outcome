package xd1;

import android.view.animation.BaseInterpolator;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends BaseInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f563277a;

    public a() {
        this.f563277a = 0.355f;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        if (r100 != 0.0f) goto L5;
        return r100;
    L5:
        if (r100 == 1.0f) goto L10;
        double r101 = Math.pow(2.0d, (-10.0f) * r100);
        double r102 = r100;
        float r103 = this.f563277a;
        return (float) ((r101 * Math.sin(((r102 - (((double) r103) / 4.0d)) * 6.283185307179586d) / ((double) r103))) + 1.0d);
    L10:
        return r100;
    }
}
