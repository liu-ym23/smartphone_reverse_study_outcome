package com.bytedance.ee.bear.drive.loader.download.platform.processor.misc;

import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;

/* JADX INFO: loaded from: classes16.dex */
public class RustCallback implements DownloadCallback {
    private IDownloader.ICallback callback;

    private RustCallback(IDownloader.ICallback r100) {
        this.callback = r100;
    }

    public static RustCallback wrap(IDownloader.ICallback r100) {
        return new RustCallback(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.DownloadCallback
    public boolean onFailed(String r100, int r101) {
        this.callback.onRustFailed(r100, r101);
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.drive.export.DownloadCallback
    public boolean updateProgress(String r100, DownloadCallback.b r101, DownloadCallback.a r102) {
        DriveFile.Status r103 = r101.f232418a;
        if (r103 != DriveFile.Status.INFLIGHT) goto L6;
        this.callback.onProgress((int) (((r101.f232419b * 1.0f) / r101.f232420c) * 100.0f));
        return false;
    L6:
        if (r103 != DriveFile.Status.SUCCESS) goto L11;
        this.callback.onSuccess(r100, r102.f232412e);
        return false;
    L11:
        return false;
    }
}
