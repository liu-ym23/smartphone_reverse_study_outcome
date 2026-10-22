package com.bytedance.ee.bear.more.pageview2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class PageviewTextView extends FrameLayout {
    public View a;
    public TextView b;
    public ImageView c;
    public View d;

    public final void a() {
        tt5.a.b("PageviewItemView", "initViews: ");
        View r0 = LayoutInflater.from(getContext()).inflate(2131563674, this, true);
        this.a = r0;
        this.b = (TextView) r0.findViewById(2131388772);
        this.c = (ImageView) this.a.findViewById(2131374718);
        this.d = this.a.findViewById(2131369197);
    }

    public PageviewTextView(Context r1) {
        super(r1);
        a();
    }

    public void setImageResource(int r2) {
        this.c.setImageResource(r2);
    }

    public void setTitle(String r2) {
        this.b.setText(r2);
    }

    public PageviewTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public PageviewTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }
}
