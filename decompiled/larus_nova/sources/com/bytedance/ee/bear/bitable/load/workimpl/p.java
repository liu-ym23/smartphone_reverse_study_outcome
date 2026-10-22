package com.bytedance.ee.bear.bitable.load.workimpl;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p<T> f214583a = null;

    static {
        f214583a = new p();
    }

    public p() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.h("SetupTimeOutWork", "***reportPreloadHtml*** preloadTemplate result:" + ((Boolean) r100).booleanValue());
    }
}
