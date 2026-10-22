package com.bytedance.ee.bear.drive.biz.preview.error._default;

import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Runnable {
    public final /* synthetic */ OfficeDriveFailedToRetryPlugin a;
    public final /* synthetic */ DrivePluginHost b;

    public b(OfficeDriveFailedToRetryPlugin r1, DrivePluginHost r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        tt5.a.h("DriveComponent", "liveInnerReload() removeCache done start reload. isUIContainerDetached=" + OfficeDriveFailedToRetryPlugin.access$isUIContainerDetached(this.a));
        if (OfficeDriveFailedToRetryPlugin.access$isUIContainerDetached(this.a) == true) goto L6;
        this.b.c().load();
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
