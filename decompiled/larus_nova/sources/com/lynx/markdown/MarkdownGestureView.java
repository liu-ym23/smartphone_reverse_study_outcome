package com.lynx.markdown;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public class MarkdownGestureView extends com.lynx.markdown.a {
    private static final int PAN_STATE_IDLE = 0;
    private static final int PAN_STATE_PENDING = 1;
    private static final int PAN_STATE_TRACKING = 2;
    private a mCheckForLongPress;
    private float mDownX;
    private float mDownY;
    private boolean mIsValidClick;
    private long mNativeGestureTarget;
    private int mPanState;
    private boolean mParentInterceptDisallowed;
    private final int mTouchSlop;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f381426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f381427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MarkdownGestureView f381428c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f381428c.longPressSuccess(this.f381426a, this.f381427b);     // Catch: Throwable -> L4
            MarkdownGestureView.access$002(this.f381428c, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(MarkdownGestureView r100, float r101, float r102) {
            this.f381428c = r100;
            this.f381426a = r101;
            this.f381427b = r102;
        }
    }

    private static int convertGestureEventType(int r100) {
        if (r100 != 0) goto L6;
        return 1;
    L6:
        if (r100 != 2) goto L9;
        return 2;
    L9:
        if (r100 != 1) goto L11;
        return 3;
    L11:
        if (r100 != 3) goto L14;
        return 4;
    L14:
        return 0;
    }

    private native boolean nativeDispatchLongPress(long r100, float r101, float r102);

    private native boolean nativeDispatchPan(long r100, float r101, float r102, float r103, float r104, int r105);

    private native boolean nativeDispatchTap(long r100, float r101, float r102);

    private native boolean nativeShouldBeginPan(long r100, float r101, float r102, float r103, float r104);

    public void resetState() {
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.mPanState = 1;
        this.mIsValidClick = false;
        removeCheckLongPressCallback();
        releaseIntercept();
    }

    private void releaseIntercept() {
        if (this.mParentInterceptDisallowed == true) goto L5;
        return;
    L5:
        setInterceptAllowed(true);
    }

    private void removeCheckLongPressCallback() {
        a r100 = this.mCheckForLongPress;
        if (r100 != null) goto L5;
        return;
    L5:
        removeCallbacks(r100);
        this.mCheckForLongPress = null;
    }

    private void setInterceptAllowed(boolean r100) {
        requestDisallowInterceptTouchEvent(!r100);
        this.mParentInterceptDisallowed = !r100;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        if (this.mNativeGestureTarget == 0) goto L5;
        int r100 = r110.getActionMasked();
        float r101 = r110.getX();
        float r102 = r110.getY();
        float r111 = this.mDownX;
        float r103 = r101 - r111;
        float r104 = this.mDownY;
        float r105 = r102 - r104;
        if (r100 != 0) goto L9;
        this.mDownX = r101;
        this.mDownY = r102;
        if (checkShouldPan(r101, r102, 0.0f, 0.0f) == true) goto L38;
        this.mIsValidClick = true;
        removeCheckLongPressCallback();
        a r112 = new a(this, r101, r102);
        this.mCheckForLongPress = r112;
        postDelayed(r112, ViewConfiguration.getLongPressTimeout());
    L38:
        return true;
    L9:
        if (r100 == 1) goto L29;
        if (r100 == 2) goto L19;
        if (r100 != 3) goto L38;
        if (this.mPanState != 2) goto L17;
        nativeDispatchPan(this.mNativeGestureTarget, r101, r102, r103, r105, convertGestureEventType(3));
    L17:
        resetState();
        goto L38
    L19:
        if (this.mPanState != 1) goto L26;
        int r106 = this.mTouchSlop;
        if (((r103 * r103) + (r105 * r105)) < (r106 * r106)) goto L26;
        this.mIsValidClick = false;
        if (checkShouldPan(r111, r104, r103, r105) == true) goto L26;
        this.mPanState = 0;
    L26:
        if (this.mPanState != 2) goto L38;
        nativeDispatchPan(this.mNativeGestureTarget, r101, r102, r103, r105, convertGestureEventType(2));
        goto L38
    L29:
        if (this.mIsValidClick == false) goto L32;
        nativeDispatchTap(this.mNativeGestureTarget, r111, r104);
    L32:
        if (this.mPanState != 2) goto L34;
        nativeDispatchPan(this.mNativeGestureTarget, r101, r102, r103, r105, convertGestureEventType(1));
    L34:
        resetState();
        goto L38
    L5:
        return super.onTouchEvent(r110);
    }

    public void setNativeGestureTarget(long r100) {
        this.mNativeGestureTarget = r100;
    }

    public MarkdownGestureView(Context r100, long r101) {
        super(r100);
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.mIsValidClick = false;
        this.mCheckForLongPress = null;
        this.mPanState = 0;
        this.mParentInterceptDisallowed = false;
        this.mNativeGestureTarget = r101;
        this.mTouchSlop = ViewConfiguration.get(r100).getScaledTouchSlop();
        setClickable(true);
        setLongClickable(true);
    }

    public static /* synthetic */ a access$002(MarkdownGestureView r100, a r101) {
        r100.mCheckForLongPress = r101;
        return r101;
    }

    public void longPressSuccess(float r100, float r101) {
        this.mIsValidClick = false;
        if (nativeDispatchLongPress(this.mNativeGestureTarget, r100, r101) == false) goto L6;
        this.mPanState = 1;
        setInterceptAllowed(false);
        return;
    }

    public boolean checkShouldPan(float r110, float r111, float r112, float r113) {
        boolean r100 = nativeShouldBeginPan(this.mNativeGestureTarget, r110, r111, r112, r113);
        if (r100 == false) goto L5;
        this.mPanState = 2;
        nativeDispatchPan(this.mNativeGestureTarget, r110, r111, r112, r113, convertGestureEventType(0));
        setInterceptAllowed(false);
        removeCheckLongPressCallback();
    L5:
        return r100;
    }
}
