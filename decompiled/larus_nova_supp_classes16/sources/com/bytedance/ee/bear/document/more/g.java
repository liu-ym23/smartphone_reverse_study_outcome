package com.bytedance.ee.bear.document.more;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ DocMoreProvider a;

    public g(DocMoreProvider r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        ConnectionService.NetworkState r2 = (ConnectionService.NetworkState) r1;
        this.a.g();
    }
}
