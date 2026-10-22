package com.obric.oui.constraintlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.obric.oui.constraintlayout.core.widgets.i;

/* JADX INFO: loaded from: classes34.dex */
public abstract class VirtualLayout extends ConstraintHelper {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f400474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f400475k;

    public void u(i r100, int r101, int r102) {
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f400474j == false) goto L5;
    L6:
        ViewParent r100 = getParent();
        if ((r100 instanceof ConstraintLayout) == false) goto L28;
        ConstraintLayout r101 = (ConstraintLayout) r100;
        int r102 = getVisibility();
        float r103 = getElevation();
        int r104 = 0;
    L10:
        if (r104 >= this.f400378b) goto L29;
        View r105 = r101.b(this.f400377a[r104]);
        if (r105 == null) goto L21;
        if (this.f400474j == false) goto L17;
        r105.setVisibility(r102);
    L17:
        if (this.f400475k == false) goto L21;
        if (r103 <= 0.0f) goto L21;
        r105.setTranslationZ(r105.getTranslationZ() + r103);
    L21:
        r104 = r104 + 1;
        goto L10
    L29:
        return;
    L28:
        return;
    L5:
        if (this.f400475k == true) goto L6;
    }

    public VirtualLayout(Context r100) {
        super(r100);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void j(ConstraintLayout r100) {
        i(r100);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void n(AttributeSet r100) {
        super.n(r100);
        if (r100 == null) goto L19;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.orientation, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.paddingStart, R.attr.paddingEnd, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.elevation, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.circularflow_angles, com.larus.nova.R.attr.circularflow_defaultAngle, com.larus.nova.R.attr.circularflow_defaultRadius, com.larus.nova.R.attr.circularflow_radiusInDP, com.larus.nova.R.attr.circularflow_viewCenter, com.larus.nova.R.attr.constraintSet, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layoutDescription, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_optimizationLevel, com.larus.nova.R.attr.layout_wrapBehaviorInParent});
        int r102 = r101.getIndexCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L13;
        int r104 = r101.getIndex(r103);
        if (r104 != 6) goto L10;
        this.f400474j = true;
    L12:
        r103 = r103 + 1;
        goto L5
    L10:
        if (r104 != 22) goto L12;
        this.f400475k = true;
        goto L12
    L13:
        r101.recycle();
        return;
    }

    @Override // android.view.View
    public void setElevation(float r100) {
        super.setElevation(r100);
        h();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        h();
    }

    public VirtualLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public VirtualLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
