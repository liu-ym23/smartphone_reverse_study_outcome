package com.bytedance.android.shopping.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class PriceTextView extends LinearLayout {
    public TextView a;
    public TextView b;
    public TextView c;

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.a = new TextView(getContext());
        this.b = new TextView(getContext());
        this.c = new TextView(getContext());
        addView(this.a);
        addView(this.b);
        addView(this.c);
        setOrientation(0);
    }

    public PriceTextView(Context r1) {
        super(r1);
    }

    public PriceTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
