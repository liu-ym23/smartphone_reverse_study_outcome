package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadTimingInfo {
    public long afterOnPrepareTime;
    public long afterOnStartTime;
    public long beforeOnEndCallbackTime;
    public long beforeOnPrepareTime;
    public long beforeOnStartTime;
    public long beforeThreadExecuteTime;
    public long buildDownloadInfoTime;
    public long callDownloadTime;
    public long doDownloadTime;
    public long endDownloadTime;
    public long threadExecuteTime;
    public long tryDownloadTime;

    public DownloadTimingInfo() {
    }

    public DownloadTimingInfo copy() {
        DownloadTimingInfo r100 = new DownloadTimingInfo();
        r100.callDownloadTime = this.callDownloadTime;
        r100.buildDownloadInfoTime = this.buildDownloadInfoTime;
        r100.tryDownloadTime = this.tryDownloadTime;
        r100.doDownloadTime = this.doDownloadTime;
        r100.beforeThreadExecuteTime = this.beforeThreadExecuteTime;
        r100.threadExecuteTime = this.threadExecuteTime;
        r100.beforeOnPrepareTime = this.beforeOnPrepareTime;
        r100.afterOnPrepareTime = this.afterOnPrepareTime;
        r100.beforeOnStartTime = this.beforeOnStartTime;
        r100.afterOnStartTime = this.afterOnStartTime;
        r100.beforeOnEndCallbackTime = this.beforeOnEndCallbackTime;
        r100.endDownloadTime = System.currentTimeMillis();
        return r100;
    }

    public JSONObject obtainDurationStats() {
        JSONObject r100 = new JSONObject();
        long r101 = this.callDownloadTime;     // Catch: Throwable -> L12
        long r102 = 0;
        if (r101 <= 0) goto L6;
        long r103 = this.buildDownloadInfoTime - r101;     // Catch: Throwable -> L12
    L7:
        r100.put(MonitorConstants.BUILD_DOWNLOAD_INFO, r103);     // Catch: Throwable -> L12
        long r104 = this.buildDownloadInfoTime;     // Catch: Throwable -> L12
        if (r104 <= 0) goto L10;
        r102 = this.tryDownloadTime - r104;     // Catch: Throwable -> L12
    L10:
        r100.put(MonitorConstants.TRY_DOWNLOAD, r102);     // Catch: Throwable -> L12
        r100.put(MonitorConstants.DO_DOWNLOAD, this.doDownloadTime - this.tryDownloadTime);     // Catch: Throwable -> L12
        r100.put(MonitorConstants.BEFORE_THREAD_EXECUTE, this.beforeThreadExecuteTime - this.doDownloadTime);     // Catch: Throwable -> L12
        r100.put(MonitorConstants.THREAD_EXECUTE, this.threadExecuteTime - this.beforeThreadExecuteTime);     // Catch: Throwable -> L12
        r100.put(MonitorConstants.BEFORE_ON_PREPARE, this.beforeOnPrepareTime - this.threadExecuteTime);     // Catch: Throwable -> L12
        r100.put(MonitorConstants.AFTER_ON_PREPARE, this.afterOnPrepareTime - this.beforeOnPrepareTime);     // Catch: Throwable -> L12
        r100.put(MonitorConstants.BEFORE_ON_START, this.beforeOnStartTime - this.afterOnPrepareTime);     // Catch: Throwable -> L12
        r100.put(MonitorConstants.AFTER_ON_START, this.afterOnStartTime - this.beforeOnStartTime);     // Catch: Throwable -> L12
        r100.put(MonitorConstants.BEFORE_ON_FINISH, this.beforeOnEndCallbackTime - this.afterOnStartTime);     // Catch: Throwable -> L12
        r100.put(MonitorConstants.AFTER_ON_FINISH, this.endDownloadTime - this.beforeOnEndCallbackTime);     // Catch: Throwable -> L12
    L14:
        return r100;
    L6:
        r103 = 0;
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L14
    }

    public JSONObject obtainOriginStats() {
        JSONObject r100 = new JSONObject();
        r100.put(MonitorConstants.CALL_DOWNLOAD, this.callDownloadTime);     // Catch: Throwable -> L5
        r100.put(MonitorConstants.BUILD_DOWNLOAD_INFO, this.buildDownloadInfoTime);     // Catch: Throwable -> L5
        r100.put(MonitorConstants.TRY_DOWNLOAD, this.tryDownloadTime);     // Catch: Throwable -> L5
        r100.put(MonitorConstants.DO_DOWNLOAD, this.doDownloadTime);     // Catch: Throwable -> L5
        r100.put(MonitorConstants.BEFORE_THREAD_EXECUTE, this.beforeThreadExecuteTime);     // Catch: Throwable -> L5
        r100.put(MonitorConstants.THREAD_EXECUTE, this.threadExecuteTime);     // Catch: Throwable -> L5
        r100.put(MonitorConstants.BEFORE_ON_PREPARE, this.beforeOnPrepareTime);     // Catch: Throwable -> L5
        r100.put(MonitorConstants.AFTER_ON_PREPARE, this.afterOnPrepareTime);     // Catch: Throwable -> L5
        r100.put(MonitorConstants.BEFORE_ON_START, this.beforeOnStartTime);     // Catch: Throwable -> L5
        r100.put(MonitorConstants.AFTER_ON_START, this.afterOnStartTime);     // Catch: Throwable -> L5
        r100.put(MonitorConstants.BEFORE_ON_FINISH, this.beforeOnEndCallbackTime);     // Catch: Throwable -> L5
        r100.put(MonitorConstants.AFTER_ON_FINISH, System.currentTimeMillis());     // Catch: Throwable -> L5
    L7:
        return r100;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public void reset() {
        this.callDownloadTime = 0;
        this.buildDownloadInfoTime = 0;
        this.tryDownloadTime = 0;
        this.doDownloadTime = 0;
        this.beforeThreadExecuteTime = 0;
        this.threadExecuteTime = 0;
        this.beforeOnPrepareTime = 0;
        this.afterOnPrepareTime = 0;
        this.beforeOnStartTime = 0;
        this.afterOnStartTime = 0;
        this.beforeOnEndCallbackTime = 0;
    }
}
