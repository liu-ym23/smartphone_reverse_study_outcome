package com.suite.lark.platform.component.cta;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ goc.a f460519a;

    public h(goc.a r100) {
        this.f460519a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        goc.a r101 = this.f460519a;
        if (r101 == null) goto L6;
        r101.onDismiss();
        return;
    }
}
