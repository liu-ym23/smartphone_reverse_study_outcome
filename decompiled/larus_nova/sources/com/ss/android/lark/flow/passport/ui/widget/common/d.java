package com.ss.android.lark.flow.passport.ui.widget.common;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowBaseActivity f423840a;

    public d(FlowBaseActivity r100) {
        this.f423840a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlowBaseActivity r100 = this.f423840a;     // Catch: Throwable -> L4
        int r101 = FlowBaseActivity.f423826c;     // Catch: Throwable -> L4
        r100.showLoading();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
