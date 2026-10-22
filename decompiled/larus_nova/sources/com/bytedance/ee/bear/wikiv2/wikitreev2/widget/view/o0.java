package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: classes18.dex */
public final class o0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSpaceMoreProvider f242530a;

    public o0(WikiSpaceMoreProvider r100) {
        this.f242530a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ConnectionService.NetworkState r101 = (ConnectionService.NetworkState) r100;
        this.f242530a.g();
    }
}
