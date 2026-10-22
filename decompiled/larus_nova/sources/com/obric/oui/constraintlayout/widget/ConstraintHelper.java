package com.obric.oui.constraintlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public abstract class ConstraintHelper extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f400377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f400378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f400379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ula.b f400380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f400381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f400382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f400383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View[] f400384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap<Integer, String> f400385i;

    public void j(ConstraintLayout r100) {
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
    }

    public void p(ConstraintWidget r100, boolean r101) {
    }

    public void q() {
    }

    public void r(ConstraintLayout r100) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f400377a, this.f400378b);
    }

    public final void t() {
        if (this.f400380d != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r100 = getLayoutParams();
        if ((r100 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ula.b r101 = this.f400380d;
        ((ConstraintLayout.LayoutParams) r100).f400436q0 = r101;
        return;
    }

    public final void h() {
        ViewParent r100 = getParent();
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof ConstraintLayout) == false) goto L9;
        i((ConstraintLayout) r100);
        return;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r100 = this.f400382f;
        if (r100 == null) goto L5;
        setIds(r100);
    L5:
        String r101 = this.f400383g;
        if (r101 == null) goto L9;
        setReferenceTags(r101);
        return;
    }

    public ConstraintHelper(Context r100) {
        super(r100);
        this.f400377a = new int[32];
        this.f400381e = false;
        this.f400384h = null;
        this.f400385i = new HashMap();
        this.f400379c = r100;
        n(null);
    }

    public final void e(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() != 0) goto L7;
        return;
    L7:
        if (this.f400379c != null) goto L9;
        return;
    L9:
        String r101 = r100.trim();
        int r102 = l(r101);
        if (r102 == 0) goto L13;
        this.f400385i.put(Integer.valueOf(r102), r101);
        f(r102);
        return;
    }

    public final void f(int r100) {
        if (r100 != getId()) goto L5;
        return;
    L5:
        int r101 = this.f400378b + 1;
        int[] r102 = this.f400377a;
        if (r101 <= r102.length) goto L8;
        this.f400377a = Arrays.copyOf(r102, r102.length * 2);
    L8:
        int[] r103 = this.f400377a;
        int r104 = this.f400378b;
        r103[r104] = r100;
        this.f400378b = r104 + 1;
    }

    public final void g(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() != 0) goto L7;
        return;
    L7:
        if (this.f400379c != null) goto L9;
        return;
    L9:
        String r101 = r100.trim();
        if ((getParent() instanceof ConstraintLayout) == false) goto L12;
        ConstraintLayout r102 = (ConstraintLayout) getParent();
    L13:
        if (r102 != null) goto L15;
        return;
    L15:
        int r103 = r102.getChildCount();
        int r104 = 0;
    L16:
        if (r104 >= r103) goto L33;
        View r105 = r102.getChildAt(r104);
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof ConstraintLayout.LayoutParams) == false) goto L25;
        if (r101.equals(((ConstraintLayout.LayoutParams) r106).Y) == false) goto L25;
        if (r105.getId() == (-1)) goto L25;
        f(r105.getId());
    L25:
        r104 = r104 + 1;
        goto L16
    L33:
        return;
    L12:
        r102 = null;
        goto L13
    }

    public final void i(ConstraintLayout r100) {
        int r101 = getVisibility();
        float r102 = getElevation();
        int r103 = 0;
    L4:
        if (r103 >= this.f400378b) goto L11;
        View r104 = r100.b(this.f400377a[r103]);
        if (r104 == null) goto L10;
        r104.setVisibility(r101);
        if (r102 <= 0.0f) goto L10;
        r104.setTranslationZ(r104.getTranslationZ() + r102);
    L10:
        r103 = r103 + 1;
        goto L4
    }

    public final int l(String r100) {
        if ((getParent() instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r101 = (ConstraintLayout) getParent();
    L7:
        if (isInEditMode() == false) goto L20;
        if (r101 == null) goto L20;
        if ((r100 instanceof String) == false) goto L16;
        HashMap<String, Integer> r102 = r101.f400399m;
        if (r102 == null) goto L16;
        if (r102.containsKey(r100) == false) goto L16;
        Integer r103 = r101.f400399m.get(r100);
    L18:
        if ((r103 instanceof Integer) == false) goto L20;
        int r104 = r103.intValue();
    L21:
        if (r104 != 0) goto L24;
        if (r101 == null) goto L24;
        r104 = k(r101, r100);
    L24:
        if (r104 == 0) goto L31;
    L28:
        if (r104 == 0) goto L30;
        return r104;
    L30:
        return this.f400379c.getResources().getIdentifier(r100, "id", this.f400379c.getPackageName());
    L31:
        r104 = R.id.class.getField(r100).getInt(null);     // Catch: Exception -> L27
    L16:
        r103 = null;
    L20:
        r104 = 0;
        goto L21
    L5:
        r101 = null;
        goto L7
    }

    public final View[] m(ConstraintLayout r100) {
        View[] r101 = this.f400384h;
        if (r101 != null) goto L5;
    L6:
        this.f400384h = new View[this.f400378b];
    L7:
        int r102 = 0;
    L9:
        if (r102 >= this.f400378b) goto L12;
        int r103 = this.f400377a[r102];
        this.f400384h[r102] = r100.b(r103);
        r102 = r102 + 1;
        goto L9
    L12:
        return this.f400384h;
    L5:
        if (r101.length == this.f400378b) goto L7;
        goto L6
    }

    public void n(AttributeSet r100) {
        if (r100 == null) goto L18;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.orientation, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.paddingStart, R.attr.paddingEnd, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.elevation, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.circularflow_angles, com.larus.nova.R.attr.circularflow_defaultAngle, com.larus.nova.R.attr.circularflow_defaultRadius, com.larus.nova.R.attr.circularflow_radiusInDP, com.larus.nova.R.attr.circularflow_viewCenter, com.larus.nova.R.attr.constraintSet, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layoutDescription, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_optimizationLevel, com.larus.nova.R.attr.layout_wrapBehaviorInParent});
        int r102 = r101.getIndexCount();
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L12;
        int r104 = r101.getIndex(r103);
        if (r104 != 35) goto L9;
        String r105 = r101.getString(r104);
        this.f400382f = r105;
        setIds(r105);
    L11:
        r103 = r103 + 1;
        goto L4
    L9:
        if (r104 != 36) goto L11;
        String r106 = r101.getString(r104);
        this.f400383g = r106;
        setReferenceTags(r106);
        goto L11
    L12:
        r101.recycle();
        return;
    }

    public void setIds(String r100) {
        this.f400382f = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = 0;
        this.f400378b = 0;
    L6:
        int r102 = r100.indexOf(44, r101);
        if (r102 == (-1)) goto L8;
        e(r100.substring(r101, r102));
        r101 = r102 + 1;
        goto L6
    L8:
        e(r100.substring(r101));
    }

    public void setReferenceTags(String r100) {
        this.f400383g = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = 0;
        this.f400378b = 0;
    L6:
        int r102 = r100.indexOf(44, r101);
        if (r102 == (-1)) goto L8;
        g(r100.substring(r101, r102));
        r101 = r102 + 1;
        goto L6
    L8:
        g(r100.substring(r101));
    }

    public void setReferencedIds(int[] r100) {
        this.f400382f = null;
        int r101 = 0;
        this.f400378b = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        f(r100[r101]);
        r101 = r101 + 1;
        goto L4
    }

    public ConstraintHelper(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f400377a = new int[32];
        this.f400381e = false;
        this.f400384h = null;
        this.f400385i = new HashMap();
        this.f400379c = r100;
        n(r101);
    }

    public final int k(ConstraintLayout r100, String r101) {
        if (r101 == null) goto L21;
        if (r100 == null) goto L21;
        Resources r102 = this.f400379c.getResources();
        if (r102 != null) goto L9;
        return 0;
    L9:
        int r103 = r100.getChildCount();
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L21;
        View r105 = r100.getChildAt(r104);
        if (r105.getId() == (-1)) goto L20;
        String r106 = r102.getResourceEntryName(r105.getId());     // Catch: Resources.NotFoundException -> L15
    L17:
        if (r101.equals(r106) == false) goto L20;
        return r105.getId();
    L15:
        r106 = null;
    L20:
        r104 = r104 + 1;
    L21:
        return 0;
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        if (this.f400381e == false) goto L5;
        super.onMeasure(r100, r101);
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    public void s(ula.a r100, SparseArray r101) {
        r100.removeAllIds();
        int r102 = 0;
    L4:
        if (r102 >= this.f400378b) goto L6;
        r100.b((ConstraintWidget) r101.get(this.f400377a[r102]));
        r102 = r102 + 1;
        goto L4
    }

    @Override // android.view.View
    public final void setTag(int r100, Object r101) {
        super.setTag(r100, r101);
        if (r101 == null) goto L5;
        return;
    L5:
        if (this.f400382f != null) goto L9;
        f(r100);
        return;
    }

    public ConstraintHelper(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f400377a = new int[32];
        this.f400381e = false;
        this.f400384h = null;
        this.f400385i = new HashMap();
        this.f400379c = r100;
        n(r101);
    }

    public void o(a.C4670a r100, ula.b r101, Constraints.LayoutParams r110, SparseArray r111) {
        a.b r112 = r100.f400490e;
        int[] r102 = r112.f400527j0;
        int r103 = 0;
        if (r102 == null) goto L5;
        setReferencedIds(r102);
    L21:
        r101.removeAllIds();
        if (r100.f400490e.f400527j0 == null) goto L29;
    L23:
        int[] r113 = r100.f400490e.f400527j0;
        if (r103 >= r113.length) goto L36;
        ConstraintWidget r114 = (ConstraintWidget) r111.get(r113[r103]);
        if (r114 == null) goto L28;
        r101.b(r114);
    L28:
        r103 = r103 + 1;
        goto L23
    L36:
        return;
    L29:
        return;
    L5:
        String r115 = r112.f400529k0;
        if (r115 == null) goto L21;
        if (r115.length() <= 0) goto L20;
        a.b r116 = r100.f400490e;
        String[] r104 = r116.f400529k0.split(",");
        int[] r105 = new int[r104.length];
        int r106 = 0;
        int r107 = 0;
    L11:
        if (r106 >= r104.length) goto L17;
        int r108 = l(r104[r106].trim());
        if (r108 == 0) goto L15;
        r105[r107] = r108;
        r107 = r107 + 1;
    L15:
        r106 = r106 + 1;
        goto L11
    L17:
        if (r107 == r104.length) goto L19;
        r105 = Arrays.copyOf(r105, r107);
    L19:
        r116.f400527j0 = r105;
        goto L21
    L20:
        r100.f400490e.f400527j0 = null;
        goto L21
    }
}
