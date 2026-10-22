package q02;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements q02.a {

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q02.d f531169a;

        public b(q02.d r100) {
            this.f531169a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            q02.d r101 = this.f531169a;
            if (r101 == null) goto L6;
            r101.c();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            q02.d r101 = this.f531169a;
            if (r101 == null) goto L6;
            r101.e();
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q02.d f531170a;

        public c(q02.d r100) {
            this.f531170a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            q02.d r101 = this.f531170a;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            q02.d r101 = this.f531170a;
            if (r101 == null) goto L6;
            r101.d();
            return;
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q02.d f531171a;

        public d(q02.d r100) {
            this.f531171a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            q02.d r101 = this.f531171a;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    static {
    }

    public e() {
    }

    @Override // q02.a
    public final Animator b(View r100, q02.d r101) {
        if (r100 == null) goto L5;
        float r102 = r100.getX();
    L6:
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r102, 0.0f});
        AnimatorSet r104 = new AnimatorSet();
        r104.playTogether(new Animator[]{r103});
        r104.setDuration(250);
        r104.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        r104.addListener(new c(r101));
        return r104;
    L5:
        r102 = 0.0f;
        goto L6
    }

    @Override // q02.a
    public final Animator c(View r100, q02.d r101) {
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r103 = new AnimatorSet();
        r103.playTogether(new Animator[]{r102});
        r103.setDuration(250);
        r103.addListener(new d(r101));
        return r103;
    }

    @Override // q02.a
    public final Animator d(View r100, q02.d r101) {
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.35f, 1.0f});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.35f, 1.0f});
        AnimatorSet r104 = new AnimatorSet();
        r104.playTogether(new Animator[]{r102, r103});
        r104.setDuration(200);
        r104.addListener(new b(r101));
        return r104;
    }

    @Override // q02.a
    public final void a(View r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setX(r101);
        r100.setY(r102);
    }
}
