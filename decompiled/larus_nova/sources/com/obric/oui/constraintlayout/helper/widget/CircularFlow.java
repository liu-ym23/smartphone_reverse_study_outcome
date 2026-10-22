package com.obric.oui.constraintlayout.helper.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes34.dex */
public class CircularFlow extends VirtualLayout {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f399883v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static float f399884w;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ConstraintLayout f399885l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f399886m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f399887n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f399888o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f399889p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f399890q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f399891r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f399892s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Float f399893t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Integer f399894u;

    public float[] getAngles() {
        return Arrays.copyOf(this.f399887n, this.f399890q);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f399888o, this.f399889p);
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r100 = this.f399891r;
        if (r100 == null) goto L5;
        this.f399887n = new float[1];
        setAngles(r100);
    L5:
        String r101 = this.f399892s;
        if (r101 == null) goto L8;
        this.f399888o = new int[1];
        setRadius(r101);
    L8:
        Float r102 = this.f399893t;
        if (r102 == null) goto L11;
        setDefaultAngle(r102.floatValue());
    L11:
        Integer r103 = this.f399894u;
        if (r103 == null) goto L14;
        setDefaultRadius(r103.intValue());
    L14:
        this.f399885l = (ConstraintLayout) getParent();
        int r104 = 0;
    L16:
        if (r104 >= this.f400378b) goto L50;
        View r105 = this.f399885l.b(this.f400377a[r104]);
        if (r105 == null) goto L49;
        int r106 = f399883v;
        float r107 = f399884w;
        int[] r108 = this.f399888o;
        if (r108 != null) goto L23;
    L25:
        Integer r109 = this.f399894u;
        if (r109 != null) goto L28;
    L33:
        String r110 = this.f400385i.get(Integer.valueOf(r105.getId()));
    L34:
        float[] r111 = this.f399887n;
        if (r111 != null) goto L37;
    L39:
        Float r112 = this.f399893t;
        if (r112 != null) goto L42;
    L47:
        String r113 = this.f400385i.get(Integer.valueOf(r105.getId()));
    L48:
        ConstraintLayout.LayoutParams r114 = (ConstraintLayout.LayoutParams) r105.getLayoutParams();
        r114.f400437r = r107;
        r114.f400433p = this.f399886m;
        r114.f400435q = r106;
        r105.setLayoutParams(r114);
        goto L49
    L42:
        if (r112.floatValue() == (-1.0f)) goto L47;
        this.f399890q++;
        if (this.f399887n != null) goto L46;
        this.f399887n = new float[1];
    L46:
        float[] r115 = getAngles();
        this.f399887n = r115;
        r115[this.f399890q - 1] = r107;
        goto L48
    L37:
        if (r104 >= r111.length) goto L39;
        r107 = r111[r104];
        goto L48
    L28:
        if (r109.intValue() == (-1)) goto L33;
        this.f399889p++;
        if (this.f399888o != null) goto L32;
        this.f399888o = new int[1];
    L32:
        int[] r116 = getRadius();
        this.f399888o = r116;
        r116[this.f399889p - 1] = r106;
        goto L34
    L23:
        if (r104 >= r108.length) goto L25;
        r106 = r108[r104];
    L49:
        r104 = r104 + 1;
        goto L16
    L50:
        h();
    }

    public CircularFlow(Context r100) {
        super(r100);
    }

    private void setAngles(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = 0;
        this.f399890q = 0;
    L5:
        int r102 = r100.indexOf(44, r101);
        if (r102 == (-1)) goto L7;
        v(r100.substring(r101, r102).trim());
        r101 = r102 + 1;
        goto L5
    L7:
        v(r100.substring(r101).trim());
    }

    private void setRadius(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = 0;
        this.f399889p = 0;
    L5:
        int r102 = r100.indexOf(44, r101);
        if (r102 == (-1)) goto L7;
        w(r100.substring(r101, r102).trim());
        r101 = r102 + 1;
        goto L5
    L7:
        w(r100.substring(r101).trim());
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void n(AttributeSet r100) {
        super.n(r100);
        if (r100 == null) goto L31;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.orientation, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.paddingStart, R.attr.paddingEnd, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.elevation, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.circularflow_angles, com.larus.nova.R.attr.circularflow_defaultAngle, com.larus.nova.R.attr.circularflow_defaultRadius, com.larus.nova.R.attr.circularflow_radiusInDP, com.larus.nova.R.attr.circularflow_viewCenter, com.larus.nova.R.attr.constraintSet, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layoutDescription, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_optimizationLevel, com.larus.nova.R.attr.layout_wrapBehaviorInParent});
        int r102 = r101.getIndexCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L22;
        int r104 = r101.getIndex(r103);
        if (r104 != 33) goto L10;
        this.f399886m = r101.getResourceId(r104, 0);
    L21:
        r103 = r103 + 1;
        goto L5
    L10:
        if (r104 != 29) goto L13;
        String r105 = r101.getString(r104);
        this.f399891r = r105;
        setAngles(r105);
        goto L21
    L13:
        if (r104 != 32) goto L16;
        String r106 = r101.getString(r104);
        this.f399892s = r106;
        setRadius(r106);
        goto L21
    L16:
        if (r104 != 30) goto L19;
        Float r107 = Float.valueOf(r101.getFloat(r104, f399884w));
        this.f399893t = r107;
        setDefaultAngle(r107.floatValue());
        goto L21
    L19:
        if (r104 != 31) goto L21;
        Integer r108 = Integer.valueOf(r101.getDimensionPixelSize(r104, f399883v));
        this.f399894u = r108;
        setDefaultRadius(r108.intValue());
        goto L21
    L22:
        r101.recycle();
        return;
    }

    public void setDefaultAngle(float r100) {
        f399884w = r100;
    }

    public void setDefaultRadius(int r100) {
        f399883v = r100;
    }

    public final void v(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() != 0) goto L7;
        return;
    L7:
        if (this.f400379c != null) goto L9;
        return;
    L9:
        float[] r101 = this.f399887n;
        if (r101 != null) goto L13;
        return;
    L13:
        if ((this.f399890q + 1) <= r101.length) goto L15;
        this.f399887n = Arrays.copyOf(r101, r101.length + 1);
    L15:
        this.f399887n[this.f399890q] = CastIntegerProtector.parseInt(r100);
        this.f399890q++;
    }

    public final void w(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() != 0) goto L7;
        return;
    L7:
        if (this.f400379c != null) goto L9;
        return;
    L9:
        int[] r101 = this.f399888o;
        if (r101 != null) goto L13;
        return;
    L13:
        if ((this.f399889p + 1) <= r101.length) goto L15;
        this.f399888o = Arrays.copyOf(r101, r101.length + 1);
    L15:
        int[] r102 = this.f399888o;
        int r103 = this.f399889p;
        float r104 = CastIntegerProtector.parseInt(r100);
        Resources r105 = this.f400379c.getResources();
        r102[r103] = (int) (r104 * WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density);
        this.f399889p++;
    }

    public CircularFlow(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public CircularFlow(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
