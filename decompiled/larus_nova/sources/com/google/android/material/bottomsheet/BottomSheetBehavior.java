package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    int activePointerId;
    private BottomSheetCallback callback;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback;
    private boolean fitToContents;
    int fitToContentsOffset;
    int halfExpandedOffset;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int lastNestedScrollDy;
    private int lastPeekHeight;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    int parentHeight;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private boolean skipCollapsed;
    int state;
    boolean touchingScrollingChild;
    private VelocityTracker velocityTracker;
    ViewDragHelper viewDragHelper;
    WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        public BottomSheetCallback() {
        }

        public abstract void onSlide(View r100, float r101);

        public abstract void onStateChanged(View r100, int r101);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final int state;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r100) {
            this(r100, null);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            this.state = r100.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.state);
        }

        public SavedState(Parcelable r100, int r101) {
            super(r100);
            this.state = r101;
        }
    }

    public class SettleRunnable implements Runnable {
        private final int targetState;
        final /* synthetic */ BottomSheetBehavior this$0;
        private final View view;

        @Override // java.lang.Runnable
        public void run() {
            com_google_android_material_bottomsheet_BottomSheetBehavior$SettleRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_google_android_material_bottomsheet_BottomSheetBehavior$SettleRunnable__run$___twin___() {
            ViewDragHelper r100 = this.this$0.viewDragHelper;
            if (r100 != null) goto L5;
        L7:
            this.this$0.setStateInternal(this.targetState);
            return;
        L5:
            if (r100.continueSettling(true) == false) goto L7;
            ViewCompat.postOnAnimation(this.view, this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_google_android_material_bottomsheet_BottomSheetBehavior$SettleRunnable_com_larus_apm_impl_protector_RunnableLancet_run(SettleRunnable r100) {
            r100.com_google_android_material_bottomsheet_BottomSheetBehavior$SettleRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public SettleRunnable(BottomSheetBehavior r100, View r101, int r102) {
            this.this$0 = r100;
            this.view = r101;
            this.targetState = r102;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker r100 = this.velocityTracker;
        if (r100 == null) goto L6;
        r100.recycle();
        this.velocityTracker = null;
        return;
    }

    private void calculateCollapsedOffset() {
        if (this.fitToContents == false) goto L5;
        this.collapsedOffset = Math.max(this.parentHeight - this.lastPeekHeight, this.fitToContentsOffset);
        return;
    L5:
        this.collapsedOffset = this.parentHeight - this.lastPeekHeight;
    }

    private int getExpandedOffset() {
        if (this.fitToContents == true) goto L7;
        return 0;
    L7:
        return this.fitToContentsOffset;
    }

    private float getYVelocity() {
        VelocityTracker r100 = this.velocityTracker;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        r100.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    public final int getPeekHeight() {
        if (this.peekHeightAuto == false) goto L6;
        return -1;
    L6:
        return this.peekHeight;
    }

    public BottomSheetBehavior() {
        this.fitToContents = true;
        this.state = 4;
        this.dragCallback = new AnonymousClass2(this);
    }

    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public final int getState() {
        return this.state;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public static /* synthetic */ boolean access$000(BottomSheetBehavior r100) {
        return r100.fitToContents;
    }

    public static /* synthetic */ int access$100(BottomSheetBehavior r100) {
        return r100.getExpandedOffset();
    }

    public static <V extends View> BottomSheetBehavior<V> from(V r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r102 = ((CoordinatorLayout.LayoutParams) r101).getBehavior();
        if ((r102 instanceof BottomSheetBehavior) == false) goto L9;
        return (BottomSheetBehavior) r102;
    L9:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private void updateImportantForAccessibility(boolean r100) {
        WeakReference<V> r101 = this.viewRef;
        if (r101 != null) goto L5;
        return;
    L5:
        ViewParent r102 = r101.get().getParent();
        if ((r102 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r103 = (CoordinatorLayout) r102;
        int r104 = r103.getChildCount();
        if (r100 == true) goto L11;
    L14:
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L27;
        View r106 = r103.getChildAt(r105);
        if (r106 == this.viewRef.get()) goto L26;
        if (r100 == true) goto L25;
        Map<View, Integer> r107 = this.importantForAccessibilityMap;
        if (r107 == null) goto L26;
        if (r107.containsKey(r106) == false) goto L26;
        ViewCompat.setImportantForAccessibility(r106, this.importantForAccessibilityMap.get(r106).intValue());
        goto L26
    L25:
        this.importantForAccessibilityMap.put(r106, Integer.valueOf(r106.getImportantForAccessibility()));
        ViewCompat.setImportantForAccessibility(r106, 4);
    L26:
        r105 = r105 + 1;
        goto L15
    L27:
        if (r100 == true) goto L36;
        this.importantForAccessibilityMap = null;
        return;
    L36:
        return;
    L11:
        if (this.importantForAccessibilityMap != null) goto L13;
        this.importantForAccessibilityMap = new HashMap(r104);
        goto L14
    }

    public void dispatchOnSlide(int r100) {
        V r101 = this.viewRef.get();
        if (r101 == null) goto L11;
        BottomSheetCallback r102 = this.callback;
        if (r102 == null) goto L12;
        int r103 = this.collapsedOffset;
        if (r100 <= r103) goto L9;
        r102.onSlide(r101, (r103 - r100) / (this.parentHeight - r103));
        return;
    L9:
        r102.onSlide(r101, (r103 - r100) / (r103 - getExpandedOffset()));
        return;
    L12:
        return;
    }

    public View findScrollingChild(View r100) {
        if (ViewCompat.isNestedScrollingEnabled(r100) == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof ViewGroup) == false) goto L13;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L17;
        View r104 = findScrollingChild(r101.getChildAt(r103));
        if (r104 != null) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return r104;
    L17:
        return null;
    L13:
        return null;
    }

    public void setBottomSheetCallback(BottomSheetCallback r100) {
        this.callback = r100;
    }

    public void setFitToContents(boolean r100) {
        if (this.fitToContents != r100) goto L5;
        return;
    L5:
        this.fitToContents = r100;
        if (this.viewRef == null) goto L9;
        calculateCollapsedOffset();
    L9:
        if (this.fitToContents == true) goto L11;
    L13:
        int r101 = this.state;
    L14:
        setStateInternal(r101);
        return;
    L11:
        if (this.state != 6) goto L13;
        r101 = 3;
        goto L14
    }

    public void setHideable(boolean r100) {
        this.hideable = r100;
    }

    public final void setPeekHeight(int r100) {
        boolean r101 = true;
        if (r100 != (-1)) goto L8;
        if (this.peekHeightAuto == true) goto L12;
        this.peekHeightAuto = true;
    L14:
        if (r101 == true) goto L16;
        return;
    L16:
        if (this.state != 4) goto L24;
        WeakReference<V> r102 = this.viewRef;
        if (r102 == null) goto L25;
        V r103 = r102.get();
        if (r103 == null) goto L26;
        r103.requestLayout();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L12:
        r101 = false;
        goto L14
    L8:
        if (this.peekHeightAuto == false) goto L10;
    L13:
        this.peekHeightAuto = false;
        this.peekHeight = Math.max(0, r100);
        this.collapsedOffset = this.parentHeight - r100;
        goto L14
    L10:
        if (this.peekHeight == r100) goto L12;
        goto L12
    }

    public void setSkipCollapsed(boolean r100) {
        this.skipCollapsed = r100;
    }

    public final void setState(final int r100) {
        if (r100 != this.state) goto L5;
        return;
    L5:
        WeakReference<V> r101 = this.viewRef;
        if (r101 == null) goto L8;
        final V r102 = r101.get();
        if (r102 != null) goto L22;
        return;
    L22:
        ViewParent r103 = r102.getParent();
        if (r103 != null) goto L25;
    L29:
        startSettlingAnimation(r102, r100);
        return;
    L25:
        if (r103.isLayoutRequested() == false) goto L29;
        if (ViewCompat.isAttachedToWindow(r102) == false) goto L29;
        r102.post(new AnonymousClass1(this, r102, r100));
        return;
    L8:
        if (r100 != 4) goto L10;
    L17:
        this.state = r100;
        return;
    L10:
        if (r100 == 3) goto L17;
        if (r100 == 6) goto L17;
        if (this.hideable == true) goto L16;
        return;
    L16:
        if (r100 == 5) goto L17;
    }

    public void setStateInternal(int r100) {
        if (this.state != r100) goto L5;
        return;
    L5:
        this.state = r100;
        if (r100 != 6) goto L8;
    L15:
        updateImportantForAccessibility(true);
    L16:
        V r101 = this.viewRef.get();
        if (r101 == null) goto L22;
        BottomSheetCallback r102 = this.callback;
        if (r102 == null) goto L23;
        r102.onStateChanged(r101, r100);
        return;
    L23:
        return;
    L22:
        return;
    L8:
        if (r100 == 3) goto L15;
        if (r100 != 5) goto L13;
    L14:
        updateImportantForAccessibility(false);
        goto L16
    L13:
        if (r100 != 4) goto L16;
        goto L14
    }

    public BottomSheetBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.fitToContents = true;
        this.state = 4;
        this.dragCallback = new AnonymousClass2(this);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_fitToContents, R.attr.behavior_hideable, R.attr.behavior_peekHeight, R.attr.behavior_skipCollapsed});
        TypedValue r103 = r102.peekValue(2);
        if (r103 == null) goto L7;
        int r104 = r103.data;
        if (r104 != (-1)) goto L7;
        setPeekHeight(r104);
    L8:
        setHideable(r102.getBoolean(1, false));
        setFitToContents(r102.getBoolean(0, true));
        setSkipCollapsed(r102.getBoolean(3, false));
        r102.recycle();
        this.maximumVelocity = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r102.getDimensionPixelSize(2, -1));
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
        return new SavedState(super.onSaveInstanceState(r100, r101), this.state);
    }

    public boolean shouldHide(View r100, float r101) {
        if (this.skipCollapsed == false) goto L6;
        return true;
    L6:
        if (r100.getTop() >= this.collapsedOffset) goto L9;
        return false;
    L9:
        if ((Math.abs((r100.getTop() + (r101 * 0.1f)) - this.collapsedOffset) / this.peekHeight) > 0.5f) goto L13;
        return false;
    L13:
        return true;
    }

    public void startSettlingAnimation(View r100, int r101) {
        if (r101 != 4) goto L6;
        int r102 = this.collapsedOffset;
    L20:
        if (this.viewDragHelper.smoothSlideViewTo(r100, r100.getLeft(), r102) == false) goto L22;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r100, new SettleRunnable(this, r100, r101));
        return;
    L22:
        setStateInternal(r101);
        return;
    L6:
        if (r101 != 6) goto L12;
        r102 = this.halfExpandedOffset;
        if (this.fitToContents == false) goto L20;
        int r103 = this.fitToContentsOffset;
        if (r102 > r103) goto L20;
        r102 = r103;
        r101 = 3;
        goto L20
    L12:
        if (r101 != 3) goto L15;
        r102 = getExpandedOffset();
        goto L20
    L15:
        if (this.hideable == false) goto L25;
        if (r101 != 5) goto L25;
        r102 = this.parentHeight;
    L25:
        throw new IllegalArgumentException("Illegal state argument: " + r101);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r100, V r110, MotionEvent r111) {
        if (r110.isShown() == true) goto L6;
        this.ignoreEvents = true;
        return false;
    L6:
        int r101 = r111.getActionMasked();
        if (r101 != 0) goto L10;
        reset();
    L10:
        if (this.velocityTracker != null) goto L12;
        this.velocityTracker = VelocityTracker.obtain();
    L12:
        this.velocityTracker.addMovement(r111);
        View r102 = null;
        if (r101 == 0) goto L22;
        if (r101 != 1) goto L16;
    L18:
        this.touchingScrollingChild = false;
        this.activePointerId = -1;
        if (this.ignoreEvents == false) goto L38;
        this.ignoreEvents = false;
        return false;
    L38:
        if (this.ignoreEvents == true) goto L44;
        ViewDragHelper r112 = this.viewDragHelper;
        if (r112 == null) goto L44;
        if (r112.shouldInterceptTouchEvent(r111) == false) goto L44;
        return true;
    L44:
        WeakReference<View> r113 = this.nestedScrollingChildRef;
        if (r113 == null) goto L48;
        r102 = r113.get();
    L48:
        if (r101 != 2) goto L62;
        if (r102 != null) goto L51;
        return false;
    L51:
        if (this.ignoreEvents == false) goto L53;
        return false;
    L53:
        if (this.state != 1) goto L55;
        return false;
    L55:
        if (r100.isPointInChildBounds(r102, (int) r111.getX(), (int) r111.getY()) == false) goto L57;
        return false;
    L57:
        if (this.viewDragHelper != null) goto L59;
        return false;
    L59:
        if (Math.abs(this.initialY - r111.getY()) <= this.viewDragHelper.getTouchSlop()) goto L68;
        return true;
    L68:
        return false;
    L62:
        return false;
    L16:
        if (r101 == 3) goto L18;
    L22:
        int r103 = (int) r111.getX();
        this.initialY = (int) r111.getY();
        WeakReference<View> r104 = this.nestedScrollingChildRef;
        if (r104 == null) goto L25;
        View r105 = r104.get();
    L26:
        if (r105 == null) goto L31;
        if (r100.isPointInChildBounds(r105, r103, this.initialY) == false) goto L31;
        this.activePointerId = r111.getPointerId(r111.getActionIndex());
        this.touchingScrollingChild = true;
    L31:
        if (this.activePointerId == (-1)) goto L33;
    L35:
        boolean r114 = false;
    L36:
        this.ignoreEvents = r114;
        goto L38
    L33:
        if (r100.isPointInChildBounds(r110, r103, this.initialY) == true) goto L35;
        r114 = true;
        goto L36
    L25:
        r105 = null;
        goto L26
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        if (ViewCompat.getFitsSystemWindows(r100) == true) goto L5;
    L7:
        int r103 = r101.getTop();
        r100.onLayoutChild(r101, r102);
        this.parentHeight = r100.getHeight();
        if (this.peekHeightAuto == true) goto L10;
        this.lastPeekHeight = this.peekHeight;
    L14:
        this.fitToContentsOffset = Math.max(0, this.parentHeight - r101.getHeight());
        this.halfExpandedOffset = this.parentHeight / 2;
        calculateCollapsedOffset();
        int r104 = this.state;
        if (r104 != 3) goto L18;
        ViewCompat.offsetTopAndBottom(r101, getExpandedOffset());
    L32:
        if (this.viewDragHelper != null) goto L34;
        this.viewDragHelper = ViewDragHelper.create(r100, this.dragCallback);
    L34:
        this.viewRef = new WeakReference(r101);
        this.nestedScrollingChildRef = new WeakReference(findScrollingChild(r101));
        return true;
    L18:
        if (r104 != 6) goto L21;
        ViewCompat.offsetTopAndBottom(r101, this.halfExpandedOffset);
        goto L32
    L21:
        if (this.hideable == false) goto L26;
        if (r104 != 5) goto L26;
        ViewCompat.offsetTopAndBottom(r101, this.parentHeight);
    L26:
        if (r104 != 4) goto L28;
        ViewCompat.offsetTopAndBottom(r101, this.collapsedOffset);
        goto L32
    L28:
        if (r104 == 1) goto L30;
        if (r104 != 2) goto L32;
    L30:
        ViewCompat.offsetTopAndBottom(r101, r103 - r101.getTop());
        goto L32
    L10:
        if (this.peekHeightMin != 0) goto L12;
        this.peekHeightMin = r100.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
    L12:
        this.lastPeekHeight = Math.max(this.peekHeightMin, this.parentHeight - ((r100.getWidth() * 9) / 16));
        goto L14
    L5:
        if (ViewCompat.getFitsSystemWindows(r101) == true) goto L7;
        r101.setFitsSystemWindows(true);
        goto L7
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout r100, V r101, Parcelable r102) {
        SavedState r103 = (SavedState) r102;
        super.onRestoreInstanceState(r100, r101, r103.getSuperState());
        int r104 = r103.state;
        if (r104 != 1) goto L5;
    L8:
        this.state = 4;
        return;
    L5:
        if (r104 == 2) goto L8;
        this.state = r104;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        if (r101.isShown() == true) goto L6;
        return false;
    L6:
        int r103 = r102.getActionMasked();
        if (this.state != 1) goto L10;
        if (r103 != 0) goto L10;
        return true;
    L10:
        ViewDragHelper r104 = this.viewDragHelper;
        if (r104 == null) goto L13;
        r104.processTouchEvent(r102);
    L13:
        if (r103 != 0) goto L16;
        reset();
    L16:
        if (this.velocityTracker != null) goto L18;
        this.velocityTracker = VelocityTracker.obtain();
    L18:
        this.velocityTracker.addMovement(r102);
        if (r103 != 2) goto L26;
        if (this.ignoreEvents == true) goto L26;
        if (Math.abs(this.initialY - r102.getY()) <= this.viewDragHelper.getTouchSlop()) goto L26;
        this.viewDragHelper.captureChildView(r101, r102.getPointerId(r102.getActionIndex()));
    L26:
        return !this.ignoreEvents;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
        int r104 = 3;
        if (r101.getTop() != getExpandedOffset()) goto L7;
        setStateInternal(3);
        return;
    L7:
        if (r102 == this.nestedScrollingChildRef.get()) goto L9;
        return;
    L9:
        if (this.nestedScrolled == true) goto L12;
        return;
    L12:
        if (this.lastNestedScrollDy <= 0) goto L15;
        int r105 = getExpandedOffset();
    L41:
        if (this.viewDragHelper.smoothSlideViewTo(r101, r101.getLeft(), r105) == false) goto L43;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r101, new SettleRunnable(this, r101, r104));
    L44:
        this.nestedScrolled = false;
        return;
    L43:
        setStateInternal(r104);
        goto L44
    L15:
        if (this.hideable == false) goto L20;
        if (shouldHide(r101, getYVelocity()) == false) goto L20;
        r105 = this.parentHeight;
        r104 = 5;
    L20:
        if (this.lastNestedScrollDy != 0) goto L38;
        int r106 = r101.getTop();
        if (this.fitToContents == true) goto L24;
        int r107 = this.halfExpandedOffset;
        if (r106 >= r107) goto L34;
        if (r106 >= Math.abs(r106 - this.collapsedOffset)) goto L32;
        r105 = 0;
        goto L41
    L32:
        r105 = this.halfExpandedOffset;
    L36:
        r104 = 6;
        goto L41
    L34:
        if (Math.abs(r106 - r107) >= Math.abs(r106 - this.collapsedOffset)) goto L37;
        r105 = this.halfExpandedOffset;
        goto L36
    L37:
        r105 = this.collapsedOffset;
    L39:
        r104 = 4;
        goto L41
    L24:
        if (Math.abs(r106 - this.fitToContentsOffset) >= Math.abs(r106 - this.collapsedOffset)) goto L26;
        r105 = this.fitToContentsOffset;
        goto L41
    L26:
        r105 = this.collapsedOffset;
        goto L39
    L38:
        r105 = this.collapsedOffset;
        goto L39
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        if (r102 == this.nestedScrollingChildRef.get()) goto L5;
    L9:
        return false;
    L5:
        if (this.state == 3) goto L7;
    L8:
        return true;
    L7:
        if (super.onNestedPreFling(r100, r101, r102, r103, r104) == false) goto L9;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((r104 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int[] r105, int r106) {
        if (r106 != 1) goto L6;
        return;
    L6:
        if (r102 == this.nestedScrollingChildRef.get()) goto L8;
        return;
    L8:
        int r107 = r101.getTop();
        int r108 = r107 - r104;
        if (r104 > 0) goto L11;
        if (r104 < 0) goto L16;
    L24:
        dispatchOnSlide(r101.getTop());
        this.lastNestedScrollDy = r104;
        this.nestedScrolled = true;
        return;
    L16:
        if (r102.canScrollVertically(-1) == true) goto L24;
        int r109 = this.collapsedOffset;
        if (r108 > r109) goto L20;
    L23:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L24
    L20:
        if (this.hideable == true) goto L23;
        int r110 = r107 - r109;
        r105[1] = r110;
        ViewCompat.offsetTopAndBottom(r101, -r110);
        setStateInternal(4);
        goto L24
    L11:
        if (r108 >= getExpandedOffset()) goto L13;
        int r111 = r107 - getExpandedOffset();
        r105[1] = r111;
        ViewCompat.offsetTopAndBottom(r101, -r111);
        setStateInternal(3);
        goto L24
    L13:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L24
    }
}
