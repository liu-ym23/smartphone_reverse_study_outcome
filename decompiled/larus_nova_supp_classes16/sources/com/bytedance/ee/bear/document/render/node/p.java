package com.bytedance.ee.bear.document.render.node;

import com.bytedance.ee.bear.contract.n0;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.domain.BearUrl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p extends n0 {
    public final /* synthetic */ DocumentLoaderV3 a;
    public final /* synthetic */ RenderSSRNode b;
    public final /* synthetic */ e c;
    public final /* synthetic */ com.bytedance.ee.bear.document.d d;
    public final /* synthetic */ BearUrl e;

    @Override // com.bytedance.ee.bear.contract.n0, com.bytedance.ee.bear.contract.m0
    public final void g() {
        DocumentLoaderV3 r0 = this.a;
        if (r0 == null) goto L5;
        r0.n(this);
    L5:
        this.b.a = null;
        tt5.a.h("RenderSSRNode", this.c.f() + "WebView is ready, so can use ssr.");
        RenderSSRNode r1 = this.b;
        e r2 = this.c;
        com.bytedance.ee.bear.document.d r3 = this.d;
        BearUrl r4 = this.e;
        r1.getClass();
        RenderSSRNode.a(r2, r3, r4);
    }

    public p(DocumentLoaderV3 r1, RenderSSRNode r2, DocumentLoaderV3 r3, com.bytedance.ee.bear.document.d r4, BearUrl r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
