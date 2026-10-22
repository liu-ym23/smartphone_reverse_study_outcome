package com.facebook.keyframes.util;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes23.dex */
public class KFPathInterpolator implements Interpolator {
    private static final float PRECISION = 0.03f;
    private final float[] mX;
    private final float[] mY;

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r100) {
        if (r100 > 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r100 < 1.0f) goto L8;
        return 1.0f;
    L8:
        int r101 = this.mX.length - 1;
        int r102 = 0;
    L10:
        if ((r101 - r102) <= 1) goto L15;
        int r103 = (r102 + r101) / 2;
        if (r100 < this.mX[r103]) goto L13;
        r102 = r103;
        goto L10
    L13:
        r101 = r103;
        goto L10
    L15:
        float[] r104 = this.mX;
        float r105 = r104[r101];
        float r106 = r104[r102];
        float r107 = r105 - r106;
        if (r107 == 0.0f) goto L18;
        float r108 = (r100 - r106) / r107;
        float[] r109 = this.mY;
        float r110 = r109[r102];
        return r110 + (r108 * (r109[r101] - r110));
    L18:
        return this.mY[r102];
    }

    public KFPathInterpolator(float r100, float r110, float r111, float r112) {
        Path r101 = new Path();
        r101.moveTo(0.0f, 0.0f);
        r101.cubicTo(r100, r110, r111, r112, 1.0f, 1.0f);
        PathMeasure r102 = new PathMeasure(r101, false);
        float r113 = r102.getLength();
        int r114 = ((int) (r113 / PRECISION)) + 1;
        this.mX = new float[r114];
        this.mY = new float[r114];
        float[] r103 = new float[2];
        int r104 = 0;
    L3:
        if (r104 >= r114) goto L5;
        r102.getPosTan((r104 * r113) / (r114 - 1), r103, null);
        this.mX[r104] = r103[0];
        this.mY[r104] = r103[1];
        r104 = r104 + 1;
        goto L3
    }
}
