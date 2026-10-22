package com.bytedance.locallife.pdp.groupondetail.view.baseview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.text.TextUtilsCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes21.dex */
public class PdpFlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<View>> f261447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f261448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f261449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f261450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<View> f261451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f261452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f261453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f261454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f261455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f261456j;

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public int getVisibleViewCount() {
        Iterator r100 = ((ArrayList) this.f261447a).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + ((List) r100.next()).size();
        goto L4
    L6:
        return r101;
    }

    public PdpFlowLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    public void setMaxLine(int r100) {
        this.f261454h = r100;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new ViewGroup.MarginLayoutParams(r100);
    }

    public PdpFlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r210, int r211) {
        int r100 = View.MeasureSpec.getSize(r210);
        View.MeasureSpec.getMode(r210);
        int r101 = View.MeasureSpec.getSize(r211);
        int r102 = View.MeasureSpec.getMode(r211);
        int r103 = getChildCount();
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
        int r110 = 0;
        int r111 = 0;
        int r112 = 1;
    L3:
        if (r104 >= r103) goto L28;
        View r113 = getChildAt(r104);
        if (r113.getVisibility() == 8) goto L7;
        measureChild(r113, r210, r211);
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r113.getLayoutParams();
        int r114 = (r113.getMeasuredWidth() + r107.leftMargin) + r107.rightMargin;
        int r115 = r101;
        int r108 = (r113.getMeasuredHeight() + r107.topMargin) + r107.bottomMargin;
        if ((r105 + r114) <= ((r100 - getPaddingLeft()) - getPaddingRight())) goto L23;
        int r109 = (((r100 - getPaddingLeft()) - getPaddingRight()) - r105) - this.f261453g;
        if (this.f261455i == true) goto L15;
    L17:
        int r116 = Math.max(r110, r105);
        int r117 = r114 + this.f261453g;
        r111 = r111 + r106;
        r106 = r108;
    L18:
        r112 = r112 + 1;
        int r118 = this.f261454h;
        if (r118 <= 0) goto L22;
        if (r112 <= r118) goto L22;
    L29:
        if (r106 <= 0) goto L32;
        r111 = r111 + (((r111 / r106) - 1) * this.f261452f);
    L32:
        if (r102 != 1073741824) goto L34;
        int r119 = r115;
    L35:
        setMeasuredDimension(r100, r119);
        return;
    L34:
        r119 = getPaddingBottom() + (r111 + getPaddingTop());
    L22:
        r110 = r116;
        r105 = r117;
    L25:
        if (r104 != (r103 - 1)) goto L27;
        r110 = Math.max(r105, r110);
        r111 = r111 + r106;
    L27:
        r104 = r104 + 1;
        r101 = r115;
        goto L3
    L15:
        if (r109 < this.f261456j) goto L17;
        r107.width = r109;
        r113.setLayoutParams(r107);
        int r120 = r105 + (r109 + this.f261453g);
        int r121 = Math.max(r106, r108);
        r116 = Math.max(r110, r120);
        r111 = r111 + r121;
        r106 = 0;
        r117 = 0;
        goto L18
    L23:
        r105 = r105 + (r114 + this.f261453g);
        r106 = Math.max(r106, r108);
        goto L25
    L7:
        if (r104 != (r103 - 1)) goto L9;
        r110 = Math.max(r105, r110);
        r111 = r111 + r106;
    L9:
        r115 = r101;
        goto L27
    L28:
        r115 = r101;
        goto L29
    }

    public PdpFlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f261447a = new ArrayList();
        this.f261448b = new ArrayList();
        this.f261449c = new ArrayList();
        this.f261451e = new ArrayList();
        this.f261452f = 0;
        this.f261453g = 0;
        this.f261454h = 0;
        this.f261455i = false;
        this.f261456j = 0;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.pdp_max_select, R.attr.pdp_tag_adjust_last, R.attr.pdp_tag_gravity, R.attr.pdp_tag_last_min, R.attr.pdp_tag_maxline, R.attr.pdp_tag_space_horizontal, R.attr.pdp_tag_space_vertical});
        int r104 = r103.getInt(2, -1);
        this.f261450d = r104;
        this.f261453g = r103.getDimensionPixelSize(5, 0);
        this.f261452f = r103.getDimensionPixelSize(6, 0);
        this.f261454h = r103.getInteger(4, 0);
        this.f261455i = r103.getBoolean(1, false);
        this.f261456j = r103.getDimensionPixelSize(3, 0);
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L7;
        if (r104 != (-1)) goto L6;
        this.f261450d = 1;
        goto L7
    L6:
        this.f261450d = -1;
    L7:
        r103.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r210, int r211, int r212) {
        ((ArrayList) this.f261447a).clear();
        ((ArrayList) this.f261448b).clear();
        ((ArrayList) this.f261449c).clear();
        this.f261451e.clear();
        int r100 = getWidth();
        int r101 = getChildCount();
        int r102 = 1;
        int r103 = 0;
        int r104 = 0;
        int r105 = 1;
        int r106 = 0;
    L4:
        if (r103 >= r101) goto L17;
        View r112 = getChildAt(r103);
        if (r112.getVisibility() == 8) goto L16;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112.getLayoutParams();
        int r114 = (r112.getMeasuredWidth() + r113.leftMargin) + r113.rightMargin;
        int r115 = (r112.getMeasuredHeight() + r113.topMargin) + r113.bottomMargin;
        if ((r114 + r104) <= ((r100 - getPaddingLeft()) - getPaddingRight())) goto L15;
        r105 = r105 + 1;
        int r116 = this.f261454h;
        if (r116 <= 0) goto L14;
        if (r105 > r116) goto L17;
    L14:
        List<Integer> r107 = this.f261448b;
        ArrayList r108 = (ArrayList) r107;
        r108.add(Integer.valueOf(r106));
        List<List<View>> r109 = this.f261447a;
        ArrayList r117 = (ArrayList) r109;
        r117.add(this.f261451e);
        List<Integer> r118 = this.f261449c;
        ArrayList r119 = (ArrayList) r118;
        r119.add(Integer.valueOf(r104));
        this.f261451e = new ArrayList();
        r106 = r115;
        r104 = 0;
    L15:
        r104 = r104 + (r114 + this.f261453g);
        r106 = Math.max(r106, r115);
        this.f261451e.add(r112);
    L16:
        r103 = r103 + 1;
    L17:
        List<Integer> r120 = this.f261448b;
        ArrayList r121 = (ArrayList) r120;
        r121.add(Integer.valueOf(r106));
        List<Integer> r122 = this.f261449c;
        ArrayList r123 = (ArrayList) r122;
        r123.add(Integer.valueOf(r104));
        List<List<View>> r124 = this.f261447a;
        ArrayList r125 = (ArrayList) r124;
        r125.add(this.f261451e);
        int r126 = getPaddingLeft();
        int r127 = getPaddingTop();
        int r128 = ((ArrayList) this.f261447a).size();
        int r129 = 0;
    L18:
        if (r129 >= r128) goto L35;
        List<View> r130 = (List) ListProtector.get(this.f261447a, r129);
        this.f261451e = r130;
        int r131 = r130.size();
        int r132 = ((Integer) ListProtector.get(this.f261448b, r129)).intValue() + this.f261452f;
        int r133 = ((Integer) ListProtector.get(this.f261449c, r129)).intValue();
        int r134 = this.f261450d;
        if (r134 == (-1)) goto L26;
        if (r134 == 0) goto L25;
        if (r134 != r102) goto L27;
        r126 = (r100 - (r133 + getPaddingLeft())) - getPaddingRight();
        Collections.reverse(this.f261451e);
    L27:
        int r135 = 0;
    L28:
        if (r135 >= r131) goto L34;
        View r136 = (View) ListProtector.get(this.f261451e, r135);
        if (r136.getVisibility() == 8) goto L33;
        ViewGroup.MarginLayoutParams r137 = (ViewGroup.MarginLayoutParams) r136.getLayoutParams();
        int r138 = r137.leftMargin + r126;
        int r139 = r137.topMargin + r127;
        r136.layout(r138, r139, r138 + r136.getMeasuredWidth(), r139 + r136.getMeasuredHeight());
        r126 = r126 + (((r136.getMeasuredWidth() + r137.leftMargin) + r137.rightMargin) + this.f261453g);
    L33:
        r135 = r135 + 1;
        goto L28
    L34:
        r127 = r127 + r132;
        r129 = r129 + 1;
        r102 = 1;
        goto L18
    L25:
        r126 = ((r100 - r133) / 2) + getPaddingLeft();
        goto L27
    L26:
        r126 = getPaddingLeft();
        goto L27
    }
}
