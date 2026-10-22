package com.bytedance.ee.bear.list.create;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.ee.bear.contract.NetService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ Context a;

    public f(Context r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        int r5 = e.a;
        e.a(this.a, (NetService) org.koin.java.a.c(NetService.class, null, null, 6));
    }
}
