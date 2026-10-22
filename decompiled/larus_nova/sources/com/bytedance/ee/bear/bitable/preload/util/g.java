package com.bytedance.ee.bear.bitable.preload.util;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f215037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f215038b;

    public g(b r100) {
        this.f215037a = r100;
        this.f215038b = Long.MAX_VALUE;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f215037a.getClass();
        tt5.a.h("BitablePreloadDBUtil", "clearRenderDataByTimeMills: timeout : " + this.f215038b + ", deleteCount: " + ((Integer) r100));
    }
}
