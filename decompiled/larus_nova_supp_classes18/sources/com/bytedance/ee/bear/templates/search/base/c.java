package com.bytedance.ee.bear.templates.search.base;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ BaseView a;

    public c(BaseView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        if (((ConnectionService.NetworkState) r1).a() == false) goto L8;
        f.a r2 = this.a.e;
        if (r2 == null) goto L9;
        r2.l4();
        return;
    L9:
        return;
    }
}
