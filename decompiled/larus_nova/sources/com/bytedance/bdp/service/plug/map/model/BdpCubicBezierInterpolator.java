package com.bytedance.bdp.service.plug.map.model;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes11.dex */
public class BdpCubicBezierInterpolator implements Interpolator {
    private final float mX1;
    private final float mX2;
    private final float mY1;
    private final float mY2;

    private float linearInterpolate(float r100, float r101, float r102) {
        return r100 + ((r101 - r100) * r102);
    }

    private float getTForXValue(float r110) {
        float r100 = 0.0f;
        if (r110 > 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r110 < 1.0f) goto L8;
        return 1.0f;
    L8:
        int r101 = 0;
        float r102 = r110;
        float r103 = 0.0f;
        float r104 = 1.0f;
        int r105 = 0;
    L10:
        if (r105 >= 8) goto L23;
        r103 = getX(r102);
        double r106 = (getX(r102 + 1.0E-4f) - r103) / 1.0E-4f;
        float r111 = r103 - r110;
        if (Math.abs(r111) < 1.0E-4f) goto L13;
        if (Math.abs(r106) < 9.999999747378752E-5d) goto L23;
        if (r103 >= r110) goto L20;
        r100 = r102;
    L21:
        r102 = (float) (((double) r102) - (((double) r111) / r106));
        r105 = r105 + 1;
        goto L10
    L20:
        r104 = r102;
        goto L21
    L13:
        return r102;
    L23:
        if (Math.abs(r103 - r110) <= 1.0E-4f) goto L30;
        if (r101 >= 8) goto L30;
        if (r103 >= r110) goto L28;
        float r112 = r102;
        r102 = (r102 + r104) / 2.0f;
        r100 = r112;
    L29:
        r103 = getX(r102);
        r101 = r101 + 1;
        goto L23
    L28:
        r104 = r102;
        r102 = (r102 + r100) / 2.0f;
    L30:
        return r102;
    }

    private float getX(float r100) {
        return getCoordinate(r100, this.mX1, this.mX2);
    }

    private float getY(float r100) {
        return getCoordinate(r100, this.mY1, this.mY2);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r100) {
        return getY(getTForXValue(r100));
    }

    private float getCoordinate(float r100, float r101, float r102) {
        if (r100 != 0.0f) goto L5;
        return r100;
    L5:
        if (r100 == 1.0f) goto L10;
        float r103 = linearInterpolate(0.0f, r101, r100);
        float r104 = linearInterpolate(r101, r102, r100);
        float r105 = linearInterpolate(r102, 1.0f, r100);
        return linearInterpolate(linearInterpolate(r103, r104, r100), linearInterpolate(r104, r105, r100), r100);
    L10:
        return r100;
    }

    public BdpCubicBezierInterpolator(float r100, float r101, float r102, float r103) {
        this.mX1 = r100;
        this.mY1 = r101;
        this.mX2 = r102;
        this.mY2 = r103;
    }

    public BdpCubicBezierInterpolator(double r100, double r101, double r102, double r103) {
        this((float) r100, (float) r101, (float) r102, (float) r103);
    }
}
