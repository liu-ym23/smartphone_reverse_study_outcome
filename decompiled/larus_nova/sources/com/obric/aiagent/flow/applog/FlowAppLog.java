package com.obric.aiagent.flow.applog;

import android.os.Handler;
import com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class FlowAppLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowAppLog f384652a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static IFlowAppLogIDL f384653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f384654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f384655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f384656e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Handler f384657f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q9a.a f384658g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a<String> f384659h = null;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f384660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<T> f384661b;

        public a(int r100) {
            this.f384660a = r100;
            this.f384661b = Collections.synchronizedList(new ArrayList());
        }

        public final void a(T r100) {
            List<T> r101 = this.f384661b;
            monitor-enter(r101);
            this.f384661b.add(r100);     // Catch: Throwable -> L11
        L6:
            if (this.f384661b.size() <= this.f384660a) goto L8;
            CollectionsKt.removeFirst(this.f384661b);     // Catch: Throwable -> L11
            goto L6
        L8:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r101);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    public FlowAppLog() {
    }

    public static void b() {
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [q9a.a] */
    static {
        f384652a = new FlowAppLog();
        f384656e = -1;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("FlowAppLog");
        ThreadMethodProxy.start(r100);
        f384657f = new Handler(r100.getLooper());
        f384658g = new q9a.a();
        new a(10);
        new a(100);
        f384659h = new a(5000);
        new a(5000);
        new a(5000);
        new a(100);
        new FlowAppLog$dataObserver$1();
    }

    public static void c() {
        if (f384654c == false) goto L5;
    L9:
        ILogDepend.f384986a.i("FlowAppLog", "has binded or binding, skip executeBind, onBindSuccess: " + f384654c + ", isBinding: " + f384655d);
        return;
    L5:
        if (f384655d == true) goto L9;
        ILogDepend.f384986a.i("FlowAppLog", "context is null, skip executeBind");
    }

    public static void d() {
        if (f384654c == true) goto L5;
        return;
    L5:
        a("safeUnbind");
        f384653b = null;
        f384654c = false;
        f384655d = false;
        b();
    }

    public static void a(String r100) {
        f384657f.removeCallbacks(f384658g);
        ILogDepend.f384986a.i("FlowAppLog", "cancelAutoUnbindLocked, reason: " + r100);
    }

    public static void e(String r100) {
        long r101 = f384656e;
        a("reschedule: ".concat(r100));
        if (r101 > 0) goto L5;
        return;
    L5:
        if (f384654c == false) goto L10;
        f384657f.postDelayed(f384658g, r101);
        ILogDepend.f384986a.i("FlowAppLog", "scheduleAutoUnbindLocked, delayMs: " + r101 + ", reason: " + r100);
        return;
    }

    public final void onEventV3(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        monitor-enter(this);
    L16:
        e = move-exception;
        ILogDepend.f384986a.e("FlowAppLog", "onEventV3 error", e);     // Catch: Throwable -> L14
    L21:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L5:
        if (f384654c == false) goto L18;
        IFlowAppLogIDL r102 = f384653b;     // Catch: Throwable -> L14 Exception -> L16
        if (r102 == null) goto L18;
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L14 Exception -> L16
        if (r102.asBinder().isBinderAlive() == false) goto L18;
        IFlowAppLogIDL r103 = f384653b;     // Catch: Throwable -> L14 Exception -> L16
        if (r103 == null) goto L13;
        r103.onEventV3(r100);     // Catch: Throwable -> L14 Exception -> L16
    L13:
        f384652a.getClass();     // Catch: Throwable -> L14 Exception -> L16
        e("onEventV3");     // Catch: Throwable -> L14 Exception -> L16
    L18:
        f384659h.a(r100);     // Catch: Throwable -> L14 Exception -> L16
        f384652a.getClass();     // Catch: Throwable -> L14 Exception -> L16
        c();     // Catch: Throwable -> L14 Exception -> L16
    L14:
        th = move-exception;
        throw th;
    }
}
