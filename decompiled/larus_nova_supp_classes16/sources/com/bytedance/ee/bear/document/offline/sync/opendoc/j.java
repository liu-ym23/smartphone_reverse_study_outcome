package com.bytedance.ee.bear.document.offline.sync.opendoc;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements q25.e.a {
    public j() {
    }

    @Override // q25.e.a
    public final void f(int r2, final OfflineDoc r3) {
        tt5.a.h("OpenDocsPreloadDataLoader", "fetch ssr before render success");
        com.bytedance.ee.util.ui.j.c(new i(r3));
    }

    @Override // q25.e.a
    public final void g(int r2, final OfflineDoc r3) {
        tt5.a.h("OpenDocsPreloadDataLoader", "fetch ssr before render failed");
        com.bytedance.ee.util.ui.j.c(new h(r3));
    }

    @Override // q25.e.a
    public final void b(int r2, Throwable r3, final OfflineDoc r4) {
        tt5.a.f("OpenDocsPreloadDataLoader", r3, false);
        com.bytedance.ee.util.ui.j.c(new g(r4));
    }
}
