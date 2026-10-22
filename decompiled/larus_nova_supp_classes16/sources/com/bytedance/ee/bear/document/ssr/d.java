package com.bytedance.ee.bear.document.ssr;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements Runnable {
    public final /* synthetic */ OfflineDoc a;

    public d(OfflineDoc r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final OfflineDoc r0 = this.a;     // Catch: Throwable -> L4
        ArrayList<a.InterfaceC0106a> r1 = a.a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r0, "offlineDoc");     // Catch: Throwable -> L4
        CollectionsKt.removeAll(a.a, new HtmlCacheRequestManager$notifyOnFail$1(r0));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
