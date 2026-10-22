package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u1<T> implements Consumer {
    public static final u1 a = null;

    static {
        a = new u1();
    }

    public u1() {
    }

    public final void accept(Object r2) {
        EnsureManager.ensureNotReachHere((Throwable) r2, "addPitayaTaskIfNeed error");
    }
}
