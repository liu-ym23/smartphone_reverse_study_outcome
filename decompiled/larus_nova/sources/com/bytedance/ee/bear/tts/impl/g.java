package com.bytedance.ee.bear.tts.impl;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f239564a;

    public g(d r100) {
        this.f239564a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        d r101 = this.f239564a;
        r101.f239552o = false;
        r101.n("showPermissionDialog, onDismiss");
    }
}
