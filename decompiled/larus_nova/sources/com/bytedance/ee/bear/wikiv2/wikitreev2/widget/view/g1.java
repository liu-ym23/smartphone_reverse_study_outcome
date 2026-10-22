package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: classes18.dex */
public final class g1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiTreeMoreProvider f242486a;

    public g1(WikiTreeMoreProvider r100) {
        this.f242486a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ConnectionService.NetworkState r101 = (ConnectionService.NetworkState) r100;
        this.f242486a.g();
    }
}
