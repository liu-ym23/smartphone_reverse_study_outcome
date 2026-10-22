package tk9;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f546595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f546596b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Function0<Unit> r101 = this.f546596b;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Function0<Unit> r101 = this.f546595a;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }

        public a(Function0<Unit> r100, Function0<Unit> r101) {
            this.f546595a = r100;
            this.f546596b = r101;
        }
    }

    public static final ValueAnimator a(final float r100, final float r101, long r102, Function0<Unit> r103, final Function1<? super Float, Unit> r104, Function0<Unit> r105) {
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{r100, r101});
        r106.setInterpolator(new LinearInterpolator());
        r106.setDuration(r102);
        r106.addUpdateListener(new tk9.a(r100, r101, r104));
        r106.addListener(new a(r103, r105));
        return r106;
    }

    public static /* synthetic */ ValueAnimator b(float r100, float r101, long r102, Function0 r110, Function1 r111, Function0 r112, int r113) {
        if ((r113 & 4) == 0) goto L5;
        r102 = 1000;
    L5:
        long r103 = r102;
        if ((r113 & 8) == 0) goto L8;
        Function0 r104 = null;
    L10:
        if ((r113 & 16) == 0) goto L12;
        Function1 r105 = null;
    L14:
        if ((r113 & 32) == 0) goto L16;
        Function0 r106 = null;
    L18:
        return a(r100, r101, r103, r104, r105, r106);
    L16:
        r106 = r112;
        goto L18
    L12:
        r105 = r111;
        goto L14
    L8:
        r104 = r110;
        goto L10
    }
}
