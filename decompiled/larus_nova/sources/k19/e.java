package k19;

import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class e implements b<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<b<e>> f501402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f501403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Integer> f501404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f501405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f501406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f501407f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f501408g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f501409h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f501410i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f501411j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f501412k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f501413l;

    public static final class a {
    }

    static {
    }

    public e() {
        this.f501402a = new LinkedList();
        d r100 = new d();
        this.f501403b = r100;
        this.f501404c = new ArrayList();
        this.f501405d = 1.0f;
        this.f501412k = 1.0f;
        r100.f501401j = this;
    }

    public final boolean b(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        d r101 = this.f501403b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        int r102 = r100.getActionMasked();
        if (r102 == 0) goto L39;
        if (r102 != 1) goto L6;
        r101.b(r100);
        if (r101.f501392a != 0) goto L36;
        r101.a();
    L43:
        return true;
    L36:
        b<d> r103 = r101.f501401j;
        if (r103 == null) goto L43;
        r103.onGestureUpdate(r101);
        goto L43
    L6:
        if (r102 != 2) goto L8;
        r101.f501393b = r101.f501392a;
        int r104 = 0;
    L25:
        if (r104 >= 2) goto L30;
        int r105 = r100.findPointerIndex(r101.f501394c[r104]);
        if (r105 == (-1)) goto L29;
        float[] r106 = r101.f501399h;
        float[] r107 = r101.f501397f;
        r106[r104] = r107[r104];
        r101.f501400i[r104] = r101.f501398g[r104];
        r107[r104] = r100.getX(r105);
        r101.f501398g[r104] = r100.getY(r105);
    L29:
        r104 = r104 + 1;
        goto L25
    L30:
        b<d> r108 = r101.f501401j;
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
        b<d> r109 = r101.f501401j;
        if (r109 == null) goto L43;
        r109.onGestureUpdate(r101);
        goto L43
    L12:
        if (r102 != 6) goto L43;
        r101.b(r100);
        if (r101.f501392a != 0) goto L17;
        r101.a();
        goto L43
    L17:
        b<d> r110 = r101.f501401j;
        if (r110 == null) goto L43;
        r110.onGestureUpdate(r101);
        goto L43
    L39:
        b<d> r111 = r101.f501401j;
        if (r111 == null) goto L42;
        r111.onGestureBegin(r101);
    L42:
        r101.b(r100);
        goto L43
    }

    @Override // k19.b
    public final void onGestureBegin(d r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        Iterator<T> r101 = this.f501402a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).onGestureBegin(this);
        goto L4
    }

    @Override // k19.b
    public final void onGestureEnd(d r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        Iterator<T> r101 = this.f501402a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).onGestureEnd(this);
        goto L4
    L6:
        this.f501405d = 1.0f;
        this.f501406e = 0.0f;
        this.f501407f = 0.0f;
        this.f501408g = 0.0f;
        this.f501409h = 0.0f;
        this.f501410i = 0.0f;
        this.f501411j = 0.0f;
        this.f501412k = 1.0f;
        this.f501413l = 0;
    }

    @Override // k19.b
    public final void onGestureUpdate(d r110) {
        d r111 = r110;
        Intrinsics.checkNotNullParameter(r111, "detector");
        boolean r100 = false;
        if (this.f501403b.f501392a != 1) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        float[] r102 = r111.f501395d;
        float r103 = r102[1] - r102[0];
        float[] r104 = r111.f501396e;
        float r105 = r104[1] - r104[0];
        float[] r106 = r111.f501397f;
        float r107 = r106[1] - r106[0];
        float[] r108 = r111.f501398g;
        float r109 = r108[1] - r108[0];
        float r112 = (float) Math.hypot(r103, r105);
        float r113 = (float) Math.hypot(r107, r109);
        float r114 = this.f501405d;
        float r115 = r113 / r112;
        this.f501405d = r115;
        this.f501412k = r115 / r114;
        this.f501408g = a(r111.f501397f, r111.f501392a);
        this.f501409h = a(r111.f501398g, r111.f501392a);
    L9:
        float r116 = a(r111.f501397f, r111.f501392a) - a(r111.f501399h, r111.f501392a);
        this.f501410i = r116;
        this.f501406e += r116;
        float r117 = a(r111.f501398g, r111.f501392a) - a(r111.f501400i, r111.f501392a);
        this.f501411j = r117;
        this.f501407f += r117;
        if (this.f501403b.f501392a != 1) goto L12;
        r100 = true;
    L12:
        if (r100 == true) goto L14;
        this.f501413l = -1;
    L38:
        Iterator<T> r118 = this.f501402a.iterator();
    L40:
        if (r118.hasNext() == false) goto L42;
        ((b) r118.next()).onGestureUpdate(this);
        goto L40
    L42:
        return;
    L14:
        if (this.f501413l != 0) goto L38;
        if ((Math.abs(this.f501406e) - Math.abs(this.f501407f)) < 0.0f) goto L28;
        if (this.f501406e >= (-10.0f)) goto L23;
        if (this.f501404c.contains(1) == true) goto L23;
        this.f501413l = 1;
    L23:
        if (this.f501406e <= 10.0f) goto L38;
        if (this.f501404c.contains(3) == true) goto L38;
        this.f501413l = 3;
        goto L38
    L28:
        if (this.f501407f >= (-10.0f)) goto L33;
        if (this.f501404c.contains(2) == true) goto L33;
        this.f501413l = 2;
    L33:
        if (this.f501407f <= 10.0f) goto L38;
        if (this.f501404c.contains(4) == true) goto L38;
        this.f501413l = 4;
        goto L38
    L8:
        this.f501405d = 1.0f;
        this.f501412k = 1.0f;
        goto L9
    L5:
        r101 = false;
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
