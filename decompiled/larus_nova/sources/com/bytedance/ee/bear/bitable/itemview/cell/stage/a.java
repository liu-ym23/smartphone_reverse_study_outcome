package com.bytedance.ee.bear.bitable.itemview.cell.stage;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f213963a;

    public a(Runnable r100) {
        this.f213963a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        rcb.c.d(r100);
        this.f213963a.run();
    }
}
