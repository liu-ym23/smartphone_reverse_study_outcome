package com.bytedance.push;

import android.app.Application;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f267088a;

    @Override // java.lang.Runnable
    public final void run() {
        t r100 = this.f267088a;     // Catch: Throwable -> L4
        Application r101 = c.O.f266761a;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        t.e(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public v(t r100) {
        this.f267088a = r100;
    }
}
