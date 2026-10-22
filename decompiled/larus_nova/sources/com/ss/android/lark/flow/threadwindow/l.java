package com.ss.android.lark.flow.threadwindow;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowThreadWindowMediaRootStateHandler f424242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Message f424243b;

    public l(FlowThreadWindowMediaRootStateHandler r100, Message r101) {
        this.f424242a = r100;
        this.f424243b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlowThreadWindowMediaRootStateHandler.b(this.f424242a, this.f424243b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
