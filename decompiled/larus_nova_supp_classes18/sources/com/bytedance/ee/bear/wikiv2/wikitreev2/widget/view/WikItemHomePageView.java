package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikItemHomePageView extends WikItemLeafView {
    public static final /* synthetic */ int t = 0;

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public float getItemHeightInDp() {
        return 46.0f;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void i(int r1, boolean r2) {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void e() {
        super.e();
        this.b.setVisibility(8);
        this.l.setVisibility(8);
        this.d.setVisibility(8);
        this.a.setPadding(cu5.c.b(24), this.a.getTop(), this.a.getRight(), this.a.getBottom());
        setFocusable(true);
        View.OnClickListener r0 = new i(this);
        setOnClickListener(r0);
        this.a.setOnClickListener(r0);
    }

    public WikItemHomePageView(Context r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public void setFocus(boolean r1) {
        super.setFocus(r1);
        if (r1 == false) goto L5;
        int r2 = 2131256610;
    L6:
        setBackgroundResource(r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public WikItemHomePageView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
