package com.bytedance.ee.bear.document;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class a1 implements Consumer {
    public final /* synthetic */ DocBridgeWebViewV2 a;

    public /* synthetic */ a1(DocBridgeWebViewV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        tt5.a.h(this.a.g1, "***reportPreloadHtml*** preloadTemplateNotDestroyWebview preloadWebview() result = " + ((Boolean) r4));
    }
}
