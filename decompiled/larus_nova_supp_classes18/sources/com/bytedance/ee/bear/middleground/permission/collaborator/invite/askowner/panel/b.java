package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements DialogInterface.OnDismissListener {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r1) {
        this.a.b.close();
    }
}
