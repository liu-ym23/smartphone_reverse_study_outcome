package com.larus.utils;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes31.dex */
public final class CubicBezierInterpolator implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f375336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f375337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f375338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f375339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f375340e;

    public static final enum CurveType extends Enum<CurveType> {
        public static final CurveType EXPO_EASE_IN_OUT = null;
        public static final CurveType LINEAR = null;
        public static final CurveType QUAD_EASE_IN = null;
        public static final CurveType SINE_EASE_IN = null;
        public static final CurveType SINE_EASE_IN_OUT = null;
        public static final CurveType SINE_EASE_OUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CurveType[] f375341a = null;
        final float endX;
        final float endY;
        final float startX;
        final float startY;

        static {
            CurveType r100 = new CurveType("LINEAR", 0, 0.0f, 0.0f, 1.0f, 1.0f);
            LINEAR = r100;
            CurveType r101 = new CurveType("SINE_EASE_IN", 1, 0.47f, 0.0f, 0.745f, 0.715f);
            SINE_EASE_IN = r101;
            CurveType r102 = new CurveType("SINE_EASE_OUT", 2, 0.39f, 0.575f, 0.565f, 1.0f);
            SINE_EASE_OUT = r102;
            CurveType r103 = new CurveType("SINE_EASE_IN_OUT", 3, 0.445f, 0.05f, 0.55f, 0.95f);
            SINE_EASE_IN_OUT = r103;
            CurveType r104 = new CurveType("QUAD_EASE_IN", 4, 0.26f, 0.0f, 0.6f, 0.2f);
            QUAD_EASE_IN = r104;
            CurveType r105 = new CurveType("EXPO_EASE_IN_OUT", 5, 0.9f, 0.0f, 0.1f, 1.0f);
            EXPO_EASE_IN_OUT = r105;
            f375341a = new CurveType[]{r100, r101, r102, r103, r104, r105};
        }

        public static CurveType[] values() {
            return (CurveType[]) f375341a.clone();
        }

        public static CurveType valueOf(String r100) {
            return (CurveType) r27.a.a(CurveType.class, r100);
        }

        public CurveType(String r100, int r101, float r102, float r103, float r104, float r105) {
            super(r100, r101);
            this.startX = r102;
            this.startY = r103;
            this.endX = r104;
            this.endY = r105;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f375342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f375343b;

        public a() {
        }

        public a(float r100, float r101) {
            this.f375342a = r100;
            this.f375343b = r101;
        }
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r110) {
        int r100 = 0;
        float r101 = r110;
    L4:
        if (r100 >= 14) goto L9;
        float r102 = ((this.f375340e.f375342a + ((this.f375339d.f375342a + (this.f375338c.f375342a * r101)) * r101)) * r101) - r110;
        if (Math.abs(r102) < 0.001d) goto L9;
        r101 = r101 - (r102 / (this.f375340e.f375342a + (((this.f375339d.f375342a * 2.0f) + ((this.f375338c.f375342a * 3.0f) * r101)) * r101)));
        r100 = r100 + 1;
    L9:
        a r111 = this.f375340e;
        a r103 = this.f375336a;
        float r104 = r103.f375342a * 3.0f;
        r111.f375342a = r104;
        a r105 = this.f375339d;
        a r106 = this.f375337b;
        float r107 = ((r106.f375342a - r103.f375342a) * 3.0f) - r104;
        r105.f375342a = r107;
        a r108 = this.f375338c;
        r108.f375342a = (1.0f - r111.f375342a) - r107;
        float r109 = r103.f375343b * 3.0f;
        r111.f375343b = r109;
        float r112 = ((r106.f375343b - r103.f375343b) * 3.0f) - r109;
        r105.f375343b = r112;
        float r113 = (1.0f - r111.f375343b) - r112;
        r108.f375343b = r113;
        return r101 * (r111.f375343b + ((r105.f375343b + (r113 * r101)) * r101));
    }

    public CubicBezierInterpolator(float r100, float r101, float r102) {
        a r103 = new a(r100, r101);
        a r104 = new a(r102, 1.0f);
        this.f375338c = new a();
        this.f375339d = new a();
        this.f375340e = new a();
        float r105 = r103.f375342a;
        if (r105 < 0.0f) goto L15;
        if (r105 > 1.0f) goto L15;
        float r106 = r104.f375342a;
        if (r106 < 0.0f) goto L13;
        if (r106 > 1.0f) goto L13;
        this.f375336a = r103;
        this.f375337b = r104;
        return;
    L13:
        throw new IllegalArgumentException("Point x value must be in the range [0, 1]");
    L15:
        throw new IllegalArgumentException("Point x value must be in the range [0, 1]");
    }
}
