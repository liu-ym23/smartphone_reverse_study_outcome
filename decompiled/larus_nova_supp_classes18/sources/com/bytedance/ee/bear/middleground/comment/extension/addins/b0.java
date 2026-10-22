package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b0 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ a0 b;
    public final /* synthetic */ String c;

    public b0(boolean r1, a0 r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        if (this.a == false) goto L11;
        kf5.b r3 = this.b.getContext().d();
        if (r3 == null) goto L7;
        r3.c(this.c);
    L7:
        kf5.b r4 = this.b.getContext().d();
        if (r4 == null) goto L12;
        r4.l();
        return;
    L12:
        return;
    }
}
