package com.bytedance.android.window.shop.search.presenter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements Runnable {
    public final /* synthetic */ WindowSearchResultProductListPresenter.c a;

    public l(WindowSearchResultProductListPresenter.c r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (WindowSearchResultProductListPresenter.e0(this.a.b).isPlayingVideo() == true) goto L9;
        WindowSearchResultProductListPresenter.d0(this.a.b);     // Catch: Throwable -> L6
        return;
    }
}
