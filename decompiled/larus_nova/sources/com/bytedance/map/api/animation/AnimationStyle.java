package com.bytedance.map.api.animation;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes21.dex */
public class AnimationStyle {
    public static final int ANIMATION_ALPHA = 1;
    public static final int ANIMATION_SCALE = 0;
    public static final int FILL_MODE_BACKWARDS = 1;
    public static final int FILL_MODE_FORWARDS = 0;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private long mDuration;
    private int mFillMode;
    private float mFrom;
    private Interpolator mInterpolator;
    private int mRepeatCount;
    private int mRepeatMode;
    private float mTo;
    private int mType;

    public AnimationStyle() {
        this.mType = 0;
        this.mFrom = 1.0f;
        this.mTo = 1.0f;
        this.mDuration = 250;
        this.mInterpolator = new LinearInterpolator();
        this.mFillMode = 0;
        this.mRepeatCount = 0;
        this.mRepeatMode = 1;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public int getFillMode() {
        return this.mFillMode;
    }

    public float getFrom() {
        return this.mFrom;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public float getTo() {
        return this.mTo;
    }

    public int getType() {
        return this.mType;
    }

    public void setDuration(long r100) {
        this.mDuration = r100;
    }

    public void setFillMode(int r100) {
        this.mFillMode = r100;
    }

    public void setFrom(float r100) {
        this.mFrom = r100;
    }

    public void setInterpolator(Interpolator r100) {
        this.mInterpolator = r100;
    }

    public void setRepeatCount(int r100) {
        this.mRepeatCount = r100;
    }

    public void setRepeatMode(int r100) {
        this.mRepeatMode = r100;
    }

    public void setTo(float r100) {
        this.mTo = r100;
    }

    public void setType(int r100) {
        this.mType = r100;
    }
}
