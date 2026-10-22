package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.DialogInterface;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ DialogInterface.OnClickListener a;
    public final /* synthetic */ SecretReviewModel b;
    public final /* synthetic */ boolean c;

    public f(DialogInterface.OnClickListener r1, SecretReviewModel r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        DialogInterface.OnClickListener r0 = this.a;
        if (r0 == null) goto L5;
        r0.onClick(r2, r3);
    L5:
        int r4 = ReSubmitApplyDialog.a;
        com.bytedance.ee.bear.middleground.permission.c.I(DocFeed$Value$Result.CANCEL, ReSubmitApplyDialog.b(this.b), this.c);
    }
}
