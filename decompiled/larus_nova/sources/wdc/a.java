package wdc;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f559314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f559315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f559316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f559317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f559318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f559319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f559320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f559321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f559322i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f559323j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f559324k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f559325l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f559326m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f559327n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f559328o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f559329p;

    public final int a() {
        if (this.f559323j == false) goto L9;
        int r100 = this.f559328o;
        if (r100 < 0) goto L8;
        return r100;
    L8:
        return this.f559320g;
    L9:
        int r101 = this.f559328o;
        if (r101 < 0) goto L13;
        return r101;
    L13:
        return this.f559321h;
    }

    public final boolean b() {
        if (this.f559318e <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public a() {
        this.f559314a = 0;
        this.f559315b = new PointF();
        this.f559318e = 0;
        this.f559319f = 0;
        this.f559322i = 0;
        this.f559323j = true;
        this.f559324k = 1.2f;
        this.f559325l = 1.7f;
        this.f559326m = 1.7f;
        this.f559327n = false;
        this.f559328o = -1;
        this.f559329p = 0;
    }
}
