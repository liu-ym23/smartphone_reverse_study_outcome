package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.document.render.node.DocLoadingState;
import com.bytedance.ee.bear.document.render.node.RenderStage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u1 implements com.bytedance.ee.bear.document.render.node.g {
    public DocLoadingState a;
    public RenderStage b;
    public boolean c;

    public final void l() {
        this.c = true;
        if (this.a != DocLoadingState.INIT) goto L5;
        this.a = DocLoadingState.WAITING_DOWNLOAD;
        return;
    L5:
        tt5.a.k("DocStateTracker", "wrong state " + this.a + " for waitDownload");
    }

    public final void m() {
        this.c = true;
        DocLoadingState r0 = this.a;
        if (r0 != DocLoadingState.INIT) goto L5;
    L8:
        this.a = DocLoadingState.WAITING_PRELOAD;
        return;
    L5:
        if (r0 == DocLoadingState.WAITING_DOWNLOAD) goto L8;
        tt5.a.k("DocStateTracker", "wrong state " + this.a + " for waiting preload");
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final void a() {
        if (this.a != DocLoadingState.RENDERING) goto L5;
        this.b = RenderStage.PULL_DATA_END;
        return;
    L5:
        tt5.a.k("DocStateTracker", "wrong state " + this.b + " for pullDataEnd");
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final void c() {
        if (this.a != DocLoadingState.RENDERING) goto L5;
        this.b = RenderStage.RENDER_CACHE_START;
        return;
    L5:
        tt5.a.k("DocStateTracker", "wrong state " + this.b + " for renderCacheStart");
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final void d() {
        if (this.a != DocLoadingState.RENDERING) goto L5;
        this.b = RenderStage.RENDER_DOC_START;
        return;
    L5:
        tt5.a.k("DocStateTracker", "wrong state " + this.b + " for renderDocStart");
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final void e() {
        if (this.a != DocLoadingState.RENDERING) goto L5;
        this.b = RenderStage.RENDER_CACHE_END;
        return;
    L5:
        tt5.a.k("DocStateTracker", "wrong state " + this.b + " for renderCacheEnd");
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final void g() {
        if (this.a != DocLoadingState.RENDERING) goto L5;
        this.b = RenderStage.PULL_DATA_START;
        return;
    L5:
        tt5.a.k("DocStateTracker", "wrong state " + this.b + " for pullDataStart");
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final void h() {
        if (this.a != DocLoadingState.RENDERING) goto L5;
        this.b = RenderStage.RENDER_DOC_END;
        return;
    L5:
        tt5.a.k("DocStateTracker", "wrong state " + this.b + " for renderDocEnd");
    }

    public final void i() {
        DocLoadingState r0 = this.a;
        if (r0 != DocLoadingState.INIT) goto L5;
    L12:
        this.a = DocLoadingState.CANCELED;
        return;
    L5:
        if (r0 == DocLoadingState.WAITING_DOWNLOAD) goto L12;
        if (r0 == DocLoadingState.WAITING_PRELOAD) goto L12;
        if (r0 == DocLoadingState.RENDERING) goto L12;
        tt5.a.k("DocStateTracker", "wrong state " + this.a + " for cancel");
    }

    public final void j() {
        DocLoadingState r0 = this.a;
        if (r0 != DocLoadingState.INIT) goto L5;
    L12:
        this.a = DocLoadingState.OVERTIME;
        return;
    L5:
        if (r0 == DocLoadingState.WAITING_DOWNLOAD) goto L12;
        if (r0 == DocLoadingState.WAITING_PRELOAD) goto L12;
        if (r0 == DocLoadingState.RENDERING) goto L12;
        tt5.a.k("DocStateTracker", "wrong state " + this.a + " for overtime");
    }

    public final void k() {
        this.a = DocLoadingState.RENDERING;
        this.b = RenderStage.RENDERING;
    }

    public u1() {
        this.a = DocLoadingState.INIT;
        this.b = RenderStage.RENDERING;
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final RenderStage b() {
        return this.b;
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final boolean f() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final DocLoadingState state() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final void finish(boolean r3) {
        DocLoadingState r0 = this.a;
        if (r0 != DocLoadingState.WAITING_PRELOAD) goto L5;
    L10:
        if (r3 == false) goto L12;
        this.a = DocLoadingState.SUCCESS;
        return;
    L12:
        this.a = DocLoadingState.FAIL;
        return;
    L5:
        if (r0 == DocLoadingState.WAITING_DOWNLOAD) goto L10;
        if (r0 == DocLoadingState.RENDERING) goto L10;
        tt5.a.k("DocStateTracker", "wrong state " + this.a + " for finish");
    }
}
