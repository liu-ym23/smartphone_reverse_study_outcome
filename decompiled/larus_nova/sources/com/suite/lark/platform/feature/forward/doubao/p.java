package com.suite.lark.platform.feature.forward.doubao;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubaoForwardFragment f461363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f461364b;

    public p(DoubaoForwardFragment r100, View r101) {
        this.f461363a = r100;
        this.f461364b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DoubaoForwardFragment.S90(this.f461363a, this.f461364b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
