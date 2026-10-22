package com.bytedance.ee.bear.account.container.impl;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f206227a;

    public e(c r100) {
        this.f206227a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = this.f206227a.a();
        tt5.a.e(r101, "pull userInfo error", (Throwable) r100, false);
    }
}
