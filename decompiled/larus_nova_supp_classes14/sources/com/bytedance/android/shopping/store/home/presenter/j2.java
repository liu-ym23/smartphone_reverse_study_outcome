package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j2<T> implements Observer {
    public final /* synthetic */ ECShopTopBarBackPresenterV2 a;

    public j2(ECShopTopBarBackPresenterV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Float r2 = (Float) r1;
        ECShopTopBarBackPresenterV2.q0(this.a);
    }
}
