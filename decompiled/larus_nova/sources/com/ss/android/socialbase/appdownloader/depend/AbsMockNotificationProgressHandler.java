package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.appdownloader.notification.IMockNotificationProgressHandler;
import com.ss.android.socialbase.downloader.depend.IBizCallback;

/* JADX INFO: loaded from: classes38.dex */
public abstract class AbsMockNotificationProgressHandler implements IMockNotificationProgressHandler, IBizCallback {
    public AbsMockNotificationProgressHandler() {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IBizCallback
    public String getMonitorScene() {
        return null;
    }
}
