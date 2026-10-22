package com.google.android.material.appbar;

import android.R;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.internal.ThemeEnforcement;

/* JADX INFO: loaded from: classes23.dex */
class ViewUtilsLollipop {
    private static final int[] STATE_LIST_ANIM_ATTRS = null;

    static {
        STATE_LIST_ANIM_ATTRS = new int[]{R.attr.stateListAnimator};
    }

    public ViewUtilsLollipop() {
    }

    public static void setBoundsViewOutlineProvider(View r100) {
        r100.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    public static void setDefaultAppBarLayoutStateListAnimator(View r110, float r111) {
        int r100 = r110.getResources().getInteger(com.larus.nova.R.integer.app_bar_elevation_anim_duration);
        StateListAnimator r101 = new StateListAnimator();
        long r102 = r100;
        r101.addState(new int[]{R.attr.enabled, com.larus.nova.R.attr.state_liftable, -2130974262}, ObjectAnimator.ofFloat(r110, "elevation", new float[]{0.0f}).setDuration(r102));
        r101.addState(new int[]{R.attr.enabled}, ObjectAnimator.ofFloat(r110, "elevation", new float[]{r111}).setDuration(r102));
        r101.addState(new int[0], ObjectAnimator.ofFloat(r110, "elevation", new float[]{0.0f}).setDuration(0));
        r110.setStateListAnimator(r101);
    }

    public static void setStateListAnimatorFromAttrs(View r100, AttributeSet r101, int r110, int r111) {
        Context r102 = r100.getContext();
        TypedArray r103 = ThemeEnforcement.obtainStyledAttributes(r102, r101, STATE_LIST_ANIM_ATTRS, r110, r111, new int[0]);
    L8:
        th = move-exception;
        r103.recycle();
        throw th;
    L4:
        if (r103.hasValue(0) == false) goto L6;
        r100.setStateListAnimator(AnimatorInflater.loadStateListAnimator(r102, r103.getResourceId(0, 0)));     // Catch: Throwable -> L8
    L6:
        r103.recycle();
    }
}
