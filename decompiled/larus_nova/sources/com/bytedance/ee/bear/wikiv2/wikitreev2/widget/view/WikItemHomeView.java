package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class WikItemHomeView extends WikItemLeafView {
    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public float getItemHeightInDp() {
        return 56.5f;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void i(int r100, boolean r101) {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void e() {
        super.e();
        this.f242223b.setVisibility(8);
        this.f242233l.setVisibility(8);
        FrameLayout.LayoutParams r100 = (FrameLayout.LayoutParams) this.f242228g.getLayoutParams();
        r100.setMargins(com.bytedance.ee.util.ui.n.c(21.0f), 0, 0, 0);
        this.f242228g.setLayoutParams(r100);
        this.f242230i.setText(getResources().getText(R.string.Doc_Wiki_Tree_HomeTitle));
        if (this.f242230i.getPaint() == null) goto L5;
        this.f242230i.getPaint().setFakeBoldText(true);
    L5:
        this.f242230i.setPadding(com.bytedance.ee.util.ui.n.c(8.0f), 0, 0, 0);
    }

    public WikItemHomeView(Context r100) {
        super(r100);
    }

    public WikItemHomeView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
