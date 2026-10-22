package com.bytedance.locallife.dito.core;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes21.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o<T> f257967a = null;

    static {
        f257967a = new o();
    }

    public o() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((Throwable) r100).printStackTrace();
    }
}
