package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: classes18.dex */
public final class t<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiTreeFragment f241583a;

    public t(WikiTreeFragment r100) {
        this.f241583a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        this.f241583a.V90().setEnabled(((ConnectionService.NetworkState) r100).a());
    }
}
