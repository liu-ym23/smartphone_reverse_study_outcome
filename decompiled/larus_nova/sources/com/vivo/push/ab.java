package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes41.dex */
public abstract class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f462212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Handler f462213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f462214c;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ab f462215a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            this.f462215a.b(r100);
        }

        public a(ab r100, Looper r101) {
            this.f462215a = r100;
            super(r101);
        }
    }

    public abstract void b(Message r100);

    public ab() {
        this.f462214c = new Object();
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2(getClass().getSimpleName(), 1);
        ThreadMethodProxy.start(r100);
        this.f462213b = new a(this, r100.getLooper());
    }

    public final void a(Message r100) {
        Object r101 = this.f462214c;
        monitor-enter(r101);
        Handler r102 = this.f462213b;     // Catch: Throwable -> L10
        if (r102 != null) goto L7;
        String r103 = "Dead worker dropping a message: " + r100.what;     // Catch: Throwable -> L10
        com.vivo.push.util.t.e(getClass().getSimpleName(), r103 + " (Thread " + ThreadMethodProxy.currentThread().getId() + ")");     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L7:
        r102.sendMessage(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final void a(Context r100) {
        this.f462212a = r100;
    }
}
