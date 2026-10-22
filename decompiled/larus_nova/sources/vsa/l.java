package vsa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.ss.android.bytedcert.face.ui.FaceDetectFullActivity;
import com.ss.android.bytedcert.view.AudioProgressTextView;

/* JADX INFO: loaded from: classes34.dex */
public final class l extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n.b f557144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f557145b;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f557146a;

        public a(l r100) {
            this.f557146a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            n.b r101 = this.f557146a.f557144a;
            if (r101 == null) goto L6;
            ((FaceDetectFullActivity.c.b) r101).a(r100);
            return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r210) {
        n.b r100 = this.f557144a;
        if (r100 != null) goto L5;
    L7:
        View r101 = this.f557145b;
        a r102 = new a(this);
        float r103 = r101.getTranslationY();
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r103, r103});
        double r105 = 2333;
        r104.setDuration((long) (0.143d * r105));
        r104.setStartDelay(0);
        r104.setInterpolator(new q());
        float r110 = r103 - 30.0f;
        ObjectAnimator r111 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r103, r110});
        r111.setDuration((long) (0.11400000000000002d * r105));
        r111.setInterpolator(new vsa.a(0.42f, 0.58f));
        ObjectAnimator r112 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r110, r103});
        long r106 = (long) (r105 * 0.11199999999999999d);
        r112.setDuration(r106);
        r112.setInterpolator(new vsa.a(0.42f, 0.58f));
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r103, r103});
        r113.setDuration(r106);
        r113.setInterpolator(new vsa.a(0.42f, 0.58f));
        float r114 = r103 + 30.0f;
        ObjectAnimator r115 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r103, r114});
        r115.setDuration(r106);
        r115.setInterpolator(new vsa.a(0.42f, 0.58f));
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r114, r103});
        r107.setDuration((long) (r105 * 0.11399999999999999d));
        r107.setInterpolator(new LinearInterpolator());
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r103, r103});
        r108.setDuration((long) (r105 * 0.29300000000000004d));
        r108.setInterpolator(new q());
        AnimatorSet r109 = new AnimatorSet();
        r109.playSequentially(new Animator[]{r104, r111, r112, r113, r115, r107, r108});
        r109.addListener(new h(r102, r101, r103));
        r109.start();
        return;
    L5:
        if (((FaceDetectFullActivity.c.b) r100).b() == false) goto L7;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        n.b r101 = this.f557144a;
        if (r101 == null) goto L6;
        ((FaceDetectFullActivity.c.b) r101).a(r100);
        return;
    }

    public l(FaceDetectFullActivity.c.b r100, AudioProgressTextView r101) {
        this.f557144a = r100;
        this.f557145b = r101;
    }
}
