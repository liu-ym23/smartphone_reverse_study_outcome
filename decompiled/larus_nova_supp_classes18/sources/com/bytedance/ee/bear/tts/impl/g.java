package com.bytedance.ee.bear.tts.impl;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements DialogInterface.OnDismissListener {
    public final /* synthetic */ d a;

    public g(d r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        d r3 = this.a;
        r3.o = false;
        r3.n("showPermissionDialog, onDismiss");
    }
}
