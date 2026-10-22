package com.larus.common_ui.photoviewer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import j19.n;
import j19.o;
import j19.p;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import k19.d;
import k19.e;

/* JADX INFO: loaded from: classes27.dex */
public class ZoomableControllerImp extends com.larus.common_ui.photoviewer.a {
    public com.larus.common_ui.photoviewer.a.InterfaceC4188a A;
    public final RectF B;
    public boolean C;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float[] f327654o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float[] f327655p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float[] f327656q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Matrix f327657r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Matrix f327658s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Matrix f327659t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f327660u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f327661v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ValueAnimator f327662w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f327663x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final p f327664y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Scroller f327665z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LimitFlag {
    }

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f327666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ZoomableControllerImp f327667b;

        public final void a() {
            this.f327667b.f327662w.removeAllUpdateListeners();
            this.f327667b.f327662w.removeAllListeners();
            ZoomableControllerImp r100 = this.f327667b;
            if (r100.f327660u == false) goto L12;
            com.larus.common_ui.photoviewer.a.InterfaceC4188a r101 = r100.A;
            if (r101 == null) goto L11;
            r100.f327679l.getValues(r100.f327681n);
            if (r100.f327681n[0] <= 1.001f) goto L9;
            boolean r102 = true;
        L10:
            r101.a(r102);
            goto L11
        L9:
            r102 = false;
        L11:
            this.f327667b.f327660u = false;
        L12:
            Runnable r103 = this.f327666a;
            if (r103 == null) goto L16;
            r103.run();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            a();
        }

        public a(ZoomableControllerImp r100, Runnable r101) {
            this.f327667b = r100;
            this.f327666a = r101;
        }
    }

    public final boolean l() {
        if (this.f327662w.isRunning() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f327665z.computeScrollOffset() == true) goto L8;
        return false;
    }

    public boolean n() {
        if (this.f327661v == false) goto L24;
        e r100 = this.f327668a;
        if (Math.abs(this.f327678k.left - this.f327676i.left) >= 0.001f) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L12;
        if (m() == true) goto L12;
    L15:
        if (Math.abs(this.f327678k.right - this.f327676i.right) >= 0.001f) goto L17;
        boolean r102 = true;
    L18:
        if (r102 == true) goto L22;
        if (m() == false) goto L24;
    L22:
        if (r100.f501413l != 1) goto L24;
        return true;
    L17:
        r102 = false;
    L12:
        if (r100.f501413l != 3) goto L15;
        return true;
    L7:
        r101 = false;
    L24:
        return false;
    }

    public final void w() {
        if (this.f327662w.isRunning() == false) goto L6;
        this.f327662w.cancel();
        this.f327662w.removeAllUpdateListeners();
        this.f327662w.removeAllListeners();
        return;
    }

    public void x() {
        this.f327657r.set(this.f327679l);
        RectF r100 = this.f327676i;
        if ((o(this.f327657r, r100.centerX(), r100.centerY()) | p(this.f327657r)) == false) goto L6;
        this.C = true;
        u(this.f327657r, this.f327663x, this.f327664y, null);
        return;
    }

    public final boolean m() {
        if (l() == true) goto L17;
        this.f327679l.getValues(this.f327681n);
        float[] r100 = this.f327681n;
        r100[0] = r100[0] - 1.0f;
        r100[4] = r100[4] - 1.0f;
        r100[8] = r100[8] - 1.0f;
        int r101 = 0;
    L6:
        if (r101 >= 9) goto L11;
        if (Math.abs(this.f327681n[r101]) > 0.001f) goto L9;
        r101 = r101 + 1;
        goto L6
    L9:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        r102 = true;
        goto L12
    L17:
        return false;
    }

    @Override // k19.b
    public /* bridge */ /* synthetic */ void onGestureBegin(e r100) {
        q(r100);
    }

    @Override // k19.b
    public /* bridge */ /* synthetic */ void onGestureEnd(e r100) {
        r(r100);
    }

    @Override // k19.b
    public /* bridge */ /* synthetic */ void onGestureUpdate(e r100) {
        s(r100);
    }

    public final boolean p(Matrix r110) {
        RectF r100 = this.B;
        RectF r101 = this.f327677j;
        RectF r102 = this.f327676i;
        r100.set(r101);
        r110.mapRect(r100);
        float r103 = k(r100.left, r100.right, r102.left, r102.right, r101.centerX());
        float r104 = k(r100.top, r100.bottom, r102.top, r102.bottom, r101.centerY());
        if (r103 == 0.0f) goto L5;
    L9:
        r110.postTranslate(r103, r104);
        return true;
    L5:
        if (r104 != 0.0f) goto L9;
        return false;
    }

    public void q(e r100) {
        if (this.C == false) goto L5;
        return;
    L5:
        w();
        if (this.f327665z.computeScrollOffset() == false) goto L9;
        this.f327665z.forceFinished(true);
        return;
    }

    public void r(e r100) {
        if (this.C == false) goto L6;
        return;
    L6:
        if (this.f327660u == false) goto L16;
        com.larus.common_ui.photoviewer.a.InterfaceC4188a r101 = this.A;
        if (r101 == null) goto L14;
        this.f327679l.getValues(this.f327681n);
        if (this.f327681n[0] <= 1.001f) goto L12;
        boolean r102 = true;
    L13:
        r101.a(r102);
        goto L14
    L12:
        r102 = false;
    L14:
        this.f327660u = false;
        return;
    }

    public void s(e r100) {
        if (this.C == false) goto L6;
        return;
    L6:
        if (l() == false) goto L8;
        return;
    L8:
        boolean r101 = false;
        if (this.f327671d == true) goto L11;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == true) goto L19;
    L23:
        d r103 = r100.f501403b;
        int r104 = r103.f501392a;
        if (r104 == r103.f501393b) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == false) goto L33;
        if (r104 != 1) goto L30;
        boolean r106 = true;
    L31:
        if (r106 == false) goto L33;
        x();
        return;
    L30:
        r106 = false;
    L33:
        Matrix r107 = this.f327679l;
        e r108 = this.f327668a;
        r107.set(r107);
        if (this.f327672e == false) goto L37;
        r107.postTranslate(r108.f501410i, r108.f501411j);
    L37:
        if (this.f327671d == false) goto L45;
        if (r108.f501403b.f501392a <= 1) goto L41;
        boolean r109 = true;
    L42:
        if (r109 == false) goto L45;
        float r110 = r108.f501412k;
        r107.postScale(r110, r110, r108.f501408g, r108.f501409h);
        goto L45
    L41:
        r109 = false;
    L45:
        if (r108.f501403b.f501392a != 1) goto L47;
        r101 = true;
    L47:
        if (r101 == false) goto L49;
    L50:
        p(r107);
    L51:
        d();
        return;
    L49:
        if (this.f327671d == true) goto L51;
    L26:
        r105 = false;
        goto L27
    L19:
        if (this.f327660u == true) goto L23;
        this.f327660u = true;
        com.larus.common_ui.photoviewer.a.InterfaceC4188a r111 = this.A;
        if (r111 == null) goto L23;
        r111.b();
        goto L23
    L11:
        if (r100.f501403b.f501392a <= 1) goto L13;
        boolean r112 = true;
    L14:
        if (r112 == false) goto L16;
        r102 = true;
        goto L17
    L13:
        r112 = false;
        goto L14
    }

    public final boolean t(MotionEvent r100) {
        if (r100.getAction() != 3) goto L10;
        if (this.f327670c == false) goto L7;
        this.f327668a.b(r100);
        return true;
    L7:
        return false;
    L10:
        if (n() == false) goto L13;
        return false;
    L13:
        if (this.f327670c == false) goto L15;
        this.f327668a.b(r100);
        return true;
    L15:
        return false;
    }

    public final void v(Matrix r100) {
        if (this.f327662w.isRunning() == false) goto L5;
        w();
    L5:
        this.f327658s.set(r100);
        this.f327679l.set(r100);
        d();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [j19.p] */
    public ZoomableControllerImp(e r100, Context r101) {
        super(r100);
        this.f327654o = new float[9];
        this.f327655p = new float[9];
        this.f327656q = new float[9];
        this.f327657r = new Matrix();
        this.f327658s = new Matrix();
        this.f327659t = new Matrix();
        this.f327660u = false;
        this.f327661v = false;
        this.f327663x = 400;
        this.f327664y = new p(this);
        this.B = new RectF();
        this.C = false;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f327662w = r102;
        r102.setInterpolator(new DecelerateInterpolator(1.2f));
        this.f327665z = new Scroller(r101);
    }

    public final void j(Matrix r100, float r101, PointF r102) {
        PointF r103 = a(r102);
        r100.setScale(r101, r101, r103.x, r103.y);
        o(r100, r103.x, r103.y);
        p(r100);
    }

    public final boolean o(Matrix r100, float r101, float r102) {
        r100.getValues(this.f327681n);
        float r103 = this.f327681n[0];
        float r104 = Math.max(this.f327673f, r103);
        float r105 = this.f327674g;
        if (r105 != 0.0f) goto L5;
        r105 = this.f327675h;
    L5:
        float r106 = Math.min(r104, r105);
        if (r106 == r103) goto L9;
        float r107 = r106 / r103;
        r100.postScale(r107, r107, r101, r102);
        return true;
    L9:
        return false;
    }

    public final void u(Matrix r100, long r101, Runnable r102, final ValueAnimator.AnimatorUpdateListener r103) {
        if (this.f327662w.isRunning() == false) goto L5;
        w();
    L5:
        this.f327662w.setDuration(r101);
        this.f327679l.getValues(this.f327654o);
        r100.getValues(this.f327655p);
        this.f327662w.addUpdateListener(new o(this, r103));
        this.f327662w.addListener(new a(this, r102));
        this.f327662w.start();
    }

    public void y(float r100, PointF r101, Runnable r102, ValueAnimator.AnimatorUpdateListener r110) {
        if (this.f327671d == true) goto L6;
        return;
    L6:
        if (this.f327662w.isRunning() == false) goto L9;
        w();
    L9:
        if (this.f327660u == true) goto L13;
        this.f327660u = true;
        com.larus.common_ui.photoviewer.a.InterfaceC4188a r103 = this.A;
        if (r103 == null) goto L13;
        r103.b();
    L13:
        this.C = true;
        Runnable r104 = new n(this);
        this.f327657r.reset();
        j(this.f327657r, r100, r101);
        u(this.f327657r, this.f327663x, r104, null);
    }

    public final float k(float r100, float r101, float r102, float r103, float r104) {
        float r105 = r101 - r100;
        float r106 = r103 - r102;
        if (r105 >= (Math.min(r104 - r102, r103 - r104) * 2.0f)) goto L7;
        return r104 - ((r101 + r100) / 2.0f);
    L7:
        if (r105 >= r106) goto L15;
        if (r104 >= ((r102 + r103) / 2.0f)) goto L13;
        return r102 - r100;
    L13:
        return r103 - r101;
    L15:
        if (r100 <= r102) goto L19;
        return r102 - r100;
    L19:
        if (r101 < r103) goto L21;
        return 0.0f;
    L21:
        return r103 - r101;
    }
}
