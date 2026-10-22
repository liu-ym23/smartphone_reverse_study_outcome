package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.stateful.ExtendableSavedState;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, ExpandableTransformationWidget {
    private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
    private static final String EXPANDABLE_WIDGET_HELPER_KEY = "expandableWidgetHelper";
    private static final String LOG_TAG = "FloatingActionButton";
    public static final int NO_CUSTOM_SIZE = 0;
    public static final int SIZE_AUTO = -1;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;
    private ColorStateList backgroundTint;
    private PorterDuff.Mode backgroundTintMode;
    private int borderWidth;
    boolean compatPadding;
    private int customSize;
    private final ExpandableWidgetHelper expandableWidgetHelper;
    private final AppCompatImageHelper imageHelper;
    private PorterDuff.Mode imageMode;
    private int imagePadding;
    private ColorStateList imageTint;
    private FloatingActionButtonImpl impl;
    private int maxImageSize;
    private ColorStateList rippleColor;
    final Rect shadowPadding;
    private int size;
    private final Rect touchArea;

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = true;
        private boolean autoHideEnabled;
        private OnVisibilityChangedListener internalAutoHideListener;
        private Rect tmpRect;

        public BaseBehavior() {
            this.autoHideEnabled = true;
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        private static boolean isBottomSheet(View r100) {
            ViewGroup.LayoutParams r101 = r100.getLayoutParams();
            if ((r101 instanceof CoordinatorLayout.LayoutParams) == true) goto L5;
            return false;
        L5:
            return ((CoordinatorLayout.LayoutParams) r101).getBehavior() instanceof BottomSheetBehavior;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r100) {
            if (r100.dodgeInsetEdges != 0) goto L6;
            r100.dodgeInsetEdges = 80;
            return;
        }

        public void setAutoHideEnabled(boolean r100) {
            this.autoHideEnabled = r100;
        }

        public void setInternalAutoHideListener(OnVisibilityChangedListener r100) {
            this.internalAutoHideListener = r100;
        }

        public BaseBehavior(Context r100, AttributeSet r101) {
            super(r100, r101);
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_autoHide});
            this.autoHideEnabled = r102.getBoolean(0, true);
            r102.recycle();
        }

        private void offsetIfNeeded(CoordinatorLayout r100, FloatingActionButton r101) {
            Rect r102 = r101.shadowPadding;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.centerX() > 0) goto L7;
            return;
        L7:
            if (r102.centerY() <= 0) goto L28;
            CoordinatorLayout.LayoutParams r103 = (CoordinatorLayout.LayoutParams) r101.getLayoutParams();
            int r104 = 0;
            if (r101.getRight() < (r100.getWidth() - ((ViewGroup.MarginLayoutParams) r103).rightMargin)) goto L12;
            int r105 = r102.right;
        L16:
            if (r101.getBottom() < (r100.getHeight() - ((ViewGroup.MarginLayoutParams) r103).bottomMargin)) goto L19;
            r104 = r102.bottom;
        L21:
            if (r104 == 0) goto L23;
            ViewCompat.offsetTopAndBottom(r101, r104);
        L23:
            if (r105 == 0) goto L29;
            ViewCompat.offsetLeftAndRight(r101, r105);
            return;
        L29:
            return;
        L19:
            if (r101.getTop() > ((ViewGroup.MarginLayoutParams) r103).topMargin) goto L21;
            r104 = -r102.top;
            goto L21
        L12:
            if (r101.getLeft() > ((ViewGroup.MarginLayoutParams) r103).leftMargin) goto L14;
            r105 = -r102.left;
            goto L16
        L14:
            r105 = 0;
            goto L16
        }

        private boolean shouldUpdateVisibility(View r100, FloatingActionButton r101) {
            CoordinatorLayout.LayoutParams r102 = (CoordinatorLayout.LayoutParams) r101.getLayoutParams();
            if (this.autoHideEnabled == true) goto L6;
            return false;
        L6:
            if (r102.getAnchorId() == r100.getId()) goto L9;
            return false;
        L9:
            if (r101.getUserSetVisibility() == 0) goto L11;
            return false;
        L11:
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(View r100, FloatingActionButton r101) {
            if (shouldUpdateVisibility(r100, r101) == true) goto L5;
            return false;
        L5:
            CoordinatorLayout.LayoutParams r102 = (CoordinatorLayout.LayoutParams) r101.getLayoutParams();
            if (r100.getTop() >= ((r101.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) r102).topMargin)) goto L8;
            r101.hide(this.internalAutoHideListener, false);
            return true;
        L8:
            r101.show(this.internalAutoHideListener, false);
            return true;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout r100, AppBarLayout r101, FloatingActionButton r102) {
            if (shouldUpdateVisibility(r101, r102) == true) goto L6;
            return false;
        L6:
            if (this.tmpRect != null) goto L8;
            this.tmpRect = new Rect();
        L8:
            Rect r103 = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(r100, r101, r103);
            if (r103.bottom > r101.getMinimumHeightForVisibleOverlappingContent()) goto L11;
            r102.hide(this.internalAutoHideListener, false);
            return true;
        L11:
            r102.show(this.internalAutoHideListener, false);
            return true;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout r100, FloatingActionButton r101, Rect r102) {
            Rect r103 = r101.shadowPadding;
            r102.set(r101.getLeft() + r103.left, r101.getTop() + r103.top, r101.getRight() - r103.right, r101.getBottom() - r103.bottom);
            return true;
        }

        public boolean onDependentViewChanged(CoordinatorLayout r100, FloatingActionButton r101, View r102) {
            if ((r102 instanceof AppBarLayout) == false) goto L6;
            updateFabVisibilityForAppBarLayout(r100, (AppBarLayout) r102, r101);
            return false;
        L6:
            if (isBottomSheet(r102) == false) goto L11;
            updateFabVisibilityForBottomSheet(r102, r101);
            return false;
        L11:
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout r100, FloatingActionButton r101, int r102) {
            List<View> r103 = r100.getDependencies(r101);
            int r104 = r103.size();
            int r105 = 0;
        L3:
            if (r105 >= r104) goto L15;
            View r106 = (View) ListProtector.get(r103, r105);
            if ((r106 instanceof AppBarLayout) == false) goto L10;
            if (updateFabVisibilityForAppBarLayout(r100, (AppBarLayout) r106, r101) == true) goto L15;
        L14:
            r105 = r105 + 1;
            goto L3
        L10:
            if (isBottomSheet(r106) == false) goto L14;
            if (updateFabVisibilityForBottomSheet(r106, r101) == false) goto L14;
        L15:
            r100.onLayoutChild(r101, r102);
            offsetIfNeeded(r100, r101);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout r100, View r101, Rect r102) {
            return getInsetDodgeRect(r100, (FloatingActionButton) r101, r102);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout r100, View r101, View r102) {
            return onDependentViewChanged(r100, (FloatingActionButton) r101, r102);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r100, View r101, int r102) {
            return onLayoutChild(r100, (FloatingActionButton) r101, r102);
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean isAutoHideEnabled() {
            return super.isAutoHideEnabled();
        }

        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r100) {
            super.onAttachedToLayoutParams(r100);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void setAutoHideEnabled(boolean r100) {
            super.setAutoHideEnabled(r100);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void setInternalAutoHideListener(OnVisibilityChangedListener r100) {
            super.setInternalAutoHideListener(r100);
        }

        public Behavior(Context r100, AttributeSet r101) {
            super(r100, r101);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout r100, FloatingActionButton r101, Rect r102) {
            return super.getInsetDodgeRect(r100, r101, r102);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout r100, FloatingActionButton r101, View r102) {
            return super.onDependentViewChanged(r100, r101, r102);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r100, FloatingActionButton r101, int r102) {
            return super.onLayoutChild(r100, r101, r102);
        }
    }

    public static abstract class OnVisibilityChangedListener {
        public OnVisibilityChangedListener() {
        }

        public void onHidden(FloatingActionButton r100) {
        }

        public void onShown(FloatingActionButton r100) {
        }
    }

    public class ShadowDelegateImpl implements ShadowViewDelegate {
        final /* synthetic */ FloatingActionButton this$0;

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public float getRadius() {
            return this.this$0.getSizeDimension() / 2.0f;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public boolean isCompatPaddingEnabled() {
            return this.this$0.compatPadding;
        }

        public ShadowDelegateImpl(FloatingActionButton r100) {
            this.this$0 = r100;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void setBackgroundDrawable(Drawable r100) {
            FloatingActionButton.access$101(this.this$0, r100);
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void setShadowPadding(int r100, int r101, int r102, int r103) {
            this.this$0.shadowPadding.set(r100, r101, r102, r103);
            FloatingActionButton r104 = this.this$0;
            r104.setPadding(r100 + FloatingActionButton.access$000(r104), r101 + FloatingActionButton.access$000(this.this$0), r102 + FloatingActionButton.access$000(this.this$0), r103 + FloatingActionButton.access$000(this.this$0));
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Size {
    }

    public void clearCustomSize() {
        setCustomSize(0);
    }

    public void hide() {
        hide(null);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r100) {
    }

    @Override // android.view.View
    public void setBackgroundResource(int r100) {
    }

    public void show() {
        show(null);
    }

    private FloatingActionButtonImpl createImpl() {
        return new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl(this));
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.impl != null) goto L6;
        this.impl = createImpl();
    L6:
        return this.impl;
    }

    @Override // com.google.android.material.expandable.ExpandableTransformationWidget
    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.getExpandedComponentIdHint();
    }

    public int getRippleColor() {
        ColorStateList r100 = this.rippleColor;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getDefaultColor();
    }

    public int getSizeDimension() {
        return getSizeDimension(this.size);
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public boolean isExpanded() {
        return this.expandableWidgetHelper.isExpanded();
    }

    private void onApplySupportImageTint() {
        Drawable r100 = getDrawable();
        if (r100 != null) goto L5;
        return;
    L5:
        ColorStateList r101 = this.imageTint;
        if (r101 != null) goto L9;
        DrawableCompat.clearColorFilter(r100);
        return;
    L9:
        int r102 = r101.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode r103 = this.imageMode;
        if (r103 != null) goto L12;
        r103 = PorterDuff.Mode.SRC_IN;
    L12:
        r100.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(r102, r103));
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().onDrawableStateChanged(getDrawableState());
    }

    public float getCompatElevation() {
        return getImpl().getElevation();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().getHoveredFocusedTranslationZ();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().getPressedTranslationZ();
    }

    public Drawable getContentBackground() {
        return getImpl().getContentBackground();
    }

    public MotionSpec getHideMotionSpec() {
        return getImpl().getHideMotionSpec();
    }

    public MotionSpec getShowMotionSpec() {
        return getImpl().getShowMotionSpec();
    }

    @Override // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public boolean isOrWillBeHidden() {
        return getImpl().isOrWillBeHidden();
    }

    public boolean isOrWillBeShown() {
        return getImpl().isOrWillBeShown();
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().jumpDrawableToCurrentState();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().onDetachedFromWindow();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ExtendableSavedState r100 = new ExtendableSavedState(super.onSaveInstanceState());
        r100.extendableStates.put(EXPANDABLE_WIDGET_HELPER_KEY, this.expandableWidgetHelper.onSaveInstanceState());
        return r100;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public int getCustomSize() {
        return this.customSize;
    }

    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    public int getSize() {
        return this.size;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public FloatingActionButton(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ int access$000(FloatingActionButton r100) {
        return r100.imagePadding;
    }

    private int getSizeDimension(int r100) {
        int r101 = this.customSize;
        if (r101 == 0) goto L5;
        return r101;
    L5:
        Resources r102 = getResources();
        if (r100 == (-1)) goto L13;
        if (r100 == 1) goto L11;
        return r102.getDimensionPixelSize(R.dimen.design_fab_size_normal);
    L11:
        return r102.getDimensionPixelSize(R.dimen.design_fab_size_mini);
    L13:
        if (Math.max(r102.getConfiguration().screenWidthDp, r102.getConfiguration().screenHeightDp) >= 470) goto L16;
        return getSizeDimension(1);
    L16:
        return getSizeDimension(0);
    }

    private void offsetRectWithShadow(Rect r100) {
        int r101 = r100.left;
        Rect r102 = this.shadowPadding;
        r100.left = r101 + r102.left;
        r100.top += r102.top;
        r100.right -= r102.right;
        r100.bottom -= r102.bottom;
    }

    private FloatingActionButtonImpl.InternalVisibilityChangedListener wrapOnVisibilityChangedListener(final OnVisibilityChangedListener r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass1(this, r100);
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener r100) {
        getImpl().addOnHideAnimationListener(r100);
    }

    public void addOnShowAnimationListener(Animator.AnimatorListener r100) {
        getImpl().addOnShowAnimationListener(r100);
    }

    public boolean getContentRect(Rect r100) {
        if (ViewCompat.isLaidOut(this) == false) goto L6;
        r100.set(0, 0, getWidth(), getHeight());
        offsetRectWithShadow(r100);
        return true;
    L6:
        return false;
    }

    public void getMeasuredContentRect(Rect r100) {
        r100.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        offsetRectWithShadow(r100);
    }

    public void hide(OnVisibilityChangedListener r100) {
        hide(r100, true);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof ExtendableSavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        ExtendableSavedState r101 = (ExtendableSavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        this.expandableWidgetHelper.onRestoreInstanceState(r101.extendableStates.get(EXPANDABLE_WIDGET_HELPER_KEY));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (r100.getAction() != 0) goto L11;
        if (getContentRect(this.touchArea) == false) goto L11;
        if (this.touchArea.contains((int) r100.getX(), (int) r100.getY()) == true) goto L11;
        return false;
    L11:
        return super.onTouchEvent(r100);
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener r100) {
        getImpl().removeOnHideAnimationListener(r100);
    }

    public void removeOnShowAnimationListener(Animator.AnimatorListener r100) {
        getImpl().removeOnShowAnimationListener(r100);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList r100) {
        if (this.backgroundTint == r100) goto L6;
        this.backgroundTint = r100;
        getImpl().setBackgroundTintList(r100);
        return;
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode r100) {
        if (this.backgroundTintMode == r100) goto L6;
        this.backgroundTintMode = r100;
        getImpl().setBackgroundTintMode(r100);
        return;
    }

    public void setCompatElevation(float r100) {
        getImpl().setElevation(r100);
    }

    public void setCompatElevationResource(int r100) {
        setCompatElevation(getResources().getDimension(r100));
    }

    public void setCompatHoveredFocusedTranslationZ(float r100) {
        getImpl().setHoveredFocusedTranslationZ(r100);
    }

    public void setCompatHoveredFocusedTranslationZResource(int r100) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(r100));
    }

    public void setCompatPressedTranslationZ(float r100) {
        getImpl().setPressedTranslationZ(r100);
    }

    public void setCompatPressedTranslationZResource(int r100) {
        setCompatPressedTranslationZ(getResources().getDimension(r100));
    }

    public void setCustomSize(int r100) {
        if (r100 < 0) goto L6;
        this.customSize = r100;
        return;
    L6:
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public boolean setExpanded(boolean r100) {
        return this.expandableWidgetHelper.setExpanded(r100);
    }

    @Override // com.google.android.material.expandable.ExpandableTransformationWidget
    public void setExpandedComponentIdHint(int r100) {
        this.expandableWidgetHelper.setExpandedComponentIdHint(r100);
    }

    public void setHideMotionSpec(MotionSpec r100) {
        getImpl().setHideMotionSpec(r100);
    }

    public void setHideMotionSpecResource(int r100) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), r100));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        super.setImageDrawable(r100);
        getImpl().updateImageMatrixScale();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r100) {
        this.imageHelper.setImageResource(r100);
    }

    public void setRippleColor(ColorStateList r100) {
        if (this.rippleColor == r100) goto L6;
        this.rippleColor = r100;
        getImpl().setRippleColor(this.rippleColor);
        return;
    }

    public void setShowMotionSpec(MotionSpec r100) {
        getImpl().setShowMotionSpec(r100);
    }

    public void setShowMotionSpecResource(int r100) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), r100));
    }

    public void setSize(int r100) {
        this.customSize = 0;
        if (r100 == this.size) goto L6;
        this.size = r100;
        requestLayout();
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList r100) {
        setBackgroundTintList(r100);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode r100) {
        setBackgroundTintMode(r100);
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(ColorStateList r100) {
        if (this.imageTint == r100) goto L6;
        this.imageTint = r100;
        onApplySupportImageTint();
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(PorterDuff.Mode r100) {
        if (this.imageMode == r100) goto L6;
        this.imageMode = r100;
        onApplySupportImageTint();
        return;
    }

    public void setUseCompatPadding(boolean r100) {
        if (this.compatPadding == r100) goto L6;
        this.compatPadding = r100;
        getImpl().onCompatShadowChanged();
        return;
    }

    public void show(OnVisibilityChangedListener r100) {
        show(r100, true);
    }

    public void setRippleColor(int r100) {
        setRippleColor(ColorStateList.valueOf(r100));
    }

    public FloatingActionButton(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.floatingActionButtonStyle);
    }

    public static /* synthetic */ void access$101(FloatingActionButton r100, Drawable r101) {
        super.setBackgroundDrawable(r101);
    }

    private static int resolveAdjustedSize(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r101);
        int r103 = View.MeasureSpec.getSize(r101);
        if (r102 == Integer.MIN_VALUE) goto L11;
        if (r102 != 0) goto L6;
        return r100;
    L6:
        if (r102 != 1073741824) goto L9;
        return r103;
    L9:
        throw new IllegalArgumentException();
    L11:
        return Math.min(r100, r103);
    }

    public void hide(OnVisibilityChangedListener r100, boolean r101) {
        getImpl().hide(wrapOnVisibilityChangedListener(r100), r101);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = getSizeDimension();
        this.imagePadding = (r102 - this.maxImageSize) / 2;
        getImpl().updatePadding();
        int r103 = Math.min(resolveAdjustedSize(r102, r100), resolveAdjustedSize(r102, r101));
        Rect r104 = this.shadowPadding;
        setMeasuredDimension((r104.left + r103) + r104.right, (r103 + r104.top) + r104.bottom);
    }

    public void show(OnVisibilityChangedListener r100, boolean r101) {
        getImpl().show(wrapOnVisibilityChangedListener(r100), r101);
    }

    public FloatingActionButton(Context r100, AttributeSet r101, int r110) {
        super(r100, r101, r110);
        this.shadowPadding = new Rect();
        this.touchArea = new Rect();
        TypedArray r102 = ThemeEnforcement.obtainStyledAttributes(r100, r101, new int[]{R.attr.backgroundTint, R.attr.backgroundTintMode, R.attr.borderWidth, R.attr.elevation, R.attr.fabCustomSize, R.attr.fabSize, R.attr.hideMotionSpec, R.attr.hoveredFocusedTranslationZ, R.attr.maxImageSize, R.attr.pressedTranslationZ, R.attr.rippleColor, R.attr.showMotionSpec, R.attr.useCompatPadding}, r110, R.style.Widget_Design_FloatingActionButton, new int[0]);
        this.backgroundTint = MaterialResources.getColorStateList(r100, r102, 0);
        this.backgroundTintMode = ViewUtils.parseTintMode(r102.getInt(1, -1), null);
        this.rippleColor = MaterialResources.getColorStateList(r100, r102, 10);
        this.size = r102.getInt(5, -1);
        this.customSize = r102.getDimensionPixelSize(4, 0);
        this.borderWidth = r102.getDimensionPixelSize(2, 0);
        float r103 = r102.getDimension(3, 0.0f);
        float r104 = r102.getDimension(7, 0.0f);
        float r105 = r102.getDimension(9, 0.0f);
        this.compatPadding = r102.getBoolean(12, false);
        this.maxImageSize = r102.getDimensionPixelSize(8, 0);
        MotionSpec r106 = MotionSpec.createFromAttribute(r100, r102, 11);
        MotionSpec r107 = MotionSpec.createFromAttribute(r100, r102, 6);
        r102.recycle();
        AppCompatImageHelper r108 = new AppCompatImageHelper(this);
        this.imageHelper = r108;
        r108.loadFromAttributes(r101, r110);
        this.expandableWidgetHelper = new ExpandableWidgetHelper(this);
        getImpl().setBackgroundDrawable(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        getImpl().setElevation(r103);
        getImpl().setHoveredFocusedTranslationZ(r104);
        getImpl().setPressedTranslationZ(r105);
        getImpl().setMaxImageSize(this.maxImageSize);
        getImpl().setShowMotionSpec(r106);
        getImpl().setHideMotionSpec(r107);
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
