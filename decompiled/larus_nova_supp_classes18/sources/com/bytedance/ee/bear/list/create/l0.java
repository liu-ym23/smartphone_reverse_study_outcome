package com.bytedance.ee.bear.list.create;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class l0 implements Consumer {
    public /* synthetic */ l0() {
    }

    public final void accept(Object r4) {
        q0.h();
        tt5.a.e("DocumentCreator", "createOfflineDocument failed", (Throwable) r4, false);
    }
}
