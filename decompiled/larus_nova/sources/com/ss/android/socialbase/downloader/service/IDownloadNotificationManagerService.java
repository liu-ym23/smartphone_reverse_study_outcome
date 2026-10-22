package com.ss.android.socialbase.downloader.service;

import android.app.Notification;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadNotificationManagerService {

    /* JADX INFO: loaded from: classes38.dex */
    public static class DefaultDownloadNotificationManagerService implements IDownloadNotificationManagerService {
        public DefaultDownloadNotificationManagerService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public void addNotification(AbsNotificationItem r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public void cancel(int r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public void cancelNotification(int r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public void clearNotification() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public SparseArray<AbsNotificationItem> getAllNotificationItems() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public AbsNotificationItem getNotificationItem(int r100) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public void hideNotification(int r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public void notifyByService(int r100, int r101, Notification r102) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
        public AbsNotificationItem removeNotification(int r100) {
            return null;
        }
    }

    void addNotification(AbsNotificationItem r100);

    void cancel(int r100);

    void cancelNotification(int r100);

    void clearNotification();

    SparseArray<AbsNotificationItem> getAllNotificationItems();

    AbsNotificationItem getNotificationItem(int r100);

    void hideNotification(int r100);

    void notifyByService(int r100, int r101, Notification r102);

    AbsNotificationItem removeNotification(int r100);
}
