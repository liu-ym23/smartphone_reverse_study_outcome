package hf3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f484919a = 0;

    /* JADX INFO: renamed from: hf3.a$a, reason: collision with other inner class name */
    public static final class C6137a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C6137a f484920a = null;

        static {
            f484920a = new C6137a();
        }

        public C6137a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L7;
            ((Float) r101).floatValue();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f484921a;

        public b(Function0 r100) {
            this.f484921a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Function0 r101 = this.f484921a;
            if (r101 == null) goto L6;
            Unit r102 = (Unit) r101.invoke();
            return;
        }
    }

    static {
    }

    public static void a(View r100, float r101, float r102, Function0 r103) {
        r100.setScaleX(r101);
        r100.setScaleY(r101);
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_X, new float[]{r100.getScaleX(), r102});
        r104.addUpdateListener(C6137a.f484920a);
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r100.getScaleY(), r102});
        AnimatorSet r106 = new AnimatorSet();
        r106.addListener(new b(r103));
        r106.play(r104).with(r105);
        r106.setDuration(200);
        r106.start();
    }
}
