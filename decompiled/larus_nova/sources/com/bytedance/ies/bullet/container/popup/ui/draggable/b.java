package com.bytedance.ies.bullet.container.popup.ui.draggable;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f246403w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f246404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f246405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f246406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f246407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f246408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f246409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f246410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f246411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f246412i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f246413j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f246414k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f246415l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f246416m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f246417n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f246418o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final OverScroller f246419p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c f246420q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f246421r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f246422s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ViewGroup f246423t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f246424u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RunnableC3521b f246425v;

    public class a implements Interpolator {
        public a() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 - 1.0f;
            return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ies.bullet.container.popup.ui.draggable.b$b, reason: collision with other inner class name */
    public class RunnableC3521b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f246426a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f246426a.o(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC3521b(b r100) {
            this.f246426a = r100;
        }
    }

    public static abstract class c {
        public c() {
        }

        public abstract void a(View r100, int r101);

        public abstract boolean b(View r100, int r101);

        public abstract void c(View r100, int r101, int r102);
    }

    public final void b() {
        this.f246406c = -1;
        float[] r100 = this.f246407d;
        if (r100 == null) goto L6;
        Arrays.fill(r100, 0.0f);
        Arrays.fill(this.f246408e, 0.0f);
        Arrays.fill(this.f246409f, 0.0f);
        Arrays.fill(this.f246410g, 0.0f);
        Arrays.fill(this.f246411h, 0);
        Arrays.fill(this.f246412i, 0);
        Arrays.fill(this.f246413j, 0);
        this.f246414k = 0;
    L6:
        VelocityTracker r101 = this.f246415l;
        if (r101 == null) goto L10;
        r101.recycle();
        this.f246415l = null;
        return;
    }

    static {
        f246403w = new a();
    }

    public final void k() {
        this.f246415l.computeCurrentVelocity(1000, this.f246416m);
        float r100 = this.f246415l.getXVelocity(this.f246406c);
        float r101 = this.f246417n;
        float r102 = this.f246416m;
        float r103 = Math.abs(r100);
        float r104 = 0.0f;
        if (r103 >= r101) goto L6;
        r100 = 0.0f;
    L11:
        float r105 = this.f246415l.getYVelocity(this.f246406c);
        float r106 = this.f246417n;
        float r107 = this.f246416m;
        float r108 = Math.abs(r105);
        if (r108 >= r106) goto L15;
    L21:
        h(r100, r104);
        return;
    L15:
        if (r108 > r107) goto L17;
    L20:
        r104 = r105;
        goto L21
    L17:
        if (r105 <= 0.0f) goto L19;
        r104 = r107;
        goto L21
    L19:
        r105 = -r107;
        goto L20
    L6:
        if (r103 <= r102) goto L11;
        if (r100 <= 0.0f) goto L10;
        r100 = r102;
        goto L11
    L10:
        r100 = -r102;
        goto L11
    }

    public final void f(int r100) {
        float[] r101 = this.f246407d;
        if (r101 == null) goto L12;
        int r102 = this.f246414k;
        boolean r103 = true;
        int r104 = 1 << r100;
        if ((r104 & r102) != 0) goto L8;
        r103 = false;
    L8:
        if (r103 == false) goto L13;
        r101[r100] = 0.0f;
        this.f246408e[r100] = 0.0f;
        this.f246409f[r100] = 0.0f;
        this.f246410g[r100] = 0.0f;
        this.f246411h[r100] = 0;
        this.f246412i[r100] = 0;
        this.f246413j[r100] = 0;
        this.f246414k = (~r104) & r102;
        return;
    L13:
        return;
    }

    public final void n(MotionEvent r100) {
        int r101 = r100.getPointerCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L14;
        int r103 = r100.getPointerId(r102);
        boolean r104 = true;
        if ((this.f246414k & (1 << r103)) == 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L10;
        r104 = false;
    L10:
        if (r104 == false) goto L13;
        float r106 = r100.getX(r102);
        float r107 = r100.getY(r102);
        this.f246409f[r103] = r106;
        this.f246410g[r103] = r107;
    L13:
        r102 = r102 + 1;
        goto L3
    L7:
        r105 = false;
        goto L8
    }

    public final void o(int r100) {
        this.f246423t.removeCallbacks(this.f246425v);
        if (this.f246404a == r100) goto L14;
        this.f246404a = r100;
        BottomSheetBehavior.a r101 = (BottomSheetBehavior.a) this.f246420q;
        if (r100 != 1) goto L9;
        BottomSheetBehavior r102 = r101.f246383a;
        if (r102.f246367q == false) goto L11;
        r102.setStateInternal(1);
    L11:
        if (this.f246404a != 0) goto L15;
        this.f246421r = null;
        return;
    L15:
        return;
    L9:
        r101.getClass();
        goto L11
    }

    public final void c(View r100, int r101) {
        if (r100.getParent() != this.f246423t) goto L7;
        this.f246421r = r100;
        this.f246406c = r101;
        this.f246420q.getClass();
        o(1);
        return;
    L7:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f246423t + ")");
    }

    public final boolean e(View r100, float r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        this.f246420q.getClass();
        BottomSheetBehavior r102 = ((BottomSheetBehavior.a) this.f246420q).f246383a;
        if (r102.f246365o == false) goto L8;
        int r103 = r102.G;
    L10:
        if (r103 <= 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == true) goto L15;
        return false;
    L15:
        if (Math.abs(r101) <= this.f246405b) goto L19;
        return true;
    L19:
        return false;
    L12:
        r104 = false;
        goto L13
    L8:
        r103 = r102.f246364n;
        goto L10
    }

    public final void h(float r110, float r111) {
        this.f246422s = true;
        c r100 = this.f246420q;
        View r101 = this.f246421r;
        BottomSheetBehavior.a r102 = (BottomSheetBehavior.a) r100;
        r102.getClass();
        int r103 = r101.getTop();
        int r104 = 3;
        if (r111 >= 0.0f) goto L23;
        BottomSheetBehavior r112 = r102.f246383a;
        if (r112.f246352b == false) goto L14;
        int r113 = r112.f246364n;
        if (r103 > r113) goto L9;
    L13:
        int r114 = r112.f246361k;
    L22:
        r113 = r114;
    L106:
        r102.f246383a.startSettlingAnimation(r101, r104, r113, true);
        this.f246422s = false;
        if (this.f246404a != 1) goto L110;
        o(0);
        return;
    L110:
        return;
    L9:
        if (r112.f246366p == true) goto L11;
    L20:
        r104 = 4;
        goto L106
    L11:
        if (r112.f246376z != 4) goto L13;
    L14:
        r113 = r112.f246364n;
        if (r103 > r113) goto L17;
    L21:
        r114 = r112.f246360j;
        goto L22
    L17:
        if (r112.f246366p == false) goto L20;
        if (r112.f246376z != 4) goto L21;
    L23:
        BottomSheetBehavior r105 = r102.f246383a;
        if (r105.f246365o == false) goto L68;
        if (r105.shouldHide(r101, r111) == false) goto L68;
        if (Math.abs(r110) >= Math.abs(r111)) goto L32;
        if (r111 <= 500.0f) goto L32;
    L42:
        r113 = r102.f246383a.G;
        r104 = 5;
    L32:
        if (r102.f246383a.f246376z != 3) goto L36;
        int r115 = r101.getTop();
        BottomSheetBehavior r116 = r102.f246383a;
        if ((r115 - r116.f246360j) < r116.f246373w) goto L36;
    L39:
        boolean r117 = true;
    L41:
        if (r117 == true) goto L42;
        BottomSheetBehavior r118 = r102.f246383a;
        if (r118.f246352b == false) goto L57;
        if (r118.f246376z == 3) goto L48;
        r113 = r118.f246364n;
        if ((r113 - r103) < r118.f246370t) goto L20;
        r114 = r118.f246361k;
        goto L22
    L48:
        if (r118.f246366p == true) goto L52;
        int r119 = Math.abs(r103 - r118.f246361k);
        BottomSheetBehavior r120 = r102.f246383a;
        if (r119 < r120.f246371u) goto L52;
        r113 = r120.f246364n;
    L52:
        r114 = r102.f246383a.f246361k;
        goto L22
    L57:
        if (r118.f246376z == 3) goto L59;
        r113 = r118.f246364n;
        if ((r113 - r103) < r118.f246370t) goto L20;
        r114 = r118.f246360j;
        goto L22
    L59:
        if (r118.f246366p == true) goto L63;
        int r121 = Math.abs(r103 - r118.f246360j);
        BottomSheetBehavior r122 = r102.f246383a;
        if (r121 < r122.f246371u) goto L63;
        r113 = r122.f246364n;
    L63:
        r114 = r102.f246383a.f246360j;
    L36:
        if (r102.f246383a.f246376z != 4) goto L40;
        int r123 = r101.getTop();
        BottomSheetBehavior r124 = r102.f246383a;
        if ((r123 - r124.f246364n) >= r124.f246372v) goto L39;
    L40:
        r117 = false;
    L68:
        if (r111 != 0.0f) goto L70;
    L82:
        BottomSheetBehavior r125 = r102.f246383a;
        if (r125.f246352b == false) goto L96;
        if (r125.f246376z == 3) goto L87;
        r113 = r125.f246364n;
        if ((r113 - r103) < r125.f246370t) goto L20;
        r114 = r125.f246361k;
        goto L22
    L87:
        if (r125.f246366p == true) goto L91;
        int r126 = Math.abs(r103 - r125.f246361k);
        BottomSheetBehavior r127 = r102.f246383a;
        if (r126 < r127.f246371u) goto L91;
        r113 = r127.f246364n;
    L91:
        r114 = r102.f246383a.f246361k;
        goto L22
    L96:
        if (r125.f246376z == 3) goto L98;
        r113 = r125.f246364n;
        if ((r113 - r103) < r125.f246370t) goto L20;
        r114 = r125.f246360j;
        goto L22
    L98:
        if (r125.f246366p == true) goto L102;
        int r128 = Math.abs(r103 - r125.f246360j);
        BottomSheetBehavior r129 = r102.f246383a;
        if (r128 < r129.f246371u) goto L102;
        r113 = r129.f246364n;
    L102:
        r114 = r102.f246383a.f246360j;
        goto L22
    L70:
        if (Math.abs(r110) > Math.abs(r111)) goto L82;
        BottomSheetBehavior r130 = r102.f246383a;
        if (r130.f246352b == false) goto L79;
        if (r130.f246366p == false) goto L77;
        r114 = r130.f246361k;
        goto L22
    L77:
        r113 = r130.f246364n;
        goto L20
    L79:
        if (r130.f246366p == false) goto L81;
        r114 = r130.f246360j;
        goto L22
    L81:
        r113 = r130.f246364n;
        goto L20
    }

    public final View i(int r100, int r101) {
        int r102 = this.f246423t.getChildCount() - 1;
    L3:
        if (r102 < 0) goto L14;
        ViewGroup r103 = this.f246423t;
        this.f246420q.getClass();
        View r104 = r103.getChildAt(r102);
        if (r100 < r104.getLeft()) goto L13;
        if (r100 >= r104.getRight()) goto L13;
        if (r101 < r104.getTop()) goto L13;
        if (r101 >= r104.getBottom()) goto L13;
        return r104;
    L13:
        r102 = r102 - 1;
        goto L3
    L14:
        return null;
    }

    public final boolean p(View r100, int r101) {
        if (r100 != this.f246421r) goto L8;
        if (this.f246406c != r101) goto L8;
        return true;
    L8:
        if (r100 == null) goto L36;
        BottomSheetBehavior.a r102 = (BottomSheetBehavior.a) this.f246420q;
        BottomSheetBehavior r103 = r102.f246383a;
        int r104 = r103.A;
        if (r104 != 1) goto L13;
    L32:
        boolean r105 = false;
    L33:
        if (r105 == false) goto L36;
        this.f246406c = r101;
        c(r100, r101);
        return true;
    L13:
        if (r103.O == true) goto L32;
        if (r104 == 3) goto L18;
    L27:
        WeakReference<V> r106 = r102.f246383a.H;
        if (r106 == 0) goto L32;
        if (r106.get() != r100) goto L32;
        r105 = true;
        goto L33
    L18:
        if (r103.L != r101) goto L27;
        WeakReference<View> r107 = r103.I;
        if (r107 == null) goto L22;
        View r108 = r107.get();
    L23:
        if (r108 == null) goto L27;
        if (r108.canScrollVertically(-1) == false) goto L27;
    L22:
        r108 = null;
    L36:
        return false;
    }

    public b(Context r100, ViewGroup r101, BottomSheetBehavior.a r102) {
        this.f246406c = -1;
        this.f246424u = false;
        this.f246425v = new RunnableC3521b(this);
        if (r101 == null) goto L10;
        if (r102 == null) goto L8;
        this.f246423t = r101;
        this.f246420q = r102;
        ViewConfiguration r103 = ViewConfiguration.get(r100);
        Resources r104 = r100.getResources();
        this.f246418o = (int) ((WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density * 20.0f) + 0.5f);
        this.f246405b = r103.getScaledTouchSlop();
        this.f246416m = r103.getScaledMaximumFlingVelocity();
        this.f246417n = r103.getScaledMinimumFlingVelocity();
        this.f246419p = new OverScroller(r100, f246403w);
        return;
    L8:
        throw new IllegalArgumentException("Callback may not be null");
    L10:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public final int g(int r100, int r101, int r102) {
        if (r100 != 0) goto L5;
        return 0;
    L5:
        int r103 = this.f246423t.getWidth();
        float r104 = r103 / 2;
        float r105 = r104 + (((float) Math.sin((Math.min(1.0f, Math.abs(r100) / r103) - 0.5f) * 0.47123894f)) * r104);
        int r106 = Math.abs(r101);
        if (r106 <= 0) goto L8;
        int r107 = Math.round(Math.abs(r105 / r106) * 1000.0f) * 4;
    L10:
        return Math.min(r107, 600);
    L8:
        r107 = (int) (((Math.abs(r100) / r102) + 1.0f) * 256.0f);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r4v2 */
    public final void l(float r100, float r101, int r102) {
        boolean r103 = d(r100, r101, r102, 1);
        ?? r104 = r103;
        if (d(r101, r100, r102, 4) == false) goto L5;
        r104 = (r103 ? 1 : 0) | 4;
    L5:
        ?? r105 = r104;
        if (d(r100, r101, r102, 2) == false) goto L8;
        r105 = (r104 == true ? 1 : 0) | 2;
    L8:
        ?? r106 = r105;
        if (d(r101, r100, r102, 8) == false) goto L11;
        r106 = (r105 == true ? 1 : 0) | 8;
    L11:
        if (r106 == 0) goto L14;
        int[] r107 = this.f246412i;
        r107[r102] = (r107[r102] | r106) == true ? 1 : 0;
        this.f246420q.getClass();
        return;
    }

    public final void m(float r110, float r111, int r112) {
        float[] r100 = this.f246407d;
        int r101 = 0;
        if (r100 != null) goto L5;
    L6:
        int r102 = r112 + 1;
        float[] r103 = new float[r102];
        float[] r104 = new float[r102];
        float[] r105 = new float[r102];
        float[] r106 = new float[r102];
        int[] r107 = new int[r102];
        int[] r108 = new int[r102];
        int[] r109 = new int[r102];
        if (r100 == null) goto L9;
        System.arraycopy(r100, 0, r103, 0, r100.length);
        float[] r113 = this.f246408e;
        System.arraycopy(r113, 0, r104, 0, r113.length);
        float[] r114 = this.f246409f;
        System.arraycopy(r114, 0, r105, 0, r114.length);
        float[] r115 = this.f246410g;
        System.arraycopy(r115, 0, r106, 0, r115.length);
        int[] r116 = this.f246411h;
        System.arraycopy(r116, 0, r107, 0, r116.length);
        int[] r117 = this.f246412i;
        System.arraycopy(r117, 0, r108, 0, r117.length);
        int[] r118 = this.f246413j;
        System.arraycopy(r118, 0, r109, 0, r118.length);
    L9:
        this.f246407d = r103;
        this.f246408e = r104;
        this.f246409f = r105;
        this.f246410g = r106;
        this.f246411h = r107;
        this.f246412i = r108;
        this.f246413j = r109;
    L10:
        float[] r119 = this.f246407d;
        this.f246409f[r112] = r110;
        r119[r112] = r110;
        float[] r120 = this.f246408e;
        this.f246410g[r112] = r111;
        r120[r112] = r111;
        int[] r121 = this.f246411h;
        int r122 = (int) r110;
        int r123 = (int) r111;
        if (r122 >= (this.f246423t.getLeft() + this.f246418o)) goto L14;
        r101 = 1;
    L14:
        if (r123 >= (this.f246423t.getTop() + this.f246418o)) goto L17;
        r101 = r101 | 4;
    L17:
        if (r122 <= (this.f246423t.getRight() - this.f246418o)) goto L20;
        r101 = r101 | 2;
    L20:
        if (r123 <= (this.f246423t.getBottom() - this.f246418o)) goto L22;
        r101 = r101 | 8;
    L22:
        r121[r112] = r101;
        this.f246414k |= 1 << r112;
        return;
    L5:
        if (r100.length > r112) goto L10;
        goto L6
    }

    public static boolean a(View r100, int r110, int r111, int r112) {
        if ((r100 instanceof ViewGroup) == false) goto L19;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r100.getScrollX();
        int r103 = r100.getScrollY();
        int r104 = r101.getChildCount() - 1;
    L5:
        if (r104 < 0) goto L19;
        View r105 = r101.getChildAt(r104);
        int r106 = r111 + r102;
        if (r106 < r105.getLeft()) goto L17;
        if (r106 >= r105.getRight()) goto L17;
        int r107 = r112 + r103;
        if (r107 < r105.getTop()) goto L17;
        if (r107 >= r105.getBottom()) goto L17;
        if (a(r105, r110, r106 - r105.getLeft(), r107 - r105.getTop()) == false) goto L17;
        return true;
    L17:
        r104 = r104 - 1;
    L19:
        if (r100.canScrollHorizontally(-r110) == false) goto L21;
        return true;
    L21:
        if (r100.canScrollVertically(-1) == true) goto L33;
        return false;
    L33:
        return true;
    }

    public final boolean d(float r100, float r101, int r102, int r103) {
        float r104 = Math.abs(r100);
        float r105 = Math.abs(r101);
        if ((this.f246411h[r102] & r103) == r103) goto L5;
        return false;
    L5:
        if ((0 & r103) != 0) goto L7;
        return false;
    L7:
        if ((this.f246413j[r102] & r103) != r103) goto L9;
        return false;
    L9:
        if ((this.f246412i[r102] & r103) == r103) goto L27;
        int r106 = this.f246405b;
        if (r104 > r106) goto L16;
        if (r105 > r106) goto L16;
        return false;
    L16:
        if (r104 >= (r105 * 0.5f)) goto L19;
        this.f246420q.getClass();
    L19:
        if ((this.f246412i[r102] & r103) == 0) goto L21;
        return false;
    L21:
        if (r104 <= this.f246405b) goto L29;
        return true;
    L29:
        return false;
    L27:
        return false;
    }

    public final boolean j(int r110, int r111, int r112, int r113) {
        int r100 = this.f246421r.getLeft();
        int r101 = this.f246421r.getTop();
        int r102 = r110 - r100;
        int r103 = r111 - r101;
        if (r102 != 0) goto L7;
        if (r103 != 0) goto L7;
        this.f246419p.abortAnimation();
        o(0);
        return false;
    L7:
        int r114 = (int) this.f246417n;
        int r104 = (int) this.f246416m;
        int r105 = Math.abs(r112);
        if (r105 >= r114) goto L10;
        r112 = 0;
    L14:
        int r115 = (int) this.f246417n;
        int r106 = (int) this.f246416m;
        int r107 = Math.abs(r113);
        if (r107 >= r115) goto L17;
        r113 = 0;
    L21:
        int r116 = Math.abs(r102);
        int r108 = Math.abs(r103);
        int r109 = Math.abs(r112);
        int r117 = Math.abs(r113);
        int r118 = r109 + r117;
        int r119 = r116 + r108;
        if (r112 == 0) goto L24;
        float r120 = r109;
        float r121 = r118;
    L25:
        float r122 = r120 / r121;
        if (r113 == 0) goto L28;
        float r123 = r117;
        float r124 = r118;
    L29:
        float r125 = r123 / r124;
        this.f246420q.getClass();
        int r126 = g(r102, r112, 0);
        BottomSheetBehavior r127 = ((BottomSheetBehavior.a) this.f246420q).f246383a;
        if (r127.f246365o == false) goto L32;
        int r128 = r127.G;
    L33:
        this.f246419p.startScroll(r100, r101, r102, r103, (int) ((r126 * r122) + (g(r103, r113, r128) * r125)));
        o(2);
        return true;
    L32:
        r128 = r127.f246364n;
        goto L33
    L28:
        r123 = r108;
        r124 = r119;
        goto L29
    L24:
        r120 = r116;
        r121 = r119;
        goto L25
    L17:
        if (r107 <= r106) goto L21;
        if (r113 <= 0) goto L20;
        r113 = r106;
        goto L21
    L20:
        r113 = -r106;
        goto L21
    L10:
        if (r105 <= r104) goto L14;
        if (r112 <= 0) goto L13;
        r112 = r104;
        goto L14
    L13:
        r112 = -r104;
        goto L14
    }
}
