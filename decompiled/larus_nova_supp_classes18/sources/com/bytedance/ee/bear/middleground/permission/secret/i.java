package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.DialogInterface;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements DialogInterface.OnClickListener {
    public final /* synthetic */ DialogInterface.OnClickListener a;
    public final /* synthetic */ boolean b;

    public i(DialogInterface.OnClickListener r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        DialogInterface.OnClickListener r0 = this.a;
        if (r0 == null) goto L5;
        r0.onClick(r2, r3);
    L5:
        com.bytedance.ee.bear.middleground.permission.c.I(DocFeed$Value$Result.CANCEL, true, this.b);
    }
}
