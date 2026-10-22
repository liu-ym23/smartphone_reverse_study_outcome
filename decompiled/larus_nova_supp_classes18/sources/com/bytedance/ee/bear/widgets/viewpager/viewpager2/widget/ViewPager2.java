package com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.widgets.viewpager.viewpager2.adapter.StatefulAdapter;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ViewPager2 extends ViewGroup {
    public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static boolean sFeatureEnhancedA11yEnabled = true;
    AccessibilityProvider mAccessibilityProvider;
    int mCurrentItem;
    private RecyclerView.AdapterDataObserver mCurrentItemDataSetChangeObserver;
    boolean mCurrentItemDirty;
    private CompositeOnPageChangeCallback mExternalPageChangeCallbacks;
    private FakeDrag mFakeDragger;
    protected LinearLayoutManager mLayoutManager;
    private int mOffscreenPageLimit;
    private CompositeOnPageChangeCallback mPageChangeEventDispatcher;
    private PageTransformerAdapter mPageTransformerAdapter;
    private PagerSnapHelper mPagerSnapHelper;
    private Parcelable mPendingAdapterState;
    private int mPendingCurrentItem;
    public RecyclerView mRecyclerView;
    private RecyclerView.ItemAnimator mSavedItemAnimator;
    private boolean mSavedItemAnimatorPresent;
    ScrollEventAdapter mScrollEventAdapter;
    private final Rect mTmpChildRect;
    private final Rect mTmpContainerRect;
    private boolean mUserInputEnabled;

    public abstract class AccessibilityProvider {
        final /* synthetic */ ViewPager2 this$0;

        public boolean handlesGetAccessibilityClassName() {
            return false;
        }

        public boolean handlesLmPerformAccessibilityAction(int r1) {
            return false;
        }

        public boolean handlesPerformAccessibilityAction(int r1, Bundle r2) {
            return false;
        }

        public boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        public void onAttachAdapter(RecyclerView.Adapter<?> r1) {
        }

        public void onDetachAdapter(RecyclerView.Adapter<?> r1) {
        }

        public void onInitialize(CompositeOnPageChangeCallback r1, RecyclerView r2) {
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        }

        public void onLmInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat r1) {
        }

        public void onRestorePendingState() {
        }

        public void onRvInitializeAccessibilityEvent(AccessibilityEvent r1) {
        }

        public void onSetLayoutDirection() {
        }

        public void onSetNewCurrentItem() {
        }

        public void onSetOrientation() {
        }

        public void onSetUserInputEnabled() {
        }

        public String onGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        public CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        private AccessibilityProvider(ViewPager2 r1) {
            this.this$0 = r1;
        }

        public boolean onLmPerformAccessibilityAction(int r2) {
            throw new IllegalStateException("Not implemented.");
        }

        public /* synthetic */ AccessibilityProvider(ViewPager2 r1, AnonymousClass1 r2) {
            this(r1);
        }

        public boolean onPerformAccessibilityAction(int r1, Bundle r2) {
            throw new IllegalStateException("Not implemented.");
        }
    }

    public class BasicAccessibilityProvider extends AccessibilityProvider {
        final /* synthetic */ ViewPager2 this$0;

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.AccessibilityProvider
        public CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName() == false) goto L7;
            return "androidx.viewpager.widget.ViewPager";
        L7:
            throw new IllegalStateException();
        }

        public BasicAccessibilityProvider(ViewPager2 r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int r2) {
            if (r2 == 8192) goto L7;
            if (r2 == 4096) goto L7;
        L9:
            return false;
        L7:
            if (this.this$0.isUserInputEnabled() == true) goto L9;
            return true;
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat r2) {
            if (this.this$0.isUserInputEnabled() == true) goto L6;
            r2.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            r2.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            r2.setScrollable(false);
            return;
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int r1) {
            if (handlesLmPerformAccessibilityAction(r1) == false) goto L7;
            return false;
        L7:
            throw new IllegalStateException();
        }
    }

    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        public abstract void onChanged();

        private DataSetChangeObserver() {
        }

        public /* synthetic */ DataSetChangeObserver(AnonymousClass1 r1) {
            this();
        }

        public final void onItemRangeChanged(int r1, int r2) {
            onChanged();
        }

        public final void onItemRangeInserted(int r1, int r2) {
            onChanged();
        }

        public final void onItemRangeRemoved(int r1, int r2) {
            onChanged();
        }

        public final void onItemRangeChanged(int r1, int r2, Object r3) {
            onChanged();
        }

        public final void onItemRangeMoved(int r1, int r2, int r3) {
            onChanged();
        }
    }

    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        final /* synthetic */ ViewPager2 this$0;

        public boolean requestChildRectangleOnScreen(RecyclerView r1, View r2, Rect r3, boolean r4, boolean r5) {
            return false;
        }

        public int getExtraLayoutSpace(RecyclerView.State r3) {
            int r0 = this.this$0.getOffscreenPageLimit();
            if (r0 != (-1)) goto L7;
            return super.getExtraLayoutSpace(r3);
        L7:
            return this.this$0.getPageSize() * r0;
        }

        public LinearLayoutManagerImpl(ViewPager2 r1, Context r2) {
            this.this$0 = r1;
            super(r2);
        }

        public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler r1, RecyclerView.State r2, AccessibilityNodeInfoCompat r3) {
            super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onInitializeAccessibilityNodeInfo(r1, r2, r3);
            this.this$0.mAccessibilityProvider.onLmInitializeAccessibilityNodeInfo(r3);
        }

        public boolean performAccessibilityAction(RecyclerView.Recycler r2, RecyclerView.State r3, int r4, Bundle r5) {
            if (this.this$0.mAccessibilityProvider.handlesLmPerformAccessibilityAction(r4) == false) goto L7;
            return this.this$0.mAccessibilityProvider.onLmPerformAccessibilityAction(r4);
        L7:
            return super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.performAccessibilityAction(r2, r3, r4, r5);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OffscreenPageLimit {
    }

    public static abstract class OnPageChangeCallback {
        public OnPageChangeCallback() {
        }

        public void onPageScrollStateChanged(int r1) {
        }

        public void onPageScrolled(int r1, float r2, int r3) {
        }

        public void onPageSelected(int r1) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public interface PageTransformer {
        void transformPage(View r1, float r2);
    }

    public class PagerSnapHelperImpl extends PagerSnapHelper {
        final /* synthetic */ ViewPager2 this$0;

        public PagerSnapHelperImpl(ViewPager2 r1) {
            this.this$0 = r1;
        }

        public View findSnapView(RecyclerView.LayoutManager r2) {
            if (this.this$0.isFakeDragging() == false) goto L6;
            return null;
        L6:
            return super.findSnapView(r2);
        }
    }

    public class RecyclerViewImpl extends RecyclerView {
        final /* synthetic */ ViewPager2 this$0;

        public CharSequence getAccessibilityClassName() {
            if (this.this$0.mAccessibilityProvider.handlesRvGetAccessibilityClassName() == false) goto L7;
            return this.this$0.mAccessibilityProvider.onRvGetAccessibilityClassName();
        L7:
            return super.getAccessibilityClassName();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
            ViewPager2.super.onInitializeAccessibilityEvent(r2);
            r2.setFromIndex(this.this$0.mCurrentItem);
            r2.setToIndex(this.this$0.mCurrentItem);
            this.this$0.mAccessibilityProvider.onRvInitializeAccessibilityEvent(r2);
        }

        public boolean onInterceptTouchEvent(MotionEvent r2) {
            if (this.this$0.isUserInputEnabled() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onInterceptTouchEvent(r2) == false) goto L7;
            return true;
        }

        public boolean onTouchEvent(MotionEvent r2) {
            if (this.this$0.isUserInputEnabled() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onTouchEvent(r2) == false) goto L7;
            return true;
        }

        public RecyclerViewImpl(ViewPager2 r1, Context r2) {
            this.this$0 = r1;
            super(r2);
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mAdapterState;
        int mCurrentItem;
        int mRecyclerViewId;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r2) {
            super(r2);
            readValues(r2, null);
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            readValues(r1, r2);
        }

        private void readValues(Parcel r2, ClassLoader r3) {
            this.mRecyclerViewId = r2.readInt();
            this.mCurrentItem = r2.readInt();
            this.mAdapterState = r2.readParcelable(r3);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeInt(this.mRecyclerViewId);
            r2.writeInt(this.mCurrentItem);
            r2.writeParcelable(this.mAdapterState, r3);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollState {
    }

    public static class SmoothScrollToPosition implements Runnable {
        private final int mPosition;
        private final RecyclerView mRecyclerView;

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_ee_bear_widgets_viewpager_viewpager2_widget_ViewPager2$SmoothScrollToPosition_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bytedance_ee_bear_widgets_viewpager_viewpager2_widget_ViewPager2$SmoothScrollToPosition__run$___twin___() {
            this.mRecyclerView.smoothScrollToPosition(this.mPosition);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_ee_bear_widgets_viewpager_viewpager2_widget_ViewPager2$SmoothScrollToPosition_com_larus_apm_impl_protector_RunnableLancet_run(SmoothScrollToPosition r1) {
            r1.com_bytedance_ee_bear_widgets_viewpager_viewpager2_widget_ViewPager2$SmoothScrollToPosition__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public SmoothScrollToPosition(int r1, RecyclerView r2) {
            this.mPosition = r1;
            this.mRecyclerView = r2;
        }
    }

    private void setOrientation(Context r1, AttributeSet r2) {
    }

    private RecyclerView.OnChildAttachStateChangeListener enforceChildFillListener() {
        return new AnonymousClass4(this);
    }

    private void restorePendingState() {
        if (this.mPendingCurrentItem != (-1)) goto L5;
        return;
    L5:
        StatefulAdapter r0 = getAdapter();
        if (r0 != null) goto L8;
        return;
    L8:
        Parcelable r2 = this.mPendingAdapterState;
        if (r2 != null) goto L11;
    L14:
        int r1 = Math.max(0, Math.min(this.mPendingCurrentItem, r0.getItemCount() - 1));
        this.mCurrentItem = r1;
        this.mPendingCurrentItem = -1;
        this.mRecyclerView.scrollToPosition(r1);
        this.mAccessibilityProvider.onRestorePendingState();
        return;
    L11:
        if ((r0 instanceof StatefulAdapter) == false) goto L13;
        r0.restoreState(r2);
    L13:
        this.mPendingAdapterState = null;
        goto L14
    }

    public boolean beginFakeDrag() {
        return this.mFakeDragger.beginFakeDrag();
    }

    public boolean endFakeDrag() {
        return this.mFakeDragger.endFakeDrag();
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (this.mAccessibilityProvider.handlesGetAccessibilityClassName() == false) goto L7;
        return this.mAccessibilityProvider.onGetAccessibilityClassName();
    L7:
        return super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    public int getItemDecorationCount() {
        return this.mRecyclerView.getItemDecorationCount();
    }

    public int getOrientation() {
        return this.mLayoutManager.getOrientation();
    }

    public int getPageSize() {
        RecyclerView r0 = this.mRecyclerView;
        if (getOrientation() != 0) goto L5;
        int r1 = r0.getWidth() - r0.getPaddingLeft();
        int r2 = r0.getPaddingRight();
    L7:
        return r1 - r2;
    L5:
        r1 = r0.getHeight() - r0.getPaddingTop();
        r2 = r0.getPaddingBottom();
        goto L7
    }

    public int getScrollState() {
        return this.mScrollEventAdapter.getScrollState();
    }

    public void invalidateItemDecorations() {
        this.mRecyclerView.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragger.isFakeDragging();
    }

    public boolean isRtl() {
        if (this.mLayoutManager.getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void requestTransform() {
        if (this.mPageTransformerAdapter.getPageTransformer() != null) goto L5;
        return;
    L5:
        double r0 = this.mScrollEventAdapter.getRelativeScrollPosition();
        int r2 = (int) r0;
        float r1 = (float) (r0 - ((double) r2));
        this.mPageTransformerAdapter.onPageScrolled(r2, r1, Math.round(getPageSize() * r1));
    }

    public void snapToPage() {
        View r0 = this.mPagerSnapHelper.findSnapView(this.mLayoutManager);
        if (r0 != null) goto L5;
        return;
    L5:
        int[] r1 = this.mPagerSnapHelper.calculateDistanceToFinalSnap(this.mLayoutManager, r0);
        int r2 = r1[0];
        if (r2 == 0) goto L8;
    L9:
        this.mRecyclerView.smoothScrollBy(r2, r1[1]);
        return;
    L8:
        if (r1[1] != 0) goto L9;
    }

    public void updateCurrentItem() {
        PagerSnapHelper r0 = this.mPagerSnapHelper;
        if (r0 == null) goto L15;
        View r1 = r0.findSnapView(this.mLayoutManager);
        if (r1 != null) goto L7;
        return;
    L7:
        int r2 = this.mLayoutManager.getPosition(r1);
        if (r2 != this.mCurrentItem) goto L10;
    L12:
        this.mCurrentItemDirty = false;
        return;
    L10:
        if (getScrollState() != 0) goto L12;
        this.mPageChangeEventDispatcher.onPageSelected(r2);
        goto L12
    L15:
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.mRecyclerViewId = this.mRecyclerView.getId();
        int r0 = this.mPendingCurrentItem;
        if (r0 != (-1)) goto L5;
        r0 = this.mCurrentItem;
    L5:
        r1.mCurrentItem = r0;
        Parcelable r2 = this.mPendingAdapterState;
        if (r2 == null) goto L8;
        r1.mAdapterState = r2;
    L11:
        return r1;
    L8:
        StatefulAdapter r3 = this.mRecyclerView.getAdapter();
        if ((r3 instanceof StatefulAdapter) == false) goto L11;
        r1.mAdapterState = r3.saveState();
        goto L11
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public boolean isUserInputEnabled() {
        return this.mUserInputEnabled;
    }

    public ViewPager2(Context r4) {
        super(r4);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r4, null);
    }

    private void registerCurrentItemDataSetTracker(RecyclerView.Adapter<?> r2) {
        if (r2 == null) goto L5;
        r2.registerAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        return;
    }

    private void unregisterCurrentItemDataSetTracker(RecyclerView.Adapter<?> r2) {
        if (r2 == null) goto L5;
        r2.unregisterAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        return;
    }

    public void addItemDecoration(RecyclerView.ItemDecoration r2) {
        this.mRecyclerView.addItemDecoration(r2);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r2) {
        return this.mRecyclerView.canScrollHorizontally(r2);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r2) {
        return this.mRecyclerView.canScrollVertically(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r4) {
        Parcelable r0 = r4.get(getId());
        if ((r0 instanceof SavedState) == false) goto L5;
        int r1 = ((SavedState) r0).mRecyclerViewId;
        r4.put(this.mRecyclerView.getId(), r4.get(r1));
        r4.remove(r1);
    L5:
        super.dispatchRestoreInstanceState(r4);
        restorePendingState();
    }

    public boolean fakeDragBy(float r2) {
        return this.mFakeDragger.fakeDragBy(r2);
    }

    public RecyclerView.ItemDecoration getItemDecorationAt(int r2) {
        return this.mRecyclerView.getItemDecorationAt(r2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r2) {
        super.onInitializeAccessibilityNodeInfo(r2);
        this.mAccessibilityProvider.onInitializeAccessibilityNodeInfo(r2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        this.mPendingCurrentItem = r3.mCurrentItem;
        this.mPendingAdapterState = r3.mAdapterState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r3) {
        throw new IllegalStateException(getClass().getSimpleName().concat(" does not support direct child views"));
    }

    public void registerOnPageChangeCallback(OnPageChangeCallback r2) {
        this.mExternalPageChangeCallbacks.addOnPageChangeCallback(r2);
    }

    public void removeItemDecoration(RecyclerView.ItemDecoration r2) {
        this.mRecyclerView.removeItemDecoration(r2);
    }

    public void removeItemDecorationAt(int r2) {
        this.mRecyclerView.removeItemDecorationAt(r2);
    }

    public void setAdapter(RecyclerView.Adapter r3) {
        RecyclerView.Adapter<?> r0 = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.onDetachAdapter(r0);
        unregisterCurrentItemDataSetTracker(r0);
        this.mRecyclerView.setAdapter(r3);
        this.mCurrentItem = 0;
        restorePendingState();
        this.mAccessibilityProvider.onAttachAdapter(r3);
        registerCurrentItemDataSetTracker(r3);
    }

    public void setCurrentItem(int r2) {
        setCurrentItem(r2, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int r1) {
        super.setLayoutDirection(r1);
        this.mAccessibilityProvider.onSetLayoutDirection();
    }

    public void setOffscreenPageLimit(int r2) {
        if (r2 < 1) goto L5;
    L9:
        this.mOffscreenPageLimit = r2;
        this.mRecyclerView.requestLayout();
        return;
    L5:
        if (r2 == (-1)) goto L9;
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int r2) {
        this.mLayoutManager.setOrientation(r2);
        this.mAccessibilityProvider.onSetOrientation();
    }

    public void setPageTransformer(PageTransformer r4) {
        if (r4 == null) goto L9;
        if (this.mSavedItemAnimatorPresent == true) goto L7;
        this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
        this.mSavedItemAnimatorPresent = true;
    L7:
        this.mRecyclerView.setItemAnimator(null);
    L12:
        if (r4 != this.mPageTransformerAdapter.getPageTransformer()) goto L14;
        return;
    L14:
        this.mPageTransformerAdapter.setPageTransformer(r4);
        requestTransform();
        return;
    L9:
        if (this.mSavedItemAnimatorPresent == false) goto L12;
        this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        goto L12
    }

    public void setUserInputEnabled(boolean r1) {
        this.mUserInputEnabled = r1;
        this.mAccessibilityProvider.onSetUserInputEnabled();
    }

    public void unregisterOnPageChangeCallback(OnPageChangeCallback r2) {
        this.mExternalPageChangeCallbacks.removeOnPageChangeCallback(r2);
    }

    public ViewPager2(Context r4, AttributeSet r5) {
        super(r4, r5);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r4, r5);
    }

    private void initialize(Context r3, AttributeSet r4) {
        if (sFeatureEnhancedA11yEnabled == false) goto L5;
        BasicAccessibilityProvider r0 = new BasicAccessibilityProvider(this);
    L6:
        this.mAccessibilityProvider = r0;
        RecyclerView r1 = new RecyclerViewImpl(this, r3);
        this.mRecyclerView = r1;
        r1.setId(ViewCompat.generateViewId());
        this.mRecyclerView.setDescendantFocusability(131072);
        LinearLayoutManagerImpl r2 = new LinearLayoutManagerImpl(this, r3);
        this.mLayoutManager = r2;
        this.mRecyclerView.setLayoutManager(r2);
        this.mRecyclerView.setScrollingTouchSlop(1);
        setOrientation(r3, r4);
        this.mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRecyclerView.addOnChildAttachStateChangeListener(enforceChildFillListener());
        ScrollEventAdapter r5 = new ScrollEventAdapter(this);
        this.mScrollEventAdapter = r5;
        this.mFakeDragger = new FakeDrag(this, r5, this.mRecyclerView);
        PagerSnapHelperImpl r6 = new PagerSnapHelperImpl(this);
        this.mPagerSnapHelper = r6;
        r6.attachToRecyclerView(this.mRecyclerView);
        this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
        CompositeOnPageChangeCallback r7 = new CompositeOnPageChangeCallback(3);
        this.mPageChangeEventDispatcher = r7;
        this.mScrollEventAdapter.setOnPageChangeCallback(r7);
        OnPageChangeCallback r8 = new AnonymousClass2(this);
        OnPageChangeCallback r9 = new AnonymousClass3(this);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r8);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r9);
        this.mAccessibilityProvider.onInitialize(this.mPageChangeEventDispatcher, this.mRecyclerView);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(this.mExternalPageChangeCallbacks);
        PageTransformerAdapter r10 = new PageTransformerAdapter(this.mLayoutManager);
        this.mPageTransformerAdapter = r10;
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r10);
        RecyclerView r11 = this.mRecyclerView;
        attachViewToParent(r11, 0, r11.getLayoutParams());
        return;
    L5:
        r0 = new BasicAccessibilityProvider(this);
        goto L6
    }

    public void addItemDecoration(RecyclerView.ItemDecoration r2, int r3) {
        this.mRecyclerView.addItemDecoration(r2, r3);
    }

    @Override // android.view.View
    public void onMeasure(int r6, int r7) {
        measureChild(this.mRecyclerView, r6, r7);
        int r0 = this.mRecyclerView.getMeasuredWidth();
        int r1 = this.mRecyclerView.getMeasuredHeight();
        int r2 = this.mRecyclerView.getMeasuredState();
        int r3 = r0 + (getPaddingLeft() + getPaddingRight());
        int r4 = r1 + (getPaddingTop() + getPaddingBottom());
        int r5 = Math.max(r3, getSuggestedMinimumWidth());
        int r8 = Math.max(r4, getSuggestedMinimumHeight());
        setMeasuredDimension(ViewGroup.resolveSizeAndState(r5, r6, r2), ViewGroup.resolveSizeAndState(r8, r7, r2 << 16));
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int r2, Bundle r3) {
        if (this.mAccessibilityProvider.handlesPerformAccessibilityAction(r2, r3) == false) goto L7;
        return this.mAccessibilityProvider.onPerformAccessibilityAction(r2, r3);
    L7:
        return super.performAccessibilityAction(r2, r3);
    }

    public void setCurrentItem(int r2, boolean r3) {
        if (isFakeDragging() == true) goto L7;
        setCurrentItemInternal(r2, r3);
        return;
    L7:
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public void setCurrentItemInternal(int r9, boolean r10) {
        RecyclerView.Adapter r0 = getAdapter();
        if (r0 != null) goto L9;
        if (this.mPendingCurrentItem == (-1)) goto L36;
        this.mPendingCurrentItem = Math.max(r9, 0);
        return;
    L36:
        return;
    L9:
        if (r0.getItemCount() > 0) goto L11;
        return;
    L11:
        int r11 = Math.min(Math.max(r9, 0), r0.getItemCount() - 1);
        if (r11 == this.mCurrentItem) goto L14;
    L16:
        int r1 = this.mCurrentItem;
        if (r11 != r1) goto L20;
        if (r10 == false) goto L20;
        return;
    L20:
        double r2 = r1;
        this.mCurrentItem = r11;
        this.mAccessibilityProvider.onSetNewCurrentItem();
        if (this.mScrollEventAdapter.isIdle() == true) goto L23;
        r2 = this.mScrollEventAdapter.getRelativeScrollPosition();
    L23:
        this.mScrollEventAdapter.notifyProgrammaticScroll(r11, r10);
        if (r10 == true) goto L27;
        this.mRecyclerView.scrollToPosition(r11);
        return;
    L27:
        double r3 = r11;
        if (Math.abs(r3 - r2) <= 3.0d) goto L34;
        RecyclerView r12 = this.mRecyclerView;
        if (r3 <= r2) goto L32;
        int r4 = r11 - 3;
    L33:
        r12.scrollToPosition(r4);
        RecyclerView r13 = this.mRecyclerView;
        r13.post(new SmoothScrollToPosition(r11, r13));
        return;
    L32:
        r4 = r11 + 3;
        goto L33
    L34:
        this.mRecyclerView.smoothScrollToPosition(r11);
        return;
    L14:
        if (this.mScrollEventAdapter.isIdle() == false) goto L16;
    }

    public ViewPager2(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r3, r4);
    }

    public ViewPager2(Context r2, AttributeSet r3, int r4, int r5) {
        super(r2, r3, r4, r5);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        int r9 = this.mRecyclerView.getMeasuredWidth();
        int r0 = this.mRecyclerView.getMeasuredHeight();
        Rect r1 = this.mTmpContainerRect;
        r1.left = getPaddingLeft();
        Rect r2 = this.mTmpContainerRect;
        r2.right = (r7 - r5) - getPaddingRight();
        Rect r10 = this.mTmpContainerRect;
        r10.top = getPaddingTop();
        Rect r11 = this.mTmpContainerRect;
        r11.bottom = (r8 - r6) - getPaddingBottom();
        Gravity.apply(8388659, r9, r0, this.mTmpContainerRect, this.mTmpChildRect);
        RecyclerView r12 = this.mRecyclerView;
        Rect r13 = this.mTmpChildRect;
        r12.layout(r13.left, r13.top, r13.right, r13.bottom);
        if (this.mCurrentItemDirty == false) goto L6;
        updateCurrentItem();
        return;
    }
}
