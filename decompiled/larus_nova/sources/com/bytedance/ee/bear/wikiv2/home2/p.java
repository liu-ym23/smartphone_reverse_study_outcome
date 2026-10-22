package com.bytedance.ee.bear.wikiv2.home2;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.NoNetworkView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes18.dex */
public final class p<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f240944a;

    public p(k r100) {
        this.f240944a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ConnectionService.NetworkState r101 = (ConnectionService.NetworkState) r100;
        NoNetworkView r102 = this.f240944a.f240850j;
        if (r101.a() == false) goto L5;
        int r103 = 8;
    L6:
        r102.setVisibility(r103);
        SmartRefreshLayout r104 = this.f240944a.f240844d;
        r104.A = r101.a();
        return;
    L5:
        r103 = 0;
        goto L6
    }
}
