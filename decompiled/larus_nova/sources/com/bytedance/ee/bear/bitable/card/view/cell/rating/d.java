package com.bytedance.ee.bear.bitable.card.view.cell.rating;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f208027a;

    public d(b r100) {
        this.f208027a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        b.a r101 = this.f208027a.f208022h;
        if (r101 == null) goto L6;
        r101.onDismiss();
        return;
    }
}
