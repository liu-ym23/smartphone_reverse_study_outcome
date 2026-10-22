package com.ss.android.socialbase.downloader.impls;

import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ProcessDownloadHandler implements IDownloadProxy {
    private static final String TAG = "ProcessDownloadHandler";
    private final IDownloadCache downloadCache;
    private final AbsDownloadEngine downloadEngine;
    private final IDownloadServiceHandler downloadServiceHandler;
    private final boolean enableSingleThread;

    public ProcessDownloadHandler() {
        this(false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startService() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearData() {
        this.downloadCache.clearData();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getAllDownloadInfo() {
        IDownloadCache r100 = this.downloadCache;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadCacheSyncSuccess() {
        return this.downloadCache.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceAlive() {
        IDownloadServiceHandler r100 = this.downloadServiceHandler;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isServiceAlive() == false) goto L7;
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pauseAll() {
        runInSingleThread(new AnonymousClass5(this));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isHttpServiceInit() {
        return DownloadComponentManager.isHttpServiceInit();
    }

    public ProcessDownloadHandler(boolean r100) {
        this.downloadEngine = DownloadComponentManager.getDownloadEngine();
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        if (r100 == true) goto L5;
        this.downloadServiceHandler = DownloadComponentManager.getDownloadServiceHandler();
    L7:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SINGLE_ASYNC_HANDLE_OPERATION) <= 0) goto L9;
        boolean r101 = true;
    L10:
        this.enableSingleThread = r101;
        return;
    L9:
        r101 = false;
        goto L10
    L5:
        this.downloadServiceHandler = DownloadComponentManager.getIndependentDownloadServiceHandler();
        goto L7
    }

    public static /* synthetic */ AbsDownloadEngine access$000(ProcessDownloadHandler r100) {
        return r100.downloadEngine;
    }

    public static /* synthetic */ IDownloadServiceHandler access$100(ProcessDownloadHandler r100) {
        return r100.downloadServiceHandler;
    }

    private void runInSingleThread(Runnable r100) {
        if (this.enableSingleThread == false) goto L5;
        DownloadComponentManager.submitSingleTask(r100);
        return;
    L5:
        r100.run();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addProcessCallback(ProcessCallback r100) {
        DownloadComponentManager.addProcessCallback(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean canResume(int r100) {
        AbsDownloadEngine r101 = this.downloadEngine;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.isInDownloadTaskPool(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public long getCurBytes(int r100) {
        IDownloadCache r101 = this.downloadCache;
        if (r101 != null) goto L5;
        return 0;
    L5:
        DownloadInfo r102 = r101.getDownloadInfo(r100);
        if (r102 != null) goto L9;
        return 0;
    L9:
        return r102.getCurBytes();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadFileUriProvider getDownloadFileUriProvider(int r100) {
        return this.downloadEngine.getDownloadFileUriProvider(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(int r100) {
        return this.downloadEngine.getDownloadInfo(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfoList(String r100) {
        return this.downloadEngine.getDownloadInfoList(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r100) {
        return this.downloadCache.getDownloadInfosByFileExtension(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r100) {
        return this.downloadCache.getDownloadInfosByMonitorScene(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosBySavePath(String r100) {
        IDownloadCache r101 = this.downloadCache;
        if (r101 != null) goto L5;
    L14:
        return null;
    L5:
        if ((r101 instanceof DefaultDownloadCache) == false) goto L14;
        ISqlDownloadCache r102 = ((DefaultDownloadCache) r101).getSqlDownloadCache();
        if (r102 == null) goto L14;
        if ((r102 instanceof SqlDownloadCache) == false) goto L14;
        return ((SqlDownloadCache) r102).getDownloadInfosBySavePath(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int r100) {
        return this.downloadEngine.getDownloadNotificationEventListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadWithIndependentProcessStatus(int r100) {
        return DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatus(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r100) {
        return this.downloadEngine.getDownloadingDownloadInfosWithMimeType(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String r100) {
        IDownloadCache r101 = this.downloadCache;
        if (r101 != null) goto L5;
    L14:
        return null;
    L5:
        if ((r101 instanceof DefaultDownloadCache) == false) goto L14;
        ISqlDownloadCache r102 = ((DefaultDownloadCache) r101).getSqlDownloadCache();
        if (r102 == null) goto L14;
        if ((r102 instanceof SqlDownloadCache) == false) goto L14;
        return ((SqlDownloadCache) r102).getInstalledTimeStampBySavePath(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public INotificationClickCallback getNotificationClickCallback(int r100) {
        INotificationClickCallback r101 = this.downloadEngine.getNotificationClickCallback(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return DownloadComponentManager.getNotificationClickCallback();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getStatus(int r100) {
        DownloadInfo r101 = this.downloadEngine.getDownloadInfo(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r100) {
        return this.downloadCache.getSuccessedDownloadInfosWithMimeType(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r100) {
        return this.downloadCache.getUnCompletedDownloadInfosWithMimeType(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = DownloadUtils.isDownloadSuccessAndFileNotExist(r100.getStatus(), r100.getSavePath(), r100.getName());
        if (r101 == false) goto L8;
        resetDownloadData(r100.getId(), true);
    L8:
        return r101;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloading(int r100) {
        return this.downloadEngine.isDownloading(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadInfo(int r100) {
        return this.downloadCache.removeDownloadInfo(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadTaskData(int r100) {
        return this.downloadCache.removeDownloadTaskData(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restart(final int r100) {
        runInSingleThread(new AnonymousClass4(this, r100));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllFailedDownloadTasks(final List<String> r100) {
        runInSingleThread(new AnonymousClass6(this, r100));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllPauseReserveOnWifiDownloadTasks(final List<String> r100) {
        runInSingleThread(new AnonymousClass7(this, r100));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resume(final int r100) {
        runInSingleThread(new AnonymousClass3(this, r100));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setLogLevel(int r100) {
        Logger.setLogLevel(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfo(DownloadInfo r100) {
        this.downloadCache.syncDownloadInfo(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfoFromOtherCache(int r100) {
        this.downloadCache.syncDownloadInfoFromOtherCache(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownload(final DownloadTask r100) {
        DownloadComponentManager.updateCurrentDownloadThreadInfo(r100, true);
        runInSingleThread(new AnonymousClass10(this, r100));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownloadWithEngine(final DownloadTask r100) {
        DownloadComponentManager.updateCurrentDownloadThreadInfo(r100, true);
        runInSingleThread(new AnonymousClass11(this, r100));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean updateDownloadInfo(DownloadInfo r100) {
        return this.downloadCache.updateDownloadInfo(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void cancel(final int r100, final boolean r101) {
        runInSingleThread(new AnonymousClass2(this, r100, r101));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void dispatchProcessCallback(int r100, int r101) {
        if (DownloadComponentManager.getProcessCallbacks() == null) goto L10;
        Iterator<ProcessCallback> r102 = DownloadComponentManager.getProcessCallbacks().iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        ProcessCallback r103 = r102.next();
        if (r103 == null) goto L6;
        r103.callback(r101, r100);
        goto L6
    L16:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadId(String r100, String r101) {
        return DownloadComponentManager.getDownloadId(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(String r100, String r101) {
        return getDownloadInfo(DownloadComponentManager.getDownloadId(r100, r101));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosByFilters(String r100, String r101) {
        IDownloadCache r102 = this.downloadCache;
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.getDownloadInfosByFilters(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pause(final int r100, boolean r101) {
        Runnable r102 = new AnonymousClass1(this, r100);
        if (r101 == false) goto L5;
        r102.run();
        return;
    L5:
        runInSingleThread(r102);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resetDownloadData(final int r100, final boolean r101) {
        runInSingleThread(new AnonymousClass9(this, r100, r101));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadNotificationEventListener(int r100, IDownloadNotificationEventListener r101) {
        this.downloadEngine.setDownloadNotificationEventListener(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadWithIndependentProcessStatus(int r100, boolean r101) {
        DownloadProcessDispatcher.getInstance().setDownloadWithIndependentProcessStatus(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearDownloadData(final int r100, final boolean r101, final boolean r102) {
        runInSingleThread(new AnonymousClass8(this, r100, r101, r102));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setThrottleNetSpeed(final int r100, final long r101, final int r110) {
        runInSingleThread(new AnonymousClass12(this, r100, r101, r110));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int r100, int r101, IDownloadListener r102, ListenerType r110, boolean r111) {
        this.downloadEngine.addDownloadListener(r100, r101, r102, r110, r111);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeDownloadListener(int r100, int r101, IDownloadListener r102, ListenerType r110, boolean r111) {
        this.downloadEngine.removeDownloadListener(r100, r101, r102, r110, r111);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int r100, int r101, IDownloadListener r110, ListenerType r111, boolean r112, boolean r113) {
        this.downloadEngine.addDownloadListener(r100, r101, r110, r111, r112, r113);
    }
}
