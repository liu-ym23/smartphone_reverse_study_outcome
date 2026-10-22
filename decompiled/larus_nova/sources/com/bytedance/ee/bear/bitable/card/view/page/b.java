package com.bytedance.ee.bear.bitable.card.view.page;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f208571a = null;

    static {
        f208571a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("RecordSubscribePresenter", "changeAutoSubscribe error:", (Throwable) r100, false);
    }
}
