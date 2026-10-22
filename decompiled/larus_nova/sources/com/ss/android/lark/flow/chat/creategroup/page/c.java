package com.ss.android.lark.flow.chat.creategroup.page;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowGroupCreateActivity f422098a;

    public c(FlowGroupCreateActivity r100) {
        this.f422098a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlowGroupCreateActivity r100 = this.f422098a;     // Catch: Throwable -> L4
        int r101 = FlowGroupCreateActivity.f422065l;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        this.f422098a.A1(0.0f, 1.0f, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
