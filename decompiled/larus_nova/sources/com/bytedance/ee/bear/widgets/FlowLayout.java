package com.bytedance.ee.bear.widgets;

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
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes18.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<View>> f240102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f240103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f240104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f240105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<View> f240106e;

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

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new ViewGroup.MarginLayoutParams(r100);
    }

    public FlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = View.MeasureSpec.getSize(r110);
        int r101 = View.MeasureSpec.getMode(r110);
        int r102 = View.MeasureSpec.getSize(r111);
        int r103 = View.MeasureSpec.getMode(r111);
        int r104 = getChildCount();
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
        int r108 = 0;
        int r112 = 0;
    L3:
        if (r105 >= r104) goto L19;
        View r113 = getChildAt(r105);
        if (r113.getVisibility() == 8) goto L7;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113.getLayoutParams();
        measureChild(r113, (r110 - r114.leftMargin) - r114.rightMargin, (r111 - r114.topMargin) - r114.bottomMargin);
        int r115 = (r113.getMeasuredWidth() + r114.leftMargin) + r114.rightMargin;
        int r116 = (r113.getMeasuredHeight() + r114.topMargin) + r114.bottomMargin;
        int r117 = r107 + r115;
        if (r117 <= ((r100 - getPaddingLeft()) - getPaddingRight())) goto L12;
        r106 = Math.max(r106, r107);
        r112 = r112 + r108;
    L14:
        if (r105 != (r104 - 1)) goto L16;
        r106 = Math.max(r115, r106);
        r112 = r112 + r116;
    L16:
        r108 = r116;
        r107 = r115;
    L17:
        r105 = r105 + 1;
        goto L3
    L12:
        r116 = Math.max(r108, r116);
        r115 = r117;
        goto L14
    L7:
        if (r105 != (r104 - 1)) goto L17;
        r106 = Math.max(r107, r106);
        r112 = r112 + r108;
        goto L17
    L19:
        if (r101 == 1073741824) goto L22;
        r100 = getPaddingRight() + (r106 + getPaddingLeft());
    L22:
        if (r103 == 1073741824) goto L25;
        r102 = (r112 + getPaddingTop()) + getPaddingBottom();
    L25:
        setMeasuredDimension(r100, r102);
    }

    public FlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f240102a = new ArrayList();
        this.f240103b = new ArrayList();
        this.f240104c = new ArrayList();
        this.f240106e = new ArrayList();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.max_select, R.attr.tag_gravity});
        int r104 = r103.getInt(1, -1);
        this.f240105d = r104;
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L7;
        if (r104 != (-1)) goto L6;
        this.f240105d = 1;
        goto L7
    L6:
        this.f240105d = -1;
    L7:
        r103.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        ((ArrayList) this.f240102a).clear();
        ((ArrayList) this.f240103b).clear();
        ((ArrayList) this.f240104c).clear();
        this.f240106e.clear();
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
        List<Integer> r105 = this.f240103b;
        ArrayList r106 = (ArrayList) r105;
        r106.add(Integer.valueOf(r118));
        List<List<View>> r119 = this.f240102a;
        ArrayList r120 = (ArrayList) r119;
        r120.add(this.f240106e);
        List<Integer> r121 = this.f240104c;
        ArrayList r122 = (ArrayList) r121;
        r122.add(Integer.valueOf(r100));
        r118 = (r102.topMargin + r104) + r102.bottomMargin;
        this.f240106e = new ArrayList();
        r100 = 0;
    L11:
        r100 = r100 + ((r103 + r102.leftMargin) + r102.rightMargin);
        r118 = Math.max(r118, (r104 + r102.topMargin) + r102.bottomMargin);
        this.f240106e.add(r101);
    L12:
        r117 = r117 + 1;
        goto L4
    L13:
        List<Integer> r123 = this.f240103b;
        ArrayList r124 = (ArrayList) r123;
        r124.add(Integer.valueOf(r118));
        List<Integer> r125 = this.f240104c;
        ArrayList r126 = (ArrayList) r125;
        r126.add(Integer.valueOf(r100));
        List<List<View>> r127 = this.f240102a;
        ArrayList r128 = (ArrayList) r127;
        r128.add(this.f240106e);
        int r129 = getPaddingLeft();
        int r130 = getPaddingTop();
        int r131 = ((ArrayList) this.f240102a).size();
        int r107 = 0;
    L14:
        if (r107 >= r131) goto L33;
        this.f240106e = (List) ListProtector.get(this.f240102a, r107);
        int r108 = ((Integer) ListProtector.get(this.f240103b, r107)).intValue();
        int r109 = ((Integer) ListProtector.get(this.f240104c, r107)).intValue();
        int r132 = this.f240105d;
        if (r132 == (-1)) goto L23;
        if (r132 != 0) goto L19;
        r129 = ((r115 - r109) / 2) + getPaddingLeft();
    L24:
        int r133 = 0;
    L26:
        if (r133 >= this.f240106e.size()) goto L32;
        View r134 = (View) ListProtector.get(this.f240106e, r133);
        if (r134.getVisibility() == 8) goto L31;
        ViewGroup.MarginLayoutParams r135 = (ViewGroup.MarginLayoutParams) r134.getLayoutParams();
        int r136 = r135.leftMargin + r129;
        int r137 = r135.topMargin + r130;
        r134.layout(r136, r137, r134.getMeasuredWidth() + r136, r134.getMeasuredHeight() + r137);
        r129 = r129 + ((r134.getMeasuredWidth() + r135.leftMargin) + r135.rightMargin);
    L31:
        r133 = r133 + 1;
        goto L26
    L32:
        r130 = r130 + r108;
        r107 = r107 + 1;
        goto L14
    L19:
        if (r132 != 1) goto L24;
        r129 = (r115 - (r109 + getPaddingLeft())) - getPaddingRight();
        Collections.reverse(this.f240106e);
        goto L24
    L23:
        r129 = getPaddingLeft();
        goto L24
    }
}
