package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ WikiSpaceListFragment a;

    public c(WikiSpaceListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        ConnectionService.NetworkState r3 = (ConnectionService.NetworkState) r2;
        if (r3 == null) goto L6;
        this.a.W90().setNetworkChange(r3);
        return;
    }
}
