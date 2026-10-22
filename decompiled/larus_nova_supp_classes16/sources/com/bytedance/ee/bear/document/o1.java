package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.doc.resupdate.EChannel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o1 implements com.bytedance.ee.bear.doc.resupdate.a0 {
    public final /* synthetic */ com.bytedance.ee.bear.doc.resupdate.g a;
    public final /* synthetic */ DocBridgeWebViewV2 b;

    @Override // com.bytedance.ee.bear.doc.resupdate.a0
    public final void a(String r2) {
        DocBridgeWebViewV2.B(this.b);
        this.a.d(EChannel.DOCS_FULLPKG_CHANNEL, this);
    }

    public o1(DocBridgeWebViewV2 r1, com.bytedance.ee.bear.doc.resupdate.g r2) {
        this.b = r1;
        this.a = r2;
    }
}
