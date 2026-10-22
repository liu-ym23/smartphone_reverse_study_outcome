package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
class CustomTitleLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f226448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f226449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f226450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f226451d;

    public CustomTitleLayout(Context r100) {
        super(r100);
        com.bytedance.ee.util.ui.n.d(16);
        com.bytedance.ee.util.ui.n.d(12);
        this.f226448a = com.bytedance.ee.util.ui.n.h(getContext(), R.color.text_title);
        this.f226449b = com.bytedance.ee.util.ui.n.h(getContext(), R.color.text_caption);
        a(r100);
    }

    public final void a(Context r100) {
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(-2, -2);
        r101.gravity = 17;
        TextView r102 = new TextView(r100);
        this.f226450c = r102;
        r102.setEllipsize(TextUtils.TruncateAt.END);
        this.f226450c.setTextSize(2, 16.0f);
        this.f226450c.setTextColor(this.f226448a);
        addView(this.f226450c, r101);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, y9c.d.a(17));
        r103.gravity = 16;
        TextView r104 = new TextView(r100);
        this.f226451d = r104;
        r104.setEllipsize(TextUtils.TruncateAt.END);
        this.f226451d.setTextSize(2, 12.0f);
        this.f226451d.setTextColor(this.f226449b);
        this.f226451d.setSingleLine(true);
        this.f226451d.setVisibility(8);
        this.f226451d.setCompoundDrawablePadding(y9c.d.a(4));
        addView(this.f226451d, r103);
    }

    public CustomTitleLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        com.bytedance.ee.util.ui.n.d(16);
        com.bytedance.ee.util.ui.n.d(12);
        this.f226448a = com.bytedance.ee.util.ui.n.h(getContext(), R.color.text_title);
        this.f226449b = com.bytedance.ee.util.ui.n.h(getContext(), R.color.text_caption);
        a(r100);
    }

    public CustomTitleLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        com.bytedance.ee.util.ui.n.d(16);
        com.bytedance.ee.util.ui.n.d(12);
        this.f226448a = com.bytedance.ee.util.ui.n.h(getContext(), R.color.text_title);
        this.f226449b = com.bytedance.ee.util.ui.n.h(getContext(), R.color.text_caption);
        a(r100);
    }
}
