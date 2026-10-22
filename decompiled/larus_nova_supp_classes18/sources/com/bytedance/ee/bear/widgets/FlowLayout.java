package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.text.TextUtilsCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FlowLayout extends ViewGroup {
    public final List<List<View>> a;
    public final List<Integer> b;
    public final List<Integer> c;
    public final int d;
    public List<View> e;

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public FlowLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new ViewGroup.MarginLayoutParams(getContext(), r3);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        return new ViewGroup.MarginLayoutParams(r2);
    }

    public FlowLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r17, int r18) {
        int r1 = View.MeasureSpec.getSize(r17);
        int r2 = View.MeasureSpec.getMode(r17);
        int r3 = View.MeasureSpec.getSize(r18);
        int r4 = View.MeasureSpec.getMode(r18);
        int r5 = getChildCount();
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
    L3:
        if (r6 >= r5) goto L19;
        View r11 = getChildAt(r6);
        if (r11.getVisibility() == 8) goto L7;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
        measureChild(r11, (r17 - r12.leftMargin) - r12.rightMargin, (r18 - r12.topMargin) - r12.bottomMargin);
        int r13 = (r11.getMeasuredWidth() + r12.leftMargin) + r12.rightMargin;
        int r14 = (r11.getMeasuredHeight() + r12.topMargin) + r12.bottomMargin;
        int r15 = r8 + r13;
        if (r15 <= ((r1 - getPaddingLeft()) - getPaddingRight())) goto L12;
        r7 = Math.max(r7, r8);
        r10 = r10 + r9;
    L14:
        if (r6 != (r5 - 1)) goto L16;
        r7 = Math.max(r13, r7);
        r10 = r10 + r14;
    L16:
        r9 = r14;
        r8 = r13;
    L17:
        r6 = r6 + 1;
        goto L3
    L12:
        r14 = Math.max(r9, r14);
        r13 = r15;
        goto L14
    L7:
        if (r6 != (r5 - 1)) goto L17;
        r7 = Math.max(r8, r7);
        r10 = r10 + r9;
        goto L17
    L19:
        if (r2 == 1073741824) goto L22;
        r1 = getPaddingRight() + (r7 + getPaddingLeft());
    L22:
        if (r4 == 1073741824) goto L25;
        r3 = (r10 + getPaddingTop()) + getPaddingBottom();
    L25:
        setMeasuredDimension(r1, r3);
    }

    public FlowLayout(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.e = new ArrayList();
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130972715, 2130974464});
        int r0 = r6.getInt(1, -1);
        this.d = r0;
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L7;
        if (r0 != (-1)) goto L6;
        this.d = 1;
        goto L7
    L6:
        this.d = -1;
    L7:
        r6.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
        ((ArrayList) this.a).clear();
        ((ArrayList) this.b).clear();
        ((ArrayList) this.c).clear();
        this.e.clear();
        int r16 = getWidth();
        int r17 = getChildCount();
        int r18 = 0;
        int r19 = 0;
        int r0 = 0;
    L4:
        if (r18 >= r17) goto L13;
        View r2 = getChildAt(r18);
        if (r2.getVisibility() == 8) goto L12;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r2.getLayoutParams();
        int r3 = r2.getMeasuredWidth();
        int r4 = r2.getMeasuredHeight();
        if ((((r3 + r0) + r1.leftMargin) + r1.rightMargin) <= ((r16 - getPaddingLeft()) - getPaddingRight())) goto L11;
        List<Integer> r5 = this.b;
        ArrayList r6 = (ArrayList) r5;
        r6.add(Integer.valueOf(r19));
        List<List<View>> r110 = this.a;
        ArrayList r111 = (ArrayList) r110;
        r111.add(this.e);
        List<Integer> r112 = this.c;
        ArrayList r113 = (ArrayList) r112;
        r113.add(Integer.valueOf(r0));
        r19 = (r1.topMargin + r4) + r1.bottomMargin;
        this.e = new ArrayList();
        r0 = 0;
    L11:
        r0 = r0 + ((r3 + r1.leftMargin) + r1.rightMargin);
        r19 = Math.max(r19, (r4 + r1.topMargin) + r1.bottomMargin);
        this.e.add(r2);
    L12:
        r18 = r18 + 1;
        goto L4
    L13:
        List<Integer> r114 = this.b;
        ArrayList r115 = (ArrayList) r114;
        r115.add(Integer.valueOf(r19));
        List<Integer> r116 = this.c;
        ArrayList r117 = (ArrayList) r116;
        r117.add(Integer.valueOf(r0));
        List<List<View>> r118 = this.a;
        ArrayList r119 = (ArrayList) r118;
        r119.add(this.e);
        int r120 = getPaddingLeft();
        int r121 = getPaddingTop();
        int r122 = ((ArrayList) this.a).size();
        int r7 = 0;
    L14:
        if (r7 >= r122) goto L33;
        this.e = (List) ListProtector.get(this.a, r7);
        int r8 = ((Integer) ListProtector.get(this.b, r7)).intValue();
        int r9 = ((Integer) ListProtector.get(this.c, r7)).intValue();
        int r10 = this.d;
        if (r10 == (-1)) goto L23;
        if (r10 != 0) goto L19;
        r120 = ((r16 - r9) / 2) + getPaddingLeft();
    L24:
        int r20 = 0;
    L26:
        if (r20 >= this.e.size()) goto L32;
        View r21 = (View) ListProtector.get(this.e, r20);
        if (r21.getVisibility() == 8) goto L31;
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21.getLayoutParams();
        int r23 = r22.leftMargin + r120;
        int r24 = r22.topMargin + r121;
        r21.layout(r23, r24, r21.getMeasuredWidth() + r23, r21.getMeasuredHeight() + r24);
        r120 = r120 + ((r21.getMeasuredWidth() + r22.leftMargin) + r22.rightMargin);
    L31:
        r20 = r20 + 1;
        goto L26
    L32:
        r121 = r121 + r8;
        r7 = r7 + 1;
        goto L14
    L19:
        if (r10 != 1) goto L24;
        r120 = (r16 - (r9 + getPaddingLeft())) - getPaddingRight();
        Collections.reverse(this.e);
        goto L24
    L23:
        r120 = getPaddingLeft();
        goto L24
    }
}
