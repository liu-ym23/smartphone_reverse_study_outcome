package com.bytedance.android.shopping.store.tabkit;

import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements Runnable {
    public final /* synthetic */ TabKitHybridTabFragment.AnonymousClass5 a;

    public j(TabKitHybridTabFragment.AnonymousClass5 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView r0 = TabKitHybridTabFragment.access$getWebView$p(this.a.a);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.setVisibility(0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
