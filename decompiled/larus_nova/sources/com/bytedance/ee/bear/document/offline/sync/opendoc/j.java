package com.bytedance.ee.bear.document.offline.sync.opendoc;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;

/* JADX INFO: loaded from: classes16.dex */
public final class j implements q25.e.a {
    public j() {
    }

    @Override // q25.e.a
    public final void f(int r100, final OfflineDoc r101) {
        tt5.a.h("OpenDocsPreloadDataLoader", "fetch ssr before render success");
        com.bytedance.ee.util.ui.j.c(new i(r101));
    }

    @Override // q25.e.a
    public final void g(int r100, final OfflineDoc r101) {
        tt5.a.h("OpenDocsPreloadDataLoader", "fetch ssr before render failed");
        com.bytedance.ee.util.ui.j.c(new h(r101));
    }

    @Override // q25.e.a
    public final void b(int r100, Throwable r101, final OfflineDoc r102) {
        tt5.a.f("OpenDocsPreloadDataLoader", r101, false);
        com.bytedance.ee.util.ui.j.c(new g(r102));
    }
}
