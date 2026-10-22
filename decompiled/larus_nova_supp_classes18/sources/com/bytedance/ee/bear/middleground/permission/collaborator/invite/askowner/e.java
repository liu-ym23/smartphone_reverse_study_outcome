package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements DialogInterface.OnDismissListener {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r1) {
        d.b r2 = this.a.d;
        if (r2 == null) goto L6;
        r2.finish();
        return;
    }
}
