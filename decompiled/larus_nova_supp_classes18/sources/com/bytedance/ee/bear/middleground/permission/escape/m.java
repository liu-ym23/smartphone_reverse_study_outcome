package com.bytedance.ee.bear.middleground.permission.escape;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements DialogInterface.OnClickListener {
    public final /* synthetic */ g.b a;

    public m(EscapeApiImpl.b r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        g.b r3 = this.a;
        if (r3 == null) goto L6;
        r3.onConfirm();
        return;
    }
}
