package com.bytedance.ee.bear.tts.impl;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        this.a.o = false;
        if (d.s() == false) goto L5;
        tt5.a.h("TtsSession", "showPermissionDialogWithoutFloatPermission, click cancel");
        this.a.h();
        return;
    L5:
        this.a.n("showPermissionDialog, click cancel");
    }
}
