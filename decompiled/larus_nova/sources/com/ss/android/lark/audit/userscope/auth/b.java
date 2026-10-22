package com.ss.android.lark.audit.userscope.auth;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuthDataServiceGlobalScope f409535a;

    public b(AuthDataServiceGlobalScope r100) {
        this.f409535a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AuthDataServiceGlobalScope r100 = this.f409535a;     // Catch: Throwable -> L7
        Iterator r101 = ((ConcurrentHashMap) r100.f409506h).keySet().iterator();     // Catch: Throwable -> L7
    L4:
        if (r101.hasNext() == false) goto L16;
        r100.d((String) r101.next());     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
