package com.obric.oui.constraintlayout.helper.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.e;
import com.obric.oui.constraintlayout.core.widgets.i;
import com.obric.oui.constraintlayout.widget.Constraints;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import com.obric.oui.constraintlayout.widget.a;
import ula.b;

/* JADX INFO: loaded from: classes34.dex */
public class Flow extends VirtualLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public e f399895l;

    public Flow(Context r100) {
        super(r100);
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void n(AttributeSet r100) {
        super.n(r100);
        this.f399895l = new e();
        if (r100 == null) goto L86;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.orientation, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.paddingStart, R.attr.paddingEnd, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.elevation, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.circularflow_angles, com.larus.nova.R.attr.circularflow_defaultAngle, com.larus.nova.R.attr.circularflow_defaultRadius, com.larus.nova.R.attr.circularflow_radiusInDP, com.larus.nova.R.attr.circularflow_viewCenter, com.larus.nova.R.attr.constraintSet, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layoutDescription, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_optimizationLevel, com.larus.nova.R.attr.layout_wrapBehaviorInParent});
        int r102 = r101.getIndexCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L85;
        int r104 = r101.getIndex(r103);
        if (r104 != 0) goto L10;
        e r105 = this.f399895l;
        r105.f399838c1 = r101.getInt(r104, 0);
    L84:
        r103 = r103 + 1;
        goto L5
    L10:
        if (r104 != 1) goto L13;
        e r106 = this.f399895l;
        int r107 = r101.getDimensionPixelSize(r104, 0);
        r106.f399868z0 = r107;
        r106.A0 = r107;
        r106.B0 = r107;
        r106.C0 = r107;
        goto L84
    L13:
        if (r104 != 18) goto L16;
        e r108 = this.f399895l;
        int r109 = r101.getDimensionPixelSize(r104, 0);
        r108.B0 = r109;
        r108.D0 = r109;
        r108.E0 = r109;
        goto L84
    L16:
        if (r104 != 19) goto L19;
        e r110 = this.f399895l;
        r110.C0 = r101.getDimensionPixelSize(r104, 0);
        goto L84
    L19:
        if (r104 != 2) goto L22;
        e r111 = this.f399895l;
        r111.D0 = r101.getDimensionPixelSize(r104, 0);
        goto L84
    L22:
        if (r104 != 3) goto L25;
        e r112 = this.f399895l;
        r112.f399868z0 = r101.getDimensionPixelSize(r104, 0);
        goto L84
    L25:
        if (r104 != 4) goto L28;
        e r113 = this.f399895l;
        r113.E0 = r101.getDimensionPixelSize(r104, 0);
        goto L84
    L28:
        if (r104 != 5) goto L31;
        e r114 = this.f399895l;
        r114.A0 = r101.getDimensionPixelSize(r104, 0);
        goto L84
    L31:
        if (r104 != 54) goto L34;
        e r115 = this.f399895l;
        r115.f399836a1 = r101.getInt(r104, 0);
        goto L84
    L34:
        if (r104 != 44) goto L37;
        e r116 = this.f399895l;
        r116.K0 = r101.getInt(r104, 0);
        goto L84
    L37:
        if (r104 != 53) goto L40;
        e r117 = this.f399895l;
        r117.L0 = r101.getInt(r104, 0);
        goto L84
    L40:
        if (r104 != 38) goto L43;
        e r118 = this.f399895l;
        r118.M0 = r101.getInt(r104, 0);
        goto L84
    L43:
        if (r104 != 46) goto L46;
        e r119 = this.f399895l;
        r119.O0 = r101.getInt(r104, 0);
        goto L84
    L46:
        if (r104 != 40) goto L49;
        e r120 = this.f399895l;
        r120.N0 = r101.getInt(r104, 0);
        goto L84
    L49:
        if (r104 != 48) goto L52;
        e r121 = this.f399895l;
        r121.P0 = r101.getInt(r104, 0);
        goto L84
    L52:
        if (r104 != 42) goto L55;
        e r122 = this.f399895l;
        r122.Q0 = r101.getFloat(r104, 0.5f);
        goto L84
    L55:
        if (r104 != 37) goto L58;
        e r123 = this.f399895l;
        r123.S0 = r101.getFloat(r104, 0.5f);
        goto L84
    L58:
        if (r104 != 45) goto L61;
        e r124 = this.f399895l;
        r124.U0 = r101.getFloat(r104, 0.5f);
        goto L84
    L61:
        if (r104 != 39) goto L64;
        e r125 = this.f399895l;
        r125.T0 = r101.getFloat(r104, 0.5f);
        goto L84
    L64:
        if (r104 != 47) goto L67;
        e r126 = this.f399895l;
        r126.V0 = r101.getFloat(r104, 0.5f);
        goto L84
    L67:
        if (r104 != 51) goto L70;
        e r127 = this.f399895l;
        r127.R0 = r101.getFloat(r104, 0.5f);
        goto L84
    L70:
        if (r104 != 41) goto L73;
        e r128 = this.f399895l;
        r128.Y0 = r101.getInt(r104, 2);
        goto L84
    L73:
        if (r104 != 50) goto L76;
        e r129 = this.f399895l;
        r129.Z0 = r101.getInt(r104, 2);
        goto L84
    L76:
        if (r104 != 43) goto L79;
        e r130 = this.f399895l;
        r130.W0 = r101.getDimensionPixelSize(r104, 0);
        goto L84
    L79:
        if (r104 != 52) goto L82;
        e r131 = this.f399895l;
        r131.X0 = r101.getDimensionPixelSize(r104, 0);
        goto L84
    L82:
        if (r104 != 49) goto L84;
        e r132 = this.f399895l;
        r132.f399837b1 = r101.getInt(r104, -1);
        goto L84
    L85:
        r101.recycle();
    L86:
        this.f400380d = this.f399895l;
        t();
    }

    public void setFirstHorizontalBias(float r100) {
        this.f399895l.S0 = r100;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int r100) {
        this.f399895l.M0 = r100;
        requestLayout();
    }

    public void setFirstVerticalBias(float r100) {
        this.f399895l.T0 = r100;
        requestLayout();
    }

    public void setFirstVerticalStyle(int r100) {
        this.f399895l.N0 = r100;
        requestLayout();
    }

    public void setHorizontalAlign(int r100) {
        this.f399895l.Y0 = r100;
        requestLayout();
    }

    public void setHorizontalBias(float r100) {
        this.f399895l.Q0 = r100;
        requestLayout();
    }

    public void setHorizontalGap(int r100) {
        this.f399895l.W0 = r100;
        requestLayout();
    }

    public void setHorizontalStyle(int r100) {
        this.f399895l.K0 = r100;
        requestLayout();
    }

    public void setLastHorizontalBias(float r100) {
        this.f399895l.U0 = r100;
        requestLayout();
    }

    public void setLastHorizontalStyle(int r100) {
        this.f399895l.O0 = r100;
        requestLayout();
    }

    public void setLastVerticalBias(float r100) {
        this.f399895l.V0 = r100;
        requestLayout();
    }

    public void setLastVerticalStyle(int r100) {
        this.f399895l.P0 = r100;
        requestLayout();
    }

    public void setMaxElementsWrap(int r100) {
        this.f399895l.f399837b1 = r100;
        requestLayout();
    }

    public void setOrientation(int r100) {
        this.f399895l.f399838c1 = r100;
        requestLayout();
    }

    public void setPadding(int r100) {
        e r101 = this.f399895l;
        r101.f399868z0 = r100;
        r101.A0 = r100;
        r101.B0 = r100;
        r101.C0 = r100;
        requestLayout();
    }

    public void setPaddingBottom(int r100) {
        this.f399895l.A0 = r100;
        requestLayout();
    }

    public void setPaddingLeft(int r100) {
        this.f399895l.D0 = r100;
        requestLayout();
    }

    public void setPaddingRight(int r100) {
        this.f399895l.E0 = r100;
        requestLayout();
    }

    public void setPaddingTop(int r100) {
        this.f399895l.f399868z0 = r100;
        requestLayout();
    }

    public void setVerticalAlign(int r100) {
        this.f399895l.Z0 = r100;
        requestLayout();
    }

    public void setVerticalBias(float r100) {
        this.f399895l.R0 = r100;
        requestLayout();
    }

    public void setVerticalGap(int r100) {
        this.f399895l.X0 = r100;
        requestLayout();
    }

    public void setVerticalStyle(int r100) {
        this.f399895l.L0 = r100;
        requestLayout();
    }

    public void setWrapMode(int r100) {
        this.f399895l.f399836a1 = r100;
        requestLayout();
    }

    public Flow(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onMeasure(int r100, int r101) {
        u(this.f399895l, r100, r101);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void p(ConstraintWidget r100, boolean r101) {
        e r102 = this.f399895l;
        int r103 = r102.B0;
        if (r103 <= 0) goto L5;
    L6:
        if (r101 == false) goto L8;
        r102.D0 = r102.C0;
        r102.E0 = r103;
        return;
    L8:
        r102.D0 = r103;
        r102.E0 = r102.C0;
        return;
    L5:
        if (r102.C0 > 0) goto L6;
    }

    public Flow(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout
    public final void u(i r100, int r101, int r102) {
        int r103 = View.MeasureSpec.getMode(r101);
        int r104 = View.MeasureSpec.getSize(r101);
        int r105 = View.MeasureSpec.getMode(r102);
        int r106 = View.MeasureSpec.getSize(r102);
        if (r100 == null) goto L5;
        r100.U(r103, r104, r105, r106);
        setMeasuredDimension(r100.G0, r100.H0);
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void o(a.C4670a r100, b r101, Constraints.LayoutParams r102, SparseArray r103) {
        super.o(r100, r101, r102, r103);
        if ((r101 instanceof e) == false) goto L8;
        e r104 = (e) r101;
        int r105 = r102.V;
        if (r105 == (-1)) goto L9;
        r104.f399838c1 = r105;
        return;
    L9:
        return;
    }
}
