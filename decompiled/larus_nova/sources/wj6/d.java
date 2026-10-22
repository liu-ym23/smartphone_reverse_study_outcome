package wj6;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f560021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f560022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f560023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f560024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f560025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f560026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f560027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f560028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f560029i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b<d> f560030j;

    public static final class a {
    }

    static {
    }

    public final void a() {
        b<d> r100 = this.f560030j;
        if (r100 == null) goto L5;
        r100.onGestureEnd(this);
    L5:
        int r101 = 0;
        this.f560021a = 0;
        this.f560022b = 0;
    L7:
        if (r101 >= 2) goto L9;
        this.f560023c[r101] = -1;
        this.f560024d[r101] = 0.0f;
        this.f560025e[r101] = 0.0f;
        this.f560026f[r101] = 0.0f;
        this.f560027g[r101] = 0.0f;
        this.f560028h[r101] = 0.0f;
        this.f560029i[r101] = 0.0f;
        r101 = r101 + 1;
        goto L7
    }

    public d() {
        this.f560023c = new int[2];
        this.f560024d = new float[2];
        this.f560025e = new float[2];
        this.f560026f = new float[2];
        this.f560027g = new float[2];
        this.f560028h = new float[2];
        this.f560029i = new float[2];
    }

    public final void b(MotionEvent r100) {
        this.f560022b = this.f560021a;
        int r101 = 0;
        this.f560021a = 0;
    L4:
        if (r101 >= 2) goto L20;
        int r102 = r100.getPointerCount();
        int r103 = r100.getActionMasked();
        int r104 = r100.getActionIndex();
        if (r103 != 1) goto L8;
    L9:
        if (r101 < r104) goto L11;
        int r105 = r101 + 1;
    L13:
        if (r105 < r102) goto L16;
        r105 = -1;
    L16:
        if (r105 != (-1)) goto L18;
        this.f560023c[r101] = -1;
    L19:
        r101 = r101 + 1;
        goto L4
    L18:
        this.f560023c[r101] = r100.getPointerId(r105);
        this.f560028h[r101] = r100.getX(r105);
        float[] r106 = this.f560024d;
        float r107 = this.f560028h[r101];
        r106[r101] = r107;
        this.f560026f[r101] = r107;
        this.f560029i[r101] = r100.getY(r105);
        float[] r108 = this.f560025e;
        float r109 = this.f560029i[r101];
        r108[r101] = r109;
        this.f560027g[r101] = r109;
        this.f560021a++;
    L11:
        r105 = r101;
        goto L13
    L8:
        if (r103 != 6) goto L11;
    }
}
