package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t implements DialogInterface.OnClickListener {
    public final /* synthetic */ r a;
    public final /* synthetic */ AlertModel b;
    public final /* synthetic */ tb5.m c;
    public final /* synthetic */ Ref.BooleanRef d;

    public t(r r1, AlertModel r2, tb5.m r3, Ref.BooleanRef r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r9, int r10) {
        r.c(this.a, ((AlertModel.ButtonsBean) ListProtector.get(this.b.getButtons(), 1)).getId(), null, this.c, ((AlertModel.ButtonsBean) ListProtector.get(this.b.getButtons(), 1)).isAutoDismiss(), Boolean.valueOf(this.d.element), null, 32);
    }
}
