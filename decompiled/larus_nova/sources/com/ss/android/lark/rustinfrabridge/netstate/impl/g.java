package com.ss.android.lark.rustinfrabridge.netstate.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.netstate.api.WSConnState$ConnState;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserNetStateService f439719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WSConnState$ConnState f439720b;

    public g(UserNetStateService r100, WSConnState$ConnState r101) {
        this.f439719a = r100;
        this.f439720b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f439719a.f439699b).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L22;
        ((h3c.a) r100.next()).a(this.f439720b);     // Catch: Throwable -> L7
        goto L4
    L22:
        return;
    L7:
        th = move-exception;
        Log.e("UserNetStateService", "Error when invoke WSChannel connection state listeners!", th);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
