package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikItemNoneView extends WikItemLeafView {
    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void f() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void e() {
        super.e();
        this.b.setVisibility(4);
        this.d.setVisibility(8);
        this.g.setVisibility(4);
        this.i.setText(getResources().getString(2131887500));
        this.i.setTextColor(getResources().getColor(2131106607));
        setEnabled(false);
    }

    public WikItemNoneView(Context r1) {
        super(r1);
    }

    public WikItemNoneView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public WikItemNoneView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public WikItemNoneView(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }
}
