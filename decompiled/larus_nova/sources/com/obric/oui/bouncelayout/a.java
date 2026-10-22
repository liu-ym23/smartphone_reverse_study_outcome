package com.obric.oui.bouncelayout;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.AbsListView;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbsListView f399019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f399020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<BounceEdgeEffect> f399021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<BounceEdgeEffect> f399022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f399023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f399024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Float> f399025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f399026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f399027i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f399028j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f399029k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f399030l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f399031m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f399032n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f399033o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f399034p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f399035q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f399036r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public VelocityTracker f399037s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f399038t;

    /* JADX INFO: renamed from: com.obric.oui.bouncelayout.a$a, reason: collision with other inner class name */
    public static final class C4667a {
    }

    static {
    }

    public final void l() {
        boolean r100 = false;
        this.f399033o = false;
        int r101 = this.f399034p;
        VelocityTracker r102 = this.f399037s;
        if (r102 == null) goto L9;
        if (r101 == (-1)) goto L9;
        r102.computeCurrentVelocity(1000, this.f399028j);
        float r103 = r102.getYVelocity(r101);
        if (Math.abs(r103) < this.f399027i) goto L9;
        int r104 = MathKt.roundToInt(-r103);
    L11:
        BounceEdgeEffect r105 = this.f399021c.invoke();
        BounceEdgeEffect r106 = this.f399022d.invoke();
        boolean r107 = b(r105);
        boolean r108 = b(r106);
        if (r107 == false) goto L15;
        if (r108 == true) goto L15;
    L24:
        byte r109 = 0;
    L32:
        this.f399034p = -1;
        this.f399038t = -1;
        int r110 = c.f399049a;
        BounceEdgeEffect r111 = this.f399021c.invoke();
        BounceEdgeEffect r112 = this.f399022d.invoke();
        if (r104 == 0) goto L73;
        if (r109 != 0) goto L39;
        if (r104 >= 0) goto L39;
        if (r111 == null) goto L82;
        r111.onAbsorb(r104);
    L82:
        if (r100 == true) goto L84;
        this.f399024f.invoke();
    L84:
        VelocityTracker r113 = this.f399037s;
        if (r113 == null) goto L88;
        r113.recycle();
    L88:
        this.f399037s = null;
        this.f399019a.invalidate();
        return;
    L39:
        if (r109 != 1) goto L44;
        if (r104 <= 0) goto L44;
        if (r112 == null) goto L82;
        r112.onAbsorb(r104);
    L44:
        if (r104 > 0) goto L46;
    L48:
        if (r104 < 0) goto L50;
    L53:
        if (r109 != 1) goto L58;
        if (r104 >= 0) goto L58;
        if (r112 == null) goto L82;
        r112.onRelease();
    L58:
        if (r109 != 0) goto L63;
        if (r104 <= 0) goto L63;
        if (r111 == null) goto L82;
        r111.onRelease();
    L63:
        if (r109 != (-1)) goto L68;
        if (r104 <= 0) goto L68;
        if (r112 == null) goto L82;
        r112.onAbsorb(r104);
    L68:
        if (r109 != (-1)) goto L73;
        if (r104 >= 0) goto L73;
        if (r111 == null) goto L82;
        r111.onAbsorb(r104);
        goto L82
    L50:
        if (this.f399019a.canScrollList(-1) == false) goto L53;
        this.f399019a.fling(r104);
    L52:
        r100 = true;
        goto L82
    L46:
        if (this.f399019a.canScrollList(1) == false) goto L48;
        this.f399019a.fling(r104);
    L73:
        if (r109 == 0) goto L79;
        if (r109 != 1) goto L82;
        if (r112 == null) goto L82;
        r112.onRelease();
        goto L82
    L79:
        if (r111 == null) goto L82;
        r111.onRelease();
    L15:
        if (r108 == false) goto L19;
        if (r107 == true) goto L19;
    L30:
        r109 = 1;
    L19:
        if (r105 != null) goto L21;
        float r114 = 0.0f;
    L23:
        if (r114 > 0.0f) goto L24;
        if (r106 != null) goto L27;
        float r115 = 0.0f;
    L29:
        if (r115 < 0.0f) goto L30;
        r109 = -1;
        goto L32
    L27:
        r115 = r106.f398883f;
        goto L29
    L21:
        r114 = r105.f398883f;
    L9:
        r104 = 0;
        goto L11
    }

    public static boolean b(BounceEdgeEffect r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getDistance() != 0.0f) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
    L16:
        return true;
    L10:
        if (r100.f398883f != 0.0f) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L16;
        if (r100.isFinished() == false) goto L16;
        return false;
    L12:
        r102 = false;
        goto L13
    L7:
        r101 = false;
        goto L8
    }

    public final int a(int r110) {
        if (r110 != 0) goto L4;
    L49:
        return r110;
    L4:
        if (this.f399019a.getChildCount() == 0) goto L49;
        if (this.f399019a.canScrollList(r110) == false) goto L49;
        int r100 = RangesKt.coerceAtLeast(((this.f399019a.getHeight() - this.f399019a.getListPaddingTop()) - this.f399019a.getListPaddingBottom()) - 1, 1);
        int r101 = this.f399019a.getChildCount();
        int r102 = 0;
        int r103 = Integer.MAX_VALUE;
    L9:
        if (r102 >= r101) goto L15;
        int r104 = r102 + 1;
        int r105 = this.f399019a.getChildAt(r102).getHeight();
        if (r105 <= 0) goto L14;
        if (r105 >= r103) goto L14;
        r103 = r105;
    L14:
        r102 = r104;
        goto L9
    L15:
        if (r103 == Integer.MAX_VALUE) goto L18;
        r100 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r103 / 2, 1), r100);
    L18:
        int r106 = 0;
    L19:
        if (r110 == 0) goto L49;
        if (this.f399019a.canScrollList(r110) == false) goto L49;
        if (r110 <= 0) goto L24;
        int r107 = RangesKt.coerceAtMost(r110, r100);
    L25:
        int r108 = this.f399019a.getChildCount();
        int[] r109 = new int[r108];
        int r111 = 0;
    L26:
        if (r111 >= r108) goto L28;
        r109[r111] = this.f399019a.getFirstVisiblePosition() + r111;
        r111 = r111 + 1;
        goto L26
    L28:
        int[] r112 = new int[r108];
        int r113 = 0;
    L29:
        if (r113 >= r108) goto L31;
        r112[r113] = this.f399019a.getChildAt(r113).getTop();
        r113 = r113 + 1;
        goto L29
    L31:
        this.f399019a.scrollListBy(r107);
        int r114 = this.f399019a.getChildCount();
        int r115 = 0;
    L32:
        if (r115 >= r114) goto L37;
        int r116 = r115 + 1;
        int r117 = ArraysKt.indexOf(r109, this.f399019a.getFirstVisiblePosition() + r115);
        if (r117 >= 0) goto L35;
        r115 = r116;
        goto L32
    L35:
        Integer r118 = Integer.valueOf(r112[r117] - this.f399019a.getChildAt(r115).getTop());
    L38:
        if (r118 == null) goto L39;
        r106 = r106 + 1;
        if (r107 <= 0) goto L43;
        int r119 = RangesKt.coerceIn(r118.intValue(), 0, r107);
    L44:
        if (r119 == 0) goto L49;
        r110 = r110 - r119;
        if (r106 <= ((this.f399019a.getCount() + this.f399019a.getChildCount()) + 1)) goto L19;
        return 0;
    L43:
        r119 = RangesKt.coerceIn(r118.intValue(), r107, 0);
        goto L44
    L39:
        int r120 = c.f399049a;
        goto L49
    L37:
        r118 = null;
        goto L38
    L24:
        r107 = RangesKt.coerceAtLeast(r110, -r100);
        goto L25
    }

    public final void c(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f399029k = false;
        this.f399030l = false;
        this.f399033o = false;
        this.f399034p = r100.getPointerId(0);
        float r101 = r100.getY(0);
        this.f399035q = r101;
        this.f399036r = r101;
        this.f399038t = -1;
        VelocityTracker r102 = this.f399037s;
        if (r102 != null) goto L5;
        this.f399037s = VelocityTracker.obtain();
    L6:
        VelocityTracker r103 = this.f399037s;
        if (r103 == null) goto L11;
        r103.addMovement(r100);
        return;
    L11:
        return;
    L5:
        r102.clear();
        goto L6
    }

    public final boolean d(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f399033o == true) goto L6;
        return false;
    L6:
        int r101 = r100.getActionIndex();
        if (r101 >= 0) goto L9;
        return true;
    L9:
        if (r101 >= r100.getPointerCount()) goto L15;
        this.f399034p = r100.getPointerId(r101);
        this.f399036r = r100.getY(r101);
        return true;
    L15:
        return true;
    }

    public final boolean e(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = 0;
        if (this.f399033o == true) goto L5;
        return false;
    L5:
        int r102 = r100.getActionIndex();
        if (r102 >= 0) goto L8;
    L23:
        return true;
    L8:
        if (r102 >= r100.getPointerCount()) goto L23;
        if (r100.getPointerId(r102) != this.f399034p) goto L23;
        if (r102 != 0) goto L16;
        r101 = 1;
    L16:
        if (r101 >= r100.getPointerCount()) goto L22;
        if (r101 < 0) goto L23;
        if (r101 >= r100.getPointerCount()) goto L23;
        this.f399034p = r100.getPointerId(r101);
        this.f399036r = r100.getY(r101);
        goto L23
    L22:
        this.f399034p = -1;
        goto L23
    }

    public final boolean f(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f399020b.invoke().booleanValue() == true) goto L5;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == false) goto L14;
        this.f399029k = true;
        this.f399030l = false;
        this.f399031m = r100.getY();
        this.f399032n = r100.getY();
        return true;
    L14:
        c(r100);
        return false;
    L5:
        if (this.f399019a.getHeight() <= 0) goto L10;
        if (this.f399019a.pointToPosition((int) r100.getX(), (int) r100.getY()) != (-1)) goto L10;
        r101 = true;
        goto L11
    }

    public final boolean g(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f399033o == false) goto L11;
        VelocityTracker r101 = this.f399037s;
        if (r101 == null) goto L8;
        r101.addMovement(r100);
    L8:
        l();
        return true;
    L11:
        if (this.f399029k == false) goto L22;
        this.f399029k = false;
        this.f399030l = false;
        int r102 = c.f399049a;
        BounceEdgeEffect r103 = this.f399021c.invoke();
        if (r103 == null) goto L16;
        r103.onRelease();
    L16:
        BounceEdgeEffect r104 = this.f399022d.invoke();
        if (r104 == null) goto L20;
        r104.onRelease();
    L20:
        this.f399019a.invalidate();
        return true;
    L22:
        return false;
    }

    public final boolean h(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r101 = false;
        if (this.f399033o == false) goto L23;
        if (r100.getEventTime() != this.f399038t) goto L7;
        return true;
    L7:
        int r102 = r100.findPointerIndex(this.f399034p);
        if (r102 >= 0) goto L11;
        l();
        return true;
    L11:
        float r103 = r100.getY(r102);
        float r104 = r103 - this.f399036r;
        if (r104 != 0.0f) goto L14;
        r101 = true;
    L14:
        if (r101 == true) goto L20;
        VelocityTracker r105 = this.f399037s;
        if (r105 == null) goto L19;
        r105.addMovement(r100);
    L19:
        j(r104);
    L20:
        this.f399036r = r103;
        return true;
    L23:
        if (n(r100) == false) goto L26;
        return true;
    L26:
        if (this.f399029k == false) goto L51;
        float r106 = r100.getY();
        float r107 = r106 - this.f399031m;
        float r108 = r106 - this.f399032n;
        if (this.f399030l == true) goto L33;
        if (Math.abs(r107) <= this.f399026h) goto L33;
        this.f399030l = true;
    L33:
        if (this.f399030l == true) goto L35;
    L49:
        this.f399032n = r106;
        return true;
    L35:
        if (r108 != 0.0f) goto L37;
        r101 = true;
    L37:
        if (r101 == true) goto L49;
        if (this.f399019a.getHeight() <= 0) goto L49;
        if (i(r108 / this.f399019a.getHeight()) == false) goto L44;
    L48:
        this.f399019a.invalidate();
        goto L49
    L44:
        if (r108 <= 0.0f) goto L46;
        k(MathKt.roundToInt(-r108));
        goto L48
    L46:
        if (r108 >= 0.0f) goto L48;
        k(MathKt.roundToInt(-r108));
        goto L48
    L51:
        return false;
    }

    public final boolean i(float r100) {
        BounceEdgeEffect r101 = this.f399021c.invoke();
        BounceEdgeEffect r102 = this.f399022d.invoke();
        boolean r103 = b(r101);
        boolean r104 = b(r102);
        if (r103 == false) goto L10;
        if (r101 != null) goto L6;
        float r105 = 0.0f;
    L7:
        float r106 = r100 - r105;
        if (r106 >= 0.0f) goto L18;
        m(MathKt.roundToInt((-r106) * this.f399019a.getHeight()), 1);
    L18:
        return true;
    L6:
        r105 = r101.j(r100, false);
        goto L7
    L10:
        if (r104 == false) goto L19;
        float r107 = -r100;
        if (r102 != null) goto L14;
        float r108 = 0.0f;
    L15:
        float r109 = r107 - r108;
        if (r109 >= 0.0f) goto L18;
        m(MathKt.roundToInt(r109 * this.f399019a.getHeight()), 0);
        goto L18
    L14:
        r108 = r102.j(r107, false);
        goto L15
    L19:
        return false;
    }

    public final void j(float r100) {
        if (this.f399019a.getHeight() > 0) goto L6;
        return;
    L6:
        if (i(r100 / this.f399019a.getHeight()) == false) goto L8;
    L13:
        this.f399019a.invalidate();
        return;
    L8:
        if (r100 <= 0.0f) goto L11;
        k(MathKt.roundToInt(-r100));
        goto L13
    L11:
        if (r100 >= 0.0f) goto L13;
        k(MathKt.roundToInt(-r100));
        goto L13
    }

    public final void k(int r100) {
        if (r100 != 0) goto L4;
        return;
    L4:
        if (this.f399019a.getHeight() <= 0) goto L26;
        int r101 = a(r100);
        int r102 = c.f399049a;
        if (r101 < 0) goto L9;
    L14:
        if (r101 > 0) goto L16;
        return;
    L16:
        if (this.f399019a.getHeight() <= 0) goto L25;
        BounceEdgeEffect r103 = this.f399022d.invoke();
        if (r103 == null) goto L28;
        r103.j(r101 / this.f399019a.getHeight(), true);
        return;
    L28:
        return;
    L25:
        return;
    L9:
        if (this.f399019a.getHeight() <= 0) goto L14;
        BounceEdgeEffect r104 = this.f399021c.invoke();
        if (r104 == null) goto L27;
        r104.j((-r101) / this.f399019a.getHeight(), true);
        return;
    L27:
        return;
    }

    public final boolean n(MotionEvent r100) {
        boolean r101 = false;
        if (this.f399020b.invoke().booleanValue() == true) goto L5;
    L27:
        return r101;
    L5:
        if (this.f399019a.getHeight() <= 0) goto L27;
        if (b(this.f399021c.invoke()) == false) goto L10;
    L12:
        int r102 = r100.findPointerIndex(this.f399034p);
        if (r102 >= 0) goto L16;
        return false;
    L16:
        if (Math.abs(r100.getY(r102) - this.f399035q) > this.f399026h) goto L18;
        return false;
    L18:
        this.f399023e.invoke();
        VelocityTracker r103 = this.f399037s;
        if (r103 == null) goto L22;
        r103.addMovement(r100);
    L22:
        r101 = true;
        this.f399033o = true;
        this.f399036r = this.f399035q;
        j(r100.getY(r102) - this.f399036r);
        this.f399036r = r100.getY(r102);
        this.f399038t = r100.getEventTime();
        ViewParent r104 = this.f399019a.getParent();
        if (r104 == null) goto L26;
        r104.requestDisallowInterceptTouchEvent(true);
    L26:
        int r105 = c.f399049a;
        goto L27
    L10:
        if (b(this.f399022d.invoke()) == true) goto L12;
        return false;
    }

    public final void m(int r100, int r101) {
        if (r100 != 0) goto L4;
        return;
    L4:
        if (this.f399019a.getHeight() <= 0) goto L27;
        int r102 = a(r100);
        int r103 = c.f399049a;
        if (r102 != 0) goto L10;
        return;
    L10:
        if (r101 != 0) goto L16;
        if (r102 >= 0) goto L16;
        BounceEdgeEffect r104 = this.f399021c.invoke();
        if (r104 == null) goto L28;
        r104.j((-r102) / this.f399019a.getHeight(), true);
        return;
    L28:
        return;
    L16:
        if (r101 != 1) goto L25;
        if (r102 <= 0) goto L26;
        BounceEdgeEffect r105 = this.f399022d.invoke();
        if (r105 == null) goto L29;
        r105.j(r102 / this.f399019a.getHeight(), true);
        return;
    L29:
        return;
    L26:
        return;
    L25:
        return;
    }

    public a(AbsListView r100, Function0<Boolean> r101, Function0<BounceEdgeEffect> r102, Function0<BounceEdgeEffect> r103, Function0<Unit> r104, Function0<Unit> r105, Function0<Float> r106) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "edgeEffectsInstalledProvider");
        Intrinsics.checkNotNullParameter(r102, "bounceTopProvider");
        Intrinsics.checkNotNullParameter(r103, "bounceBottomProvider");
        Intrinsics.checkNotNullParameter(r104, "stopBounceIfNeeded");
        Intrinsics.checkNotNullParameter(r105, "resetAbsListViewTouchMode");
        Intrinsics.checkNotNullParameter(r106, "getBounceTranslation");
        this.f399019a = r100;
        this.f399020b = r101;
        this.f399021c = r102;
        this.f399022d = r103;
        this.f399023e = r104;
        this.f399024f = r105;
        this.f399025g = r106;
        this.f399026h = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
        this.f399027i = ViewConfiguration.get(r100.getContext()).getScaledMinimumFlingVelocity();
        this.f399028j = ViewConfiguration.get(r100.getContext()).getScaledMaximumFlingVelocity();
        this.f399034p = -1;
        this.f399038t = -1;
    }
}
