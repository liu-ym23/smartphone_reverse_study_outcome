package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadTimingInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadListenerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadStatusHandler {
    private static final String TAG = null;
    private IDownloadCache downloadCache;
    private DownloadInfo downloadInfo;
    private IDownloadMonitorDepend downloadMonitorDepend;
    private DownloadTask downloadTask;
    private final boolean fixAnrProcessHandleMsg;
    private final boolean fixSameTaskMonitorReport;
    private boolean forceRefreshProcess;
    private boolean hasSyncProgressBefore;
    private boolean isFastDownload;
    private volatile long lastSyncProgressTime;
    private boolean mRemoveUselessReport;
    private final Handler mainThreadHandler;
    private Map<Integer, IDownloadListener> mainThreadListeners;
    private long minByteIntervalForSyncProgress;
    private int minTimeIntervalForSyncProgress;
    private final AtomicLong msgPostDataBuffer;
    private Map<Integer, IDownloadListener> notificationListeners;
    private long prepareDownloadTime;
    private Map<Integer, IDownloadListener> subThreadListeners;

    public void onCancel() {
        onStatusChanged(-4, null);
    }

    static {
        TAG = "DownloadStatusHandler";
    }

    private void downloadCompleteProcess() throws BaseException {
        List<IDownloadCompleteHandler> r100 = this.downloadTask.getDownloadCompleteHandlers();
        if (r100.isEmpty() == true) goto L17;
        DownloadInfo r101 = this.downloadInfo;
        onStatusChanged(11, null);
        this.downloadCache.updateDownloadInfo(r101);
        Iterator<IDownloadCompleteHandler> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L25;
        IDownloadCompleteHandler r103 = r102.next();
    L15:
        e = move-exception;
        throw e;
    L12:
        th = move-exception;
        throw new BaseException(1071, th);
    L9:
        if (r103.needHandle(r101) == false) goto L6;
        r103.handle(r101);     // Catch: Throwable -> L12 BaseException -> L15
        this.downloadCache.updateDownloadInfo(r101);     // Catch: Throwable -> L12 BaseException -> L15
    L25:
        return;
    }

    public void handlePrepare() {
        DownloadTimingInfo r100 = this.downloadTask.getTimingInfo();
        r100.beforeOnPrepareTime = System.currentTimeMillis();
        if (this.downloadInfo.canSkipStatusHandler() == true) goto L5;
        this.downloadCache.OnDownloadTaskPrepare(this.downloadInfo.getId());
        onStatusChanged(1, null);
    L5:
        long r101 = this.prepareDownloadTime;
        if (r101 > 0) goto L11;
    L8:
        DownloadTimingInfo r102 = this.downloadTask.getTimingInfo();
        r102.afterOnPrepareTime = System.currentTimeMillis();
        return;
    L11:
        this.downloadInfo.increaseDownloadPrepareTime(r101);     // Catch: Throwable -> L10
        goto L8
    }

    public void handleWaitingAsyncHandler() {
        this.downloadInfo.setStatus(8);
        this.downloadInfo.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_WAITING);
        AbsDownloadEngine r100 = DownloadComponentManager.getDownloadEngine();
        if (r100 == null) goto L6;
        r100.refreshDownloadTaskMap(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), 8);
        return;
    }

    public void onCompleteForFileExist() throws BaseException {
        if (this.downloadInfo == null) goto L10;
        downloadCompleteProcess();
        if (Logger.debugScene(this.downloadInfo) == false) goto L7;
        Logger.taskDebug(TAG, this.downloadInfo, "onCompleteForFileExist", "Success");
    L7:
        this.downloadInfo.setSuccessByCache(true);
        onStatusChanged(-3, null);
        this.downloadCache.OnDownloadTaskCompleted(this.downloadInfo.getId(), this.downloadInfo.getTotalBytes());
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        this.downloadCache.removeSegments(this.downloadInfo.getId());
        return;
    L10:
        throw new BaseException(1087, "onCompleteForFileExist DownloadInfo is null");
    }

    public void onIntercept() {
        this.downloadInfo.setStatus(-7);
        this.downloadCache.OnDownloadTaskIntercept(this.downloadInfo.getId());     // Catch: SQLiteException -> L5
    L7:
        onStatusChanged(-7, null);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void onPause() {
        this.downloadInfo.setStatus(-2);
        this.downloadCache.OnDownloadTaskPause(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());     // Catch: SQLiteException -> L5
    L7:
        onStatusChanged(-2, null);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void onSaveTempFileSuccess() {
    L17:
        th = move-exception;
        onError(new BaseException(1008, DownloadUtils.getErrorMsgWithTagPrefix(th, LynxVideoManagerLite.EVENT_ON_PLAY_COMPLETED)));
        return;
    L3:
        if (Logger.debugScene(this.downloadInfo) == false) goto L21;
        Logger.taskDebug(TAG, this.downloadInfo, "onSaveTempFileSuccess", "Success");     // Catch: Throwable -> L17
    L21:
        downloadCompleteProcess();     // Catch: BaseException -> L14 Throwable -> L17
        DownloadInfo r100 = this.downloadInfo;     // Catch: Throwable -> L17
        if (r100 != null) goto L10;
        onError(new BaseException(1087, "onSaveTempFileSuccess DownloadInfo is null"));     // Catch: Throwable -> L17
        return;
    L10:
        r100.setFirstSuccess(false);     // Catch: Throwable -> L17
        this.downloadInfo.setSuccessByCache(false);     // Catch: Throwable -> L17
        if (this.downloadInfo.getDownloadFinishTimeStamp() > 0) goto L13;
        this.downloadInfo.setDownloadFinishTimeStamp(System.currentTimeMillis());     // Catch: Throwable -> L17
    L13:
        onStatusChanged(-3, null);     // Catch: Throwable -> L17
        this.downloadCache.OnDownloadTaskCompleted(this.downloadInfo.getId(), this.downloadInfo.getTotalBytes());     // Catch: Throwable -> L17
        this.downloadCache.removeSegments(this.downloadInfo.getId());     // Catch: Throwable -> L17
        return;
    L14:
        e = move-exception;
        onError(e);     // Catch: Throwable -> L17
    }

    public void onStart() {
        DownloadTimingInfo r100 = this.downloadTask.getTimingInfo();
        r100.beforeOnStartTime = System.currentTimeMillis();
        if (this.downloadInfo.canSkipStatusHandler() == false) goto L6;
        this.downloadInfo.changeSkipStatus();
    L12:
        DownloadTimingInfo r101 = this.downloadTask.getTimingInfo();
        r101.afterOnStartTime = System.currentTimeMillis();
        return;
    L6:
        if (this.downloadInfo.getDownloadStartTimeStamp() > 0) goto L8;
        this.downloadInfo.setDownloadStartTimeStamp(System.currentTimeMillis());
    L8:
        this.downloadCache.onDownloadTaskStart(this.downloadInfo.getId());
        if (this.downloadInfo.isFirstDownload() == false) goto L11;
        onStatusChanged(6, null);
    L11:
        onStatusChanged(2, null);
        goto L12
    }

    public void onPrepare() {
        this.prepareDownloadTime = System.currentTimeMillis();
        if (this.downloadInfo.canSkipStatusHandler() == false) goto L5;
        return;
    L5:
        this.downloadInfo.setStatus(1);
    }

    private void handleError(BaseException r100) {
        String r101 = TAG;
        Logger.taskError(r101, this.downloadInfo.getId(), "handleError", "Exception:" + r100);
        if (Logger.debug() == false) goto L5;
        Logger.taskError(r101, this.downloadInfo.getId(), "handleError", "Exception Trace:" + Log.getStackTraceString(new Throwable()));
    L5:
        if (r100 != null) goto L7;
    L28:
        this.downloadCache.OnDownloadTaskError(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());     // Catch: SQLiteException -> L16
    L20:
        BaseException r102 = reviseFailedException(r100);
        this.downloadInfo.setFailedException(r102);
        if ((r102 instanceof DownloadPauseReserveWifiException) == false) goto L23;
        int r103 = -2;
    L24:
        onStatusChanged(r103, r102);
        if (DownloadSetting.obtain(this.downloadInfo.getId()).optInt(DownloadSettingKeys.RETRY_SCHEDULE, 0) <= 0) goto L33;
        RetryScheduler.getInstance().tryStartScheduleRetry(this.downloadInfo);
        return;
    L33:
        return;
    L23:
        r103 = -1;
    L16:
        this.downloadCache.removeDownloadTaskData(this.downloadInfo.getId());     // Catch: SQLiteException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L7:
        if (r100.getCause() == null) goto L28;
        if ((r100.getCause() instanceof SQLiteFullException) == false) goto L28;
        this.downloadCache.removeDownloadTaskData(this.downloadInfo.getId());     // Catch: SQLiteException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    private void handleRetry(BaseException r100) {
        this.downloadCache.OnDownloadTaskRetry(this.downloadInfo.getId());
        onStatusChanged(5, r100);
    }

    private boolean needSyncProgress(long r100) {
        boolean r101 = true;
        if (this.hasSyncProgressBefore == true) goto L6;
        this.hasSyncProgressBefore = true;
        return true;
    L6:
        long r102 = r100 - this.lastSyncProgressTime;
        if (this.msgPostDataBuffer.get() < this.minByteIntervalForSyncProgress) goto L9;
    L12:
        if (r101 == false) goto L14;
        this.lastSyncProgressTime = r100;
        this.msgPostDataBuffer.set(0);
    L14:
        return r101;
    L9:
        if (r102 >= this.minTimeIntervalForSyncProgress) goto L12;
        r101 = false;
        goto L12
    }

    private BaseException reviseFailedException(BaseException r100) {
        if (DownloadSetting.obtain(this.downloadInfo.getId()).optInt(DownloadSettingKeys.DOWNLOAD_FAILED_CHECK_NET, 1) == 1) goto L5;
    L14:
        return r100;
    L5:
        if (DownloadUtils.isNetworkError(r100) == false) goto L14;
        Context r101 = DownloadComponentManager.getAppContext();
        if (r101 == null) goto L14;
        if (DownloadUtils.isNetworkConnected(r101) == true) goto L14;
        if (DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.DISABLE_CHECK_NO_NETWORK) == true) goto L14;
        return new BaseException(1049, r100.getErrorMessage());
    }

    public void onError(BaseException r100) {
        this.downloadInfo.setFirstDownload(false);
        handleError(r100);
    }

    public boolean onProgress(long r100) {
        this.msgPostDataBuffer.addAndGet(r100);
        this.downloadInfo.increaseCurBytes(r100);
        long r101 = SystemClock.uptimeMillis();
        return handleProgress(r101, needSyncProgress(r101));
    }

    public void onReceiveHeader(List<Pair<String, String>> r100) {
        DownloadListenerUtils.notifyReceiveHeader(this.subThreadListeners, this.downloadInfo, r100);
    }

    public void onReceiveRequestLog(String r100) {
        DownloadListenerUtils.notifyReceiveRequestLog(this.subThreadListeners, this.downloadInfo, r100);
    }

    public void onRetry(BaseException r100) {
        this.downloadInfo.setFirstDownload(false);
        this.msgPostDataBuffer.set(0);
        handleRetry(r100);
    }

    public DownloadStatusHandler(DownloadTask r100, Handler r101) {
        boolean r102 = false;
        this.forceRefreshProcess = false;
        this.lastSyncProgressTime = 0;
        this.msgPostDataBuffer = new AtomicLong();
        this.hasSyncProgressBefore = false;
        this.downloadTask = r100;
        this.downloadInfo = r100.getDownloadInfo();
        this.mainThreadListeners = r100.getDownloadListeners(ListenerType.MAIN);
        this.notificationListeners = r100.getDownloadListeners(ListenerType.NOTIFICATION);
        this.subThreadListeners = r100.getDownloadListeners(ListenerType.SUB);
        this.downloadMonitorDepend = r100.getMonitorDepend();
        this.mainThreadHandler = r101;
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        boolean r103 = this.downloadInfo.isFastDownload();
        this.isFastDownload = r103;
        if (r103 == false) goto L8;
        IDownloadCache r104 = this.downloadCache;
        if ((r104 instanceof DefaultDownloadCache) == false) goto L8;
        this.downloadCache = ((DefaultDownloadCache) r104).getDownloadCache();
    L8:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_ANR_PROGRESS_HANDLE_MSG) <= 0) goto L10;
        boolean r105 = true;
    L11:
        this.fixAnrProcessHandleMsg = r105;
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_SAME_TASK_MONITOR_REPORT) <= 0) goto L14;
        boolean r106 = true;
    L15:
        this.fixSameTaskMonitorReport = r106;
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.REMOVE_USELESS_MONITOR_REPORT) <= 0) goto L18;
        r102 = true;
    L18:
        this.mRemoveUselessReport = r102;
        return;
    L14:
        r106 = false;
        goto L15
    L10:
        r105 = false;
        goto L11
    }

    private boolean handleProgress(long r100, boolean r101) {
        boolean r102 = false;
        if (this.downloadInfo.getCurBytes() != this.downloadInfo.getTotalBytes()) goto L10;
        this.downloadCache.OnDownloadTaskProgress(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());     // Catch: Exception -> L6
    L8:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    L10:
        if (this.forceRefreshProcess == false) goto L13;
        this.forceRefreshProcess = false;
        this.downloadInfo.setStatus(4);
    L13:
        if (this.downloadInfo.isNeedPostProgress() == false) goto L16;
        if (r101 == false) goto L16;
        r102 = true;
    L16:
        onStatusChanged(4, null, r102);
        return r101;
    }

    private void onStatusChanged(int r100, BaseException r101) {
        if (this.isFastDownload == true) goto L5;
    L12:
        onStatusChanged(r100, r101, true);
        return;
    L5:
        if (r100 != 1) goto L7;
    L9:
        if (r100 != 2) goto L14;
        this.downloadInfo.setStatus(r100);
        DownloadMonitorHelper.monitorSend(this.downloadTask, r101, r100);
        return;
    L14:
        return;
    L7:
        if (r100 == 6) goto L9;
        if (r100 != 2) goto L12;
        goto L9
    }

    public void onCompleteForFileExist(String r100, String r101) throws BaseException {
        if (Logger.debugScene(this.downloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.downloadInfo, "onCompleteForFileExist", "ExistTargetFileName:" + r101 + " but curName is " + this.downloadInfo.getName());
    L5:
        DownloadHelper.copyFileFromExistFileWithSameName(this.downloadInfo, r100, r101);
        downloadCompleteProcess();
        this.downloadInfo.setSuccessByCache(true);
        onStatusChanged(-3, null);
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
    }

    public void onReceiveData(byte[] r100, int r101) {
        DownloadListenerUtils.notifyReceiveData(this.subThreadListeners, this.downloadInfo, r100, r101);
    }

    private void notifyDownloadTaskStatus(AbsDownloadEngine r110, final int r111, final BaseException r112) {
        final DownloadTask r100 = r110.getDownloadTask(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask());
        if (r100 != null) goto L6;
        Logger.taskError(TAG, this.downloadInfo.getId(), "notifyDownloadTaskStatus", "DownloadTask is null");
        return;
    L6:
        final DownloadInfo r101 = r100.getDownloadInfo();
        if (r101 != null) goto L10;
        Logger.taskError(TAG, this.downloadInfo.getId(), "notifyDownloadTaskStatus", "DownloadInfo is null");
        return;
    L10:
        final Map<Integer, IDownloadListener> r102 = r100.getDownloadListeners(ListenerType.MAIN);
        final Map<Integer, IDownloadListener> r103 = r100.getDownloadListeners(ListenerType.NOTIFICATION);
        if (r100.canShowNotification() == false) goto L13;
    L16:
        final boolean r113 = true;
    L17:
        this.mainThreadHandler.post(new AnonymousClass1(this, r111, r102, r101, r112, r100, r103, r113));
        r110.refreshDownloadTaskMap(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), r111);
        return;
    L13:
        if (r101.isAutoInstallWithoutNotification() == true) goto L16;
        r113 = false;
        goto L17
    }

    private void onStatusChanged(int r110, BaseException r111, boolean r112) {
        int r100 = this.downloadInfo.getStatus();
        if (r100 != (-3)) goto L10;
        if (r110 != 4) goto L10;
        if (Logger.debugScene(this.downloadInfo) == false) goto L65;
        Logger.taskDebug(TAG, this.downloadInfo, "onStatusChanged", "Status = " + r100 + ", monitorStatus = " + r110);
        return;
    L65:
        return;
    L10:
        if (r110 != 4) goto L12;
    L24:
        if (r110 != 6) goto L27;
        this.downloadInfo.setStatus(2);
    L30:
        if (r100 == (-3)) goto L34;
        if (r100 == (-1)) goto L34;
    L39:
        DownloadListenerUtils.notifyListener(r110, this.subThreadListeners, true, this.downloadInfo, r111, ListenerType.SUB, this.downloadTask);
        if (r110 != (-4)) goto L42;
        return;
    L42:
        if (r112 == true) goto L44;
    L61:
        AbsDownloadEngine r113 = DownloadComponentManager.getDownloadEngine();
        if (r113 == null) goto L68;
        r113.refreshDownloadTaskMap(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), r110);
        return;
    L68:
        return;
    L44:
        if (this.mainThreadHandler == null) goto L61;
        Map<Integer, IDownloadListener> r114 = this.mainThreadListeners;
        if (r114 != null) goto L48;
    L49:
        Map<Integer, IDownloadListener> r115 = this.notificationListeners;
        if (r115 == null) goto L61;
        if (r115.size() <= 0) goto L61;
        if (this.downloadInfo.canShowNotification() == false) goto L56;
    L58:
        if (this.fixAnrProcessHandleMsg == false) goto L60;
        notifyDownloadTaskStatus(DownloadComponentManager.getDownloadEngine(), r110, r111);
        return;
    L60:
        this.mainThreadHandler.obtainMessage(r110, this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), r111).sendToTarget();
        return;
    L56:
        if (this.downloadInfo.isAutoInstallWithoutNotification() == false) goto L61;
    L48:
        if (r114.size() > 0) goto L58;
    L34:
        if (this.downloadInfo.getAsyncHandleStatus() != AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADING) goto L37;
        this.downloadInfo.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADED);
    L37:
        if (this.downloadInfo.getByteInvalidRetryStatus() != ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) goto L39;
        this.downloadInfo.setByteInvalidRetryStatus(ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
        goto L39
    L27:
        if (r110 != (-6)) goto L29;
        this.downloadInfo.setStatus(-3);
        goto L30
    L29:
        this.downloadInfo.setStatus(r110);
        goto L30
    L12:
        if (DownloadStatus.isRealTimeUploadStatus(r110) == false) goto L17;
        this.downloadInfo.updateRealDownloadTime(false);
        if (DownloadStatus.isTimeUploadStatus(r110) == false) goto L17;
        this.downloadInfo.updateDownloadTime();
    L17:
        if (this.downloadInfo.isAddListenerToSameTask() == false) goto L21;
        if (this.fixSameTaskMonitorReport == false) goto L24;
    L21:
        if (this.mRemoveUselessReport == false) goto L23;
        if (r110 == 6) goto L24;
    L23:
        DownloadMonitorHelper.monitorSend(this.downloadTask, r111, r110);
        goto L24
    }

    public void onFirstConnectionSuccessed(long r100, String r110, String r111) {
        this.downloadInfo.setTotalBytes(r100);
        this.downloadInfo.seteTag(r110);
        if (TextUtils.isEmpty(r111) == false) goto L5;
    L13:
        this.downloadCache.OnDownloadTaskConnected(this.downloadInfo.getId(), r100, r110, r111);     // Catch: Exception -> L9
    L11:
        onStatusChanged(3, null);
        this.minByteIntervalForSyncProgress = this.downloadInfo.getMinByteIntervalForPostToMainThread(r100);
        this.minTimeIntervalForSyncProgress = this.downloadInfo.getMinProgressTimeMsInterval();
        this.forceRefreshProcess = true;
        RetryScheduler.getInstance().scheduleRetryWhenHasTaskConnected();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L5:
        if (TextUtils.isEmpty(this.downloadInfo.getName()) == false) goto L13;
        this.downloadInfo.setName(r111);
        goto L13
    }

    public void onReceiveSegmentData(long r100, byte[] r101, int r110) {
        DownloadListenerUtils.notifyReceiveSegmentData(this.subThreadListeners, this.downloadInfo, r100, r101, r110);
    }
}
