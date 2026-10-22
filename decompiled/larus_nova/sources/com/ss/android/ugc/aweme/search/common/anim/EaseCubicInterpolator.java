package com.ss.android.ugc.aweme.search.common.anim;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes40.dex */
public class EaseCubicInterpolator implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f451471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f451472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f451473c;

    public static double a(double r110, double r111, double r112) {
        double r100 = 1.0d - r110;
        double r101 = r110 * r110;
        double r102 = r100 * r100;
        return ((((r102 * r100) * AudioStats.AUDIO_AMPLITUDE_NONE) + (((r102 * 3.0d) * r110) * r111)) + (((r100 * 3.0d) * r101) * r112)) + ((r101 * r110) * 1.0d);
    }

    public EaseCubicInterpolator() {
        this.f451471a = 0;
        this.f451472b = new PointF();
        this.f451473c = new PointF();
    }

    public EaseCubicInterpolator(int r100) {
        this.f451471a = 0;
        PointF r101 = new PointF();
        this.f451472b = r101;
        PointF r102 = new PointF();
        this.f451473c = r102;
        r101.x = 0.65f;
        r101.y = 0.0f;
        r102.x = 0.35f;
        r102.y = 1.0f;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        int r101 = this.f451471a;
        float r102 = r100;
    L4:
        if (r101 >= 4096) goto L9;
        r102 = (r101 * 1.0f) / 4096.0f;
        if (a(r102, this.f451472b.x, this.f451473c.x) >= r100) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        this.f451471a = r101;
    L9:
        double r103 = a(r102, this.f451472b.y, this.f451473c.y);
        if (r103 <= 0.999d) goto L13;
        this.f451471a = 0;
        r103 = 1.0d;
    L13:
        return (float) r103;
    }
}
