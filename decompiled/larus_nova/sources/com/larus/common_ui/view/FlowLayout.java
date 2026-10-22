package com.larus.common_ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f328239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f328240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f328241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f328242d;

    public int getItemSpacing() {
        return this.f328240b;
    }

    public int getLineSpacing() {
        return this.f328239a;
    }

    public int getRowCount() {
        return this.f328242d;
    }

    public FlowLayout(Context r100) {
        this(r100, null);
    }

    public void setItemSpacing(int r100) {
        this.f328240b = r100;
    }

    public void setLineSpacing(int r100) {
        this.f328239a = r100;
    }

    public void setSingleLine(boolean r100) {
        this.f328241c = r100;
    }

    public FlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r210, int r211) {
        int r100 = View.MeasureSpec.getSize(r210);
        int r101 = View.MeasureSpec.getMode(r210);
        int r102 = View.MeasureSpec.getSize(r211);
        int r103 = View.MeasureSpec.getMode(r211);
        if (r101 == Integer.MIN_VALUE) goto L7;
        if (r101 == 1073741824) goto L7;
        int r104 = Integer.MAX_VALUE;
    L8:
        int r105 = getPaddingLeft();
        int r106 = getPaddingTop();
        int r107 = r104 - getPaddingRight();
        int r110 = r106;
        int r111 = 0;
        int r112 = 0;
    L10:
        if (r111 >= getChildCount()) goto L30;
        View r113 = getChildAt(r111);
        if (r113.getVisibility() == 8) goto L29;
        measureChild(r113, r210, r211);
        ViewGroup.LayoutParams r108 = r113.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        int r114 = r109.leftMargin + 0;
        int r115 = r109.rightMargin + 0;
    L19:
        if (((r105 + r114) + r113.getMeasuredWidth()) > r107) goto L21;
    L23:
        int r116 = (r105 + r114) + r113.getMeasuredWidth();
        r106 = r113.getMeasuredHeight() + r110;
        if (r116 <= r112) goto L26;
        r112 = r116;
    L26:
        r105 = r105 + (((r114 + r115) + r113.getMeasuredWidth()) + this.f328240b);
        if (r111 != (getChildCount() - 1)) goto L29;
        r112 = r112 + r115;
        goto L29
    L21:
        if (this.f328241c == true) goto L23;
        r105 = getPaddingLeft();
        r110 = this.f328239a + r106;
        goto L23
    L17:
        r115 = 0;
        r114 = 0;
    L29:
        r111 = r111 + 1;
        goto L10
    L30:
        int r117 = r112 + getPaddingRight();
        int r118 = r106 + getPaddingBottom();
        if (r101 == Integer.MIN_VALUE) goto L35;
        int r119 = 1073741824;
        if (r101 == 1073741824) goto L36;
        r100 = r117;
    L36:
        if (r103 == Integer.MIN_VALUE) goto L39;
        if (r103 == r119) goto L40;
        r102 = r118;
    L40:
        setMeasuredDimension(r100, r102);
        return;
    L39:
        r102 = Math.min(r118, r102);
        goto L40
    L35:
        r119 = 1073741824;
        r100 = Math.min(r117, r100);
    L7:
        r104 = r100;
        goto L8
    }

    public FlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f328241c = false;
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.itemSpacing, R.attr.lineSpacing}, 0, 0);
        this.f328239a = r103.getDimensionPixelSize(1, 0);
        this.f328240b = r103.getDimensionPixelSize(0, 0);
        r103.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        if (getChildCount() != 0) goto L6;
        this.f328242d = 0;
        return;
    L6:
        this.f328242d = 1;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        boolean r115 = true;
    L10:
        if (r115 == false) goto L12;
        int r100 = getPaddingRight();
    L13:
        if (r115 == false) goto L15;
        int r101 = getPaddingLeft();
    L16:
        int r102 = getPaddingTop();
        int r116 = (r113 - r111) - r101;
        int r103 = r100;
        int r117 = r102;
        int r104 = 0;
    L18:
        if (r104 >= getChildCount()) goto L36;
        View r105 = getChildAt(r104);
        if (r105.getVisibility() != 8) goto L22;
        r105.setTag(R.id.row_index_key_flow_fix, -1);
    L35:
        r104 = r104 + 1;
        goto L18
    L22:
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        int r108 = MarginLayoutParamsCompat.getMarginStart(r107);
        int r109 = MarginLayoutParamsCompat.getMarginEnd(r107);
    L26:
        int r118 = (r103 + r108) + r105.getMeasuredWidth();
        if (this.f328241c == true) goto L30;
        if (r118 <= r116) goto L30;
        r117 = this.f328239a + r102;
        this.f328242d++;
        r103 = r100;
    L30:
        r105.setTag(R.id.row_index_key_flow_fix, Integer.valueOf(this.f328242d - 1));
        int r119 = r103 + r108;
        int r120 = r105.getMeasuredWidth() + r119;
        int r121 = r105.getMeasuredHeight() + r117;
        if (r115 == false) goto L33;
        r105.layout(r116 - r120, r117, (r116 - r103) - r108, r121);
    L34:
        r103 = r103 + (((r108 + r109) + r105.getMeasuredWidth()) + this.f328240b);
        r102 = r121;
        goto L35
    L33:
        r105.layout(r119, r117, r120, r121);
        goto L34
    L25:
        r109 = 0;
        r108 = 0;
        goto L26
    L36:
        return;
    L15:
        r101 = getPaddingRight();
        goto L16
    L12:
        r100 = getPaddingLeft();
        goto L13
    L9:
        r115 = false;
        goto L10
    }
}
