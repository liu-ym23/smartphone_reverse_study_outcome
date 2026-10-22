package com.ss.android.downloadlib.addownload;

import com.ss.android.socialbase.appdownloader.notification.IMockNotificationProgressHandler;

/* JADX INFO: loaded from: classes34.dex */
public class MockNotificationProgressHandlerManager implements IMockNotificationProgressHandler {
    private static volatile MockNotificationProgressHandlerManager sInstance;

    public MockNotificationProgressHandlerManager() {
    }

    public static MockNotificationProgressHandlerManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(MockNotificationProgressHandlerManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new MockNotificationProgressHandlerManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MockNotificationProgressHandlerManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // com.ss.android.socialbase.appdownloader.notification.IMockNotificationProgressHandler
    public long onNotificationUpdate(int r100, long r101, long r102) {
        int r103 = (int) ((r101 * 100) / r102);
        if (r102 > 0) goto L6;
        return 0;
    L6:
        return (((long) DownloadPercentHelper.handlePercent(r100, r103, r102)) * r102) / 100;
    }
}
