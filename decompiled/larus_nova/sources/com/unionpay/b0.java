package com.unionpay;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes41.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f462155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f462156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f462157c;

    public b0(f r100, String r101, c r102) {
        this.f462155a = r100;
        this.f462156b = r101;
        this.f462157c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r100 = this.f462155a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.a(this.f462156b, this.f462157c);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
