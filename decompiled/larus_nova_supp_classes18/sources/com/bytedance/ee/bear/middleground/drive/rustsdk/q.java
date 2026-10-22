package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ List a;

    public /* synthetic */ q(List r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List r0 = this.a;
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "driveMultiDownload return because NOT_LOGIN");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        DownloadCallback r2 = ((DownloadRequestInfo) r1.next()).o;
        if (r2 == null) goto L4;
        DownloadCallback.b.a r3 = new DownloadCallback.b.a();
        r3.a = DriveFile.Status.FAILED;
        r3.c = 1;
        r3.b = 0;
        r2.updateProgress("-1", new DownloadCallback.b(r3), new DownloadCallback.a(new DownloadCallback.a.C0076a()));
        r2.onFailed("-1", DocUserPermission.USER_PERM_FULL_ACCESS);
        goto L4
    }
}
