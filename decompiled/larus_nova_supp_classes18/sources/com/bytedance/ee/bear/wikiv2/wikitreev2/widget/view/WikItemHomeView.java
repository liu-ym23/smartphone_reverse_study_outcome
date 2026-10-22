package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikItemHomeView extends WikItemLeafView {
    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public float getItemHeightInDp() {
        return 56.5f;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void i(int r1, boolean r2) {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void e() {
        super.e();
        this.b.setVisibility(8);
        this.l.setVisibility(8);
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) this.g.getLayoutParams();
        r0.setMargins(com.bytedance.ee.util.ui.n.c(21.0f), 0, 0, 0);
        this.g.setLayoutParams(r0);
        this.i.setText(getResources().getText(2131888354));
        if (this.i.getPaint() == null) goto L5;
        this.i.getPaint().setFakeBoldText(true);
    L5:
        this.i.setPadding(com.bytedance.ee.util.ui.n.c(8.0f), 0, 0, 0);
    }

    public WikItemHomeView(Context r1) {
        super(r1);
    }

    public WikItemHomeView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
