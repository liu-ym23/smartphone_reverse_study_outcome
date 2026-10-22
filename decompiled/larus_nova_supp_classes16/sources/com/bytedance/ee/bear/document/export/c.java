package com.bytedance.ee.bear.document.export;

import com.bytedance.ee.bear.document.export.viewmodel.SlidesExportViewModel;
import io.reactivex.disposables.Disposable;
import rw4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements SlidesExportViewModel.a {
    public final /* synthetic */ e a;

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final void g() {
        e r0 = this.a;
        Disposable r1 = r0.e;
        if (r1 == null) goto L6;
        r1.dispose();
        r0.e = null;
    L6:
        com.bytedance.ee.bear.document.export.net.exportV2.a r2 = r0.d;
        if (r2 == null) goto L10;
        r2.cancel();
        return;
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final String getToken() {
        return this.a.b.d;
    }

    public c(e r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final void b(String r2) {
        e.d(this.a, r2);
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final void d(String r2) {
        e.b(this.a, r2);
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final void j(String r2) {
        this.a.s(r2);
    }

    public final void k(n r9, rw4.a r10) {
        tt5.a.h("DocumentExportAction", "export slides document, format = " + r9);
        e r2 = this.a;
        r2.w(r9, sbb.e.d(r2.b.b).getType(), this.a.b.d, null, r10);
        this.a.c.f(r9.a);
    }

    @Override // com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel.a
    public final void a(n r1, String r2, rw4.a r3) {
        k(r1, r3);
    }
}
