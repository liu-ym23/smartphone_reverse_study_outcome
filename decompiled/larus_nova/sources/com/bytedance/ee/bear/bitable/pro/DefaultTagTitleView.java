package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class DefaultTagTitleView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f215100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f215101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f215102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f215103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f215104e;

    public CharSequence getTitle() {
        return this.f215102c;
    }

    public DefaultTagTitleView(Context r100) {
        super(r100);
        this.f215103d = com.bytedance.ee.util.ui.n.d(16);
        this.f215104e = com.bytedance.ee.util.ui.n.h(getContext(), R.color.text_title);
        a(r100);
    }

    public final void a(Context r100) {
        this.f215104e = getResources().getColor(R.color.text_title);
        setOrientation(0);
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(-2, -2);
        r101.gravity = 16;
        TextView r102 = new TextView(r100);
        this.f215100a = r102;
        r102.setEllipsize(TextUtils.TruncateAt.END);
        TextView r103 = this.f215100a;
        r103.setTextSize(0, a08.b.a(this.f215103d, r103.getContext()));
        this.f215100a.setTextColor(this.f215104e);
        if (TextUtils.isEmpty(this.f215102c) == true) goto L5;
        this.f215100a.setText(this.f215102c);
    L5:
        addView(this.f215100a, r101);
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -2);
        r104.gravity = 48;
        r104.leftMargin = getResources().getDimensionPixelSize(R.dimen.facade_star_view_margin_left);
        r104.topMargin = 1;
        TextView r105 = new TextView(r100);
        this.f215101b = r105;
        r105.setPadding(com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(2), com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(2));
        this.f215101b.setVisibility(8);
        this.f215101b.setTextSize(12.0f);
        this.f215101b.setGravity(16);
        this.f215101b.setBackground(r100.getDrawable(R.drawable.bitable_pro_default_label_bg));
        this.f215101b.setTextColor(com.bytedance.ee.util.ui.n.h(getContext(), R.color.udtoken_tag_neutral_text_normal));
        addView(this.f215101b, r104);
    }

    public void setBackground(int r100) {
        this.f215101b.setBackground(AppCompatResources.getDrawable(getContext(), r100));
    }

    public void setTagTextColor(int r100) {
        this.f215101b.setTextColor(getResources().getColor(r100));
    }

    public void setTitle(int r100) {
        String r101 = getResources().getString(r100);
        this.f215102c = r101;
        this.f215100a.setText(r101);
    }

    public void setTitleSize(float r100) {
        this.f215100a.setTextSize(r100);
    }

    public void setTitleTextBold(boolean r100) {
        this.f215100a.getPaint().setFakeBoldText(r100);
    }

    public void setTitleTextColor(int r100) {
        this.f215100a.setTextColor(getResources().getColor(r100));
    }

    public void setTitleTextSize(int r100) {
        this.f215100a.setTextSize(0, a08.b.a(getResources().getDimension(r100), this.f215100a.getContext()));
    }

    public void setTitle(CharSequence r100) {
        this.f215102c = r100;
        this.f215100a.setText(r100);
    }

    public DefaultTagTitleView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f215103d = com.bytedance.ee.util.ui.n.d(16);
        this.f215104e = com.bytedance.ee.util.ui.n.h(getContext(), R.color.text_title);
        a(r100);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        int r100 = 0;
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L7;
        measureChildWithMargins(getChildAt(r101), r110, 0, r111, 0);
        r101 = r101 + 1;
        goto L4
    L7:
        if (this.f215101b.getVisibility() != 0) goto L9;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) this.f215101b.getLayoutParams();
        r100 = (this.f215101b.getMeasuredWidth() + r112.leftMargin) + r112.rightMargin;
    L9:
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) this.f215100a.getLayoutParams();
        int r114 = (this.f215100a.getMeasuredWidth() + r113.leftMargin) + r113.rightMargin;
        int r115 = getMeasuredWidth();
        int r102 = r115 - r100;
        if (r114 <= r102) goto L12;
        r114 = r102;
    L12:
        int r116 = View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        int r103 = View.MeasureSpec.makeMeasureSpec(this.f215100a.getMeasuredHeight(), 1073741824);
        this.f215100a.measure(r116, r103);
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(r115, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f215100a.getMeasuredHeight(), 1073741824));
    }

    public DefaultTagTitleView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f215103d = com.bytedance.ee.util.ui.n.d(16);
        this.f215104e = com.bytedance.ee.util.ui.n.h(getContext(), R.color.text_title);
        a(r100);
    }
}
