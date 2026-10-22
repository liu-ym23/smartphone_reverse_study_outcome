package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j<T> f240788a = null;

    static {
        f240788a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("WikiSpaceListView", "getCachedRelationIds err. ", (Throwable) r100, false);
    }
}
