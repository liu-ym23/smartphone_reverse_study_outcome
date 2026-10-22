package vsa;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes34.dex */
public final class q implements TimeInterpolator {
    public q() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        if (r100 <= 0.0f) goto L6;
        return 1.0f;
    L6:
        return 0.0f;
    }
}
