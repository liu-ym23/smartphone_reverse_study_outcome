package com.larksuite.framework.ui.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<View>> f285849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f285850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f285851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f285852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<View> f285853e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Gravity {
        public static final int CENTER = 0;
        public static final int LEFT = -1;
        public static final int RIGHT = 1;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public FlowLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    public void setGravity(int r100) {
        this.f285852d = r100;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new ViewGroup.MarginLayoutParams(r100);
    }

    public FlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public void onMeasure(int r110, int r210) {
        int r100 = View.MeasureSpec.getSize(r110);
        int r101 = View.MeasureSpec.getMode(r110);
        int r102 = View.MeasureSpec.getSize(r210);
        int r103 = View.MeasureSpec.getMode(r210);
        int r104 = getChildCount();
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
        int r108 = 0;
        int r111 = 0;
    L3:
        if (r105 >= r104) goto L19;
        View r112 = getChildAt(r105);
        if (r112.getVisibility() == 8) goto L7;
        measureChild(r112, r110, r210);
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112.getLayoutParams();
        int r114 = (r112.getMeasuredWidth() + r113.leftMargin) + r113.rightMargin;
        int r109 = (r112.getMeasuredHeight() + r113.topMargin) + r113.bottomMargin;
        int r115 = r107 + r114;
        if (r115 <= ((r100 - getPaddingLeft()) - getPaddingRight())) goto L13;
        r106 = Math.max(r106, r107);
        r111 = r111 + r108;
    L15:
        if (r105 != (r104 - 1)) goto L17;
        r106 = Math.max(r114, r106);
        r111 = r111 + r109;
    L17:
        r108 = r109;
        r107 = r114;
    L18:
        r105 = r105 + 1;
        r102 = r102;
        goto L3
    L13:
        r109 = Math.max(r108, r109);
        r114 = r115;
        goto L15
    L7:
        if (r105 != (r104 - 1)) goto L18;
        r106 = Math.max(r107, r106);
        r111 = r111 + r108;
        goto L18
    L19:
        int r116 = r102;
        if (r101 == 1073741824) goto L23;
        r100 = getPaddingRight() + (r106 + getPaddingLeft());
    L23:
        if (r103 != 1073741824) goto L25;
        int r117 = r116;
    L26:
        setMeasuredDimension(r100, r117);
        return;
    L25:
        r117 = (r111 + getPaddingTop()) + getPaddingBottom();
        goto L26
    }

    public FlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f285849a = new ArrayList();
        this.f285850b = new ArrayList();
        this.f285851c = new ArrayList();
        this.f285853e = new ArrayList();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.auto_select_effect, R.attr.gravity, R.attr.marginOutside, R.attr.maxLines, R.attr.max_select, R.attr.paddingBottom, R.attr.paddingEnd, R.attr.paddingStart, R.attr.paddingTop, R.attr.rowSpacing, R.attr.tag_gravity_ec, R.attr.tag_maxline, R.attr.tag_space_horizontal, R.attr.tag_space_vertical, R.attr.textColor, R.attr.textSize});
        this.f285852d = r103.getInt(1, -1);
        r103.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        ((ArrayList) this.f285849a).clear();
        ((ArrayList) this.f285850b).clear();
        ((ArrayList) this.f285851c).clear();
        this.f285853e.clear();
        int r115 = getWidth();
        int r116 = getChildCount();
        int r117 = 0;
        int r118 = 0;
        int r100 = 0;
    L4:
        if (r117 >= r116) goto L13;
        View r101 = getChildAt(r117);
        if (r101.getVisibility() == 8) goto L12;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101.getLayoutParams();
        int r103 = r101.getMeasuredWidth();
        int r104 = r101.getMeasuredHeight();
        if ((((r103 + r100) + r102.leftMargin) + r102.rightMargin) <= ((r115 - getPaddingLeft()) - getPaddingRight())) goto L11;
        List<Integer> r105 = this.f285850b;
        ArrayList r106 = (ArrayList) r105;
        r106.add(Integer.valueOf(r118));
        List<List<View>> r119 = this.f285849a;
        ArrayList r120 = (ArrayList) r119;
        r120.add(this.f285853e);
        List<Integer> r121 = this.f285851c;
        ArrayList r122 = (ArrayList) r121;
        r122.add(Integer.valueOf(r100));
        r118 = (r102.topMargin + r104) + r102.bottomMargin;
        this.f285853e = new ArrayList();
        r100 = 0;
    L11:
        r100 = r100 + ((r103 + r102.leftMargin) + r102.rightMargin);
        r118 = Math.max(r118, (r104 + r102.topMargin) + r102.bottomMargin);
        this.f285853e.add(r101);
    L12:
        r117 = r117 + 1;
        goto L4
    L13:
        List<Integer> r123 = this.f285850b;
        ArrayList r124 = (ArrayList) r123;
        r124.add(Integer.valueOf(r118));
        List<Integer> r125 = this.f285851c;
        ArrayList r126 = (ArrayList) r125;
        r126.add(Integer.valueOf(r100));
        List<List<View>> r127 = this.f285849a;
        ArrayList r128 = (ArrayList) r127;
        r128.add(this.f285853e);
        int r129 = getPaddingLeft();
        int r130 = getPaddingTop();
        int r131 = ((ArrayList) this.f285849a).size();
        int r107 = 0;
    L14:
        if (r107 >= r131) goto L34;
        this.f285853e = (List) ListProtector.get(this.f285849a, r107);
        int r108 = ((Integer) ListProtector.get(this.f285850b, r107)).intValue();
        int r109 = ((Integer) ListProtector.get(this.f285851c, r107)).intValue();
        int r132 = this.f285852d;
        if (r132 == (-1)) goto L24;
        if (r132 != 0) goto L19;
        int r133 = (r115 - r109) / 2;
        int r134 = getPaddingLeft();
    L23:
        r129 = r133 + r134;
    L25:
        int r135 = 0;
    L27:
        if (r135 >= this.f285853e.size()) goto L33;
        View r136 = (View) ListProtector.get(this.f285853e, r135);
        if (r136.getVisibility() == 8) goto L32;
        ViewGroup.MarginLayoutParams r137 = (ViewGroup.MarginLayoutParams) r136.getLayoutParams();
        int r138 = r137.leftMargin + r129;
        int r139 = r137.topMargin + r130;
        r136.layout(r138, r139, r136.getMeasuredWidth() + r138, r136.getMeasuredHeight() + r139);
        r129 = r129 + ((r136.getMeasuredWidth() + r137.leftMargin) + r137.rightMargin);
    L32:
        r135 = r135 + 1;
        goto L27
    L33:
        r130 = r130 + r108;
        r107 = r107 + 1;
        goto L14
    L19:
        if (r132 != 1) goto L25;
        r133 = r115 - r109;
        r134 = getPaddingLeft();
        goto L23
    L24:
        r129 = getPaddingLeft();
        goto L25
    }
}
