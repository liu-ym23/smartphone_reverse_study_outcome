package com.bytedance.locallife.poi.dito.poi.component;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes21.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k<T> f262522a = null;

    static {
        f262522a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((Throwable) r100).printStackTrace();
    }
}
