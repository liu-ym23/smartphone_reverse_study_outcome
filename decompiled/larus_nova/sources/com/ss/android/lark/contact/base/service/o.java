package com.ss.android.lark.contact.base.service;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f418930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f418931b;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f418931b.f418934a).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((f9b.a) r100.next()).a(this.f418930a);     // Catch: Throwable -> L7
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

    public o(q r100, List r101) {
        this.f418931b = r100;
        this.f418930a = r101;
    }
}
