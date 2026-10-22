package com.bytedance.bdp.appbase.base.bdptask;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f200506a = null;

    public class a extends b {
        public a() {
        }

        @Override // com.bytedance.bdp.appbase.base.bdptask.h.b
        public final void c(b.a r100) {
            new BdpTask.Builder().priority(1).onIO().nonCancel().runnable(r100).start();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f200507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedTransferQueue<Runnable> f200508b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f200509a;

            @Override // java.lang.Runnable
            public final void run() {
            L18:
                b r100 = this.f200509a;     // Catch: Throwable -> L7 InterruptedException -> L17
                Runnable r101 = r100.f200508b.poll(r100.a(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L7 InterruptedException -> L17
                if (r101 == null) goto L10;
                r101.run();     // Catch: Throwable -> L7 InterruptedException -> L17
            L12:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L16;
                return;
            L16:
                throw th;
            L7:
                th = move-exception;
                this.f200509a.f200507a = false;     // Catch: Throwable -> L12
                throw th;     // Catch: Throwable -> L12
            L10:
                this.f200509a.f200507a = false;     // Catch: Throwable -> L12
            }

            public a(b r100) {
                this.f200509a = r100;
            }
        }

        public long a() {
            return 100;
        }

        public void c(a r100) {
            throw null;
        }

        public b() {
            this.f200507a = false;
            this.f200508b = new LinkedTransferQueue();
        }

        public final void b(Runnable r100) {
            this.f200508b.offer(r100);
            if (this.f200507a == false) goto L5;
            return;
        L5:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L7:
            if (this.f200507a == false) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L10:
            this.f200507a = true;     // Catch: Throwable -> L13
            c(new a(this));     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
        }
    }

    static {
        f200506a = new a();
    }
}
