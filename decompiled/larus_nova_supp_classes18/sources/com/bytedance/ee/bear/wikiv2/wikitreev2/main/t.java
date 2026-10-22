package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t<T> implements Observer {
    public final /* synthetic */ WikiTreeFragment a;

    public t(WikiTreeFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        this.a.V90().setEnabled(((ConnectionService.NetworkState) r2).a());
    }
}
