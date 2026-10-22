package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.CircularBorderDrawable;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.android.material.shadow.ShadowViewDelegate;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
class FloatingActionButtonImpl {
    static final int ANIM_STATE_HIDING = 1;
    static final int ANIM_STATE_NONE = 0;
    static final int ANIM_STATE_SHOWING = 2;
    static final long ELEVATION_ANIM_DELAY = 100;
    static final long ELEVATION_ANIM_DURATION = 100;
    static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = null;
    static final int[] EMPTY_STATE_SET = null;
    static final int[] ENABLED_STATE_SET = null;
    static final int[] FOCUSED_ENABLED_STATE_SET = null;
    private static final float HIDE_ICON_SCALE = 0.0f;
    private static final float HIDE_OPACITY = 0.0f;
    private static final float HIDE_SCALE = 0.0f;
    static final int[] HOVERED_ENABLED_STATE_SET = null;
    static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = null;
    static final int[] PRESSED_ENABLED_STATE_SET = null;
    private static final float SHOW_ICON_SCALE = 1.0f;
    private static final float SHOW_OPACITY = 1.0f;
    private static final float SHOW_SCALE = 1.0f;
    int animState;
    CircularBorderDrawable borderDrawable;
    Drawable contentBackground;
    Animator currentAnimator;
    private MotionSpec defaultHideMotionSpec;
    private MotionSpec defaultShowMotionSpec;
    float elevation;
    private ArrayList<Animator.AnimatorListener> hideListeners;
    MotionSpec hideMotionSpec;
    float hoveredFocusedTranslationZ;
    float imageMatrixScale;
    int maxImageSize;
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    float pressedTranslationZ;
    Drawable rippleDrawable;
    private float rotation;
    ShadowDrawableWrapper shadowDrawable;
    final ShadowViewDelegate shadowViewDelegate;
    Drawable shapeDrawable;
    private ArrayList<Animator.AnimatorListener> showListeners;
    MotionSpec showMotionSpec;
    private final StateListAnimator stateListAnimator;
    private final Matrix tmpMatrix;
    private final Rect tmpRect;
    private final RectF tmpRectF1;
    private final RectF tmpRectF2;
    final VisibilityAwareImageButton view;

    public class DisabledElevationAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            return 0.0f;
        }

        public DisabledElevationAnimation(FloatingActionButtonImpl r100) {
            this.this$0 = r100;
            super(r100, null);
        }
    }

    public class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            FloatingActionButtonImpl r100 = this.this$0;
            return r100.elevation + r100.hoveredFocusedTranslationZ;
        }

        public ElevateToHoveredFocusedTranslationZAnimation(FloatingActionButtonImpl r100) {
            this.this$0 = r100;
            super(r100, null);
        }
    }

    public class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            FloatingActionButtonImpl r100 = this.this$0;
            return r100.elevation + r100.pressedTranslationZ;
        }

        public ElevateToPressedTranslationZAnimation(FloatingActionButtonImpl r100) {
            this.this$0 = r100;
            super(r100, null);
        }
    }

    public interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    public class ResetElevationAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            return this.this$0.elevation;
        }

        public ResetElevationAnimation(FloatingActionButtonImpl r100) {
            this.this$0 = r100;
            super(r100, null);
        }
    }

    public abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private float shadowSizeEnd;
        private float shadowSizeStart;
        final /* synthetic */ FloatingActionButtonImpl this$0;
        private boolean validValues;

        public abstract float getTargetShadowSize();

        private ShadowAnimatorImpl(FloatingActionButtonImpl r100) {
            this.this$0 = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            this.this$0.shadowDrawable.setShadowSize(this.shadowSizeEnd);
            this.validValues = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r100) {
            if (this.validValues == true) goto L5;
            this.shadowSizeStart = this.this$0.shadowDrawable.getShadowSize();
            this.shadowSizeEnd = getTargetShadowSize();
            this.validValues = true;
        L5:
            ShadowDrawableWrapper r101 = this.this$0.shadowDrawable;
            float r102 = this.shadowSizeStart;
            r101.setShadowSize(r102 + ((this.shadowSizeEnd - r102) * r100.getAnimatedFraction()));
        }

        public /* synthetic */ ShadowAnimatorImpl(FloatingActionButtonImpl r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public void onCompatShadowChanged() {
    }

    public void onPaddingUpdated(Rect r100) {
    }

    public boolean requirePreDrawListener() {
        return true;
    }

    static {
        ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
        PRESSED_ENABLED_STATE_SET = new int[]{R.attr.state_pressed, R.attr.state_enabled};
        HOVERED_FOCUSED_ENABLED_STATE_SET = new int[]{R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
        FOCUSED_ENABLED_STATE_SET = new int[]{R.attr.state_focused, R.attr.state_enabled};
        HOVERED_ENABLED_STATE_SET = new int[]{R.attr.state_hovered, R.attr.state_enabled};
        ENABLED_STATE_SET = new int[]{R.attr.state_enabled};
        EMPTY_STATE_SET = new int[0];
    }

    private void ensurePreDrawListener() {
        if (this.preDrawListener != null) goto L6;
        this.preDrawListener = new AnonymousClass3(this);
        return;
    }

    private MotionSpec getDefaultHideMotionSpec() {
        if (this.defaultHideMotionSpec != null) goto L6;
        this.defaultHideMotionSpec = MotionSpec.createFromResource(this.view.getContext(), com.larus.nova.R.animator.design_fab_hide_motion_spec);
    L6:
        return this.defaultHideMotionSpec;
    }

    private MotionSpec getDefaultShowMotionSpec() {
        if (this.defaultShowMotionSpec != null) goto L6;
        this.defaultShowMotionSpec = MotionSpec.createFromResource(this.view.getContext(), com.larus.nova.R.animator.design_fab_show_motion_spec);
    L6:
        return this.defaultShowMotionSpec;
    }

    private boolean shouldAnimateVisibilityChange() {
        if (ViewCompat.isLaidOut(this.view) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.view.isInEditMode() == true) goto L7;
        return true;
    }

    private void updateFromViewRotation() {
        ShadowDrawableWrapper r100 = this.shadowDrawable;
        if (r100 == null) goto L5;
        r100.setRotation(-this.rotation);
    L5:
        CircularBorderDrawable r101 = this.borderDrawable;
        if (r101 == null) goto L9;
        r101.setRotation(-this.rotation);
        return;
    }

    public boolean isOrWillBeHidden() {
        if (this.view.getVisibility() != 0) goto L9;
        if (this.animState != 1) goto L12;
        return true;
    L12:
        return false;
    L9:
        if (this.animState == 2) goto L13;
        return true;
    L13:
        return false;
    }

    public boolean isOrWillBeShown() {
        if (this.view.getVisibility() == 0) goto L9;
        if (this.animState != 2) goto L12;
        return true;
    L12:
        return false;
    L9:
        if (this.animState == 1) goto L13;
        return true;
    L13:
        return false;
    }

    public void jumpDrawableToCurrentState() {
        this.stateListAnimator.jumpToCurrentState();
    }

    public CircularBorderDrawable newCircularDrawable() {
        return new CircularBorderDrawable();
    }

    public GradientDrawable newGradientDrawableForShape() {
        return new GradientDrawable();
    }

    public void onDetachedFromWindow() {
        if (this.preDrawListener == null) goto L6;
        this.view.getViewTreeObserver().removeOnPreDrawListener(this.preDrawListener);
        this.preDrawListener = null;
        return;
    }

    public void onPreDraw() {
        float r100 = this.view.getRotation();
        if (this.rotation == r100) goto L6;
        this.rotation = r100;
        updateFromViewRotation();
        return;
    }

    public final void updateImageMatrixScale() {
        setImageMatrixScale(this.imageMatrixScale);
    }

    public final void updatePadding() {
        Rect r100 = this.tmpRect;
        getPadding(r100);
        onPaddingUpdated(r100);
        this.shadowViewDelegate.setShadowPadding(r100.left, r100.top, r100.right, r100.bottom);
    }

    public GradientDrawable createShapeDrawable() {
        GradientDrawable r100 = newGradientDrawableForShape();
        r100.setShape(1);
        r100.setColor(-1);
        return r100;
    }

    public void onAttachedToWindow() {
        if (requirePreDrawListener() == false) goto L6;
        ensurePreDrawListener();
        this.view.getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
        return;
    }

    public final Drawable getContentBackground() {
        return this.contentBackground;
    }

    public float getElevation() {
        return this.elevation;
    }

    public final MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getHoveredFocusedTranslationZ() {
        return this.hoveredFocusedTranslationZ;
    }

    public float getPressedTranslationZ() {
        return this.pressedTranslationZ;
    }

    public final MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    private ValueAnimator createElevationAnimator(ShadowAnimatorImpl r100) {
        ValueAnimator r101 = new ValueAnimator();
        r101.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        r101.setDuration(100);
        r101.addListener(r100);
        r101.addUpdateListener(r100);
        r101.setFloatValues(new float[]{0.0f, 1.0f});
        return r101;
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener r100) {
        if (this.hideListeners != null) goto L5;
        this.hideListeners = new ArrayList();
    L5:
        this.hideListeners.add(r100);
    }

    public void addOnShowAnimationListener(Animator.AnimatorListener r100) {
        if (this.showListeners != null) goto L5;
        this.showListeners = new ArrayList();
    L5:
        this.showListeners.add(r100);
    }

    public void getPadding(Rect r100) {
        this.shadowDrawable.getPadding(r100);
    }

    public void onDrawableStateChanged(int[] r100) {
        this.stateListAnimator.setState(r100);
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener r100) {
        ArrayList<Animator.AnimatorListener> r101 = this.hideListeners;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.remove(r100);
    }

    public void removeOnShowAnimationListener(Animator.AnimatorListener r100) {
        ArrayList<Animator.AnimatorListener> r101 = this.showListeners;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.remove(r100);
    }

    public void setBackgroundTintList(ColorStateList r100) {
        Drawable r101 = this.shapeDrawable;
        if (r101 == null) goto L5;
        DrawableCompat.setTintList(r101, r100);
    L5:
        CircularBorderDrawable r102 = this.borderDrawable;
        if (r102 == null) goto L9;
        r102.setBorderTint(r100);
        return;
    }

    public void setBackgroundTintMode(PorterDuff.Mode r100) {
        Drawable r101 = this.shapeDrawable;
        if (r101 == null) goto L6;
        DrawableCompat.setTintMode(r101, r100);
        return;
    }

    public final void setElevation(float r100) {
        if (this.elevation == r100) goto L6;
        this.elevation = r100;
        onElevationsChanged(r100, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        return;
    }

    public final void setHideMotionSpec(MotionSpec r100) {
        this.hideMotionSpec = r100;
    }

    public final void setHoveredFocusedTranslationZ(float r100) {
        if (this.hoveredFocusedTranslationZ == r100) goto L6;
        this.hoveredFocusedTranslationZ = r100;
        onElevationsChanged(this.elevation, r100, this.pressedTranslationZ);
        return;
    }

    public final void setImageMatrixScale(float r100) {
        this.imageMatrixScale = r100;
        Matrix r101 = this.tmpMatrix;
        calculateImageMatrixFromScale(r100, r101);
        this.view.setImageMatrix(r101);
    }

    public final void setMaxImageSize(int r100) {
        if (this.maxImageSize == r100) goto L6;
        this.maxImageSize = r100;
        updateImageMatrixScale();
        return;
    }

    public final void setPressedTranslationZ(float r100) {
        if (this.pressedTranslationZ == r100) goto L6;
        this.pressedTranslationZ = r100;
        onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, r100);
        return;
    }

    public void setRippleColor(ColorStateList r100) {
        Drawable r101 = this.rippleDrawable;
        if (r101 == null) goto L6;
        DrawableCompat.setTintList(r101, RippleUtils.convertToRippleDrawableColor(r100));
        return;
    }

    public final void setShowMotionSpec(MotionSpec r100) {
        this.showMotionSpec = r100;
    }

    public FloatingActionButtonImpl(VisibilityAwareImageButton r100, ShadowViewDelegate r101) {
        this.animState = 0;
        this.imageMatrixScale = 1.0f;
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpMatrix = new Matrix();
        this.view = r100;
        this.shadowViewDelegate = r101;
        StateListAnimator r102 = new StateListAnimator();
        this.stateListAnimator = r102;
        r102.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToPressedTranslationZAnimation(this)));
        r102.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        r102.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        r102.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        r102.addState(ENABLED_STATE_SET, createElevationAnimator(new ResetElevationAnimation(this)));
        r102.addState(EMPTY_STATE_SET, createElevationAnimator(new DisabledElevationAnimation(this)));
        this.rotation = r100.getRotation();
    }

    private void calculateImageMatrixFromScale(float r100, Matrix r101) {
        r101.reset();
        Drawable r102 = this.view.getDrawable();
        if (r102 != null) goto L5;
        return;
    L5:
        if (this.maxImageSize == 0) goto L9;
        RectF r103 = this.tmpRectF1;
        RectF r104 = this.tmpRectF2;
        r103.set(0.0f, 0.0f, r102.getIntrinsicWidth(), r102.getIntrinsicHeight());
        int r105 = this.maxImageSize;
        r104.set(0.0f, 0.0f, r105, r105);
        r101.setRectToRect(r103, r104, Matrix.ScaleToFit.CENTER);
        int r106 = this.maxImageSize;
        r101.postScale(r100, r100, r106 / 2.0f, r106 / 2.0f);
        return;
    }

    public CircularBorderDrawable createBorderDrawable(int r100, ColorStateList r101) {
        Context r102 = this.view.getContext();
        CircularBorderDrawable r103 = newCircularDrawable();
        r103.setGradientColors(ContextCompat.getColor(r102, com.larus.nova.R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(r102, com.larus.nova.R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(r102, com.larus.nova.R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(r102, com.larus.nova.R.color.design_fab_stroke_end_outer_color));
        r103.setBorderWidth(r100);
        r103.setBorderTint(r101);
        return r103;
    }

    public void hide(final InternalVisibilityChangedListener r100, final boolean r101) {
        if (isOrWillBeHidden() == false) goto L5;
        return;
    L5:
        Animator r102 = this.currentAnimator;
        if (r102 == null) goto L9;
        r102.cancel();
    L9:
        if (shouldAnimateVisibilityChange() == false) goto L21;
        MotionSpec r103 = this.hideMotionSpec;
        if (r103 != null) goto L14;
        r103 = getDefaultHideMotionSpec();
    L14:
        AnimatorSet r104 = createAnimator(r103, 0.0f, 0.0f, 0.0f);
        r104.addListener(new AnonymousClass1(this, r101, r100));
        ArrayList<Animator.AnimatorListener> r105 = this.hideListeners;
        if (r105 == null) goto L20;
        Iterator<Animator.AnimatorListener> r106 = r105.iterator();
    L18:
        if (r106.hasNext() == false) goto L20;
        r104.addListener(r106.next());
    L20:
        r104.start();
        return;
    L21:
        VisibilityAwareImageButton r107 = this.view;
        if (r101 == false) goto L24;
        int r108 = 8;
    L25:
        r107.internalSetVisibility(r108, r101);
        if (r100 == null) goto L31;
        r100.onHidden();
        return;
    L31:
        return;
    L24:
        r108 = 4;
        goto L25
    }

    public void show(final InternalVisibilityChangedListener r100, final boolean r101) {
        if (isOrWillBeShown() == false) goto L5;
        return;
    L5:
        Animator r102 = this.currentAnimator;
        if (r102 == null) goto L9;
        r102.cancel();
    L9:
        if (shouldAnimateVisibilityChange() == true) goto L11;
        this.view.internalSetVisibility(0, r101);
        this.view.setAlpha(1.0f);
        this.view.setScaleY(1.0f);
        this.view.setScaleX(1.0f);
        setImageMatrixScale(1.0f);
        if (r100 == null) goto L30;
        r100.onShown();
        return;
    L30:
        return;
    L11:
        if (this.view.getVisibility() == 0) goto L13;
        this.view.setAlpha(0.0f);
        this.view.setScaleY(0.0f);
        this.view.setScaleX(0.0f);
        setImageMatrixScale(0.0f);
    L13:
        MotionSpec r103 = this.showMotionSpec;
        if (r103 != null) goto L17;
        r103 = getDefaultShowMotionSpec();
    L17:
        AnimatorSet r104 = createAnimator(r103, 1.0f, 1.0f, 1.0f);
        r104.addListener(new AnonymousClass2(this, r101, r100));
        ArrayList<Animator.AnimatorListener> r105 = this.showListeners;
        if (r105 == null) goto L23;
        Iterator<Animator.AnimatorListener> r106 = r105.iterator();
    L21:
        if (r106.hasNext() == false) goto L23;
        r104.addListener(r106.next());
    L23:
        r104.start();
    }

    public void onElevationsChanged(float r100, float r101, float r102) {
        ShadowDrawableWrapper r103 = this.shadowDrawable;
        if (r103 == null) goto L6;
        r103.setShadowSize(r100, this.pressedTranslationZ + r100);
        updatePadding();
        return;
    }

    private AnimatorSet createAnimator(MotionSpec r100, float r101, float r102, float r110) {
        ArrayList r103 = new ArrayList();
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this.view, View.ALPHA, new float[]{r101});
        r100.getTiming(GXTemplateKey.STYLE_OPACITY).apply(r104);
        r103.add(r104);
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{r102});
        r100.getTiming("scale").apply(r105);
        r103.add(r105);
        ObjectAnimator r106 = ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{r102});
        r100.getTiming("scale").apply(r106);
        r103.add(r106);
        calculateImageMatrixFromScale(r110, this.tmpMatrix);
        ObjectAnimator r107 = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new MatrixEvaluator(), new Matrix[]{new Matrix(this.tmpMatrix)});
        r100.getTiming("iconScale").apply(r107);
        r103.add(r107);
        AnimatorSet r108 = new AnimatorSet();
        AnimatorSetCompat.playTogether(r108, r103);
        return r108;
    }

    public void setBackgroundDrawable(ColorStateList r100, PorterDuff.Mode r101, ColorStateList r110, int r111) {
        Drawable r102 = DrawableCompat.wrap(createShapeDrawable());
        this.shapeDrawable = r102;
        DrawableCompat.setTintList(r102, r100);
        if (r101 == null) goto L5;
        DrawableCompat.setTintMode(this.shapeDrawable, r101);
    L5:
        Drawable r103 = DrawableCompat.wrap(createShapeDrawable());
        this.rippleDrawable = r103;
        DrawableCompat.setTintList(r103, RippleUtils.convertToRippleDrawableColor(r110));
        if (r111 <= 0) goto L8;
        CircularBorderDrawable r104 = createBorderDrawable(r111, r100);
        this.borderDrawable = r104;
        Drawable[] r112 = {r104, this.shapeDrawable, this.rippleDrawable};
    L9:
        this.contentBackground = new LayerDrawable(r112);
        Context r105 = this.view.getContext();
        Drawable r106 = this.contentBackground;
        float r107 = this.shadowViewDelegate.getRadius();
        float r108 = this.elevation;
        ShadowDrawableWrapper r109 = new ShadowDrawableWrapper(r105, r106, r107, r108, r108 + this.pressedTranslationZ);
        this.shadowDrawable = r109;
        r109.setAddPaddingForCorners(false);
        this.shadowViewDelegate.setBackgroundDrawable(this.shadowDrawable);
        return;
    L8:
        this.borderDrawable = null;
        r112 = new Drawable[]{this.shapeDrawable, this.rippleDrawable};
        goto L9
    }
}
