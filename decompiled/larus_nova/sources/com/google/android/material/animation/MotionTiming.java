package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes23.dex */
public class MotionTiming {
    private long delay;
    private long duration;
    private TimeInterpolator interpolator;
    private int repeatCount;
    private int repeatMode;

    public TimeInterpolator getInterpolator() {
        TimeInterpolator r100 = this.interpolator;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public String toString() {
        return "\n" + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + getDelay() + " duration: " + getDuration() + " interpolator: " + getInterpolator().getClass() + " repeatCount: " + getRepeatCount() + " repeatMode: " + getRepeatMode() + "}\n";
    }

    public int hashCode() {
        return (((((((((int) (getDelay() ^ (getDelay() >>> 32))) * 31) + ((int) (getDuration() ^ (getDuration() >>> 32)))) * 31) + getInterpolator().getClass().hashCode()) * 31) + getRepeatCount()) * 31) + getRepeatMode();
    }

    public long getDelay() {
        return this.delay;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    public int getRepeatMode() {
        return this.repeatMode;
    }

    public static MotionTiming createFromAnimator(ValueAnimator r100) {
        MotionTiming r101 = new MotionTiming(r100.getStartDelay(), r100.getDuration(), getInterpolatorCompat(r100));
        r101.repeatCount = r100.getRepeatCount();
        r101.repeatMode = r100.getRepeatMode();
        return r101;
    }

    private static TimeInterpolator getInterpolatorCompat(ValueAnimator r100) {
        TimeInterpolator r101 = r100.getInterpolator();
        if ((r101 instanceof AccelerateDecelerateInterpolator) == true) goto L15;
        if (r101 == null) goto L15;
        if ((r101 instanceof AccelerateInterpolator) == false) goto L11;
        return AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    L11:
        if ((r101 instanceof DecelerateInterpolator) == true) goto L13;
        return r101;
    L13:
        return AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
    L15:
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public void apply(Animator r100) {
        r100.setStartDelay(getDelay());
        r100.setDuration(getDuration());
        r100.setInterpolator(getInterpolator());
        if ((r100 instanceof ValueAnimator) == false) goto L6;
        ValueAnimator r101 = (ValueAnimator) r100;
        r101.setRepeatCount(getRepeatCount());
        r101.setRepeatMode(getRepeatMode());
        return;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L24:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L24;
        MotionTiming r101 = (MotionTiming) r100;
        if (getDelay() == r101.getDelay()) goto L14;
        return false;
    L14:
        if (getDuration() == r101.getDuration()) goto L17;
        return false;
    L17:
        if (getRepeatCount() == r101.getRepeatCount()) goto L20;
        return false;
    L20:
        if (getRepeatMode() == r101.getRepeatMode()) goto L23;
        return false;
    L23:
        return getInterpolator().getClass().equals(r101.getInterpolator().getClass());
    }

    public MotionTiming(long r100, long r101) {
        this.interpolator = null;
        this.repeatCount = 0;
        this.repeatMode = 1;
        this.delay = r100;
        this.duration = r101;
    }

    public MotionTiming(long r100, long r101, TimeInterpolator r102) {
        this.repeatCount = 0;
        this.repeatMode = 1;
        this.delay = r100;
        this.duration = r101;
        this.interpolator = r102;
    }
}
