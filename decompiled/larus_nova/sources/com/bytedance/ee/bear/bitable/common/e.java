package com.bytedance.ee.bear.bitable.common;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f209809a = 0;

    static {
    }

    public e() {
    }

    public static final void a(float r100, View r101) {
        if (r101 == null) goto L5;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_X, new float[]{r100});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r100});
        AnimatorSet r104 = new AnimatorSet();
        r104.playTogether(new Animator[]{r102, r103});
        r104.setDuration(150);
        r104.start();
        return;
    }

    public static void b(View r100, float r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = 0.9f;
    L5:
        if (r100 == null) goto L8;
        r100.setOnTouchListener(new d(r101, null));
        return;
    }
}
