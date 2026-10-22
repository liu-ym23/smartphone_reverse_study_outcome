package com.bytedance.ee.bear.facade.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class d {
    public static float p = 0.2f;
    public static float q = 0.6928f;
    public static float r = 0.9f;
    public float a;
    public float b;
    public float[] c;
    public float d;
    public View e;
    public ValueAnimator f;
    public float g;
    public b h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;
    public c m;
    public InterfaceC0190d n;
    public View.OnTouchListener o;

    public class a implements View.OnTouchListener {
        public float a;
        public float b;
        public float c;
        public float d;
        public float e;
        public final /* synthetic */ View f;
        public final /* synthetic */ d g;

        public final String toString() {
            return "$classname{orgY=" + this.a + ", offsetY=" + this.b + ", orgDeltaY=" + this.c + ", deltaY=" + this.d + '}';
        }

        public a(d r1, View r2) {
            this.g = r1;
            this.f = r2;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r5, MotionEvent r6) {
            d r0 = this.g;
            if (r0.k == false) goto L9;
            View.OnTouchListener r1 = r0.o;
            if (r1 == null) goto L9;
            if (r1.onTouch(r5, r6) == false) goto L9;
            return true;
        L9:
            int r7 = r6.getAction();
            if (r7 == 0) goto L50;
            if (r7 != 1) goto L13;
            tt5.a.h("DragPopupWindow", "ACTION_UP enableDrag:" + this.g.k);
            InterfaceC0190d r8 = this.g.n;
            if (r8 == null) goto L37;
            r8.a();
        L37:
            if (Math.abs(this.e) >= 30.0f) goto L39;
            this.f.performClick();
        L53:
            return true;
        L39:
            tt5.a.h("DragPopupWindow", "ACTION_CANCEL enableDrag:" + this.g.k);
            d r9 = this.g;
            if (r9.k == true) goto L42;
        L46:
            InterfaceC0190d r10 = this.g.n;
            if (r10 == null) goto L49;
            r10.c();
        L49:
            this.d = 0.0f;
            this.c = 0.0f;
            this.b = 0.0f;
            this.a = 0.0f;
            goto L53
        L42:
            if (this.b >= 0.0f) goto L44;
            boolean r11 = true;
        L45:
            r9.g(r11);
            goto L46
        L44:
            r11 = false;
            goto L45
        L13:
            if (r7 != 2) goto L15;
            tt5.a.h("DragPopupWindow", "on  move event.getY():" + r6.getY());
            if (this.a != 0.0f) goto L20;
            this.a = r6.getRawY();
            this.c = this.g.c();
            this.e = 0.0f;
        L20:
            float r12 = this.a - r6.getRawY();
            this.b = r12;
            this.e += Math.abs(r12);
            d r13 = this.g;
            if (r13.k == false) goto L53;
            if (r13.j == false) goto L25;
        L26:
            float r14 = this.c + this.b;
            this.d = r14;
            if (r13.l == true) goto L30;
            r13.l(r14);
            goto L53
        L30:
            if (r14 >= com.bytedance.ee.util.ui.n.t()) goto L32;
            this.g.l(this.d);
            goto L53
        L32:
            tt5.a.h("DragPopupWindow", "on  move deltaY:" + this.d + " , sHeight: " + com.bytedance.ee.util.ui.n.t());
            goto L53
        L25:
            if (this.b >= 0.0f) goto L53;
        L15:
            if (r7 == 3) goto L39;
        L50:
            tt5.a.h("DragPopupWindow", "ACTION_DOWN enableDrag:" + this.g.k);
            this.a = r6.getRawY();
            this.c = (float) this.g.c();
            this.e = 0.0f;
            d r16 = this.g;
            InterfaceC0190d r17 = r16.n;
            if (r17 == null) goto L53;
            r17.b(r16.c());
            goto L53
        }
    }

    public interface b {
        void a(int r1);
    }

    public interface c {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.facade.common.widget.d$d, reason: collision with other inner class name */
    public interface InterfaceC0190d {
        void a();

        void b(int r1);

        void c();
    }

    public final void e() {
        this.c = new float[]{com.bytedance.ee.util.ui.n.t() * p, com.bytedance.ee.util.ui.n.t() * q, com.bytedance.ee.util.ui.n.t() * r};
    }

    public final void a() {
        float r0 = this.c[1];
        if (b() <= r0) goto L6;
        k(r0);
        return;
    }

    public int b() {
        return this.e.getLayoutParams().height;
    }

    public int c() {
        int r0 = this.e.getHeight();
        if (r0 == 0) goto L5;
        return r0;
    L5:
        if (this.e.getLayoutParams() != null) goto L7;
        return r0;
    L7:
        if (this.e.getLayoutParams().height > 0) goto L9;
        return r0;
    L9:
        return this.e.getLayoutParams().height;
    }

    public final void f() {
        l(this.c[1]);
    }

    public static void h() {
        p = 0.2f;
        q = 0.6928f;
        r = 0.9f;
    }

    public final void d(int r2) {
        b r0 = this.h;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public final void g(boolean r9) {
        int r0 = b();
        float[] r1 = this.c;
        float r2 = this.d;
        int r4 = 0;
        if (r2 != (-1.0f)) goto L5;
    L7:
        int r3 = 0;
    L9:
        if (r3 >= r1.length) goto L14;
        if (r0 < r1[r3]) goto L15;
        r3 = r3 + 1;
    L15:
        if (r3 != (-1)) goto L17;
        float r10 = (int) r1[r1.length - 1];
    L31:
        tt5.a.h("DragPopupWindow", "position:" + r3);
        tt5.a.h("DragPopupWindow", "targetHeight:" + r10);
    L32:
        float[] r5 = this.c;
        if (r4 >= r5.length) goto L38;
        if (r10 <= r5[r4]) goto L36;
        r4 = r4 + 1;
        goto L32
    L36:
        this.i = r4;
    L38:
        ValueAnimator r6 = this.f;
        if (r6 == null) goto L41;
        r6.cancel();
    L41:
        k(r10);
        return;
    L17:
        if (r3 == 0) goto L30;
        float r7 = r1[r3];
        float r8 = r1[r3 - 1];
        float r11 = r7 - r8;
        float r12 = r0;
        if (r12 >= ((this.a * r11) + r8)) goto L23;
    L26:
        r10 = r8;
    L29:
        if (r10 > r1[0]) goto L31;
    L23:
        if (r12 > ((r11 * this.b) + r8)) goto L27;
        if (r9 == true) goto L26;
    L27:
        r10 = r7;
    L30:
        r10 = 0.0f;
        goto L31
    L14:
        r3 = -1;
        goto L15
    L5:
        if (r1.length != 3) goto L7;
        r1 = new float[]{r1[0], r2, r1[1], r1[2]};
        goto L7
    }

    public final void i(View r2) {
        r2.setOnTouchListener(new a(this, r2));
    }

    public final void k(float r3) {
        j(r3, (int) (Math.abs(b() - r3) / this.g));
    }

    public void l(float r3) {
        if (r3 >= 0.0f) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r0 = this.e.getLayoutParams();
        if (r0 == null) goto L12;
        int r4 = (int) r3;
        if (r4 != r0.height) goto L10;
        return;
    L10:
        r0.height = r4;
        this.e.setLayoutParams(r0);
        d(r4);
        return;
    }

    public d(Context r9, View r10) {
        this(r9, r10, com.bytedance.ee.util.ui.n.t() * p, com.bytedance.ee.util.ui.n.u(r9) * 0.6928f, com.bytedance.ee.util.ui.n.t() * r);
    }

    public final ValueAnimator j(float r5, long r6) {
        int r0 = b();
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{r0, (int) r5});
        this.f = r1;
        r1.setDuration(r6);
        this.f.addUpdateListener(new com.bytedance.ee.bear.facade.common.widget.c(this));
        this.f.start();
        if (r0 <= r5) goto L12;
        if (r5 != 0.0f) goto L12;
        c r7 = this.m;
        if (r7 == null) goto L12;
        dy4.c r8 = ((ey4.c) r7).a.d;
        if (r8 == null) goto L12;
        r8.ag();
    L12:
        return this.f;
    }

    public void m(float r3, float r4, float r5) {
        if (r4 <= r5) goto L5;
    L6:
        r4 = ((r5 - r3) * 0.5f) + r3;
    L7:
        this.c = new float[]{r3, r4, r5};
        return;
    L5:
        if (r4 >= r3) goto L7;
        goto L6
    }

    public final void n(float r3, float r4, float r5, float r6) {
        m(r3, r5, r6);
        if (r4 > r3) goto L5;
    L7:
        tt5.a.h("DragPopupWindow", "updatePanelHeight: min = " + r3 + ", shrink = " + r4 + ", mid = " + r5 + ", max = " + r6);
        return;
    L5:
        if (r4 >= r5) goto L7;
        this.d = r4;
        goto L7
    }

    public d(Context r4, View r5, float r6, float r7, float r8) {
        this.a = 0.1f;
        this.b = 0.9f;
        this.d = -1.0f;
        this.i = 1;
        this.j = true;
        this.k = true;
        this.l = false;
        this.o = null;
        this.e = r5;
        if (r7 <= r8) goto L5;
    L6:
        r7 = r6 + ((r8 - r6) * 0.5f);
    L7:
        this.c = new float[]{r6, r7, r8};
        this.g = com.bytedance.ee.util.ui.n.f(r4, 180) / 200;
        l(r7);
        return;
    L5:
        if (r7 >= r6) goto L7;
        goto L6
    }
}
