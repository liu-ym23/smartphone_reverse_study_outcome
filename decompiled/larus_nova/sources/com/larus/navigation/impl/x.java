package com.larus.navigation.impl;

import android.os.Handler;
import android.os.Looper;
import com.larus.navigation.impl.baidu.notification.BaiduNaviNotificationManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f359968a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f359969b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f359970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile long f359971d;

    public x() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        Handler r100 = f359969b;     // Catch: Throwable -> L6
        r100.removeCallbacksAndMessages(null);     // Catch: Throwable -> L6
        f359971d++;     // Catch: Throwable -> L6
        final long r101 = f359971d;     // Catch: Throwable -> L6
        f359970c = true;     // Catch: Throwable -> L6
        final com.larus.navigation.impl.baidu.notification.i r102 = BaiduNaviNotificationManager.f359788a.a();     // Catch: Throwable -> L6
        com.larus.navigation.api.c.d("kmp_event", "quick-restart notification retention armed");     // Catch: Throwable -> L6
        r100.postDelayed(new w(r101, r102), 5000);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
        f359971d++;     // Catch: Throwable -> L6
        f359970c = false;     // Catch: Throwable -> L6
        f359969b.removeCallbacksAndMessages(null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        f359968a = new x();
        f359969b = new Handler(Looper.getMainLooper());
    }

    public final synchronized void c(boolean r100) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (f359970c == true) goto L8;
        if (r100 == true) goto L8;
        boolean r101 = false;
    L9:
        f359970c = r101;     // Catch: Throwable -> L16
        if (f359970c == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        f359971d++;     // Catch: Throwable -> L16
        f359969b.removeCallbacksAndMessages(null);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L8:
        r101 = true;
        goto L9
    }

    public final synchronized void d(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "reason");     // Catch: Throwable -> L11
        if (f359970c == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        b();     // Catch: Throwable -> L11
        int r101 = com.larus.navigation.api.c.f359656a;     // Catch: Throwable -> L11
        com.larus.navigation.api.c.d("kmp_event", "quick-restart notification retention released (" + r100 + ')');     // Catch: Throwable -> L11
        BaiduNaviNotificationManager.f359788a.f();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
