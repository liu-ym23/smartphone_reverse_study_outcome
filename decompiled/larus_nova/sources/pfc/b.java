package pfc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.RectF;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f529031a;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RectF f529032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RectF f529033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RectF f529034c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f529035d;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            float r101 = r100.getAnimatedFraction();
            RectF r102 = this.f529032a;
            RectF r103 = this.f529033b;
            float r104 = r103.left;
            RectF r105 = this.f529034c;
            float r106 = r105.left;
            r102.left = ((r104 - r106) * r101) + r106;
            float r107 = r103.right;
            float r108 = r105.right;
            r102.right = ((r107 - r108) * r101) + r108;
            float r109 = r103.top;
            float r110 = r105.top;
            r102.top = ((r109 - r110) * r101) + r110;
            float r111 = r103.bottom;
            float r112 = r105.bottom;
            r102.bottom = ((r111 - r112) * r101) + r112;
            this.f529035d.f529031a.d(r102);
        }

        public a(b r100, RectF r101, RectF r102, RectF r103) {
            this.f529035d = r100;
            this.f529032a = r101;
            this.f529033b = r102;
            this.f529034c = r103;
        }
    }

    /* JADX INFO: renamed from: pfc.b$b, reason: collision with other inner class name */
    public class C7194b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f529036a;

        public C7194b(b r100) {
            this.f529036a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            super.onAnimationCancel(r100);
            this.f529036a.f529031a.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f529036a.f529031a.b();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            this.f529036a.f529031a.c();
        }
    }

    public static abstract class c {
        public c() {
        }

        public void a() {
        }

        public void b() {
        }

        public void c() {
        }

        public abstract void d(RectF r100);
    }

    public b(c r100) {
        this.f529031a = r100;
    }

    public final boolean a(RectF r110, RectF r111) {
        boolean r100 = false;
        boolean r101 = true;
        if (Math.abs((r110.width() / r110.height()) - (r111.width() / r111.height())) >= 0.001f) goto L25;
        RectF r102 = new RectF(r110);
        RectF r103 = new RectF();
        if (r102.width() < r111.width()) goto L7;
    L9:
        r103.set(r110);
        float r112 = r103.top;
        float r104 = r111.top;
        if (r112 <= r104) goto L12;
        r103.offset(0.0f, r104 - r112);
        r100 = true;
    L12:
        float r113 = r103.left;
        float r105 = r111.left;
        if (r113 <= r105) goto L15;
        r103.offset(r105 - r113, 0.0f);
        r100 = true;
    L15:
        float r114 = r103.bottom;
        float r106 = r111.bottom;
        if (r114 >= r106) goto L18;
        r103.offset(0.0f, r106 - r114);
        r100 = true;
    L18:
        float r115 = r103.right;
        float r116 = r111.right;
        if (r115 >= r116) goto L21;
        r103.offset(r116 - r115, 0.0f);
    L22:
        if (r101 == false) goto L24;
        b(r102, r103, 300);
    L24:
        return r101;
    L21:
        r101 = r100;
        goto L22
    L7:
        if (r102.height() >= r111.height()) goto L9;
        r103.set(r111);
        goto L22
    L25:
        RectF r107 = new RectF(r110);
        RectF r108 = new RectF();
        if (r107.width() < r111.width()) goto L44;
        if (r107.height() < r111.height()) goto L44;
        r108.set(r110);
        float r117 = r108.top;
        float r109 = r111.top;
        if (r117 <= r109) goto L33;
        r108.offset(0.0f, r109 - r117);
        r100 = true;
    L33:
        float r118 = r108.left;
        float r119 = r111.left;
        if (r118 <= r119) goto L36;
        r108.offset(r119 - r118, 0.0f);
        r100 = true;
    L36:
        float r120 = r108.bottom;
        float r121 = r111.bottom;
        if (r120 >= r121) goto L39;
        r108.offset(0.0f, r121 - r120);
        r100 = true;
    L39:
        float r122 = r108.right;
        float r123 = r111.right;
        if (r122 >= r123) goto L42;
        r108.offset(r123 - r122, 0.0f);
    L48:
        if (r101 == false) goto L50;
        b(r107, r108, 300);
    L50:
        return r101;
    L42:
        r101 = r100;
    L44:
        if ((r110.width() / r110.height()) <= (r111.width() / r111.height())) goto L46;
        float r124 = r111.height();
        float r125 = r124 / r110.height();
        float r126 = r110.width() * r125;
    L47:
        float r127 = r126 / 2.0f;
        float r128 = r124 / 2.0f;
        r108.set(r111.centerX() - r127, r111.centerY() - r128, r111.centerX() + r127, r111.centerY() + r128);
        goto L48
    L46:
        float r129 = r111.width();
        float r130 = r129 / r110.width();
        r124 = r110.height() * r130;
        r126 = r129;
        goto L47
    }

    public final void b(RectF r100, RectF r101, int r102) {
        RectF r103 = new RectF();
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(r102);
        r104.addUpdateListener(new a(this, r103, r101, r100));
        r104.setInterpolator(new DecelerateInterpolator());
        r104.addListener(new C7194b(this));
        r104.start();
    }
}
