package com.bytedance.android.shopping.store.moments.module.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ ECStoreShortVideoPresenterNew a;

    public m(ECStoreShortVideoPresenterNew r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        this.a.e0(((Boolean) r2).booleanValue());
    }
}
