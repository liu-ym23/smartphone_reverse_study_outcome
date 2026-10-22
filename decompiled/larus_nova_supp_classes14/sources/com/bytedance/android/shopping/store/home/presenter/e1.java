package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e1<T> implements Observer {
    public final /* synthetic */ ECShopLoadStatusPresenter a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ View c;

    public e1(ECShopLoadStatusPresenter r1, ViewGroup r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r4) {
        LoadStatus r5 = (LoadStatus) r4;
        ECShopLoadStatusPresenter r6 = this.a;
        r6.v0(this.b, this.c, (LoadStatus) r6.T().getTabLoadStatus().getValue());
    }
}
