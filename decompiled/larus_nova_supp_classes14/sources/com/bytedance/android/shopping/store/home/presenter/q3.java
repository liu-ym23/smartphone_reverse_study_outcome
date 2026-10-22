package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q3<T> implements Consumer {
    public static final q3 a = null;

    static {
        a = new q3();
    }

    public q3() {
    }

    public final void accept(Object r1) {
        ECExceptionMonitor.e((Throwable) r1);
    }
}
