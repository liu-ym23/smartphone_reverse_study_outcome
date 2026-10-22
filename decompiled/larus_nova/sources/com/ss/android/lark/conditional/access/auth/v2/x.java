package com.ss.android.lark.conditional.access.auth.v2;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SenderTenantMap f417931a;

    public x(SenderTenantMap r100) {
        this.f417931a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.ss.android.lark.storage.kv.repo.a r100 = y.f417932a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.putJSONObject("SenderTenantIdMap", this.f417931a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
