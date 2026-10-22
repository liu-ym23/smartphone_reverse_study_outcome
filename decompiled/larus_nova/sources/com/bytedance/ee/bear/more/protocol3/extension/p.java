package com.bytedance.ee.bear.more.protocol3.extension;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p<T> f234840a = null;

    static {
        f234840a = new p();
    }

    public p() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("DefMoreInfoBehavior", "objInfoFlow, wikiStateFlow err. ", (Throwable) r100, false);
    }
}
