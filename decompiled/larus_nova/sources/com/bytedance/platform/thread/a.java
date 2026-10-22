package com.bytedance.platform.thread;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f266626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f266627b;

    /* JADX INFO: renamed from: com.bytedance.platform.thread.a$a, reason: collision with other inner class name */
    public class C3728a extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ a f266628v;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        L19:
            return;
        L3:
            if (this.f266628v.f266626a != null) goto L14;
            super.run();     // Catch: Throwable -> L9
        L16:
            return;
        L14:
            super.run();     // Catch: Throwable -> L6
        L6:
            ((d.b) this.f266628v.f266626a).getClass();     // Catch: Throwable -> L9
            d.a r100 = d.f266632a;     // Catch: Throwable -> L9
            goto L16
        }

        public C3728a(a r100, Runnable r101, String r102) {
            this.f266628v = r100;
            super(r101, r102);
        }
    }

    public a(d.b r100) {
        this.f266626a = r100;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final synchronized Thread newThread(Runnable r100) {
        monitor-enter(this);
        C3728a r101 = new C3728a(this, r100, "platform-io-thread-" + this.f266627b);     // Catch: Throwable -> L7
        this.f266627b = this.f266627b + 1;     // Catch: Throwable -> L7
        monitor-exit(this);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }
}
