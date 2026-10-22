package com.bytedance.awemeopen.apps.framework.feed.follow.util;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f194774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f194775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f194776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PointF f194777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PointF f194778e;

    public a() {
        PointF r100 = new PointF(0.33f, 1.0f);
        PointF r101 = new PointF(0.68f, 1.0f);
        this.f194776c = new PointF();
        this.f194777d = new PointF();
        this.f194778e = new PointF();
        float r102 = r100.x;
        if (r102 < 0.0f) goto L15;
        if (r102 > 1.0f) goto L15;
        float r103 = r101.x;
        if (r103 < 0.0f) goto L13;
        if (r103 > 1.0f) goto L13;
        this.f194774a = r100;
        this.f194775b = r101;
        return;
    L13:
        throw new IllegalArgumentException("endX value must be in the range [0, 1]");
    L15:
        throw new IllegalArgumentException("startX value must be in the range [0, 1]");
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r110) {
        int r100 = 1;
        float r101 = r110;
    L4:
        if (r100 >= 14) goto L9;
        PointF r102 = this.f194778e;
        PointF r103 = this.f194774a;
        float r104 = r103.x * 3.0f;
        r102.x = r104;
        PointF r105 = this.f194777d;
        float r106 = ((this.f194775b.x - r103.x) * 3.0f) - r104;
        r105.x = r106;
        PointF r107 = this.f194776c;
        float r108 = (1.0f - r102.x) - r106;
        r107.x = r108;
        float r109 = ((r102.x + ((r105.x + (r108 * r101)) * r101)) * r101) - r110;
        if (Math.abs(r109) < 0.001d) goto L9;
        r101 = r101 - (r109 / (this.f194778e.x + (((this.f194777d.x * 2.0f) + ((this.f194776c.x * 3.0f) * r101)) * r101)));
        r100 = r100 + 1;
    L9:
        PointF r111 = this.f194778e;
        PointF r112 = this.f194774a;
        float r113 = r112.y * 3.0f;
        r111.y = r113;
        PointF r114 = this.f194777d;
        float r115 = ((this.f194775b.y - r112.y) * 3.0f) - r113;
        r114.y = r115;
        PointF r116 = this.f194776c;
        float r117 = (1.0f - r111.y) - r115;
        r116.y = r117;
        return r101 * (r111.y + ((r114.y + (r117 * r101)) * r101));
    }
}
