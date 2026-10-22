package com.bytedance.ee.bear.document.ssr;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfflineDoc f221869a;

    public f(OfflineDoc r100) {
        this.f221869a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final OfflineDoc r100 = this.f221869a;     // Catch: Throwable -> L4
        ArrayList<a.InterfaceC3162a> r101 = a.f221860a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r100, "offlineDoc");     // Catch: Throwable -> L4
        CollectionsKt.removeAll(a.f221860a, new HtmlCacheRequestManager$notifyOnThrowable$1(r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
