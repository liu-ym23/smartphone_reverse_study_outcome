package com.bytedance.ee.bear.templates.horizontal;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ HorizontalTemplatePresenter a;

    public f(HorizontalTemplatePresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        ConnectionService.NetworkState r3 = (ConnectionService.NetworkState) r2;
        if (this.a.e == true) goto L12;
        if (r3 == null) goto L8;
        boolean r0 = true;
        if (r3.a() != true) goto L8;
    L9:
        if (r0 == false) goto L13;
        this.a.H8();
        return;
    L13:
        return;
    L8:
        r0 = false;
        goto L9
    }
}
