package com.ss.android.lark.reaction.widget.detailwindow.scroller;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes37.dex */
public final class k {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final float[] f439313y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final float f439314z = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Interpolator f439315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f439316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f439317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f439318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f439319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f439320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f439321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f439322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f439323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f439324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f439325k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f439326l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f439327m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f439328n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f439329o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f439330p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f439331q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f439332r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f439333s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f439334t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f439335u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f439336v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f439337w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f439338x;

    public static class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final float f439339a = 0.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final float f439340b = 0.0f;

        public a() {
        }

        static {
            float r100 = 1.0f / a(1.0f);
            f439339a = r100;
            f439340b = 1.0f - (r100 * a(1.0f));
        }

        public static float a(float r100) {
            float r101 = r100 * 8.0f;
            if (r101 >= 1.0f) goto L6;
            return r101 - (1.0f - ((float) Math.exp(-r101)));
        L6:
            return 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - r101))) * 0.63212055f);
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = f439339a * a(r100);
            if (r101 > 0.0f) goto L5;
            return r101;
        L5:
            return r101 + f439340b;
        }
    }

    static {
        f439313y = new float[101];
        f439314z = (float) (Math.log(0.78d) / Math.log(0.9d));
        float r100 = 0.0f;
        float r101 = 0.0f;
        int r102 = 0;
    L4:
        if (r102 >= 100) goto L20;
        float r103 = r102 / 100.0f;
        float r104 = 1.0f;
    L6:
        float r105 = ((r104 - r100) / 2.0f) + r100;
        float r110 = 1.0f - r105;
        float r106 = (r105 * 3.0f) * r110;
        float r111 = (r105 * r105) * r105;
        float r112 = (((0.175f * r110) + (0.35000002f * r105)) * r106) + r111;
        if (Math.abs(r112 - r103) < 1.0E-5d) goto L8;
        if (r112 > r103) goto L18;
        r100 = r105;
        goto L6
    L18:
        r104 = r105;
        goto L6
    L8:
        f439313y[r102] = (r106 * ((r110 * 0.5f) + r105)) + r111;
        float r107 = 1.0f;
    L9:
        float r108 = ((r107 - r101) / 2.0f) + r101;
        float r113 = 1.0f - r108;
        float r109 = (((r108 * 3.0f) * r113) * ((r113 * 0.5f) + r108)) + ((r108 * r108) * r108);
        if (Math.abs(r109 - r103) < 1.0E-5d) goto L11;
        if (r109 > r103) goto L14;
        r101 = r108;
        goto L9
    L14:
        r107 = r108;
        goto L9
    L11:
        r102 = r102 + 1;
        goto L4
    L20:
        f439313y[100] = 1.0f;
    }

    public final boolean a() {
        if (this.f439331q == false) goto L6;
        return false;
    L6:
        int r100 = (int) (AnimationUtils.currentAnimationTimeMillis() - this.f439328n);
        int r101 = this.f439329o;
        if (r100 >= r101) goto L22;
        int r102 = this.f439317c;
        float r103 = 0.0f;
        if (r102 == 0) goto L21;
        if (r102 != 1) goto L23;
        float r104 = r100 / r101;
        int r105 = (int) (r104 * 100.0f);
        if (r105 >= 100) goto L15;
        float r106 = r105 / 100.0f;
        int r107 = r105 + 1;
        float[] r108 = f439313y;
        float r109 = r108[r105];
        float r110 = (r108[r107] - r109) / ((r107 / 100.0f) - r106);
        float r111 = r109 + ((r104 - r106) * r110);
        r103 = r110;
    L16:
        this.f439334t = ((r103 * this.f439335u) / r101) * 1000.0f;
        int r112 = this.f439318d;
        int r113 = r112 + Math.round((this.f439320f - r112) * r111);
        this.f439326l = r113;
        int r114 = Math.min(r113, this.f439323i);
        this.f439326l = r114;
        this.f439326l = Math.max(r114, this.f439322h);
        int r115 = this.f439319e;
        int r116 = r115 + Math.round(r111 * (this.f439321g - r115));
        this.f439327m = r116;
        int r117 = Math.min(r116, this.f439325k);
        this.f439327m = r117;
        int r118 = Math.max(r117, this.f439324j);
        this.f439327m = r118;
        if (this.f439326l != this.f439320f) goto L23;
        if (r118 != this.f439321g) goto L23;
        this.f439331q = true;
        goto L23
    L15:
        r111 = 1.0f;
    L23:
        return true;
    L21:
        float r119 = this.f439315a.getInterpolation(r100 * 0.0f);
        this.f439326l = this.f439318d + Math.round(0.0f * r119);
        this.f439327m = this.f439319e + Math.round(r119 * this.f439330p);
        goto L23
    L22:
        this.f439326l = this.f439320f;
        this.f439327m = this.f439321g;
        this.f439331q = true;
        goto L23
    }

    public k(Context r100, boolean r101) {
        this.f439336v = ViewConfiguration.getScrollFriction();
        this.f439331q = true;
        this.f439315a = new a();
        Resources r102 = r100.getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density * 160.0f;
        this.f439316b = r103;
        float r104 = r103 * 386.0878f;
        this.f439337w = r104 * ViewConfiguration.getScrollFriction();
        this.f439332r = r101;
        this.f439338x = (r103 * 386.0878f) * 0.84f;
    }

    public final void b(int r110, int r111, int r112) {
        if (this.f439332r == true) goto L5;
    L15:
        int r100 = r111;
    L16:
        int r101 = r100;
        int r102 = 0;
    L17:
        this.f439317c = 1;
        this.f439331q = false;
        float r103 = (float) Math.hypot(r102, r101);
        this.f439333s = r103;
        double r104 = Math.log((Math.abs(r103) * 0.35f) / (this.f439336v * this.f439338x));
        float r105 = f439314z;
        this.f439329o = (int) (Math.exp(r104 / (((double) r105) - 1.0d)) * 1000.0d);
        this.f439328n = AnimationUtils.currentAnimationTimeMillis();
        this.f439318d = 0;
        this.f439319e = r110;
        float r106 = 1.0f;
        if (r103 != 0.0f) goto L20;
        float r107 = 1.0f;
    L21:
        if (r103 == 0.0f) goto L24;
        r106 = r101 / r103;
    L24:
        double r108 = r105;
        double r113 = ((double) (this.f439336v * this.f439338x)) * Math.exp((r108 / (r108 - 1.0d)) * Math.log((Math.abs(r103) * 0.35f) / (this.f439336v * this.f439338x)));
        this.f439335u = (int) (((double) Math.signum(r103)) * r113);
        this.f439322h = 0;
        this.f439323i = 0;
        this.f439324j = 0;
        this.f439325k = r112;
        int r109 = 0 + ((int) Math.round(((double) r107) * r113));
        this.f439320f = r109;
        int r114 = Math.min(r109, this.f439323i);
        this.f439320f = r114;
        this.f439320f = Math.max(r114, this.f439322h);
        int r115 = ((int) Math.round(r113 * ((double) r106))) + r110;
        this.f439321g = r115;
        int r116 = Math.min(r115, this.f439325k);
        this.f439321g = r116;
        this.f439321g = Math.max(r116, this.f439324j);
        return;
    L20:
        r107 = r102 / r103;
        goto L21
    L5:
        if (this.f439331q == true) goto L15;
        if (this.f439317c != 1) goto L9;
        float r117 = this.f439334t;
    L10:
        float r118 = this.f439320f - this.f439318d;
        float r119 = this.f439321g - this.f439319e;
        float r120 = (float) Math.hypot(r118, r119);
        float r121 = (r118 / r120) * r117;
        float r122 = (r119 / r120) * r117;
        float r123 = 0;
        if (Math.signum(r123) != Math.signum(r121)) goto L15;
        r100 = r111;
        float r124 = r100;
        if (Math.signum(r124) != Math.signum(r122)) goto L16;
        r102 = (int) (r123 + r121);
        r101 = (int) (r124 + r122);
        goto L17
    L9:
        r117 = this.f439333s - ((this.f439337w * ((int) (AnimationUtils.currentAnimationTimeMillis() - this.f439328n))) / 2000.0f);
        goto L10
    }
}
