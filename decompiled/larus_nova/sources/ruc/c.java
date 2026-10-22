package ruc;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes42.dex */
public abstract class c implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f539334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final suc.a f539335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f539336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f539337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f539338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InterfaceC7539c f539339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ruc.a f539340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ruc.b f539341h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f539342i;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Property<View, Float> f539343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f539344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f539345c;

        public a() {
        }

        public abstract void a(View r100);
    }

    public class b implements InterfaceC7539c, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Interpolator f539346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f539347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f539348c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a f539349d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ c f539350e;

        @Override // ruc.c.InterfaceC7539c
        public final int a() {
            return 3;
        }

        @Override // ruc.c.InterfaceC7539c
        public final boolean b(MotionEvent r100) {
            return true;
        }

        @Override // ruc.c.InterfaceC7539c
        public final boolean d() {
            return true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public b(c r100) {
            this.f539350e = r100;
            this.f539346a = new DecelerateInterpolator();
            this.f539347b = -2.0f;
            this.f539348c = -4.0f;
            this.f539349d = r100.a();
        }

        public final ObjectAnimator e(float r100) {
            View r101 = this.f539350e.f539335b.getView();
            float r102 = Math.abs(r100);
            a r103 = this.f539349d;
            float r104 = (r102 / r103.f539345c) * 800.0f;
            ObjectAnimator r105 = ObjectAnimator.ofFloat(r101, r103.f539343a, new float[]{this.f539350e.f539334a.f539357b});
            r105.setDuration(Math.max((int) r104, 200));
            r105.setInterpolator(this.f539346a);
            r105.addUpdateListener(this);
            return r105;
        }

        public final void f(InterfaceC7539c r100) {
            ruc.a r101 = this.f539350e.f539340g;
            r100.a();
            r101.getClass();
            View r102 = this.f539350e.f539335b.getView();
            this.f539349d.a(r102);
            c r103 = this.f539350e;
            float r104 = r103.f539342i;
            float r105 = 0.0f;
            if (r104 != 0.0f) goto L5;
        L17:
            Animator r106 = e(this.f539349d.f539344b);
        L18:
            r106.addListener(this);
            r106.start();
            return;
        L5:
            if (r104 < 0.0f) goto L7;
        L8:
            if (r104 > 0.0f) goto L10;
        L12:
            float r107 = -r104;
            float r108 = r107 / this.f539347b;
            if (r108 < 0.0f) goto L16;
            r105 = r108;
        L16:
            float r109 = (r107 * r104) / this.f539348c;
            a r110 = this.f539349d;
            float r111 = r110.f539344b + r109;
            ObjectAnimator r112 = ObjectAnimator.ofFloat(r102, r110.f539343a, new float[]{r111});
            r112.setDuration((int) r105);
            r112.setInterpolator(this.f539346a);
            r112.addUpdateListener(this);
            ObjectAnimator r113 = e(r111);
            AnimatorSet r114 = new AnimatorSet();
            r114.playSequentially(new Animator[]{r112, r113});
            r106 = r114;
            goto L18
        L10:
            if (r103.f539334a.f539358c == true) goto L12;
        L7:
            if (r103.f539334a.f539358c == true) goto L17;
            goto L8
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            c r101 = this.f539350e;
            d r102 = r101.f539336c;
            InterfaceC7539c r103 = r101.f539339f;
            r101.f539339f = r102;
            r102.c(r103);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            ruc.b r101 = this.f539350e.f539341h;
            ((Float) r100.getAnimatedValue()).floatValue();
            r101.getClass();
        }
    }

    /* JADX INFO: renamed from: ruc.c$c, reason: collision with other inner class name */
    public interface InterfaceC7539c {
        int a();

        boolean b(MotionEvent r100);

        boolean d();
    }

    public class d implements InterfaceC7539c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f539351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f539352b;

        @Override // ruc.c.InterfaceC7539c
        public final int a() {
            return 0;
        }

        @Override // ruc.c.InterfaceC7539c
        public final boolean d() {
            return false;
        }

        public d(c r100) {
            this.f539352b = r100;
            this.f539351a = r100.b();
        }

        @Override // ruc.c.InterfaceC7539c
        public final boolean b(MotionEvent r100) {
            View r101 = this.f539352b.f539335b.getView();
            if (this.f539351a.a(r101, r100) == true) goto L6;
            return false;
        L6:
            if (this.f539352b.f539335b.a() == false) goto L10;
            if (this.f539351a.f539355c == false) goto L10;
        L13:
            f r102 = this.f539352b.f539334a;
            r102.f539356a = r100.getPointerId(0);
            c r103 = this.f539352b;
            f r104 = r103.f539334a;
            e r105 = this.f539351a;
            r104.f539357b = r105.f539353a;
            r104.f539358c = r105.f539355c;
            g r106 = r103.f539337d;
            InterfaceC7539c r107 = r103.f539339f;
            r103.f539339f = r106;
            r106.c(r107);
            this.f539352b.f539337d.b(r100);
            return true;
        L10:
            if (this.f539352b.f539335b.b() == true) goto L12;
        L15:
            return false;
        L12:
            if (this.f539351a.f539355c == true) goto L15;
            goto L13
        }

        public final void c(InterfaceC7539c r100) {
            ruc.a r101 = this.f539352b.f539340g;
            r100.a();
            r101.getClass();
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f539353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f539354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f539355c;

        public e() {
        }

        public abstract boolean a(View r100, MotionEvent r101);
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f539356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f539357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f539358c;

        public f() {
        }
    }

    public class g implements InterfaceC7539c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f539359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f539360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f539361c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f539362d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ c f539363e;

        @Override // ruc.c.InterfaceC7539c
        public final boolean d() {
            c r100 = this.f539363e;
            b r101 = r100.f539338e;
            InterfaceC7539c r102 = r100.f539339f;
            r100.f539339f = r101;
            r101.f(r102);
            return false;
        }

        @Override // ruc.c.InterfaceC7539c
        public final int a() {
            return this.f539362d;
        }

        public g(c r100) {
            this.f539363e = r100;
            this.f539361c = r100.b();
            this.f539359a = 3.0f;
            this.f539360b = 1.0f;
        }

        @Override // ruc.c.InterfaceC7539c
        public final boolean b(MotionEvent r110) {
            if (this.f539363e.f539334a.f539356a == r110.getPointerId(0)) goto L6;
            c r111 = this.f539363e;
            b r100 = r111.f539338e;
            InterfaceC7539c r101 = r111.f539339f;
            r111.f539339f = r100;
            r100.f(r101);
            return true;
        L6:
            View r102 = this.f539363e.f539335b.getView();
            if (this.f539361c.a(r102, r110) == true) goto L9;
            return true;
        L9:
            e r103 = this.f539361c;
            float r104 = r103.f539354b;
            boolean r105 = r103.f539355c;
            c r106 = this.f539363e;
            f r107 = r106.f539334a;
            boolean r108 = r107.f539358c;
            if (r105 != r108) goto L12;
            float r109 = this.f539359a;
        L13:
            float r112 = r104 / r109;
            float r113 = r103.f539353a + r112;
            if (r108 == false) goto L18;
            if (r105 == true) goto L18;
            if (r113 > r107.f539357b) goto L18;
        L22:
            r106.d(r102, r107.f539357b, r110);
            this.f539363e.f539341h.getClass();
            c r114 = this.f539363e;
            d r115 = r114.f539336c;
            InterfaceC7539c r116 = r114.f539339f;
            r114.f539339f = r115;
            r115.c(r116);
            return true;
        L18:
            if (r108 == true) goto L25;
            if (r105 == false) goto L25;
            if (r113 >= r107.f539357b) goto L22;
        L25:
            if (r102.getParent() == null) goto L27;
            r102.getParent().requestDisallowInterceptTouchEvent(true);
        L27:
            long r117 = r110.getEventTime() - r110.getHistoricalEventTime(0);
            if (r117 <= 0) goto L30;
            this.f539363e.f539342i = r112 / r117;
        L30:
            this.f539363e.c(r102, r113);
            this.f539363e.f539341h.getClass();
            return true;
        L12:
            r109 = this.f539360b;
            goto L13
        }

        public final void c(InterfaceC7539c r100) {
            c r101 = this.f539363e;
            if (r101.f539334a.f539358c == false) goto L5;
            int r102 = 1;
        L6:
            this.f539362d = r102;
            ruc.a r103 = r101.f539340g;
            r100.a();
            r103.getClass();
            return;
        L5:
            r102 = 2;
            goto L6
        }
    }

    public abstract a a();

    public abstract e b();

    public abstract void c(View r100, float r101);

    public abstract void d(View r100, float r101, MotionEvent r102);

    public c(suc.b r100) {
        this.f539334a = new f();
        this.f539340g = new ruc.a();
        this.f539341h = new ruc.b();
        this.f539335b = r100;
        this.f539338e = new b(this);
        this.f539337d = new g(this);
        d r101 = new d(this);
        this.f539336c = r101;
        this.f539339f = r101;
        r100.getView().setOnTouchListener(this);
        r100.getView().setOverScrollMode(2);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 == 1) goto L13;
        if (r102 == 2) goto L11;
        if (r102 == 3) goto L13;
        return false;
    L11:
        return this.f539339f.b(r101);
    L13:
        return this.f539339f.d();
    }
}
