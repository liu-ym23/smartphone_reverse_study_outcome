package com.bytedance.ee.bear.tts.impl;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f239565a;

    public h(d r100) {
        this.f239565a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        this.f239565a.f239552o = false;
        if (d.s() == false) goto L5;
        tt5.a.h("TtsSession", "showPermissionDialogWithoutFloatPermission, onCancel");
        this.f239565a.h();
        return;
    L5:
        this.f239565a.n("showPermissionDialog, onCancel");
    }
}
