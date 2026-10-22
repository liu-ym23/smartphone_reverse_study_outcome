package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class AppBarLayout extends LinearLayout {
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private int downPreScrollRange;
    private int downScrollRange;
    private boolean haveChildWithInterpolator;
    private WindowInsetsCompat lastInsets;
    private boolean liftOnScroll;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List<BaseOnOffsetChangedListener> listeners;
    private int pendingAction;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final int INVALID_POSITION = -1;
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        private WeakReference<View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private ValueAnimator offsetAnimator;
        private int offsetDelta;
        private int offsetToChildIndexOnLayout;
        private boolean offsetToChildIndexOnLayoutIsMinHeight;
        private float offsetToChildIndexOnLayoutPerc;
        private BaseDragCallback onDragCallback;

        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public BaseDragCallback() {
            }

            public abstract boolean canDrag(T r100);
        }

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = null;
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;

            static {
                CREATOR = new AnonymousClass1();
            }

            public SavedState(Parcelable r100) {
                super(r100);
            }

            public SavedState(Parcel r100, ClassLoader r101) {
                super(r100, r101);
                this.firstVisibleChildIndex = r100.readInt();
                this.firstVisibleChildPercentageShown = r100.readFloat();
                if (r100.readByte() == 0) goto L5;
                boolean r102 = true;
            L6:
                this.firstVisibleChildAtMinimumHeight = r102;
                return;
            L5:
                r102 = false;
                goto L6
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel r100, int r101) {
                super.writeToParcel(r100, r101);
                r100.writeInt(this.firstVisibleChildIndex);
                r100.writeFloat(this.firstVisibleChildPercentageShown);
                r100.writeByte(this.firstVisibleChildAtMinimumHeight ? 1 : 0);
            }
        }

        private static boolean checkFlag(int r100, int r101) {
            if ((r100 & r101) != r101) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isOffsetAnimatorRunning() {
            ValueAnimator r100 = this.offsetAnimator;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.isRunning() == false) goto L7;
            return true;
        }

        public BaseBehavior() {
            this.offsetToChildIndexOnLayout = -1;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        public static /* synthetic */ int access$000(BaseBehavior r100) {
            return r100.offsetDelta;
        }

        private View findFirstScrollingChild(CoordinatorLayout r100) {
            int r101 = r100.getChildCount();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L8;
            View r103 = r100.getChildAt(r102);
            if ((r103 instanceof NestedScrollingChild) == true) goto L6;
            r102 = r102 + 1;
            goto L3
        L6:
            return r103;
        L8:
            return null;
        }

        public boolean canDragView(T r100) {
            BaseDragCallback r101 = this.onDragCallback;
            if (r101 != null) goto L5;
            WeakReference<View> r102 = this.lastNestedScrollingChildRef;
            if (r102 == null) goto L17;
            View r103 = r102.get();
            if (r103 != null) goto L11;
        L15:
            return false;
        L11:
            if (r103.isShown() == false) goto L15;
            if (r103.canScrollVertically(-1) == true) goto L15;
            return true;
        L17:
            return true;
        L5:
            return r101.canDrag(r100);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ int getMaxDragOffset(View r100) {
            return getMaxDragOffset((AppBarLayout) r100);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(View r100) {
            return getScrollRangeForDragFling((AppBarLayout) r100);
        }

        public void setDragCallback(BaseDragCallback r100) {
            this.onDragCallback = r100;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean canDragView(View r100) {
            return canDragView((AppBarLayout) r100);
        }

        public int getMaxDragOffset(T r100) {
            return -r100.getDownNestedScrollRange();
        }

        public int getScrollRangeForDragFling(T r100) {
            return r100.getTotalScrollRange();
        }

        public BaseBehavior(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.offsetToChildIndexOnLayout = -1;
        }

        private static View getAppBarChildOnOffset(AppBarLayout r100, int r101) {
            int r102 = Math.abs(r101);
            int r103 = r100.getChildCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L10;
            View r105 = r100.getChildAt(r104);
            if (r102 < r105.getTop()) goto L9;
            if (r102 > r105.getBottom()) goto L9;
            return r105;
        L9:
            r104 = r104 + 1;
            goto L3
        L10:
            return null;
        }

        private int getChildIndexOnOffset(T r100, int r101) {
            int r102 = r100.getChildCount();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L12;
            View r104 = r100.getChildAt(r103);
            int r105 = r104.getTop();
            int r106 = r104.getBottom();
            LayoutParams r107 = (LayoutParams) r104.getLayoutParams();
            if (checkFlag(r107.getScrollFlags(), 32) == false) goto L7;
            r105 = r105 - ((LinearLayout.LayoutParams) r107).topMargin;
            r106 = r106 + ((LinearLayout.LayoutParams) r107).bottomMargin;
        L7:
            int r108 = -r101;
            if (r105 > r108) goto L11;
            if (r106 < r108) goto L11;
            return r103;
        L11:
            r103 = r103 + 1;
            goto L3
        L12:
            return -1;
        }

        private int interpolateOffset(T r100, int r110) {
            int r101 = Math.abs(r110);
            int r102 = r100.getChildCount();
            int r103 = 0;
            int r104 = 0;
        L3:
            if (r104 >= r102) goto L21;
            View r105 = r100.getChildAt(r104);
            LayoutParams r106 = (LayoutParams) r105.getLayoutParams();
            Interpolator r107 = r106.getScrollInterpolator();
            if (r101 < r105.getTop()) goto L20;
            if (r101 > r105.getBottom()) goto L20;
            if (r107 == null) goto L21;
            int r108 = r106.getScrollFlags();
            if ((r108 & 1) == 0) goto L15;
            r103 = 0 + ((r105.getHeight() + ((LinearLayout.LayoutParams) r106).topMargin) + ((LinearLayout.LayoutParams) r106).bottomMargin);
            if ((r108 & 2) == 0) goto L15;
            r103 = r103 - ViewCompat.getMinimumHeight(r105);
        L15:
            if (ViewCompat.getFitsSystemWindows(r105) == false) goto L17;
            r103 = r103 - r100.getTopInset();
        L17:
            if (r103 <= 0) goto L21;
            float r109 = r103;
            return Integer.signum(r110) * (r105.getTop() + Math.round(r109 * r107.getInterpolation((r101 - r105.getTop()) / r109)));
        L20:
            r104 = r104 + 1;
        L21:
            return r110;
        }

        private boolean shouldJumpElevationState(CoordinatorLayout r100, T r101) {
            List<View> r102 = r100.getDependents(r101);
            int r103 = r102.size();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L11;
            CoordinatorLayout.Behavior r105 = ((CoordinatorLayout.LayoutParams) ((View) ListProtector.get(r102, r104)).getLayoutParams()).getBehavior();
            if ((r105 instanceof ScrollingViewBehavior) == true) goto L7;
            r104 = r104 + 1;
            goto L3
        L7:
            if (((ScrollingViewBehavior) r105).getOverlayTop() == 0) goto L14;
            return true;
        L14:
            return false;
        L11:
            return false;
        }

        private void snapToChildIfNeeded(CoordinatorLayout r100, T r110) {
            int r101 = getTopBottomOffsetForScrollingSibling();
            int r102 = getChildIndexOnOffset(r110, r101);
            if (r102 < 0) goto L26;
            View r103 = r110.getChildAt(r102);
            LayoutParams r104 = (LayoutParams) r103.getLayoutParams();
            int r105 = r104.getScrollFlags();
            if ((r105 & 17) != 17) goto L27;
            int r106 = -r103.getTop();
            int r107 = -r103.getBottom();
            if (r102 != (r110.getChildCount() - 1)) goto L10;
            r107 = r107 + r110.getTopInset();
        L10:
            if (checkFlag(r105, 2) == false) goto L13;
            r107 = r107 + ViewCompat.getMinimumHeight(r103);
        L19:
            if (checkFlag(r105, 32) == false) goto L22;
            r106 = r106 + ((LinearLayout.LayoutParams) r104).topMargin;
            r107 = r107 - ((LinearLayout.LayoutParams) r104).bottomMargin;
        L22:
            if (r101 >= ((r107 + r106) / 2)) goto L24;
            r106 = r107;
        L24:
            animateOffsetTo(r100, r110, MathUtils.clamp(r106, -r110.getTotalScrollRange(), 0), 0.0f);
            return;
        L13:
            if (checkFlag(r105, 5) == false) goto L19;
            int r108 = ViewCompat.getMinimumHeight(r103) + r107;
            if (r101 >= r108) goto L17;
            r106 = r108;
            goto L19
        L17:
            r107 = r108;
            goto L19
        L27:
            return;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ void onFlingFinished(CoordinatorLayout r100, View r101) {
            onFlingFinished(r100, (AppBarLayout) r101);
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout r100, T r101) {
            Parcelable r102 = super.onSaveInstanceState(r100, r101);
            int r103 = getTopAndBottomOffset();
            int r104 = r101.getChildCount();
            boolean r105 = false;
            int r106 = 0;
        L3:
            if (r106 >= r104) goto L13;
            View r107 = r101.getChildAt(r106);
            int r108 = r107.getBottom() + r103;
            if ((r107.getTop() + r103) > 0) goto L12;
            if (r108 < 0) goto L12;
            SavedState r109 = new SavedState(r102);
            r109.firstVisibleChildIndex = r106;
            if (r108 != (ViewCompat.getMinimumHeight(r107) + r101.getTopInset())) goto L10;
            r105 = true;
        L10:
            r109.firstVisibleChildAtMinimumHeight = r105;
            r109.firstVisibleChildPercentageShown = r108 / r107.getHeight();
            return r109;
        L12:
            r106 = r106 + 1;
            goto L3
        L13:
            return r102;
        }

        public void onFlingFinished(CoordinatorLayout r100, T r101) {
            snapToChildIfNeeded(r100, r101);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r100, View r101) {
            return onSaveInstanceState(r100, (AppBarLayout) r101);
        }

        private boolean canScrollChildren(CoordinatorLayout r100, T r101, View r102) {
            if (r101.hasScrollableChildren() == true) goto L5;
        L7:
            return false;
        L5:
            if ((r100.getHeight() - r102.getHeight()) > r101.getHeight()) goto L7;
            return true;
        }

        public boolean onLayoutChild(CoordinatorLayout r100, T r101, int r110) {
            boolean r111 = super.onLayoutChild(r100, r101, r110);
            int r102 = r101.getPendingAction();
            int r103 = this.offsetToChildIndexOnLayout;
            if (r103 >= 0) goto L5;
        L11:
            if (r102 != 0) goto L13;
        L27:
            r101.resetPendingAction();
            this.offsetToChildIndexOnLayout = -1;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -r101.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(r100, r101, getTopAndBottomOffset(), 0, true);
            r101.dispatchOffsetUpdates(getTopAndBottomOffset());
            return r111;
        L13:
            if ((r102 & 4) == 0) goto L15;
            boolean r104 = true;
        L17:
            if ((r102 & 2) == 0) goto L23;
            int r105 = -r101.getUpNestedPreScrollRange();
            if (r104 == false) goto L21;
            animateOffsetTo(r100, r101, r105, 0.0f);
            goto L27
        L21:
            setHeaderTopBottomOffset(r100, r101, r105);
            goto L27
        L23:
            if ((r102 & 1) == 0) goto L27;
            if (r104 == false) goto L26;
            animateOffsetTo(r100, r101, 0, 0.0f);
            goto L27
        L26:
            setHeaderTopBottomOffset(r100, r101, 0);
            goto L27
        L15:
            r104 = false;
            goto L17
        L5:
            if ((r102 & 8) != 0) goto L11;
            View r106 = r101.getChildAt(r103);
            int r107 = -r106.getBottom();
            if (this.offsetToChildIndexOnLayoutIsMinHeight == false) goto L9;
            int r108 = ViewCompat.getMinimumHeight(r106) + r101.getTopInset();
        L10:
            setHeaderTopBottomOffset(r100, r101, r107 + r108);
            goto L27
        L9:
            r108 = Math.round(r106.getHeight() * this.offsetToChildIndexOnLayoutPerc);
            goto L10
        }

        public void onRestoreInstanceState(CoordinatorLayout r100, T r101, Parcelable r102) {
            if ((r102 instanceof SavedState) == false) goto L5;
            SavedState r103 = (SavedState) r102;
            super.onRestoreInstanceState(r100, r101, r103.getSuperState());
            this.offsetToChildIndexOnLayout = r103.firstVisibleChildIndex;
            this.offsetToChildIndexOnLayoutPerc = r103.firstVisibleChildPercentageShown;
            this.offsetToChildIndexOnLayoutIsMinHeight = r103.firstVisibleChildAtMinimumHeight;
            return;
        L5:
            super.onRestoreInstanceState(r100, r101, r102);
            this.offsetToChildIndexOnLayout = -1;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r100, View r101, int r102) {
            return onLayoutChild(r100, (AppBarLayout) r101, r102);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r100, View r101, Parcelable r102) {
            onRestoreInstanceState(r100, (AppBarLayout) r101, r102);
        }

        private void animateOffsetTo(CoordinatorLayout r100, T r101, int r102, float r103) {
            int r104 = Math.abs(getTopBottomOffsetForScrollingSibling() - r102);
            float r105 = Math.abs(r103);
            if (r105 <= 0.0f) goto L5;
            int r106 = Math.round((r104 / r105) * 1000.0f) * 3;
        L6:
            animateOffsetWithDuration(r100, r101, r102, r106);
            return;
        L5:
            r106 = (int) (((r104 / r101.getHeight()) + 1.0f) * 150.0f);
            goto L6
        }

        private void animateOffsetWithDuration(final CoordinatorLayout r100, final T r101, int r102, int r103) {
            int r104 = getTopBottomOffsetForScrollingSibling();
            if (r104 != r102) goto L10;
            ValueAnimator r105 = this.offsetAnimator;
            if (r105 != null) goto L7;
            return;
        L7:
            if (r105.isRunning() == false) goto L17;
            this.offsetAnimator.cancel();
            return;
        L17:
            return;
        L10:
            ValueAnimator r106 = this.offsetAnimator;
            if (r106 != null) goto L13;
            ValueAnimator r107 = new ValueAnimator();
            this.offsetAnimator = r107;
            r107.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
            this.offsetAnimator.addUpdateListener(new AnonymousClass1(this, r100, r101));
        L14:
            this.offsetAnimator.setDuration(Math.min(r103, 600));
            this.offsetAnimator.setIntValues(new int[]{r104, r102});
            this.offsetAnimator.start();
            return;
        L13:
            r106.cancel();
            goto L14
        }

        private void stopNestedScrollIfNeeded(int r100, T r101, View r102, int r103) {
            if (r103 != 1) goto L12;
            int r104 = getTopBottomOffsetForScrollingSibling();
            if (r100 >= 0) goto L7;
            if (r104 != 0) goto L7;
        L10:
            ViewCompat.stopNestedScroll(r102, 1);
            return;
        L7:
            if (r100 > 0) goto L9;
            return;
        L9:
            if (r104 == (-r101.getDownNestedScrollRange())) goto L10;
            return;
        }

        public void onStopNestedScroll(CoordinatorLayout r100, T r101, View r102, int r103) {
            if (this.lastStartedType != 0) goto L5;
        L6:
            snapToChildIfNeeded(r100, r101);
        L7:
            this.lastNestedScrollingChildRef = new WeakReference(r102);
            return;
        L5:
            if (r103 != 1) goto L7;
            goto L6
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103) {
            onStopNestedScroll(r100, (AppBarLayout) r101, r102, r103);
        }

        private void updateAppBarLayoutDrawableState(CoordinatorLayout r100, T r101, int r102, int r103, boolean r110) {
            View r104 = getAppBarChildOnOffset(r101, r102);
            if (r104 == null) goto L35;
            int r105 = ((LayoutParams) r104.getLayoutParams()).getScrollFlags();
            boolean r106 = true;
            if ((r105 & 1) == 0) goto L18;
            int r107 = ViewCompat.getMinimumHeight(r104);
            if (r103 <= 0) goto L14;
            if ((r105 & 12) == 0) goto L14;
            if ((-r102) < ((r104.getBottom() - r107) - r101.getTopInset())) goto L18;
        L12:
            boolean r108 = true;
        L20:
            if (r101.isLiftOnScroll() == false) goto L28;
            View r109 = findFirstScrollingChild(r100);
            if (r109 == null) goto L28;
            if (r109.getScrollY() > 0) goto L27;
            r106 = false;
        L27:
            r108 = r106;
        L28:
            boolean r111 = r101.setLiftedState(r108);
            if (r110 == true) goto L33;
            if (r111 == true) goto L32;
            return;
        L32:
            if (shouldJumpElevationState(r100, r101) == true) goto L33;
            return;
        L33:
            r101.jumpDrawablesToCurrentState();
            return;
        L14:
            if ((r105 & 2) == 0) goto L18;
            if ((-r102) >= ((r104.getBottom() - r107) - r101.getTopInset())) goto L12;
        L18:
            r108 = false;
            goto L20
        }

        public int setHeaderTopBottomOffset(CoordinatorLayout r100, T r110, int r111, int r112, int r113) {
            int r101 = getTopBottomOffsetForScrollingSibling();
            int r102 = 0;
            if (r112 == 0) goto L22;
            if (r101 < r112) goto L22;
            if (r101 > r113) goto L22;
            int r103 = MathUtils.clamp(r111, r112, r113);
            if (r101 != r103) goto L9;
        L23:
            return r102;
        L9:
            if (r110.hasChildWithInterpolator() == false) goto L11;
            int r114 = interpolateOffset(r110, r103);
        L12:
            boolean r115 = setTopAndBottomOffset(r114);
            r102 = r101 - r103;
            this.offsetDelta = r103 - r114;
            if (r115 == false) goto L15;
        L17:
            r110.dispatchOffsetUpdates(getTopAndBottomOffset());
            if (r103 >= r101) goto L20;
            int r104 = -1;
        L21:
            updateAppBarLayoutDrawableState(r100, r110, r103, r104, false);
            goto L23
        L20:
            r104 = 1;
            goto L21
        L15:
            if (r110.hasChildWithInterpolator() == false) goto L17;
            r100.dispatchDependentViewsChanged(r110);
            goto L17
        L11:
            r114 = r103;
        L22:
            this.offsetDelta = 0;
            goto L23
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r100, View r101, int r102, int r103, int r104) {
            return setHeaderTopBottomOffset(r100, (AppBarLayout) r101, r102, r103, r104);
        }

        public boolean onMeasureChild(CoordinatorLayout r100, T r101, int r102, int r110, int r111, int r112) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r101.getLayoutParams())).height != (-2)) goto L7;
            r100.onMeasureChild(r101, r102, r110, View.MeasureSpec.makeMeasureSpec(0, 0), r112);
            return true;
        L7:
            return super.onMeasureChild(r100, r101, r102, r110, r111, r112);
        }

        public boolean onStartNestedScroll(CoordinatorLayout r100, T r101, View r102, View r103, int r104, int r105) {
            if ((r104 & 2) != 0) goto L5;
        L9:
            boolean r106 = false;
        L10:
            if (r106 == false) goto L14;
            ValueAnimator r107 = this.offsetAnimator;
            if (r107 == null) goto L14;
            r107.cancel();
        L14:
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = r105;
            return r106;
        L5:
            if (r101.isLiftOnScroll() == false) goto L7;
        L8:
            r106 = true;
            goto L10
        L7:
            if (canScrollChildren(r100, r101, r102) == false) goto L9;
            goto L8
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r100, View r101, int r102, int r103, int r104, int r105) {
            return onMeasureChild(r100, (AppBarLayout) r101, r102, r103, r104, r105);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r102, View r103, int r104, int r105) {
            return onStartNestedScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105);
        }

        public void onNestedPreScroll(CoordinatorLayout r100, T r101, View r110, int r111, int r112, int[] r113, int r114) {
            if (r112 == 0) goto L9;
            if (r112 >= 0) goto L5;
            int r115 = -r101.getTotalScrollRange();
            int r102 = r115;
            int r103 = r101.getDownNestedPreScrollRange() + r115;
        L6:
            if (r102 == r103) goto L10;
            r113[1] = scroll(r100, r101, r112, r102, r103);
            stopNestedScrollIfNeeded(r112, r101, r110, r114);
            return;
        L10:
            return;
        L5:
            r102 = -r101.getUpNestedPreScrollRange();
            r103 = 0;
            goto L6
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int[] r105, int r106) {
            onNestedPreScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105, r106);
        }

        public void onNestedScroll(CoordinatorLayout r100, T r101, View r102, int r110, int r111, int r112, int r113, int r114) {
            if (r113 >= 0) goto L5;
            scroll(r100, r101, r113, -r101.getDownNestedScrollRange(), 0);
            stopNestedScrollIfNeeded(r113, r101, r102, r114);
        L5:
            if (r101.isLiftOnScroll() == true) goto L7;
            return;
        L7:
            if (r102.getScrollY() <= 0) goto L9;
            boolean r103 = true;
        L10:
            r101.setLiftedState(r103);
            return;
        L9:
            r103 = false;
            goto L10
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int r105, int r106, int r107) {
            onNestedScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105, r106, r107);
        }
    }

    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(T r100, int r101);
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
            public DragCallback() {
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public Behavior() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void setDragCallback(BaseBehavior.BaseDragCallback r100) {
            super.setDragCallback(r100);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int r100) {
            return super.setLeftAndRightOffset(r100);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r100) {
            return super.setTopAndBottomOffset(r100);
        }

        public Behavior(Context r100, AttributeSet r101) {
            super(r100, r101);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r100, AppBarLayout r101) {
            return super.onSaveInstanceState(r100, r101);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r100, AppBarLayout r101, int r102) {
            return super.onLayoutChild(r100, r101, r102);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r100, AppBarLayout r101, Parcelable r102) {
            super.onRestoreInstanceState(r100, r101, r102);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103) {
            super.onStopNestedScroll(r100, r101, r102, r103);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r100, AppBarLayout r101, int r102, int r103, int r104, int r105) {
            return super.onMeasureChild(r100, r101, r102, r103, r104, r105);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, View r103, int r104, int r105) {
            return super.onStartNestedScroll(r100, r101, r102, r103, r104, r105);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103, int r104, int[] r105, int r106) {
            super.onNestedPreScroll(r100, r101, r102, r103, r104, r105, r106);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103, int r104, int r105, int r106, int r107) {
            super.onNestedScroll(r100, r101, r102, r103, r104, r105, r106, r107);
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
        int scrollFlags;
        Interpolator scrollInterpolator;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollFlags {
        }

        public boolean isCollapsible() {
            int r100 = this.scrollFlags;
            if ((r100 & 1) == 1) goto L5;
        L7:
            return false;
        L5:
            if ((r100 & 10) == 0) goto L7;
            return true;
        }

        public int getScrollFlags() {
            return this.scrollFlags;
        }

        public Interpolator getScrollInterpolator() {
            return this.scrollInterpolator;
        }

        public LayoutParams(LayoutParams r100) {
            super(r100);
            this.scrollFlags = 1;
            this.scrollFlags = r100.scrollFlags;
            this.scrollInterpolator = r100.scrollInterpolator;
        }

        public void setScrollFlags(int r100) {
            this.scrollFlags = r100;
        }

        public void setScrollInterpolator(Interpolator r100) {
            this.scrollInterpolator = r100;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.scrollFlags = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams r100) {
            super(r100);
            this.scrollFlags = 1;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.scrollFlags = 1;
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.layout_scrollFlags, R.attr.layout_scrollInterpolator});
            this.scrollFlags = r102.getInt(0, 0);
            if (r102.hasValue(1) == false) goto L5;
            this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(r100, r102.getResourceId(1, 0));
        L5:
            r102.recycle();
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.scrollFlags = 1;
        }

        public LayoutParams(int r100, int r101, float r102) {
            super(r100, r101, r102);
            this.scrollFlags = 1;
        }
    }

    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        void onOffsetChanged(AppBarLayout r100, int r101);
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public ScrollingViewBehavior() {
        }

        private static int getAppBarLayoutOffset(AppBarLayout r100) {
            CoordinatorLayout.Behavior r101 = ((CoordinatorLayout.LayoutParams) r100.getLayoutParams()).getBehavior();
            if ((r101 instanceof BaseBehavior) == true) goto L5;
            return 0;
        L5:
            return ((BaseBehavior) r101).getTopBottomOffsetForScrollingSibling();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public AppBarLayout findFirstDependency(List<View> r100) {
            int r101 = r100.size();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L9;
            View r103 = (View) ListProtector.get(r100, r102);
            if ((r103 instanceof AppBarLayout) == true) goto L7;
            r102 = r102 + 1;
            goto L3
        L7:
            return (AppBarLayout) r103;
        L9:
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public float getOverlapRatioForOffset(View r100) {
            if ((r100 instanceof AppBarLayout) == false) goto L13;
            AppBarLayout r101 = (AppBarLayout) r100;
            int r102 = r101.getTotalScrollRange();
            int r103 = r101.getDownNestedPreScrollRange();
            int r104 = getAppBarLayoutOffset(r101);
            if (r103 != 0) goto L7;
        L9:
            int r105 = r102 - r103;
            if (r105 == 0) goto L13;
            return (r104 / r105) + 1.0f;
        L7:
            if ((r102 + r104) > r103) goto L9;
            return 0.0f;
        L13:
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public int getScrollRange(View r100) {
            if ((r100 instanceof AppBarLayout) == false) goto L7;
            return ((AppBarLayout) r100).getTotalScrollRange();
        L7:
            return super.getScrollRange(r100);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int r100) {
            return super.setLeftAndRightOffset(r100);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r100) {
            return super.setTopAndBottomOffset(r100);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public /* bridge */ /* synthetic */ View findFirstDependency(List r100) {
            return findFirstDependency(r100);
        }

        public ScrollingViewBehavior(Context r100, AttributeSet r101) {
            super(r100, r101);
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_overlapTop});
            setOverlayTop(r102.getDimensionPixelSize(0, 0));
            r102.recycle();
        }

        private void offsetChildAsNeeded(View r100, View r101) {
            CoordinatorLayout.Behavior r102 = ((CoordinatorLayout.LayoutParams) r101.getLayoutParams()).getBehavior();
            if ((r102 instanceof BaseBehavior) == false) goto L6;
            ViewCompat.offsetTopAndBottom(r100, (((r101.getBottom() - r100.getTop()) + BaseBehavior.access$000((BaseBehavior) r102)) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(r101));
            return;
        }

        private void updateLiftedStateIfNeeded(View r100, View r101) {
            if ((r101 instanceof AppBarLayout) == false) goto L12;
            AppBarLayout r102 = (AppBarLayout) r101;
            if (r102.isLiftOnScroll() == true) goto L7;
            return;
        L7:
            if (r100.getScrollY() <= 0) goto L9;
            boolean r103 = true;
        L10:
            r102.setLiftedState(r103);
            return;
        L9:
            r103 = false;
            goto L10
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout r100, View r101, View r102) {
            return r102 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout r100, View r101, View r102) {
            offsetChildAsNeeded(r101, r102);
            updateLiftedStateIfNeeded(r101, r102);
            return false;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r100, View r101, int r102) {
            return super.onLayoutChild(r100, r101, r102);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout r100, View r101, Rect r102, boolean r103) {
            AppBarLayout r104 = findFirstDependency(r100.getDependencies(r101));
            if (r104 == null) goto L8;
            r102.offset(r101.getLeft(), r101.getTop());
            Rect r105 = this.tempRect1;
            r105.set(0, 0, r100.getWidth(), r100.getHeight());
            if (r105.contains(r102) == true) goto L8;
            r104.setExpanded(false, !r103);
            return true;
        L8:
            return false;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r100, View r101, int r102, int r103, int r104, int r105) {
            return super.onMeasureChild(r100, r101, r102, r103, r104, r105);
        }
    }

    private void invalidateScrollRanges() {
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
    }

    public float getTargetElevation() {
        return 0.0f;
    }

    void resetPendingAction() {
        this.pendingAction = 0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    int getDownNestedPreScrollRange() {
        int r100 = this.downPreScrollRange;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        int r101 = getChildCount() - 1;
        int r102 = 0;
    L6:
        if (r101 < 0) goto L20;
        View r103 = getChildAt(r101);
        LayoutParams r104 = (LayoutParams) r103.getLayoutParams();
        int r105 = r103.getMeasuredHeight();
        int r106 = r104.scrollFlags;
        if ((r106 & 5) != 5) goto L17;
        int r107 = r102 + (((LinearLayout.LayoutParams) r104).topMargin + ((LinearLayout.LayoutParams) r104).bottomMargin);
        if ((r106 & 8) == 0) goto L13;
        r102 = r107 + ViewCompat.getMinimumHeight(r103);
    L19:
        r101 = r101 - 1;
        goto L6
    L13:
        if ((r106 & 2) == 0) goto L15;
        int r108 = ViewCompat.getMinimumHeight(r103);
    L16:
        r102 = r107 + (r105 - r108);
        goto L19
    L15:
        r108 = getTopInset();
        goto L16
    L17:
        if (r102 <= 0) goto L19;
    L20:
        int r109 = Math.max(0, r102);
        this.downPreScrollRange = r109;
        return r109;
    }

    int getDownNestedScrollRange() {
        int r100 = this.downScrollRange;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        int r101 = getChildCount();
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r102 >= r101) goto L13;
        View r104 = getChildAt(r102);
        LayoutParams r105 = (LayoutParams) r104.getLayoutParams();
        int r106 = r104.getMeasuredHeight() + (((LinearLayout.LayoutParams) r105).topMargin + ((LinearLayout.LayoutParams) r105).bottomMargin);
        int r107 = r105.scrollFlags;
        if ((r107 & 1) == 0) goto L13;
        r103 = r103 + r106;
        if ((r107 & 2) != 0) goto L11;
        r102 = r102 + 1;
        goto L6
    L11:
        r103 = r103 - (ViewCompat.getMinimumHeight(r104) + getTopInset());
    L13:
        int r108 = Math.max(0, r103);
        this.downScrollRange = r108;
        return r108;
    }

    final int getTopInset() {
        WindowInsetsCompat r100 = this.lastInsets;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getSystemWindowInsetTop();
    }

    public final int getTotalScrollRange() {
        int r100 = this.totalScrollRange;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        int r101 = getChildCount();
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r102 >= r101) goto L13;
        View r104 = getChildAt(r102);
        LayoutParams r105 = (LayoutParams) r104.getLayoutParams();
        int r106 = r104.getMeasuredHeight();
        int r107 = r105.scrollFlags;
        if ((r107 & 1) == 0) goto L13;
        r103 = r103 + ((r106 + ((LinearLayout.LayoutParams) r105).topMargin) + ((LinearLayout.LayoutParams) r105).bottomMargin);
        if ((r107 & 2) != 0) goto L11;
        r102 = r102 + 1;
        goto L6
    L11:
        r103 = r103 - ViewCompat.getMinimumHeight(r104);
    L13:
        int r108 = Math.max(0, r103 - getTopInset());
        this.totalScrollRange = r108;
        return r108;
    }

    private boolean hasCollapsibleChild() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L9;
        if (((LayoutParams) getChildAt(r101).getLayoutParams()).isCollapsible() == true) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int r100 = getTopInset();
        int r101 = ViewCompat.getMinimumHeight(this);
        if (r101 != 0) goto L5;
        int r102 = getChildCount();
        if (r102 < 1) goto L9;
        r101 = ViewCompat.getMinimumHeight(getChildAt(r102 - 1));
    L10:
        if (r101 != 0) goto L5;
        return getHeight() / 3;
    L9:
        r101 = 0;
    L5:
        return (r101 * 2) + r100;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    boolean hasScrollableChildren() {
        if (getTotalScrollRange() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    int getPendingAction() {
        return this.pendingAction;
    }

    boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public AppBarLayout(Context r100) {
        this(r100, null);
    }

    private boolean setLiftableState(boolean r100) {
        if (this.liftable == r100) goto L6;
        this.liftable = r100;
        refreshDrawableState();
        return true;
    L6:
        return false;
    }

    public void addOnOffsetChangedListener(BaseOnOffsetChangedListener r100) {
        if (this.listeners != null) goto L5;
        this.listeners = new ArrayList();
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (this.listeners.contains(r100) == true) goto L11;
        this.listeners.add(r100);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    public void dispatchOffsetUpdates(int r100) {
        List<BaseOnOffsetChangedListener> r101 = this.listeners;
        if (r101 == null) goto L10;
        int r102 = r101.size();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        BaseOnOffsetChangedListener r104 = (BaseOnOffsetChangedListener) ListProtector.get(this.listeners, r103);
        if (r104 == null) goto L9;
        r104.onOffsetChanged(this, r100);
    L9:
        r103 = r103 + 1;
        goto L5
    L14:
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LinearLayout.LayoutParams) == false) goto L7;
        return new LayoutParams((LinearLayout.LayoutParams) r100);
    L7:
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L11:
        return new LayoutParams(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int r100) {
        if (this.tmpStatesArray != null) goto L5;
        this.tmpStatesArray = new int[4];
    L5:
        int[] r101 = this.tmpStatesArray;
        int[] r102 = super.onCreateDrawableState(r100 + r101.length);
        boolean r103 = this.liftable;
        if (r103 == false) goto L8;
        int r104 = R.attr.state_liftable;
    L9:
        r101[0] = r104;
        if (r103 == true) goto L12;
    L14:
        int r105 = -2130974262;
    L15:
        r101[1] = r105;
        if (r103 == false) goto L18;
        int r106 = R.attr.state_collapsible;
    L19:
        r101[2] = r106;
        if (r103 == true) goto L22;
    L24:
        int r107 = -2130974254;
    L25:
        r101[3] = r107;
        return LinearLayout.mergeDrawableStates(r102, r101);
    L22:
        if (this.lifted == false) goto L24;
        r107 = R.attr.state_collapsed;
        goto L25
    L18:
        r106 = -2130974255;
        goto L19
    L12:
        if (this.lifted == false) goto L14;
        r105 = R.attr.state_lifted;
        goto L15
    L8:
        r104 = -2130974261;
        goto L9
    }

    WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat r100) {
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L5;
        WindowInsetsCompat r101 = r100;
    L7:
        if (ObjectsCompat.equals(this.lastInsets, r101) == true) goto L9;
        this.lastInsets = r101;
        invalidateScrollRanges();
    L9:
        return r100;
    L5:
        r101 = null;
        goto L7
    }

    public void removeOnOffsetChangedListener(BaseOnOffsetChangedListener r100) {
        List<BaseOnOffsetChangedListener> r101 = this.listeners;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.remove(r100);
        return;
    L8:
        return;
    }

    public void setExpanded(boolean r100) {
        setExpanded(r100, ViewCompat.isLaidOut(this));
    }

    public void setLiftOnScroll(boolean r100) {
        this.liftOnScroll = r100;
    }

    public boolean setLiftable(boolean r100) {
        this.liftableOverride = true;
        return setLiftableState(r100);
    }

    public boolean setLifted(boolean r100) {
        return setLiftedState(r100);
    }

    boolean setLiftedState(boolean r100) {
        if (this.lifted == r100) goto L6;
        this.lifted = r100;
        refreshDrawableState();
        return true;
    L6:
        return false;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int r100) {
        if (r100 != 1) goto L7;
        super.setOrientation(r100);
        return;
    L7:
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setTargetElevation(float r100) {
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, r100);
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener r100) {
        addOnOffsetChangedListener(r100);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener r100) {
        removeOnOffsetChangedListener(r100);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateLayoutParams(r100);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateLayoutParams(r100);
    }

    public AppBarLayout(Context r110, AttributeSet r111) {
        super(r110, r111);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        this.pendingAction = 0;
        setOrientation(1);
        int r100 = Build.VERSION.SDK_INT;
        ViewUtilsLollipop.setBoundsViewOutlineProvider(this);
        ViewUtilsLollipop.setStateListAnimatorFromAttrs(this, r111, 0, R.style.Widget_Design_AppBarLayout);
        TypedArray r112 = ThemeEnforcement.obtainStyledAttributes(r110, r111, new int[]{android.R.attr.background, android.R.attr.touchscreenBlocksFocus, android.R.attr.keyboardNavigationCluster, R.attr.elevation, R.attr.expanded, R.attr.liftOnScroll}, 0, R.style.Widget_Design_AppBarLayout, new int[0]);
        ViewCompat.setBackground(this, r112.getDrawable(0));
        if (r112.hasValue(4) == false) goto L6;
        setExpanded(r112.getBoolean(4, false), false, false);
    L6:
        if (r112.hasValue(3) == false) goto L9;
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, r112.getDimensionPixelSize(3, 0));
    L9:
        if (r100 >= 26) goto L11;
    L16:
        this.liftOnScroll = r112.getBoolean(5, false);
        r112.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
        return;
    L11:
        if (r112.hasValue(2) == false) goto L14;
        setKeyboardNavigationCluster(r112.getBoolean(2, false));
    L14:
        if (r112.hasValue(1) == false) goto L16;
        setTouchscreenBlocksFocus(r112.getBoolean(1, false));
        goto L16
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        invalidateScrollRanges();
    }

    public void setExpanded(boolean r100, boolean r101) {
        setExpanded(r100, r101, true);
    }

    private void setExpanded(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L4;
        int r103 = 1;
    L5:
        int r104 = 0;
        if (r101 == false) goto L8;
        int r105 = 4;
    L9:
        int r106 = r103 | r105;
        if (r102 == false) goto L12;
        r104 = 8;
    L12:
        this.pendingAction = r106 | r104;
        requestLayout();
        return;
    L8:
        r105 = 0;
        goto L9
    L4:
        r103 = 2;
        goto L5
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        invalidateScrollRanges();
        boolean r105 = false;
        this.haveChildWithInterpolator = false;
        int r106 = getChildCount();
        int r107 = 0;
    L4:
        if (r107 >= r106) goto L10;
        if (((LayoutParams) getChildAt(r107).getLayoutParams()).getScrollInterpolator() != null) goto L7;
        r107 = r107 + 1;
        goto L4
    L7:
        this.haveChildWithInterpolator = true;
    L10:
        if (this.liftableOverride == false) goto L12;
        return;
    L12:
        if (this.liftOnScroll == false) goto L14;
    L15:
        r105 = true;
    L16:
        setLiftableState(r105);
        return;
    L14:
        if (hasCollapsibleChild() == false) goto L16;
        goto L15
    }
}
