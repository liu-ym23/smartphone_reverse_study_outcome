package com.larus.im.internal.network.link.impl.rtc;

import com.larus.im.internal.rtcsdk.impl.v;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f349228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f349229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f349230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentLinkedQueue<Runnable> f349231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f349232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f349233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f349234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f349235h;

    public final synchronized boolean b() {
        monitor-enter(this);
        boolean r100 = this.f349232e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final d getContext() {
        return this.f349228a;
    }

    public a(d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f349228a = r100;
        this.f349229b = "RTCLinkConnectManager";
        this.f349230c = "";
        this.f349231d = new ConcurrentLinkedQueue();
        this.f349233f = -1;
        v.f350031a.getClass();
        if (v.f350040j != 4) goto L5;
        boolean r101 = true;
    L6:
        this.f349235h = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void a(ff9.i.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        fe9.a.f476620a.e(this.f349229b, "[handleConnectionStateChanged] event:" + r100);
        int r101 = r100.f476704a;
        if (r101 != 3) goto L5;
        return;
    L5:
        if (r101 == 5) goto L9;
        f(false);
        return;
    }

    public final void c(ue9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (this.f349235h == false) goto L11;
        boolean r101 = r100 instanceof ue9.b.a;
        if (r101 == false) goto L7;
    L8:
        i(false);
        if (r101 == false) goto L11;
        Intrinsics.checkNotNullParameter("OTHER_EVENT_REQUEST_RETRIED_TOAST", "key");
        this.f349228a.f349297d.invoke("OTHER_EVENT_REQUEST_RETRIED_TOAST", null);
        goto L11
    L7:
        if ((r100 instanceof ue9.b.c) == true) goto L8;
    L11:
        this.f349228a.f349298e.invoke(r100);
    }

    public void d(ff9.i r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof ff9.i.b) == false) goto L7;
        a((ff9.i.b) r100);
        return;
    L7:
        if ((r100 instanceof ff9.i.g) == true) goto L9;
        return;
    L9:
        if (((ff9.i.g) r100).f476716a == false) goto L13;
        f(true);
        return;
    }

    public final synchronized void e(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "value");     // Catch: Throwable -> L7
        this.f349230c = r100;     // Catch: Throwable -> L7
        fe9.a.f476620a.e(this.f349229b, "[botUserId] update:" + r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void f(boolean r100) {
        monitor-enter(this);
        fe9.a r101 = fe9.a.f476620a;     // Catch: Throwable -> L13
        r101.e(this.f349229b, "[setClientReady]");     // Catch: Throwable -> L13
        h(r100);     // Catch: Throwable -> L13
        if (r100 == false) goto L11;
        ArrayList r102 = new ArrayList(this.f349231d);     // Catch: Throwable -> L13
        this.f349231d.clear();     // Catch: Throwable -> L13
        r101.e(this.f349229b, "[setClientReady] Has " + r102.size() + " pending task will be execute.");     // Catch: Throwable -> L13
        Iterator r103 = r102.iterator();     // Catch: Throwable -> L13
    L8:
        if (r103.hasNext() == false) goto L11;
        ((Runnable) r103.next()).run();     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void g(long r100) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r100 <= this.f349233f) goto L7;
    L10:
        this.f349233f = r100;     // Catch: Throwable -> L13
        fe9.a.f476620a.e(this.f349229b, "[connectReadyTime] update:" + r100);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L7:
        if (r100 < 0) goto L10;
        fe9.a.f476620a.e(this.f349229b, "[connectReadyTime] update failed, current:" + this.f349233f + ", expect:" + r100);     // Catch: Throwable -> L13
        goto L11
    }

    public final synchronized void h(boolean r100) {
        monitor-enter(this);
        this.f349232e = r100;     // Catch: Throwable -> L7
        fe9.a.f476620a.e(this.f349229b, "[connectReady] update:" + r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void i(boolean r100) {
        monitor-enter(this);
        this.f349235h = r100;     // Catch: Throwable -> L7
        fe9.a.f476620a.e(this.f349229b, "[reconnecting] update:" + r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
