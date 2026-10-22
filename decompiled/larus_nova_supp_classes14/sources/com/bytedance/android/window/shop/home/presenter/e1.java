package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e1<T> implements Consumer {
    public static final e1 a = null;

    static {
        a = new e1();
    }

    public e1() {
    }

    public final void accept(Object r1) {
        ECExceptionMonitor.e((Throwable) r1);
    }
}
