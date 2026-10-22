package com.facebook.drawee.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes23.dex */
public class GestureDetector {
    long mActionDownTime;
    float mActionDownX;
    float mActionDownY;
    ClickListener mClickListener;
    boolean mIsCapturingGesture;
    boolean mIsClickCandidate;
    final float mSingleTapSlopPx;

    public interface ClickListener {
        boolean onClick();
    }

    public void init() {
        this.mClickListener = null;
        reset();
    }

    public void reset() {
        this.mIsCapturingGesture = false;
        this.mIsClickCandidate = false;
    }

    public boolean isCapturingGesture() {
        return this.mIsCapturingGesture;
    }

    public GestureDetector(Context r100) {
        this.mSingleTapSlopPx = ViewConfiguration.get(r100).getScaledTouchSlop();
        init();
    }

    public static GestureDetector newInstance(Context r100) {
        return new GestureDetector(r100);
    }

    public boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        this.mIsCapturingGesture = true;
        this.mIsClickCandidate = true;
        this.mActionDownTime = r100.getEventTime();
        this.mActionDownX = r100.getX();
        this.mActionDownY = r100.getY();
    L31:
        return true;
    L5:
        if (r101 != 1) goto L7;
        this.mIsCapturingGesture = false;
        if (Math.abs(r100.getX() - this.mActionDownX) <= this.mSingleTapSlopPx) goto L20;
    L21:
        this.mIsClickCandidate = false;
    L23:
        if (this.mIsClickCandidate == true) goto L25;
    L29:
        this.mIsClickCandidate = false;
        goto L31
    L25:
        if ((r100.getEventTime() - this.mActionDownTime) > ViewConfiguration.getLongPressTimeout()) goto L29;
        ClickListener r102 = this.mClickListener;
        if (r102 == null) goto L29;
        r102.onClick();
        goto L29
    L20:
        if (Math.abs(r100.getY() - this.mActionDownY) <= this.mSingleTapSlopPx) goto L23;
    L7:
        if (r101 == 2) goto L13;
        if (r101 != 3) goto L31;
        this.mIsCapturingGesture = false;
        this.mIsClickCandidate = false;
        goto L31
    L13:
        if (Math.abs(r100.getX() - this.mActionDownX) <= this.mSingleTapSlopPx) goto L15;
    L16:
        this.mIsClickCandidate = false;
        goto L31
    L15:
        if (Math.abs(r100.getY() - this.mActionDownY) <= this.mSingleTapSlopPx) goto L31;
        goto L16
    }

    public void setClickListener(ClickListener r100) {
        this.mClickListener = r100;
    }
}
