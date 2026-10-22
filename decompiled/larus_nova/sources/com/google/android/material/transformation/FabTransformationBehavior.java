package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private final int[] tmpArray;
    private final Rect tmpRect;
    private final RectF tmpRectF1;
    private final RectF tmpRectF2;

    public static class FabTransformationSpec {
        public Positioning positioning;
        public MotionSpec timings;

        public FabTransformationSpec() {
        }
    }

    public abstract FabTransformationSpec onCreateMotionSpec(Context r100, boolean r101);

    public FabTransformationBehavior() {
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    private ViewGroup calculateChildContentContainer(View r100) {
        View r101 = r100.findViewById(R.id.mtrl_child_content_container);
        if (r101 == null) goto L7;
        return toViewGroupOrNull(r101);
    L7:
        if ((r100 instanceof TransformationChildLayout) == true) goto L14;
        if ((r100 instanceof TransformationChildCard) == true) goto L14;
        return toViewGroupOrNull(r100);
    L14:
        return toViewGroupOrNull(((ViewGroup) r100).getChildAt(0));
    }

    private int getBackgroundTint(View r100) {
        ColorStateList r101 = ViewCompat.getBackgroundTintList(r100);
        if (r101 != null) goto L5;
        return 0;
    L5:
        return r101.getColorForState(r100.getDrawableState(), r101.getDefaultColor());
    }

    private ViewGroup toViewGroupOrNull(View r100) {
        if ((r100 instanceof ViewGroup) == true) goto L5;
        return null;
    L5:
        return (ViewGroup) r100;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r100) {
        if (r100.dodgeInsetEdges != 0) goto L6;
        r100.dodgeInsetEdges = 80;
        return;
    }

    public FabTransformationBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    private void calculateWindowBounds(View r100, RectF r101) {
        r101.set(0.0f, 0.0f, r100.getWidth(), r100.getHeight());
        int[] r102 = this.tmpArray;
        r100.getLocationInWindow(r102);
        r101.offsetTo(r102[0], r102[1]);
        r101.offset((int) (-r100.getTranslationX()), (int) (-r100.getTranslationY()));
    }

    private float calculateRevealCenterX(View r100, View r101, Positioning r102) {
        RectF r103 = this.tmpRectF1;
        RectF r104 = this.tmpRectF2;
        calculateWindowBounds(r100, r103);
        calculateWindowBounds(r101, r104);
        r104.offset(-calculateTranslationX(r100, r101, r102), 0.0f);
        return r103.centerX() - r104.left;
    }

    private float calculateRevealCenterY(View r100, View r101, Positioning r102) {
        RectF r103 = this.tmpRectF1;
        RectF r104 = this.tmpRectF2;
        calculateWindowBounds(r100, r103);
        calculateWindowBounds(r101, r104);
        r104.offset(0.0f, -calculateTranslationY(r100, r101, r102));
        return r103.centerY() - r104.top;
    }

    private float calculateTranslationX(View r100, View r101, Positioning r102) {
        RectF r103 = this.tmpRectF1;
        RectF r104 = this.tmpRectF2;
        calculateWindowBounds(r100, r103);
        calculateWindowBounds(r101, r104);
        int r105 = r102.gravity & 7;
        if (r105 != 1) goto L5;
        float r106 = r104.centerX();
        float r107 = r103.centerX();
    L12:
        float r108 = r106 - r107;
    L14:
        return r108 + r102.xAdjustment;
    L5:
        if (r105 != 3) goto L7;
        r106 = r104.left;
        r107 = r103.left;
        goto L12
    L7:
        if (r105 == 5) goto L9;
        r108 = 0.0f;
        goto L14
    L9:
        r106 = r104.right;
        r107 = r103.right;
        goto L12
    }

    private float calculateTranslationY(View r100, View r101, Positioning r102) {
        RectF r103 = this.tmpRectF1;
        RectF r104 = this.tmpRectF2;
        calculateWindowBounds(r100, r103);
        calculateWindowBounds(r101, r104);
        int r105 = r102.gravity & 112;
        if (r105 != 16) goto L5;
        float r106 = r104.centerY();
        float r107 = r103.centerY();
    L12:
        float r108 = r106 - r107;
    L14:
        return r108 + r102.yAdjustment;
    L5:
        if (r105 != 48) goto L7;
        r106 = r104.top;
        r107 = r103.top;
        goto L12
    L7:
        if (r105 == 80) goto L9;
        r108 = 0.0f;
        goto L14
    L9:
        r106 = r104.bottom;
        r107 = r103.bottom;
        goto L12
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout r100, View r101, View r102) {
        if (r101.getVisibility() == 8) goto L13;
        if ((r102 instanceof FloatingActionButton) == false) goto L14;
        int r103 = ((FloatingActionButton) r102).getExpandedComponentIdHint();
        if (r103 != 0) goto L9;
    L10:
        return true;
    L9:
        if (r103 == r101.getId()) goto L10;
        return false;
    L14:
        return false;
    L13:
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    private float calculateValueOfAnimationAtEndOfExpansion(FabTransformationSpec r100, MotionTiming r110, float r111, float r112) {
        long r101 = r110.getDelay();
        long r102 = r110.getDuration();
        MotionTiming r103 = r100.timings.getTiming("expansion");
        return AnimationUtils.lerp(r111, r112, r110.getInterpolator().getInterpolation((((r103.getDelay() + r103.getDuration()) + 17) - r101) / r102));
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet onCreateExpandedStateChangeAnimation(final View r110, final View r111, final boolean r112, boolean r113) {
        FabTransformationSpec r114 = onCreateMotionSpec(r111.getContext(), r112);
        List<Animator> r115 = new ArrayList();
        ArrayList r116 = new ArrayList();
        createElevationAnimation(r110, r111, r112, r113, r114, r115, r116);
        RectF r100 = this.tmpRectF1;
        createTranslationAnimation(r110, r111, r112, r113, r114, r115, r116, r100);
        float r101 = r100.width();
        float r102 = r100.height();
        createIconFadeAnimation(r110, r111, r112, r113, r114, r115, r116);
        createExpansionAnimation(r110, r111, r112, r113, r114, r101, r102, r115, r116);
        createColorAnimation(r110, r111, r112, r113, r114, r115, r116);
        createChildrenFadeAnimation(r110, r111, r112, r113, r114, r115, r116);
        AnimatorSet r103 = new AnimatorSet();
        AnimatorSetCompat.playTogether(r103, r115);
        r103.addListener(new AnonymousClass1(this, r112, r111, r110));
        int r104 = r116.size();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r103.addListener((Animator.AnimatorListener) ListProtector.get(r116, r105));
        r105 = r105 + 1;
        goto L3
    L5:
        return r103;
    }

    private void createPreFillRadialExpansion(View r100, long r101, int r102, int r103, float r104, List<Animator> r110) {
        if (r101 <= 0) goto L6;
        Animator r105 = ViewAnimationUtils.createCircularReveal(r100, r102, r103, r104, r104);
        r105.setStartDelay(0);
        r105.setDuration(r101);
        r110.add(r105);
        return;
    }

    private void createChildrenFadeAnimation(View r100, View r101, boolean r102, boolean r103, FabTransformationSpec r104, List<Animator> r105, List<Animator.AnimatorListener> r106) {
        if ((r101 instanceof ViewGroup) == true) goto L6;
        return;
    L6:
        if ((r101 instanceof CircularRevealWidget) == true) goto L8;
    L10:
        ViewGroup r107 = calculateChildContentContainer(r101);
        if (r107 != null) goto L14;
        return;
    L14:
        if (r102 == false) goto L18;
        if (r103 == true) goto L17;
        ChildrenAlphaProperty.CHILDREN_ALPHA.set(r107, Float.valueOf(0.0f));
    L17:
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r107, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{1.0f});
    L19:
        r104.timings.getTiming("contentFade").apply(r108);
        r105.add(r108);
        return;
    L18:
        r108 = ObjectAnimator.ofFloat(r107, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{0.0f});
        goto L19
    L8:
        if (CircularRevealHelper.STRATEGY != 0) goto L10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createColorAnimation(View r100, View r101, boolean r102, boolean r103, FabTransformationSpec r104, List<Animator> r105, List<Animator.AnimatorListener> r106) {
        if ((r101 instanceof CircularRevealWidget) == true) goto L5;
        return;
    L5:
        CircularRevealWidget r107 = (CircularRevealWidget) r101;
        int r108 = getBackgroundTint(r100);
        int r109 = 16777215 & r108;
        if (r102 == false) goto L10;
        if (r103 == true) goto L9;
        r107.setCircularRevealScrimColor(r108);
    L9:
        ObjectAnimator r110 = ObjectAnimator.ofInt(r107, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{r109});
    L11:
        r110.setEvaluator(ArgbEvaluatorCompat.getInstance());
        r104.timings.getTiming("color").apply(r110);
        r105.add(r110);
        return;
    L10:
        r110 = ObjectAnimator.ofInt(r107, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{r108});
        goto L11
    }

    private void createElevationAnimation(View r100, View r101, boolean r102, boolean r103, FabTransformationSpec r104, List<Animator> r105, List<Animator.AnimatorListener> r106) {
        float r107 = ViewCompat.getElevation(r101) - ViewCompat.getElevation(r100);
        if (r102 == false) goto L7;
        if (r103 == true) goto L6;
        r101.setTranslationZ(-r107);
    L6:
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r101, View.TRANSLATION_Z, new float[]{0.0f});
    L8:
        r104.timings.getTiming("elevation").apply(r108);
        r105.add(r108);
        return;
    L7:
        r108 = ObjectAnimator.ofFloat(r101, View.TRANSLATION_Z, new float[]{-r107});
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createIconFadeAnimation(View r100, final View r101, boolean r102, boolean r103, FabTransformationSpec r104, List<Animator> r110, List<Animator.AnimatorListener> r111) {
        if ((r101 instanceof CircularRevealWidget) == true) goto L5;
        return;
    L5:
        if ((r100 instanceof ImageView) == false) goto L19;
        final CircularRevealWidget r105 = (CircularRevealWidget) r101;
        final Drawable r106 = ((ImageView) r100).getDrawable();
        if (r106 != null) goto L10;
        return;
    L10:
        r106.mutate();
        if (r102 == false) goto L15;
        if (r103 == true) goto L14;
        r106.setAlpha(255);
    L14:
        ObjectAnimator r107 = ObjectAnimator.ofInt(r106, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{0});
    L16:
        r107.addUpdateListener(new AnonymousClass2(this, r101));
        r104.timings.getTiming("iconFade").apply(r107);
        r110.add(r107);
        r111.add(new AnonymousClass3(this, r105, r106));
        return;
    L15:
        r107 = ObjectAnimator.ofInt(r106, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{255});
        goto L16
    }

    private void createPostFillRadialExpansion(View r100, long r101, long r102, long r103, int r104, int r105, float r110, List<Animator> r111) {
        long r106 = r101 + r102;
        if (r106 >= r103) goto L6;
        Animator r107 = ViewAnimationUtils.createCircularReveal(r100, r104, r105, r110, r110);
        r107.setStartDelay(r106);
        r107.setDuration(r103 - r106);
        r111.add(r107);
        return;
    }

    private void createTranslationAnimation(View r110, View r111, boolean r112, boolean r210, FabTransformationSpec r211, List<Animator> r212, List<Animator.AnimatorListener> r213, RectF r214) {
        float r100 = calculateTranslationX(r110, r111, r211.positioning);
        float r101 = calculateTranslationY(r110, r111, r211.positioning);
        if (r100 != 0.0f) goto L5;
    L14:
        MotionTiming r102 = r211.timings.getTiming("translationXLinear");
        MotionTiming r103 = r211.timings.getTiming("translationYLinear");
    L15:
        MotionTiming r113 = r102;
        MotionTiming r114 = r103;
        if (r112 == false) goto L20;
        if (r210 == true) goto L19;
        r111.setTranslationX(-r100);
        r111.setTranslationY(-r101);
    L19:
        ObjectAnimator r115 = ObjectAnimator.ofFloat(r111, View.TRANSLATION_X, new float[]{0.0f});
        ObjectAnimator r116 = ObjectAnimator.ofFloat(r111, View.TRANSLATION_Y, new float[]{0.0f});
        calculateChildVisibleBoundsAtEndOfExpansion(r111, r211, r113, r114, -r100, -r101, 0.0f, 0.0f, r214);
    L21:
        r113.apply(r115);
        r114.apply(r116);
        r212.add(r115);
        r212.add(r116);
        return;
    L20:
        r115 = ObjectAnimator.ofFloat(r111, View.TRANSLATION_X, new float[]{-r100});
        r116 = ObjectAnimator.ofFloat(r111, View.TRANSLATION_Y, new float[]{-r101});
        goto L21
    L5:
        if (r101 == 0.0f) goto L14;
        if (r112 == true) goto L9;
    L10:
        if (r112 == true) goto L13;
        if (r101 <= 0.0f) goto L13;
    L12:
        r102 = r211.timings.getTiming("translationXCurveUpwards");
        r103 = r211.timings.getTiming("translationYCurveUpwards");
    L13:
        r102 = r211.timings.getTiming("translationXCurveDownwards");
        r103 = r211.timings.getTiming("translationYCurveDownwards");
        goto L15
    L9:
        if (r101 < 0.0f) goto L12;
        goto L10
    }

    private void calculateChildVisibleBoundsAtEndOfExpansion(View r100, FabTransformationSpec r101, MotionTiming r102, MotionTiming r103, float r104, float r105, float r106, float r107, RectF r108) {
        float r109 = calculateValueOfAnimationAtEndOfExpansion(r101, r102, r104, r106);
        float r110 = calculateValueOfAnimationAtEndOfExpansion(r101, r103, r105, r107);
        Rect r111 = this.tmpRect;
        r100.getWindowVisibleDisplayFrame(r111);
        RectF r112 = this.tmpRectF1;
        r112.set(r111);
        RectF r113 = this.tmpRectF2;
        calculateWindowBounds(r100, r113);
        r113.offset(r109, r110);
        r113.intersect(r112);
        r108.set(r113);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void createExpansionAnimation(View r110, View r111, boolean r210, boolean r211, FabTransformationSpec r212, float r213, float r214, List<Animator> r215, List<Animator.AnimatorListener> r216) {
        if ((r111 instanceof CircularRevealWidget) == true) goto L5;
        return;
    L5:
        final CircularRevealWidget r112 = (CircularRevealWidget) r111;
        float r100 = calculateRevealCenterX(r110, r111, r212.positioning);
        float r113 = calculateRevealCenterY(r110, r111, r212.positioning);
        ((FloatingActionButton) r110).getContentRect(this.tmpRect);
        float r114 = this.tmpRect.width() / 2.0f;
        MotionTiming r115 = r212.timings.getTiming("expansion");
        if (r210 == false) goto L12;
        if (r211 == true) goto L9;
        r112.setRevealInfo(new CircularRevealWidget.RevealInfo(r100, r113, r114));
    L9:
        if (r211 == false) goto L11;
        r114 = r112.getRevealInfo().radius;
    L11:
        Animator r101 = CircularRevealCompat.createCircularReveal(r112, r100, r113, MathUtils.distanceToFurthestCorner(r100, r113, 0.0f, 0.0f, r213, r214));
        r101.addListener(new AnonymousClass4(this, r112));
        createPreFillRadialExpansion(r111, r115.getDelay(), (int) r100, (int) r113, r114, r215);
    L13:
        r115.apply(r101);
        r215.add(r101);
        r216.add(CircularRevealCompat.createCircularRevealListener(r112));
        return;
    L12:
        float r102 = r112.getRevealInfo().radius;
        Animator r116 = CircularRevealCompat.createCircularReveal(r112, r100, r113, r114);
        int r103 = (int) r100;
        int r117 = (int) r113;
        createPreFillRadialExpansion(r111, r115.getDelay(), r103, r117, r102, r215);
        createPostFillRadialExpansion(r111, r115.getDelay(), r115.getDuration(), r212.timings.getTotalDuration(), r103, r117, r114, r215);
        r101 = r116;
        goto L13
    }
}
