package com.bytedance.ee.bear.drive.loader.download.platform.processor.misc;

import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RustCallback implements DownloadCallback {
    private IDownloader.ICallback callback;

    private RustCallback(IDownloader.ICallback r1) {
        this.callback = r1;
    }

    public static RustCallback wrap(IDownloader.ICallback r1) {
        return new RustCallback(r1);
    }

    public boolean onFailed(String r2, int r3) {
        this.callback.onRustFailed(r2, r3);
        return false;
    }

    public boolean updateProgress(String r3, DownloadCallback.b r4, DownloadCallback.a r5) {
        DriveFile.Status r0 = r4.a;
        if (r0 != DriveFile.Status.INFLIGHT) goto L6;
        this.callback.onProgress((int) (((r4.b * 1.0f) / r4.c) * 100.0f));
        return false;
    L6:
        if (r0 != DriveFile.Status.SUCCESS) goto L11;
        this.callback.onSuccess(r3, r5.e);
        return false;
    L11:
        return false;
    }
}
