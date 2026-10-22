package com.ss.android.lark.flow.threadwindow.plugin;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowThreadWindowMsgTipsPlugin f424278a;

    public d(FlowThreadWindowMsgTipsPlugin r100) {
        this.f424278a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        wgb.b<y6b.c<?>> r100 = this.f424278a.f424254j;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.f(true);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
