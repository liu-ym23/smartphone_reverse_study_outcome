package rp9;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f538891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f538892b;

    public static float a(float r100, float r101, float r102) {
        if (r100 != 0.0f) goto L5;
    L9:
        return r100;
    L5:
        if (r100 == 1.0f) goto L9;
        float r103 = ((r101 - 0.0f) * r100) + 0.0f;
        float r104 = r101 + ((r102 - r101) * r100);
        float r105 = r103 + ((r104 - r103) * r100);
        return r105 + (((r104 + (((r102 + ((1.0f - r102) * r100)) - r104) * r100)) - r105) * r100);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r110) {
        float r100 = 0.0f;
        if (r110 <= 0.0f) goto L31;
        if (r110 < 1.0f) goto L8;
        r100 = 1.0f;
        goto L31
    L8:
        int r101 = 0;
        r100 = r110;
        float r102 = 0.0f;
        float r103 = 0.0f;
        float r104 = 1.0f;
        int r105 = 0;
    L10:
        if (r105 >= 8) goto L23;
        r103 = a(r100, this.f538891a.x, this.f538892b.x);
        double r106 = (a(r100 + 1.0E-6f, this.f538891a.x, this.f538892b.x) - r103) / 1.0E-6f;
        float r111 = r103 - r110;
        if (Math.abs(r111) < 1.0E-6f) goto L31;
        if (Math.abs(r106) < 9.999999974752427E-7d) goto L23;
        if (r103 >= r110) goto L20;
        r102 = r100;
    L21:
        r100 = (float) (((double) r100) - (((double) r111) / r106));
        r105 = r105 + 1;
        goto L10
    L20:
        r104 = r100;
    L23:
        if (Math.abs(r103 - r110) <= 1.0E-6f) goto L31;
        if (r101 >= 8) goto L31;
        if (r103 >= r110) goto L28;
        r102 = r100;
        r100 = (r100 + r104) / 2.0f;
    L29:
        r103 = a(r100, this.f538891a.x, this.f538892b.x);
        r101 = r101 + 1;
        goto L23
    L28:
        r104 = r100;
        r100 = (r100 + r102) / 2.0f;
    L31:
        return a(r100, this.f538891a.y, this.f538892b.y);
    }

    public b(PointF r100, PointF r101) {
        float r102 = r100.x;
        boolean r103 = true;
        if (r102 >= 0.0f) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L21;
        float r105 = r101.x;
        if (r105 >= 0.0f) goto L12;
    L14:
        r103 = false;
    L15:
        if (r103 == false) goto L19;
        this.f538891a = r100;
        this.f538892b = r101;
        new PointF();
        new PointF();
        new PointF();
        return;
    L19:
        throw new RuntimeException("endX should be in [0, 1]");
    L12:
        if (r105 > 1.0f) goto L14;
    L21:
        throw new RuntimeException("startX should be in [0, 1]");
    L5:
        if (r102 > 1.0f) goto L7;
        r104 = true;
        goto L8
    }
}
