package com.ss.android.lark.conditional.access.auth.v2;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f417844a;

    public s(String r100) {
        this.f417844a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.ss.android.lark.storage.kv.repo.a r100 = y.f417933b;     // Catch: Throwable -> L10
        if (r100 == null) goto L13;
        String r101 = this.f417844a;     // Catch: Throwable -> L10
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440410b == false) goto L17;
        d r102 = (d) r100.getJSONObject(r101, d.class);     // Catch: Throwable -> L10
        if (r102 == null) goto L18;
        r102.h(Long.valueOf(System.currentTimeMillis() - 1));     // Catch: Throwable -> L10
        r100.putJSONObject(r101, r102);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
