package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
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
import com.bytedance.awemeopen.infra.util.e;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class AosBottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior3";
    int activePointerId;
    private final ArrayList<BottomSheetCallback> callbacks;
    private int childHeight;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    float elevation;
    private int expandHalfwayActionId;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    private MaterialShapeDrawable materialShapeDrawable;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags;
    private AosBottomSheetBehavior<V>.SettleRunnable settleRunnable;
    private boolean shapeThemingEnabled;
    private boolean skipCollapsed;
    int state;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    private VelocityTracker velocityTracker;
    ViewDragHelper viewDragHelper;
    WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        public BottomSheetCallback() {
        }

        public abstract void onSlide(View r100, float r101);

        public abstract void onStateChanged(View r100, int r101);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
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
            this.peekHeight = r100.readInt();
            boolean r102 = false;
            if (r100.readInt() != 1) goto L5;
            boolean r103 = true;
        L6:
            this.fitToContents = r103;
            if (r100.readInt() != 1) goto L9;
            boolean r104 = true;
        L10:
            this.hideable = r104;
            if (r100.readInt() != 1) goto L13;
            r102 = true;
        L13:
            this.skipCollapsed = r102;
            return;
        L9:
            r104 = false;
            goto L10
        L5:
            r103 = false;
            goto L6
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.state);
            r100.writeInt(this.peekHeight);
            r100.writeInt(this.fitToContents ? 1 : 0);
            r100.writeInt(this.hideable ? 1 : 0);
            r100.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(Parcelable r100, AosBottomSheetBehavior<?> r101) {
            super(r100);
            this.state = r101.state;
            this.peekHeight = AosBottomSheetBehavior.access$600(r101);
            this.fitToContents = AosBottomSheetBehavior.access$500(r101);
            this.hideable = r101.hideable;
            this.skipCollapsed = AosBottomSheetBehavior.access$700(r101);
        }

        public SavedState(Parcelable r100, int r101) {
            super(r100);
            this.state = r101;
        }
    }

    public class SettleRunnable implements Runnable {
        private boolean isPosted;
        int targetState;
        final /* synthetic */ AosBottomSheetBehavior this$0;
        private final View view;

        @Override // java.lang.Runnable
        public void run() {
            com_google_android_material_internal_AosBottomSheetBehavior$SettleRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_google_android_material_internal_AosBottomSheetBehavior$SettleRunnable__run$___twin___() {
            ViewDragHelper r100 = this.this$0.viewDragHelper;
            if (r100 != null) goto L5;
        L7:
            this.this$0.setStateInternal(this.targetState);
        L8:
            this.isPosted = false;
            return;
        L5:
            if (r100.continueSettling(true) == false) goto L7;
            ViewCompat.postOnAnimation(this.view, this);
            goto L8
        }

        public static /* synthetic */ boolean access$300(SettleRunnable r100) {
            return r100.isPosted;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_google_android_material_internal_AosBottomSheetBehavior$SettleRunnable_com_larus_apm_impl_protector_RunnableLancet_run(SettleRunnable r100) {
            r100.com_google_android_material_internal_AosBottomSheetBehavior$SettleRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public static /* synthetic */ boolean access$302(SettleRunnable r100, boolean r101) {
            r100.isPosted = r101;
            return r101;
        }

        public SettleRunnable(AosBottomSheetBehavior r100, View r101, int r102) {
            this.this$0 = r100;
            this.view = r101;
            this.targetState = r102;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    private void createMaterialShapeDrawable(Context r100, AttributeSet r101, boolean r102, ColorStateList r103) {
    }

    private void createShapeValueAnimator() {
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.interpolatorAnimator = r100;
        r100.setDuration(500);
        this.interpolatorAnimator.addUpdateListener(new AnonymousClass2(this));
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker r100 = this.velocityTracker;
        if (r100 == null) goto L6;
        r100.recycle();
        this.velocityTracker = null;
        return;
    }

    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int r105, int r106, int r107, int[] r108) {
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private int calculatePeekHeight() {
        if (this.peekHeightAuto == false) goto L7;
        return Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight);
    L7:
        if (this.gestureInsetBottomIgnored == true) goto L13;
        int r100 = this.gestureInsetBottom;
        if (r100 <= 0) goto L13;
        return Math.max(this.peekHeight, r100 + this.peekHeightGestureInsetBuffer);
    L13:
        return this.peekHeight;
    }

    private float getYVelocity() {
        VelocityTracker r100 = this.velocityTracker;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        r100.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    public int getExpandedOffset() {
        if (this.fitToContents == false) goto L6;
        return this.fitToContentsOffset;
    L6:
        return this.expandedOffset;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto == false) goto L6;
        return -1;
    L6:
        return this.peekHeight;
    }

    public AosBottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new AnonymousClass5(this);
    }

    private void calculateCollapsedOffset() {
        int r100 = calculatePeekHeight();
        if (this.fitToContents == false) goto L5;
        this.collapsedOffset = Math.max(this.parentHeight - r100, this.fitToContentsOffset);
        return;
    L5:
        this.collapsedOffset = this.parentHeight - r100;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public static /* synthetic */ MaterialShapeDrawable access$000(AosBottomSheetBehavior r100) {
        return r100.materialShapeDrawable;
    }

    public static /* synthetic */ boolean access$400(AosBottomSheetBehavior r100) {
        return r100.draggable;
    }

    public static /* synthetic */ boolean access$500(AosBottomSheetBehavior r100) {
        return r100.fitToContents;
    }

    public static /* synthetic */ int access$600(AosBottomSheetBehavior r100) {
        return r100.peekHeight;
    }

    public static /* synthetic */ boolean access$700(AosBottomSheetBehavior r100) {
        return r100.skipCollapsed;
    }

    public static <V extends View> AosBottomSheetBehavior<V> from(V r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r102 = ((CoordinatorLayout.LayoutParams) r101).getBehavior();
        if ((r102 instanceof AosBottomSheetBehavior) == false) goto L9;
        return (AosBottomSheetBehavior) r102;
    L9:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior3");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public static void requestApplyInsetsWhenAttached(View r100) {
        if (ViewCompat.isAttachedToWindow(r100) == false) goto L5;
        ViewCompat.requestApplyInsets(r100);
        return;
    L5:
        r100.addOnAttachStateChangeListener(new AnonymousClass4());
    }

    private void restoreOptionalState(SavedState r100) {
        int r101 = this.saveFlags;
        if (r101 != 0) goto L6;
        return;
    L6:
        if (r101 != (-1)) goto L8;
    L9:
        this.peekHeight = r100.peekHeight;
    L10:
        if (r101 != (-1)) goto L12;
    L13:
        this.fitToContents = r100.fitToContents;
    L14:
        if (r101 != (-1)) goto L16;
    L17:
        this.hideable = r100.hideable;
    L18:
        if (r101 != (-1)) goto L20;
    L21:
        this.skipCollapsed = r100.skipCollapsed;
        return;
    L20:
        if ((r101 & 8) == 8) goto L21;
        return;
    L16:
        if ((r101 & 4) != 4) goto L18;
    L12:
        if ((r101 & 2) != 2) goto L14;
    L8:
        if ((r101 & 1) != 1) goto L10;
        goto L9
    }

    private void setSystemGestureInsets(View r100) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return;
    L5:
        if (isGestureInsetBottomIgnored() == false) goto L7;
        return;
    L7:
        if (this.peekHeightAuto == true) goto L12;
        ViewCompat.setOnApplyWindowInsetsListener(r100, new AnonymousClass3(this));
        requestApplyInsetsWhenAttached(r100);
        return;
    }

    private void settleToStatePendingLayout(final int r100) {
        final V r101 = this.viewRef.get();
        if (r101 != null) goto L5;
        return;
    L5:
        ViewParent r102 = r101.getParent();
        if (r102 != null) goto L8;
    L12:
        settleToState(r101, r100);
        return;
    L8:
        if (r102.isLayoutRequested() == false) goto L12;
        if (ViewCompat.isAttachedToWindow(r101) == false) goto L12;
        r101.post(new AnonymousClass1(this, r101, r100));
    }

    private void updateDrawableForTargetState(int r100) {
        if (r100 != 2) goto L6;
        return;
    L6:
        if (r100 != 3) goto L8;
        boolean r101 = true;
    L10:
        if (this.isShapeExpanded == r101) goto L24;
        this.isShapeExpanded = r101;
        if (this.materialShapeDrawable == null) goto L25;
        ValueAnimator r102 = this.interpolatorAnimator;
        if (r102 != null) goto L16;
        return;
    L16:
        if (r102.isRunning() == false) goto L19;
        this.interpolatorAnimator.reverse();
        return;
    L19:
        if (r101 == false) goto L21;
        float r103 = 0.0f;
    L22:
        this.interpolatorAnimator.setFloatValues(new float[]{1.0f - r103, r103});
        this.interpolatorAnimator.start();
        return;
    L21:
        r103 = 1.0f;
        goto L22
    L25:
        return;
    L24:
        return;
    L8:
        r101 = false;
        goto L10
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
        if (r105 >= r104) goto L31;
        View r106 = r103.getChildAt(r105);
        if (r106 == this.viewRef.get()) goto L30;
        if (r100 == false) goto L24;
        this.importantForAccessibilityMap.put(r106, Integer.valueOf(r106.getImportantForAccessibility()));
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L30;
        ViewCompat.setImportantForAccessibility(r106, 4);
        goto L30
    L24:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L30;
        Map<View, Integer> r107 = this.importantForAccessibilityMap;
        if (r107 == null) goto L30;
        if (r107.containsKey(r106) == false) goto L30;
        ViewCompat.setImportantForAccessibility(r106, this.importantForAccessibilityMap.get(r106).intValue());
    L30:
        r105 = r105 + 1;
        goto L15
    L31:
        if (r100 == true) goto L34;
        this.importantForAccessibilityMap = null;
        return;
    L34:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L46;
        this.viewRef.get().sendAccessibilityEvent(8);
        return;
    L46:
        return;
    L11:
        if (this.importantForAccessibilityMap != null) goto L13;
        this.importantForAccessibilityMap = new HashMap(r104);
        goto L14
    }

    private void updatePeekHeight(boolean r100) {
        if (this.viewRef == null) goto L12;
        calculateCollapsedOffset();
        if (this.state != 4) goto L13;
        V r101 = this.viewRef.get();
        if (r101 == null) goto L14;
        if (r100 == false) goto L10;
        settleToStatePendingLayout(this.state);
        return;
    L10:
        r101.requestLayout();
        return;
    L14:
        return;
    L13:
        return;
    }

    public void addBottomSheetCallback(BottomSheetCallback r100) {
        if (this.callbacks.contains(r100) == true) goto L6;
        this.callbacks.add(r100);
        return;
    }

    public void dispatchOnSlide(int r100) {
        V r101 = this.viewRef.get();
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.callbacks.isEmpty() == true) goto L19;
        int r102 = this.collapsedOffset;
        if (r100 <= r102) goto L9;
    L12:
        int r103 = this.collapsedOffset;
        float r104 = r103 - r100;
        float r105 = this.parentHeight - r103;
    L13:
        float r106 = r104 / r105;
        int r107 = 0;
    L15:
        if (r107 >= this.callbacks.size()) goto L20;
        ((BottomSheetCallback) ListProtector.get(this.callbacks, r107)).onSlide(r101, r106);
        r107 = r107 + 1;
        goto L15
    L20:
        return;
    L9:
        if (r102 == getExpandedOffset()) goto L12;
        int r108 = this.collapsedOffset;
        r104 = r108 - r100;
        r105 = r108 - getExpandedOffset();
        goto L13
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

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r100) {
        super.onAttachedToLayoutParams(r100);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    public void removeBottomSheetCallback(BottomSheetCallback r100) {
        this.callbacks.remove(r100);
    }

    public void setBottomSheetCallback(BottomSheetCallback r100) {
        this.callbacks.clear();
        if (r100 == null) goto L6;
        this.callbacks.add(r100);
        return;
    }

    public void setDraggable(boolean r100) {
        this.draggable = r100;
    }

    public void setExpandedOffset(int r100) {
        if (r100 < 0) goto L6;
        this.expandedOffset = r100;
        return;
    L6:
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
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

    public void setGestureInsetBottomIgnored(boolean r100) {
        this.gestureInsetBottomIgnored = r100;
    }

    public void setHalfExpandedRatio(float r100) {
        if (r100 <= 0.0f) goto L11;
        if (r100 >= 1.0f) goto L11;
        this.halfExpandedRatio = r100;
        if (this.viewRef == null) goto L12;
        calculateHalfExpandedOffset();
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void setHideable(boolean r100) {
        if (this.hideable == r100) goto L10;
        this.hideable = r100;
        if (r100 == false) goto L7;
        return;
    L7:
        if (this.state != 5) goto L12;
        setState(4);
        return;
    L12:
        return;
    }

    public void setPeekHeight(int r100) {
        setPeekHeight(r100, false);
    }

    public void setSaveFlags(int r100) {
        this.saveFlags = r100;
    }

    public void setSkipCollapsed(boolean r100) {
        this.skipCollapsed = r100;
    }

    public void setState(int r100) {
        if (r100 != this.state) goto L6;
        return;
    L6:
        if (this.viewRef == null) goto L8;
        settleToStatePendingLayout(r100);
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
        WeakReference<V> r101 = this.viewRef;
        if (r101 != null) goto L8;
        return;
    L8:
        V r102 = r101.get();
        if (r102 != null) goto L11;
        return;
    L11:
        int r103 = 0;
        if (r100 != 3) goto L15;
        updateImportantForAccessibility(true);
    L21:
        updateDrawableForTargetState(r100);
    L23:
        if (r103 >= this.callbacks.size()) goto L25;
        ((BottomSheetCallback) ListProtector.get(this.callbacks, r103)).onStateChanged(r102, r100);
        r103 = r103 + 1;
        goto L23
    L25:
        return;
    L15:
        if (r100 != 6) goto L17;
    L20:
        updateImportantForAccessibility(false);
        goto L21
    L17:
        if (r100 == 5) goto L20;
        if (r100 != 4) goto L21;
        goto L20
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean r100) {
        this.updateImportantForAccessibilityOnSiblings = r100;
    }

    public AosBottomSheetBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new AnonymousClass5(this);
        this.peekHeightGestureInsetBuffer = e.a(r100, 48.0f);
        this.shapeThemingEnabled = false;
        createShapeValueAnimator();
        setPeekHeight(-1);
        this.maximumVelocity = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
    }

    public static /* synthetic */ int access$102(AosBottomSheetBehavior r100, int r101) {
        r100.gestureInsetBottom = r101;
        return r101;
    }

    public static /* synthetic */ void access$200(AosBottomSheetBehavior r100, boolean r101) {
        r100.updatePeekHeight(r101);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
        return new SavedState(super.onSaveInstanceState(r100, r101), this);
    }

    public final void setPeekHeight(int r100, boolean r101) {
        boolean r102 = true;
        if (r100 != (-1)) goto L8;
        if (this.peekHeightAuto == true) goto L12;
        this.peekHeightAuto = true;
    L14:
        if (r102 == false) goto L17;
        updatePeekHeight(r101);
        return;
    L17:
        return;
    L12:
        r102 = false;
        goto L14
    L8:
        if (this.peekHeightAuto == false) goto L10;
    L13:
        this.peekHeightAuto = false;
        this.peekHeight = Math.max(0, r100);
        goto L14
    L10:
        if (this.peekHeight == r100) goto L12;
        goto L12
    }

    public void settleToState(View r100, int r101) {
        if (r101 != 4) goto L6;
        int r102 = this.collapsedOffset;
    L19:
        startSettlingAnimation(r100, r101, r102, false);
        return;
    L6:
        if (r101 != 6) goto L12;
        r102 = this.halfExpandedOffset;
        if (this.fitToContents == false) goto L19;
        int r103 = this.fitToContentsOffset;
        if (r102 > r103) goto L19;
        r102 = r103;
        r101 = 3;
        goto L19
    L12:
        if (r101 != 3) goto L15;
        r102 = getExpandedOffset();
        goto L19
    L15:
        if (this.hideable == false) goto L22;
        if (r101 != 5) goto L22;
        r102 = this.parentHeight;
    L22:
        throw new IllegalArgumentException("Illegal state argument: " + r101);
    }

    public boolean shouldHide(View r100, float r101) {
        if (this.skipCollapsed == false) goto L6;
        return true;
    L6:
        if (r100.getTop() >= this.collapsedOffset) goto L9;
        return false;
    L9:
        if ((Math.abs((r100.getTop() + (r101 * 0.1f)) - this.collapsedOffset) / calculatePeekHeight()) > 0.5f) goto L13;
        return false;
    L13:
        return true;
    }

    private void createMaterialShapeDrawable(Context r100, AttributeSet r101, boolean r102) {
        createMaterialShapeDrawable(r100, r101, r102, null);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r110, V r111, MotionEvent r112) {
        if (r111.isShown() == true) goto L5;
    L64:
        this.ignoreEvents = true;
        return false;
    L5:
        if (this.draggable == false) goto L64;
        int r100 = r112.getActionMasked();
        if (r100 != 0) goto L11;
        reset();
    L11:
        if (this.velocityTracker != null) goto L13;
        this.velocityTracker = VelocityTracker.obtain();
    L13:
        this.velocityTracker.addMovement(r112);
        View r101 = null;
        if (r100 == 0) goto L23;
        if (r100 != 1) goto L17;
    L19:
        this.touchingScrollingChild = false;
        this.activePointerId = -1;
        if (this.ignoreEvents == false) goto L41;
        this.ignoreEvents = false;
        return false;
    L41:
        if (this.ignoreEvents == true) goto L47;
        ViewDragHelper r113 = this.viewDragHelper;
        if (r113 == null) goto L47;
        if (r113.shouldInterceptTouchEvent(r112) == false) goto L47;
        return true;
    L47:
        WeakReference<View> r114 = this.nestedScrollingChildRef;
        if (r114 == null) goto L50;
        r101 = r114.get();
    L50:
        if (r100 != 2) goto L66;
        if (r101 != null) goto L53;
        return false;
    L53:
        if (this.ignoreEvents == false) goto L55;
        return false;
    L55:
        if (this.state != 1) goto L57;
        return false;
    L57:
        if (r110.isPointInChildBounds(r101, (int) r112.getX(), (int) r112.getY()) == false) goto L59;
        return false;
    L59:
        if (this.viewDragHelper != null) goto L61;
        return false;
    L61:
        if (Math.abs(this.initialY - r112.getY()) <= this.viewDragHelper.getTouchSlop()) goto L72;
        return true;
    L72:
        return false;
    L66:
        return false;
    L17:
        if (r100 == 3) goto L19;
    L23:
        int r102 = (int) r112.getX();
        this.initialY = (int) r112.getY();
        if (this.state == 2) goto L34;
        WeakReference<View> r103 = this.nestedScrollingChildRef;
        if (r103 == null) goto L28;
        View r104 = r103.get();
    L29:
        if (r104 == null) goto L34;
        if (r110.isPointInChildBounds(r104, r102, this.initialY) == false) goto L34;
        this.activePointerId = r112.getPointerId(r112.getActionIndex());
        this.touchingScrollingChild = true;
        goto L34
    L28:
        r104 = null;
    L34:
        if (this.activePointerId == (-1)) goto L36;
    L38:
        boolean r115 = false;
    L39:
        this.ignoreEvents = r115;
        goto L41
    L36:
        if (r110.isPointInChildBounds(r111, r102, this.initialY) == true) goto L38;
        r115 = true;
        goto L39
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        if (ViewCompat.getFitsSystemWindows(r100) == false) goto L8;
        if (ViewCompat.getFitsSystemWindows(r101) == true) goto L8;
        r101.setFitsSystemWindows(true);
    L8:
        if (this.viewRef != null) goto L29;
        this.peekHeightMin = e.a(r101.getContext(), 60.0f);
        setSystemGestureInsets(r101);
        this.viewRef = new WeakReference(r101);
        if (this.shapeThemingEnabled == false) goto L14;
        MaterialShapeDrawable r103 = this.materialShapeDrawable;
        if (r103 == null) goto L14;
        ViewCompat.setBackground(r101, r103);
    L14:
        MaterialShapeDrawable r104 = this.materialShapeDrawable;
        if (r104 == null) goto L26;
        if (this.state != 3) goto L19;
        boolean r105 = true;
    L20:
        this.isShapeExpanded = r105;
        if (r105 == false) goto L23;
        float r106 = 0.0f;
    L24:
        r104.setInterpolation(r106);
        goto L26
    L23:
        r106 = 1.0f;
        goto L24
    L19:
        r105 = false;
    L26:
        if (ViewCompat.getImportantForAccessibility(r101) != 0) goto L29;
        ViewCompat.setImportantForAccessibility(r101, 1);
    L29:
        if (this.viewDragHelper != null) goto L31;
        this.viewDragHelper = ViewDragHelper.create(r100, this.dragCallback);
    L31:
        int r107 = r101.getTop();
        r100.onLayoutChild(r101, r102);
        this.parentWidth = r100.getWidth();
        this.parentHeight = r100.getHeight();
        int r108 = r101.getHeight();
        this.childHeight = r108;
        this.fitToContentsOffset = Math.max(0, this.parentHeight - r108);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int r109 = this.state;
        if (r109 != 3) goto L35;
        ViewCompat.offsetTopAndBottom(r101, getExpandedOffset());
    L49:
        this.nestedScrollingChildRef = new WeakReference(findScrollingChild(r101));
        return true;
    L35:
        if (r109 != 6) goto L38;
        ViewCompat.offsetTopAndBottom(r101, this.halfExpandedOffset);
        goto L49
    L38:
        if (this.hideable == false) goto L43;
        if (r109 != 5) goto L43;
        ViewCompat.offsetTopAndBottom(r101, this.parentHeight);
    L43:
        if (r109 != 4) goto L45;
        ViewCompat.offsetTopAndBottom(r101, this.collapsedOffset);
        goto L49
    L45:
        if (r109 != 1) goto L47;
    L48:
        ViewCompat.offsetTopAndBottom(r101, r107 - r101.getTop());
        goto L49
    L47:
        if (r109 != 2) goto L49;
        goto L48
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout r100, V r101, Parcelable r102) {
        SavedState r103 = (SavedState) r102;
        super.onRestoreInstanceState(r100, r101, r103.getSuperState());
        restoreOptionalState(r103);
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
        if (this.viewDragHelper == null) goto L28;
        if (r103 != 2) goto L28;
        if (this.ignoreEvents == true) goto L28;
        if (Math.abs(this.initialY - r102.getY()) <= this.viewDragHelper.getTouchSlop()) goto L28;
        this.viewDragHelper.captureChildView(r101, r102.getPointerId(r102.getActionIndex()));
    L28:
        return !this.ignoreEvents;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
        int r104 = 3;
        if (r101.getTop() != getExpandedOffset()) goto L6;
        setStateInternal(3);
        return;
    L6:
        WeakReference<View> r105 = this.nestedScrollingChildRef;
        if (r105 != null) goto L9;
        return;
    L9:
        if (r102 == r105.get()) goto L11;
        return;
    L11:
        if (this.nestedScrolled == true) goto L14;
        return;
    L14:
        if (this.lastNestedScrollDy <= 0) goto L23;
        if (this.fitToContents == false) goto L18;
        int r106 = this.fitToContentsOffset;
    L54:
        startSettlingAnimation(r101, r104, r106, false);
        this.nestedScrolled = false;
        return;
    L18:
        int r107 = r101.getTop();
        int r108 = this.halfExpandedOffset;
        if (r107 <= r108) goto L21;
        r106 = r108;
    L52:
        r104 = 6;
        goto L54
    L21:
        r106 = this.expandedOffset;
        goto L54
    L23:
        if (this.hideable == false) goto L28;
        if (shouldHide(r101, getYVelocity()) == false) goto L28;
        r106 = this.parentHeight;
        r104 = 5;
    L28:
        if (this.lastNestedScrollDy != 0) goto L46;
        int r109 = r101.getTop();
        if (this.fitToContents == true) goto L32;
        int r110 = this.halfExpandedOffset;
        if (r109 >= r110) goto L42;
        if (r109 >= Math.abs(r109 - this.collapsedOffset)) goto L40;
        r106 = this.expandedOffset;
        goto L54
    L40:
        r106 = this.halfExpandedOffset;
        goto L52
    L42:
        if (Math.abs(r109 - r110) >= Math.abs(r109 - this.collapsedOffset)) goto L44;
        r106 = this.halfExpandedOffset;
        goto L52
    L44:
        r106 = this.collapsedOffset;
    L48:
        r104 = 4;
        goto L54
    L32:
        if (Math.abs(r109 - this.fitToContentsOffset) >= Math.abs(r109 - this.collapsedOffset)) goto L34;
        r106 = this.fitToContentsOffset;
        goto L54
    L34:
        r106 = this.collapsedOffset;
        goto L48
    L46:
        if (this.fitToContents == false) goto L49;
        r106 = this.collapsedOffset;
        goto L48
    L49:
        int r111 = r101.getTop();
        if (Math.abs(r111 - this.halfExpandedOffset) >= Math.abs(r111 - this.collapsedOffset)) goto L53;
        r106 = this.halfExpandedOffset;
        goto L52
    L53:
        r106 = this.collapsedOffset;
        goto L48
    }

    public void startSettlingAnimation(View r100, int r101, int r102, boolean r103) {
        ViewDragHelper r104 = this.viewDragHelper;
        if (r104 == null) goto L11;
        if (r103 == false) goto L9;
        if (r104.settleCapturedViewAt(r100.getLeft(), r102) == false) goto L11;
    L10:
        boolean r105 = true;
    L12:
        if (r105 == false) goto L20;
        setStateInternal(2);
        updateDrawableForTargetState(r101);
        if (this.settleRunnable != null) goto L17;
        this.settleRunnable = new SettleRunnable(this, r100, r101);
    L17:
        if (SettleRunnable.access$300(this.settleRunnable) == true) goto L19;
        AosBottomSheetBehavior<V>.SettleRunnable r106 = this.settleRunnable;
        r106.targetState = r101;
        ViewCompat.postOnAnimation(r100, r106);
        SettleRunnable.access$302(this.settleRunnable, true);
        return;
    L19:
        this.settleRunnable.targetState = r101;
        return;
    L20:
        setStateInternal(r101);
        return;
    L9:
        if (r104.smoothSlideViewTo(r100, r100.getLeft(), r102) == true) goto L10;
    L11:
        r105 = false;
        goto L12
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        WeakReference<View> r105 = this.nestedScrollingChildRef;
        if (r105 != null) goto L5;
        return false;
    L5:
        if (r102 == r105.get()) goto L7;
        return false;
    L7:
        if (this.state == 3) goto L9;
    L10:
        return true;
    L9:
        if (super.onNestedPreFling(r100, r101, r102, r103, r104) == true) goto L10;
        return false;
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
        if (r106 != 1) goto L5;
        return;
    L5:
        WeakReference<View> r107 = this.nestedScrollingChildRef;
        if (r107 == null) goto L8;
        View r108 = r107.get();
    L9:
        if (r102 == r108) goto L11;
        return;
    L11:
        int r109 = r101.getTop();
        int r110 = r109 - r104;
        if (r104 > 0) goto L14;
        if (r104 < 0) goto L22;
    L33:
        dispatchOnSlide(r101.getTop());
        this.lastNestedScrollDy = r104;
        this.nestedScrolled = true;
        return;
    L22:
        if (r102.canScrollVertically(-1) == true) goto L33;
        int r111 = this.collapsedOffset;
        if (r110 <= r111) goto L30;
        if (this.hideable == true) goto L30;
        int r112 = r109 - r111;
        r105[1] = r112;
        ViewCompat.offsetTopAndBottom(r101, -r112);
        setStateInternal(4);
    L30:
        if (this.draggable == true) goto L32;
        return;
    L32:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L33
    L14:
        if (r110 >= getExpandedOffset()) goto L17;
        int r113 = r109 - getExpandedOffset();
        r105[1] = r113;
        ViewCompat.offsetTopAndBottom(r101, -r113);
        setStateInternal(3);
        goto L33
    L17:
        if (this.draggable == true) goto L19;
        return;
    L19:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L33
    L8:
        r108 = null;
        goto L9
    }
}
