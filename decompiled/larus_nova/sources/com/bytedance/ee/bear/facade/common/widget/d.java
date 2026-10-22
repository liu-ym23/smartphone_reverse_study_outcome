package com.bytedance.ee.bear.facade.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes16.dex */
public class d {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static float f226583p = 0.2f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static float f226584q = 0.6928f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static float f226585r = 0.9f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f226586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f226587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float[] f226588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f226589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f226590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f226591f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f226592g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f226593h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f226594i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f226595j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f226596k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f226597l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f226598m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public InterfaceC3246d f226599n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View.OnTouchListener f226600o;

    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f226601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f226602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f226603c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f226604d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f226605e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ View f226606f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d f226607g;

        public final String toString() {
            return "$classname{orgY=" + this.f226601a + ", offsetY=" + this.f226602b + ", orgDeltaY=" + this.f226603c + ", deltaY=" + this.f226604d + '}';
        }

        public a(d r100, View r101) {
            this.f226607g = r100;
            this.f226606f = r101;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            d r102 = this.f226607g;
            if (r102.f226596k == false) goto L9;
            View.OnTouchListener r103 = r102.f226600o;
            if (r103 == null) goto L9;
            if (r103.onTouch(r100, r101) == false) goto L9;
            return true;
        L9:
            int r104 = r101.getAction();
            if (r104 == 0) goto L50;
            if (r104 != 1) goto L13;
            tt5.a.h("DragPopupWindow", "ACTION_UP enableDrag:" + this.f226607g.f226596k);
            InterfaceC3246d r105 = this.f226607g.f226599n;
            if (r105 == null) goto L37;
            r105.a();
        L37:
            if (Math.abs(this.f226605e) >= 30.0f) goto L39;
            this.f226606f.performClick();
        L53:
            return true;
        L39:
            tt5.a.h("DragPopupWindow", "ACTION_CANCEL enableDrag:" + this.f226607g.f226596k);
            d r106 = this.f226607g;
            if (r106.f226596k == true) goto L42;
        L46:
            InterfaceC3246d r107 = this.f226607g.f226599n;
            if (r107 == null) goto L49;
            r107.c();
        L49:
            this.f226604d = 0.0f;
            this.f226603c = 0.0f;
            this.f226602b = 0.0f;
            this.f226601a = 0.0f;
            goto L53
        L42:
            if (this.f226602b >= 0.0f) goto L44;
            boolean r108 = true;
        L45:
            r106.g(r108);
            goto L46
        L44:
            r108 = false;
            goto L45
        L13:
            if (r104 != 2) goto L15;
            tt5.a.h("DragPopupWindow", "on  move event.getY():" + r101.getY());
            if (this.f226601a != 0.0f) goto L20;
            this.f226601a = r101.getRawY();
            this.f226603c = this.f226607g.c();
            this.f226605e = 0.0f;
        L20:
            float r109 = this.f226601a - r101.getRawY();
            this.f226602b = r109;
            this.f226605e += Math.abs(r109);
            d r110 = this.f226607g;
            if (r110.f226596k == false) goto L53;
            if (r110.f226595j == false) goto L25;
        L26:
            float r111 = this.f226603c + this.f226602b;
            this.f226604d = r111;
            if (r110.f226597l == true) goto L30;
            r110.l(r111);
            goto L53
        L30:
            if (r111 >= com.bytedance.ee.util.ui.n.t()) goto L32;
            this.f226607g.l(this.f226604d);
            goto L53
        L32:
            tt5.a.h("DragPopupWindow", "on  move deltaY:" + this.f226604d + " , sHeight: " + com.bytedance.ee.util.ui.n.t());
            goto L53
        L25:
            if (this.f226602b >= 0.0f) goto L53;
        L15:
            if (r104 == 3) goto L39;
        L50:
            tt5.a.h("DragPopupWindow", "ACTION_DOWN enableDrag:" + this.f226607g.f226596k);
            this.f226601a = r101.getRawY();
            this.f226603c = (float) this.f226607g.c();
            this.f226605e = 0.0f;
            d r112 = this.f226607g;
            InterfaceC3246d r113 = r112.f226599n;
            if (r113 == null) goto L53;
            r113.b(r112.c());
            goto L53
        }
    }

    public interface b {
        void a(int r100);
    }

    public interface c {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.facade.common.widget.d$d, reason: collision with other inner class name */
    public interface InterfaceC3246d {
        void a();

        void b(int r100);

        void c();
    }

    public final void e() {
        this.f226588c = new float[]{com.bytedance.ee.util.ui.n.t() * f226583p, com.bytedance.ee.util.ui.n.t() * f226584q, com.bytedance.ee.util.ui.n.t() * f226585r};
    }

    public final void a() {
        float r100 = this.f226588c[1];
        if (b() <= r100) goto L6;
        k(r100);
        return;
    }

    public int b() {
        return this.f226590e.getLayoutParams().height;
    }

    public int c() {
        int r100 = this.f226590e.getHeight();
        if (r100 == 0) goto L5;
        return r100;
    L5:
        if (this.f226590e.getLayoutParams() != null) goto L7;
        return r100;
    L7:
        if (this.f226590e.getLayoutParams().height > 0) goto L9;
        return r100;
    L9:
        return this.f226590e.getLayoutParams().height;
    }

    public final void f() {
        l(this.f226588c[1]);
    }

    public static void h() {
        f226583p = 0.2f;
        f226584q = 0.6928f;
        f226585r = 0.9f;
    }

    public final void d(int r100) {
        b r101 = this.f226593h;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public final void g(boolean r100) {
        int r101 = b();
        float[] r102 = this.f226588c;
        float r103 = this.f226589d;
        int r104 = 0;
        if (r103 != (-1.0f)) goto L5;
    L7:
        int r105 = 0;
    L9:
        if (r105 >= r102.length) goto L14;
        if (r101 < r102[r105]) goto L15;
        r105 = r105 + 1;
    L15:
        if (r105 != (-1)) goto L17;
        float r106 = (int) r102[r102.length - 1];
    L31:
        tt5.a.h("DragPopupWindow", "position:" + r105);
        tt5.a.h("DragPopupWindow", "targetHeight:" + r106);
    L32:
        float[] r107 = this.f226588c;
        if (r104 >= r107.length) goto L38;
        if (r106 <= r107[r104]) goto L36;
        r104 = r104 + 1;
        goto L32
    L36:
        this.f226594i = r104;
    L38:
        ValueAnimator r108 = this.f226591f;
        if (r108 == null) goto L41;
        r108.cancel();
    L41:
        k(r106);
        return;
    L17:
        if (r105 == 0) goto L30;
        float r109 = r102[r105];
        float r110 = r102[r105 - 1];
        float r111 = r109 - r110;
        float r112 = r101;
        if (r112 >= ((this.f226586a * r111) + r110)) goto L23;
    L26:
        r106 = r110;
    L29:
        if (r106 > r102[0]) goto L31;
    L23:
        if (r112 > ((r111 * this.f226587b) + r110)) goto L27;
        if (r100 == true) goto L26;
    L27:
        r106 = r109;
    L30:
        r106 = 0.0f;
        goto L31
    L14:
        r105 = -1;
        goto L15
    L5:
        if (r102.length != 3) goto L7;
        r102 = new float[]{r102[0], r103, r102[1], r102[2]};
        goto L7
    }

    public final void i(View r100) {
        r100.setOnTouchListener(new a(this, r100));
    }

    public final void k(float r100) {
        j(r100, (int) (Math.abs(b() - r100) / this.f226592g));
    }

    public void l(float r100) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r101 = this.f226590e.getLayoutParams();
        if (r101 == null) goto L12;
        int r102 = (int) r100;
        if (r102 != r101.height) goto L10;
        return;
    L10:
        r101.height = r102;
        this.f226590e.setLayoutParams(r101);
        d(r102);
        return;
    }

    public d(Context r100, View r110) {
        this(r100, r110, com.bytedance.ee.util.ui.n.t() * f226583p, com.bytedance.ee.util.ui.n.u(r100) * 0.6928f, com.bytedance.ee.util.ui.n.t() * f226585r);
    }

    public final ValueAnimator j(float r100, long r101) {
        int r102 = b();
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{r102, (int) r100});
        this.f226591f = r103;
        r103.setDuration(r101);
        this.f226591f.addUpdateListener(new com.bytedance.ee.bear.facade.common.widget.c(this));
        this.f226591f.start();
        if (r102 <= r100) goto L12;
        if (r100 != 0.0f) goto L12;
        c r104 = this.f226598m;
        if (r104 == null) goto L12;
        dy4.c r105 = ((ey4.c) r104).f474799a.f217673d;
        if (r105 == null) goto L12;
        r105.ag();
    L12:
        return this.f226591f;
    }

    public void m(float r100, float r101, float r102) {
        if (r101 <= r102) goto L5;
    L6:
        r101 = ((r102 - r100) * 0.5f) + r100;
    L7:
        this.f226588c = new float[]{r100, r101, r102};
        return;
    L5:
        if (r101 >= r100) goto L7;
        goto L6
    }

    public final void n(float r100, float r101, float r102, float r103) {
        m(r100, r102, r103);
        if (r101 > r100) goto L5;
    L7:
        tt5.a.h("DragPopupWindow", "updatePanelHeight: min = " + r100 + ", shrink = " + r101 + ", mid = " + r102 + ", max = " + r103);
        return;
    L5:
        if (r101 >= r102) goto L7;
        this.f226589d = r101;
        goto L7
    }

    public d(Context r100, View r101, float r102, float r103, float r104) {
        this.f226586a = 0.1f;
        this.f226587b = 0.9f;
        this.f226589d = -1.0f;
        this.f226594i = 1;
        this.f226595j = true;
        this.f226596k = true;
        this.f226597l = false;
        this.f226600o = null;
        this.f226590e = r101;
        if (r103 <= r104) goto L5;
    L6:
        r103 = r102 + ((r104 - r102) * 0.5f);
    L7:
        this.f226588c = new float[]{r102, r103, r104};
        this.f226592g = com.bytedance.ee.util.ui.n.f(r100, 180) / 200;
        l(r103);
        return;
    L5:
        if (r103 >= r102) goto L7;
        goto L6
    }
}
