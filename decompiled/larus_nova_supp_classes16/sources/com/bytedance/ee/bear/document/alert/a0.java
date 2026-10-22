package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ r a;
    public final /* synthetic */ AlertModel b;
    public final /* synthetic */ tb5.m c;

    public a0(r r1, AlertModel r2, tb5.m r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r9, int r10) {
        r.c(this.a, ((AlertModel.ButtonsBean) ListProtector.get(this.b.getButtons(), 2)).getId(), null, this.c, ((AlertModel.ButtonsBean) ListProtector.get(this.b.getButtons(), 2)).isAutoDismiss(), null, null, 48);
    }
}
