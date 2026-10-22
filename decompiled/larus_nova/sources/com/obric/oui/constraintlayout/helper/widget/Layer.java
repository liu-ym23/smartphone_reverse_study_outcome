package com.obric.oui.constraintlayout.helper.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.widget.ConstraintHelper;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes34.dex */
public class Layer extends ConstraintHelper {
    public boolean A;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f399911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f399912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f399913l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ConstraintLayout f399914m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f399915n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f399916o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f399917p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f399918q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f399919r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f399920s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f399921t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f399922u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f399923v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View[] f399924w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f399925x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f399926y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f399927z;

    public final void u() {
        if (this.f399914m != null) goto L6;
        return;
    L6:
        if (this.f399923v == true) goto L13;
        if (Float.isNaN(this.f399917p) == true) goto L13;
        if (Float.isNaN(this.f399918q) == true) goto L13;
        return;
    L13:
        if (Float.isNaN(this.f399911j) == false) goto L15;
    L18:
        View[] r100 = m(this.f399914m);
        int r101 = 0;
        int r102 = r100[0].getLeft();
        int r103 = r100[0].getTop();
        int r104 = r100[0].getRight();
        int r105 = r100[0].getBottom();
    L20:
        if (r101 >= this.f400378b) goto L22;
        View r106 = r100[r101];
        r102 = Math.min(r102, r106.getLeft());
        r103 = Math.min(r103, r106.getTop());
        r104 = Math.max(r104, r106.getRight());
        r105 = Math.max(r105, r106.getBottom());
        r101 = r101 + 1;
        goto L20
    L22:
        this.f399919r = r104;
        this.f399920s = r105;
        this.f399921t = r102;
        this.f399922u = r103;
        if (Float.isNaN(this.f399911j) == false) goto L25;
        this.f399917p = (r102 + r104) / 2;
    L27:
        if (Float.isNaN(this.f399912k) == false) goto L29;
        this.f399918q = (r103 + r105) / 2;
        return;
    L29:
        this.f399918q = this.f399912k;
        return;
    L25:
        this.f399917p = this.f399911j;
        goto L27
    L15:
        if (Float.isNaN(this.f399912k) == true) goto L18;
        this.f399918q = this.f399912k;
        this.f399917p = this.f399911j;
    }

    public final void v() {
        if (this.f399914m != null) goto L5;
        return;
    L5:
        int r100 = this.f400378b;
        if (r100 != 0) goto L8;
        return;
    L8:
        View[] r101 = this.f399924w;
        if (r101 != null) goto L11;
    L12:
        this.f399924w = new View[r100];
    L13:
        int r102 = 0;
    L15:
        if (r102 >= this.f400378b) goto L17;
        int r103 = this.f400377a[r102];
        this.f399924w[r102] = this.f399914m.b(r103);
        r102 = r102 + 1;
        goto L15
    L17:
        return;
    L11:
        if (r101.length == r100) goto L13;
        goto L12
    }

    public final void w() {
        if (this.f399914m != null) goto L6;
        return;
    L6:
        if (this.f399924w != null) goto L8;
        v();
    L8:
        u();
        if (Float.isNaN(this.f399913l) == false) goto L11;
        double r100 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L12:
        float r101 = (float) Math.sin(r100);
        float r102 = (float) Math.cos(r100);
        float r103 = this.f399915n;
        float r104 = r103 * r102;
        float r105 = this.f399916o;
        float r106 = (-r105) * r101;
        float r107 = r103 * r101;
        float r108 = r105 * r102;
        int r109 = 0;
    L14:
        if (r109 >= this.f400378b) goto L19;
        View r110 = this.f399924w[r109];
        int r111 = (r110.getLeft() + r110.getRight()) / 2;
        int r112 = (r110.getTop() + r110.getBottom()) / 2;
        float r113 = r111 - this.f399917p;
        float r114 = r112 - this.f399918q;
        float r115 = (((r104 * r113) + (r106 * r114)) - r113) + this.f399925x;
        float r116 = (((r113 * r107) + (r108 * r114)) - r114) + this.f399926y;
        r110.setTranslationX(r115);
        r110.setTranslationY(r116);
        r110.setScaleY(this.f399916o);
        r110.setScaleX(this.f399915n);
        if (Float.isNaN(this.f399913l) == true) goto L18;
        r110.setRotation(this.f399913l);
    L18:
        r109 = r109 + 1;
        goto L14
    L19:
        return;
    L11:
        r100 = Math.toRadians(this.f399913l);
        goto L12
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f399914m = (ConstraintLayout) getParent();
        if (this.f399927z == false) goto L5;
    L6:
        int r100 = getVisibility();
        float r101 = getElevation();
        int r102 = 0;
    L8:
        if (r102 >= this.f400378b) goto L26;
        int r103 = this.f400377a[r102];
        View r104 = this.f399914m.b(r103);
        if (r104 == null) goto L19;
        if (this.f399927z == false) goto L15;
        r104.setVisibility(r100);
    L15:
        if (this.A == false) goto L19;
        if (r101 <= 0.0f) goto L19;
        r104.setTranslationZ(r104.getTranslationZ() + r101);
    L19:
        r102 = r102 + 1;
        goto L8
    L26:
        return;
    L5:
        if (this.A == true) goto L6;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void q() {
        v();
        this.f399917p = Float.NaN;
        this.f399918q = Float.NaN;
        ConstraintWidget r100 = ((ConstraintLayout.LayoutParams) getLayoutParams()).f400436q0;
        r100.Q(0);
        r100.N(0);
        u();
        layout(((int) this.f399921t) - getPaddingLeft(), ((int) this.f399922u) - getPaddingTop(), ((int) this.f399919r) + getPaddingRight(), ((int) this.f399920s) + getPaddingBottom());
        w();
    }

    public Layer(Context r100) {
        super(r100);
        this.f399911j = Float.NaN;
        this.f399912k = Float.NaN;
        this.f399913l = Float.NaN;
        this.f399915n = 1.0f;
        this.f399916o = 1.0f;
        this.f399917p = Float.NaN;
        this.f399918q = Float.NaN;
        this.f399919r = Float.NaN;
        this.f399920s = Float.NaN;
        this.f399921t = Float.NaN;
        this.f399922u = Float.NaN;
        this.f399923v = true;
        this.f399924w = null;
        this.f399925x = 0.0f;
        this.f399926y = 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void j(ConstraintLayout r100) {
        i(r100);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void n(AttributeSet r100) {
        super.n(r100);
        int r101 = 0;
        this.f400381e = false;
        if (r100 == null) goto L19;
        TypedArray r102 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.orientation, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.paddingStart, R.attr.paddingEnd, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.elevation, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.circularflow_angles, com.larus.nova.R.attr.circularflow_defaultAngle, com.larus.nova.R.attr.circularflow_defaultRadius, com.larus.nova.R.attr.circularflow_radiusInDP, com.larus.nova.R.attr.circularflow_viewCenter, com.larus.nova.R.attr.constraintSet, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layoutDescription, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_optimizationLevel, com.larus.nova.R.attr.layout_wrapBehaviorInParent});
        int r103 = r102.getIndexCount();
    L5:
        if (r101 >= r103) goto L13;
        int r104 = r102.getIndex(r101);
        if (r104 != 6) goto L10;
        this.f399927z = true;
    L12:
        r101 = r101 + 1;
        goto L5
    L10:
        if (r104 != 22) goto L12;
        this.A = true;
        goto L12
    L13:
        r102.recycle();
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void r(ConstraintLayout r100) {
        this.f399914m = r100;
        float r101 = getRotation();
        if (r101 == 0.0f) goto L5;
        this.f399913l = r101;
        return;
    L5:
        if (Float.isNaN(this.f399913l) == true) goto L9;
        this.f399913l = r101;
        return;
    }

    @Override // android.view.View
    public void setElevation(float r100) {
        super.setElevation(r100);
        h();
    }

    @Override // android.view.View
    public void setPivotX(float r100) {
        this.f399911j = r100;
        w();
    }

    @Override // android.view.View
    public void setPivotY(float r100) {
        this.f399912k = r100;
        w();
    }

    @Override // android.view.View
    public void setRotation(float r100) {
        this.f399913l = r100;
        w();
    }

    @Override // android.view.View
    public void setScaleX(float r100) {
        this.f399915n = r100;
        w();
    }

    @Override // android.view.View
    public void setScaleY(float r100) {
        this.f399916o = r100;
        w();
    }

    @Override // android.view.View
    public void setTranslationX(float r100) {
        this.f399925x = r100;
        w();
    }

    @Override // android.view.View
    public void setTranslationY(float r100) {
        this.f399926y = r100;
        w();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        h();
    }

    public Layer(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f399911j = Float.NaN;
        this.f399912k = Float.NaN;
        this.f399913l = Float.NaN;
        this.f399915n = 1.0f;
        this.f399916o = 1.0f;
        this.f399917p = Float.NaN;
        this.f399918q = Float.NaN;
        this.f399919r = Float.NaN;
        this.f399920s = Float.NaN;
        this.f399921t = Float.NaN;
        this.f399922u = Float.NaN;
        this.f399923v = true;
        this.f399924w = null;
        this.f399925x = 0.0f;
        this.f399926y = 0.0f;
    }

    public Layer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f399911j = Float.NaN;
        this.f399912k = Float.NaN;
        this.f399913l = Float.NaN;
        this.f399915n = 1.0f;
        this.f399916o = 1.0f;
        this.f399917p = Float.NaN;
        this.f399918q = Float.NaN;
        this.f399919r = Float.NaN;
        this.f399920s = Float.NaN;
        this.f399921t = Float.NaN;
        this.f399922u = Float.NaN;
        this.f399923v = true;
        this.f399924w = null;
        this.f399925x = 0.0f;
        this.f399926y = 0.0f;
    }
}
