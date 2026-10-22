package k19;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f501392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f501393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f501394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f501395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f501396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f501397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f501398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f501399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f501400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b<d> f501401j;

    public static final class a {
    }

    static {
    }

    public final void a() {
        b<d> r100 = this.f501401j;
        if (r100 == null) goto L5;
        r100.onGestureEnd(this);
    L5:
        int r101 = 0;
        this.f501392a = 0;
        this.f501393b = 0;
    L7:
        if (r101 >= 2) goto L9;
        this.f501394c[r101] = -1;
        this.f501395d[r101] = 0.0f;
        this.f501396e[r101] = 0.0f;
        this.f501397f[r101] = 0.0f;
        this.f501398g[r101] = 0.0f;
        this.f501399h[r101] = 0.0f;
        this.f501400i[r101] = 0.0f;
        r101 = r101 + 1;
        goto L7
    }

    public d() {
        this.f501394c = new int[2];
        this.f501395d = new float[2];
        this.f501396e = new float[2];
        this.f501397f = new float[2];
        this.f501398g = new float[2];
        this.f501399h = new float[2];
        this.f501400i = new float[2];
    }

    public final void b(MotionEvent r100) {
        r100.getAction();
        this.f501393b = this.f501392a;
        int r101 = 0;
        this.f501392a = 0;
    L4:
        if (r101 >= 2) goto L21;
        int r102 = r100.getPointerCount();
        int r103 = r100.getActionMasked();
        int r104 = r100.getActionIndex();
        if (r103 != 1) goto L8;
    L10:
        if (r101 < r104) goto L12;
        int r105 = r101 + 1;
    L14:
        if (r105 < r102) goto L17;
        r105 = -1;
    L17:
        if (r105 != (-1)) goto L19;
        this.f501394c[r101] = -1;
    L20:
        r101 = r101 + 1;
        goto L4
    L19:
        this.f501394c[r101] = r100.getPointerId(r105);
        this.f501399h[r101] = r100.getX(r105);
        float[] r106 = this.f501395d;
        float r107 = this.f501399h[r101];
        r106[r101] = r107;
        this.f501397f[r101] = r107;
        this.f501400i[r101] = r100.getY(r105);
        float[] r108 = this.f501396e;
        float r109 = this.f501400i[r101];
        r108[r101] = r109;
        this.f501398g[r101] = r109;
        this.f501392a++;
    L12:
        r105 = r101;
        goto L14
    L8:
        if (r103 == 6) goto L10;
    }
}
