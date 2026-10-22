package vsa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.ss.android.bytedcert.view.AudioProgressTextView;

/* JADX INFO: loaded from: classes34.dex */
public final class n {

    public static class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f557150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f557151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f557152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f557153d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f557154e;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f557151b.setScaleX(this.f557152c);
            this.f557151b.setScaleY(this.f557153d);
            this.f557151b.setAlpha(this.f557154e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f557151b.setScaleX(this.f557152c);
            this.f557151b.setScaleY(this.f557153d);
            this.f557151b.setAlpha(this.f557154e);
            Animator.AnimatorListener r101 = this.f557150a;
            if (r101 == null) goto L6;
            r101.onAnimationEnd(r100);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Animator.AnimatorListener r101 = this.f557150a;
            if (r101 == null) goto L6;
            r101.onAnimationStart(r100);
            return;
        }

        public a(Animator.AnimatorListener r100, View r101, float r102, float r103, float r104) {
            this.f557150a = r100;
            this.f557151b = r101;
            this.f557152c = r102;
            this.f557153d = r103;
            this.f557154e = r104;
        }
    }

    public interface b {
    }

    public static void a(View r110, Animator.AnimatorListener r210) {
        float r100 = r110.getScaleX();
        float r101 = r110.getScaleY();
        float r102 = r110.getAlpha();
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.SCALE_X, new float[]{r100 * 0.4f, r100});
        double r111 = 250;
        long r112 = (long) (0.933d * r111);
        r103.setDuration(r112);
        r103.setInterpolator(new vsa.a(0.42f, 0.58f));
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.4f * r101, r101});
        r113.setDuration(r112);
        r113.setInterpolator(new vsa.a(0.42f, 0.58f));
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r110, "alpha", new float[]{0.0f, r102});
        r104.setDuration(r112);
        r104.setInterpolator(new vsa.a(0.42f, 0.58f));
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.SCALE_X, new float[]{r100, r100});
        long r114 = (long) (r111 * 0.06699999999999995d);
        r105.setDuration(r114);
        r105.setInterpolator(new q());
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r101, r101});
        r106.setDuration(r114);
        r106.setInterpolator(new q());
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r110, "alpha", new float[]{r102, r102});
        r107.setDuration(r114);
        r107.setInterpolator(new q());
        AnimatorSet r108 = new AnimatorSet();
        r108.playTogether(new Animator[]{r103, r113, r104});
        r108.play(r105).after(r103);
        r108.play(r106).after(r113);
        r108.play(r107).after(r104);
        r108.addListener(new a(r210, r110, r100, r101, r102));
        r108.start();
    }

    public static void b(AudioProgressTextView r210, Animator.AnimatorListener r211) {
        float r100 = r210.getScaleX();
        float r101 = r210.getScaleY();
        float r102 = r210.getAlpha();
        float r103 = r100 * 0.4f;
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r210, LiveDegradeFpsAnimator.SCALE_X, new float[]{r100, r103});
        double r110 = 250;
        long r111 = (long) (0.933d * r110);
        r104.setDuration(r111);
        r104.setInterpolator(new vsa.a(0.42f, 0.58f));
        float r112 = 0.4f * r101;
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r210, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r101, r112});
        r113.setDuration(r111);
        r113.setInterpolator(new vsa.a(0.42f, 0.58f));
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r210, "alpha", new float[]{r102, 0.0f});
        r105.setDuration(r111);
        r105.setInterpolator(new vsa.a(0.42f, 0.58f));
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r210, LiveDegradeFpsAnimator.SCALE_X, new float[]{r103, r103});
        long r114 = (long) (r110 * 0.06699999999999995d);
        r106.setDuration(r114);
        r106.setInterpolator(new q());
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r210, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r112, r112});
        r107.setDuration(r114);
        r107.setInterpolator(new q());
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r210, "alpha", new float[]{0.0f, 0.0f});
        r108.setDuration(r114);
        r108.setInterpolator(new q());
        AnimatorSet r109 = new AnimatorSet();
        r109.playTogether(new Animator[]{r104, r113, r105});
        r109.play(r106).after(r104);
        r109.play(r107).after(r113);
        r109.play(r108).after(r105);
        r109.addListener(new o(r211, r210, r100, r101, r102));
        r109.start();
    }
}
