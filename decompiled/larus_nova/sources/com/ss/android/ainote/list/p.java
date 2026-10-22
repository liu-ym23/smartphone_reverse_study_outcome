package com.ss.android.ainote.list;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AINoteListView f407097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ xra.a f407098b;

    public p(AINoteListView r100, xra.a r101) {
        this.f407097a = r100;
        this.f407098b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AINoteListView.r(this.f407097a, this.f407098b.f564896a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
