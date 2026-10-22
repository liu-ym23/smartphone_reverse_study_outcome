package com.larus.platform.exp;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;

/* JADX INFO: loaded from: classes31.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f365393a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f365394b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f365395c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f365396d = null;

    public q() {
    }

    static {
        f365393a = new q();
        f365394b = new AtomicBoolean(false);
        f365395c = new AtomicBoolean(false);
        f365396d = new AtomicInteger(0);
    }

    public final void a() {
        AtomicBoolean r100 = f365394b;
        if (r100.get() == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (r100.get() == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        AtomicBoolean r101 = f365395c;     // Catch: Throwable -> L13
        LarkSocialExp r102 = LarkSocialExp.f365340a;     // Catch: Throwable -> L13
        r101.set(r102.c());     // Catch: Throwable -> L13
        AtomicInteger r103 = f365396d;     // Catch: Throwable -> L13
        r103.set(r102.m());     // Catch: Throwable -> L13
        r100.set(true);     // Catch: Throwable -> L13
        FLogger.f375446a.i("LarkSocialExpLaunch", "isSocialEnabled=" + r101 + " socialPerformanceExp=" + r103);     // Catch: Throwable -> L13
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public final boolean b() {
        a();
        return f365395c.get();
    }
}
