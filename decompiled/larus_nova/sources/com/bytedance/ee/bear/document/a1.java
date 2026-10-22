package com.bytedance.ee.bear.document;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class a1 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocBridgeWebViewV2 f218649a;

    public /* synthetic */ a1(DocBridgeWebViewV2 r100) {
        this.f218649a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.h(this.f218649a.f218510g1, "***reportPreloadHtml*** preloadTemplateNotDestroyWebview preloadWebview() result = " + ((Boolean) r100));
    }
}
