package com.bytedance.ee.bear.document.ssr;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements n.a {
    public g() {
    }

    @Override // com.bytedance.ee.bear.document.ssr.n.a
    public final void a(SimpleRequestResult r2, OfflineDoc r3) {
        Intrinsics.checkNotNullParameter(r2, TipCallBackData.RESULT);
        Intrinsics.checkNotNullParameter(r3, "offlineDoc");
        com.bytedance.ee.util.ui.j.c(new d(r3));
    }

    @Override // com.bytedance.ee.bear.document.ssr.n.a
    public final void b(Throwable r3, OfflineDoc r4) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Intrinsics.checkNotNullParameter(r4, "offlineDoc");
        tt5.a.f("SsrDataLoader", r3, false);
        com.bytedance.ee.util.ui.j.c(new f(r4));
    }

    @Override // com.bytedance.ee.bear.document.ssr.n.a
    public final void c(SimpleRequestResult r2, OfflineDoc r3) {
        Intrinsics.checkNotNullParameter(r2, TipCallBackData.RESULT);
        Intrinsics.checkNotNullParameter(r3, "offlineDoc");
        com.bytedance.ee.util.ui.j.c(new e(r3));
    }
}
