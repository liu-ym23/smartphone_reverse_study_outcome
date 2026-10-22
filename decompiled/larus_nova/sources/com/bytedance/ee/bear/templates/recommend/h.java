package com.bytedance.ee.bear.templates.recommend;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: classes18.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f239284a;

    public h(g r100) {
        this.f239284a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ConnectionService.NetworkState r101 = (ConnectionService.NetworkState) r100;
        if (this.f239284a.f239277j == true) goto L12;
        if (r101 == null) goto L8;
        boolean r102 = true;
        if (r101.a() != true) goto L8;
    L9:
        if (r102 == false) goto L13;
        this.f239284a.H8();
        return;
    L13:
        return;
    L8:
        r102 = false;
        goto L9
    }
}
