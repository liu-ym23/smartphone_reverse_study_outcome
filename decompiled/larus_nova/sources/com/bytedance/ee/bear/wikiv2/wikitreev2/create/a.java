package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: classes18.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f241399a;

    public a(b r100) {
        this.f241399a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ConnectionService.NetworkState r101 = (ConnectionService.NetworkState) r100;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        this.f241399a.f241401b.setEnabled(r102);
        b r103 = this.f241399a;
        r103.f241402c = r103.f241402c;
        return;
    L5:
        if (r101.a() == false) goto L7;
        r102 = true;
        goto L8
    }
}
