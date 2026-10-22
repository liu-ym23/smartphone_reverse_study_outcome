package vsa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.ss.android.bytedcert.face.ui.FaceDetectFullActivity;
import com.ss.android.bytedcert.view.AudioProgressTextView;

/* JADX INFO: loaded from: classes34.dex */
public final class j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n.b f557138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f557139b;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f557140a;

        public a(j r100) {
            this.f557140a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            n.b r101 = this.f557140a.f557138a;
            if (r101 == null) goto L6;
            ((FaceDetectFullActivity.c.b) r101).a(r100);
            return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r210) {
        n.b r100 = this.f557138a;
        if (r100 != null) goto L5;
    L7:
        View r101 = this.f557139b;
        a r102 = new a(this);
        float r103 = r101.getTranslationX();
        double r104 = 2333;
        long r105 = (long) (0.143d * r104);
        long r110 = (long) (0.257d * r104);
        long r111 = (long) (0.369d * r104);
        long r112 = (long) (0.481d * r104);
        long r106 = (long) (r104 * 0.593d);
        long r107 = (long) (r104 * 0.707d);
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r103, r103});
        r108.setDuration(r105);
        float r113 = r103 - 30.0f;
        ObjectAnimator r109 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r103, r113});
        r109.setDuration(r110 - r105);
        ObjectAnimator r114 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r113, r103});
        r114.setDuration(r111 - r110);
        ObjectAnimator r115 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r103, r103});
        r115.setDuration(r112 - r111);
        float r116 = 30.0f + r103;
        ObjectAnimator r117 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r103, r116});
        r117.setDuration(r106 - r112);
        ObjectAnimator r118 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r116, r103});
        r118.setDuration(r107 - r106);
        ObjectAnimator r119 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r103, r103});
        r119.setDuration(2333 - r107);
        AnimatorSet r120 = new AnimatorSet();
        r120.playSequentially(new Animator[]{r108, r109, r114, r115, r117, r118, r119});
        r120.addListener(new g(r102, r101, r103));
        r120.start();
        return;
    L5:
        if (((FaceDetectFullActivity.c.b) r100).b() == false) goto L7;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        n.b r101 = this.f557138a;
        if (r101 == null) goto L6;
        ((FaceDetectFullActivity.c.b) r101).a(r100);
        return;
    }

    public j(FaceDetectFullActivity.c.b r100, AudioProgressTextView r101) {
        this.f557138a = r100;
        this.f557139b = r101;
    }
}
