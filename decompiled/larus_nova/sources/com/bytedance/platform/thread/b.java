package com.bytedance.platform.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.HashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, HandlerThread> f266629a = null;

    public static class a extends PthreadHandlerThreadV2 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f266630c;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2, com.ss.android.ugc.bytex.pthread.base.convergence.hook.HandlerThreadProxyWrapper, java.lang.Thread
        public final synchronized void start() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.f266630c == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f266630c = true;     // Catch: Throwable -> L11
            super.start();     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        public a() {
            super("pool-monitor", 0);
            this.f266630c = false;
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        f266629a = new HashMap();
    }
}
