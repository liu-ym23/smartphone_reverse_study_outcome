package com.bytedance.live.photoviewer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import uj6.c;
import uj6.f;
import wj6.d;
import wj6.e;

/* JADX INFO: loaded from: classes19.dex */
public class ZoomableControllerImp extends uj6.a {
    public boolean A;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float[] f255621n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float[] f255622o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float[] f255623p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Matrix f255624q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Matrix f255625r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Matrix f255626s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c f255627t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f255628u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ValueAnimator f255629v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f255630w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f f255631x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Scroller f255632y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RectF f255633z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LimitFlag {
    }

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f255634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ZoomableControllerImp f255635b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f255635b.f255629v.removeAllUpdateListeners();
            this.f255635b.f255629v.removeAllListeners();
            Runnable r101 = this.f255634a;
            if (r101 == null) goto L6;
            r101.run();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f255635b.f255629v.removeAllUpdateListeners();
            this.f255635b.f255629v.removeAllListeners();
            Runnable r101 = this.f255634a;
            if (r101 == null) goto L6;
            r101.run();
            return;
        }

        public a(ZoomableControllerImp r100, Runnable r101) {
            this.f255635b = r100;
            this.f255634a = r101;
        }
    }

    public void m() {
    }

    public final boolean h() {
        if (this.f255629v.isRunning() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f255632y.computeScrollOffset() == true) goto L8;
        return false;
    }

    public final void q() {
        if (this.f255629v.isRunning() == false) goto L6;
        this.f255629v.cancel();
        this.f255629v.removeAllUpdateListeners();
        this.f255629v.removeAllListeners();
        return;
    }

    public final boolean i() {
        if (h() == true) goto L17;
        this.f550404k.getValues(this.f550406m);
        float[] r100 = this.f550406m;
        r100[0] = r100[0] - 1.0f;
        r100[4] = r100[4] - 1.0f;
        r100[8] = r100[8] - 1.0f;
        int r101 = 0;
    L6:
        if (r101 >= 9) goto L11;
        if (Math.abs(this.f550406m[r101]) > 0.001f) goto L9;
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

    public final boolean k(Matrix r110) {
        RectF r100 = this.f255633z;
        RectF r101 = this.f550402i;
        RectF r102 = this.f550401h;
        r100.set(r101);
        r110.mapRect(r100);
        float r103 = g(r100.left, r100.right, r102.left, r102.right, r101.centerX());
        float r104 = g(r100.top, r100.bottom, r102.top, r102.bottom, r101.centerY());
        if (r103 == 0.0f) goto L5;
    L9:
        r110.postTranslate(r103, r104);
        return true;
    L5:
        if (r104 != 0.0f) goto L9;
        return false;
    }

    public void l(e r100) {
        if (this.A == false) goto L5;
        return;
    L5:
        q();
        if (this.f255632y.computeScrollOffset() == false) goto L9;
        this.f255632y.forceFinished(true);
        return;
    }

    public void n(e r110) {
        if (this.A == false) goto L6;
        return;
    L6:
        if (h() == false) goto L8;
        return;
    L8:
        d r111 = r110.f560032b;
        int r100 = r111.f560021a;
        boolean r101 = false;
        if (r100 == r111.f560022b) goto L11;
        boolean r112 = true;
    L12:
        if (r112 == false) goto L20;
        if (r100 != 1) goto L15;
        boolean r113 = true;
    L16:
        if (r113 == false) goto L20;
        this.f255624q.set(this.f550404k);
        RectF r114 = this.f550401h;
        if ((j(this.f255624q, r114.centerX(), r114.centerY()) | k(this.f255624q)) == false) goto L38;
        this.A = true;
        p(this.f255624q, this.f255630w, this.f255631x, null);
        return;
    L38:
        return;
    L15:
        r113 = false;
    L20:
        Matrix r115 = this.f550404k;
        e r102 = this.f550394a;
        r115.set(r115);
        if (this.f550398e == false) goto L24;
        r115.postTranslate(r102.f560039i, r102.f560040j);
    L24:
        if (this.f550397d == false) goto L32;
        if (r102.f560032b.f560021a <= 1) goto L28;
        boolean r103 = true;
    L29:
        if (r103 == false) goto L32;
        float r104 = r102.f560041k;
        r115.postScale(r104, r104, r102.f560037g, r102.f560038h);
        goto L32
    L28:
        r103 = false;
    L32:
        if (r102.f560032b.f560021a != 1) goto L34;
        r101 = true;
    L34:
        if (r101 == false) goto L36;
        k(r115);
    L36:
        c();
        return;
    L11:
        r112 = false;
        goto L12
    }

    public final boolean o(MotionEvent r100) {
        if (r100.getAction() != 3) goto L10;
        if (this.f550396c == false) goto L7;
        this.f550394a.b(r100);
        return true;
    L7:
        return false;
    L10:
        if (this.f255628u == false) goto L31;
        e r101 = this.f550394a;
        if (Math.abs(this.f550403j.left - this.f550401h.left) >= 0.001f) goto L14;
        boolean r102 = true;
    L15:
        if (r102 == true) goto L19;
        if (i() == true) goto L19;
    L22:
        if (Math.abs(this.f550403j.right - this.f550401h.right) >= 0.001f) goto L24;
        boolean r103 = true;
    L25:
        if (r103 == true) goto L29;
        if (i() == false) goto L31;
    L29:
        if (r101.f560042l != 1) goto L31;
    L30:
        boolean r104 = true;
    L32:
        if (r104 == false) goto L35;
        return false;
    L35:
        if (this.f550396c == false) goto L37;
        this.f550394a.b(r100);
        return true;
    L37:
        return false;
    L24:
        r103 = false;
    L19:
        if (r101.f560042l != 3) goto L22;
    L14:
        r102 = false;
    L31:
        r104 = false;
        goto L32
    }

    @Override // wj6.b
    public /* bridge */ /* synthetic */ void onGestureBegin(e r100) {
        l(r100);
    }

    @Override // wj6.b
    public /* bridge */ /* synthetic */ void onGestureEnd(e r100) {
        m();
    }

    @Override // wj6.b
    public /* bridge */ /* synthetic */ void onGestureUpdate(e r100) {
        n(r100);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [uj6.f] */
    public ZoomableControllerImp(e r100, Context r101) {
        super(r100);
        this.f255621n = new float[9];
        this.f255622o = new float[9];
        this.f255623p = new float[9];
        this.f255624q = new Matrix();
        this.f255625r = new Matrix();
        this.f255626s = new Matrix();
        this.f255628u = false;
        this.f255630w = 400;
        this.f255631x = new f(this);
        this.f255633z = new RectF();
        this.A = false;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f255629v = r102;
        r102.setInterpolator(new DecelerateInterpolator());
        this.f255632y = new Scroller(r101);
    }

    public final boolean j(Matrix r100, float r101, float r102) {
        float r103 = b(r100);
        float r104 = Math.max(1.0f, r103);
        float r105 = this.f550399f;
        if (r105 != 0.0f) goto L5;
        r105 = this.f550400g;
    L5:
        float r106 = Math.min(r104, r105);
        if (r106 == r103) goto L9;
        float r107 = r106 / r103;
        r100.postScale(r107, r107, r101, r102);
        return true;
    L9:
        return false;
    }

    public final void p(Matrix r100, long r101, Runnable r102, ValueAnimator.AnimatorUpdateListener r103) {
        if (this.f255629v.isRunning() == false) goto L5;
        q();
    L5:
        this.f255629v.setDuration(r101);
        this.f550404k.getValues(this.f255621n);
        r100.getValues(this.f255622o);
        final zj6.f.c r104 = (zj6.f.c) r103;
        this.f255629v.addUpdateListener(new uj6.e(this, r104));
        this.f255629v.addListener(new a(this, r102));
        this.f255629v.start();
    }

    public final float g(float r100, float r101, float r102, float r103, float r104) {
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
