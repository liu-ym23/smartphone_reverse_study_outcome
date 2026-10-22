package com.bytedance.android.shopping.widget.flow;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class FlowLayout extends ViewGroup {
    public final List<List<View>> a;
    public final List<Integer> b;
    public final List<Integer> c;
    public final int d;
    public List<View> e;
    public final int f;
    public final int g;
    public int h;

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

    public void setMaxLine(int r1) {
        this.h = r1;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        return new ViewGroup.MarginLayoutParams(r2);
    }

    public FlowLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public void onMeasure(int r20, int r21) {
        int r1 = View.MeasureSpec.getSize(r20);
        int r2 = View.MeasureSpec.getMode(r20);
        int r3 = View.MeasureSpec.getSize(r21);
        int r4 = View.MeasureSpec.getMode(r21);
        int r5 = getChildCount();
        int r6 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
        int r12 = 1;
    L3:
        if (r6 >= r5) goto L23;
        View r13 = getChildAt(r6);
        if (r13.getVisibility() == 8) goto L7;
        measureChild(r13, r20, r21);
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r13.getLayoutParams();
        int r17 = r3;
        int r16 = (r13.getMeasuredWidth() + r7.leftMargin) + r7.rightMargin;
        r9 = (r13.getMeasuredHeight() + r7.topMargin) + r7.bottomMargin;
        if ((r8 + r16) <= ((r1 - getPaddingLeft()) - getPaddingRight())) goto L16;
        r10 = Math.max(r10, r8);
        int r18 = r16 + this.g;
        r11 = r11 + r9;
        r12 = r12 + 1;
        int r14 = this.h;
        if (r14 <= 0) goto L17;
        if (r12 <= r14) goto L17;
        r9 = r9;
    L24:
        if (r9 <= 0) goto L27;
        r11 = r11 + (((r11 / r9) - 1) * this.f);
    L27:
        if (r2 == 1073741824) goto L30;
        r1 = getPaddingRight() + (r10 + getPaddingLeft());
    L30:
        if (r4 != 1073741824) goto L32;
        int r15 = r17;
    L33:
        setMeasuredDimension(r1, r15);
        return;
    L32:
        r15 = (r11 + getPaddingTop()) + getPaddingBottom();
    L17:
        int r19 = r18;
        if (r6 != (r5 - 1)) goto L21;
        r11 = r11 + r9;
        r10 = Math.max(r19, r10);
    L21:
        r8 = r19;
    L22:
        r6 = r6 + 1;
        r3 = r17;
        goto L3
    L16:
        r18 = r8 + (r16 + this.g);
        r9 = Math.max(r9, r9);
        goto L17
    L7:
        if (r6 != (r5 - 1)) goto L9;
        r10 = Math.max(r8, r10);
        r11 = r11 + r9;
    L9:
        r17 = r3;
        goto L22
    L23:
        r17 = r3;
        goto L24
    }

    public FlowLayout(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.e = new ArrayList();
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130972716, 2130974465, 2130974469, 2130974473, 2130974476});
        int r0 = r7.getInt(1, -1);
        this.d = r0;
        this.g = r7.getDimensionPixelSize(3, 0);
        this.f = r7.getDimensionPixelSize(4, 0);
        this.h = r7.getInteger(2, 0);
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L7;
        if (r0 != (-1)) goto L6;
        this.d = 1;
        goto L7
    L6:
        this.d = -1;
    L7:
        r7.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        ((ArrayList) this.a).clear();
        ((ArrayList) this.b).clear();
        ((ArrayList) this.c).clear();
        this.e.clear();
        int r1 = getWidth();
        int r2 = getChildCount();
        int r4 = 1;
        int r5 = 0;
        int r6 = 0;
        int r7 = 1;
        int r8 = 0;
    L4:
        if (r5 >= r2) goto L17;
        View r10 = getChildAt(r5);
        if (r10.getVisibility() == 8) goto L16;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        int r12 = (r10.getMeasuredWidth() + r11.leftMargin) + r11.rightMargin;
        int r13 = (r10.getMeasuredHeight() + r11.topMargin) + r11.bottomMargin;
        if ((r12 + r6) <= ((r1 - getPaddingLeft()) - getPaddingRight())) goto L15;
        r7 = r7 + 1;
        int r14 = this.h;
        if (r14 <= 0) goto L14;
        if (r7 > r14) goto L17;
    L14:
        List<Integer> r9 = this.b;
        ArrayList r15 = (ArrayList) r9;
        r15.add(Integer.valueOf(r8));
        List<List<View>> r16 = this.a;
        ArrayList r17 = (ArrayList) r16;
        r17.add(this.e);
        List<Integer> r23 = this.c;
        ArrayList r24 = (ArrayList) r23;
        r24.add(Integer.valueOf(r6));
        this.e = new ArrayList();
        r8 = r13;
        r6 = 0;
    L15:
        r6 = r6 + (r12 + this.g);
        r8 = Math.max(r8, r13);
        this.e.add(r10);
    L16:
        r5 = r5 + 1;
    L17:
        List<Integer> r3 = this.b;
        ArrayList r25 = (ArrayList) r3;
        r25.add(Integer.valueOf(r8));
        List<Integer> r26 = this.c;
        ArrayList r27 = (ArrayList) r26;
        r27.add(Integer.valueOf(r6));
        List<List<View>> r28 = this.a;
        ArrayList r29 = (ArrayList) r28;
        r29.add(this.e);
        int r30 = getPaddingLeft();
        int r31 = getPaddingTop();
        int r32 = ((ArrayList) this.a).size();
        int r33 = 0;
    L18:
        if (r33 >= r32) goto L35;
        List<View> r34 = (List) ListProtector.get(this.a, r33);
        this.e = r34;
        int r35 = r34.size();
        int r110 = ((Integer) ListProtector.get(this.b, r33)).intValue() + this.f;
        int r111 = ((Integer) ListProtector.get(this.c, r33)).intValue();
        int r112 = this.d;
        if (r112 == (-1)) goto L26;
        if (r112 == 0) goto L25;
        if (r112 != r4) goto L27;
        r30 = (r1 - (r111 + getPaddingLeft())) - getPaddingRight();
        Collections.reverse(this.e);
    L27:
        int r113 = 0;
    L28:
        if (r113 >= r35) goto L34;
        View r114 = (View) ListProtector.get(this.e, r113);
        if (r114.getVisibility() == 8) goto L33;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114.getLayoutParams();
        int r116 = r115.leftMargin + r30;
        int r117 = r115.topMargin + r31;
        r114.layout(r116, r117, r116 + r114.getMeasuredWidth(), r117 + r114.getMeasuredHeight());
        r30 = r30 + (((r114.getMeasuredWidth() + r115.leftMargin) + r115.rightMargin) + this.g);
    L33:
        r113 = r113 + 1;
        goto L28
    L34:
        r31 = r31 + r110;
        r33 = r33 + 1;
        r4 = 1;
        goto L18
    L25:
        r30 = ((r1 - r111) / 2) + getPaddingLeft();
        goto L27
    L26:
        r30 = getPaddingLeft();
        goto L27
    }
}
