package com.bytedance.ee.bear.bitable.celleditor.menu;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f209580a;

    public d(a r100) {
        this.f209580a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        a.a(this.f209580a);
    }
}
