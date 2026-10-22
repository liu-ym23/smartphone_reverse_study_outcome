package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSpaceListFragment f240778a;

    public c(WikiSpaceListFragment r100) {
        this.f240778a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ConnectionService.NetworkState r101 = (ConnectionService.NetworkState) r100;
        if (r101 == null) goto L6;
        this.f240778a.W90().setNetworkChange(r101);
        return;
    }
}
