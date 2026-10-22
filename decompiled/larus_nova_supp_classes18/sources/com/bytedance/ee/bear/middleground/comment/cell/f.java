package com.bytedance.ee.bear.middleground.comment.cell;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements DialogInterface.OnDismissListener {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p a;

    public f(com.bytedance.ee.bear.middleground.comment.uitls.p r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        this.a.N.a(new ef5.k());
    }
}
