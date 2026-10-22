package com.bytedance.ee.bear.bitable.card.view.cell.text;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextCellViewHolder f208257a;

    public k(TextCellViewHolder r100) {
        this.f208257a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f208257a.Z4();
        this.f208257a.T4().q(this.f208257a.V4(), Boolean.TRUE, this.f208257a.Q4());
    }
}
