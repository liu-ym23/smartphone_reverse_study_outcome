package com.bytedance.ee.bear.bitable.preload.util;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f215046a;

    public n(b r100) {
        this.f215046a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f215046a.getClass();
        tt5.a.e("BitablePreloadDBUtil", "deleteResource ", (Throwable) r100, false);
    }
}
