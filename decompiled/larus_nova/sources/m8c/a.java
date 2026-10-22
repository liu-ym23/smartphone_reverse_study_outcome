package m8c;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static LayoutTransition a(int r210, int r211) {
        LayoutTransition r100 = new LayoutTransition();
        AnimatorSet r101 = new AnimatorSet();
        r101.setInterpolator(new DecelerateInterpolator());
        float r102 = r210;
        float r103 = 0;
        r101.playTogether(new Animator[]{ObjectAnimator.ofFloat(null, "alpha", new float[]{1.0f, 1.0f}), ObjectAnimator.ofFloat(null, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r102, r103})});
        r100.setAnimator(2, r101);
        long r104 = r211;
        r100.setDuration(r104);
        r100.setStartDelay(2, 0);
        AnimatorSet r105 = new AnimatorSet();
        r105.setInterpolator(new DecelerateInterpolator());
        r105.playTogether(new Animator[]{ObjectAnimator.ofFloat(null, "alpha", new float[]{1.0f, 1.0f}), ObjectAnimator.ofFloat(null, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r103, r102})});
        r100.setAnimator(3, r105);
        r100.setDuration(r104);
        r100.setDuration(3, 0);
        r100.setAnimator(0, ObjectAnimator.ofPropertyValuesHolder(null, new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("left", new int[]{0, 0}), PropertyValuesHolder.ofInt("top", new int[]{0, 0}), PropertyValuesHolder.ofInt("right", new int[]{0, 0}), PropertyValuesHolder.ofInt("bottom", new int[]{0, 0}), PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 1.0f}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r102, r103})}));
        r100.setDuration(r104);
        r100.setStartDelay(0, 0);
        r100.setAnimator(1, ObjectAnimator.ofPropertyValuesHolder(null, new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("left", new int[]{0, 0}), PropertyValuesHolder.ofInt("top", new int[]{0, 0}), PropertyValuesHolder.ofInt("right", new int[]{0, 0}), PropertyValuesHolder.ofInt("bottom", new int[]{0, 0}), PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 1.0f}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r103, r102})}));
        r100.setDuration(r104);
        r100.setStartDelay(1, 0);
        return r100;
    }
}
