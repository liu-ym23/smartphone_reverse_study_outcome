package com.ss.android.socialbase.appdownloader;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class RetryJobSchedulerServiceImpl {
    private static final String TAG = "RetryJobSchedulerServiceImpl";

    public RetryJobSchedulerServiceImpl() {
    }

    public static boolean onStartJob(JobParameters r100) {
        if (r100 == null) goto L9;
        int r101 = r100.getJobId();
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "onStartJob", "Id: " + r101);
    L6:
        RetryScheduler.getInstance().doSchedulerRetry(r101);
        return false;
    L9:
        return false;
    }

    public static void tryCancelScheduleRetry(int r100) {
        Context r101 = DownloadComponentManager.getAppContext();
        if (r101 != null) goto L13;
        return;
    L13:
        JobScheduler r102 = (JobScheduler) r101.getSystemService("jobscheduler");     // Catch: Throwable -> L10
        if (r102 != null) goto L8;
        return;
    L8:
        r102.cancel(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public static void tryStartScheduleRetry(DownloadInfo r110, long r111, boolean r112, int r210) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (r111 <= 0) goto L57;
        Context r100 = DownloadComponentManager.getAppContext();
        if (r100 != null) goto L10;
        return;
    L10:
        int r101 = 2;
        if (r110.isPauseReserveOnWifi() == false) goto L52;
        IReserveWifiStatusListener r102 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener();
        if (r102 == null) goto L52;
        r102.onStatusChanged(r110, 2, 3);
    L52:
        JobScheduler r103 = (JobScheduler) r100.getSystemService("jobscheduler");     // Catch: Throwable -> L47
        if (r103 != null) goto L50;
        return;
    L50:
        r103.cancel(r110.getId());     // Catch: Throwable -> L20
    L22:
        if (r210 == 0) goto L27;
        if (r112 == false) goto L26;
        if (r210 != 2) goto L27;
    L26:
        long r113 = r111 + 60000;     // Catch: Throwable -> L47
        long r114 = r111;
    L28:
        JobInfo.Builder r104 = new JobInfo.Builder(r110.getId(), new ComponentName(r100.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(r114);     // Catch: Throwable -> L47
        if (r112 == true) goto L32;
        r101 = 1;
    L32:
        JobInfo.Builder r105 = r104.setRequiredNetworkType(r101).setRequiresCharging(false).setRequiresDeviceIdle(false);     // Catch: Throwable -> L47
        if (r113 <= 0) goto L35;
        r105.setOverrideDeadline(r113);     // Catch: Throwable -> L47
    L35:
        int r106 = r103.schedule(r105.build());     // Catch: Throwable -> L47
        if (r106 > 0) goto L38;
    L42:
        if (r106 <= 0) goto L44;
        return;
    L44:
        if (Logger.debug() == false) goto L56;
        Logger.globalDebug(TAG, "tryStartScheduleRetry", "ErrCode: " + r106);     // Catch: Throwable -> L47
        return;
    L56:
        return;
    L38:
        if (r110.isPauseReserveOnWifi() == false) goto L42;
        IReserveWifiStatusListener r107 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener();     // Catch: Throwable -> L47
        if (r107 == null) goto L42;
        r107.onStatusChanged(r110, 3, 3);     // Catch: Throwable -> L47
    L27:
        r114 = 1000;
        r113 = 0;
        goto L28
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
