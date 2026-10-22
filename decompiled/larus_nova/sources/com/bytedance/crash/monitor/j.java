package com.bytedance.crash.monitor;

import android.content.Context;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.d0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.bytedance.crash.monitor.a f203315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static fh4.f f203316b;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f203317a;

        @Override // java.lang.Runnable
        public final void run() {
            new e(this.f203317a).c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(f r100) {
            this.f203317a = r100;
        }
    }

    public j() {
    }

    public static fh4.f c() {
        if (f203316b != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f203316b != null) goto L9;
        f203316b = new fh4.f(f203315a);     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f203316b;
    }

    public static com.bytedance.crash.monitor.a b(Context r100, ICommonParams r101) {
        com.bytedance.crash.i.g(r100);
        monitor-enter(com.bytedance.crash.monitor.a.class);
        com.bytedance.crash.monitor.a r102 = f203315a;     // Catch: Throwable -> L15
        if (r102 == null) goto L8;
        monitor-exit(com.bytedance.crash.monitor.a.class);     // Catch: Throwable -> L15
        return r102;
    L8:
        g r103 = new g(r101);     // Catch: Throwable -> L15
        f203315a = r103;     // Catch: Throwable -> L15
        monitor-exit(com.bytedance.crash.monitor.a.class);     // Catch: Throwable -> L15
        fh4.f r104 = f203316b;
        if (r104 == null) goto L13;
        r104.f477020d = r103;
    L13:
        d0.b(r100, com.bytedance.crash.i.e(r100));
        return f203315a;
    L15:
        th = move-exception;
        throw th;
    }

    public static synchronized f a(Context r100, String r101, long r110, long r111, String r112) {
        monitor-enter(j.class);
        com.bytedance.crash.i.g(r100);     // Catch: Throwable -> L7
        f r102 = new f(r101, r112, r110, r111);     // Catch: Throwable -> L7
        d0.c();     // Catch: Throwable -> L7
        wh4.b.post(new a(r102));     // Catch: Throwable -> L7
        monitor-exit(j.class);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }
}
