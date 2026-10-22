package com.larksuite.common_selection;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes24.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f282905a;

    public m(i r100) {
        this.f282905a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f282905a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
