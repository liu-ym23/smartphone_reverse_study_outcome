package com.bytedance.bdinstall;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class q0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f199775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p0 f199776b;

    public final void a() {
        if (this.f199776b.f199761e.get() == false) goto L5;
        this.f199776b.f199758b.d(this.f199775a, true, false);
        return;
    L5:
        t.a("not start yet,start it " + this.f199775a);
        this.f199776b.f199758b.c(this.f199775a, false);
        p0.o(this.f199776b, true);
        this.f199776b.q();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public q0(p0 r100, u r101) {
        this.f199776b = r100;
        this.f199775a = r101;
    }
}
