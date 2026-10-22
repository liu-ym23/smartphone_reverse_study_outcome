package com.bytedance.bdp.bdpbase.ipc;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MethodInvoker f201181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object[] f201182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f201183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f201184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f201185e;

    @Override // java.lang.Runnable
    public final void run() {
        this.f201181a.a(this.f201182b, this.f201183c, false, this.f201184d, this.f201185e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public n(MethodInvoker r100, Object[] r101, long r102, boolean r103, String r104) {
        this.f201181a = r100;
        this.f201182b = r101;
        this.f201183c = r102;
        this.f201184d = r103;
        this.f201185e = r104;
    }
}
