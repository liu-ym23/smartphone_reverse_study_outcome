package wj6;

import android.view.MotionEvent;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements b<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b<e> f560031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f560032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Integer> f560033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f560034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f560035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f560036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f560037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f560038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f560039i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f560040j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f560041k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f560042l;

    public static final class a {
    }

    static {
    }

    public e() {
        d r100 = new d();
        this.f560032b = r100;
        this.f560033c = new ArrayList();
        this.f560034d = 1.0f;
        this.f560041k = 1.0f;
        r100.f560030j = this;
    }

    public final boolean b(MotionEvent r100) {
        d r101 = this.f560032b;
        r101.getClass();
        int r102 = r100.getActionMasked();
        if (r102 == 0) goto L39;
        if (r102 != 1) goto L6;
        r101.b(r100);
        if (r101.f560021a != 0) goto L36;
        r101.a();
    L43:
        return true;
    L36:
        b<d> r103 = r101.f560030j;
        if (r103 == null) goto L43;
        r103.onGestureUpdate(r101);
        goto L43
    L6:
        if (r102 != 2) goto L8;
        r101.f560022b = r101.f560021a;
        int r104 = 0;
    L25:
        if (r104 >= 2) goto L30;
        int r105 = r100.findPointerIndex(r101.f560023c[r104]);
        if (r105 == (-1)) goto L29;
        float[] r106 = r101.f560028h;
        float[] r107 = r101.f560026f;
        r106[r104] = r107[r104];
        r101.f560029i[r104] = r101.f560027g[r104];
        r107[r104] = r100.getX(r105);
        r101.f560027g[r104] = r100.getY(r105);
    L29:
        r104 = r104 + 1;
        goto L25
    L30:
        b<d> r108 = r101.f560030j;
        if (r108 == null) goto L43;
        r108.onGestureUpdate(r101);
        goto L43
    L8:
        if (r102 != 3) goto L10;
        r101.a();
        goto L43
    L10:
        if (r102 != 5) goto L12;
        r101.b(r100);
        b<d> r109 = r101.f560030j;
        if (r109 == null) goto L43;
        r109.onGestureUpdate(r101);
        goto L43
    L12:
        if (r102 != 6) goto L43;
        r101.b(r100);
        if (r101.f560021a != 0) goto L17;
        r101.a();
        goto L43
    L17:
        b<d> r110 = r101.f560030j;
        if (r110 == null) goto L43;
        r110.onGestureUpdate(r101);
        goto L43
    L39:
        b<d> r111 = r101.f560030j;
        if (r111 == null) goto L42;
        r111.onGestureBegin(r101);
    L42:
        r101.b(r100);
        goto L43
    }

    @Override // wj6.b
    public final void onGestureBegin(d r100) {
        b<e> r101 = this.f560031a;
        if (r101 == null) goto L6;
        r101.onGestureBegin(this);
        return;
    }

    @Override // wj6.b
    public final void onGestureEnd(d r100) {
        b<e> r101 = this.f560031a;
        if (r101 == null) goto L5;
        r101.onGestureEnd(this);
    L5:
        this.f560034d = 1.0f;
        this.f560035e = 0.0f;
        this.f560036f = 0.0f;
        this.f560037g = 0.0f;
        this.f560038h = 0.0f;
        this.f560039i = 0.0f;
        this.f560040j = 0.0f;
        this.f560041k = 1.0f;
        this.f560042l = 0;
    }

    @Override // wj6.b
    public final void onGestureUpdate(d r110) {
        d r111 = r110;
        if (this.f560032b.f560021a != 1) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        float[] r101 = r111.f560024d;
        float r102 = r101[1] - r101[0];
        float[] r103 = r111.f560025e;
        float r104 = r103[1] - r103[0];
        float[] r105 = r111.f560026f;
        float r106 = r105[1] - r105[0];
        float[] r107 = r111.f560027g;
        float r108 = r107[1] - r107[0];
        float r109 = (float) Math.hypot(r102, r104);
        float r112 = (float) Math.hypot(r106, r108);
        float r113 = this.f560034d;
        float r114 = r112 / r109;
        this.f560034d = r114;
        this.f560041k = r114 / r113;
        this.f560037g = a(r111.f560026f, r111.f560021a);
        this.f560038h = a(r111.f560027g, r111.f560021a);
    L9:
        float r115 = a(r111.f560026f, r111.f560021a) - a(r111.f560028h, r111.f560021a);
        this.f560039i = r115;
        this.f560035e += r115;
        float r116 = a(r111.f560027g, r111.f560021a) - a(r111.f560029i, r111.f560021a);
        this.f560040j = r116;
        this.f560036f += r116;
        if (this.f560032b.f560021a != 1) goto L12;
        boolean r117 = true;
    L13:
        if (r117 == true) goto L15;
        this.f560042l = -1;
    L39:
        b<e> r118 = this.f560031a;
        if (r118 == null) goto L43;
        r118.onGestureUpdate(this);
        return;
    L43:
        return;
    L15:
        if (this.f560042l != 0) goto L39;
        if ((Math.abs(this.f560035e) - Math.abs(this.f560036f)) < 0) goto L29;
        if (this.f560035e >= (-10)) goto L24;
        if (this.f560033c.contains(1) == true) goto L24;
        this.f560042l = 1;
    L24:
        if (this.f560035e <= 10) goto L39;
        if (this.f560033c.contains(3) == true) goto L39;
        this.f560042l = 3;
        goto L39
    L29:
        if (this.f560036f >= (-10)) goto L34;
        if (this.f560033c.contains(2) == true) goto L34;
        this.f560042l = 2;
    L34:
        if (this.f560036f <= 10) goto L39;
        if (this.f560033c.contains(4) == true) goto L39;
        this.f560042l = 4;
        goto L39
    L12:
        r117 = false;
        goto L13
    L8:
        this.f560034d = 1.0f;
        this.f560041k = 1.0f;
        goto L9
    L5:
        r100 = false;
        goto L6
    }

    public final float a(float[] r100, int r101) {
        int r102 = 0;
        float r103 = 0.0f;
    L3:
        if (r102 >= r101) goto L5;
        r103 = r103 + r100[r102];
        r102 = r102 + 1;
        goto L3
    L5:
        if (r101 > 0) goto L7;
        return 0.0f;
    L7:
        return r103 / r101;
    }
}
