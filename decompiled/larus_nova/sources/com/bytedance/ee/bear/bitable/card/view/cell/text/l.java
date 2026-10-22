package com.bytedance.ee.bear.bitable.card.view.cell.text;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextCellViewHolder f208258a;

    public l(TextCellViewHolder r100) {
        this.f208258a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f208258a.Z4();
        this.f208258a.T4().q(this.f208258a.V4(), Boolean.TRUE, this.f208258a.Q4());
    }
}
