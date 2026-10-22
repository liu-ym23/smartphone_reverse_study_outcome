package com.ss.android.socialbase.downloader.notification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadNotificationService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
        DownloadNotificationServiceImpl.getInstance().init();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        DownloadNotificationServiceImpl.getInstance().onDestroy();
    }

    public DownloadNotificationService() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        DownloadNotificationServiceImpl.getInstance().handleIntent(r100);
        return 2;
    }
}
