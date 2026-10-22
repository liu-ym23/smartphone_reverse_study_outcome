package com.ss.android.lark.contact.base.service;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.contact.base.entity.ExternalContact;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.contact.base.entity.a f418932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f418933b;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f418933b.f418935b).iterator();     // Catch: Throwable -> L9
    L4:
        if (r100.hasNext() == false) goto L21;
        q.b r101 = (q.b) r100.next();     // Catch: Throwable -> L9
        r101.a();     // Catch: Throwable -> L9
        if ((r101 instanceof q.c) == false) goto L4;
        ((q.c) r101).b(this.f418932a);     // Catch: Throwable -> L9
        goto L4
    L21:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }

    public p(q r100, ExternalContact r101, com.ss.android.lark.contact.base.entity.a r102) {
        this.f418933b = r100;
        this.f418932a = r102;
    }
}
