package com.bytedance.ee.bear.bitable.jsapi.common;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes15.dex */
public final class j implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bb5.h f214415a;

    public j(bb5.h r100) {
        this.f214415a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        tt5.a.b("NewLarkForm", "onDismiss");
        bb5.h r101 = this.f214415a;
        if (r101 == null) goto L6;
        r101.onDismiss();
        return;
    }
}
