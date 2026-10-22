package com.bytedance.ee.bear.bitable.card.view.cell.progress;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProgressItemsAdapter f207988a;

    public e(ProgressItemsAdapter r100) {
        this.f207988a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ProgressItemsAdapter.a r101 = this.f207988a.f207954l;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
