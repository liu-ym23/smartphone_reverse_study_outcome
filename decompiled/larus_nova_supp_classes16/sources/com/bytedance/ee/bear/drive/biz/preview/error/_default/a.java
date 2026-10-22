package com.bytedance.ee.bear.drive.biz.preview.error._default;

import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Runnable {
    public final /* synthetic */ DriveFailedToRetryPlugin a;
    public final /* synthetic */ DrivePluginHost b;

    public a(DriveFailedToRetryPlugin r1, DrivePluginHost r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        tt5.a.h("DriveComponent", "liveInnerReload() removeCache done start reload. isUIContainerDetached=" + DriveFailedToRetryPlugin.access$isUIContainerDetached(this.a));
        if (DriveFailedToRetryPlugin.access$isUIContainerDetached(this.a) == true) goto L6;
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
