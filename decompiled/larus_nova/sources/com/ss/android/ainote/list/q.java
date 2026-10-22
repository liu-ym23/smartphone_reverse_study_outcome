package com.ss.android.ainote.list;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AINoteListView f407099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f407100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f407101c;

    public q(AINoteListView r100, long r101, String r102) {
        this.f407099a = r100;
        this.f407100b = r101;
        this.f407101c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AINoteListView r100 = this.f407099a;     // Catch: Throwable -> L4
        long r101 = this.f407100b;     // Catch: Throwable -> L4
        AINoteListView.c(r100, r101, this.f407101c, AINoteListView.a(r100, r101));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
