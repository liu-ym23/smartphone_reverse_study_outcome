package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatorSetCompat {
    public AnimatorSetCompat() {
    }

    public static void playTogether(AnimatorSet r110, List<Animator> r111) {
        int r100 = r111.size();
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        Animator r103 = (Animator) ListProtector.get(r111, r102);
        r101 = Math.max(r101, r103.getStartDelay() + r103.getDuration());
        r102 = r102 + 1;
        goto L3
    L5:
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{0, 0});
        r104.setDuration(r101);
        ListProtector.add(r111, 0, r104);
        r110.playTogether(r111);
    }
}
