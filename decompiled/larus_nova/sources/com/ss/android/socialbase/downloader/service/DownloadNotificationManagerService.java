package com.ss.android.socialbase.downloader.service;

import android.app.Notification;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManagerImpl;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadNotificationManagerService implements IDownloadNotificationManagerService {
    public DownloadNotificationManagerService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void clearNotification() {
        DownloadNotificationManagerImpl.getInstance().clearNotification();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public SparseArray<AbsNotificationItem> getAllNotificationItems() {
        return DownloadNotificationManagerImpl.getInstance().getAllNotificationItems();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void addNotification(AbsNotificationItem r100) {
        DownloadNotificationManagerImpl.getInstance().addNotification(r100);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void cancel(int r100) {
        DownloadNotificationManagerImpl.getInstance().cancel(r100);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void cancelNotification(int r100) {
        DownloadNotificationManagerImpl.getInstance().cancelNotification(r100);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public AbsNotificationItem getNotificationItem(int r100) {
        return DownloadNotificationManagerImpl.getInstance().getNotificationItem(r100);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void hideNotification(int r100) {
        DownloadNotificationManagerImpl.getInstance().hideNotification(r100);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public AbsNotificationItem removeNotification(int r100) {
        return DownloadNotificationManagerImpl.getInstance().removeNotification(r100);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void notifyByService(int r100, int r101, Notification r102) {
        DownloadNotificationManagerImpl.getInstance().notifyByService(r100, r101, r102);
    }
}
