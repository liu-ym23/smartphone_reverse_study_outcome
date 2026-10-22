package com.ss.android.lark.conditional.access.nopermission.manager;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f418168a = null;

    static {
        f418168a = new b();
    }

    public b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        SecurityPolicyDialogActionManager.f418129a.getClass();     // Catch: Throwable -> L4
        SecurityPolicyDialogActionManager.b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
