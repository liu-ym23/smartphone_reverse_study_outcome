package com.obric.oui.constraintlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.d;

/* JADX INFO: loaded from: classes34.dex */
public class Barrier extends ConstraintHelper {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f400364j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f400365k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.obric.oui.constraintlayout.core.widgets.a f400366l;

    public boolean getAllowsGoneWidget() {
        return this.f400366l.A0;
    }

    public int getMargin() {
        return this.f400366l.B0;
    }

    public int getType() {
        return this.f400364j;
    }

    public Barrier(Context r100) {
        super(r100);
        super.setVisibility(8);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void n(AttributeSet r100) {
        super.n(r100);
        this.f400366l = new com.obric.oui.constraintlayout.core.widgets.a();
        if (r100 == null) goto L17;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.orientation, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.paddingStart, R.attr.paddingEnd, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.elevation, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.circularflow_angles, com.larus.nova.R.attr.circularflow_defaultAngle, com.larus.nova.R.attr.circularflow_defaultRadius, com.larus.nova.R.attr.circularflow_radiusInDP, com.larus.nova.R.attr.circularflow_viewCenter, com.larus.nova.R.attr.constraintSet, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layoutDescription, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_optimizationLevel, com.larus.nova.R.attr.layout_wrapBehaviorInParent});
        int r102 = r101.getIndexCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L16;
        int r104 = r101.getIndex(r103);
        if (r104 != 26) goto L10;
        setType(r101.getInt(r104, 0));
    L15:
        r103 = r103 + 1;
        goto L5
    L10:
        if (r104 != 25) goto L13;
        com.obric.oui.constraintlayout.core.widgets.a r105 = this.f400366l;
        r105.A0 = r101.getBoolean(r104, true);
        goto L15
    L13:
        if (r104 != 27) goto L15;
        this.f400366l.B0 = r101.getDimensionPixelSize(r104, 0);
        goto L15
    L16:
        r101.recycle();
    L17:
        this.f400380d = this.f400366l;
        t();
    }

    public void setAllowsGoneWidget(boolean r100) {
        this.f400366l.A0 = r100;
    }

    public void setDpMargin(int r100) {
        Resources r101 = getResources();
        this.f400366l.B0 = (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public void setMargin(int r100) {
        this.f400366l.B0 = r100;
    }

    public void setType(int r100) {
        this.f400364j = r100;
    }

    public Barrier(Context r100, AttributeSet r101) {
        super(r100, r101);
        super.setVisibility(8);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void p(ConstraintWidget r100, boolean r101) {
        u(r100, this.f400364j, r101);
    }

    public Barrier(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        super.setVisibility(8);
    }

    public final void u(ConstraintWidget r100, int r101, boolean r102) {
        this.f400365k = r101;
        if (r102 == false) goto L9;
        int r103 = this.f400364j;
        if (r103 != 5) goto L7;
        this.f400365k = 1;
    L15:
        if ((r100 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L18;
        int r104 = this.f400365k;
        ((com.obric.oui.constraintlayout.core.widgets.a) r100).f399753z0 = r104;
        return;
    L18:
        return;
    L7:
        if (r103 != 6) goto L15;
        this.f400365k = 0;
        goto L15
    L9:
        int r105 = this.f400364j;
        if (r105 != 5) goto L12;
        this.f400365k = 0;
        goto L15
    L12:
        if (r105 != 6) goto L15;
        this.f400365k = 1;
        goto L15
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void o(a.C4670a r100, ula.b r101, Constraints.LayoutParams r102, SparseArray r103) {
        super.o(r100, r101, r102, r103);
        if ((r101 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L6;
        com.obric.oui.constraintlayout.core.widgets.a r104 = (com.obric.oui.constraintlayout.core.widgets.a) r101;
        boolean r105 = ((d) r101.X).C0;
        u(r104, r100.f400490e.f400521g0, r105);
        a.b r106 = r100.f400490e;
        r104.A0 = r106.f400537o0;
        r104.B0 = r106.f400523h0;
        return;
    }
}
