package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g<T> implements Consumer {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final void accept(Object r2) {
        EnsureManager.ensureNotReachHere((Throwable) r2, "collapseHeaderIfNeed error");
    }
}
