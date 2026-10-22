package com.bytedance.ee.bear.bitable.preload.util;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f215034a;

    public e(b r100) {
        this.f215034a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f215034a.getClass();
        tt5.a.e("BitablePreloadDBUtil", "clearLocalCsByTimeMills ", (Throwable) r100, false);
    }
}
