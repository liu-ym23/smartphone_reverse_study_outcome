package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DefaultTagTitleView extends LinearLayout {
    public TextView a;
    public TextView b;
    public CharSequence c;
    public final float d;
    public int e;

    public CharSequence getTitle() {
        return this.c;
    }

    public DefaultTagTitleView(Context r3) {
        super(r3);
        this.d = com.bytedance.ee.util.ui.n.d(16);
        this.e = com.bytedance.ee.util.ui.n.h(getContext(), 2131106622);
        a(r3);
    }

    public final void a(Context r8) {
        this.e = getResources().getColor(2131106622);
        setOrientation(0);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -2);
        r1.gravity = 16;
        TextView r4 = new TextView(r8);
        this.a = r4;
        r4.setEllipsize(TextUtils.TruncateAt.END);
        TextView r5 = this.a;
        r5.setTextSize(0, a08.b.a(this.d, r5.getContext()));
        this.a.setTextColor(this.e);
        if (TextUtils.isEmpty(this.c) == true) goto L5;
        this.a.setText(this.c);
    L5:
        addView(this.a, r1);
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -2);
        r0.gravity = 48;
        r0.leftMargin = getResources().getDimensionPixelSize(2131166501);
        r0.topMargin = 1;
        TextView r2 = new TextView(r8);
        this.b = r2;
        r2.setPadding(com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(2), com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(2));
        this.b.setVisibility(8);
        this.b.setTextSize(12.0f);
        this.b.setGravity(16);
        this.b.setBackground(r8.getDrawable(2131232356));
        this.b.setTextColor(com.bytedance.ee.util.ui.n.h(getContext(), 2131109115));
        addView(this.b, r0);
    }

    public void setBackground(int r3) {
        this.b.setBackground(AppCompatResources.getDrawable(getContext(), r3));
    }

    public void setTagTextColor(int r3) {
        this.b.setTextColor(getResources().getColor(r3));
    }

    public void setTitle(int r2) {
        String r3 = getResources().getString(r2);
        this.c = r3;
        this.a.setText(r3);
    }

    public void setTitleSize(float r2) {
        this.a.setTextSize(r2);
    }

    public void setTitleTextBold(boolean r2) {
        this.a.getPaint().setFakeBoldText(r2);
    }

    public void setTitleTextColor(int r3) {
        this.a.setTextColor(getResources().getColor(r3));
    }

    public void setTitleTextSize(int r3) {
        this.a.setTextSize(0, a08.b.a(getResources().getDimension(r3), this.a.getContext()));
    }

    public void setTitle(CharSequence r2) {
        this.c = r2;
        this.a.setText(r2);
    }

    public DefaultTagTitleView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.d = com.bytedance.ee.util.ui.n.d(16);
        this.e = com.bytedance.ee.util.ui.n.h(getContext(), 2131106622);
        a(r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= getChildCount()) goto L7;
        measureChildWithMargins(getChildAt(r1), r10, 0, r11, 0);
        r1 = r1 + 1;
        goto L4
    L7:
        if (this.b.getVisibility() != 0) goto L9;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) this.b.getLayoutParams();
        r0 = (this.b.getMeasuredWidth() + r12.leftMargin) + r12.rightMargin;
    L9:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
        int r14 = (this.a.getMeasuredWidth() + r13.leftMargin) + r13.rightMargin;
        int r16 = getMeasuredWidth();
        int r2 = r16 - r0;
        if (r14 <= r2) goto L12;
        r14 = r2;
    L12:
        int r17 = View.MeasureSpec.makeMeasureSpec(r14, 1073741824);
        int r3 = View.MeasureSpec.makeMeasureSpec(this.a.getMeasuredHeight(), 1073741824);
        this.a.measure(r17, r3);
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(r16, 1073741824), View.MeasureSpec.makeMeasureSpec(this.a.getMeasuredHeight(), 1073741824));
    }

    public DefaultTagTitleView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.d = com.bytedance.ee.util.ui.n.d(16);
        this.e = com.bytedance.ee.util.ui.n.h(getContext(), 2131106622);
        a(r1);
    }
}
