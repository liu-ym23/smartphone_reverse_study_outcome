package com.bytedance.ee.bear.bitable.preload.util;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f215032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f215033b;

    public d(b r100) {
        this.f215032a = r100;
        this.f215033b = Long.MAX_VALUE;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f215032a.getClass();
        tt5.a.h("BitablePreloadDBUtil", "clearLocalCsByTimeMills: over30TimeMills: " + this.f215033b + ", deleteCount: " + ((Integer) r100));
    }
}
