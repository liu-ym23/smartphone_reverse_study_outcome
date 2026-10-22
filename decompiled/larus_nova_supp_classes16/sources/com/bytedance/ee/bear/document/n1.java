package com.bytedance.ee.bear.document;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n1 implements com.bytedance.ee.bear.doc.resupdate.f0 {
    public final /* synthetic */ DocBridgeWebViewV2 a;

    @Override // com.bytedance.ee.bear.doc.resupdate.f0
    public final void onFail() {
        tt5.a.h(this.a.g1, "downloadFullResource onFail");
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.f0
    public final void onReady() {
        DocBridgeWebViewV2.B(this.a);
    }

    public n1(DocBridgeWebViewV2 r1) {
        this.a = r1;
    }
}
