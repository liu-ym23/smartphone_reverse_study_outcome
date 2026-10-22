package com.facebook.drawee.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.view.ViewGroup;
import com.facebook.drawee.drawable.ScalingUtils;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class DraweeTransition extends Transition {
    private static final String PROPNAME_BOUNDS = "draweeTransition:bounds";

    @Nullable
    private final PointF mFromFocusPoint;
    private final ScalingUtils.ScaleType mFromScale;

    @Nullable
    private final PointF mToFocusPoint;
    private final ScalingUtils.ScaleType mToScale;

    public static /* synthetic */ ScalingUtils.ScaleType access$000(DraweeTransition r100) {
        return r100.mToScale;
    }

    public static /* synthetic */ PointF access$100(DraweeTransition r100) {
        return r100.mToFocusPoint;
    }

    private void captureValues(TransitionValues r100) {
        if ((r100.view instanceof GenericDraweeView) == false) goto L6;
        r100.values.put(PROPNAME_BOUNDS, new Rect(0, 0, r100.view.getWidth(), r100.view.getHeight()));
        return;
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues r100) {
        captureValues(r100);
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues r100) {
        captureValues(r100);
    }

    public DraweeTransition(ScalingUtils.ScaleType r100, ScalingUtils.ScaleType r101) {
        this(r100, r101, null, null);
    }

    public static TransitionSet createTransitionSet(ScalingUtils.ScaleType r100, ScalingUtils.ScaleType r101) {
        return createTransitionSet(r100, r101, null, null);
    }

    @Override // android.transition.Transition
    public Animator createAnimator(ViewGroup r110, TransitionValues r111, TransitionValues r112) {
        if (r111 == null) goto L17;
        if (r112 == null) goto L17;
        Rect r100 = (Rect) r111.values.get(PROPNAME_BOUNDS);
        Rect r101 = (Rect) r112.values.get(PROPNAME_BOUNDS);
        if (r100 == null) goto L17;
        if (r101 == null) goto L17;
        ScalingUtils.ScaleType r102 = this.mFromScale;
        ScalingUtils.ScaleType r103 = this.mToScale;
        if (r102 == r103) goto L13;
    L15:
        final GenericDraweeView r113 = (GenericDraweeView) r111.view;
        final ScalingUtils.InterpolatingScaleType r114 = new ScalingUtils.InterpolatingScaleType(r102, r103, r100, r101, this.mFromFocusPoint, this.mToFocusPoint);
        r113.getHierarchy().setActualImageScaleType(r114);
        ValueAnimator r115 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r115.addUpdateListener(new AnonymousClass1(this, r114));
        r115.addListener(new AnonymousClass2(this, r113));
        return r115;
    L13:
        if (this.mFromFocusPoint != this.mToFocusPoint) goto L15;
        return null;
    L17:
        return null;
    }

    public DraweeTransition(ScalingUtils.ScaleType r100, ScalingUtils.ScaleType r101, @Nullable PointF r102, @Nullable PointF r103) {
        this.mFromScale = r100;
        this.mToScale = r101;
        this.mFromFocusPoint = r102;
        this.mToFocusPoint = r103;
    }

    public static TransitionSet createTransitionSet(ScalingUtils.ScaleType r100, ScalingUtils.ScaleType r101, @Nullable PointF r102, @Nullable PointF r103) {
        TransitionSet r104 = new TransitionSet();
        r104.addTransition(new ChangeBounds());
        r104.addTransition(new DraweeTransition(r100, r101, r102, r103));
        return r104;
    }
}
