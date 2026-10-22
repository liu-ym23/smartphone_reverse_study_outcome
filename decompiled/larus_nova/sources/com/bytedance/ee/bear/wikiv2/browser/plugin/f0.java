package com.bytedance.ee.bear.wikiv2.browser.plugin;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class f0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0<T> f240549a = null;

    static {
        f240549a = new f0();
    }

    public f0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d(WikiFolderBlockMorePlugin.TAG, "get perm info failed, error = " + ((Throwable) r100));
    }
}
