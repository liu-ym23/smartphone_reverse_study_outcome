package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadNotificationManager implements IDownloadNotificationManagerService {
    private static volatile DownloadNotificationManager instance;
    private IDownloadNotificationManagerService service;

    public static DownloadNotificationManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(DownloadNotificationManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new DownloadNotificationManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadNotificationManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void clearNotification() {
        this.service.clearNotification();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public SparseArray<AbsNotificationItem> getAllNotificationItems() {
        return this.service.getAllNotificationItems();
    }

    private DownloadNotificationManager() {
        this.service = (IDownloadNotificationManagerService) DownloadServiceManager.getService(IDownloadNotificationManagerService.class);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void addNotification(AbsNotificationItem r100) {
        this.service.addNotification(r100);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void cancel(int r100) {
        this.service.cancel(r100);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void cancelNotification(int r100) {
        this.service.cancelNotification(r100);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public AbsNotificationItem getNotificationItem(int r100) {
        return this.service.getNotificationItem(r100);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void hideNotification(int r100) {
        this.service.hideNotification(r100);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public AbsNotificationItem removeNotification(int r100) {
        return this.service.removeNotification(r100);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void notifyByService(int r100, int r101, Notification r102) {
        this.service.notifyByService(r100, r101, r102);
    }
}
