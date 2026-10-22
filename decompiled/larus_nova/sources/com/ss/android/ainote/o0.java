package com.ss.android.ainote;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ainote.list.AINoteListView;

/* JADX INFO: loaded from: classes34.dex */
public final class o0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AINoteListView f407160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f407161b;

    public o0(AINoteListView r100, long r101) {
        this.f407160a = r100;
        this.f407161b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f407160a.J(this.f407161b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
