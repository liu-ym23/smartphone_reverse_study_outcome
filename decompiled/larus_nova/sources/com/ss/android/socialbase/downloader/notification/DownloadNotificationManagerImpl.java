package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.NotificationConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadNotificationManagerImpl {
    private static final String TAG = "DownloadNotificationManagerImpl";
    private static volatile DownloadNotificationManagerImpl instance;
    private final long PROGRESS_NOTIFY_DURATION;
    private final SparseArray<Long> PROGRESS_NOTIFY_LAST_TIME_INFO;
    private final SparseArray<AbsNotificationItem> notificationItemArray;

    public static boolean isCompleteVisibility(int r100) {
        if (r100 != 1) goto L5;
    L9:
        return true;
    L5:
        if (r100 == 3) goto L9;
        return false;
    }

    public static DownloadNotificationManagerImpl getInstance() {
        if (instance != null) goto L15;
        monitor-enter(DownloadNotificationManagerImpl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new DownloadNotificationManagerImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadNotificationManagerImpl.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public void clearNotification() {
        SparseArray<AbsNotificationItem> r100 = this.notificationItemArray;
        monitor-enter(r100);
        SparseArray<AbsNotificationItem> r101 = this.notificationItemArray.clone();     // Catch: Throwable -> L11
        this.notificationItemArray.clear();     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        int r102 = 0;
    L8:
        if (r102 >= r101.size()) goto L10;
        r101.get(r101.keyAt(r102)).cancel();
        r102 = r102 + 1;
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public SparseArray<AbsNotificationItem> getAllNotificationItems() {
        SparseArray<AbsNotificationItem> r100 = this.notificationItemArray;
        monitor-enter(r100);
        SparseArray<AbsNotificationItem> r101 = this.notificationItemArray;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    private DownloadNotificationManagerImpl() {
        this.PROGRESS_NOTIFY_DURATION = 1000;
        this.PROGRESS_NOTIFY_LAST_TIME_INFO = new SparseArray();
        this.notificationItemArray = new SparseArray();
    }

    public static boolean isCompleteAndVisible(DownloadInfo r100) {
        if (r100.isDownloadOverStatus() == true) goto L5;
        return false;
    L5:
        if (isCompleteVisibility(r100.getNotificationVisibility()) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public void addNotification(AbsNotificationItem r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        SparseArray<AbsNotificationItem> r101 = this.notificationItemArray;
        monitor-enter(r101);
        this.notificationItemArray.put(r100.getId(), r100);     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void cancel(int r100) {
        Context r101 = DownloadComponentManager.getAppContext();
        if (r101 == null) goto L19;
        if (r100 == 0) goto L21;
        Intent r102 = new Intent(r101, DownloadNotificationService.class);
        r102.setAction(NotificationConstants.ACTION_NOTIFICATION_CANCEL);     // Catch: Throwable -> L13
        r102.putExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, r100);     // Catch: Throwable -> L13
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_TARGET_34) <= 0) goto L11;
        DownloadNotificationServiceImpl.getInstance().handleIntent(r102);     // Catch: Throwable -> L13
        return;
    L11:
        r101.startService(r102);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Logger.taskError(TAG, r100, "cancel", "Error:" + th);
        th.printStackTrace();
        if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.FIX_BACKGROUND_NOTIFICATION) == false) goto L20;
        DownloadNotificationServiceImpl.getInstance().handleIntent(r102);
        return;
    L20:
        return;
    L21:
        return;
    }

    public void cancelCompleteNotification(DownloadInfo r100) {
        if (isCompleteAndVisible(r100) == false) goto L6;
        cancelNotification(r100.getId());
        return;
    }

    public void cancelNotification(int r100) {
        removeNotification(r100);
        if (r100 == 0) goto L6;
        DownloadNotificationManager.getInstance().cancel(r100);
        return;
    }

    public AbsNotificationItem getNotificationItem(int r100) {
        if (r100 != 0) goto L5;
        return null;
    L5:
        SparseArray<AbsNotificationItem> r101 = this.notificationItemArray;
        monitor-enter(r101);
        AbsNotificationItem r102 = this.notificationItemArray.get(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    public void hideNotification(int r100) {
        DownloadInfo r101 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        updateNotificationState(r101);
        cancelCompleteNotification(r101);
    }

    public AbsNotificationItem removeNotification(int r100) {
        if (r100 != 0) goto L5;
        return null;
    L5:
        SparseArray<AbsNotificationItem> r101 = this.notificationItemArray;
        monitor-enter(r101);
        AbsNotificationItem r102 = this.notificationItemArray.get(r100);     // Catch: Throwable -> L12
        if (r102 == null) goto L10;
        this.notificationItemArray.remove(r100);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L12:
        th = move-exception;
        throw th;
    }

    public void updateNotificationState(DownloadInfo r100) {
        if (r100.isDownloadOverStatus() == false) goto L6;
        r100.setNotificationVisibility(3);
        Downloader.getInstance(DownloadComponentManager.getAppContext()).updateDownloadInfo(r100);
        return;
    }

    public void notifyByService(int r110, int r111, Notification r112) {
        Context r100 = DownloadComponentManager.getAppContext();
        if (r100 == null) goto L37;
        if (r110 == 0) goto L38;
        if (r112 != null) goto L8;
        return;
    L8:
        if (r111 != 4) goto L23;
        SparseArray<Long> r101 = this.PROGRESS_NOTIFY_LAST_TIME_INFO;
        monitor-enter(r101);
        Long r102 = this.PROGRESS_NOTIFY_LAST_TIME_INFO.get(r110);     // Catch: Throwable -> L20
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L20
        if (r102 != null) goto L14;
    L17:
        this.PROGRESS_NOTIFY_LAST_TIME_INFO.put(r110, Long.valueOf(r103));     // Catch: Throwable -> L20
        monitor-exit(r101);     // Catch: Throwable -> L20
        goto L23
    L14:
        if (Math.abs(r103 - r102.longValue()) >= 1000) goto L17;
        monitor-exit(r101);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L23:
        Intent r104 = new Intent(r100, DownloadNotificationService.class);
        r104.setAction(NotificationConstants.ACTION_NOTIFICATION_NOTIFY);     // Catch: Throwable -> L30
        r104.putExtra(NotificationConstants.EXTRA_NOTIFICATION_STATUS, r111);     // Catch: Throwable -> L30
        r104.putExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, r110);     // Catch: Throwable -> L30
        r104.putExtra(NotificationConstants.EXTRA_NOTIFICATION, r112);     // Catch: Throwable -> L30
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_TARGET_34) <= 0) goto L28;
        DownloadNotificationServiceImpl.getInstance().handleIntent(r104);     // Catch: Throwable -> L30
        return;
    L28:
        r100.startService(r104);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r110, "notifyByService", "Error:" + th);
        if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.FIX_BACKGROUND_NOTIFICATION) == false) goto L39;
        DownloadNotificationServiceImpl.getInstance().handleIntent(r104);
        return;
    L39:
        return;
    L38:
        return;
    }
}
