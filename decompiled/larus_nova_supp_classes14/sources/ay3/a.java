package ay3;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.awemeopen.apps.framework.base.view.xtoast.XToast;
import com.bytedance.awemeopen.apps.framework.utils.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static AnimatorSet a(XToast r10, int r11) {
        Context r0 = r10.c.getContext();
        if (r11 == 1) goto L13;
        if (r11 != 2) goto L6;
        AnimatorSet r12 = new AnimatorSet();
        r12.setDuration(160);
        r12.playTogether(new Animator[]{ObjectAnimator.ofFloat(r10.c, "scaleX", new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(r10.c, "scaleY", new float[]{1.0f, 0.0f})});
        return r12;
    L6:
        if (r11 == 3) goto L9;
        AnimatorSet r13 = new AnimatorSet();
        r13.setDuration(160);
        r13.play(ObjectAnimator.ofFloat(r10.c, "alpha", new float[]{1.0f, 0.0f}));
        return r13;
    L9:
        AnimatorSet r14 = new AnimatorSet();
        r14.setDuration(160);
        View r4 = r10.c;
        r14.playTogether(new Animator[]{ObjectAnimator.ofFloat(r4, "translationY", new float[]{0.0f, r4.getMeasuredHeight()}), ObjectAnimator.ofFloat(r10.c, "alpha", new float[]{1.0f, 0.0f})});
        return r14;
    L13:
        AnimatorSet r15 = new AnimatorSet();
        r15.setDuration(160);
        r15.setInterpolator(new AccelerateInterpolator());
        r15.playTogether(new Animator[]{ObjectAnimator.ofFloat(r10.c, "translationY", new float[]{0.0f, -n0.a(r0, 16.0f)}), ObjectAnimator.ofFloat(r10.c, "alpha", new float[]{1.0f, 0.0f})});
        return r15;
    }

    public static AnimatorSet b(XToast r13, int r14) {
        Context r0 = r13.c.getContext();
        if (r14 == 1) goto L13;
        if (r14 != 2) goto L6;
        AnimatorSet r15 = new AnimatorSet();
        r15.setDuration(260);
        r15.playTogether(new Animator[]{ObjectAnimator.ofFloat(r13.c, "scaleX", new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(r13.c, "scaleY", new float[]{0.0f, 1.0f})});
        return r15;
    L6:
        if (r14 == 3) goto L9;
        AnimatorSet r16 = new AnimatorSet();
        r16.setDuration(260);
        r16.play(ObjectAnimator.ofFloat(r13.c, "alpha", new float[]{0.0f, 1.0f}));
        return r16;
    L9:
        AnimatorSet r17 = new AnimatorSet();
        r17.setDuration(260);
        View r4 = r13.c;
        r17.playTogether(new Animator[]{ObjectAnimator.ofFloat(r4, "translationY", new float[]{r4.getMeasuredHeight(), 0.0f}), ObjectAnimator.ofFloat(r13.c, "alpha", new float[]{0.0f, 1.0f})});
        return r17;
    L13:
        AnimatorSet r18 = new AnimatorSet();
        r18.playTogether(new Animator[]{ObjectAnimator.ofFloat(r13.c, "translationY", new float[]{-n0.a(r0, 16.0f), 0.0f}), ObjectAnimator.ofFloat(r13.c, "alpha", new float[]{0.0f, 1.0f})});
        r18.setDuration(260);
        r18.setInterpolator(new DecelerateInterpolator());
        return r18;
    }
}
