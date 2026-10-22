package com.bytedance.ee.bear.document.offline.sync;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ DocxPreloadStrategyV2 a;

    public m(DocxPreloadStrategyV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        String r0 = this.a.a;
        tt5.a.e(r0, "embedDocTokens failed", (Throwable) r4, false);
    }
}
