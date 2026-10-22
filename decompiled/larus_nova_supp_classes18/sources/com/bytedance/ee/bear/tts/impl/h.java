package com.bytedance.ee.bear.tts.impl;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements DialogInterface.OnCancelListener {
    public final /* synthetic */ d a;

    public h(d r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r2) {
        this.a.o = false;
        if (d.s() == false) goto L5;
        tt5.a.h("TtsSession", "showPermissionDialogWithoutFloatPermission, onCancel");
        this.a.h();
        return;
    L5:
        this.a.n("showPermissionDialog, onCancel");
    }
}
