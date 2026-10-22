package com.bytedance.ee.bear.wikiv2.home2;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.NoNetworkView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ k a;

    public p(k r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        ConnectionService.NetworkState r4 = (ConnectionService.NetworkState) r3;
        NoNetworkView r0 = this.a.j;
        if (r4.a() == false) goto L5;
        int r1 = 8;
    L6:
        r0.setVisibility(r1);
        SmartRefreshLayout r2 = this.a.d;
        r2.A = r4.a();
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
