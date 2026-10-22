package com.ss.android.lark.todo.impl.features.center.v3.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f442012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f442013b;

    public c0(a0 r100, int r101) {
        this.f442012a = r100;
        this.f442013b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a0 r100 = this.f442012a;     // Catch: Throwable -> L6
        if (r100.f441992d == false) goto L9;
        r100.b(this.f442013b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
