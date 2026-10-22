package com.unicom.online.account.kernel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes41.dex */
public class af {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static af f461961f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ConnectivityManager.NetworkCallback f461962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ConnectivityManager f461963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Timer f461964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Network f461965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<a> f461966e;

    public interface a {
        void a(boolean r100, Object r101);
    }

    private af() {
        this.f461965d = null;
        this.f461962a = null;
        this.f461963b = null;
        this.f461966e = new ArrayList();
        this.f461964c = null;
    }

    public static /* synthetic */ Network a(af r100) {
        return r100.f461965d;
    }

    public static /* synthetic */ Network a(af r100, Network r101) {
        r100.f461965d = r101;
        return r101;
    }

    public static af a() {
        if (f461961f != null) goto L15;
        monitor-enter(af.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f461961f != null) goto L9;
        f461961f = new af();     // Catch: Throwable -> L11
    L9:
        monitor-exit(af.class);     // Catch: Throwable -> L11
    L15:
        return f461961f;
    }

    private synchronized void a(a r100) {
        monitor-enter(this);
        this.f461966e.add(r100);     // Catch: Throwable -> L6 Exception -> L8
        monitor-exit(this);
        return;
    L8:
        e = move-exception;
        aj.a(e);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void a(af r100, boolean r101, Network r102) {
        r100.a(r101, r102);
    }

    public static /* synthetic */ ConnectivityManager b(af r100) {
        return r100.f461963b;
    }

    private synchronized void b(final Context r100, final a r101) {
        monitor-enter(this);
        Network r102 = this.f461965d;     // Catch: Throwable -> L18
        if (r102 == null) goto L8;
        r101.a(true, r102);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L8:
        a(r101);     // Catch: Throwable -> L18
        if (this.f461962a != null) goto L12;
    L15:
        ao r103 = new ao();     // Catch: Throwable -> L18
        ThreadMethodProxy.start(new PthreadThreadV2(new FutureTask(new AnonymousClass3(this, r100, r101), r103), "unt/kernel/af"));     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L12:
        if (this.f461966e.size() < 2) goto L15;
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final void a(Context r100, a r101) {
        b(r100, r101);
    }

    public final synchronized void a(boolean r100, Network r101) {
        monitor-enter(this);
        Timer r102 = this.f461964c;     // Catch: Throwable -> L13 Exception -> L15
        if (r102 == null) goto L6;
        r102.cancel();     // Catch: Throwable -> L13 Exception -> L15
        this.f461964c = null;     // Catch: Throwable -> L13 Exception -> L15
    L6:
        Iterator<a> r103 = this.f461966e.iterator();     // Catch: Throwable -> L13 Exception -> L15
    L8:
        if (r103.hasNext() == false) goto L10;
        r103.next().a(r100, r101);     // Catch: Throwable -> L13 Exception -> L15
        goto L8
    L10:
        this.f461966e.clear();     // Catch: Throwable -> L13 Exception -> L15
        monitor-exit(this);
        return;
    L15:
        e = move-exception;
        aj.a(e);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
        Timer r100 = this.f461964c;     // Catch: Throwable -> L14 Exception -> L16
        if (r100 == null) goto L6;
        r100.cancel();     // Catch: Throwable -> L14 Exception -> L16
        this.f461964c = null;     // Catch: Throwable -> L14 Exception -> L16
    L6:
        ConnectivityManager r101 = this.f461963b;     // Catch: Throwable -> L14 Exception -> L16
        if (r101 == null) goto L11;
        ConnectivityManager.NetworkCallback r102 = this.f461962a;     // Catch: Throwable -> L14 Exception -> L16
        if (r102 == null) goto L11;
        r101.unregisterNetworkCallback(r102);     // Catch: Throwable -> L14 Exception -> L16
    L11:
        this.f461963b = null;     // Catch: Throwable -> L14 Exception -> L16
        this.f461962a = null;     // Catch: Throwable -> L14 Exception -> L16
        this.f461965d = null;     // Catch: Throwable -> L14 Exception -> L16
        this.f461966e.clear();     // Catch: Throwable -> L14 Exception -> L16
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    L16:
        e = move-exception;
        aj.a(e);     // Catch: Throwable -> L14
    }
}
