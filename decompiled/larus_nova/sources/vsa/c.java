package vsa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.ss.android.bytedcert.face.ui.FaceDetectDialogActivity;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    public static class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f557116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f557117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f557118c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f557119d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f557120e;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f557117b.setScaleX(this.f557118c);
            this.f557117b.setScaleY(this.f557119d);
            this.f557117b.setAlpha(this.f557120e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f557117b.setScaleX(this.f557118c);
            this.f557117b.setScaleY(this.f557119d);
            this.f557117b.setAlpha(this.f557120e);
            Animator.AnimatorListener r101 = this.f557116a;
            if (r101 == null) goto L6;
            r101.onAnimationEnd(r100);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Animator.AnimatorListener r101 = this.f557116a;
            if (r101 == null) goto L6;
            r101.onAnimationStart(r100);
            return;
        }

        public a(Animator.AnimatorListener r100, View r101, float r102, float r103, float r104) {
            this.f557116a = r100;
            this.f557117b = r101;
            this.f557118c = r102;
            this.f557119d = r103;
            this.f557120e = r104;
        }
    }

    public interface b {
    }

    public static void a(View r110, FaceDetectDialogActivity.a r111) {
        float r100 = r110.getAlpha();
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r110, "alpha", new float[]{r100, 0.3f});
        r101.setDuration(500);
        r101.setInterpolator(new vsa.a(0.42f, 0.58f));
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r110, "alpha", new float[]{0.3f, r100});
        r102.setDuration(500);
        r102.setInterpolator(new vsa.a(0.42f, 0.58f));
        AnimatorSet r103 = new AnimatorSet();
        r103.playSequentially(new Animator[]{r101, r102});
        r103.addListener(new e(r111, r110, r100, r103));
        r103.start();
    }

    public static void b(View r110, Animator.AnimatorListener r210) {
        float r100 = r110.getScaleX();
        float r101 = r110.getScaleY();
        float r102 = r110.getAlpha();
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.SCALE_X, new float[]{r100 * 0.4f, r100});
        double r111 = 700;
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

    public static void c(View r110, Point r111, jsa.d r112) {
        long r100 = (long) (700 * 0.976d);
        long r101 = 700 - r100;
        float r102 = r110.getTranslationX();
        float r103 = r110.getTranslationY();
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r102, r111.x + r102}).setDuration(r100);
        r104.setInterpolator(new vsa.a(0.61f, 0.58f));
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r103, r111.y + r103}).setDuration(r100);
        r105.setInterpolator(new vsa.a(0.61f, 0.58f));
        float r113 = r111.x + r102;
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r113, r113}).setDuration(r101);
        r106.setInterpolator(new LinearInterpolator());
        float r107 = r111.y + r103;
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r107, r107}).setDuration(r101);
        r108.setInterpolator(new LinearInterpolator());
        AnimatorSet r109 = new AnimatorSet();
        r109.playTogether(new Animator[]{r104, r105});
        r109.play(r106).after(r104);
        r109.play(r108).after(r105);
        r109.addListener(r112);
        r109.start();
    }
}
