package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g1<T> implements Observer {
    public final /* synthetic */ WikiTreeMoreProvider a;

    public g1(WikiTreeMoreProvider r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        ConnectionService.NetworkState r2 = (ConnectionService.NetworkState) r1;
        this.a.g();
    }
}
