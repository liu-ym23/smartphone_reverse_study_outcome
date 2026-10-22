package com.ss.android.lark.rustinfrabridge.netstate.impl;

import com.bytedance.lark.pb.basic.v1.GetWebSocketStatusResponse;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.netstate.api.WSConnState$ConnState;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GetWebSocketStatusResponse.Status f439711a;

    public final void a() {
        int r100 = d.a.f439715a[this.f439711a.ordinal()];     // Catch: Throwable -> L17
        if (r100 != 1) goto L5;
        WSConnState$ConnState r101 = WSConnState$ConnState.ConnectClosed;     // Catch: Throwable -> L17
    L12:
        Iterator r102 = ((CopyOnWriteArrayList) d.f439712a).iterator();     // Catch: Throwable -> L17
    L13:
        if (r102.hasNext() == false) goto L23;
        ((h3c.a) r102.next()).a(r101);     // Catch: Throwable -> L17
        goto L13
    L23:
        return;
    L5:
        if (r100 != 2) goto L7;
        r101 = WSConnState$ConnState.Connecting;     // Catch: Throwable -> L17
        goto L12
    L7:
        if (r100 == 3) goto L9;
        r101 = WSConnState$ConnState.ConnectUnknown;     // Catch: Throwable -> L17
        goto L12
    L9:
        r101 = WSConnState$ConnState.Connected;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Log.e("WschannelService", "Error when invoke WSChannel connection state listeners!", th);
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

    public c(GetWebSocketStatusResponse.Status r100) {
        this.f439711a = r100;
    }
}
