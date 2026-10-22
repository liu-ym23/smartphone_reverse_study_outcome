package com.bytedance.ee.bear.document.print;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l<T> f221190a = null;

    static {
        f221190a = new l();
    }

    public l() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.k("PrintExportCoordinator", "query comment state from server failed, show content options: ".concat(((Throwable) r100).getClass().getSimpleName()));
    }
}
