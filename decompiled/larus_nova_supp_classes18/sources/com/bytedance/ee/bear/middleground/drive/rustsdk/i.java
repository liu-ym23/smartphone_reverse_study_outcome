package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ DownloadRequestInfo a;

    public /* synthetic */ i(DownloadRequestInfo r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DownloadRequestInfo r0 = this.a;
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "driveDownload return because NOT_LOGIN");
        DownloadCallback r1 = r0.o;
        if (r1 == null) goto L6;
        DownloadCallback.b.a r2 = new DownloadCallback.b.a();
        r2.a = DriveFile.Status.FAILED;
        r2.c = 1;
        r2.b = 0;
        r1.updateProgress("-1", new DownloadCallback.b(r2), new DownloadCallback.a(new DownloadCallback.a.C0076a()));
        r0.o.onFailed("-1", DocUserPermission.USER_PERM_FULL_ACCESS);
        return;
    }
}
