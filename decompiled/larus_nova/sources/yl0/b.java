package yl0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import kotlin.Pair;

/* JADX INFO: loaded from: classes46.dex */
public final class b {
    public static Animator a(View r100, long r101, Pair r110, long r111, Pair r112) {
        AnimatorSet r102 = new AnimatorSet();
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100, "ScaleX", new float[]{((Number) r110.getFirst()).floatValue(), ((Number) r110.getSecond()).floatValue()});
        r103.setDuration(r101);
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r100, "ScaleY", new float[]{((Number) r110.getFirst()).floatValue(), ((Number) r110.getSecond()).floatValue()});
        r104.setDuration(r101);
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r100, "ScaleX", new float[]{((Number) r112.getFirst()).floatValue(), ((Number) r112.getSecond()).floatValue()});
        r105.setDuration(r111);
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r100, "ScaleY", new float[]{((Number) r112.getFirst()).floatValue(), ((Number) r112.getSecond()).floatValue()});
        r106.setDuration(r111);
        r102.play(r103).with(r104).before(r105).before(r106);
        return r102;
    }
}
