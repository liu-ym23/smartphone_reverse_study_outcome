package com.bytedance.ee.bear.document.ssr;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements n.a {
    public g() {
    }

    @Override // com.bytedance.ee.bear.document.ssr.n.a
    public final void a(SimpleRequestResult r100, OfflineDoc r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "offlineDoc");
        com.bytedance.ee.util.ui.j.c(new d(r101));
    }

    @Override // com.bytedance.ee.bear.document.ssr.n.a
    public final void b(Throwable r100, OfflineDoc r101) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r101, "offlineDoc");
        tt5.a.f("SsrDataLoader", r100, false);
        com.bytedance.ee.util.ui.j.c(new f(r101));
    }

    @Override // com.bytedance.ee.bear.document.ssr.n.a
    public final void c(SimpleRequestResult r100, OfflineDoc r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "offlineDoc");
        com.bytedance.ee.util.ui.j.c(new e(r101));
    }
}
