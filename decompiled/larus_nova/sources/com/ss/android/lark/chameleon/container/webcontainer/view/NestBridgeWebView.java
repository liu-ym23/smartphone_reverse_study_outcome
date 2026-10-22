package com.ss.android.lark.chameleon.container.webcontainer.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.EdgeEffectCompat;
import com.ss.android.lark.chameleon.basewebview.BridgeWebViewV2;

/* JADX INFO: loaded from: classes35.dex */
public class NestBridgeWebView extends BridgeWebViewV2 implements NestedScrollingChild3 {
    private static final int INVALID_POINTER = -1;
    private static final String TAG = "NestBridgeWebView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowTop;
    private boolean mIsBeingDragged;
    private int mLastMotionY;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll(0);
        EdgeEffect r100 = this.mEdgeGlowTop;
        if (r100 == null) goto L6;
        r100.onRelease();
        this.mEdgeGlowBottom.onRelease();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker r100 = this.mVelocityTracker;
        if (r100 != null) goto L5;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    L5:
        r100.clear();
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration r100 = ViewConfiguration.get(getContext());
        this.mTouchSlop = r100.getScaledTouchSlop();
        this.mMinimumVelocity = r100.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = r100.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker != null) goto L6;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    }

    private void recycleVelocityTracker() {
        VelocityTracker r100 = this.mVelocityTracker;
        if (r100 == null) goto L6;
        r100.recycle();
        this.mVelocityTracker = null;
        return;
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
        if (this.mScroller.isFinished() == false) goto L5;
        return;
    L5:
        this.mScroller.computeScrollOffset();
        int r100 = this.mScroller.getCurrY();
        int r101 = r100 - this.mLastScrollerY;
        this.mLastScrollerY = r100;
        int[] r102 = this.mScrollConsumed;
        boolean r110 = false;
        r102[1] = 0;
        dispatchNestedPreScroll(0, r101, r102, null, 1);
        int r111 = r101 - this.mScrollConsumed[1];
        int r112 = getScrollRange();
        if (r111 == 0) goto L8;
        int r113 = getScrollY();
        overScrollByCompat(0, r111, getScrollX(), r113, 0, r112, 0, 0, false);
        int r103 = getScrollY() - r113;
        int r114 = r111 - r103;
        int[] r104 = this.mScrollConsumed;
        r104[1] = 0;
        dispatchNestedScroll(0, r103, 0, r114, this.mScrollOffset, 1, r104);
        r111 = r114 - this.mScrollConsumed[1];
    L8:
        if (r111 == 0) goto L25;
        int r105 = getOverScrollMode();
        if (r105 == 0) goto L13;
        if (r105 != 1) goto L14;
        if (r112 > 0) goto L13;
    L14:
        if (r110 == false) goto L23;
        ensureGlows();
        if (r111 >= 0) goto L21;
        if (this.mEdgeGlowTop.isFinished() == false) goto L23;
        this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
        goto L23
    L21:
        if (this.mEdgeGlowBottom.isFinished() == false) goto L23;
        this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
    L23:
        abortAnimatedScroll();
    L13:
        r110 = true;
    L25:
        if (this.mScroller.isFinished() == true) goto L27;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L27:
        stopNestedScroll(1);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    private void ensureGlows() {
        if (getOverScrollMode() != 2) goto L5;
        this.mEdgeGlowTop = null;
        this.mEdgeGlowBottom = null;
        return;
    L5:
        if (this.mEdgeGlowTop != null) goto L9;
        Context r100 = getContext();
        this.mEdgeGlowTop = new EdgeEffect(r100);
        this.mEdgeGlowBottom = new EdgeEffect(r100);
        return;
    }

    public int getScrollRange() {
        return computeVerticalScrollRange();
    }

    public NestBridgeWebView(Context r100) {
        super(r100);
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        initScrollView();
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    private void onSecondaryPointerUp(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r100.getPointerId(r101) != this.mActivePointerId) goto L11;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.mLastMotionY = (int) r100.getY(r102);
        this.mActivePointerId = r100.getPointerId(r102);
        VelocityTracker r103 = this.mVelocityTracker;
        if (r103 == null) goto L12;
        r103.clear();
        return;
    L12:
        return;
    L6:
        r102 = 0;
        goto L7
    }

    private void runAnimatedScroll(boolean r100) {
        if (r100 == false) goto L5;
        startNestedScroll(2, 1);
    L6:
        this.mLastScrollerY = getScrollY();
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L5:
        stopNestedScroll(1);
        goto L6
    }

    public void fling(int r110) {
        this.mScroller.fling(getScrollX(), getScrollY(), 0, r110, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        runAnimatedScroll(true);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int r100) {
        return this.mChildHelper.hasNestedScrollingParent(r100);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r110) {
        int r100 = r110.getAction();
        if (r100 == 2) goto L5;
    L7:
        int r101 = r100 & 255;
        if (r101 != 0) goto L10;
        this.mLastMotionY = (int) r110.getY();
        this.mActivePointerId = r110.getPointerId(0);
        initOrResetVelocityTracker();
        this.mVelocityTracker.addMovement(r110);
        this.mScroller.computeScrollOffset();
        this.mIsBeingDragged = !this.mScroller.isFinished();
        startNestedScroll(2, 0);
    L37:
        return this.mIsBeingDragged;
    L10:
        if (r101 == 1) goto L31;
        if (r101 != 2) goto L13;
        int r102 = this.mActivePointerId;
        if (r102 == (-1)) goto L37;
        int r103 = r110.findPointerIndex(r102);
        if (r103 == (-1)) goto L37;
        int r104 = (int) r110.getY(r103);
        if (Math.abs(r104 - this.mLastMotionY) <= this.mTouchSlop) goto L37;
        if ((2 & getNestedScrollAxes()) != 0) goto L37;
        this.mIsBeingDragged = true;
        this.mLastMotionY = r104;
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(r110);
        this.mNestedYOffset = 0;
        ViewParent r111 = getParent();
        if (r111 == null) goto L37;
        r111.requestDisallowInterceptTouchEvent(true);
        goto L37
    L13:
        if (r101 == 3) goto L31;
        if (r101 != 6) goto L37;
        onSecondaryPointerUp(r110);
    L31:
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        recycleVelocityTracker();
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L34;
        ViewCompat.postInvalidateOnAnimation(this);
    L34:
        stopNestedScroll(0);
        goto L37
    L5:
        if (this.mIsBeingDragged == false) goto L7;
        return true;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r210) {
        initVelocityTrackerIfNotExists();
        int r100 = r210.getActionMasked();
        if (r100 != 0) goto L5;
        this.mNestedYOffset = 0;
    L5:
        MotionEvent r110 = MotionEvent.obtain(r210);
        r110.offsetLocation(0.0f, this.mNestedYOffset);
        if (r100 != 0) goto L8;
        boolean r101 = !this.mScroller.isFinished();
        this.mIsBeingDragged = r101;
        if (r101 == false) goto L90;
        ViewParent r102 = getParent();
        if (r102 == null) goto L90;
        r102.requestDisallowInterceptTouchEvent(true);
    L90:
        if (this.mScroller.isFinished() == true) goto L92;
        abortAnimatedScroll();
    L92:
        this.mLastMotionY = (int) r210.getY();
        this.mActivePointerId = r210.getPointerId(0);
        startNestedScroll(2, 0);
    L93:
        VelocityTracker r103 = this.mVelocityTracker;
        if (r103 == null) goto L96;
        r103.addMovement(r110);
    L96:
        r110.recycle();
        return super.onTouchEvent(r210);
    L8:
        if (r100 == 1) goto L75;
        if (r100 != 2) goto L11;
        int r111 = r210.findPointerIndex(this.mActivePointerId);
        if (r111 == (-1)) goto L93;
        int r104 = (int) r210.getY(r111);
        int r105 = this.mLastMotionY - r104;
        if (this.mIsBeingDragged == false) goto L31;
    L39:
        int r106 = r105;
        if (this.mIsBeingDragged == false) goto L93;
        if (dispatchNestedPreScroll(0, r106, this.mScrollConsumed, this.mScrollOffset, 0) == false) goto L44;
        r106 = r106 - this.mScrollConsumed[1];
        this.mNestedYOffset += this.mScrollOffset[1];
    L44:
        int r112 = r106;
        this.mLastMotionY = r104 - this.mScrollOffset[1];
        int r113 = getScrollY();
        int r107 = getScrollRange();
        int r108 = getOverScrollMode();
        if (r108 == 0) goto L50;
        if (r108 != 1) goto L49;
        if (r107 > 0) goto L50;
    L49:
        boolean r114 = false;
    L52:
        if (overScrollByCompat(0, r112, 0, getScrollY(), 0, r107, 0, 0, true) == true) goto L54;
    L56:
        int r109 = getScrollY() - r113;
        int[] r115 = this.mScrollConsumed;
        r115[1] = 0;
        dispatchNestedScroll(0, r109, 0, r112 - r109, this.mScrollOffset, 0, r115);
        int r116 = this.mLastMotionY;
        int r117 = this.mScrollOffset[1];
        this.mLastMotionY = r116 - r117;
        this.mNestedYOffset += r117;
        if (r114 == false) goto L93;
        int r118 = r112 - this.mScrollConsumed[1];
        ensureGlows();
        int r119 = r113 + r118;
        if (r119 >= 0) goto L64;
        EdgeEffectCompat.onPull(this.mEdgeGlowTop, r118 / getHeight(), r210.getX(r111) / getWidth());
        if (this.mEdgeGlowBottom.isFinished() == true) goto L68;
        this.mEdgeGlowBottom.onRelease();
    L68:
        EdgeEffect r120 = this.mEdgeGlowTop;
        if (r120 == null) goto L93;
        if (r120.isFinished() == true) goto L73;
    L74:
        ViewCompat.postInvalidateOnAnimation(this);
        goto L93
    L73:
        if (this.mEdgeGlowBottom.isFinished() == true) goto L93;
    L64:
        if (r119 <= r107) goto L68;
        EdgeEffectCompat.onPull(this.mEdgeGlowBottom, r118 / getHeight(), 1.0f - (r210.getX(r111) / getWidth()));
        if (this.mEdgeGlowTop.isFinished() == true) goto L68;
        this.mEdgeGlowTop.onRelease();
        goto L68
    L54:
        if (hasNestedScrollingParent(0) == true) goto L56;
        this.mVelocityTracker.clear();
    L50:
        r114 = true;
        goto L52
    L31:
        if (Math.abs(r105) <= this.mTouchSlop) goto L39;
        ViewParent r121 = getParent();
        if (r121 == null) goto L35;
        r121.requestDisallowInterceptTouchEvent(true);
    L35:
        this.mIsBeingDragged = true;
        if (r105 <= 0) goto L38;
        r105 = r105 - this.mTouchSlop;
        goto L39
    L38:
        r105 = r105 + this.mTouchSlop;
        goto L39
    L11:
        if (r100 == 3) goto L20;
        if (r100 != 5) goto L15;
        int r122 = r210.getActionIndex();
        this.mLastMotionY = (int) r210.getY(r122);
        this.mActivePointerId = r210.getPointerId(r122);
        goto L93
    L15:
        if (r100 != 6) goto L93;
        onSecondaryPointerUp(r210);
        this.mLastMotionY = (int) r210.getY(r210.findPointerIndex(this.mActivePointerId));
        goto L93
    L20:
        if (this.mIsBeingDragged == true) goto L22;
    L24:
        this.mActivePointerId = -1;
        endDrag();
        goto L93
    L22:
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L24;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L24
    L75:
        VelocityTracker r123 = this.mVelocityTracker;
        r123.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r124 = (int) r123.getYVelocity(this.mActivePointerId);
        if (Math.abs(r124) < this.mMinimumVelocity) goto L81;
        int r125 = -r124;
        float r126 = r125;
        if (dispatchNestedPreFling(0.0f, r126) == true) goto L83;
        dispatchNestedFling(0.0f, r126, true);
        fling(r125);
    L83:
        this.mActivePointerId = -1;
        endDrag();
        goto L93
    L81:
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L83;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L83
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r100) {
        if (r100 == false) goto L4;
        recycleVelocityTracker();
    L4:
        super.requestDisallowInterceptTouchEvent(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.mChildHelper.setNestedScrollingEnabled(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r100) {
        return startNestedScroll(r100, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int r100) {
        this.mChildHelper.stopNestedScroll(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r100, float r101) {
        return this.mChildHelper.dispatchNestedPreFling(r100, r101);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r100, int r101) {
        return this.mChildHelper.startNestedScroll(r100, r101);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.mChildHelper.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110) {
        return dispatchNestedPreScroll(r100, r101, r102, r110, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110, int r111) {
        return this.mChildHelper.dispatchNestedPreScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return this.mChildHelper.dispatchNestedScroll(r100, r101, r102, r110, r111);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112, int r113) {
        return this.mChildHelper.dispatchNestedScroll(r100, r101, r110, r111, r112, r113);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int r100, int r110, int r111, int r112, int[] r113, int r114, int[] r115) {
        this.mChildHelper.dispatchNestedScroll(r100, r110, r111, r112, r113, r114, r115);
    }

    public boolean overScrollByCompat(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r210, boolean r211) {
        int r100 = getOverScrollMode();
        if (computeHorizontalScrollRange() <= computeHorizontalScrollExtent()) goto L5;
        boolean r101 = true;
    L7:
        if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) goto L9;
        boolean r102 = true;
    L10:
        if (r100 == 0) goto L15;
        if (r100 != 1) goto L14;
        if (r101 == true) goto L15;
    L14:
        boolean r103 = false;
    L16:
        if (r100 == 0) goto L21;
        if (r100 != 1) goto L20;
        if (r102 == true) goto L21;
    L20:
        boolean r104 = false;
    L22:
        int r105 = r112 + r110;
        if (r103 == true) goto L25;
        int r106 = 0;
    L26:
        int r107 = r113 + r111;
        if (r104 == true) goto L29;
        int r108 = 0;
    L30:
        int r109 = -r106;
        int r117 = r106 + r114;
        int r118 = -r108;
        int r119 = r108 + r115;
        if (r105 <= r117) goto L34;
        r105 = r117;
    L33:
        boolean r120 = true;
    L37:
        if (r107 <= r119) goto L40;
        r107 = r119;
    L39:
        boolean r121 = true;
    L43:
        if (r121 == true) goto L45;
    L47:
        onOverScrolled(r105, r107, r120, r121);
        if (r120 == true) goto L50;
        if (r121 == true) goto L50;
        return false;
    L50:
        return true;
    L45:
        if (hasNestedScrollingParent(1) == true) goto L47;
        int r122 = r105;
        int r123 = r107;
        this.mScroller.springBack(r122, r123, 0, 0, 0, getScrollRange());
        goto L47
    L40:
        if (r107 >= r118) goto L42;
        r107 = r118;
        goto L39
    L42:
        r121 = false;
        goto L43
    L34:
        if (r105 >= r109) goto L36;
        r105 = r109;
        goto L33
    L36:
        r120 = false;
        goto L37
    L29:
        r108 = r210;
        goto L30
    L25:
        r106 = r116;
    L21:
        r104 = true;
    L15:
        r103 = true;
        goto L16
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L7
    }
}
