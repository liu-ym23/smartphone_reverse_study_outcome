package com.ss.android.lark.utils.rxjava;

import io.reactivex.Observer;

/* JADX INFO: loaded from: classes38.dex */
public abstract class d<T> implements Observer<T> {
    public d() {
    }

    public abstract void a(Throwable r100);

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        e.a(r100);
        a(r100);
    }
}
