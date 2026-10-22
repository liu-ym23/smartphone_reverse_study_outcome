package com.bytedance.push;

import android.app.Activity;
import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.PushThreadHandlerManager;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements v67.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f266884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static u77.l f266885e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f266886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f266887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<Activity> f266888c;

    /* JADX INFO: loaded from: classes21.dex */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v67.u f266889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f266890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f266891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f266892d;

        public final void a() {
            if (k.f266885e != null) goto L30;
            com.ss.android.pushmanager.setting.b.b().getClass();
            k.f266885e = com.ss.android.pushmanager.setting.b.d().r();
        L30:
            if (this.f266892d == false) goto L31;
            com.bytedance.push.utils.f.b("Polling", "Polling is cancelled");
            return;
        L31:
            com.bytedance.push.utils.f.b("Polling", "polling to report switch status");     // Catch: Throwable -> L18 Exception -> L20
            if (k.f266885e.enableOriginalReporting == false) goto L13;
            v67.h r100 = this.f266889a.getNotificationService();     // Catch: Throwable -> L18 Exception -> L20
            com.bytedance.push.notification.n r101 = (com.bytedance.push.notification.n) r100;     // Catch: Throwable -> L18 Exception -> L20
            r101.b(this.f266890b);     // Catch: Throwable -> L18 Exception -> L20
        L13:
            if (k.f266885e.enableReportingTiming == false) goto L16;
            v67.h r102 = this.f266889a.getNotificationService();     // Catch: Throwable -> L18 Exception -> L20
            com.bytedance.push.notification.n r103 = (com.bytedance.push.notification.n) r102;     // Catch: Throwable -> L18 Exception -> L20
            r103.c(this.f266890b, "pollingAction");     // Catch: Throwable -> L18 Exception -> L20
        L16:
            if (this.f266892d == true) goto L33;
        L24:
            PushThreadHandlerManager.inst().postRunnable(this, this.f266891c);
            return;
        L33:
            return;
        L20:
            e = move-exception;
            com.bytedance.push.utils.f.f("Polling", "Polling failed", e);     // Catch: Throwable -> L18
            if (this.f266892d == false) goto L24;
            return;
        L18:
            th = move-exception;
            if (this.f266892d == true) goto L29;
            PushThreadHandlerManager.inst().postRunnable(this, this.f266891c);
        L29:
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(v67.u r100, Context r101, long r102) {
            this.f266889a = r100;
            this.f266890b = r101;
            this.f266891c = r102;
            this.f266892d = false;
        }
    }

    public k() {
        this.f266887b = false;
        this.f266888c = null;
    }
}
