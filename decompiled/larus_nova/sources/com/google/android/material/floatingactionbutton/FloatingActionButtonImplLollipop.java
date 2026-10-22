package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.internal.CircularBorderDrawable;
import com.google.android.material.internal.CircularBorderDrawableLollipop;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.android.material.shadow.ShadowViewDelegate;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {
    private InsetDrawable insetDrawable;

    public static class AlwaysStatefulGradientDrawable extends GradientDrawable {
        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }

        public AlwaysStatefulGradientDrawable() {
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void jumpDrawableToCurrentState() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public boolean requirePreDrawListener() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public float getElevation() {
        return this.view.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public CircularBorderDrawable newCircularDrawable() {
        return new CircularBorderDrawableLollipop();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public GradientDrawable newGradientDrawableForShape() {
        return new AlwaysStatefulGradientDrawable();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void onCompatShadowChanged() {
        updatePadding();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void getPadding(Rect r100) {
        if (this.shadowViewDelegate.isCompatPaddingEnabled() == false) goto L5;
        float r101 = this.shadowViewDelegate.getRadius();
        float r102 = getElevation() + this.pressedTranslationZ;
        int r103 = (int) Math.ceil(ShadowDrawableWrapper.calculateHorizontalPadding(r102, r101, false));
        int r104 = (int) Math.ceil(ShadowDrawableWrapper.calculateVerticalPadding(r102, r101, false));
        r100.set(r103, r104, r103, r104);
        return;
    L5:
        r100.set(0, 0, 0, 0);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void onDrawableStateChanged(int[] r100) {
        if (Build.VERSION.SDK_INT == 21) goto L5;
        return;
    L5:
        if (this.view.isEnabled() == false) goto L16;
        this.view.setElevation(this.elevation);
        if (this.view.isPressed() == false) goto L10;
        this.view.setTranslationZ(this.pressedTranslationZ);
        return;
    L10:
        if (this.view.isFocused() == false) goto L12;
    L15:
        this.view.setTranslationZ(this.hoveredFocusedTranslationZ);
        return;
    L12:
        if (this.view.isHovered() == true) goto L15;
        this.view.setTranslationZ(0.0f);
        return;
    L16:
        this.view.setElevation(0.0f);
        this.view.setTranslationZ(0.0f);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void onPaddingUpdated(Rect r100) {
        if (this.shadowViewDelegate.isCompatPaddingEnabled() == false) goto L5;
        InsetDrawable r101 = new InsetDrawable(this.rippleDrawable, r100.left, r100.top, r100.right, r100.bottom);
        this.insetDrawable = r101;
        this.shadowViewDelegate.setBackgroundDrawable(r101);
        return;
    L5:
        this.shadowViewDelegate.setBackgroundDrawable(this.rippleDrawable);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void setRippleColor(ColorStateList r100) {
        Drawable r101 = this.rippleDrawable;
        if ((r101 instanceof RippleDrawable) == false) goto L5;
        ((RippleDrawable) r101).setColor(RippleUtils.convertToRippleDrawableColor(r100));
        return;
    L5:
        super.setRippleColor(r100);
    }

    public FloatingActionButtonImplLollipop(VisibilityAwareImageButton r100, ShadowViewDelegate r101) {
        super(r100, r101);
    }

    private Animator createElevationAnimator(float r100, float r101) {
        AnimatorSet r102 = new AnimatorSet();
        r102.play(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{r100}).setDuration(0)).with(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{r101}).setDuration(100));
        r102.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        return r102;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void onElevationsChanged(float r100, float r110, float r111) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 != 21) goto L5;
        this.view.refreshDrawableState();
    L12:
        if (this.shadowViewDelegate.isCompatPaddingEnabled() == false) goto L15;
        updatePadding();
        return;
    L15:
        return;
    L5:
        StateListAnimator r102 = new StateListAnimator();
        r102.addState(FloatingActionButtonImpl.PRESSED_ENABLED_STATE_SET, createElevationAnimator(r100, r111));
        r102.addState(FloatingActionButtonImpl.HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(r100, r110));
        r102.addState(FloatingActionButtonImpl.FOCUSED_ENABLED_STATE_SET, createElevationAnimator(r100, r110));
        r102.addState(FloatingActionButtonImpl.HOVERED_ENABLED_STATE_SET, createElevationAnimator(r100, r110));
        AnimatorSet r112 = new AnimatorSet();
        ArrayList r113 = new ArrayList();
        r113.add(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{r100}).setDuration(0));
        if (r101 >= 22) goto L8;
    L10:
        r113.add(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
        r112.playSequentially((Animator[]) r113.toArray(new Animator[0]));
        r112.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        r102.addState(FloatingActionButtonImpl.ENABLED_STATE_SET, r112);
        r102.addState(FloatingActionButtonImpl.EMPTY_STATE_SET, createElevationAnimator(0.0f, 0.0f));
        this.view.setStateListAnimator(r102);
        goto L12
    L8:
        if (r101 > 24) goto L10;
        VisibilityAwareImageButton r103 = this.view;
        r113.add(ObjectAnimator.ofFloat(r103, View.TRANSLATION_Z, new float[]{r103.getTranslationZ()}).setDuration(100));
        goto L10
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void setBackgroundDrawable(ColorStateList r100, PorterDuff.Mode r101, ColorStateList r102, int r103) {
        Drawable r104 = DrawableCompat.wrap(createShapeDrawable());
        this.shapeDrawable = r104;
        DrawableCompat.setTintList(r104, r100);
        if (r101 == null) goto L6;
        DrawableCompat.setTintMode(this.shapeDrawable, r101);
    L6:
        if (r103 <= 0) goto L8;
        this.borderDrawable = createBorderDrawable(r103, r100);
        Drawable r105 = new LayerDrawable(new Drawable[]{this.borderDrawable, this.shapeDrawable});
    L9:
        RippleDrawable r106 = new RippleDrawable(RippleUtils.convertToRippleDrawableColor(r102), r105, null);
        this.rippleDrawable = r106;
        this.contentBackground = r106;
        this.shadowViewDelegate.setBackgroundDrawable(r106);
        return;
    L8:
        this.borderDrawable = null;
        r105 = this.shapeDrawable;
        goto L9
    }
}
