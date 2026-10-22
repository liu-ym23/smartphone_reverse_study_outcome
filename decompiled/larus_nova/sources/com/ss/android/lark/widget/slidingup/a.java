package com.ss.android.lark.widget.slidingup;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ScrollerCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Arrays;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final InterpolatorC5431a f448549u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f448550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f448551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f448552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f448553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f448554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f448555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f448556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f448557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f448558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f448559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public VelocityTracker f448560k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f448561l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f448562m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f448563n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ScrollerCompat f448564o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f448565p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f448566q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f448567r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ViewGroup f448568s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f448569t;

    /* JADX INFO: renamed from: com.ss.android.lark.widget.slidingup.a$a, reason: collision with other inner class name */
    public class InterpolatorC5431a implements Interpolator {
        public InterpolatorC5431a() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 - 1.0f;
            return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f448570a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f448570a.o(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r100) {
            this.f448570a = r100;
        }
    }

    public static abstract class c {
        public c() {
        }
    }

    public final void b() {
        this.f448552c = -1;
        float[] r100 = this.f448553d;
        if (r100 == null) goto L6;
        Arrays.fill(r100, 0.0f);
        Arrays.fill(this.f448554e, 0.0f);
        Arrays.fill(this.f448555f, 0.0f);
        Arrays.fill(this.f448556g, 0.0f);
        Arrays.fill(this.f448557h, 0);
        Arrays.fill(this.f448558i, 0);
        Arrays.fill(this.f448559j, 0);
    L6:
        VelocityTracker r101 = this.f448560k;
        if (r101 == null) goto L10;
        r101.recycle();
        this.f448560k = null;
        return;
    }

    static {
        f448549u = new InterpolatorC5431a();
    }

    public final void k() {
        this.f448560k.computeCurrentVelocity(1000, this.f448561l);
        float r100 = VelocityTrackerCompat.getXVelocity(this.f448560k, this.f448552c);
        float r101 = this.f448562m;
        float r102 = this.f448561l;
        float r103 = Math.abs(r100);
        if (r103 < r101) goto L6;
        int r104 = (r103 > r102 ? 1 : (r103 == r102 ? 0 : -1));
    L6:
        float r105 = VelocityTrackerCompat.getYVelocity(this.f448560k, this.f448552c);
        float r106 = this.f448562m;
        float r107 = this.f448561l;
        float r108 = Math.abs(r105);
        if (r108 >= r106) goto L10;
        r105 = 0.0f;
    L15:
        g(r105);
        return;
    L10:
        if (r108 <= r107) goto L15;
        if (r105 <= 0.0f) goto L14;
        r105 = r107;
        goto L15
    L14:
        r105 = -r107;
        goto L15
    }

    public final void a() {
        b();
        if (this.f448550a != 2) goto L5;
        this.f448564o.getCurrX();
        this.f448564o.getCurrY();
        this.f448564o.abortAnimation();
        this.f448564o.getCurrX();
        int r100 = this.f448564o.getCurrY();
        SlidingUpPanelLayout.c r101 = (SlidingUpPanelLayout.c) this.f448565p;
        SlidingUpPanelLayout.a(r101.f448548a, r100);
        r101.f448548a.invalidate();
    L5:
        o(0);
    }

    public final void e(int r100) {
        float[] r101 = this.f448553d;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length <= r100) goto L10;
        r101[r100] = 0.0f;
        this.f448554e[r100] = 0.0f;
        this.f448555f[r100] = 0.0f;
        this.f448556g[r100] = 0.0f;
        this.f448557h[r100] = 0;
        this.f448558i[r100] = 0;
        this.f448559j[r100] = 0;
        return;
    }

    public final void g(float r110) {
        this.f448567r = true;
        c r100 = this.f448565p;
        View r101 = this.f448566q;
        SlidingUpPanelLayout.c r102 = (SlidingUpPanelLayout.c) r100;
        SlidingUpPanelLayout r103 = r102.f448548a;
        if (r103.f448524h == false) goto L6;
        r110 = -r110;
    L6:
        if (r110 <= 0.0f) goto L11;
        float r104 = r103.f448536t;
        float r105 = r103.f448538v;
        if (r104 > r105) goto L11;
        int r111 = r103.c(r105);
    L31:
        a r106 = r102.f448548a.F;
        if (r106 == null) goto L38;
        int r107 = r101.getLeft();
        if (r106.f448567r == false) goto L37;
        r106.i(r107, r111, (int) VelocityTrackerCompat.getXVelocity(r106.f448560k, r106.f448552c), (int) VelocityTrackerCompat.getYVelocity(r106.f448560k, r106.f448552c));
        goto L38
    L37:
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    L38:
        r102.f448548a.invalidate();
        this.f448567r = false;
        if (this.f448550a != 1) goto L42;
        o(0);
        return;
    L42:
        return;
    L11:
        if (r110 <= 0.0f) goto L16;
        if (r103.f448536t <= r103.f448538v) goto L16;
        r111 = r103.c(1.0f);
    L16:
        if (r110 >= 0.0f) goto L20;
        float r108 = r103.f448536t;
        float r109 = r103.f448538v;
        if (r108 < r109) goto L20;
        r111 = r103.c(r109);
    L20:
        if (r110 < 0.0f) goto L22;
    L24:
        float r112 = r103.f448536t;
        float r113 = r103.f448538v;
        if (r112 < ((r113 + 1.0f) / 2.0f)) goto L28;
        r111 = r103.c(1.0f);
        goto L31
    L28:
        if (r112 < (r113 / 2.0f)) goto L30;
        r111 = r103.c(r113);
        goto L31
    L30:
        r111 = r103.c(0.0f);
        goto L31
    L22:
        if (r103.f448536t >= r103.f448538v) goto L24;
        r111 = r103.c(0.0f);
        goto L31
    }

    public final void j(MotionEvent r100) {
        int r101 = MotionEventCompat.getActionMasked(r100);
        int r102 = MotionEventCompat.getActionIndex(r100);
        if (r101 != 0) goto L6;
        b();
    L6:
        if (this.f448560k != null) goto L8;
        this.f448560k = VelocityTracker.obtain();
    L8:
        this.f448560k.addMovement(r100);
        int r103 = 0;
        if (r101 != 0) goto L11;
        float r104 = r100.getX();
        float r105 = r100.getY();
        int r106 = MotionEventCompat.getPointerId(r100, 0);
        View r107 = h((int) r104, (int) r105);
        m(r104, r105, r106);
        p(r107, r106);
        if ((this.f448557h[r106] & 0) == 0) goto L118;
        this.f448565p.getClass();
        return;
    L118:
        return;
    L11:
        if (r101 == 1) goto L92;
        if (r101 == 2) goto L65;
        if (r101 == 3) goto L61;
        if (r101 != 5) goto L19;
        int r108 = MotionEventCompat.getPointerId(r100, r102);
        float r109 = MotionEventCompat.getX(r100, r102);
        float r110 = MotionEventCompat.getY(r100, r102);
        m(r109, r110, r108);
        if (this.f448550a != 0) goto L46;
        p(h((int) r109, (int) r110), r108);
        if ((this.f448557h[r108] & 0) == 0) goto L110;
        this.f448565p.getClass();
        return;
    L110:
        return;
    L46:
        int r111 = (int) r109;
        int r112 = (int) r110;
        View r113 = this.f448566q;
        if (r113 != null) goto L50;
    L58:
        if (r103 == 0) goto L112;
        p(this.f448566q, r108);
        return;
    L112:
        return;
    L50:
        if (r111 < r113.getLeft()) goto L58;
        if (r111 >= r113.getRight()) goto L58;
        if (r112 < r113.getTop()) goto L58;
        if (r112 >= r113.getBottom()) goto L58;
        r103 = 1;
        goto L58
    L19:
        if (r101 != 6) goto L119;
        int r114 = MotionEventCompat.getPointerId(r100, r102);
        if (this.f448550a == 1) goto L24;
    L40:
        e(r114);
        return;
    L24:
        if (r114 != this.f448552c) goto L40;
        int r115 = MotionEventCompat.getPointerCount(r100);
    L27:
        if (r103 >= r115) goto L37;
        int r116 = MotionEventCompat.getPointerId(r100, r103);
        if (r116 == this.f448552c) goto L36;
        float r117 = MotionEventCompat.getX(r100, r103);
        View r118 = h((int) r117, (int) MotionEventCompat.getY(r100, r103));
        View r119 = this.f448566q;
        if (r118 != r119) goto L36;
        if (p(r119, r116) == false) goto L36;
        int r120 = this.f448552c;
    L38:
        if (r120 != (-1)) goto L40;
        k();
    L36:
        r103 = r103 + 1;
        goto L27
    L37:
        r120 = -1;
        goto L38
    L119:
        return;
    L61:
        if (this.f448550a != 1) goto L63;
        g(0.0f);
    L63:
        b();
        return;
    L65:
        if (this.f448550a != 1) goto L79;
        int r121 = MotionEventCompat.findPointerIndex(r100, this.f448552c);
        float r122 = MotionEventCompat.getX(r100, r121);
        float r123 = MotionEventCompat.getY(r100, r121);
        float[] r124 = this.f448555f;
        int r125 = this.f448552c;
        int r126 = (int) (r122 - r124[r125]);
        int r127 = (int) (r123 - this.f448556g[r125]);
        this.f448566q.getLeft();
        int r128 = this.f448566q.getTop() + r127;
        int r129 = this.f448566q.getLeft();
        int r130 = this.f448566q.getTop();
        if (r126 == 0) goto L69;
        this.f448565p.getClass();
        this.f448566q.offsetLeftAndRight(0 - r129);
    L69:
        if (r127 == 0) goto L75;
        SlidingUpPanelLayout.c r131 = (SlidingUpPanelLayout.c) this.f448565p;
        SlidingUpPanelLayout r132 = r131.f448548a;
        SlidingUpPanelLayout.PanelState r133 = SlidingUpPanelLayout.I;
        int r134 = r132.c(0.0f);
        int r135 = r131.f448548a.c(1.0f);
        if (r131.f448548a.f448524h == false) goto L73;
        int r136 = Math.min(Math.max(r128, r135), r134);
    L74:
        r128 = r136;
        this.f448566q.offsetTopAndBottom(r128 - r130);
        goto L75
    L73:
        r136 = Math.min(Math.max(r128, r134), r135);
    L75:
        if (r126 != 0) goto L77;
        if (r127 != 0) goto L77;
    L78:
        n(r100);
        return;
    L77:
        SlidingUpPanelLayout.c r137 = (SlidingUpPanelLayout.c) this.f448565p;
        SlidingUpPanelLayout.a(r137.f448548a, r128);
        r137.f448548a.invalidate();
        goto L78
    L79:
        int r138 = MotionEventCompat.getPointerCount(r100);
    L80:
        if (r103 >= r138) goto L90;
        int r139 = MotionEventCompat.getPointerId(r100, r103);
        float r140 = MotionEventCompat.getX(r100, r103);
        float r141 = MotionEventCompat.getY(r100, r103);
        float r142 = r140 - this.f448553d[r139];
        float r143 = r141 - this.f448554e[r139];
        l(r142, r143, r139);
        if (this.f448550a == 1) goto L90;
        View r144 = h((int) this.f448553d[r139], (int) this.f448554e[r139]);
        if (d(r144, r143) == false) goto L89;
        if (p(r144, r139) == true) goto L90;
    L89:
        r103 = r103 + 1;
    L90:
        n(r100);
        return;
    L92:
        if (this.f448550a != 1) goto L94;
        k();
    L94:
        b();
    }

    public final void n(MotionEvent r100) {
        int r101 = MotionEventCompat.getPointerCount(r100);
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L14;
        int r103 = MotionEventCompat.getPointerId(r100, r102);
        float r104 = MotionEventCompat.getX(r100, r102);
        float r105 = MotionEventCompat.getY(r100, r102);
        float[] r106 = this.f448555f;
        if (r106 == null) goto L13;
        float[] r107 = this.f448556g;
        if (r107 == null) goto L13;
        if (r106.length <= r103) goto L13;
        if (r107.length <= r103) goto L13;
        r106[r103] = r104;
        r107[r103] = r105;
    L13:
        r102 = r102 + 1;
        goto L3
    }

    public final void o(int r100) {
        if (this.f448550a == r100) goto L25;
        this.f448550a = r100;
        SlidingUpPanelLayout.c r101 = (SlidingUpPanelLayout.c) this.f448565p;
        SlidingUpPanelLayout r102 = r101.f448548a;
        a r103 = r102.F;
        if (r103 == null) goto L22;
        if (r103.f448550a != 0) goto L22;
        r102.f448536t = r102.d(r102.f448532p.getTop());
        SlidingUpPanelLayout r104 = r101.f448548a;
        if (r104.f448523g <= 0) goto L11;
        ViewCompat.setTranslationY(r104.f448533q, r104.getCurrentParallaxOffset());
    L11:
        SlidingUpPanelLayout r105 = r101.f448548a;
        float r106 = r105.f448536t;
        if (r106 != 1.0f) goto L15;
        r105.h();
        SlidingUpPanelLayout.b(r101.f448548a, SlidingUpPanelLayout.PanelState.EXPANDED);
        goto L22
    L15:
        if (r106 != 0.0f) goto L18;
        SlidingUpPanelLayout.b(r105, SlidingUpPanelLayout.PanelState.COLLAPSED);
        goto L22
    L18:
        if (r106 >= 0.0f) goto L20;
        SlidingUpPanelLayout.b(r105, SlidingUpPanelLayout.PanelState.HIDDEN);
        r101.f448548a.f448532p.setVisibility(4);
        goto L22
    L20:
        r105.h();
        SlidingUpPanelLayout.b(r101.f448548a, SlidingUpPanelLayout.PanelState.ANCHORED);
    L22:
        if (this.f448550a != 0) goto L26;
        this.f448566q = null;
        return;
    L26:
        return;
    }

    public final boolean d(View r100, float r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        this.f448565p.getClass();
        if (((SlidingUpPanelLayout.c) this.f448565p).f448548a.f448537u <= 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return false;
    L11:
        if (Math.abs(r101) <= this.f448551b) goto L15;
        return true;
    L15:
        return false;
    L8:
        r102 = false;
        goto L9
    }

    public final View h(int r100, int r101) {
        int r102 = this.f448568s.getChildCount() - 1;
    L3:
        if (r102 < 0) goto L14;
        ViewGroup r103 = this.f448568s;
        this.f448565p.getClass();
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
        if (r100 != this.f448566q) goto L8;
        if (this.f448552c != r101) goto L8;
        return true;
    L8:
        if (r100 == null) goto L28;
        SlidingUpPanelLayout r102 = ((SlidingUpPanelLayout.c) this.f448565p).f448548a;
        if (r102.f448539w == false) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L28;
        this.f448552c = r101;
        if (r100.getParent() != this.f448568s) goto L27;
        this.f448566q = r100;
        this.f448552c = r101;
        SlidingUpPanelLayout r104 = ((SlidingUpPanelLayout.c) this.f448565p).f448548a;
        int r105 = r104.getChildCount();
        int r106 = 0;
    L19:
        if (r106 >= r105) goto L24;
        View r107 = r104.getChildAt(r106);
        if (r107.getVisibility() != 4) goto L23;
        r107.setVisibility(0);
    L23:
        r106 = r106 + 1;
        goto L19
    L24:
        o(1);
        return true;
    L27:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f448568s + ")");
    L12:
        if (r100 != r102.f448532p) goto L14;
        r103 = true;
    L28:
        return false;
    }

    public final int f(int r100, int r101, int r102) {
        if (r100 != 0) goto L5;
        return 0;
    L5:
        int r103 = this.f448568s.getWidth();
        float r104 = r103 / 2;
        float r105 = r104 + (((float) Math.sin((float) (((double) (Math.min(1.0f, Math.abs(r100) / r103) - 0.5f)) * 0.4712389167638204d))) * r104);
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
        int[] r107 = this.f448558i;
        r107[r102] = (r107[r102] | r106) == true ? 1 : 0;
        this.f448565p.getClass();
        return;
    }

    public final void m(float r110, float r111, int r112) {
        float[] r100 = this.f448553d;
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
        float[] r113 = this.f448554e;
        System.arraycopy(r113, 0, r104, 0, r113.length);
        float[] r114 = this.f448555f;
        System.arraycopy(r114, 0, r105, 0, r114.length);
        float[] r115 = this.f448556g;
        System.arraycopy(r115, 0, r106, 0, r115.length);
        int[] r116 = this.f448557h;
        System.arraycopy(r116, 0, r107, 0, r116.length);
        int[] r117 = this.f448558i;
        System.arraycopy(r117, 0, r108, 0, r117.length);
        int[] r118 = this.f448559j;
        System.arraycopy(r118, 0, r109, 0, r118.length);
    L9:
        this.f448553d = r103;
        this.f448554e = r104;
        this.f448555f = r105;
        this.f448556g = r106;
        this.f448557h = r107;
        this.f448558i = r108;
        this.f448559j = r109;
    L10:
        float[] r119 = this.f448553d;
        this.f448555f[r112] = r110;
        r119[r112] = r110;
        float[] r120 = this.f448554e;
        this.f448556g[r112] = r111;
        r120[r112] = r111;
        int[] r121 = this.f448557h;
        int r122 = (int) r110;
        int r123 = (int) r111;
        if (r122 >= (this.f448568s.getLeft() + this.f448563n)) goto L14;
        r101 = 1;
    L14:
        if (r123 >= (this.f448568s.getTop() + this.f448563n)) goto L17;
        r101 = r101 | 4;
    L17:
        if (r122 <= (this.f448568s.getRight() - this.f448563n)) goto L20;
        r101 = r101 | 2;
    L20:
        if (r123 <= (this.f448568s.getBottom() - this.f448563n)) goto L22;
        r101 = r101 | 8;
    L22:
        r121[r112] = r101;
        return;
    L5:
        if (r100.length > r112) goto L10;
        goto L6
    }

    public a(Context r100, ViewGroup r101, Interpolator r102, SlidingUpPanelLayout.c r103) {
        this.f448552c = -1;
        this.f448569t = new b(this);
        if (r101 == null) goto L11;
        this.f448568s = r101;
        this.f448565p = r103;
        ViewConfiguration r104 = ViewConfiguration.get(r100);
        Resources r105 = r100.getResources();
        this.f448563n = (int) ((WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density * 20.0f) + 0.5f);
        this.f448551b = r104.getScaledTouchSlop();
        this.f448561l = r104.getScaledMaximumFlingVelocity();
        this.f448562m = r104.getScaledMinimumFlingVelocity();
        if (r102 != null) goto L8;
        r102 = f448549u;
    L8:
        this.f448564o = ScrollerCompat.create(r100, r102);
        return;
    L11:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public final boolean c(float r100, float r101, int r102, int r103) {
        float r104 = Math.abs(r100);
        float r105 = Math.abs(r101);
        if ((this.f448557h[r102] & r103) == r103) goto L5;
        return false;
    L5:
        if ((0 & r103) != 0) goto L7;
        return false;
    L7:
        if ((this.f448559j[r102] & r103) != r103) goto L9;
        return false;
    L9:
        if ((this.f448558i[r102] & r103) == r103) goto L27;
        int r106 = this.f448551b;
        if (r104 > r106) goto L16;
        if (r105 > r106) goto L16;
        return false;
    L16:
        if (r104 >= (r105 * 0.5f)) goto L19;
        this.f448565p.getClass();
    L19:
        if ((this.f448558i[r102] & r103) == 0) goto L21;
        return false;
    L21:
        if (r104 <= this.f448551b) goto L29;
        return true;
    L29:
        return false;
    L27:
        return false;
    }

    public final boolean i(int r110, int r111, int r112, int r113) {
        int r100 = this.f448566q.getLeft();
        int r101 = this.f448566q.getTop();
        int r102 = r110 - r100;
        int r103 = r111 - r101;
        if (r102 != 0) goto L7;
        if (r103 != 0) goto L7;
        this.f448564o.abortAnimation();
        o(0);
        return false;
    L7:
        int r114 = (int) this.f448562m;
        int r104 = (int) this.f448561l;
        int r105 = Math.abs(r112);
        if (r105 >= r114) goto L10;
        r112 = 0;
    L14:
        int r115 = (int) this.f448562m;
        int r106 = (int) this.f448561l;
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
        this.f448565p.getClass();
        int r125 = f(r102, r112, 0);
        this.f448564o.startScroll(r100, r101, r102, r103, (int) ((r125 * r122) + (f(r103, r113, ((SlidingUpPanelLayout.c) this.f448565p).f448548a.f448537u) * (r123 / r124))));
        o(2);
        return true;
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
