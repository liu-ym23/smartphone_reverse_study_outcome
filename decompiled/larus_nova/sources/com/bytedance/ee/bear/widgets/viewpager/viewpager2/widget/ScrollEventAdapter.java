package com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

/* JADX INFO: loaded from: classes18.dex */
final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    private static final int NO_POSITION = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_PROGRESS_FAKE_DRAG = 4;
    private static final int STATE_IN_PROGRESS_IMMEDIATE_SCROLL = 3;
    private static final int STATE_IN_PROGRESS_MANUAL_DRAG = 1;
    private static final int STATE_IN_PROGRESS_SMOOTH_SCROLL = 2;
    private int mAdapterState;
    private ViewPager2.OnPageChangeCallback mCallback;
    private boolean mDataSetChangeHappened;
    private boolean mDispatchSelected;
    private int mDragStartPosition;
    private boolean mFakeDragging;
    private final LinearLayoutManager mLayoutManager;
    private final RecyclerView mRecyclerView;
    private boolean mScrollHappened;
    private int mScrollState;
    private ScrollEventValues mScrollValues;
    private int mTarget;
    private final ViewPager2 mViewPager;

    public static final class ScrollEventValues {
        float mOffset;
        int mOffsetPx;
        int mPosition;

        public void reset() {
            this.mPosition = -1;
            this.mOffset = 0.0f;
            this.mOffsetPx = 0;
        }

        public ScrollEventValues() {
        }
    }

    private void resetState() {
        this.mAdapterState = 0;
        this.mScrollState = 0;
        this.mScrollValues.reset();
        this.mDragStartPosition = -1;
        this.mTarget = -1;
        this.mDispatchSelected = false;
        this.mScrollHappened = false;
        this.mFakeDragging = false;
        this.mDataSetChangeHappened = false;
    }

    public void notifyBeginFakeDrag() {
        this.mAdapterState = 4;
        startDrag(true);
    }

    public void notifyDataSetChangeHappened() {
        this.mDataSetChangeHappened = true;
    }

    private int getPosition() {
        return this.mLayoutManager.findFirstVisibleItemPosition();
    }

    private boolean isInAnyDraggingState() {
        int r100 = this.mAdapterState;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 4) goto L10;
        return false;
    L10:
        return true;
    }

    private void updateScrollEventValues() {
        ScrollEventValues r100 = this.mScrollValues;
        int r101 = this.mLayoutManager.findFirstVisibleItemPosition();
        r100.mPosition = r101;
        if (r101 != (-1)) goto L6;
        r100.reset();
        return;
    L6:
        View r102 = this.mLayoutManager.findViewByPosition(r101);
        if (r102 != null) goto L10;
        r100.reset();
        return;
    L10:
        int r103 = this.mLayoutManager.getLeftDecorationWidth(r102);
        int r104 = this.mLayoutManager.getRightDecorationWidth(r102);
        int r105 = this.mLayoutManager.getTopDecorationHeight(r102);
        int r106 = this.mLayoutManager.getBottomDecorationHeight(r102);
        ViewGroup.LayoutParams r107 = r102.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        r103 = r103 + r108.leftMargin;
        r104 = r104 + r108.rightMargin;
        r105 = r105 + r108.topMargin;
        r106 = r106 + r108.bottomMargin;
    L13:
        int r109 = (r102.getHeight() + r105) + r106;
        int r110 = (r102.getWidth() + r103) + r104;
        if (this.mLayoutManager.getOrientation() != 0) goto L16;
        boolean r111 = true;
    L17:
        if (r111 == false) goto L22;
        int r112 = (r102.getLeft() - r103) - this.mRecyclerView.getPaddingLeft();
        if (this.mViewPager.isRtl() == false) goto L21;
        r112 = -r112;
    L21:
        r109 = r110;
    L23:
        int r113 = -r112;
        r100.mOffsetPx = r113;
        if (r113 < 0) goto L26;
        if (r109 != 0) goto L33;
        float r114 = 0.0f;
    L34:
        r100.mOffset = r114;
        return;
    L33:
        r114 = r113 / r109;
        goto L34
    L26:
        if (new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations() == false) goto L30;
        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
    L30:
        throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(r100.mOffsetPx)}));
    L22:
        r112 = (r102.getTop() - r105) - this.mRecyclerView.getPaddingTop();
        goto L23
    L16:
        r111 = false;
        goto L17
    }

    public boolean isDragging() {
        if (this.mScrollState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isIdle() {
        if (this.mScrollState != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public double getRelativeScrollPosition() {
        updateScrollEventValues();
        ScrollEventValues r100 = this.mScrollValues;
        return ((double) r100.mPosition) + ((double) r100.mOffset);
    }

    public void notifyEndFakeDrag() {
        if (isDragging() == true) goto L5;
    L7:
        this.mFakeDragging = false;
        updateScrollEventValues();
        ScrollEventValues r100 = this.mScrollValues;
        if (r100.mOffsetPx != 0) goto L13;
        int r101 = r100.mPosition;
        if (r101 == this.mDragStartPosition) goto L12;
        dispatchSelected(r101);
    L12:
        dispatchStateChanged(0);
        resetState();
        return;
    L13:
        dispatchStateChanged(2);
        return;
    L5:
        if (this.mFakeDragging == true) goto L7;
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    public ScrollEventAdapter(ViewPager2 r100) {
        this.mViewPager = r100;
        RecyclerView r101 = r100.mRecyclerView;
        this.mRecyclerView = r101;
        this.mLayoutManager = (LinearLayoutManager) r101.getLayoutManager();
        this.mScrollValues = new ScrollEventValues();
        resetState();
    }

    private void dispatchSelected(int r100) {
        ViewPager2.OnPageChangeCallback r101 = this.mCallback;
        if (r101 == null) goto L6;
        r101.onPageSelected(r100);
        return;
    }

    private void dispatchStateChanged(int r100) {
        if (this.mAdapterState != 3) goto L8;
        if (this.mScrollState != 0) goto L8;
        return;
    L8:
        if (this.mScrollState != r100) goto L10;
        return;
    L10:
        this.mScrollState = r100;
        ViewPager2.OnPageChangeCallback r101 = this.mCallback;
        if (r101 == null) goto L14;
        r101.onPageScrollStateChanged(r100);
        return;
    }

    private void startDrag(boolean r100) {
        this.mFakeDragging = r100;
        if (r100 == false) goto L5;
        int r101 = 4;
    L6:
        this.mAdapterState = r101;
        int r102 = this.mTarget;
        if (r102 == (-1)) goto L10;
        this.mDragStartPosition = r102;
        this.mTarget = -1;
    L12:
        dispatchStateChanged(1);
        return;
    L10:
        if (this.mDragStartPosition != (-1)) goto L12;
        this.mDragStartPosition = getPosition();
        goto L12
    L5:
        r101 = 1;
        goto L6
    }

    public void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback r100) {
        this.mCallback = r100;
    }

    public void notifyProgrammaticScroll(int r100, boolean r101) {
        if (r101 == false) goto L5;
        int r102 = 2;
    L6:
        this.mAdapterState = r102;
        boolean r103 = false;
        this.mFakeDragging = false;
        if (this.mTarget == r100) goto L9;
        r103 = true;
    L9:
        this.mTarget = r100;
        dispatchStateChanged(2);
        if (r103 == false) goto L13;
        dispatchSelected(r100);
        return;
    L13:
        return;
    L5:
        r102 = 3;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView r100, int r101) {
        boolean r102 = true;
        if (this.mAdapterState == 1) goto L5;
    L6:
        if (r101 != 1) goto L10;
        startDrag(false);
        return;
    L10:
        if (isInAnyDraggingState() == false) goto L17;
        if (r101 != 2) goto L17;
        if (this.mScrollHappened == false) goto L46;
        dispatchStateChanged(2);
        this.mDispatchSelected = true;
        return;
    L46:
        return;
    L17:
        if (isInAnyDraggingState() == false) goto L33;
        if (r101 != 0) goto L33;
        updateScrollEventValues();
        if (this.mScrollHappened == true) goto L24;
        int r103 = this.mScrollValues.mPosition;
        if (r103 == (-1)) goto L30;
        dispatchScrolled(r103, 0.0f, 0);
    L30:
        if (r102 == false) goto L33;
        dispatchStateChanged(0);
        resetState();
        goto L33
    L24:
        ScrollEventValues r104 = this.mScrollValues;
        if (r104.mOffsetPx != 0) goto L29;
        int r105 = this.mDragStartPosition;
        int r106 = r104.mPosition;
        if (r105 == r106) goto L30;
        dispatchSelected(r106);
        goto L30
    L29:
        r102 = false;
    L33:
        if (this.mAdapterState != 2) goto L47;
        if (r101 == 0) goto L36;
        return;
    L36:
        if (this.mDataSetChangeHappened == false) goto L49;
        updateScrollEventValues();
        ScrollEventValues r107 = this.mScrollValues;
        if (r107.mOffsetPx != 0) goto L50;
        int r108 = this.mTarget;
        int r109 = r107.mPosition;
        if (r108 == r109) goto L44;
        if (r109 != (-1)) goto L43;
        r109 = 0;
    L43:
        dispatchSelected(r109);
    L44:
        dispatchStateChanged(0);
        resetState();
        return;
    L50:
        return;
    L49:
        return;
    L47:
        return;
    L5:
        if (this.mScrollState == 1) goto L10;
        goto L6
    }

    private void dispatchScrolled(int r100, float r101, int r102) {
        ViewPager2.OnPageChangeCallback r103 = this.mCallback;
        if (r103 == null) goto L6;
        r103.onPageScrolled(r100, r101, r102);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView r100, int r101, int r102) {
        this.mScrollHappened = true;
        updateScrollEventValues();
        if (this.mDispatchSelected == false) goto L24;
        this.mDispatchSelected = false;
        if (r102 > 0) goto L14;
        if (r102 != 0) goto L13;
        if (r101 >= 0) goto L9;
        boolean r103 = true;
    L11:
        if (r103 != this.mViewPager.isRtl()) goto L13;
    L9:
        r103 = false;
    L13:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L19;
        ScrollEventValues r105 = this.mScrollValues;
        if (r105.mOffsetPx == 0) goto L19;
        int r106 = r105.mPosition + 1;
    L20:
        this.mTarget = r106;
        if (this.mDragStartPosition == r106) goto L29;
        dispatchSelected(r106);
    L29:
        ScrollEventValues r107 = this.mScrollValues;
        int r108 = r107.mPosition;
        if (r108 != (-1)) goto L32;
        r108 = 0;
    L32:
        dispatchScrolled(r108, r107.mOffset, r107.mOffsetPx);
        ScrollEventValues r109 = this.mScrollValues;
        int r110 = r109.mPosition;
        int r111 = this.mTarget;
        if (r110 == r111) goto L36;
        if (r111 == (-1)) goto L36;
        return;
    L36:
        if (r109.mOffsetPx == 0) goto L38;
        return;
    L38:
        if (this.mScrollState == 1) goto L43;
        dispatchStateChanged(0);
        resetState();
        return;
    L43:
        return;
    L19:
        r106 = this.mScrollValues.mPosition;
    L14:
        r104 = true;
        goto L15
    L24:
        if (this.mAdapterState != 0) goto L29;
        int r112 = this.mScrollValues.mPosition;
        if (r112 != (-1)) goto L28;
        r112 = 0;
    L28:
        dispatchSelected(r112);
        goto L29
    }
}
