package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
class CustomTitleLayout extends LinearLayout {
    public final int a;
    public final int b;
    public TextView c;
    public TextView d;

    public CustomTitleLayout(Context r3) {
        super(r3);
        com.bytedance.ee.util.ui.n.d(16);
        com.bytedance.ee.util.ui.n.d(12);
        this.a = com.bytedance.ee.util.ui.n.h(getContext(), 2131106622);
        this.b = com.bytedance.ee.util.ui.n.h(getContext(), 2131106607);
        a(r3);
    }

    public final void a(Context r8) {
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -2);
        r1.gravity = 17;
        TextView r4 = new TextView(r8);
        this.c = r4;
        r4.setEllipsize(TextUtils.TruncateAt.END);
        this.c.setTextSize(2, 16.0f);
        this.c.setTextColor(this.a);
        addView(this.c, r1);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-2, y9c.d.a(17));
        r2.gravity = 16;
        TextView r3 = new TextView(r8);
        this.d = r3;
        r3.setEllipsize(TextUtils.TruncateAt.END);
        this.d.setTextSize(2, 12.0f);
        this.d.setTextColor(this.b);
        this.d.setSingleLine(true);
        this.d.setVisibility(8);
        this.d.setCompoundDrawablePadding(y9c.d.a(4));
        addView(this.d, r2);
    }

    public CustomTitleLayout(Context r2, AttributeSet r3) {
        super(r2, r3);
        com.bytedance.ee.util.ui.n.d(16);
        com.bytedance.ee.util.ui.n.d(12);
        this.a = com.bytedance.ee.util.ui.n.h(getContext(), 2131106622);
        this.b = com.bytedance.ee.util.ui.n.h(getContext(), 2131106607);
        a(r2);
    }

    public CustomTitleLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        com.bytedance.ee.util.ui.n.d(16);
        com.bytedance.ee.util.ui.n.d(12);
        this.a = com.bytedance.ee.util.ui.n.h(getContext(), 2131106622);
        this.b = com.bytedance.ee.util.ui.n.h(getContext(), 2131106607);
        a(r1);
    }
}
