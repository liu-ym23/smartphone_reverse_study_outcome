package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements DialogInterface.OnClickListener {
    public final /* synthetic */ String a;

    public l(String r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        b0.d(this.a);
        com.bytedance.ee.bear.middleground.permission.c.K("view_checking");
    }
}
