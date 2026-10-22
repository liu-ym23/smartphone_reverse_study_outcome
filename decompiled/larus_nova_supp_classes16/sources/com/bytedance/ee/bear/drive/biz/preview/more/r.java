package com.bytedance.ee.bear.drive.biz.preview.more;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r implements Runnable {
    public final /* synthetic */ DriveLocalFileMoreMenuPlugin a;
    public final /* synthetic */ String b;

    public r(DriveLocalFileMoreMenuPlugin r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.showSuccessText(DriveLocalFileMoreMenuPlugin.access$getContext(this.a), this.b, 1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
