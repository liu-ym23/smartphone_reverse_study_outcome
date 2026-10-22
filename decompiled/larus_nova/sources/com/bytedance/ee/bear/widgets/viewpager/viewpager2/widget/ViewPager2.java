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

/* JADX INFO: loaded from: classes18.dex */
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

        public boolean handlesLmPerformAccessibilityAction(int r100) {
            return false;
        }

        public boolean handlesPerformAccessibilityAction(int r100, Bundle r101) {
            return false;
        }

        public boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        public void onAttachAdapter(RecyclerView.Adapter<?> r100) {
        }

        public void onDetachAdapter(RecyclerView.Adapter<?> r100) {
        }

        public void onInitialize(CompositeOnPageChangeCallback r100, RecyclerView r101) {
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r100) {
        }

        public void onLmInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat r100) {
        }

        public void onRestorePendingState() {
        }

        public void onRvInitializeAccessibilityEvent(AccessibilityEvent r100) {
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

        private AccessibilityProvider(ViewPager2 r100) {
            this.this$0 = r100;
        }

        public boolean onLmPerformAccessibilityAction(int r100) {
            throw new IllegalStateException("Not implemented.");
        }

        public /* synthetic */ AccessibilityProvider(ViewPager2 r100, AnonymousClass1 r101) {
            this(r100);
        }

        public boolean onPerformAccessibilityAction(int r100, Bundle r101) {
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

        public BasicAccessibilityProvider(ViewPager2 r100) {
            this.this$0 = r100;
            super(r100, null);
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int r100) {
            if (r100 == 8192) goto L7;
            if (r100 == 4096) goto L7;
        L9:
            return false;
        L7:
            if (this.this$0.isUserInputEnabled() == true) goto L9;
            return true;
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat r100) {
            if (this.this$0.isUserInputEnabled() == true) goto L6;
            r100.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            r100.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            r100.setScrollable(false);
            return;
        }

        @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int r100) {
            if (handlesLmPerformAccessibilityAction(r100) == false) goto L7;
            return false;
        L7:
            throw new IllegalStateException();
        }
    }

    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        private DataSetChangeObserver() {
        }

        public /* synthetic */ DataSetChangeObserver(AnonymousClass1 r100) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r100, int r101) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r100, int r101) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101, Object r102) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r100, int r101, int r102) {
            onChanged();
        }
    }

    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        final /* synthetic */ ViewPager2 this$0;

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView r100, View r101, Rect r102, boolean r103, boolean r104) {
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public int getExtraLayoutSpace(RecyclerView.State r100) {
            int r101 = this.this$0.getOffscreenPageLimit();
            if (r101 != (-1)) goto L7;
            return super.getExtraLayoutSpace(r100);
        L7:
            return this.this$0.getPageSize() * r101;
        }

        public LinearLayoutManagerImpl(ViewPager2 r100, Context r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler r100, RecyclerView.State r101, AccessibilityNodeInfoCompat r102) {
            super.onInitializeAccessibilityNodeInfo(r100, r101, r102);
            this.this$0.mAccessibilityProvider.onLmInitializeAccessibilityNodeInfo(r102);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(RecyclerView.Recycler r100, RecyclerView.State r101, int r102, Bundle r103) {
            if (this.this$0.mAccessibilityProvider.handlesLmPerformAccessibilityAction(r102) == false) goto L7;
            return this.this$0.mAccessibilityProvider.onLmPerformAccessibilityAction(r102);
        L7:
            return super.performAccessibilityAction(r100, r101, r102, r103);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OffscreenPageLimit {
    }

    public static abstract class OnPageChangeCallback {
        public OnPageChangeCallback() {
        }

        public void onPageScrollStateChanged(int r100) {
        }

        public void onPageScrolled(int r100, float r101, int r102) {
        }

        public void onPageSelected(int r100) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public interface PageTransformer {
        void transformPage(View r100, float r101);
    }

    public class PagerSnapHelperImpl extends PagerSnapHelper {
        final /* synthetic */ ViewPager2 this$0;

        public PagerSnapHelperImpl(ViewPager2 r100) {
            this.this$0 = r100;
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        public View findSnapView(RecyclerView.LayoutManager r100) {
            if (this.this$0.isFakeDragging() == false) goto L6;
            return null;
        L6:
            return super.findSnapView(r100);
        }
    }

    public class RecyclerViewImpl extends RecyclerView {
        final /* synthetic */ ViewPager2 this$0;

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            if (this.this$0.mAccessibilityProvider.handlesRvGetAccessibilityClassName() == false) goto L7;
            return this.this$0.mAccessibilityProvider.onRvGetAccessibilityClassName();
        L7:
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
            super.onInitializeAccessibilityEvent(r100);
            r100.setFromIndex(this.this$0.mCurrentItem);
            r100.setToIndex(this.this$0.mCurrentItem);
            this.this$0.mAccessibilityProvider.onRvInitializeAccessibilityEvent(r100);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent r100) {
            if (this.this$0.isUserInputEnabled() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onInterceptTouchEvent(r100) == false) goto L7;
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent r100) {
            if (this.this$0.isUserInputEnabled() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onTouchEvent(r100) == false) goto L7;
            return true;
        }

        public RecyclerViewImpl(ViewPager2 r100, Context r101) {
            this.this$0 = r100;
            super(r101);
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

        public SavedState(Parcel r100) {
            super(r100);
            readValues(r100, null);
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            readValues(r100, r101);
        }

        private void readValues(Parcel r100, ClassLoader r101) {
            this.mRecyclerViewId = r100.readInt();
            this.mCurrentItem = r100.readInt();
            this.mAdapterState = r100.readParcelable(r101);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.mRecyclerViewId);
            r100.writeInt(this.mCurrentItem);
            r100.writeParcelable(this.mAdapterState, r101);
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
        public static void com_bytedance_ee_bear_widgets_viewpager_viewpager2_widget_ViewPager2$SmoothScrollToPosition_com_larus_apm_impl_protector_RunnableLancet_run(SmoothScrollToPosition r100) {
            r100.com_bytedance_ee_bear_widgets_viewpager_viewpager2_widget_ViewPager2$SmoothScrollToPosition__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public SmoothScrollToPosition(int r100, RecyclerView r101) {
            this.mPosition = r100;
            this.mRecyclerView = r101;
        }
    }

    private void setOrientation(Context r100, AttributeSet r101) {
    }

    private RecyclerView.OnChildAttachStateChangeListener enforceChildFillListener() {
        return new AnonymousClass4(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void restorePendingState() {
        if (this.mPendingCurrentItem != (-1)) goto L5;
        return;
    L5:
        RecyclerView.Adapter r100 = getAdapter();
        if (r100 != 0) goto L8;
        return;
    L8:
        Parcelable r101 = this.mPendingAdapterState;
        if (r101 != null) goto L11;
    L14:
        int r102 = Math.max(0, Math.min(this.mPendingCurrentItem, r100.getItemCount() - 1));
        this.mCurrentItem = r102;
        this.mPendingCurrentItem = -1;
        this.mRecyclerView.scrollToPosition(r102);
        this.mAccessibilityProvider.onRestorePendingState();
        return;
    L11:
        if ((r100 instanceof StatefulAdapter) == false) goto L13;
        ((StatefulAdapter) r100).restoreState(r101);
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
        RecyclerView r100 = this.mRecyclerView;
        if (getOrientation() != 0) goto L5;
        int r101 = r100.getWidth() - r100.getPaddingLeft();
        int r102 = r100.getPaddingRight();
    L7:
        return r101 - r102;
    L5:
        r101 = r100.getHeight() - r100.getPaddingTop();
        r102 = r100.getPaddingBottom();
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
        double r100 = this.mScrollEventAdapter.getRelativeScrollPosition();
        int r101 = (int) r100;
        float r102 = (float) (r100 - ((double) r101));
        this.mPageTransformerAdapter.onPageScrolled(r101, r102, Math.round(getPageSize() * r102));
    }

    public void snapToPage() {
        View r100 = this.mPagerSnapHelper.findSnapView(this.mLayoutManager);
        if (r100 != null) goto L5;
        return;
    L5:
        int[] r101 = this.mPagerSnapHelper.calculateDistanceToFinalSnap(this.mLayoutManager, r100);
        int r102 = r101[0];
        if (r102 == 0) goto L8;
    L9:
        this.mRecyclerView.smoothScrollBy(r102, r101[1]);
        return;
    L8:
        if (r101[1] != 0) goto L9;
    }

    public void updateCurrentItem() {
        PagerSnapHelper r100 = this.mPagerSnapHelper;
        if (r100 == null) goto L15;
        View r101 = r100.findSnapView(this.mLayoutManager);
        if (r101 != null) goto L7;
        return;
    L7:
        int r102 = this.mLayoutManager.getPosition(r101);
        if (r102 != this.mCurrentItem) goto L10;
    L12:
        this.mCurrentItemDirty = false;
        return;
    L10:
        if (getScrollState() != 0) goto L12;
        this.mPageChangeEventDispatcher.onPageSelected(r102);
        goto L12
    L15:
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.mRecyclerViewId = this.mRecyclerView.getId();
        int r101 = this.mPendingCurrentItem;
        if (r101 != (-1)) goto L5;
        r101 = this.mCurrentItem;
    L5:
        r100.mCurrentItem = r101;
        Parcelable r102 = this.mPendingAdapterState;
        if (r102 == null) goto L8;
        r100.mAdapterState = r102;
    L11:
        return r100;
    L8:
        Object r103 = this.mRecyclerView.getAdapter();
        if ((r103 instanceof StatefulAdapter) == false) goto L11;
        r100.mAdapterState = ((StatefulAdapter) r103).saveState();
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

    public ViewPager2(Context r100) {
        super(r100);
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
        initialize(r100, null);
    }

    private void registerCurrentItemDataSetTracker(RecyclerView.Adapter<?> r100) {
        if (r100 == null) goto L5;
        r100.registerAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        return;
    }

    private void unregisterCurrentItemDataSetTracker(RecyclerView.Adapter<?> r100) {
        if (r100 == null) goto L5;
        r100.unregisterAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        return;
    }

    public void addItemDecoration(RecyclerView.ItemDecoration r100) {
        this.mRecyclerView.addItemDecoration(r100);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r100) {
        return this.mRecyclerView.canScrollHorizontally(r100);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r100) {
        return this.mRecyclerView.canScrollVertically(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r100) {
        Parcelable r101 = r100.get(getId());
        if ((r101 instanceof SavedState) == false) goto L5;
        int r102 = ((SavedState) r101).mRecyclerViewId;
        r100.put(this.mRecyclerView.getId(), r100.get(r102));
        r100.remove(r102);
    L5:
        super.dispatchRestoreInstanceState(r100);
        restorePendingState();
    }

    public boolean fakeDragBy(float r100) {
        return this.mFakeDragger.fakeDragBy(r100);
    }

    public RecyclerView.ItemDecoration getItemDecorationAt(int r100) {
        return this.mRecyclerView.getItemDecorationAt(r100);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r100) {
        super.onInitializeAccessibilityNodeInfo(r100);
        this.mAccessibilityProvider.onInitializeAccessibilityNodeInfo(r100);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        this.mPendingCurrentItem = r101.mCurrentItem;
        this.mPendingAdapterState = r101.mAdapterState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r100) {
        throw new IllegalStateException(getClass().getSimpleName().concat(" does not support direct child views"));
    }

    public void registerOnPageChangeCallback(OnPageChangeCallback r100) {
        this.mExternalPageChangeCallbacks.addOnPageChangeCallback(r100);
    }

    public void removeItemDecoration(RecyclerView.ItemDecoration r100) {
        this.mRecyclerView.removeItemDecoration(r100);
    }

    public void removeItemDecorationAt(int r100) {
        this.mRecyclerView.removeItemDecorationAt(r100);
    }

    public void setAdapter(RecyclerView.Adapter r100) {
        RecyclerView.Adapter r101 = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.onDetachAdapter(r101);
        unregisterCurrentItemDataSetTracker(r101);
        this.mRecyclerView.setAdapter(r100);
        this.mCurrentItem = 0;
        restorePendingState();
        this.mAccessibilityProvider.onAttachAdapter(r100);
        registerCurrentItemDataSetTracker(r100);
    }

    public void setCurrentItem(int r100) {
        setCurrentItem(r100, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int r100) {
        super.setLayoutDirection(r100);
        this.mAccessibilityProvider.onSetLayoutDirection();
    }

    public void setOffscreenPageLimit(int r100) {
        if (r100 < 1) goto L5;
    L9:
        this.mOffscreenPageLimit = r100;
        this.mRecyclerView.requestLayout();
        return;
    L5:
        if (r100 == (-1)) goto L9;
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int r100) {
        this.mLayoutManager.setOrientation(r100);
        this.mAccessibilityProvider.onSetOrientation();
    }

    public void setPageTransformer(PageTransformer r100) {
        if (r100 == null) goto L9;
        if (this.mSavedItemAnimatorPresent == true) goto L7;
        this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
        this.mSavedItemAnimatorPresent = true;
    L7:
        this.mRecyclerView.setItemAnimator(null);
    L12:
        if (r100 != this.mPageTransformerAdapter.getPageTransformer()) goto L14;
        return;
    L14:
        this.mPageTransformerAdapter.setPageTransformer(r100);
        requestTransform();
        return;
    L9:
        if (this.mSavedItemAnimatorPresent == false) goto L12;
        this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        goto L12
    }

    public void setUserInputEnabled(boolean r100) {
        this.mUserInputEnabled = r100;
        this.mAccessibilityProvider.onSetUserInputEnabled();
    }

    public void unregisterOnPageChangeCallback(OnPageChangeCallback r100) {
        this.mExternalPageChangeCallbacks.removeOnPageChangeCallback(r100);
    }

    public ViewPager2(Context r100, AttributeSet r101) {
        super(r100, r101);
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
        initialize(r100, r101);
    }

    private void initialize(Context r100, AttributeSet r101) {
        if (sFeatureEnhancedA11yEnabled == false) goto L5;
        BasicAccessibilityProvider r102 = new BasicAccessibilityProvider(this);
    L6:
        this.mAccessibilityProvider = r102;
        RecyclerViewImpl r103 = new RecyclerViewImpl(this, r100);
        this.mRecyclerView = r103;
        r103.setId(ViewCompat.generateViewId());
        this.mRecyclerView.setDescendantFocusability(131072);
        LinearLayoutManagerImpl r104 = new LinearLayoutManagerImpl(this, r100);
        this.mLayoutManager = r104;
        this.mRecyclerView.setLayoutManager(r104);
        this.mRecyclerView.setScrollingTouchSlop(1);
        setOrientation(r100, r101);
        this.mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRecyclerView.addOnChildAttachStateChangeListener(enforceChildFillListener());
        ScrollEventAdapter r105 = new ScrollEventAdapter(this);
        this.mScrollEventAdapter = r105;
        this.mFakeDragger = new FakeDrag(this, r105, this.mRecyclerView);
        PagerSnapHelperImpl r106 = new PagerSnapHelperImpl(this);
        this.mPagerSnapHelper = r106;
        r106.attachToRecyclerView(this.mRecyclerView);
        this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
        CompositeOnPageChangeCallback r107 = new CompositeOnPageChangeCallback(3);
        this.mPageChangeEventDispatcher = r107;
        this.mScrollEventAdapter.setOnPageChangeCallback(r107);
        OnPageChangeCallback r108 = new AnonymousClass2(this);
        OnPageChangeCallback r109 = new AnonymousClass3(this);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r108);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r109);
        this.mAccessibilityProvider.onInitialize(this.mPageChangeEventDispatcher, this.mRecyclerView);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(this.mExternalPageChangeCallbacks);
        PageTransformerAdapter r110 = new PageTransformerAdapter(this.mLayoutManager);
        this.mPageTransformerAdapter = r110;
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r110);
        RecyclerView r111 = this.mRecyclerView;
        attachViewToParent(r111, 0, r111.getLayoutParams());
        return;
    L5:
        r102 = new BasicAccessibilityProvider(this);
        goto L6
    }

    public void addItemDecoration(RecyclerView.ItemDecoration r100, int r101) {
        this.mRecyclerView.addItemDecoration(r100, r101);
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        measureChild(this.mRecyclerView, r100, r101);
        int r102 = this.mRecyclerView.getMeasuredWidth();
        int r103 = this.mRecyclerView.getMeasuredHeight();
        int r104 = this.mRecyclerView.getMeasuredState();
        int r105 = r102 + (getPaddingLeft() + getPaddingRight());
        int r106 = r103 + (getPaddingTop() + getPaddingBottom());
        int r107 = Math.max(r105, getSuggestedMinimumWidth());
        int r108 = Math.max(r106, getSuggestedMinimumHeight());
        setMeasuredDimension(ViewGroup.resolveSizeAndState(r107, r100, r104), ViewGroup.resolveSizeAndState(r108, r101, r104 << 16));
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int r100, Bundle r101) {
        if (this.mAccessibilityProvider.handlesPerformAccessibilityAction(r100, r101) == false) goto L7;
        return this.mAccessibilityProvider.onPerformAccessibilityAction(r100, r101);
    L7:
        return super.performAccessibilityAction(r100, r101);
    }

    public void setCurrentItem(int r100, boolean r101) {
        if (isFakeDragging() == true) goto L7;
        setCurrentItemInternal(r100, r101);
        return;
    L7:
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public void setCurrentItemInternal(int r100, boolean r110) {
        RecyclerView.Adapter r101 = getAdapter();
        if (r101 != null) goto L9;
        if (this.mPendingCurrentItem == (-1)) goto L36;
        this.mPendingCurrentItem = Math.max(r100, 0);
        return;
    L36:
        return;
    L9:
        if (r101.getItemCount() > 0) goto L11;
        return;
    L11:
        int r102 = Math.min(Math.max(r100, 0), r101.getItemCount() - 1);
        if (r102 == this.mCurrentItem) goto L14;
    L16:
        int r103 = this.mCurrentItem;
        if (r102 != r103) goto L20;
        if (r110 == false) goto L20;
        return;
    L20:
        double r104 = r103;
        this.mCurrentItem = r102;
        this.mAccessibilityProvider.onSetNewCurrentItem();
        if (this.mScrollEventAdapter.isIdle() == true) goto L23;
        r104 = this.mScrollEventAdapter.getRelativeScrollPosition();
    L23:
        this.mScrollEventAdapter.notifyProgrammaticScroll(r102, r110);
        if (r110 == true) goto L27;
        this.mRecyclerView.scrollToPosition(r102);
        return;
    L27:
        double r105 = r102;
        if (Math.abs(r105 - r104) <= 3.0d) goto L34;
        RecyclerView r111 = this.mRecyclerView;
        if (r105 <= r104) goto L32;
        int r106 = r102 - 3;
    L33:
        r111.scrollToPosition(r106);
        RecyclerView r112 = this.mRecyclerView;
        r112.post(new SmoothScrollToPosition(r102, r112));
        return;
    L32:
        r106 = r102 + 3;
        goto L33
    L34:
        this.mRecyclerView.smoothScrollToPosition(r102);
        return;
    L14:
        if (this.mScrollEventAdapter.isIdle() == false) goto L16;
    }

    public ViewPager2(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
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
        initialize(r100, r101);
    }

    public ViewPager2(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
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
        initialize(r100, r101);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = this.mRecyclerView.getMeasuredWidth();
        int r106 = this.mRecyclerView.getMeasuredHeight();
        Rect r107 = this.mTmpContainerRect;
        r107.left = getPaddingLeft();
        Rect r108 = this.mTmpContainerRect;
        r108.right = (r103 - r101) - getPaddingRight();
        Rect r109 = this.mTmpContainerRect;
        r109.top = getPaddingTop();
        Rect r110 = this.mTmpContainerRect;
        r110.bottom = (r104 - r102) - getPaddingBottom();
        Gravity.apply(8388659, r105, r106, this.mTmpContainerRect, this.mTmpChildRect);
        RecyclerView r111 = this.mRecyclerView;
        Rect r112 = this.mTmpChildRect;
        r111.layout(r112.left, r112.top, r112.right, r112.bottom);
        if (this.mCurrentItemDirty == false) goto L6;
        updateCurrentItem();
        return;
    }
}
