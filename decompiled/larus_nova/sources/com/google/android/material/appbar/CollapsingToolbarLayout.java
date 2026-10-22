package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes23.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    final CollapsingTextHelper collapsingTextHelper;
    private boolean collapsingTitleEnabled;
    private Drawable contentScrim;
    int currentOffset;
    private boolean drawCollapsingTitle;
    private View dummyView;
    private int expandedMarginBottom;
    private int expandedMarginEnd;
    private int expandedMarginStart;
    private int expandedMarginTop;
    WindowInsetsCompat lastInsets;
    private AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
    private boolean refreshToolbar;
    private int scrimAlpha;
    private long scrimAnimationDuration;
    private ValueAnimator scrimAnimator;
    private int scrimVisibleHeightTrigger;
    private boolean scrimsAreShown;
    Drawable statusBarScrim;
    private final Rect tmpRect;
    private Toolbar toolbar;
    private View toolbarDirectChild;
    private int toolbarId;

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int collapseMode;
        float parallaxMult;

        public int getCollapseMode() {
            return this.collapseMode;
        }

        public float getParallaxMultiplier() {
            return this.parallaxMult;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public void setCollapseMode(int r100) {
            this.collapseMode = r100;
        }

        public void setParallaxMultiplier(float r100) {
            this.parallaxMult = r100;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(FrameLayout.LayoutParams r100) {
            super(r100);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.layout_collapseMode, R.attr.layout_collapseParallaxMultiplier});
            this.collapseMode = r102.getInt(0, 0);
            setParallaxMultiplier(r102.getFloat(1, 0.5f));
            r102.recycle();
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(int r100, int r101, int r102) {
            super(r100, r101, r102);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }
    }

    public class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        final /* synthetic */ CollapsingToolbarLayout this$0;

        public OffsetUpdateListener(CollapsingToolbarLayout r100) {
            this.this$0 = r100;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout r100, int r110) {
            CollapsingToolbarLayout r101 = this.this$0;
            r101.currentOffset = r110;
            WindowInsetsCompat r102 = r101.lastInsets;
            if (r102 == null) goto L5;
            int r103 = r102.getSystemWindowInsetTop();
        L6:
            int r104 = this.this$0.getChildCount();
            int r105 = 0;
        L7:
            if (r105 >= r104) goto L16;
            View r106 = this.this$0.getChildAt(r105);
            LayoutParams r107 = (LayoutParams) r106.getLayoutParams();
            ViewOffsetHelper r108 = CollapsingToolbarLayout.getViewOffsetHelper(r106);
            int r109 = r107.collapseMode;
            if (r109 != 1) goto L11;
            r108.setTopAndBottomOffset(MathUtils.clamp(-r110, 0, this.this$0.getMaxOffsetForPinChild(r106)));
        L15:
            r105 = r105 + 1;
            goto L7
        L11:
            if (r109 != 2) goto L15;
            r108.setTopAndBottomOffset(Math.round((-r110) * r107.parallaxMult));
            goto L15
        L16:
            this.this$0.updateScrimVisibility();
            CollapsingToolbarLayout r111 = this.this$0;
            if (r111.statusBarScrim == null) goto L20;
            if (r103 <= 0) goto L20;
            ViewCompat.postInvalidateOnAnimation(r111);
        L20:
            this.this$0.collapsingTextHelper.setExpansionFraction(Math.abs(r110) / ((this.this$0.getHeight() - ViewCompat.getMinimumHeight(this.this$0)) - r103));
            return;
        L5:
            r103 = 0;
            goto L6
        }
    }

    private void ensureToolbar() {
        if (this.refreshToolbar == true) goto L5;
        return;
    L5:
        Toolbar r100 = null;
        this.toolbar = null;
        this.toolbarDirectChild = null;
        int r101 = this.toolbarId;
        if (r101 == (-1)) goto L11;
        Toolbar r102 = (Toolbar) findViewById(r101);
        this.toolbar = r102;
        if (r102 == null) goto L11;
        this.toolbarDirectChild = findDirectChild(r102);
    L11:
        if (this.toolbar != null) goto L19;
        int r103 = getChildCount();
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L18;
        View r105 = getChildAt(r104);
        if ((r105 instanceof Toolbar) == true) goto L16;
        r104 = r104 + 1;
        goto L13
    L16:
        r100 = (Toolbar) r105;
    L18:
        this.toolbar = r100;
    L19:
        updateDummyView();
        this.refreshToolbar = false;
    }

    private void updateDummyView() {
        if (this.collapsingTitleEnabled == true) goto L10;
        View r100 = this.dummyView;
        if (r100 == null) goto L10;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L10;
        ((ViewGroup) r101).removeView(this.dummyView);
    L10:
        if (this.collapsingTitleEnabled == true) goto L12;
        return;
    L12:
        if (this.toolbar != null) goto L14;
        return;
    L14:
        if (this.dummyView != null) goto L17;
        this.dummyView = new View(getContext());
    L17:
        if (this.dummyView.getParent() != null) goto L22;
        this.toolbar.addView(this.dummyView, -1, -1);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public int getCollapsedTitleGravity() {
        return this.collapsingTextHelper.getCollapsedTextGravity();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.collapsingTextHelper.getCollapsedTypeface();
    }

    public int getExpandedTitleGravity() {
        return this.collapsingTextHelper.getExpandedTextGravity();
    }

    public Typeface getExpandedTitleTypeface() {
        return this.collapsingTextHelper.getExpandedTypeface();
    }

    public int getScrimVisibleHeightTrigger() {
        int r100 = this.scrimVisibleHeightTrigger;
        if (r100 < 0) goto L5;
        return r100;
    L5:
        WindowInsetsCompat r101 = this.lastInsets;
        if (r101 == null) goto L8;
        int r102 = r101.getSystemWindowInsetTop();
    L9:
        int r103 = ViewCompat.getMinimumHeight(this);
        if (r103 <= 0) goto L14;
        return Math.min((r103 * 2) + r102, getHeight());
    L14:
        return getHeight() / 3;
    L8:
        r102 = 0;
        goto L9
    }

    public CharSequence getTitle() {
        if (this.collapsingTitleEnabled == true) goto L7;
        return null;
    L7:
        return this.collapsingTextHelper.getText();
    }

    public final void updateScrimVisibility() {
        if (this.contentScrim != null) goto L7;
        if (this.statusBarScrim != null) goto L7;
        return;
    L7:
        if ((getHeight() + this.currentOffset) >= getScrimVisibleHeightTrigger()) goto L9;
        boolean r100 = true;
    L10:
        setScrimsShown(r100);
        return;
    L9:
        r100 = false;
        goto L10
    }

    private void updateContentDescriptionFromTitle() {
        setContentDescription(getTitle());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r100 = getDrawableState();
        Drawable r101 = this.statusBarScrim;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        Drawable r103 = this.contentScrim;
        if (r103 != null) goto L10;
    L12:
        CollapsingTextHelper r104 = this.collapsingTextHelper;
        if (r104 == null) goto L15;
        r102 = r102 | r104.setState(r100);
    L15:
        if (r102 == false) goto L18;
        invalidate();
        return;
    L18:
        return;
    L10:
        if (r103.isStateful() == false) goto L12;
        r102 = r102 | r103.setState(r100);
        goto L12
    L5:
        if (r101.isStateful() == false) goto L7;
        r102 = false | r101.setState(r100);
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object r100 = getParent();
        if ((r100 instanceof AppBarLayout) == false) goto L9;
        ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) r100));
        if (this.onOffsetChangedListener != null) goto L7;
        this.onOffsetChangedListener = new OffsetUpdateListener(this);
    L7:
        ((AppBarLayout) r100).addOnOffsetChangedListener(this.onOffsetChangedListener);
        ViewCompat.requestApplyInsets(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent r100 = getParent();
        AppBarLayout.OnOffsetChangedListener r101 = this.onOffsetChangedListener;
        if (r101 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if ((r100 instanceof AppBarLayout) == false) goto L7;
        ((AppBarLayout) r100).removeOnOffsetChangedListener(r101);
        goto L7
    }

    public Drawable getContentScrim() {
        return this.contentScrim;
    }

    public int getExpandedTitleMarginBottom() {
        return this.expandedMarginBottom;
    }

    public int getExpandedTitleMarginEnd() {
        return this.expandedMarginEnd;
    }

    public int getExpandedTitleMarginStart() {
        return this.expandedMarginStart;
    }

    public int getExpandedTitleMarginTop() {
        return this.expandedMarginTop;
    }

    public int getScrimAlpha() {
        return this.scrimAlpha;
    }

    public long getScrimAnimationDuration() {
        return this.scrimAnimationDuration;
    }

    public Drawable getStatusBarScrim() {
        return this.statusBarScrim;
    }

    public boolean isTitleEnabled() {
        return this.collapsingTitleEnabled;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public CollapsingToolbarLayout(Context r100) {
        this(r100, null);
    }

    private void animateScrim(int r100) {
        ensureToolbar();
        ValueAnimator r101 = this.scrimAnimator;
        if (r101 != null) goto L10;
        ValueAnimator r102 = new ValueAnimator();
        this.scrimAnimator = r102;
        r102.setDuration(this.scrimAnimationDuration);
        ValueAnimator r103 = this.scrimAnimator;
        if (r100 <= this.scrimAlpha) goto L7;
        TimeInterpolator r104 = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    L8:
        r103.setInterpolator(r104);
        this.scrimAnimator.addUpdateListener(new AnonymousClass2(this));
    L12:
        this.scrimAnimator.setIntValues(new int[]{this.scrimAlpha, r100});
        this.scrimAnimator.start();
        return;
    L7:
        r104 = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
        goto L8
    L10:
        if (r101.isRunning() == false) goto L12;
        this.scrimAnimator.cancel();
        goto L12
    }

    private View findDirectChild(View r100) {
        ViewParent r101 = r100.getParent();
    L3:
        if (r101 == this) goto L9;
        if (r101 == null) goto L9;
        if ((r101 instanceof View) == false) goto L8;
        r100 = r101;
    L8:
        r101 = r101.getParent();
    L9:
        return r100;
    }

    private static int getHeightWithMargins(View r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        return (r100.getHeight() + r102.topMargin) + r102.bottomMargin;
    L7:
        return r100.getHeight();
    }

    public static ViewOffsetHelper getViewOffsetHelper(View r100) {
        ViewOffsetHelper r101 = (ViewOffsetHelper) r100.getTag(R.id.view_offset_helper);
        if (r101 != null) goto L6;
        ViewOffsetHelper r102 = new ViewOffsetHelper(r100);
        r100.setTag(R.id.view_offset_helper, r102);
        return r102;
    L6:
        return r101;
    }

    private boolean isToolbarChild(View r100) {
        View r101 = this.toolbarDirectChild;
        if (r101 == null) goto L9;
        if (r101 == this) goto L9;
        if (r100 == r101) goto L13;
    L11:
        return false;
    L13:
        return true;
    L9:
        if (r100 != this.toolbar) goto L11;
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        super.draw(r100);
        ensureToolbar();
        if (this.toolbar != null) goto L10;
        Drawable r101 = this.contentScrim;
        if (r101 == null) goto L10;
        if (this.scrimAlpha <= 0) goto L10;
        r101.mutate().setAlpha(this.scrimAlpha);
        this.contentScrim.draw(r100);
    L10:
        if (this.collapsingTitleEnabled == false) goto L15;
        if (this.drawCollapsingTitle == false) goto L15;
        this.collapsingTextHelper.draw(r100);
    L15:
        if (this.statusBarScrim != null) goto L17;
        return;
    L17:
        if (this.scrimAlpha <= 0) goto L26;
        WindowInsetsCompat r102 = this.lastInsets;
        if (r102 == null) goto L21;
        int r103 = r102.getSystemWindowInsetTop();
    L22:
        if (r103 <= 0) goto L27;
        this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), r103 - this.currentOffset);
        this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
        this.statusBarScrim.draw(r100);
        return;
    L27:
        return;
    L21:
        r103 = 0;
        goto L22
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public final int getMaxOffsetForPinChild(View r100) {
        ViewOffsetHelper r101 = getViewOffsetHelper(r100);
        LayoutParams r102 = (LayoutParams) r100.getLayoutParams();
        return ((getHeight() - r101.getLayoutTop()) - r100.getHeight()) - ((FrameLayout.LayoutParams) r102).bottomMargin;
    }

    public WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat r100) {
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L5;
        WindowInsetsCompat r101 = r100;
    L7:
        if (ObjectsCompat.equals(this.lastInsets, r101) == true) goto L10;
        this.lastInsets = r101;
        requestLayout();
    L10:
        return r100.consumeSystemWindowInsets();
    L5:
        r101 = null;
        goto L7
    }

    public void setCollapsedTitleGravity(int r100) {
        this.collapsingTextHelper.setCollapsedTextGravity(r100);
    }

    public void setCollapsedTitleTextAppearance(int r100) {
        this.collapsingTextHelper.setCollapsedTextAppearance(r100);
    }

    public void setCollapsedTitleTextColor(int r100) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(r100));
    }

    public void setCollapsedTitleTypeface(Typeface r100) {
        this.collapsingTextHelper.setCollapsedTypeface(r100);
    }

    public void setContentScrim(Drawable r100) {
        Drawable r101 = this.contentScrim;
        if (r101 == r100) goto L14;
        Drawable r102 = null;
        if (r101 == null) goto L7;
        r101.setCallback(null);
    L7:
        if (r100 == null) goto L9;
        r102 = r100.mutate();
    L9:
        this.contentScrim = r102;
        if (r102 == null) goto L12;
        r102.setBounds(0, 0, getWidth(), getHeight());
        this.contentScrim.setCallback(this);
        this.contentScrim.setAlpha(this.scrimAlpha);
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public void setContentScrimColor(int r100) {
        setContentScrim(new ColorDrawable(r100));
    }

    public void setContentScrimResource(int r100) {
        setContentScrim(ContextCompat.getDrawable(getContext(), r100));
    }

    public void setExpandedTitleColor(int r100) {
        setExpandedTitleTextColor(ColorStateList.valueOf(r100));
    }

    public void setExpandedTitleGravity(int r100) {
        this.collapsingTextHelper.setExpandedTextGravity(r100);
    }

    public void setExpandedTitleMarginBottom(int r100) {
        this.expandedMarginBottom = r100;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int r100) {
        this.expandedMarginEnd = r100;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int r100) {
        this.expandedMarginStart = r100;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int r100) {
        this.expandedMarginTop = r100;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int r100) {
        this.collapsingTextHelper.setExpandedTextAppearance(r100);
    }

    public void setExpandedTitleTextColor(ColorStateList r100) {
        this.collapsingTextHelper.setExpandedTextColor(r100);
    }

    public void setExpandedTitleTypeface(Typeface r100) {
        this.collapsingTextHelper.setExpandedTypeface(r100);
    }

    public void setScrimAlpha(int r100) {
        if (r100 != this.scrimAlpha) goto L5;
        return;
    L5:
        if (this.contentScrim == null) goto L9;
        Toolbar r101 = this.toolbar;
        if (r101 == null) goto L9;
        ViewCompat.postInvalidateOnAnimation(r101);
    L9:
        this.scrimAlpha = r100;
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setScrimAnimationDuration(long r100) {
        this.scrimAnimationDuration = r100;
    }

    public void setScrimVisibleHeightTrigger(int r100) {
        if (this.scrimVisibleHeightTrigger == r100) goto L6;
        this.scrimVisibleHeightTrigger = r100;
        updateScrimVisibility();
        return;
    }

    public void setScrimsShown(boolean r100) {
        if (ViewCompat.isLaidOut(this) == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        setScrimsShown(r100, r101);
        return;
    L5:
        if (isInEditMode() == true) goto L7;
        r101 = true;
        goto L8
    }

    public void setStatusBarScrim(Drawable r100) {
        Drawable r101 = this.statusBarScrim;
        if (r101 == r100) goto L21;
        Drawable r102 = null;
        if (r101 == null) goto L7;
        r101.setCallback(null);
    L7:
        if (r100 == null) goto L9;
        r102 = r100.mutate();
    L9:
        this.statusBarScrim = r102;
        if (r102 != null) goto L12;
    L19:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        if (r102.isStateful() == false) goto L14;
        this.statusBarScrim.setState(getDrawableState());
    L14:
        DrawableCompat.setLayoutDirection(this.statusBarScrim, ViewCompat.getLayoutDirection(this));
        Drawable r103 = this.statusBarScrim;
        if (getVisibility() != 0) goto L17;
        boolean r104 = true;
    L18:
        r103.setVisible(r104, false);
        this.statusBarScrim.setCallback(this);
        this.statusBarScrim.setAlpha(this.scrimAlpha);
        goto L19
    L17:
        r104 = false;
        goto L18
    }

    public void setStatusBarScrimColor(int r100) {
        setStatusBarScrim(new ColorDrawable(r100));
    }

    public void setStatusBarScrimResource(int r100) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), r100));
    }

    public void setTitle(CharSequence r100) {
        this.collapsingTextHelper.setText(r100);
        updateContentDescriptionFromTitle();
    }

    public void setTitleEnabled(boolean r100) {
        if (r100 == this.collapsingTitleEnabled) goto L6;
        this.collapsingTitleEnabled = r100;
        updateContentDescriptionFromTitle();
        updateDummyView();
        requestLayout();
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        boolean r101 = true;
    L6:
        Drawable r102 = this.statusBarScrim;
        if (r102 != null) goto L9;
    L11:
        Drawable r103 = this.contentScrim;
        if (r103 != null) goto L14;
        return;
    L14:
        if (r103.isVisible() == r101) goto L18;
        this.contentScrim.setVisible(r101, false);
        return;
    L18:
        return;
    L9:
        if (r102.isVisible() == r101) goto L11;
        this.statusBarScrim.setVisible(r101, false);
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r100) {
        if (super.verifyDrawable(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (r100 == this.contentScrim) goto L10;
        if (r100 == this.statusBarScrim) goto L10;
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new LayoutParams(r100);
    }

    public void setCollapsedTitleTextColor(ColorStateList r100) {
        this.collapsingTextHelper.setCollapsedTextColor(r100);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateLayoutParams(r100);
    }

    public CollapsingToolbarLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        ensureToolbar();
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getMode(r101);
        WindowInsetsCompat r103 = this.lastInsets;
        if (r103 == null) goto L5;
        int r104 = r103.getSystemWindowInsetTop();
    L6:
        if (r102 != 0) goto L10;
        if (r104 <= 0) goto L11;
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + r104, 1073741824));
        return;
    L11:
        return;
    L10:
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public void setScrimsShown(boolean r100, boolean r101) {
        if (this.scrimsAreShown == r100) goto L16;
        int r102 = 255;
        if (r101 == false) goto L10;
        if (r100 == true) goto L9;
        r102 = 0;
    L9:
        animateScrim(r102);
    L14:
        this.scrimsAreShown = r100;
        return;
    L10:
        if (r100 == true) goto L13;
        r102 = 0;
    L13:
        setScrimAlpha(r102);
        goto L14
    }

    public CollapsingToolbarLayout(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.refreshToolbar = true;
        this.tmpRect = new Rect();
        this.scrimVisibleHeightTrigger = -1;
        CollapsingTextHelper r100 = new CollapsingTextHelper(this);
        this.collapsingTextHelper = r100;
        r100.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        TypedArray r113 = ThemeEnforcement.obtainStyledAttributes(r110, r111, new int[]{R.attr.collapsedTitleGravity, R.attr.collapsedTitleTextAppearance, R.attr.contentScrim, R.attr.expandedTitleGravity, R.attr.expandedTitleMargin, R.attr.expandedTitleMarginBottom, R.attr.expandedTitleMarginEnd, R.attr.expandedTitleMarginStart, R.attr.expandedTitleMarginTop, R.attr.expandedTitleTextAppearance, R.attr.scrimAnimationDuration, R.attr.scrimVisibleHeightTrigger, R.attr.statusBarScrim, R.attr.title, R.attr.titleEnabled, R.attr.toolbarId}, r112, R.style.Widget_Design_CollapsingToolbar, new int[0]);
        r100.setExpandedTextGravity(r113.getInt(3, 8388691));
        r100.setCollapsedTextGravity(r113.getInt(0, 8388627));
        int r114 = r113.getDimensionPixelSize(4, 0);
        this.expandedMarginBottom = r114;
        this.expandedMarginEnd = r114;
        this.expandedMarginTop = r114;
        this.expandedMarginStart = r114;
        if (r113.hasValue(7) == false) goto L6;
        this.expandedMarginStart = r113.getDimensionPixelSize(7, 0);
    L6:
        if (r113.hasValue(6) == false) goto L9;
        this.expandedMarginEnd = r113.getDimensionPixelSize(6, 0);
    L9:
        if (r113.hasValue(8) == false) goto L12;
        this.expandedMarginTop = r113.getDimensionPixelSize(8, 0);
    L12:
        if (r113.hasValue(5) == false) goto L14;
        this.expandedMarginBottom = r113.getDimensionPixelSize(5, 0);
    L14:
        this.collapsingTitleEnabled = r113.getBoolean(14, true);
        setTitle(r113.getText(13));
        r100.setExpandedTextAppearance(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        r100.setCollapsedTextAppearance(R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (r113.hasValue(9) == false) goto L18;
        r100.setExpandedTextAppearance(r113.getResourceId(9, 0));
    L18:
        if (r113.hasValue(1) == false) goto L20;
        r100.setCollapsedTextAppearance(r113.getResourceId(1, 0));
    L20:
        this.scrimVisibleHeightTrigger = r113.getDimensionPixelSize(11, -1);
        this.scrimAnimationDuration = r113.getInt(10, 600);
        setContentScrim(r113.getDrawable(2));
        setStatusBarScrim(r113.getDrawable(12));
        this.toolbarId = r113.getResourceId(15, -1);
        r113.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r100, View r101, long r102) {
        if (this.contentScrim != null) goto L5;
    L9:
        boolean r103 = false;
    L11:
        if (super.drawChild(r100, r101, r102) == true) goto L16;
        if (r103 == true) goto L17;
        return false;
    L17:
        return true;
    L16:
        return true;
    L5:
        if (this.scrimAlpha <= 0) goto L9;
        if (isToolbarChild(r101) == false) goto L9;
        this.contentScrim.mutate().setAlpha(this.scrimAlpha);
        this.contentScrim.draw(r100);
        r103 = true;
        goto L11
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        Drawable r104 = this.contentScrim;
        if (r104 == null) goto L6;
        r104.setBounds(0, 0, r100, r101);
        return;
    }

    public void setExpandedTitleMargin(int r100, int r101, int r102, int r103) {
        this.expandedMarginStart = r100;
        this.expandedMarginTop = r101;
        this.expandedMarginEnd = r102;
        this.expandedMarginBottom = r103;
        requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r110, int r111, int r112) {
        super.onLayout(r100, r101, r110, r111, r112);
        WindowInsetsCompat r102 = this.lastInsets;
        int r103 = 0;
        if (r102 == null) goto L13;
        int r104 = r102.getSystemWindowInsetTop();
        int r105 = getChildCount();
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L13;
        View r107 = getChildAt(r106);
        if (ViewCompat.getFitsSystemWindows(r107) == true) goto L11;
        if (r107.getTop() >= r104) goto L11;
        ViewCompat.offsetTopAndBottom(r107, r104);
    L11:
        r106 = r106 + 1;
    L13:
        if (this.collapsingTitleEnabled == false) goto L49;
        View r108 = this.dummyView;
        if (r108 == null) goto L49;
        boolean r109 = true;
        if (ViewCompat.isAttachedToWindow(r108) == true) goto L19;
    L21:
        boolean r113 = false;
    L22:
        this.drawCollapsingTitle = r113;
        if (r113 == false) goto L49;
        if (ViewCompat.getLayoutDirection(this) == 1) goto L28;
        r109 = false;
    L28:
        View r114 = this.toolbarDirectChild;
        if (r114 != null) goto L32;
        r114 = this.toolbar;
    L32:
        int r115 = getMaxOffsetForPinChild(r114);
        DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
        CollapsingTextHelper r116 = this.collapsingTextHelper;
        int r117 = this.tmpRect.left;
        if (r109 == false) goto L35;
        int r118 = this.toolbar.getTitleMarginEnd();
    L36:
        int r119 = r117 + r118;
        int r120 = (this.tmpRect.top + r115) + this.toolbar.getTitleMarginTop();
        int r121 = this.tmpRect.right;
        if (r109 == false) goto L39;
        int r122 = this.toolbar.getTitleMarginStart();
    L40:
        r116.setCollapsedBounds(r119, r120, r121 + r122, (this.tmpRect.bottom + r115) - this.toolbar.getTitleMarginBottom());
        CollapsingTextHelper r123 = this.collapsingTextHelper;
        if (r109 == false) goto L43;
        int r124 = this.expandedMarginEnd;
    L44:
        int r125 = this.tmpRect.top + this.expandedMarginTop;
        int r126 = r111 - r101;
        if (r109 == false) goto L47;
        int r127 = this.expandedMarginStart;
    L48:
        r123.setExpandedBounds(r124, r125, r126 - r127, (r112 - r110) - this.expandedMarginBottom);
        this.collapsingTextHelper.recalculate();
        goto L49
    L47:
        r127 = this.expandedMarginEnd;
        goto L48
    L43:
        r124 = this.expandedMarginStart;
        goto L44
    L39:
        r122 = this.toolbar.getTitleMarginEnd();
        goto L40
    L35:
        r118 = this.toolbar.getTitleMarginStart();
        goto L36
    L19:
        if (this.dummyView.getVisibility() != 0) goto L21;
        r113 = true;
    L49:
        int r128 = getChildCount();
    L50:
        if (r103 >= r128) goto L53;
        getViewOffsetHelper(getChildAt(r103)).onViewLayout();
        r103 = r103 + 1;
        goto L50
    L53:
        if (this.toolbar != null) goto L55;
    L65:
        updateScrimVisibility();
        return;
    L55:
        if (this.collapsingTitleEnabled == true) goto L57;
    L59:
        View r129 = this.toolbarDirectChild;
        if (r129 == null) goto L64;
        if (r129 == this) goto L64;
        setMinimumHeight(getHeightWithMargins(r129));
    L64:
        setMinimumHeight(getHeightWithMargins(this.toolbar));
        goto L65
    L57:
        if (TextUtils.isEmpty(this.collapsingTextHelper.getText()) == false) goto L59;
        setTitle(this.toolbar.getTitle());
        goto L59
    }
}
