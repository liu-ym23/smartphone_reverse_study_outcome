package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f193662a;

    public h() {
        this.f193662a = 4.0f;
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
        double r102 = r110;
        double r103 = Math.pow(2.0d, ((double) (-10)) * r102);
        float r111 = this.f193662a;
        return (float) ((r103 * Math.sin(((r102 - (((double) r111) / 4.0d)) * 6.283185307179586d) / ((double) r111))) + ((double) 1));
    L15:
        return r110;
    L5:
        r101 = false;
        goto L6
    }
}
