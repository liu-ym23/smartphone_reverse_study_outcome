package mz3;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes14.dex */
public final class l extends k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f516491d;

    public l() {
        PointF r100 = this.f516489b;
        r100.x = 0.25f;
        r100.y = 0.1f;
        PointF r101 = this.f516490c;
        r101.x = 0.18f;
        r101.y = 1.0f;
    }

    @Override // mz3.k, android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        if (this.f516491d == true) goto L7;
        float r101 = r100 - 1.0f;
        return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
    L7:
        return super.getInterpolation(r100);
    }
}
