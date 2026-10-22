package com.bytedance.ee.bear.templates.search.base;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseView f239386a;

    public c(BaseView r100) {
        this.f239386a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((ConnectionService.NetworkState) r100).a() == false) goto L8;
        f.a r101 = this.f239386a.f239372e;
        if (r101 == null) goto L9;
        r101.l4();
        return;
    L9:
        return;
    }
}
