package com.obric.oui.panel;

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
import java.util.Arrays;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f402091w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f402092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f402093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f402094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f402095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f402096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f402097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f402098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f402099h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f402100i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f402101j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f402102k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f402103l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f402104m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f402105n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f402106o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final OverScroller f402107p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c f402108q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f402109r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f402110s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ViewGroup f402111t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f402112u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f402113v;

    public class a implements Interpolator {
        public a() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 - 1.0f;
            return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f402114a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f402114a.m(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(d r100) {
            this.f402114a = r100;
        }
    }

    public static abstract class c {
        public c() {
        }

        public abstract int a(View r100, int r101, int r102);

        public abstract int b(View r100, int r101, int r102);

        public abstract int c(View r100);

        public abstract void d(int r100);

        public abstract void e(View r100, int r101, int r102, int r103, int r104);

        public abstract void f(View r100, float r101, float r102);

        public abstract boolean g(View r100, int r101);
    }

    public final void a() {
        this.f402094c = -1;
        float[] r100 = this.f402095d;
        if (r100 == null) goto L6;
        Arrays.fill(r100, 0.0f);
        Arrays.fill(this.f402096e, 0.0f);
        Arrays.fill(this.f402097f, 0.0f);
        Arrays.fill(this.f402098g, 0.0f);
        Arrays.fill(this.f402099h, 0);
        Arrays.fill(this.f402100i, 0);
        Arrays.fill(this.f402101j, 0);
        this.f402102k = 0;
    L6:
        VelocityTracker r101 = this.f402103l;
        if (r101 == null) goto L10;
        r101.recycle();
        this.f402103l = null;
        return;
    }

    static {
        f402091w = new a();
    }

    public final void i() {
        this.f402103l.computeCurrentVelocity(1000, this.f402104m);
        float r100 = this.f402103l.getXVelocity(this.f402094c);
        float r101 = this.f402105n;
        float r102 = this.f402104m;
        float r103 = Math.abs(r100);
        float r104 = 0.0f;
        if (r103 >= r101) goto L6;
        r100 = 0.0f;
    L11:
        float r105 = this.f402103l.getYVelocity(this.f402094c);
        float r106 = this.f402105n;
        float r107 = this.f402104m;
        float r108 = Math.abs(r105);
        if (r108 >= r106) goto L15;
    L21:
        this.f402110s = true;
        this.f402108q.f(this.f402109r, r100, r104);
        this.f402110s = false;
        if (this.f402092a != 1) goto L25;
        m(0);
        return;
    L25:
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

    public final void e(int r100) {
        float[] r101 = this.f402095d;
        if (r101 == null) goto L12;
        int r102 = this.f402102k;
        boolean r103 = true;
        int r104 = 1 << r100;
        if ((r104 & r102) != 0) goto L8;
        r103 = false;
    L8:
        if (r103 == false) goto L13;
        r101[r100] = 0.0f;
        this.f402096e[r100] = 0.0f;
        this.f402097f[r100] = 0.0f;
        this.f402098g[r100] = 0.0f;
        this.f402099h[r100] = 0;
        this.f402100i[r100] = 0;
        this.f402101j[r100] = 0;
        this.f402102k = (~r104) & r102;
        return;
    L13:
        return;
    }

    public final void l(MotionEvent r100) {
        int r101 = r100.getPointerCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L14;
        int r103 = r100.getPointerId(r102);
        boolean r104 = true;
        if ((this.f402102k & (1 << r103)) == 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L10;
        r104 = false;
    L10:
        if (r104 == false) goto L13;
        float r106 = r100.getX(r102);
        float r107 = r100.getY(r102);
        this.f402097f[r103] = r106;
        this.f402098g[r103] = r107;
    L13:
        r102 = r102 + 1;
        goto L3
    L7:
        r105 = false;
        goto L8
    }

    public final void m(int r100) {
        this.f402111t.removeCallbacks(this.f402113v);
        if (this.f402092a == r100) goto L8;
        this.f402092a = r100;
        this.f402108q.d(r100);
        if (this.f402092a != 0) goto L9;
        this.f402109r = null;
        return;
    L9:
        return;
    }

    public final void b(View r100, int r101) {
        if (r100.getParent() != this.f402111t) goto L7;
        this.f402109r = r100;
        this.f402094c = r101;
        this.f402108q.getClass();
        m(1);
        return;
    L7:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f402111t + ")");
    }

    public final boolean d(View r100, float r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        this.f402108q.getClass();
        if (this.f402108q.c(r100) <= 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return false;
    L11:
        if (Math.abs(r101) <= this.f402093b) goto L15;
        return true;
    L15:
        return false;
    L8:
        r102 = false;
        goto L9
    }

    public final View g(int r100, int r101) {
        int r102 = this.f402111t.getChildCount() - 1;
    L3:
        if (r102 < 0) goto L14;
        ViewGroup r103 = this.f402111t;
        this.f402108q.getClass();
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

    public final boolean n(View r100, int r101) {
        if (r100 == this.f402109r) goto L5;
    L7:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (this.f402108q.g(r100, r101) == false) goto L14;
        this.f402094c = r101;
        b(r100, r101);
        return true;
    L14:
        return false;
    L5:
        if (this.f402094c != r101) goto L7;
        return true;
    }

    public d(Context r100, ViewGroup r101, c r102) {
        this.f402094c = -1;
        this.f402112u = 600;
        this.f402113v = new b(this);
        if (r101 == null) goto L10;
        if (r102 == null) goto L8;
        this.f402111t = r101;
        this.f402108q = r102;
        ViewConfiguration r103 = ViewConfiguration.get(r100);
        Resources r104 = r100.getResources();
        this.f402106o = (int) ((WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density * 20.0f) + 0.5f);
        this.f402093b = r103.getScaledTouchSlop();
        this.f402104m = r103.getScaledMaximumFlingVelocity();
        this.f402105n = r103.getScaledMinimumFlingVelocity();
        this.f402107p = new OverScroller(r100, f402091w);
        return;
    L8:
        throw new IllegalArgumentException("Callback may not be null");
    L10:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public final int f(int r100, int r101, int r102) {
        if (r100 != 0) goto L5;
        return 0;
    L5:
        int r103 = this.f402111t.getWidth();
        float r104 = r103 / 2;
        float r105 = r104 + (((float) Math.sin((Math.min(1.0f, Math.abs(r100) / r103) - 0.5f) * 0.47123894f)) * r104);
        int r106 = Math.abs(r101);
        if (r106 <= 0) goto L8;
        int r107 = Math.round(Math.abs(r105 / r106) * 1000.0f) * 4;
    L10:
        return Math.min(r107, this.f402112u);
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
    public final void j(float r100, float r101, int r102) {
        boolean r103 = c(r100, r101, r102, 1);
        ?? r104 = r103;
        if (c(r101, r100, r102, 4) == false) goto L5;
        r104 = (r103 ? 1 : 0) | 4;
    L5:
        ?? r105 = r104;
        if (c(r100, r101, r102, 2) == false) goto L8;
        r105 = (r104 == true ? 1 : 0) | 2;
    L8:
        ?? r106 = r105;
        if (c(r101, r100, r102, 8) == false) goto L11;
        r106 = (r105 == true ? 1 : 0) | 8;
    L11:
        if (r106 == 0) goto L14;
        int[] r107 = this.f402100i;
        r107[r102] = (r107[r102] | r106) == true ? 1 : 0;
        this.f402108q.getClass();
        return;
    }

    public final void k(float r110, float r111, int r112) {
        float[] r100 = this.f402095d;
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
        float[] r113 = this.f402096e;
        System.arraycopy(r113, 0, r104, 0, r113.length);
        float[] r114 = this.f402097f;
        System.arraycopy(r114, 0, r105, 0, r114.length);
        float[] r115 = this.f402098g;
        System.arraycopy(r115, 0, r106, 0, r115.length);
        int[] r116 = this.f402099h;
        System.arraycopy(r116, 0, r107, 0, r116.length);
        int[] r117 = this.f402100i;
        System.arraycopy(r117, 0, r108, 0, r117.length);
        int[] r118 = this.f402101j;
        System.arraycopy(r118, 0, r109, 0, r118.length);
    L9:
        this.f402095d = r103;
        this.f402096e = r104;
        this.f402097f = r105;
        this.f402098g = r106;
        this.f402099h = r107;
        this.f402100i = r108;
        this.f402101j = r109;
    L10:
        float[] r119 = this.f402095d;
        this.f402097f[r112] = r110;
        r119[r112] = r110;
        float[] r120 = this.f402096e;
        this.f402098g[r112] = r111;
        r120[r112] = r111;
        int[] r121 = this.f402099h;
        int r122 = (int) r110;
        int r123 = (int) r111;
        if (r122 >= (this.f402111t.getLeft() + this.f402106o)) goto L14;
        r101 = 1;
    L14:
        if (r123 >= (this.f402111t.getTop() + this.f402106o)) goto L17;
        r101 = r101 | 4;
    L17:
        if (r122 <= (this.f402111t.getRight() - this.f402106o)) goto L20;
        r101 = r101 | 2;
    L20:
        if (r123 <= (this.f402111t.getBottom() - this.f402106o)) goto L22;
        r101 = r101 | 8;
    L22:
        r121[r112] = r101;
        this.f402102k |= 1 << r112;
        return;
    L5:
        if (r100.length > r112) goto L10;
        goto L6
    }

    public final boolean c(float r100, float r101, int r102, int r103) {
        float r104 = Math.abs(r100);
        float r105 = Math.abs(r101);
        if ((this.f402099h[r102] & r103) == r103) goto L5;
        return false;
    L5:
        if ((0 & r103) != 0) goto L7;
        return false;
    L7:
        if ((this.f402101j[r102] & r103) != r103) goto L9;
        return false;
    L9:
        if ((this.f402100i[r102] & r103) == r103) goto L27;
        int r106 = this.f402093b;
        if (r104 > r106) goto L16;
        if (r105 > r106) goto L16;
        return false;
    L16:
        if (r104 >= (r105 * 0.5f)) goto L19;
        this.f402108q.getClass();
    L19:
        if ((this.f402100i[r102] & r103) == 0) goto L21;
        return false;
    L21:
        if (r104 <= this.f402093b) goto L29;
        return true;
    L29:
        return false;
    L27:
        return false;
    }

    public final boolean h(int r110, int r111, int r112, int r113) {
        int r100 = this.f402109r.getLeft();
        int r101 = this.f402109r.getTop();
        int r102 = r110 - r100;
        int r103 = r111 - r101;
        if (r102 != 0) goto L7;
        if (r103 != 0) goto L7;
        this.f402107p.abortAnimation();
        m(0);
        return false;
    L7:
        View r114 = this.f402109r;
        int r104 = (int) this.f402105n;
        int r105 = (int) this.f402104m;
        int r106 = Math.abs(r112);
        if (r106 >= r104) goto L10;
        r112 = 0;
    L14:
        int r107 = (int) this.f402105n;
        int r108 = (int) this.f402104m;
        int r109 = Math.abs(r113);
        if (r109 >= r107) goto L17;
        r113 = 0;
    L21:
        int r115 = Math.abs(r102);
        int r116 = Math.abs(r103);
        int r117 = Math.abs(r112);
        int r118 = Math.abs(r113);
        int r119 = r117 + r118;
        int r120 = r115 + r116;
        if (r112 == 0) goto L24;
        float r121 = r117;
        float r122 = r119;
    L25:
        float r123 = r121 / r122;
        if (r113 == 0) goto L28;
        float r124 = r118;
        float r125 = r119;
    L29:
        this.f402108q.getClass();
        int r126 = f(r102, r112, 0);
        this.f402107p.startScroll(r100, r101, r102, r103, (int) ((r126 * r123) + (f(r103, r113, this.f402108q.c(r114)) * (r124 / r125))));
        m(2);
        return true;
    L28:
        r124 = r116;
        r125 = r120;
        goto L29
    L24:
        r121 = r115;
        r122 = r120;
        goto L25
    L17:
        if (r109 <= r108) goto L21;
        if (r113 <= 0) goto L20;
        r113 = r108;
        goto L21
    L20:
        r113 = -r108;
        goto L21
    L10:
        if (r106 <= r105) goto L14;
        if (r112 <= 0) goto L13;
        r112 = r105;
        goto L14
    L13:
        r112 = -r105;
        goto L14
    }
}
