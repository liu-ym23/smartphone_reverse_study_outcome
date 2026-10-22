package com.bytedance.ee.bear.watermark;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f239832a;

    public g(l.a r100) {
        this.f239832a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        this.f239832a.onError();
    }
}
