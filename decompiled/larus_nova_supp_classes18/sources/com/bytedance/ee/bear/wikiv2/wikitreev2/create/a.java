package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        ConnectionService.NetworkState r3 = (ConnectionService.NetworkState) r2;
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        this.a.b.setEnabled(r4);
        b r5 = this.a;
        r5.c = r5.c;
        return;
    L5:
        if (r3.a() == false) goto L7;
        r4 = true;
        goto L8
    }
}
