package com.bytedance.ee.bear.drive.biz.preview.error._default;

import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DriveFailedToRetryPlugin f223313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DrivePluginHost f223314b;

    public a(DriveFailedToRetryPlugin r100, DrivePluginHost r101) {
        this.f223313a = r100;
        this.f223314b = r101;
    }

    public final void a() {
        tt5.a.h("DriveComponent", "liveInnerReload() removeCache done start reload. isUIContainerDetached=" + DriveFailedToRetryPlugin.access$isUIContainerDetached(this.f223313a));
        if (DriveFailedToRetryPlugin.access$isUIContainerDetached(this.f223313a) == true) goto L6;
        this.f223314b.c().load();
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
}
