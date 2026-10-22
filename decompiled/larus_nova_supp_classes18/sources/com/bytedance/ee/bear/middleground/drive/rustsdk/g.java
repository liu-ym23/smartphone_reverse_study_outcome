package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import com.bytedance.ee.bear.middleground.drive.export.UploadRequestInfo;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ UploadRequestInfo a;

    public /* synthetic */ g(UploadRequestInfo r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UploadRequestInfo r0 = this.a;
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "driveUpload return because NOT_LOGIN");
        UploadCallback r1 = r0.l;
        if (r1 == null) goto L6;
        UploadCallback.b.a r2 = new UploadCallback.b.a();
        r2.a = DriveFile.Status.FAILED;
        r2.b = 0;
        r2.c = 1;
        r1.updateProgress("-1", new UploadCallback.b(r2), new UploadCallback.a(new UploadCallback.a.C0077a()));
        r0.l.onFailed("-1", DocUserPermission.USER_PERM_FULL_ACCESS, "", 1);
        return;
    }
}
