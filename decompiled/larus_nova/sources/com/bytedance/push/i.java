package com.bytedance.push;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v67.u f266880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f266881b;

    public final void a() {
        if (k.f266885e != null) goto L6;
        com.ss.android.pushmanager.setting.b.b().getClass();
        k.f266885e = com.ss.android.pushmanager.setting.b.d().r();
    L6:
        if (k.f266885e.enableReportingTiming == false) goto L9;
        v67.h r100 = this.f266880a.getNotificationService();
        com.bytedance.push.notification.n r101 = (com.bytedance.push.notification.n) r100;
        r101.c(this.f266881b, "performForegroundAction");
    L9:
        if (k.f266885e.enableOriginalReporting == false) goto L12;
        v67.h r102 = this.f266880a.getNotificationService();
        com.bytedance.push.notification.n r103 = (com.bytedance.push.notification.n) r102;
        r103.b(this.f266881b);
        return;
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

    public i(v67.u r100, Context r101) {
        this.f266880a = r100;
        this.f266881b = r101;
    }
}
