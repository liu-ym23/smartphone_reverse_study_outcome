package com.bytedance.ee.bear.list.create;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ m b;

    public g(FragmentActivity r1, m r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        int r5 = e.a;
        e.a(this.a, (NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        e.b(this.b, "notify_admin");
    }
}
