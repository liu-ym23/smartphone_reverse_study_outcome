package com.ss.android.lark.flow.threadwindow;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowThreadWindowMediaRootStateHandler f424239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f424240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ErrorResult f424241c;

    public k(FlowThreadWindowMediaRootStateHandler r100, String r101, ErrorResult r102) {
        this.f424239a = r100;
        this.f424240b = r101;
        this.f424241c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlowThreadWindowMediaRootStateHandler.a(this.f424239a, this.f424240b, this.f424241c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
