package com.bytedance.ies.uikit.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes19.dex */
public class WrapLineFlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f249019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f249020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f249021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<LayoutParams> f249022d;

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f249023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f249024b;

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public WrapLineFlowLayout(Context r100) {
        this(r100, null, 0);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new LayoutParams(r100.width, r100.height);
    }

    public WrapLineFlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r210) {
        int r100 = View.MeasureSpec.getSize(r110);
        int r101 = View.MeasureSpec.getMode(r110);
        int r102 = View.MeasureSpec.getSize(r210);
        int r103 = View.MeasureSpec.getMode(r210);
        int r104 = getPaddingTop();
        int r105 = getPaddingLeft();
        int r106 = 0;
        if (r101 != 0) goto L5;
        r100 = 0;
    L5:
        int r107 = (r100 - getPaddingLeft()) - getPaddingRight();
        int r108 = getChildCount();
        this.f249022d.clear();
        int r111 = r107;
        int r112 = r105;
        int r109 = 0;
        int r113 = 0;
    L6:
        if (r109 >= r108) goto L46;
        View r114 = getChildAt(r109);
        LayoutParams r115 = (LayoutParams) r114.getLayoutParams();
        if (r107 > 0) goto L10;
        int r116 = r105;
        r114.measure(View.MeasureSpec.makeMeasureSpec(r106, 1073741824), View.MeasureSpec.makeMeasureSpec(r106, 1073741824));
        r115.f249023a = r112;
        r115.f249024b = r104;
        int r117 = r107;
    L44:
        r109 = r109 + 1;
        r105 = r116;
        r107 = r117;
        goto L6
    L10:
        r116 = r105;
        int r118 = ((ViewGroup.LayoutParams) r115).width;
        if (r118 != (-2)) goto L13;
        int r119 = View.MeasureSpec.makeMeasureSpec(r107, Integer.MIN_VALUE);
    L16:
        int r120 = ((ViewGroup.LayoutParams) r115).height;
        if (r120 != (-2)) goto L19;
        r106 = 0;
        int r121 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r117 = r107;
    L23:
        r114.measure(r119, r121);
        if (r114.getMeasuredWidth() <= r111) goto L38;
        if (r113 <= 0) goto L28;
        r104 = r104 + (r113 + this.f249020b);
    L28:
        if (this.f249021c == true) goto L30;
    L37:
        this.f249022d.clear();
        r112 = r116;
        r111 = r117;
        r113 = 0;
        goto L38
    L30:
        if (r111 <= 1) goto L37;
        if (this.f249022d.isEmpty() == true) goto L37;
        int r122 = r111 / 2;
        Iterator<LayoutParams> r123 = this.f249022d.iterator();
    L35:
        if (r123.hasNext() == false) goto L37;
        r123.next().f249023a += r122;
    L38:
        r115.f249023a = r112;
        r115.f249024b = r104;
        if (this.f249021c == false) goto L41;
        this.f249022d.add(r115);
    L41:
        int r124 = r114.getMeasuredWidth() + this.f249019a;
        r112 = r112 + r124;
        r111 = r111 - r124;
        if (r114.getMeasuredHeight() <= r113) goto L44;
        r113 = r114.getMeasuredHeight();
        goto L44
    L19:
        r117 = r107;
        r106 = 0;
        if (r120 != (-1)) goto L22;
        r121 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        goto L23
    L22:
        r121 = View.MeasureSpec.makeMeasureSpec(r120, 1073741824);
        goto L23
    L13:
        if (r118 != (-1)) goto L15;
        r119 = View.MeasureSpec.makeMeasureSpec(r111, 1073741824);
        goto L16
    L15:
        r119 = View.MeasureSpec.makeMeasureSpec(r118, 1073741824);
        goto L16
    L46:
        if (this.f249021c == true) goto L48;
    L55:
        if (r113 <= 0) goto L57;
        r104 = r104 + r113;
    L57:
        if (r103 != 0) goto L60;
        r102 = r104 + getPaddingBottom();
    L62:
        setMeasuredDimension(r100, r102);
        return;
    L60:
        if (r103 != Integer.MIN_VALUE) goto L62;
        r102 = Math.min(r102, r104 + getPaddingBottom());
        goto L62
    L48:
        if (r111 <= 1) goto L55;
        if (this.f249022d.isEmpty() == true) goto L55;
        int r125 = r111 / 2;
        Iterator<LayoutParams> r126 = this.f249022d.iterator();
    L53:
        if (r126.hasNext() == false) goto L55;
        r126.next().f249023a += r125;
        goto L53
    }

    public WrapLineFlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f249019a = 0;
        this.f249020b = 0;
        this.f249022d = new ArrayList();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.alignCenter, R.attr.hSpacing, R.attr.vSpacing}, r102, 0);
        int r104 = r103.getDimensionPixelOffset(1, 0);
        this.f249019a = r104;
        int r105 = r103.getDimensionPixelOffset(2, 0);
        this.f249020b = r105;
        this.f249021c = r103.getBoolean(0, false);
        r103.recycle();
        if (r104 >= 0) goto L5;
        this.f249019a = 0;
    L5:
        if (r105 >= 0) goto L8;
        this.f249020b = 0;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L5;
        View r107 = getChildAt(r106);
        LayoutParams r108 = (LayoutParams) r107.getLayoutParams();
        int r109 = r108.f249023a;
        r107.layout(r109, r108.f249024b, r107.getMeasuredWidth() + r109, r108.f249024b + r107.getMeasuredHeight());
        r106 = r106 + 1;
        goto L3
    }
}
