package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements DialogInterface.OnClickListener {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        com.bytedance.ee.bear.middleground.permission.c.K("known");
    }
}
