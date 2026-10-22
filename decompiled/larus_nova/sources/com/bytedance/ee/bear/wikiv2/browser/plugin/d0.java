package com.bytedance.ee.bear.wikiv2.browser.plugin;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class d0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0<T> f240541a = null;

    static {
        f240541a = new d0();
    }

    public d0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e(WikiFolderBlockMorePlugin.TAG, "requestOriginTitle fail. ", (Throwable) r100, false);
    }
}
