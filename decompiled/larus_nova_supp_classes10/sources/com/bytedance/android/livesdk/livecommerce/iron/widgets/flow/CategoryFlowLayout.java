package com.bytedance.android.livesdk.livecommerce.iron.widgets.flow;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.text.TextUtilsCompat;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.TopCategoryView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class CategoryFlowLayout extends ViewGroup {
    public final List<List<View>> a;
    public final List<Integer> b;
    public final List<Integer> c;
    public final int d;
    public List<View> e;
    public int f;
    public final int g;
    public int h;
    public int i;

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public int getNumOfLines() {
        return ((ArrayList) this.a).size();
    }

    public CategoryFlowLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new ViewGroup.MarginLayoutParams(getContext(), r3);
    }

    public void setMaxLine(int r1) {
        this.h = r1;
    }

    public void setSpaceV(int r1) {
        this.f = r1;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        return new ViewGroup.MarginLayoutParams(r2);
    }

    public CategoryFlowLayout(Context r2, AttributeSet r3) {
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
        if (r6 >= r5) goto L30;
        View r13 = getChildAt(r6);
        if (r13.getVisibility() == 8) goto L7;
        measureChild(r13, r20, r21);
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r13.getLayoutParams();
        int r17 = r3;
        int r16 = (r13.getMeasuredWidth() + r7.leftMargin) + r7.rightMargin;
        r11 = (r13.getMeasuredHeight() + r7.topMargin) + r7.bottomMargin;
        if ((r8 + r16) <= ((r1 - getPaddingLeft()) - getPaddingRight())) goto L18;
        r9 = Math.max(r9, r8);
        int r18 = r16 + this.g;
        r10 = r10 + r11;
        r12 = r12 + 1;
        int r14 = this.h;
        if (r14 <= 0) goto L16;
        if (r12 <= r14) goto L16;
        r11 = r11;
    L31:
        if (r11 <= 0) goto L34;
        r10 = r10 + (((r10 / r11) - 1) * this.f);
    L34:
        if (r2 == 1073741824) goto L37;
        r1 = getPaddingRight() + (r9 + getPaddingLeft());
    L37:
        if (r4 != 1073741824) goto L39;
        int r15 = r17;
    L40:
        setMeasuredDimension(r1, r15);
        return;
    L39:
        r15 = (r10 + getPaddingTop()) + getPaddingBottom();
    L16:
        int r19 = r18;
        if (r6 != (r5 - 1)) goto L28;
        r10 = r10 + r11;
        r9 = Math.max(r19, r9);
    L28:
        r8 = r19;
    L29:
        r6 = r6 + 1;
        r3 = r17;
        goto L3
    L18:
        if ((r13 instanceof ei2.a) == true) goto L20;
    L22:
        r18 = r8 + (r16 + this.g);
    L23:
        r11 = Math.max(r11, r11);
        goto L16
    L20:
        if (((ei2.a) r13).getType() != 1) goto L22;
        r18 = (r1 - getPaddingLeft()) - getPaddingRight();
        goto L23
    L7:
        if (r6 != (r5 - 1)) goto L9;
        r9 = Math.max(r8, r9);
        r10 = r10 + r11;
    L9:
        r17 = r3;
        goto L29
    L30:
        r17 = r3;
        goto L31
    }

    public CategoryFlowLayout(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.e = new ArrayList();
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130972717, 2130974466, 2130974470, 2130974474, 2130974477});
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
        View r2 = (View) getParent();
        int r3 = (r2.getHeight() - r2.getPaddingBottom()) - r2.getPaddingTop();
        this.i = 0;
        int r4 = getChildCount();
        int r5 = 1;
        int r6 = 0;
        int r7 = 0;
        int r8 = 1;
        int r9 = 0;
    L3:
        int r10 = 8;
        if (r6 >= r4) goto L23;
        View r11 = getChildAt(r6);
        if (r11.getVisibility() == 8) goto L22;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
        int r13 = (r11.getMeasuredWidth() + r12.leftMargin) + r12.rightMargin;
        int r14 = (r11.getMeasuredHeight() + r12.topMargin) + r12.bottomMargin;
        if ((r13 + r7) <= ((r1 - getPaddingLeft()) - getPaddingRight())) goto L16;
        r8 = r8 + 1;
        int r15 = this.h;
        if (r15 <= 0) goto L14;
        if (r8 > r15) goto L23;
    L14:
        List<Integer> r16 = this.b;
        ArrayList r17 = (ArrayList) r16;
        r17.add(Integer.valueOf(r9));
        List<List<View>> r23 = this.a;
        ArrayList r24 = (ArrayList) r23;
        r24.add(this.e);
        List<Integer> r25 = this.c;
        ArrayList r26 = (ArrayList) r25;
        r26.add(Integer.valueOf(r7));
        this.e = new ArrayList();
        r9 = r14;
        r7 = 0;
    L16:
        if ((r11 instanceof ei2.a) == true) goto L18;
    L20:
        r7 = r7 + (r13 + this.g);
    L21:
        r9 = Math.max(r9, r14);
        this.e.add(r11);
        goto L22
    L18:
        if (((ei2.a) r11).getType() != 1) goto L20;
        r7 = (r1 - getPaddingLeft()) - getPaddingRight();
    L22:
        r6 = r6 + 1;
    L23:
        List<Integer> r27 = this.b;
        ArrayList r28 = (ArrayList) r27;
        r28.add(Integer.valueOf(r9));
        List<Integer> r29 = this.c;
        ArrayList r30 = (ArrayList) r29;
        r30.add(Integer.valueOf(r7));
        List<List<View>> r31 = this.a;
        ArrayList r32 = (ArrayList) r31;
        r32.add(this.e);
        int r33 = getPaddingLeft();
        int r34 = getPaddingTop();
        int r35 = ((ArrayList) this.a).size();
        int r36 = 0;
    L24:
        if (r36 >= r35) goto L54;
        List<View> r37 = (List) ListProtector.get(this.a, r36);
        this.e = r37;
        int r38 = r37.size();
        int r110 = ((Integer) ListProtector.get(this.b, r36)).intValue() + this.f;
        int r111 = ((Integer) ListProtector.get(this.c, r36)).intValue();
        int r112 = this.d;
        if (r112 == (-1)) goto L32;
        if (r112 == 0) goto L31;
        if (r112 != r5) goto L33;
        r33 = (r1 - (r111 + getPaddingLeft())) - getPaddingRight();
        Collections.reverse(this.e);
    L33:
        int r113 = 0;
    L34:
        if (r113 >= r38) goto L50;
        View r114 = (View) ListProtector.get(this.e, r113);
        if (r114.getVisibility() != r10) goto L38;
        int r210 = r1;
    L49:
        r113 = r113 + 1;
        r1 = r210;
        r5 = 1;
        r10 = 8;
        goto L34
    L38:
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114.getLayoutParams();
        boolean r116 = r114 instanceof ei2.a;
        if (r116 == true) goto L41;
    L43:
        int r39 = r115.leftMargin + r33;
    L44:
        int r40 = r115.topMargin + r34;
        r210 = r1;
        r114.layout(r39, r40, r39 + r114.getMeasuredWidth(), r40 + r114.getMeasuredHeight());
        r33 = r33 + (((r114.getMeasuredWidth() + r115.leftMargin) + r115.rightMargin) + this.g);
        if (r116 == false) goto L49;
        ei2.a r117 = (ei2.a) r114;
        if ((r117.getTagView() instanceof TopCategoryView) == false) goto L49;
        ((TopCategoryView) r117.getTagView()).setTabRow(r36 + 1);
        goto L49
    L41:
        if (((ei2.a) r114).getType() != r5) goto L43;
        r39 = (r1 - getPaddingRight()) - r114.getMeasuredWidth();
        goto L44
    L50:
        int r211 = r1;
        r34 = r34 + r110;
        if ((r34 - this.f) > r3) goto L53;
        this.i = r36 + 1;
    L53:
        r36 = r36 + 1;
        r1 = r211;
        r5 = 1;
        r10 = 8;
        goto L24
    L31:
        r33 = ((r1 - r111) / 2) + getPaddingLeft();
        goto L33
    L32:
        r33 = getPaddingLeft();
        goto L33
    }
}
