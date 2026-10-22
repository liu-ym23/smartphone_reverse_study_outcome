package com.bytedance.badger.utils;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.badger.BadgerCore;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes47.dex */
public final class x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f199298d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f199299e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f199300f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f199301g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f199302h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f199303i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f199304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f199305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f199306c;

    static {
        BadgerCore.Companion.getClass();
        f199298d = com.bytedance.badger.j.b(1950707304799506855L);
        f199299e = com.bytedance.badger.j.b(2808155107469694167L);
        f199300f = com.bytedance.badger.j.b(4654826111501568837L);
        f199301g = com.bytedance.badger.j.b(1601638077316868688L);
        f199302h = com.bytedance.badger.j.b(3359762759185814791L);
        f199303i = com.bytedance.badger.j.b(422619849029467889L);
    }

    public x(Context r100, Handler r101) {
        this.f199304a = r100;
        this.f199305b = r101;
        this.f199306c = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("adger/utils/m"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.bytedance.badger.utils.q, java.lang.Runnable] */
    public final void b(final com.bytedance.badger.z.g0 r110) {
        final AtomicBoolean r100 = new AtomicBoolean(false);
        com.bytedance.badger.e.f("OppoIDHelper", "fetch# start thread=" + ThreadMethodProxy.currentThread().getName());
        final ?? r101 = new q(this, r100, r110);
        final j r102 = new j(this, this.f199305b, r100, r101, r110);
        this.f199305b.postDelayed(r101, 15000);
        this.f199306c.execute(new u(this, r102, r100, r110, r101));
    }

    public final void c(AtomicBoolean r100, final o r101, final p r102, Runnable r103) {
        if (r100.compareAndSet(false, true) == true) goto L6;
        com.bytedance.badger.e.g("OppoIDHelper", "postError# ignored (already completed), code=" + r102.f199274a);
        return;
    L6:
        if (r103 == null) goto L8;
        this.f199305b.removeCallbacks(r103);
    L8:
        this.f199305b.post(new v(r101, r102));
    }

    public final void d() {
        this.f199306c.shutdownNow();
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static void a(IBinder r110, Parcel r111, Parcel r112) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        r110.transact(1, r111, r112, 0);
        return;
    L6:
        long r100 = SystemClock.uptimeMillis();
        r110.transact(1, r111, r112, 0);     // Catch: Throwable -> L12
        long r101 = SystemClock.uptimeMillis() - r100;
        if (r101 < 100) goto L19;
        BinderPerformanceReporter.report(r101, r110.getClass().getName(), 1, 0, new Throwable("Slow main-thread Binder transaction"));
        return;
    L19:
        return;
    L12:
        th = move-exception;
        long r102 = SystemClock.uptimeMillis() - r100;
        if (r102 < 100) goto L16;
        BinderPerformanceReporter.report(r102, r110.getClass().getName(), 1, 0, new Throwable("Slow main-thread Binder transaction"));
    L16:
        throw th;
    }
}
