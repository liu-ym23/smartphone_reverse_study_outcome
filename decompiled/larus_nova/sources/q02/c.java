package q02;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.revenue.common.utils.LiveDegradeFpsAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements q02.a {

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f531166a;

        public a(d r100) {
            this.f531166a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d r101 = this.f531166a;
            if (r101 == null) goto L6;
            r101.c();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d r101 = this.f531166a;
            if (r101 == null) goto L6;
            r101.e();
            return;
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f531167a;

        public b(d r100) {
            this.f531167a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d r101 = this.f531167a;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d r101 = this.f531167a;
            if (r101 == null) goto L6;
            r101.d();
            return;
        }
    }

    /* JADX INFO: renamed from: q02.c$c, reason: collision with other inner class name */
    public static final class C7258c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f531168a;

        public C7258c(d r100) {
            this.f531168a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d r101 = this.f531168a;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    public c() {
    }

    @Override // q02.a
    public final Animator b(View r100, d r101) {
        if (r100 == null) goto L4;
        float r102 = r100.getAlpha();
    L5:
        LiveDegradeFpsAnimator r103 = LiveDegradeFpsAnimator.ofFloat(r100, "alpha", new float[]{r102, 1.0f});
        AnimatorSet r104 = new AnimatorSet();
        r104.playTogether(new Animator[]{r103});
        r104.setDuration(200);
        r104.addListener(new b(r101));
        return r104;
    L4:
        r102 = 0.0f;
        goto L5
    }

    @Override // q02.a
    public final Animator c(View r100, d r101) {
        LiveDegradeFpsAnimator r102 = LiveDegradeFpsAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r103 = new AnimatorSet();
        r103.playTogether(new Animator[]{r102});
        r103.setDuration(200);
        r103.addListener(new C7258c(r101));
        return r103;
    }

    @Override // q02.a
    public final Animator d(View r100, d r101) {
        LiveDegradeFpsAnimator r102 = LiveDegradeFpsAnimator.ofFloat(r100, com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator.SCALE_X, new float[]{1.35f, 1.0f});
        LiveDegradeFpsAnimator r103 = LiveDegradeFpsAnimator.ofFloat(r100, com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.35f, 1.0f});
        AnimatorSet r104 = new AnimatorSet();
        r104.playTogether(new Animator[]{r102, r103});
        r104.setDuration(200);
        r104.setInterpolator(new PathInterpolator(0.29f, 0.22f, 0.21f, 1.5f));
        r104.addListener(new a(r101));
        return r104;
    }

    @Override // q02.a
    public final void a(View r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setX(0.0f);
        r100.setY(r102);
        r100.setAlpha(0.0f);
    }
}
