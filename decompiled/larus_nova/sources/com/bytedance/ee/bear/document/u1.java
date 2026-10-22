package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.document.render.node.DocLoadingState;
import com.bytedance.ee.bear.document.render.node.RenderStage;

/* JADX INFO: loaded from: classes16.dex */
public final class u1 implements com.bytedance.ee.bear.document.render.node.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DocLoadingState f222434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RenderStage f222435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f222436c;

    public final void l() {
        this.f222436c = true;
        if (this.f222434a != DocLoadingState.INIT) goto L5;
        this.f222434a = DocLoadingState.WAITING_DOWNLOAD;
        return;
    L5:
        tt5.a.k("DocStateTracker", "wrong state " + this.f222434a + " for waitDownload");
    }

    public final void m() {
        this.f222436c = true;
        DocLoadingState r100 = this.f222434a;
        if (r100 != DocLoadingState.INIT) goto L5;
    L8:
        this.f222434a = DocLoadingState.WAITING_PRELOAD;
        return;
    L5:
        if (r100 == DocLoadingState.WAITING_DOWNLOAD) goto L8;
        tt5.a.k("DocStateTracker", "wrong state " + this.f222434a + " for waiting preload");
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final void a() {
        if (this.f222434a != DocLoadingState.RENDERING) goto L5;
        this.f222435b = RenderStage.PULL_DATA_END;
        return;
    L5:
        tt5.a.k("DocStateTracker", "wrong state " + this.f222435b + " for pullDataEnd");
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final void c() {
        if (this.f222434a != DocLoadingState.RENDERING) goto L5;
        this.f222435b = RenderStage.RENDER_CACHE_START;
        return;
    L5:
        tt5.a.k("DocStateTracker", "wrong state " + this.f222435b + " for renderCacheStart");
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final void d() {
        if (this.f222434a != DocLoadingState.RENDERING) goto L5;
        this.f222435b = RenderStage.RENDER_DOC_START;
        return;
    L5:
        tt5.a.k("DocStateTracker", "wrong state " + this.f222435b + " for renderDocStart");
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final void e() {
        if (this.f222434a != DocLoadingState.RENDERING) goto L5;
        this.f222435b = RenderStage.RENDER_CACHE_END;
        return;
    L5:
        tt5.a.k("DocStateTracker", "wrong state " + this.f222435b + " for renderCacheEnd");
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final void g() {
        if (this.f222434a != DocLoadingState.RENDERING) goto L5;
        this.f222435b = RenderStage.PULL_DATA_START;
        return;
    L5:
        tt5.a.k("DocStateTracker", "wrong state " + this.f222435b + " for pullDataStart");
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final void h() {
        if (this.f222434a != DocLoadingState.RENDERING) goto L5;
        this.f222435b = RenderStage.RENDER_DOC_END;
        return;
    L5:
        tt5.a.k("DocStateTracker", "wrong state " + this.f222435b + " for renderDocEnd");
    }

    public final void i() {
        DocLoadingState r100 = this.f222434a;
        if (r100 != DocLoadingState.INIT) goto L5;
    L12:
        this.f222434a = DocLoadingState.CANCELED;
        return;
    L5:
        if (r100 == DocLoadingState.WAITING_DOWNLOAD) goto L12;
        if (r100 == DocLoadingState.WAITING_PRELOAD) goto L12;
        if (r100 == DocLoadingState.RENDERING) goto L12;
        tt5.a.k("DocStateTracker", "wrong state " + this.f222434a + " for cancel");
    }

    public final void j() {
        DocLoadingState r100 = this.f222434a;
        if (r100 != DocLoadingState.INIT) goto L5;
    L12:
        this.f222434a = DocLoadingState.OVERTIME;
        return;
    L5:
        if (r100 == DocLoadingState.WAITING_DOWNLOAD) goto L12;
        if (r100 == DocLoadingState.WAITING_PRELOAD) goto L12;
        if (r100 == DocLoadingState.RENDERING) goto L12;
        tt5.a.k("DocStateTracker", "wrong state " + this.f222434a + " for overtime");
    }

    public final void k() {
        this.f222434a = DocLoadingState.RENDERING;
        this.f222435b = RenderStage.RENDERING;
    }

    public u1() {
        this.f222434a = DocLoadingState.INIT;
        this.f222435b = RenderStage.RENDERING;
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final RenderStage b() {
        return this.f222435b;
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final boolean f() {
        return this.f222436c;
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final DocLoadingState state() {
        return this.f222434a;
    }

    @Override // com.bytedance.ee.bear.document.render.node.g
    public final void finish(boolean r100) {
        DocLoadingState r101 = this.f222434a;
        if (r101 != DocLoadingState.WAITING_PRELOAD) goto L5;
    L10:
        if (r100 == false) goto L12;
        this.f222434a = DocLoadingState.SUCCESS;
        return;
    L12:
        this.f222434a = DocLoadingState.FAIL;
        return;
    L5:
        if (r101 == DocLoadingState.WAITING_DOWNLOAD) goto L10;
        if (r101 == DocLoadingState.RENDERING) goto L10;
        tt5.a.k("DocStateTracker", "wrong state " + this.f222434a + " for finish");
    }
}
