package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.util.Pair;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.cleaner.Cleaner;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadProcessDispatcher {
    private static volatile DownloadProcessDispatcher instance;
    private volatile SparseArray<Boolean> independentMap;
    private volatile List<IDownloaderProcessConnectedListener> processConnectedListeners;

    public List<DownloadInfo> getAllDownloadInfo() {
        IDownloadProxy r100 = DownloadProxy.get(false);
        List<DownloadInfo> r101 = null;
        if (r100 == null) goto L5;
        List<DownloadInfo> r102 = r100.getAllDownloadInfo();
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L12;
        IDownloadProxy r103 = DownloadProxy.get(true);
        if (r103 == null) goto L12;
        r101 = r103.getAllDownloadInfo();
    L12:
        return handleDownloadInfos(r102, r101);
    L5:
        r102 = null;
        goto L7
    }

    public boolean isDownloadCacheSyncSuccess() {
        IDownloadProxy r100 = DownloadProxy.get(false);
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isDownloadCacheSyncSuccess();
    }

    public void pauseAll() {
        IDownloadProxy r100 = DownloadProxy.get(false);
        if (r100 == null) goto L6;
        r100.pauseAll();
    L6:
        if (DownloadUtils.optimizeMultiProcess() == false) goto L8;
        return;
    L8:
        IDownloadProxy r101 = DownloadProxy.get(true);
        if (r101 == null) goto L12;
        r101.pauseAll();
        return;
    }

    public static DownloadProcessDispatcher getInstance() {
        if (instance != null) goto L13;
        monitor-enter(DownloadProcessDispatcher.class);
        instance = new DownloadProcessDispatcher();     // Catch: Throwable -> L9
        monitor-exit(DownloadProcessDispatcher.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return instance;
    }

    public void dispatchDownloaderProcessConnectedEvent() {
        List<IDownloaderProcessConnectedListener> r100 = this.processConnectedListeners;
        monitor-enter(r100);
        Iterator<IDownloaderProcessConnectedListener> r101 = this.processConnectedListeners.iterator();     // Catch: Throwable -> L12
    L6:
        if (r101.hasNext() == false) goto L10;
        IDownloaderProcessConnectedListener r102 = r101.next();     // Catch: Throwable -> L12
        if (r102 == null) goto L6;
        r102.onConnected();     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public DownloadProcessDispatcher() {
        this.independentMap = new SparseArray();
        this.processConnectedListeners = new ArrayList();
    }

    public boolean isHttpServiceInit() {
        return DownloadComponentManager.isHttpServiceInit();
    }

    private IDownloadProxy getDownloadHandler(DownloadTask r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        DownloadInfo r101 = r100.getDownloadInfo();
        if (r101 != null) goto L8;
        return null;
    L8:
        boolean r102 = false;
        if (r101.isFastDownload() == true) goto L45;
        if (r101.isNeedCurrentProcess() == true) goto L45;
        if (DownloadUtils.optimizeMultiProcess() == true) goto L45;
        boolean r103 = r101.isNeedIndependentProcess();
        if (DownloadHelper.isDownloaderProcess() == false) goto L18;
    L19:
        r103 = true;
    L20:
        int r104 = getDownloadWithIndependentProcessStatus(r101.getId());
        if (r104 < 0) goto L35;
        if (r104 == r103) goto L35;
        if (r104 != 1) goto L30;
        if (DownloadHelper.isMainProcess() == false) goto L46;
        DownloadProxy.get(true).pause(r101.getId(), true);     // Catch: Throwable -> L34
        DownloadInfo r105 = DownloadProxy.get(true).getDownloadInfo(r101.getId());     // Catch: Throwable -> L34
        if (r105 == null) goto L46;
        DownloadProxy.get(false).syncDownloadInfo(r105);     // Catch: Throwable -> L34
    L46:
        goto L35
    L30:
        if (DownloadHelper.isMainProcess() == false) goto L32;
        DownloadProxy.get(false).pause(r101.getId(), true);     // Catch: Throwable -> L34
        goto L46
    L32:
        r100.setNeedDelayForCacheSync(true);     // Catch: Throwable -> L34
        DownloadProxy.get(true).dispatchProcessCallback(1, r101.getId());     // Catch: Throwable -> L34
    L35:
        int r106 = r101.getId();
        if (r103 != true) goto L38;
        boolean r107 = true;
    L39:
        setDownloadWithIndependentProcessStatus(r106, r107);
        if (r103 != true) goto L43;
        r102 = true;
    L43:
        return DownloadProxy.get(r102);
    L38:
        r107 = false;
        goto L39
    L18:
        if (DownloadHelper.isMainProcess() == true) goto L20;
    L45:
        return DownloadProxy.get(false);
    }

    public boolean canResume(int r100) {
        IDownloadProxy r101 = getDownloadHandler(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.canResume(r100);
    }

    public long getCurBytes(int r100) {
        IDownloadProxy r101 = getDownloadHandler(r100);
        if (r101 != null) goto L5;
        return 0;
    L5:
        if (Cleaner.getInstance().isExistInCleanSet(r100) == false) goto L8;
        return 0;
    L8:
        return r101.getCurBytes(r100);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int r100) {
        IDownloadProxy r101 = getDownloadHandler(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getDownloadFileUriProvider(r100);
    }

    public DownloadInfo getDownloadInfo(int r100) {
        IDownloadProxy r101 = getDownloadHandler(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if (Cleaner.getInstance().isExistInCleanSet(r100) == false) goto L9;
        return null;
    L9:
        return r101.getDownloadInfo(r100);
    }

    public List<DownloadInfo> getDownloadInfoList(String r100) {
        List<DownloadInfo> r101 = DownloadProxy.get(false).getDownloadInfoList(r100);
        if (DownloadUtils.optimizeMultiProcess() == true) goto L5;
        List<DownloadInfo> r102 = DownloadProxy.get(true).getDownloadInfoList(r100);
    L6:
        if (r101 != null) goto L9;
        if (r102 != null) goto L9;
        return null;
    L9:
        if (r101 == null) goto L16;
        Iterator<DownloadInfo> r103 = r101.iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        if (Cleaner.getInstance().isExistInCleanSet(r103.next().getId()) == false) goto L12;
        r103.remove();
    L16:
        if (r102 == null) goto L24;
        Iterator<DownloadInfo> r104 = r102.iterator();
    L19:
        if (r104.hasNext() == false) goto L24;
        if (Cleaner.getInstance().isExistInCleanSet(r104.next().getId()) == false) goto L19;
        r104.remove();
    L24:
        return handleDownloadInfos(r101, r102);
    L5:
        r102 = null;
        goto L6
    }

    public List<DownloadInfo> getDownloadInfosByFileExtension(String r100) {
        IDownloadProxy r101 = DownloadProxy.get(false);
        List<DownloadInfo> r102 = null;
        if (r101 == null) goto L5;
        List<DownloadInfo> r103 = r101.getDownloadInfosByFileExtension(r100);
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L12;
        IDownloadProxy r104 = DownloadProxy.get(true);
        if (r104 == null) goto L12;
        r102 = r104.getDownloadInfosByFileExtension(r100);
    L12:
        return handleDownloadInfos(r103, r102);
    L5:
        r103 = null;
        goto L7
    }

    public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r100) {
        IDownloadProxy r101 = DownloadProxy.get(false);
        List<DownloadInfo> r102 = null;
        if (r101 == null) goto L5;
        List<DownloadInfo> r103 = r101.getDownloadInfosByMonitorScene(r100);
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L12;
        IDownloadProxy r104 = DownloadProxy.get(true);
        if (r104 == null) goto L12;
        r102 = r104.getDownloadInfosByMonitorScene(r100);
    L12:
        return handleDownloadInfos(r103, r102);
    L5:
        r103 = null;
        goto L7
    }

    public List<DownloadInfo> getDownloadInfosBySavePath(String r100) {
        IDownloadProxy r101 = DownloadProxy.get(false);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getDownloadInfosBySavePath(r100);
    }

    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int r100) {
        IDownloadProxy r101 = getDownloadHandler(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getDownloadNotificationEventListener(r100);
    }

    public int getDownloadWithIndependentProcessStatus(int r100) {
        if (DownloadComponentManager.supportMultiProc() == true) goto L5;
        return -1;
    L5:
        if (DownloadUtils.optimizeMultiProcess() == false) goto L8;
        return -1;
    L8:
        if (DownloadHelper.isDownloaderProcess() == true) goto L14;
        if (DownloadProxy.get(true).isServiceAlive() == false) goto L14;
        return DownloadProxy.get(true).getDownloadWithIndependentProcessStatus(r100);
    L14:
        return getDownloadWithIndependentProcessStatusInner(r100);
    }

    public synchronized int getDownloadWithIndependentProcessStatusInner(int r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.independentMap.get(r100) != null) goto L8;
        monitor-exit(this);
        return -1;
    L8:
        boolean r101 = this.independentMap.get(r100).booleanValue();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101 ? 1 : 0;
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r100) {
        IDownloadProxy r101 = DownloadProxy.get(false);
        List<DownloadInfo> r102 = null;
        if (r101 == null) goto L5;
        List<DownloadInfo> r103 = r101.getDownloadingDownloadInfosWithMimeType(r100);
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L12;
        IDownloadProxy r104 = DownloadProxy.get(true);
        if (r104 == null) goto L12;
        r102 = r104.getDownloadingDownloadInfosWithMimeType(r100);
    L12:
        return handleDownloadInfos(r103, r102);
    L5:
        r103 = null;
        goto L7
    }

    public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String r100) {
        IDownloadProxy r101 = DownloadProxy.get(false);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getInstalledTimeStampBySavePath(r100);
    }

    public INotificationClickCallback getNotificationClickCallback(int r100) {
        IDownloadProxy r101 = getDownloadHandler(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getNotificationClickCallback(r100);
    }

    public int getStatus(int r100) {
        IDownloadProxy r101 = getDownloadHandler(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getStatus(r100);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r100) {
        IDownloadProxy r101 = DownloadProxy.get(false);
        List<DownloadInfo> r102 = null;
        if (r101 == null) goto L5;
        List<DownloadInfo> r103 = r101.getSuccessedDownloadInfosWithMimeType(r100);
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L12;
        IDownloadProxy r104 = DownloadProxy.get(true);
        if (r104 == null) goto L12;
        r102 = r104.getSuccessedDownloadInfosWithMimeType(r100);
    L12:
        return handleDownloadInfos(r103, r102);
    L5:
        r103 = null;
        goto L7
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r100) {
        IDownloadProxy r101 = DownloadProxy.get(false);
        List<DownloadInfo> r102 = null;
        if (r101 == null) goto L5;
        List<DownloadInfo> r103 = r101.getUnCompletedDownloadInfosWithMimeType(r100);
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L12;
        IDownloadProxy r104 = DownloadProxy.get(true);
        if (r104 == null) goto L12;
        r102 = r104.getUnCompletedDownloadInfosWithMimeType(r100);
    L12:
        return handleDownloadInfos(r103, r102);
    L5:
        r103 = null;
        goto L7
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        IDownloadProxy r101 = getDownloadHandler(r100.getId());
        if (r101 != null) goto L9;
        return false;
    L9:
        return r101.isDownloadSuccessAndFileNotExist(r100);
    }

    public boolean isDownloading(int r100) {
        IDownloadProxy r101 = getDownloadHandler(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isDownloading(r100);
    }

    public void pause(int r100) {
        IDownloadProxy r101 = getDownloadHandler(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        r101.pause(r100, false);
    }

    public void recordTaskProcessIndependent(int r100) {
        if (r100 != 0) goto L4;
        return;
    L4:
        setDownloadIndependentProcessStatus(r100, true);
        IDownloadProxy r101 = DownloadProxy.get(true);
        if (r101 != null) goto L7;
        return;
    L7:
        r101.startService();
    }

    public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r100) {
        DownloadComponentManager.registerDownloadCacheSyncListener(r100);
    }

    public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (DownloadHelper.isDownloaderProcess() == false) goto L9;
        r100.onConnected();
        return;
    L9:
        if (DownloadProxy.get(true).isServiceAlive() == false) goto L11;
        r100.onConnected();
    L11:
        List<IDownloaderProcessConnectedListener> r101 = this.processConnectedListeners;
        monitor-enter(r101);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (this.processConnectedListeners.contains(r100) == true) goto L16;
        this.processConnectedListeners.add(r100);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L18
    }

    public void restart(int r100) {
        IDownloadProxy r101 = getDownloadHandler(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        r101.restart(r100);
    }

    public void restartAllFailedDownloadTasks(List<String> r100) {
        IDownloadProxy r101 = DownloadProxy.get(false);
        if (r101 == null) goto L6;
        r101.restartAllFailedDownloadTasks(r100);
    L6:
        if (DownloadUtils.optimizeMultiProcess() == false) goto L8;
        return;
    L8:
        IDownloadProxy r102 = DownloadProxy.get(true);
        if (r102 == null) goto L12;
        r102.restartAllFailedDownloadTasks(r100);
        return;
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r100) {
        IDownloadProxy r101 = DownloadProxy.get(false);
        if (r101 == null) goto L6;
        r101.restartAllPauseReserveOnWifiDownloadTasks(r100);
    L6:
        if (DownloadUtils.optimizeMultiProcess() == false) goto L8;
        return;
    L8:
        IDownloadProxy r102 = DownloadProxy.get(true);
        if (r102 == null) goto L12;
        r102.restartAllPauseReserveOnWifiDownloadTasks(r100);
        return;
    }

    public void resume(int r100) {
        IDownloadProxy r101 = getDownloadHandler(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        r101.resume(r100);
    }

    public void setLogLevel(int r100) {
        IDownloadProxy r101 = DownloadProxy.get(false);
        if (r101 == null) goto L6;
        r101.setLogLevel(r100);
    L6:
        if (DownloadUtils.optimizeMultiProcess() == false) goto L8;
        return;
    L8:
        IDownloadProxy r102 = DownloadProxy.get(true);
        if (r102 == null) goto L12;
        r102.setLogLevel(r100);
        return;
    }

    public void tryDownload(final DownloadTask r100) {
        final IDownloadProxy r101 = getDownloadHandler(r100);
        if (r101 != null) goto L11;
        if (r100 == null) goto L16;
        IDownloadMonitorDepend r102 = r100.getMonitorDepend();
        DownloadInfo r103 = r100.getDownloadInfo();
        BaseException r104 = new BaseException(1003, "tryDownload but getDownloadHandler failed");
        if (r100.getDownloadInfo() == null) goto L8;
        int r105 = r100.getDownloadInfo().getStatus();
    L9:
        DownloadMonitorHelper.monitorSendWithTaskMonitor(r102, r103, r104, r105);
        return;
    L8:
        r105 = 0;
        goto L9
    L16:
        return;
    L11:
        Cleaner.getInstance().removeFromCleanSet(r100.getDownloadId());
        if (r100.isNeedDelayForCacheSync() == false) goto L14;
        DownloadComponentManager.submitScheduleTask(new AnonymousClass1(this, r101, r100), 500, TimeUnit.MILLISECONDS);
        return;
    L14:
        r101.tryDownload(r100);
    }

    public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r100) {
        DownloadComponentManager.unRegisterDownloadCacheSyncListener(r100);
    }

    public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<IDownloaderProcessConnectedListener> r101 = this.processConnectedListeners;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.processConnectedListeners.contains(r100) == false) goto L9;
        this.processConnectedListeners.remove(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    public IDownloadProxy getDownloadHandler(int r100) {
        boolean r101 = true;
        if (getDownloadWithIndependentProcessStatus(r100) == 1) goto L5;
    L7:
        r101 = false;
    L9:
        return DownloadProxy.get(r101);
    L5:
        if (DownloadHelper.isDownloaderProcess() == true) goto L7;
        goto L7
    }

    private List<DownloadInfo> handleDownloadInfos(List<DownloadInfo> r100, List<DownloadInfo> r101) {
        SparseArray r102 = new SparseArray();
        ArrayList r103 = new ArrayList();
        if (r100 == null) goto L12;
        Iterator<DownloadInfo> r104 = r100.iterator();
    L6:
        if (r104.hasNext() == false) goto L12;
        DownloadInfo r105 = r104.next();
        if (r105 == null) goto L6;
        if (r102.get(r105.getId()) != null) goto L6;
        r102.put(r105.getId(), r105);
    L12:
        if (r101 == null) goto L21;
        Iterator<DownloadInfo> r106 = r101.iterator();
    L15:
        if (r106.hasNext() == false) goto L21;
        DownloadInfo r107 = r106.next();
        if (r107 == null) goto L15;
        if (r102.get(r107.getId()) != null) goto L15;
        r102.put(r107.getId(), r107);
    L21:
        int r108 = 0;
    L23:
        if (r108 >= r102.size()) goto L28;
        DownloadInfo r109 = (DownloadInfo) r102.get(r102.keyAt(r108));
        if (Cleaner.getInstance().isExistInCleanSet(r109.getId()) == true) goto L27;
        r103.add(r109);
    L27:
        r108 = r108 + 1;
        goto L23
    L28:
        return r103;
    }

    public void cancel(int r100, boolean r101) {
        if (DownloadHelper.isMainProcess() == true) goto L5;
        IDownloadProxy r102 = getDownloadHandler(r100);
        if (r102 == null) goto L15;
        r102.cancel(r100, r101);
    L15:
        DownloadProxy.get(true).dispatchProcessCallback(2, r100);
        return;
    L5:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L9;
        IDownloadProxy r103 = DownloadProxy.get(true);
        if (r103 == null) goto L9;
        r103.cancel(r100, r101);
    L9:
        IDownloadProxy r104 = DownloadProxy.get(false);
        if (r104 == null) goto L17;
        r104.cancel(r100, r101);
        return;
    }

    public void clearDownloadData(int r100, boolean r101) {
        IDownloadProxy r102 = getDownloadHandler(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        r102.clearDownloadData(r100, r101, true);
    }

    public int getDownloadId(String r100, String r101) {
        return DownloadComponentManager.getDownloadId(r100, r101);
    }

    public DownloadInfo getDownloadInfo(String r100, String r101) {
        int r102 = getDownloadId(r100, r101);
        if (Cleaner.getInstance().isExistInCleanSet(r102) == false) goto L5;
        return null;
    L5:
        IDownloadProxy r103 = getDownloadHandler(r102);
        if (r103 != null) goto L9;
        return null;
    L9:
        return r103.getDownloadInfo(r102);
    }

    public List<DownloadInfo> getDownloadInfosByFilters(String r100, String r101) {
        IDownloadProxy r102 = DownloadProxy.get(false);
        List<DownloadInfo> r103 = null;
        if (r102 == null) goto L5;
        List<DownloadInfo> r104 = r102.getDownloadInfosByFilters(r100, r101);
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L12;
        IDownloadProxy r105 = DownloadProxy.get(true);
        if (r105 == null) goto L12;
        r103 = r105.getDownloadInfosByFilters(r100, r101);
    L12:
        return handleDownloadInfos(r104, r103);
    L5:
        r104 = null;
        goto L7
    }

    public synchronized void setDownloadIndependentProcessStatus(int r100, boolean r101) {
        monitor-enter(this);
        SparseArray<Boolean> r102 = this.independentMap;     // Catch: Throwable -> L10
        if (r101 == false) goto L6;
        Boolean r103 = Boolean.TRUE;     // Catch: Throwable -> L10
    L7:
        r102.put(r100, r103);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r103 = Boolean.FALSE;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void setDownloadNotificationEventListener(int r100, IDownloadNotificationEventListener r101) {
        IDownloadProxy r102 = getDownloadHandler(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setDownloadNotificationEventListener(r100, r101);
    }

    public void setDownloadWithIndependentProcessStatus(int r100, boolean r101) {
        if (DownloadUtils.optimizeMultiProcess() == false) goto L5;
        return;
    L5:
        setDownloadIndependentProcessStatus(r100, r101);
        if (DownloadComponentManager.supportMultiProc() == false) goto L13;
        if (DownloadHelper.isDownloaderProcess() == true) goto L13;
        if (DownloadProxy.get(true).isServiceAlive() == false) goto L13;
        DownloadProxy.get(true).setDownloadWithIndependentProcessStatus(r100, r101);
    L13:
        if (DownloadComponentManager.isDownloadInMultiProcess() == false) goto L15;
        return;
    L15:
        if (DownloadHelper.isDownloaderProcess() == false) goto L17;
        return;
    L17:
        if (DownloadHelper.isMainProcess() == true) goto L27;
        Intent r102 = new Intent(DownloadComponentManager.getAppContext(), DownloadHandleService.class);     // Catch: Throwable -> L20
        r102.setAction(DownloadConstants.ACTION_DOWNLOAD_PROCESS_NOTIFY);     // Catch: Throwable -> L20
        r102.putExtra("extra_download_id", r100);     // Catch: Throwable -> L20
        DownloadComponentManager.getAppContext().startService(r102);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void setThrottleNetSpeed(int r100, long r101, int r102) {
        IDownloadProxy r103 = getDownloadHandler(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        r103.setThrottleNetSpeed(r100, r101, r102);
    }

    public void addDownloadListener(int r100, IDownloadListener r101, ListenerType r102, boolean r110) {
        IDownloadProxy r103 = getDownloadHandler(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        r103.addDownloadListener(r100, r101.hashCode(), r101, r102, r110);
    }

    public void removeDownloadListener(int r100, IDownloadListener r101, ListenerType r102, boolean r110) {
        IDownloadProxy r103 = getDownloadHandler(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        if (r101 != null) goto L7;
        int r104 = 0;
    L8:
        r103.removeDownloadListener(r100, r104, r101, r102, r110);
        return;
    L7:
        r104 = r101.hashCode();
        goto L8
    }

    public void addDownloadListener(int r100, IDownloadListener r101, ListenerType r110, boolean r111, boolean r112) {
        IDownloadProxy r102 = getDownloadHandler(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        r102.addDownloadListener(r100, r101.hashCode(), r101, r110, r111, r112);
    }
}
