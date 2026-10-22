package pfc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f529037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f529038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObjectAnimator f529039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ObjectAnimator f529040d;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f529041a;

        public a(c r100) {
            this.f529041a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f529041a.f529037a.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f529041a.f529037a.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f529041a.f529037a.setVisibility(0);
            this.f529041a.f529038b = true;
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f529042a;

        public b(c r100) {
            this.f529042a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f529042a.f529037a.setAlpha(0.0f);
            this.f529042a.f529037a.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f529042a.f529037a.setAlpha(0.0f);
            this.f529042a.f529037a.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f529042a.f529037a.setVisibility(0);
            this.f529042a.f529038b = false;
        }
    }

    public final void a() {
        if (this.f529038b == true) goto L6;
        return;
    L6:
        if (this.f529039c.isRunning() == false) goto L8;
        this.f529039c.cancel();
    L8:
        this.f529040d.start();
    }

    public final void b() {
        if (this.f529038b == false) goto L6;
        return;
    L6:
        if (this.f529040d.isRunning() == false) goto L8;
        this.f529040d.cancel();
    L8:
        this.f529039c.start();
    }

    public c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f529037a = r100;
        this.f529038b = true;
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.0f, 1.0f}).setDuration(200);
        this.f529039c = r101;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f}).setDuration(200);
        this.f529040d = r102;
        r101.addListener(new a(this));
        r102.addListener(new b(this));
    }
}
