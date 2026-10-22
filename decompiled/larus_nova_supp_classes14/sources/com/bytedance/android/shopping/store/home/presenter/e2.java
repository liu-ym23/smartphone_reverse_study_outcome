package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e2<T> implements Observer {
    public final /* synthetic */ ECShopSliceTopBarPresenter.b a;

    public e2(ECShopSliceTopBarPresenter.b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        float r5 = ((Number) r4).floatValue();
        dm.a.a("ShopScrollTextViewManager").a("测试一下滑动_percent: " + r5);
        this.a.a.B.put("profile_scroll_percent", Float.valueOf(r5));
        ECShopSliceTopBarPresenter.q0(this.a.a);
    }
}
