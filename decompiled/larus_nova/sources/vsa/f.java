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
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n.b f557126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f557127b;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f557128a;

        public a(f r100) {
            this.f557128a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            n.b r101 = this.f557128a.f557126a;
            if (r101 == null) goto L6;
            ((FaceDetectFullActivity.c.b) r101).a(r100);
            return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r210) {
        n.b r100 = this.f557126a;
        if (r100 != null) goto L5;
    L7:
        View r101 = this.f557127b;
        a r102 = new a(this);
        float r103 = r101.getScaleY();
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r103, r103});
        double r105 = 2000;
        r104.setDuration((long) (0.167d * r105));
        r104.setInterpolator(new q());
        float r110 = 1.05f * r103;
        ObjectAnimator r111 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r103, r110});
        r111.setDuration((long) (0.066d * r105));
        r111.setInterpolator(new vsa.a(0.33f, 0.67f));
        float r112 = 0.5f * r103;
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r110, r112});
        r113.setDuration((long) (r105 * 0.10900000000000001d));
        r113.setInterpolator(new vsa.a(0.33f, 0.67f));
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r112, r110});
        r106.setDuration((long) (r105 * 0.10799999999999998d));
        r106.setInterpolator(new vsa.a(0.33f, 0.67f));
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r110, r112});
        r107.setDuration((long) (r105 * 0.10800000000000004d));
        r107.setInterpolator(new vsa.a(0.33f, 0.67f));
        ObjectAnimator r114 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r112, r103});
        r114.setDuration((long) (r105 * 0.10899999999999999d));
        r114.setInterpolator(new vsa.a(0.33f, 0.67f));
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r103, r103});
        r108.setDuration((long) (r105 * 0.33299999999999996d));
        r108.setInterpolator(new LinearInterpolator());
        AnimatorSet r109 = new AnimatorSet();
        r109.playSequentially(new Animator[]{r104, r111, r113, r106, r107, r114, r108});
        r109.addListener(new p(r102, r101, r103));
        r109.start();
        return;
    L5:
        if (((FaceDetectFullActivity.c.b) r100).b() == false) goto L7;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        n.b r101 = this.f557126a;
        if (r101 == null) goto L6;
        ((FaceDetectFullActivity.c.b) r101).a(r100);
        return;
    }

    public f(FaceDetectFullActivity.c.b r100, AudioProgressTextView r101) {
        this.f557126a = r100;
        this.f557127b = r101;
    }
}
