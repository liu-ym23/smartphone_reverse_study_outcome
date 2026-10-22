package com.bytedance.ee.bear.office.list.selectpanel;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ OfficeSelectPanelAdapter.ActionViewHolder a;
    public final /* synthetic */ d b;

    public a(OfficeSelectPanelAdapter.ActionViewHolder r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.a.invoke(this.b);
    }
}
