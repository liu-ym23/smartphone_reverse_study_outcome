package com.vv;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f462963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VvPushAdapter.a.C5559a f462964b;

    @Override // java.lang.Runnable
    public final void run() {
        VvPushAdapter.sendToken(this.f462964b.f462932a.f462930b, this.f462963a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(VvPushAdapter.a.C5559a r100, String r101) {
        this.f462964b = r100;
        this.f462963a = r101;
    }
}
