package com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
final class FakeDrag {
    private int mActualDraggedDistance;
    private long mFakeDragBeginTime;
    private int mMaximumVelocity;
    private final RecyclerView mRecyclerView;
    private float mRequestedDragDistance;
    private final ScrollEventAdapter mScrollEventAdapter;
    private VelocityTracker mVelocityTracker;
    private final ViewPager2 mViewPager;

    private void beginFakeVelocityTracker() {
        VelocityTracker r0 = this.mVelocityTracker;
        if (r0 != null) goto L5;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mMaximumVelocity = ViewConfiguration.get(this.mViewPager.getContext()).getScaledMaximumFlingVelocity();
        return;
    L5:
        r0.clear();
    }

    public boolean beginFakeDrag() {
        if (this.mScrollEventAdapter.isDragging() == false) goto L5;
        return false;
    L5:
        this.mActualDraggedDistance = 0;
        this.mRequestedDragDistance = 0;
        this.mFakeDragBeginTime = SystemClock.uptimeMillis();
        beginFakeVelocityTracker();
        this.mScrollEventAdapter.notifyBeginFakeDrag();
        if (this.mScrollEventAdapter.isIdle() == true) goto L8;
        this.mRecyclerView.stopScroll();
    L8:
        addFakeMotionEvent(this.mFakeDragBeginTime, 0, 0.0f, 0.0f);
        return true;
    }

    public boolean endFakeDrag() {
        if (this.mScrollEventAdapter.isFakeDragging() == true) goto L6;
        return false;
    L6:
        this.mScrollEventAdapter.notifyEndFakeDrag();
        VelocityTracker r0 = this.mVelocityTracker;
        r0.computeCurrentVelocity(CCMLynxCardView.ViewType.BANNER, this.mMaximumVelocity);
        if (this.mRecyclerView.fling((int) r0.getXVelocity(), (int) r0.getYVelocity()) == true) goto L11;
        this.mViewPager.snapToPage();
        return true;
    L11:
        return true;
    }

    public boolean isFakeDragging() {
        return this.mScrollEventAdapter.isFakeDragging();
    }

    public boolean fakeDragBy(float r10) {
        int r1 = 0;
        if (this.mScrollEventAdapter.isFakeDragging() == true) goto L5;
        return false;
    L5:
        float r0 = this.mRequestedDragDistance - r10;
        this.mRequestedDragDistance = r0;
        int r11 = Math.round(r0 - this.mActualDraggedDistance);
        this.mActualDraggedDistance += r11;
        long r3 = SystemClock.uptimeMillis();
        if (this.mViewPager.getOrientation() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        int r4 = r11;
    L12:
        if (r2 == true) goto L16;
        r1 = r11;
    L16:
        if (r2 == false) goto L18;
        float r6 = this.mRequestedDragDistance;
    L19:
        if (r2 == false) goto L21;
        float r7 = 0.0f;
    L22:
        this.mRecyclerView.scrollBy(r4, r1);
        addFakeMotionEvent(r3, 2, r6, r7);
        return true;
    L21:
        r7 = this.mRequestedDragDistance;
        goto L22
    L18:
        r6 = 0.0f;
        goto L19
    L11:
        r4 = 0;
        goto L12
    L8:
        r2 = false;
        goto L9
    }

    public FakeDrag(ViewPager2 r1, ScrollEventAdapter r2, RecyclerView r3) {
        this.mViewPager = r1;
        this.mScrollEventAdapter = r2;
        this.mRecyclerView = r3;
    }

    private void addFakeMotionEvent(long r9, int r11, float r12, float r13) {
        MotionEvent r10 = MotionEvent.obtain(this.mFakeDragBeginTime, r9, r11, r12, r13, 0);
        this.mVelocityTracker.addMovement(r10);
        r10.recycle();
    }
}
