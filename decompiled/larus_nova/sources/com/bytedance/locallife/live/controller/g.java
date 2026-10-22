package com.bytedance.locallife.live.controller;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes21.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f259386a;

    public g(f r100) {
        this.f259386a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f259386a.d();
    }
}
