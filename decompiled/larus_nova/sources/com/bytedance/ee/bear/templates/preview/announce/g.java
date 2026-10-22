package com.bytedance.ee.bear.templates.preview.announce;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TemplateCardPanelFragment f239182a;

    public g(TemplateCardPanelFragment r100) {
        this.f239182a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AnnounceTemplateViewModel r101 = this.f239182a.f239162k;
        if (r101 == null) goto L6;
        r101.onClickHidePanel();
        return;
    }
}
