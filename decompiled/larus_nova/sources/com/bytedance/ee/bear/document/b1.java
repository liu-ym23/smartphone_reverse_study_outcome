package com.bytedance.ee.bear.document;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class b1 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocBridgeWebViewV2 f219142a;

    public /* synthetic */ b1(DocBridgeWebViewV2 r100) {
        this.f219142a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DocBridgeWebViewV2 r101 = this.f219142a;
        Throwable r102 = (Throwable) r100;
        tt5.a.f(r101.f218510g1, r102, false);
        iu5.d.a(r101.f218510g1, r102);
    }
}
