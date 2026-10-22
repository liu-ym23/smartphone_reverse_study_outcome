package com.bytedance.timonbase.utils;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f270911a;

    public c(d r100) {
        this.f270911a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f270911a.f270913b.invoke();     // Catch: Throwable -> L4
        d r100 = this.f270911a;     // Catch: Throwable -> L4
        ((Handler) r100.f270912a.getValue()).postDelayed(new c(r100), 60000);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
