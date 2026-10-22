package mz3;

import android.graphics.PointF;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l extends k {
    public boolean d;

    public l() {
        PointF r0 = this.b;
        r0.x = 0.25f;
        r0.y = 0.1f;
        PointF r1 = this.c;
        r1.x = 0.18f;
        r1.y = 1.0f;
    }

    @Override // mz3.k, android.animation.TimeInterpolator
    public final float getInterpolation(float r3) {
        if (this.d == true) goto L7;
        float r4 = r3 - 1.0f;
        return ((((r4 * r4) * r4) * r4) * r4) + 1.0f;
    L7:
        return super.getInterpolation(r3);
    }
}
