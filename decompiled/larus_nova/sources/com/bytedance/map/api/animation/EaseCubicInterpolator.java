package com.bytedance.map.api.animation;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes21.dex */
public class EaseCubicInterpolator implements Interpolator {
    private static final int ACCURACY = 4096;
    private final PointF mControlPoint1;
    private final PointF mControlPoint2;
    private boolean mEnableOvershoot;
    private int mLastI;

    public static double cubicCurves(double r110, double r111, double r112, double r113, double r210) {
        double r100 = 1.0d - r110;
        double r101 = r110 * r110;
        double r102 = r100 * r100;
        return ((((r102 * r100) * r111) + (((r102 * 3.0d) * r110) * r112)) + (((r100 * 3.0d) * r101) * r113)) + ((r101 * r110) * r210);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r110) {
        int r100 = this.mLastI;
        float r101 = r110;
    L4:
        if (r100 >= 4096) goto L9;
        r101 = (r100 * 1.0f) / 4096.0f;
        if (cubicCurves(r101, AudioStats.AUDIO_AMPLITUDE_NONE, this.mControlPoint1.x, this.mControlPoint2.x, 1.0d) >= r110) goto L7;
        r100 = r100 + 1;
        goto L4
    L7:
        this.mLastI = r100;
    L9:
        double r102 = cubicCurves(r101, AudioStats.AUDIO_AMPLITUDE_NONE, this.mControlPoint1.y, this.mControlPoint2.y, 1.0d);
        if (this.mEnableOvershoot == true) goto L15;
        if (r102 <= 0.999d) goto L15;
        this.mLastI = 0;
        r102 = 1.0d;
    L15:
        return (float) r102;
    }

    public EaseCubicInterpolator(float r100, float r101, float r102, float r103) {
        this.mLastI = 0;
        PointF r104 = new PointF();
        this.mControlPoint1 = r104;
        PointF r105 = new PointF();
        this.mControlPoint2 = r105;
        this.mEnableOvershoot = false;
        r104.x = r100;
        r104.y = r101;
        r105.x = r102;
        r105.y = r103;
    }

    public EaseCubicInterpolator(float r100, float r101, float r102, float r103, boolean r104) {
        this(r100, r101, r102, r103);
        this.mEnableOvershoot = r104;
    }
}
