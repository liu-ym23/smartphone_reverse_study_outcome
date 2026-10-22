package com.bytedance.sync.v2;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import hg7.m;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.bytedance.sync.v2.net.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f270435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WsMonitor f270436b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f270437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f270438b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f270438b.f270436b.a(this.f270437a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(e r100, long r101) {
            this.f270438b = r100;
            this.f270437a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f270439a;

        @Override // java.lang.Runnable
        public final void run() {
            ProcessLifecycleOwner.get().getLifecycle().removeObserver(this.f270439a.f270436b);     // Catch: Throwable -> L4 Exception -> L6
        L12:
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L6:
            zf7.b.b("there is something wrong when remove life cycle Observer,maybe someone add addObserver in work thread");     // Catch: Throwable -> L4
            goto L12
        }

        public b(e r100) {
            this.f270439a = r100;
        }
    }

    @Override // com.bytedance.sync.v2.net.d.a
    public final void M(boolean r100) {
        monitor-enter(this);
        WsMonitor r101 = this.f270436b;     // Catch: Throwable -> L13
        long r102 = r101.f270383a;     // Catch: Throwable -> L13
        if (r100 == true) goto L6;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L6:
        if (r102 <= 0) goto L11;
        r101.f270383a = 0;     // Catch: Throwable -> L13
        this.f270435a.o(this);     // Catch: Throwable -> L13
        new Handler(((yf7.f) rgc.b.a(yf7.f.class)).get(), null).post(new a(this, SystemClock.elapsedRealtime() - r102));     // Catch: Throwable -> L13
        WsMonitor r103 = this.f270436b;     // Catch: Throwable -> L13
        b r104 = new b(this);     // Catch: Throwable -> L13
        r103.getClass();     // Catch: Throwable -> L13
        if (Looper.getMainLooper() != Looper.myLooper()) goto L10;
        r104.run();     // Catch: Throwable -> L13
        goto L11
    L10:
        new Handler(Looper.getMainLooper()).post(r104);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public e(WsMonitor r100, m r101) {
        this.f270436b = r100;
        this.f270435a = r101;
    }
}
