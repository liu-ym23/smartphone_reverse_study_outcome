package com.bytedance.ee.bear.bitable.homepage.list;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<T> f212793a = null;

    static {
        f212793a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.h("BitableHomeListFragment", "pull user result = " + ((Boolean) r100).booleanValue());
    }
}
