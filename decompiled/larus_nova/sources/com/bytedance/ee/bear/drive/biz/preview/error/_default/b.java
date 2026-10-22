package com.bytedance.ee.bear.drive.biz.preview.error._default;

import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeDriveFailedToRetryPlugin f223315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DrivePluginHost f223316b;

    public b(OfficeDriveFailedToRetryPlugin r100, DrivePluginHost r101) {
        this.f223315a = r100;
        this.f223316b = r101;
    }

    public final void a() {
        tt5.a.h("DriveComponent", "liveInnerReload() removeCache done start reload. isUIContainerDetached=" + OfficeDriveFailedToRetryPlugin.access$isUIContainerDetached(this.f223315a));
        if (OfficeDriveFailedToRetryPlugin.access$isUIContainerDetached(this.f223315a) == true) goto L6;
        this.f223316b.c().load();
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
