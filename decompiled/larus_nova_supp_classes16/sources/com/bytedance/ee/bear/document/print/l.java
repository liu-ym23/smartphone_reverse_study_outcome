package com.bytedance.ee.bear.document.print;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l<T> implements Consumer {
    public static final l<T> a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public final void accept(Object r2) {
        tt5.a.k("PrintExportCoordinator", "query comment state from server failed, show content options: ".concat(((Throwable) r2).getClass().getSimpleName()));
    }
}
