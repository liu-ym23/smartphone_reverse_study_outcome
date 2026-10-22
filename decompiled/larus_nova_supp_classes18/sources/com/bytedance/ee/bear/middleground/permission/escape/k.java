package com.bytedance.ee.bear.middleground.permission.escape;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements DialogInterface.OnCancelListener {
    public final /* synthetic */ g.b a;

    public k(EscapeApiImpl.b r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r1) {
        g.b r2 = this.a;
        if (r2 == null) goto L6;
        r2.onCancel();
        return;
    }
}
