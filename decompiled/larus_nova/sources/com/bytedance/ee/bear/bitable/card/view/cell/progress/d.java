package com.bytedance.ee.bear.bitable.card.view.cell.progress;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f207987a;

    public d(b r100) {
        this.f207987a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        b r101 = this.f207987a;
        b.a r102 = r101.f207983v;
        if (r102 == null) goto L5;
        r102.h1(r101.f207977p, r101.f207984w);
    L5:
        this.f207987a.c();
    }
}
