package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements Interpolator {
    public final float a;

    public h() {
        this.a = 4.0f;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r10) {
        boolean r1 = false;
        if (r10 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r10;
    L8:
        if (r10 != 1.0f) goto L10;
        r1 = true;
    L10:
        if (r1 == true) goto L15;
        double r3 = r10;
        double r2 = Math.pow(2.0d, ((double) (-10)) * r3);
        float r11 = this.a;
        return (float) ((r2 * Math.sin(((r3 - (((double) r11) / 4.0d)) * 6.283185307179586d) / ((double) r11))) + ((double) 1));
    L15:
        return r10;
    L5:
        r0 = false;
        goto L6
    }
}
