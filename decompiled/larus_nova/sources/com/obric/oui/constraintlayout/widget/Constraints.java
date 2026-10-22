package com.obric.oui.constraintlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes34.dex */
public class Constraints extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f400456a;

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public final float A0;
        public final float B0;
        public final float C0;
        public final float D0;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public final float f400457r0;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public final boolean f400458s0;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public final float f400459t0;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public final float f400460u0;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public final float f400461v0;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public final float f400462w0;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public final float f400463x0;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public final float f400464y0;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public final float f400465z0;

        public LayoutParams() {
            super(-2, -2);
            this.f400457r0 = 1.0f;
            this.f400458s0 = false;
            this.f400459t0 = 0.0f;
            this.f400460u0 = 0.0f;
            this.f400461v0 = 0.0f;
            this.f400462w0 = 0.0f;
            this.f400463x0 = 1.0f;
            this.f400464y0 = 1.0f;
            this.f400465z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f400457r0 = 1.0f;
            int r102 = 0;
            this.f400458s0 = false;
            this.f400459t0 = 0.0f;
            this.f400460u0 = 0.0f;
            this.f400461v0 = 0.0f;
            this.f400462w0 = 0.0f;
            this.f400463x0 = 1.0f;
            this.f400464y0 = 1.0f;
            this.f400465z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
            TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.orientation, R.attr.id, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.pivotX, R.attr.pivotY, R.attr.alpha, R.attr.transformPivotX, R.attr.transformPivotY, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.translationZ, R.attr.elevation, com.larus.nova.R.attr.animateCircleAngleTo, com.larus.nova.R.attr.animateRelativeTo, com.larus.nova.R.attr.animate_relativeTo, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.constraintRotate, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.deriveConstraintsFrom, com.larus.nova.R.attr.drawPath, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_wrapBehaviorInParent, com.larus.nova.R.attr.motionProgress, com.larus.nova.R.attr.motionStagger, com.larus.nova.R.attr.pathMotionArc, com.larus.nova.R.attr.pivotAnchor, com.larus.nova.R.attr.polarRelativeTo, com.larus.nova.R.attr.quantizeMotionSteps, com.larus.nova.R.attr.stateLabels, com.larus.nova.R.attr.transitionEasing, com.larus.nova.R.attr.transitionPathRotate});
            int r104 = r103.getIndexCount();
        L3:
            if (r102 >= r104) goto L41;
            int r105 = r103.getIndex(r102);
            if (r105 != 15) goto L8;
            this.f400457r0 = r103.getFloat(r105, this.f400457r0);
        L40:
            r102 = r102 + 1;
            goto L3
        L8:
            if (r105 != 28) goto L11;
            this.f400459t0 = r103.getFloat(r105, this.f400459t0);
            this.f400458s0 = true;
            goto L40
        L11:
            if (r105 != 23) goto L14;
            this.f400461v0 = r103.getFloat(r105, this.f400461v0);
            goto L40
        L14:
            if (r105 != 24) goto L17;
            this.f400462w0 = r103.getFloat(r105, this.f400462w0);
            goto L40
        L17:
            if (r105 != 22) goto L20;
            this.f400460u0 = r103.getFloat(r105, this.f400460u0);
            goto L40
        L20:
            if (r105 != 20) goto L23;
            this.f400463x0 = r103.getFloat(r105, this.f400463x0);
            goto L40
        L23:
            if (r105 != 21) goto L26;
            this.f400464y0 = r103.getFloat(r105, this.f400464y0);
            goto L40
        L26:
            if (r105 != 16) goto L29;
            this.f400465z0 = r103.getFloat(r105, this.f400465z0);
            goto L40
        L29:
            if (r105 != 17) goto L32;
            this.A0 = r103.getFloat(r105, this.A0);
            goto L40
        L32:
            if (r105 != 18) goto L35;
            this.B0 = r103.getFloat(r105, this.B0);
            goto L40
        L35:
            if (r105 != 19) goto L38;
            this.C0 = r103.getFloat(r105, this.C0);
            goto L40
        L38:
            if (r105 != 27) goto L40;
            this.D0 = r103.getFloat(r105, this.D0);
            goto L40
        L41:
            r103.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public a getConstraintSet() {
        if (this.f400456a != null) goto L5;
        this.f400456a = new a();
    L5:
        a r100 = this.f400456a;
        r100.getClass();
        int r101 = getChildCount();
        r100.f400485g.clear();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L28;
        View r103 = getChildAt(r102);
        LayoutParams r104 = (LayoutParams) r103.getLayoutParams();
        int r105 = r103.getId();
        if (r100.f400484f == false) goto L15;
        if (r105 != (-1)) goto L15;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L15:
        if (r100.f400485g.containsKey(Integer.valueOf(r105)) == true) goto L17;
        r100.f400485g.put(Integer.valueOf(r105), new a.C4670a());
    L17:
        a.C4670a r106 = r100.f400485g.get(Integer.valueOf(r105));
        if (r106 == null) goto L26;
        if ((r103 instanceof ConstraintHelper) == false) goto L25;
        ConstraintHelper r107 = (ConstraintHelper) r103;
        r106.d(r105, r104);
        if ((r107 instanceof Barrier) == false) goto L25;
        a.b r108 = r106.f400490e;
        r108.f400525i0 = 1;
        Barrier r109 = (Barrier) r107;
        r108.f400521g0 = r109.getType();
        a.b r110 = r106.f400490e;
        r110.f400527j0 = r109.getReferencedIds();
        a.b r111 = r106.f400490e;
        r111.f400523h0 = r109.getMargin();
    L25:
        r106.d(r105, r104);
    L26:
        r102 = r102 + 1;
        goto L6
    L28:
        return this.f400456a;
    }

    public Constraints(Context r100) {
        super(r100);
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new ConstraintLayout.LayoutParams(r100);
    }

    public Constraints(Context r100, AttributeSet r101) {
        super(r100, r101);
        super.setVisibility(8);
    }

    public Constraints(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        super.setVisibility(8);
    }
}
