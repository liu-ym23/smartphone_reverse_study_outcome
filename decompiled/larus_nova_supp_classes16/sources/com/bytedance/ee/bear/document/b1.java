package com.bytedance.ee.bear.document;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class b1 implements Consumer {
    public final /* synthetic */ DocBridgeWebViewV2 a;

    public /* synthetic */ b1(DocBridgeWebViewV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        DocBridgeWebViewV2 r0 = this.a;
        Throwable r5 = (Throwable) r4;
        tt5.a.f(r0.g1, r5, false);
        iu5.d.a(r0.g1, r5);
    }
}
