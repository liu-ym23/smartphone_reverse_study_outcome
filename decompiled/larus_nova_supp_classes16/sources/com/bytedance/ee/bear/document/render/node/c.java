package com.bytedance.ee.bear.document.render.node;

import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.domain.BearUrl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements x2.b {
    public final /* synthetic */ EditionRenderNode a;
    public final /* synthetic */ DocViewModel b;
    public final /* synthetic */ e c;

    @Override // com.bytedance.ee.bear.document.x2.b
    public final /* synthetic */ void onLoadCancel() {
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public final void onLoadStart() {
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public final /* synthetic */ void onSSRLoadSuccess() {
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public final void onLoadSuccess() {
        z05.d r0 = this.a.a;
        BearUrl r1 = this.b.getBearUrl();
        com.bytedance.ee.bear.document.editionmanager.executor.k r2 = r0.a;
        r2.getClass();
        iu5.f.a(new com.bytedance.ee.bear.document.editionmanager.executor.f(r2, r1, sbb.e.e(r1.a)));
        this.c.S(this);
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public final void onLoadFail(int r1, Throwable r2) {
        this.c.S(this);
    }

    public c(EditionRenderNode r1, DocViewModel r2, DocumentLoaderV3 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
