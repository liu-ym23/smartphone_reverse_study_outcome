package com.bytedance.ee.bear.more.protocol3.extension;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r<T> f234842a = null;

    static {
        f234842a = new r();
    }

    public r() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("DefMoreInfoBehavior", "permFlow err. ", (Throwable) r100, false);
    }
}
