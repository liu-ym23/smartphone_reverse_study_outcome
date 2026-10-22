package com.bytedance.android.shopping.store.home.presenter.preview;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ ECShopPreviewBottomInfoPresenter a;

    public k(ECShopPreviewBottomInfoPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Pair r4 = (Pair) r3;
        this.a.k0((String) r4.getFirst(), ((Boolean) r4.getSecond()).booleanValue());
    }
}
