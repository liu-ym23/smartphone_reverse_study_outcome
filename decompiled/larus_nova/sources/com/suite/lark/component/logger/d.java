package com.suite.lark.component.logger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.suite.component.logger.Log;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class d implements com.suite.component.logger.api.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f460152a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f460153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Handler f460154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LinkedList<com.suite.component.logger.c> f460155d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicLong f460156e = null;

    public static final class a extends PthreadHandlerThreadV2 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<Looper, Unit> f460157c;

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            this.f460157c.invoke(getLooper());
        }

        public a(Function1 r100) {
            Intrinsics.checkNotNullParameter("logger-handler", "name");
            Intrinsics.checkNotNullParameter(r100, "onPrepared");
            super("logger-handler");
            this.f460157c = r100;
        }
    }

    public d() {
    }

    static {
        f460152a = new d();
        f460155d = new LinkedList();
        f460156e = new AtomicLong();
    }

    @Override // com.suite.component.logger.api.c
    public final void b() {
        if (f460153b == false) goto L6;
        return;
    L6:
        if (f460153b == true) goto L10;
        f460153b = true;
        ThreadMethodProxy.start(new a(LogHandlerThreadExecutor$makeSureRunning$1.INSTANCE));
        return;
    }

    @Override // com.suite.component.logger.api.c
    public final boolean isRunning() {
        return f460153b;
    }

    @Override // com.suite.component.logger.api.c
    public final void a(com.suite.component.logger.c r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        if (f460153b == true) goto L6;
        f460153b = true;
        ThreadMethodProxy.start(new a(LogHandlerThreadExecutor$makeSureRunning$1.INSTANCE));
    L6:
        AtomicLong r101 = f460156e;
        r101.incrementAndGet();
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L19;
        Handler r102 = f460154c;
        if (r102 == null) goto L11;
        Message r103 = Message.obtain();
        r103.what = 1;
        r103.obj = r100;
        r102.sendMessage(r103);
        return;
    L11:
        LinkedList<com.suite.component.logger.c> r104 = f460155d;
        monitor-enter(r104);
        r104.add(r100);     // Catch: Throwable -> L16
        monitor-exit(r104);
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        long r105 = r101.decrementAndGet();
        if (r105 <= 2000) goto L28;
        com.suite.lark.component.logger.dynamic.a r106 = Log.f460091e;
        if (r106 == null) goto L29;
        r106.e(r100, r105);
        return;
    L29:
        return;
    }
}
