package com.ss.android.ugc.aweme.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes40.dex */
public class ThreadPoolHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolInitConfig f454304a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IThreadPoolMonitor f454305b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile ExecutorService f454306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile int f454307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile int f454308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile int f454309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile ExecutorService f454310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile ExecutorService f454311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile ScheduledExecutorService f454312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile ExecutorService f454313j;

    public ThreadPoolHelper() {
    }

    static {
        f454304a = new ThreadPoolInitConfig(new ThreadPoolInitConfig.Builder(0));
        f454305b = new AnonymousClass1();
        f454307d = 30;
        f454308e = 30;
        f454309f = 15;
    }

    public static ExecutorService b() {
        if (f454311h != null) goto L15;
        monitor-enter(ThreadPoolHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f454311h != null) goto L9;
        f454311h = ThreadPoolProvider.Holder.f454339a.a(new ThreadPoolOptions(new ThreadPoolOptions.Builder(ThreadPoolType.BACKGROUND)));     // Catch: Throwable -> L11
    L9:
        monitor-exit(ThreadPoolHelper.class);     // Catch: Throwable -> L11
    L15:
        return f454311h;
    }

    public static ExecutorService c() {
        if (f454310g != null) goto L15;
        monitor-enter(ThreadPoolHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f454310g != null) goto L9;
        f454310g = ThreadPoolProvider.Holder.f454339a.a(new ThreadPoolOptions(new ThreadPoolOptions.Builder(ThreadPoolType.DEFAULT)));     // Catch: Throwable -> L11
    L9:
        monitor-exit(ThreadPoolHelper.class);     // Catch: Throwable -> L11
    L15:
        return f454310g;
    }

    public static ExecutorService d() {
        if (f454306c != null) goto L15;
        monitor-enter(ThreadPoolHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f454306c != null) goto L9;
        ThreadPoolProvider r100 = ThreadPoolProvider.Holder.f454339a;     // Catch: Throwable -> L11
        ThreadPoolOptions.Builder r101 = new ThreadPoolOptions.Builder(ThreadPoolType.IO);     // Catch: Throwable -> L11
        r101.f454337g = 128;     // Catch: Throwable -> L11
        f454306c = r100.a(new ThreadPoolOptions(r101));     // Catch: Throwable -> L11
    L9:
        monitor-exit(ThreadPoolHelper.class);     // Catch: Throwable -> L11
    L15:
        return f454306c;
    }

    public static ScheduledExecutorService e() {
        if (f454312i != null) goto L15;
        monitor-enter(ThreadPoolHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f454312i != null) goto L9;
        ThreadPoolProvider r100 = ThreadPoolProvider.Holder.f454339a;     // Catch: Throwable -> L11
        ThreadPoolOptions.Builder r101 = new ThreadPoolOptions.Builder(ThreadPoolType.SCHEDULED);     // Catch: Throwable -> L11
        r101.f454333c = 1;     // Catch: Throwable -> L11
        f454312i = (ScheduledExecutorService) r100.a(new ThreadPoolOptions(r101));     // Catch: Throwable -> L11
    L9:
        monitor-exit(ThreadPoolHelper.class);     // Catch: Throwable -> L11
    L15:
        return f454312i;
    }

    public static ExecutorService f() {
        if (f454313j != null) goto L15;
        monitor-enter(ThreadPoolHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f454313j != null) goto L9;
        f454313j = ThreadPoolProvider.Holder.f454339a.a(new ThreadPoolOptions(new ThreadPoolOptions.Builder(ThreadPoolType.SERIAL)));     // Catch: Throwable -> L11
    L9:
        monitor-exit(ThreadPoolHelper.class);     // Catch: Throwable -> L11
    L15:
        return f454313j;
    }

    public static ExecutorService a(ThreadPoolOptions r100) {
        ThreadPoolType r101 = r100.f454324a;
        if (r101 == ThreadPoolType.IO) goto L11;
        if (r101 == ThreadPoolType.DEFAULT) goto L11;
        if (r101 == ThreadPoolType.BACKGROUND) goto L11;
        return ThreadPoolProvider.Holder.f454339a.a(r100);
    L11:
        throw new IllegalArgumentException();
    }

    public static boolean g(ExecutorService r100) {
        if (f454306c == null) goto L7;
        if (r100 != d()) goto L7;
    L22:
        return true;
    L7:
        if (f454310g == null) goto L11;
        if (r100 == c()) goto L22;
    L11:
        if (f454311h == null) goto L15;
        if (r100 == b()) goto L22;
    L15:
        if (f454312i == null) goto L19;
        if (r100 == e()) goto L22;
    L19:
        if (f454313j != null) goto L21;
    L23:
        return false;
    L21:
        if (r100 != f()) goto L23;
        goto L22
    }
}
