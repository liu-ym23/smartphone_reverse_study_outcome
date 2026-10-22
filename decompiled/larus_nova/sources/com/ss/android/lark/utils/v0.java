package com.ss.android.lark.utils;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class v0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0.c f444784a;

    @Override // java.lang.Runnable
    public final void run() {
        s0.c r100 = this.f444784a;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        ViewUtils.runOnUiThread(new w0(r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public v0(s0.c r100) {
        this.f444784a = r100;
    }
}
