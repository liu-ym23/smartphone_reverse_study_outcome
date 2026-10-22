package ijc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;

/* JADX INFO: loaded from: classes40.dex */
public final class e extends hjc.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ijc.a f490161a;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hjc.f f490162a;

        public a(hjc.f r100) {
            this.f490162a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            this.f490162a.a((((Float) r100.getAnimatedValue()).floatValue() * 1.0f) / ijc.a.b(this.f490162a.f485508a, null), 3);
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hjc.f f490163a;

        public b(hjc.f r100) {
            this.f490163a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            super.onAnimationCancel(r100);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            hjc.f r101 = this.f490163a;
            r101.f485513f = true;
            r101.a(0.0f, 6);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            super.onAnimationStart(r100);
            this.f490163a.f485513f = false;
        }
    }

    public e(ijc.a r100) {
        this.f490161a = r100;
    }

    @Override // hjc.f.b
    public final void a(hjc.f r100, View r101, int r102, int r103) {
        if ((r100.f485508a & 12) == 0) goto L5;
        String r104 = LiveDegradeFpsAnimator.TRANSLATION_Y;
    L6:
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r101, r104, new float[]{ijc.a.a(this.f490161a, r101), 0.0f});
        r105.addUpdateListener(new a(r100));
        r105.addListener(new b(r100));
        r105.setDuration(200);
        r105.start();
        return;
    L5:
        r104 = LiveDegradeFpsAnimator.TRANSLATION_X;
        goto L6
    }
}
