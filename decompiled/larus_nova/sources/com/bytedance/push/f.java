package com.bytedance.push;

import android.app.Application;
import android.content.Context;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f266861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v67.u f266862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f266863c;

    public final void a() {
        if (k.f266885e != null) goto L5;
        com.ss.android.pushmanager.setting.b.b().getClass();
        k.f266885e = com.ss.android.pushmanager.setting.b.d().r();
    L5:
        u77.l r100 = k.f266885e;
        if (r100.enableReportingTiming == false) goto L8;
    L9:
        boolean r101 = r100.enableBackToForeNotificationReport;
        boolean r102 = r100.enablePolling;
        if (r101 == true) goto L12;
        if (r102 == true) goto L12;
        return;
    L12:
        if (r101 == false) goto L14;
        int r103 = 2;
    L15:
        int r104 = r103 + (r102 ? 1 : 0);
        com.bytedance.push.utils.f.b("Polling", "start to register foreground listener");
        k r105 = this.f266863c;
        Context r106 = this.f266861a;
        v67.u r107 = this.f266862b;
        r105.getClass();
        k.f266884d = r104;
        s67.d r108 = s67.d.a();
        g r109 = new g(r105, r106, r107);
        List<Application.ActivityLifecycleCallbacks> r110 = r108.f540837a;
        monitor-enter(r110);
    L25:
        th = move-exception;
        throw th;
    L18:
        if (((ArrayList) r108.f540837a).contains(r109) == false) goto L21;
        monitor-exit(r110);     // Catch: Throwable -> L25
    L23:
        ActivityLifecycleObserver.getIns().addObserver(new h(r105, r106, r107));
        return;
    L21:
        ((ArrayList) r108.f540837a).add(r109);     // Catch: Throwable -> L25
        monitor-exit(r110);     // Catch: Throwable -> L25
        goto L23
    L14:
        r103 = 0;
        goto L15
    L8:
        if (r100.enableOriginalReporting == true) goto L9;
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

    public f(k r100, Context r101, v67.u r102) {
        this.f266863c = r100;
        this.f266861a = r101;
        this.f266862b = r102;
    }
}
