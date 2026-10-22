package vu7;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeInterpolator f557363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float[] f557364b;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        if (this.f557364b.length <= 1) goto L14;
        int r101 = 0;
    L5:
        float[] r102 = this.f557364b;
        if (r101 >= (r102.length - 1)) goto L14;
        float r103 = r102[r101];
        r101 = r101 + 1;
        float r104 = r102[r101];
        float r105 = r104 - r103;
        if (r100 < r103) goto L5;
        if (r100 > r104) goto L5;
        TimeInterpolator r106 = this.f557363a;
        return r103 + (r106.getInterpolation((r100 - r103) / r105) * r105);
    L14:
        return this.f557363a.getInterpolation(r100);
    }

    public a(TimeInterpolator r100, float... r101) {
        this.f557363a = r100;
        this.f557364b = r101;
    }
}
