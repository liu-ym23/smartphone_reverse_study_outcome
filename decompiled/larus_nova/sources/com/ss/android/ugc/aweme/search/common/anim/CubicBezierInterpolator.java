package com.ss.android.ugc.aweme.search.common.anim;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes40.dex */
public class CubicBezierInterpolator implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f451466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f451467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f451468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PointF f451469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PointF f451470e;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r110) {
        int r100 = 1;
        float r101 = r110;
    L4:
        if (r100 >= 14) goto L9;
        PointF r102 = this.f451470e;
        PointF r103 = this.f451466a;
        float r104 = r103.x * 3.0f;
        r102.x = r104;
        PointF r105 = this.f451469d;
        float r106 = ((this.f451467b.x - r103.x) * 3.0f) - r104;
        r105.x = r106;
        PointF r107 = this.f451468c;
        float r108 = (1.0f - r102.x) - r106;
        r107.x = r108;
        float r109 = ((r102.x + ((r105.x + (r108 * r101)) * r101)) * r101) - r110;
        if (Math.abs(r109) < 0.001d) goto L9;
        r101 = r101 - (r109 / (this.f451470e.x + (((this.f451469d.x * 2.0f) + ((this.f451468c.x * 3.0f) * r101)) * r101)));
        r100 = r100 + 1;
    L9:
        PointF r111 = this.f451470e;
        PointF r112 = this.f451466a;
        float r113 = r112.y * 3.0f;
        r111.y = r113;
        PointF r114 = this.f451469d;
        float r115 = ((this.f451467b.y - r112.y) * 3.0f) - r113;
        r114.y = r115;
        PointF r116 = this.f451468c;
        float r117 = (1.0f - r111.y) - r115;
        r116.y = r117;
        return r101 * (r111.y + ((r114.y + (r117 * r101)) * r101));
    }

    public CubicBezierInterpolator(float r100, float r101, float r102) {
        PointF r103 = new PointF(r100, r101);
        PointF r104 = new PointF(r102, 1.0f);
        this.f451468c = new PointF();
        this.f451469d = new PointF();
        this.f451470e = new PointF();
        float r105 = r103.x;
        if (r105 < 0.0f) goto L15;
        if (r105 > 1.0f) goto L15;
        float r106 = r104.x;
        if (r106 < 0.0f) goto L13;
        if (r106 > 1.0f) goto L13;
        this.f451466a = r103;
        this.f451467b = r104;
        return;
    L13:
        throw new IllegalArgumentException("endX value must be in the range [0, 1]");
    L15:
        throw new IllegalArgumentException("startX value must be in the range [0, 1]");
    }
}
