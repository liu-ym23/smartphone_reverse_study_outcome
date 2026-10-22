package com.larus.camera.impl.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class s {
    public static final Rect b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Rect r101 = new Rect();
        int[] r102 = new int[2];
        r100.getLocationInWindow(r102);
        int r103 = r102[0];
        r101.set(r103, r102[1], r100.getWidth() + r103, r102[1] + r100.getHeight());
        return r101;
    }

    public static final void a(View r100, int r110, float r111) {
        Intrinsics.checkNotNullParameter(r100, "view");
        float r112 = r110;
        if (r100.getRotation() >= r112) goto L5;
        float r101 = r100.getRotation() + 360;
    L6:
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r100, View.ROTATION, new float[]{r101, r112});
        r113.setDuration(300);
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r100, View.SCALE_X, new float[]{r100.getScaleX(), r111});
        r102.setDuration(300);
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100, View.SCALE_Y, new float[]{r100.getScaleY(), r111});
        r103.setDuration(300);
        AnimatorSet r114 = new AnimatorSet();
        r114.playTogether(new Animator[]{r113, r102, r103});
        r114.start();
        return;
    L5:
        r101 = r100.getRotation();
        goto L6
    }
}
