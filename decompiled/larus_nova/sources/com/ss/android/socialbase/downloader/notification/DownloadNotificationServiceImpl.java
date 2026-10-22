package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.NotificationConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.ThreadWithHandler;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadNotificationServiceImpl {
    private static final long NOTIFY_TIME_WINDOW = 1000;
    private static final String TAG = "DownloadNotificationServiceImpl";
    private static volatile DownloadNotificationServiceImpl mInstance;
    private boolean mEnabledFixLeak;
    private AtomicBoolean mInited;
    private volatile long mLastImportantNotifyTimestamp;
    private volatile long mLastNotifyTimestamp;
    private volatile ThreadWithHandler mNotifyThreadHandler;
    private long mNotifyTimeWindow;
    private final SparseArray<Notification> mPendingImportantNotify;

    public static DownloadNotificationServiceImpl getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(DownloadNotificationServiceImpl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new DownloadNotificationServiceImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadNotificationServiceImpl.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public void init() {
        if (this.mEnabledFixLeak == false) goto L8;
        if (this.mInited.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.globalDebug(TAG, "init", "Create DownloaderNotifyThread");
    L10:
        this.mNotifyThreadHandler = new ThreadWithHandler("DownloaderNotifyThread");
        this.mNotifyThreadHandler.start();
        long r100 = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.NOTIFICATION_TIME_WINDOW, 1000);
        this.mNotifyTimeWindow = r100;
        if (r100 >= 0) goto L13;
    L14:
        this.mNotifyTimeWindow = 1000;
        return;
    L13:
        if (r100 > AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME) goto L14;
    }

    public DownloadNotificationServiceImpl() {
        this.mNotifyTimeWindow = 1000;
        this.mPendingImportantNotify = new SparseArray(2);
        this.mInited = new AtomicBoolean(false);
        this.mEnabledFixLeak = isEnableFixNotificationLeak();
    }

    private boolean isEnableFixNotificationLeak() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_NOTIFICATION_LEAK, 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public void onDestroy() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_TARGET_34) <= 0) goto L6;
        return;
    L6:
        if (this.mNotifyThreadHandler != null) goto L12;
        return;
    L12:
        this.mNotifyThreadHandler.quit();     // Catch: Throwable -> L11
    L9:
        this.mNotifyThreadHandler = null;
    }

    private void handleIntentImpl(Intent r100) {
        Context r101 = DownloadComponentManager.getAppContext();
        if (r101 != null) goto L6;
        Logger.globalError(TAG, "handleIntentImpl", "Context is null");
        return;
    L6:
        String r102 = r100.getAction();
        NotificationManager r103 = (NotificationManager) r101.getSystemService("notification");
        int r104 = r100.getIntExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, 0);
        if (NotificationConstants.ACTION_NOTIFICATION_NOTIFY.equals(r102) == false) goto L32;
        Notification r105 = (Notification) r100.getParcelableExtra(NotificationConstants.EXTRA_NOTIFICATION);
        int r106 = r100.getIntExtra(NotificationConstants.EXTRA_NOTIFICATION_STATUS, 0);
        if (r104 == 0) goto L74;
        if (r105 == null) goto L75;
        if (r103 != null) goto L13;
        return;
    L13:
        if (r106 != 4) goto L25;
        if (Downloader.getInstance(DownloadComponentManager.getAppContext()).isDownloading(r104) == true) goto L17;
        return;
    L17:
        DownloadInfo r107 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(r104);
        if (r107 != null) goto L20;
        return;
    L20:
        if (r107.canNotifyProgress() == true) goto L22;
        return;
    L22:
        if ((System.currentTimeMillis() - this.mLastImportantNotifyTimestamp) <= this.mNotifyTimeWindow) goto L79;
        doNotify(r103, r104, r105);
        r107.setLastNotifyProgressTime();
        return;
    L79:
        return;
    L25:
        if (r106 != (-2)) goto L27;
    L30:
        doImportantNotify(r103, r104, r105);
        return;
    L27:
        if (r106 == (-3)) goto L30;
        doImportantNotify(r103, r104, r105);
        return;
    L75:
        return;
    L74:
        return;
    L32:
        if (NotificationConstants.ACTION_NOTIFICATION_CANCEL.equals(r102) == false) goto L36;
        if (r104 == 0) goto L83;
        doCancel(r103, r104);
        return;
    L83:
        return;
    L36:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r102) == false) goto L56;
    L53:
        e = move-exception;
        e.printStackTrace();
        return;
    L38:
        if (DownloadHelper.checkPermission(r101, "android.permission.ACCESS_NETWORK_STATE") == false) goto L52;
        ConnectivityManager r108 = (ConnectivityManager) r101.getSystemService("connectivity");     // Catch: Exception -> L53
        if (r108 != null) goto L42;
        return;
    L42:
        NetworkInfo r109 = r108.getActiveNetworkInfo();     // Catch: Exception -> L53
        if (r109 != null) goto L45;
        return;
    L45:
        if (r109.isConnected() == false) goto L73;
        ArrayList r110 = new ArrayList();     // Catch: Exception -> L53
        if (TextUtils.isEmpty(DownloadConstants.MIME_APK) == true) goto L50;
        r110.add(DownloadConstants.MIME_APK);     // Catch: Exception -> L53
    L50:
        r110.add(DownloadConstants.MIME_PLG);     // Catch: Exception -> L53
        Downloader.getInstance(r101).restartAllFailedDownloadTasks(r110);     // Catch: Exception -> L53
        Downloader.getInstance(r101).restartAllPauseReserveOnWifiDownloadTasks(r110);     // Catch: Exception -> L53
        return;
    L73:
        return;
    L52:
        return;
    L56:
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(r102) == false) goto L58;
    L68:
        Downloader.getInstance(DownloadComponentManager.getAppContext()).pauseAll();     // Catch: Exception -> L65
        return;
    L65:
        e = move-exception;
        e.printStackTrace();
        return;
    L58:
        if ("android.intent.action.MEDIA_REMOVED".equals(r102) == true) goto L68;
        if ("android.intent.action.MEDIA_BAD_REMOVAL".equals(r102) == true) goto L68;
        if ("android.intent.action.MEDIA_EJECT".equals(r102) == true) goto L68;
    }

    public void handleIntent(final Intent r100) {
        if (r100 != null) goto L5;
    L13:
        Logger.globalError(TAG, "handleIntent", "Intent Error:" + r100);
        return;
    L5:
        if (TextUtils.isEmpty(r100.getAction()) == true) goto L13;
        init();
        if (this.mNotifyThreadHandler != null) goto L11;
        Logger.globalError(TAG, "handleIntent", "NotifyThreadHandler is null");
        return;
    L11:
        this.mNotifyThreadHandler.post(new AnonymousClass1(this, r100));
    }

    public static /* synthetic */ void access$000(DownloadNotificationServiceImpl r100, Intent r101) {
        r100.handleIntentImpl(r101);
    }

    private void doCancel(NotificationManager r100, int r101) {
        r100.cancel(r101);     // Catch: Throwable -> L4
        return;
    }

    private void performImportantNotify(NotificationManager r100, int r101) {
        SparseArray<Notification> r102 = this.mPendingImportantNotify;
        monitor-enter(r102);
        Notification r103 = this.mPendingImportantNotify.get(r101);     // Catch: Throwable -> L9
        this.mPendingImportantNotify.remove(r101);     // Catch: Throwable -> L9
        monitor-exit(r102);     // Catch: Throwable -> L9
        if (r103 == null) goto L14;
        doNotify(r100, r101, r103);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$100(DownloadNotificationServiceImpl r100, NotificationManager r101, int r102) {
        r100.performImportantNotify(r101, r102);
    }

    private void doImportantNotify(final NotificationManager r100, final int r101, Notification r110) {
        SparseArray<Notification> r102 = this.mPendingImportantNotify;
        monitor-enter(r102);
        int r103 = this.mPendingImportantNotify.indexOfKey(r101);     // Catch: Throwable -> L32
        if (r103 >= 0) goto L7;
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L32
        long r104 = this.mNotifyTimeWindow - (System.currentTimeMillis() - this.mLastNotifyTimestamp);
        if (r104 > 0) goto L16;
        r104 = 0;
    L16:
        if (r104 <= 20000) goto L18;
        r104 = 20000;
    L18:
        long r105 = System.currentTimeMillis() + r104;
        this.mLastImportantNotifyTimestamp = r105;
        this.mLastNotifyTimestamp = r105;
        if (r104 > 0) goto L22;
        doNotify(r100, r101, r110);
        return;
    L22:
        if (this.mNotifyThreadHandler == null) goto L38;
        SparseArray<Notification> r106 = this.mPendingImportantNotify;
        monitor-enter(r106);
        this.mPendingImportantNotify.put(r101, r110);     // Catch: Throwable -> L28
        monitor-exit(r106);     // Catch: Throwable -> L28
        this.mNotifyThreadHandler.postDelayed(new AnonymousClass2(this, r100, r101), r104);
        return;
    L28:
        th = move-exception;
        throw th;
    L38:
        return;
    L7:
        if (r103 >= this.mPendingImportantNotify.size()) goto L11;
        this.mPendingImportantNotify.setValueAt(r103, r110);     // Catch: Throwable -> L32
        monitor-exit(r102);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    }

    private void doNotify(NotificationManager r100, int r101, Notification r102) {
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L7
        if (this.mLastNotifyTimestamp >= r103) goto L5;
        this.mLastNotifyTimestamp = r103;     // Catch: Throwable -> L7
    L5:
        r100.notify(r101, r102);     // Catch: Throwable -> L7
        return;
    }
}
