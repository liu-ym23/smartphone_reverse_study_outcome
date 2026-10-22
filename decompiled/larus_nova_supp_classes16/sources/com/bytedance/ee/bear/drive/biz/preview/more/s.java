package com.bytedance.ee.bear.drive.biz.preview.more;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s implements Runnable {
    public final /* synthetic */ DriveLocalFileMoreMenuPlugin a;
    public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d b;

    public s(DriveLocalFileMoreMenuPlugin r1, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.showText(DriveLocalFileMoreMenuPlugin.access$getContext(this.a), 2131888428);     // Catch: Throwable -> L4
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d.a(this.b, null, null, 0, 15);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
