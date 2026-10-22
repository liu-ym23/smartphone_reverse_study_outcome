package hf3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: hf3.a$a, reason: collision with other inner class name */
    public static final class C0203a implements ValueAnimator.AnimatorUpdateListener {
        public static final C0203a a = null;

        static {
            a = new C0203a();
        }

        public C0203a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            ((Float) r3).floatValue();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            Function0 r3 = this.a;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke();
            return;
        }
    }

    static {
    }

    public static void a(View r4, float r5, float r6, Function0 r7) {
        r4.setScaleX(r5);
        r4.setScaleY(r5);
        ObjectAnimator r0 = ObjectAnimator.ofFloat(r4, "scaleX", new float[]{r4.getScaleX(), r6});
        r0.addUpdateListener(C0203a.a);
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r4, "scaleY", new float[]{r4.getScaleY(), r6});
        AnimatorSet r9 = new AnimatorSet();
        r9.addListener(new b(r7));
        r9.play(r0).with(r8);
        r9.setDuration(200);
        r9.start();
    }
}
