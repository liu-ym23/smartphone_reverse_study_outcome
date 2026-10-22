package com.ss.android.ainote.list;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AINoteListView f407106a;

    public s(AINoteListView r100) {
        this.f407106a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AINoteListView r100 = this.f407106a;     // Catch: Throwable -> L8
        if (r100.f406973k == null) goto L5;
        return;
    L5:
        if (r100.u() == true) goto L15;
        this.f407106a.w();     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
