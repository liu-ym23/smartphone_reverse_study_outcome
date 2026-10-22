package com.bytedance.praisedialoglib.manager;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f266654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f266655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f266656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f266657d;

    public class a implements z57.a.InterfaceC8421a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f266658a;

        public final void a() {
            com.bytedance.praisedialoglib.manager.a.C3729a.f266645a.e();
        }

        public final void b() {
            com.bytedance.praisedialoglib.manager.a r100 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a;
            y57.c r101 = r100.f266638d;
            if (r101 == null) goto L5;
            r101.a();
            boolean r102 = true;
        L6:
            if (r102 == false) goto L8;
            this.f266658a.f266657d.f266660a.post(new f(this));
            return;
        L8:
            r100.e();
            return;
        L5:
            r102 = false;
            goto L6
        }

        public a(g r100) {
            this.f266658a = r100;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.praisedialoglib.manager.a r100 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a;     // Catch: Throwable -> L7
        z57.a r101 = new z57.a(String.valueOf(this.f266654a), new a(this));     // Catch: Throwable -> L7
        y57.b r102 = r100.f266639e;     // Catch: Throwable -> L7
        if (r102 == null) goto L5;
        r102.execute(r101);     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        w57.c.f558353a.submit(r101);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }

    public g(h r100, long r101, Context r102, String r103) {
        this.f266657d = r100;
        this.f266654a = r101;
        this.f266655b = r102;
        this.f266656c = r103;
    }
}
