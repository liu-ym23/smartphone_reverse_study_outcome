package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements DialogInterface.OnClickListener {
    public final /* synthetic */ DialogInterface.OnClickListener a;
    public final /* synthetic */ boolean b;

    public j(DialogInterface.OnClickListener r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        this.a.onClick(r2, r3);
        com.bytedance.ee.bear.middleground.permission.c.I("confirm", true, this.b);
    }
}
