package com.ss.android.lark.base.activity;

import android.app.Activity;
import android.os.Build;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public class ActivityAnimationManager {
    public static final int[] ANIM_FADE_OUT = null;
    public static final int[] ANIM_HOLD = null;
    public static final int[] ANIM_PUSH_LEFT_CREAT = null;
    public static final int[] ANIM_SLIDE_BOTTOM_OUT = null;
    public static final int[] ANIM_SLIDE_LEFT_OUT = null;
    public static final int[] ANIM_SLIDE_RIGHT_IN = null;
    public static final int[] ANIM_SLIDE_RIGHT_OUT = null;
    public static final int[] ANIM_SLIDE_UP_IN = null;

    public static class AnimationConfig {
        private int mEnterAnimation;
        private int mExitAnimation;

        public AnimationConfig() {
            this.mEnterAnimation = Integer.MIN_VALUE;
            this.mExitAnimation = Integer.MIN_VALUE;
        }

        public int getEnterAnimation() {
            return this.mEnterAnimation;
        }

        public int getExitAnimation() {
            return this.mExitAnimation;
        }

        public AnimationConfig(int[] r100) {
            this.mEnterAnimation = Integer.MIN_VALUE;
            this.mExitAnimation = Integer.MIN_VALUE;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.length <= 0) goto L8;
            this.mEnterAnimation = r100[0];
        L8:
            if (r100.length <= 1) goto L12;
            this.mExitAnimation = r100[1];
            return;
        }

        public AnimationConfig setEnterAnimation(int r100) {
            this.mEnterAnimation = r100;
            return this;
        }

        public AnimationConfig setExitAnimation(int r100) {
            this.mExitAnimation = r100;
            return this;
        }

        public AnimationConfig(int r100, int r101) {
            this.mEnterAnimation = r100;
            this.mExitAnimation = r101;
        }
    }

    static {
        ANIM_PUSH_LEFT_CREAT = new int[]{R.anim.push_left_in, R.anim.push_left_out};
        ANIM_SLIDE_RIGHT_IN = new int[]{R.anim.slide_right_in, R.anim.lark_base_hold};
        ANIM_SLIDE_LEFT_OUT = new int[]{R.anim.lark_base_hold, R.anim.slide_left_out};
        ANIM_SLIDE_RIGHT_OUT = new int[]{R.anim.lark_base_hold, R.anim.slide_right_out};
        ANIM_FADE_OUT = new int[]{R.anim.lark_base_hold, R.anim.fade_out};
        ANIM_SLIDE_UP_IN = new int[]{R.anim.activity_enter_from_bottom, R.anim.activity_nothing};
        ANIM_SLIDE_BOTTOM_OUT = new int[]{R.anim.activity_nothing, R.anim.activity_close_to_bottom};
        ANIM_HOLD = new int[]{0, 0};
    }

    public ActivityAnimationManager() {
    }

    public static void doAnimation(Activity r100, AnimationConfig r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L13;
        int r102 = r101.getEnterAnimation();
        int r103 = r101.getExitAnimation();
        if (Build.VERSION.SDK_INT >= 24) goto L8;
    L10:
        r100.overridePendingTransition(r102, r103);
        return;
    L8:
        if (r100.isInMultiWindowMode() == false) goto L10;
        return;
    L13:
        return;
    }

    public static void doAnimationWithDefault(Activity r100, AnimationConfig r101, AnimationConfig r102) {
        if (r101 != null) goto L5;
        r101 = r102;
    L5:
        doAnimation(r100, r101);
    }
}
