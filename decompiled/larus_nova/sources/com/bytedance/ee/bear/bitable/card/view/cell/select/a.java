package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseRecordSelectView f208118a;

    public a(BaseRecordSelectView r100) {
        this.f208118a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f208118a.requestFocus();
    }
}
