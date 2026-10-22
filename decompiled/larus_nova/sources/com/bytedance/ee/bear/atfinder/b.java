package com.bytedance.ee.bear.atfinder;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements Consumer<Throwable> {
    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        tt5.a.e("AtFinderController", "accept: exception", r100, false);
    }
}
