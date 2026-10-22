package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k<T> implements Consumer {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        dm.a.a("ECShopMemberCardPresenter").a("applyCoupon：" + r5);
        EnsureManager.ensureNotReachHere(r5);
    }
}
