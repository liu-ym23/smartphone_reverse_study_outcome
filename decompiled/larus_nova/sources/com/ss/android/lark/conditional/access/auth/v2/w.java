package com.ss.android.lark.conditional.access.auth.v2;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.conditional.access.auth.v2.service.SecurityLabelConfig;

/* JADX INFO: loaded from: classes35.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SecurityLabelConfig f417930a;

    public w(SecurityLabelConfig r100) {
        this.f417930a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.ss.android.lark.storage.kv.repo.a r100 = y.f417932a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.putJSONObject("FileAuthSecurityLabelConfig", this.f417930a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
