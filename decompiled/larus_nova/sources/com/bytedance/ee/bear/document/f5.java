package com.bytedance.ee.bear.document;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class f5<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f5<T> f219854a = null;

    static {
        f219854a = new f5();
    }

    public f5() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d(ImageResDeletePlugin.TAG, "exception " + ((Throwable) r100).getMessage());
    }
}
