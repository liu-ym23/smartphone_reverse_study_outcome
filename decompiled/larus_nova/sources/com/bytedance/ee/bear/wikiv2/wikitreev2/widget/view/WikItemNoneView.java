package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class WikItemNoneView extends WikItemLeafView {
    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void f() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void e() {
        super.e();
        this.f242223b.setVisibility(4);
        this.f242225d.setVisibility(8);
        this.f242228g.setVisibility(4);
        this.f242230i.setText(getResources().getString(R.string.CreationMobile_Wiki_NoSubpages_Placeholder));
        this.f242230i.setTextColor(getResources().getColor(R.color.text_caption));
        setEnabled(false);
    }

    public WikItemNoneView(Context r100) {
        super(r100);
    }

    public WikItemNoneView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public WikItemNoneView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    public WikItemNoneView(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
    }
}
