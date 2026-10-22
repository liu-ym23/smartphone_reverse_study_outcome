package com.ss.android.message;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.push.third.g;
import com.bytedance.push.utils.f;
import com.larus.apm.impl.protector.RunnableProtector;
import gfc.c;
import rgc.b;

/* JADX INFO: loaded from: classes38.dex */
public class NotifyService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f449120a = 0;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotifyService f449121a;

        @Override // java.lang.Runnable
        public final void run() {
            NotifyService r100 = this.f449121a;     // Catch: Throwable -> L6
            int r101 = NotifyService.f449120a;     // Catch: Throwable -> L6
            r100.getClass();     // Catch: Throwable -> L6
            g.g().f(r100.getApplicationContext());     // Catch: Throwable -> L11
        L4:
            f.b("NotifyService", "do onCreate end");     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L10;
            return;
        L10:
            throw th;
        }

        public a(NotifyService r100) {
            this.f449121a = r100;
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        l67.a.d(getApplicationContext()).b();
        PushThreadHandlerManager.inst().postRunnable(new a(this));
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        g.g().b();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public NotifyService() {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        f.b("PushService NotifyService", "onBind");
        PushThreadHandlerManager.inst().postRunnable(new c(r100));
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        int r103 = super.onStartCommand(r100, r101, r102);
        if (f.f267065a == false) goto L5;
        f.b("PushService NotifyService", "onStartCommand");
    L5:
        PushThreadHandlerManager.inst().postRunnable(new c(r100));
        zfc.a.b r104 = (zfc.a.b) b.a(zfc.a.b.class);
        if (r104 != null) goto L8;
        return 2;
    L8:
        if (r104.f() == true) goto L13;
        return r103;
    L13:
        return 2;
    }
}
