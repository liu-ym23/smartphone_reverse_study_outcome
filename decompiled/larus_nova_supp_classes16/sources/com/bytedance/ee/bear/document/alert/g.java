package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements DialogInterface.OnCancelListener {
    public final /* synthetic */ e a;
    public final /* synthetic */ tb5.m b;

    public g(e r1, tb5.m r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r9) {
        e.e(this.a, "cancel_by_touch_outside", null, this.b, true, Boolean.FALSE, null, 32);
    }
}
