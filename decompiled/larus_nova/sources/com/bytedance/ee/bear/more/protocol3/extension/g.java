package com.bytedance.ee.bear.more.protocol3.extension;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T> f234831a = null;

    static {
        f234831a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("DefMoreInfoBehavior", "retentionFlow err. ", (Throwable) r100, false);
    }
}
