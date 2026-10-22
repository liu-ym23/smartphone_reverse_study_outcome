package com.ss.android.lark.forwardv3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f425388a = null;

    static {
        f425388a = new h();
    }

    public h() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        i08.a.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
