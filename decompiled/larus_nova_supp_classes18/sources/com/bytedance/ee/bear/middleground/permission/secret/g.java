package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements DialogInterface.OnClickListener {
    public final /* synthetic */ DialogInterface.OnClickListener a;
    public final /* synthetic */ SecretReviewModel b;
    public final /* synthetic */ boolean c;

    public g(DialogInterface.OnClickListener r1, SecretReviewModel r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        this.a.onClick(r2, r3);
        int r4 = ReSubmitApplyDialog.a;
        com.bytedance.ee.bear.middleground.permission.c.I("confirm", ReSubmitApplyDialog.b(this.b), this.c);
    }
}
