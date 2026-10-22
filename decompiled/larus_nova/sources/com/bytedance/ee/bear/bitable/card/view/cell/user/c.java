package com.bytedance.ee.bear.bitable.card.view.cell.user;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserCellContainer f208371a;

    public c(UserCellContainer r100) {
        this.f208371a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f208371a.requestFocus();
    }
}
