package com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        int r0 = this.mAdapterState;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 == 4) goto L10;
        return false;
    L10:
        return true;
    }

    private void updateScrollEventValues() {
        ScrollEventValues r0 = this.mScrollValues;
        int r1 = this.mLayoutManager.findFirstVisibleItemPosition();
        r0.mPosition = r1;
        if (r1 != (-1)) goto L6;
        r0.reset();
        return;
    L6:
        View r2 = this.mLayoutManager.findViewByPosition(r1);
        if (r2 != null) goto L10;
        r0.reset();
        return;
    L10:
        int r3 = this.mLayoutManager.getLeftDecorationWidth(r2);
        int r4 = this.mLayoutManager.getRightDecorationWidth(r2);
        int r5 = this.mLayoutManager.getTopDecorationHeight(r2);
        int r6 = this.mLayoutManager.getBottomDecorationHeight(r2);
        ViewGroup.LayoutParams r7 = r2.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        r3 = r3 + r8.leftMargin;
        r4 = r4 + r8.rightMargin;
        r5 = r5 + r8.topMargin;
        r6 = r6 + r8.bottomMargin;
    L13:
        int r9 = (r2.getHeight() + r5) + r6;
        int r10 = (r2.getWidth() + r3) + r4;
        if (this.mLayoutManager.getOrientation() != 0) goto L16;
        boolean r11 = true;
    L17:
        if (r11 == false) goto L22;
        int r12 = (r2.getLeft() - r3) - this.mRecyclerView.getPaddingLeft();
        if (this.mViewPager.isRtl() == false) goto L21;
        r12 = -r12;
    L21:
        r9 = r10;
    L23:
        int r13 = -r12;
        r0.mOffsetPx = r13;
        if (r13 < 0) goto L26;
        if (r9 != 0) goto L33;
        float r14 = 0.0f;
    L34:
        r0.mOffset = r14;
        return;
    L33:
        r14 = r13 / r9;
        goto L34
    L26:
        if (new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations() == false) goto L30;
        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
    L30:
        throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(r0.mOffsetPx)}));
    L22:
        r12 = (r2.getTop() - r5) - this.mRecyclerView.getPaddingTop();
        goto L23
    L16:
        r11 = false;
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
        ScrollEventValues r0 = this.mScrollValues;
        return ((double) r0.mPosition) + ((double) r0.mOffset);
    }

    public void notifyEndFakeDrag() {
        if (isDragging() == true) goto L5;
    L7:
        this.mFakeDragging = false;
        updateScrollEventValues();
        ScrollEventValues r1 = this.mScrollValues;
        if (r1.mOffsetPx != 0) goto L13;
        int r2 = r1.mPosition;
        if (r2 == this.mDragStartPosition) goto L12;
        dispatchSelected(r2);
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

    public ScrollEventAdapter(ViewPager2 r1) {
        this.mViewPager = r1;
        RecyclerView r2 = r1.mRecyclerView;
        this.mRecyclerView = r2;
        this.mLayoutManager = r2.getLayoutManager();
        this.mScrollValues = new ScrollEventValues();
        resetState();
    }

    private void dispatchSelected(int r2) {
        ViewPager2.OnPageChangeCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onPageSelected(r2);
        return;
    }

    private void dispatchStateChanged(int r3) {
        if (this.mAdapterState != 3) goto L8;
        if (this.mScrollState != 0) goto L8;
        return;
    L8:
        if (this.mScrollState != r3) goto L10;
        return;
    L10:
        this.mScrollState = r3;
        ViewPager2.OnPageChangeCallback r0 = this.mCallback;
        if (r0 == null) goto L14;
        r0.onPageScrollStateChanged(r3);
        return;
    }

    private void startDrag(boolean r3) {
        this.mFakeDragging = r3;
        if (r3 == false) goto L5;
        int r4 = 4;
    L6:
        this.mAdapterState = r4;
        int r5 = this.mTarget;
        if (r5 == (-1)) goto L10;
        this.mDragStartPosition = r5;
        this.mTarget = -1;
    L12:
        dispatchStateChanged(1);
        return;
    L10:
        if (this.mDragStartPosition != (-1)) goto L12;
        this.mDragStartPosition = getPosition();
        goto L12
    L5:
        r4 = 1;
        goto L6
    }

    public void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback r1) {
        this.mCallback = r1;
    }

    public void notifyProgrammaticScroll(int r3, boolean r4) {
        if (r4 == false) goto L5;
        int r5 = 2;
    L6:
        this.mAdapterState = r5;
        boolean r6 = false;
        this.mFakeDragging = false;
        if (this.mTarget == r3) goto L9;
        r6 = true;
    L9:
        this.mTarget = r3;
        dispatchStateChanged(2);
        if (r6 == false) goto L13;
        dispatchSelected(r3);
        return;
    L13:
        return;
    L5:
        r5 = 3;
        goto L6
    }

    public void onScrollStateChanged(RecyclerView r6, int r7) {
        boolean r1 = true;
        if (this.mAdapterState == 1) goto L5;
    L6:
        if (r7 != 1) goto L10;
        startDrag(false);
        return;
    L10:
        if (isInAnyDraggingState() == false) goto L17;
        if (r7 != 2) goto L17;
        if (this.mScrollHappened == false) goto L46;
        dispatchStateChanged(2);
        this.mDispatchSelected = true;
        return;
    L46:
        return;
    L17:
        if (isInAnyDraggingState() == false) goto L33;
        if (r7 != 0) goto L33;
        updateScrollEventValues();
        if (this.mScrollHappened == true) goto L24;
        int r8 = this.mScrollValues.mPosition;
        if (r8 == (-1)) goto L30;
        dispatchScrolled(r8, 0.0f, 0);
    L30:
        if (r1 == false) goto L33;
        dispatchStateChanged(0);
        resetState();
        goto L33
    L24:
        ScrollEventValues r9 = this.mScrollValues;
        if (r9.mOffsetPx != 0) goto L29;
        int r4 = this.mDragStartPosition;
        int r10 = r9.mPosition;
        if (r4 == r10) goto L30;
        dispatchSelected(r10);
        goto L30
    L29:
        r1 = false;
    L33:
        if (this.mAdapterState != 2) goto L47;
        if (r7 == 0) goto L36;
        return;
    L36:
        if (this.mDataSetChangeHappened == false) goto L49;
        updateScrollEventValues();
        ScrollEventValues r11 = this.mScrollValues;
        if (r11.mOffsetPx != 0) goto L50;
        int r12 = this.mTarget;
        int r13 = r11.mPosition;
        if (r12 == r13) goto L44;
        if (r13 != (-1)) goto L43;
        r13 = 0;
    L43:
        dispatchSelected(r13);
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

    private void dispatchScrolled(int r2, float r3, int r4) {
        ViewPager2.OnPageChangeCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onPageScrolled(r2, r3, r4);
        return;
    }

    public void onScrolled(RecyclerView r4, int r5, int r6) {
        this.mScrollHappened = true;
        updateScrollEventValues();
        if (this.mDispatchSelected == false) goto L24;
        this.mDispatchSelected = false;
        if (r6 > 0) goto L14;
        if (r6 != 0) goto L13;
        if (r5 >= 0) goto L9;
        boolean r7 = true;
    L11:
        if (r7 != this.mViewPager.isRtl()) goto L13;
    L9:
        r7 = false;
    L13:
        boolean r8 = false;
    L15:
        if (r8 == false) goto L19;
        ScrollEventValues r9 = this.mScrollValues;
        if (r9.mOffsetPx == 0) goto L19;
        int r10 = r9.mPosition + 1;
    L20:
        this.mTarget = r10;
        if (this.mDragStartPosition == r10) goto L29;
        dispatchSelected(r10);
    L29:
        ScrollEventValues r11 = this.mScrollValues;
        int r12 = r11.mPosition;
        if (r12 != (-1)) goto L32;
        r12 = 0;
    L32:
        dispatchScrolled(r12, r11.mOffset, r11.mOffsetPx);
        ScrollEventValues r13 = this.mScrollValues;
        int r14 = r13.mPosition;
        int r0 = this.mTarget;
        if (r14 == r0) goto L36;
        if (r0 == (-1)) goto L36;
        return;
    L36:
        if (r13.mOffsetPx == 0) goto L38;
        return;
    L38:
        if (this.mScrollState == 1) goto L43;
        dispatchStateChanged(0);
        resetState();
        return;
    L43:
        return;
    L19:
        r10 = this.mScrollValues.mPosition;
    L14:
        r8 = true;
        goto L15
    L24:
        if (this.mAdapterState != 0) goto L29;
        int r15 = this.mScrollValues.mPosition;
        if (r15 != (-1)) goto L28;
        r15 = 0;
    L28:
        dispatchSelected(r15);
        goto L29
    }
}
