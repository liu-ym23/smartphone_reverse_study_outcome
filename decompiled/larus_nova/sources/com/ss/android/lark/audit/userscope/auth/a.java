package com.ss.android.lark.audit.userscope.auth;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuthDataServiceGlobalScope f409533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f409534b;

    public a(AuthDataServiceGlobalScope r100, String r101) {
        this.f409533a = r100;
        this.f409534b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f409533a.d(this.f409534b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
