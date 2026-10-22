package com.bytedance.ee.bear.templates.center.list.base;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTemplateListPresenter f239013a;

    public i(BaseTemplateListPresenter r100) {
        this.f239013a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ConnectionService.NetworkState r101 = (ConnectionService.NetworkState) r100;
        if (r101 == null) goto L5;
        boolean r102 = r101.a();
    L6:
        BaseTemplateListPresenter r103 = this.f239013a;
        if (r103.f238963i == true) goto L12;
        if (r102 == false) goto L12;
        if (r103.f238961g == true) goto L12;
        r103.R8(-1);
    L12:
        this.f239013a.f238963i = r102;
        return;
    L5:
        r102 = false;
        goto L6
    }
}
