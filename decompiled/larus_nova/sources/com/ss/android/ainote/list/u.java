package com.ss.android.ainote.list;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AINoteListView f407110a;

    public u(AINoteListView r100) {
        this.f407110a = r100;
    }

    public final void a() {
        this.f407110a.H0 = null;
        int r100 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "image preview return timeout, noteId=" + this.f407110a.f406980p0 + ", active=" + this.f407110a.f406969h + ", focused=" + this.f407110a.f406973k + ", state=" + this.f407110a.f406972j);
        this.f407110a.k("timeout");
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
