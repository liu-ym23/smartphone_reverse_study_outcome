package com.bytedance.ee.bear.templates.preview.announce;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ TemplateCardPanelFragment a;

    public g(TemplateCardPanelFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        AnnounceTemplateViewModel r2 = this.a.k;
        if (r2 == null) goto L6;
        r2.onClickHidePanel();
        return;
    }
}
