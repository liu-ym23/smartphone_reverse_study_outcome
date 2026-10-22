package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import android.content.DialogInterface;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z implements DialogInterface.OnClickListener {
    public final /* synthetic */ sl.i a;
    public final /* synthetic */ e0 b;
    public final /* synthetic */ sl.k c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ Object e;

    public z(sl.i r1, e0 r2, sl.k r3, Context r4, Object r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        r3.dismiss();
        e0 r5 = this.b;
        String r6 = this.c.d();
        Map r0 = this.c.e();
        r5.getClass();
        oh.a.c("ECAlertDialogConfirmEvent", new c0(r6, r0));
        e0.c(this.b, this.d, this.a.a(), this.e);
    }
}
