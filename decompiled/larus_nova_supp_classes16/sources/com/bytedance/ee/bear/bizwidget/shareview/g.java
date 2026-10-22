package com.bytedance.ee.bear.bizwidget.shareview;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class g implements DialogInterface.OnDismissListener {
    public final /* synthetic */ h.b a;

    public /* synthetic */ g(h.b r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r1) {
        this.a.onDismiss();
    }
}
