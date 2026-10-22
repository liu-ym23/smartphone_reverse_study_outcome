package com.bytedance.locallife.dito.core;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes21.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q<T> f257970a = null;

    static {
        f257970a = new q();
    }

    public q() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((Throwable) r100).printStackTrace();
    }
}
