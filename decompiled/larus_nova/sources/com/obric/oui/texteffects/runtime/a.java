package com.obric.oui.texteffects.runtime;

import android.view.animation.Interpolator;
import androidx.camera.video.AudioStats;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f403311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f403312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f403313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f403314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f403315e;

    public a() {
        this(0, 0.0f, 0.0f);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r110) {
        if (this.f403311a != 0) goto L5;
        double r100 = r110;
    L6:
        double r101 = RangesKt.coerceIn(r100, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);
        float r111 = this.f403312b;
        boolean r102 = true;
        if (r111 != 0.0f) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L19;
        if (this.f403313c != 0.0f) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L19;
        return (float) r101;
    L14:
        r104 = false;
    L19:
        if (r111 != 0.0f) goto L21;
        boolean r112 = true;
    L22:
        if (r112 == true) goto L24;
        double r105 = ((Math.pow(r101, this.f403314d) - r101) * (1.0d - r101)) + r101;
    L26:
        if (this.f403313c == 0.0f) goto L29;
        r102 = false;
    L29:
        if (r102 == true) goto L32;
        r105 = r105 + (((1.0d - Math.pow(1.0d - r101, this.f403315e)) - r105) * r101);
    L32:
        return (float) r105;
    L24:
        r105 = r101;
        goto L26
    L21:
        r112 = false;
        goto L22
    L9:
        r103 = false;
        goto L10
    L5:
        r100 = 1.0d - ((double) r110);
        goto L6
    }

    public a(int r100, float r110, float r111) {
        this.f403311a = r100;
        this.f403312b = r110;
        this.f403313c = r111;
        if (r110 < 0.0f) goto L5;
        double r101 = ((double) r110) * 1.5d;
    L6:
        this.f403314d = r101 + 1.0d;
        if (r111 < 0.0f) goto L9;
        double r102 = ((double) r111) * 1.5d;
    L10:
        this.f403315e = r102 + 1.0d;
        return;
    L9:
        r102 = ((double) r111) * 0.6d;
        goto L10
    L5:
        r101 = ((double) r110) * 0.6d;
        goto L6
    }
}
