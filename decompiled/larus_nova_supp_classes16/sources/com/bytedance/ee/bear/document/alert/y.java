package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class y implements DialogInterface.OnClickListener {
    public final /* synthetic */ r a;
    public final /* synthetic */ AlertModel b;
    public final /* synthetic */ tb5.m c;

    public y(r r1, AlertModel r2, tb5.m r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r9, int r10) {
        r r0 = this.a;
        String r11 = ((AlertModel.ButtonsBean) ListProtector.get(this.b.getButtons(), 0)).getId();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r.c(r0, r11, null, this.c, ((AlertModel.ButtonsBean) ListProtector.get(this.b.getButtons(), 0)).isAutoDismiss(), null, null, 48);
    }
}
