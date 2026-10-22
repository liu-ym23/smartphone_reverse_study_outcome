package com.bytedance.android.shopping.feed.fragment;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        int r0 = cf.e.a;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(ProductFeedContentFragment r1, VideoProductFeedFragment r2) {
    }
}
