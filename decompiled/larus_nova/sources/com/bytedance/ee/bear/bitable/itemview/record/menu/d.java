package com.bytedance.ee.bear.bitable.itemview.record.menu;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f214164a = null;

    static {
        f214164a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = b.f214155h;
        tt5.a.e("NavigationItem", "fetchBaseAddToken error", (Throwable) r100, false);
    }
}
