package com.bytedance.ee.bear.templates.center.list.base;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ BaseTemplateListPresenter a;

    public i(BaseTemplateListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        ConnectionService.NetworkState r4 = (ConnectionService.NetworkState) r3;
        if (r4 == null) goto L5;
        boolean r5 = r4.a();
    L6:
        BaseTemplateListPresenter r0 = this.a;
        if (r0.i == true) goto L12;
        if (r5 == false) goto L12;
        if (r0.g == true) goto L12;
        r0.R8(-1);
    L12:
        this.a.i = r5;
        return;
    L5:
        r5 = false;
        goto L6
    }
}
