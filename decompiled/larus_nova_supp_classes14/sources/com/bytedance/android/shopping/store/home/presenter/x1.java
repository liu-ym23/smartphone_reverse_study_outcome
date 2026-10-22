package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x1<T> implements Observer {
    public final /* synthetic */ w1.b a;

    public x1(w1.b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        ShopHeaderVideoVO r2 = (ShopHeaderVideoVO) r1;
        w1.q0(this.a.a);
    }
}
