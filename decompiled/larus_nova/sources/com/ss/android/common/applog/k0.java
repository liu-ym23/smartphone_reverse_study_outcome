package com.ss.android.common.applog;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes5.dex */
public final class k0 extends PthreadHandlerThreadV2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile k0 f408175g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f408176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f408177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f408178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedList<Runnable> f408179f;

    public k0() {
        super("TeaThread");
        this.f408177d = new Object();
        this.f408178e = false;
        this.f408179f = new LinkedList();
    }

    public static k0 d() {
        if (f408175g != null) goto L15;
        monitor-enter(k0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f408175g != null) goto L9;
        f408175g = new k0();     // Catch: Throwable -> L11
        ThreadMethodProxy.start(f408175g);     // Catch: Throwable -> L11
    L9:
        monitor-exit(k0.class);     // Catch: Throwable -> L11
    L15:
        return f408175g;
    }

    public final Handler e() {
        if (this.f408176c != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f408176c != null) goto L8;
        this.f408176c = new Handler(getLooper());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f408176c;
    }

    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        super.onLooperPrepared();
        Object r100 = this.f408177d;
        monitor-enter(r100);
        this.f408178e = true;     // Catch: Throwable -> L15
        ArrayList r101 = new ArrayList(this.f408179f);     // Catch: Throwable -> L15
        this.f408179f.clear();     // Catch: Throwable -> L15
        if (r101.isEmpty() == true) goto L13;
        Iterator r102 = r101.iterator();     // Catch: Throwable -> L15
    L9:
        if (r102.hasNext() == false) goto L13;
        Runnable r103 = (Runnable) r102.next();     // Catch: Throwable -> L15
        if (r103 == null) goto L9;
        e().post(r103);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final void b(Runnable r100) {
        if (this.f408178e == false) goto L5;
        e().postDelayed(r100, 0);
        return;
    L5:
        Object r101 = this.f408177d;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (this.f408178e == false) goto L11;
        e().postDelayed(r100, 0);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L11:
        if (this.f408179f.size() <= 1000) goto L13;
        this.f408179f.poll();     // Catch: Throwable -> L16
    L13:
        this.f408179f.add(r100);     // Catch: Throwable -> L16
        goto L14
    }
}
