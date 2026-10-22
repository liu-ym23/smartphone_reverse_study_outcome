package com.bytedance.android.shopping.store.search.presenter;

import android.widget.LinearLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ ShopSearchHotViewPresenter a;

    public k(ShopSearchHotViewPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        ShopSearchHotViewPresenter r0 = this.a;
        int r1 = ShopSearchHotViewPresenter.l;
        ((LinearLayout) r0.w().b(2131367514).f()).setVisibility(((Integer) r3).intValue());
    }
}
