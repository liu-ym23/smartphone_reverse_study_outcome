package com.bytedance.android.shopping.deepfeed.slice.view.list;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ DeepFeedSlcList a;
    public final /* synthetic */ Map b;

    public b(DeepFeedSlcList r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeepFeedSlcList r0 = this.a;     // Catch: Throwable -> L6
        int r1 = DeepFeedSlcList.p;     // Catch: Throwable -> L6
        com.bytedance.android.shopping.deepfeed.slice.service.b r2 = r0.w();     // Catch: Throwable -> L6
        if (r2 == null) goto L9;
        r2.M(this.b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
