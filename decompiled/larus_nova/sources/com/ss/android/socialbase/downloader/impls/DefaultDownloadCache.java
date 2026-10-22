package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.db.EmptySqlDownloadCache;
import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultDownloadCache implements IDownloadCache {
    private static final int MSG_RESUME = 1;
    private static final String TAG = "DefaultDownloadCache";
    private static AtomicBoolean isInitFinish;
    private static AtomicBoolean isRunInit;
    private WeakDownloadHandler.IHandler IHandler;
    private int bizCloseDBBatchInit;
    private final DownloadCache downloadCache;
    private volatile boolean hasInitSqlDownloadCache;
    private int loadDBWaitTime;
    private ThreadLocal<Boolean> mThreadDownloadCacheLoaded;
    private boolean mThreadLoadDownloadCacheOnlyOnce;
    private volatile ISqlDownloadCache sqlDownloadCache;
    private volatile boolean unCompleteTaskResumed;
    private WeakDownloadHandler weakHandler;

    static {
        isRunInit = new AtomicBoolean(false);
        isInitFinish = new AtomicBoolean(false);
    }

    private void initFinish() {
        if (isInitFinish.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        onDownloadCacheSyncSuccess();
        resumeUnCompleteTaskMayDelayed();
        DownloadComponentManager.onDownloadCacheSyncCallback(DownloadCacheSyncStatus.SYNC_SUCCESS);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        this.downloadCache.clearData();     // Catch: SQLiteException -> L4
    L7:
        if (DownloadHelper.needNotifyDownloaderProcess() == true) goto L9;
    L14:
        this.sqlDownloadCache.clearData();
        return;
    L9:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L14;
        IDownloadProxy r100 = DownloadProxy.get(true);
        if (r100 == null) goto L13;
        r100.clearData();
        return;
    L13:
        this.sqlDownloadCache.clearData();
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        if (this.hasInitSqlDownloadCache == false) goto L7;
        return true;
    L7:
        if (this.downloadCache.isActiveLoadDownloadCache() == false) goto L10;
        newEnsureDownloadCacheSyncSuccess();
        return this.hasInitSqlDownloadCache;
    L10:
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L12:
        if (this.hasInitSqlDownloadCache == false) goto L14;
    L26:
        monitor-exit(this);     // Catch: Throwable -> L29
        return this.hasInitSqlDownloadCache;
    L14:
        if (Logger.debug() == false) goto L17;
        Logger.globalDebug(TAG, "ensureDownloadCacheSyncSuccess", "Waiting start:" + this.loadDBWaitTime);     // Catch: Throwable -> L29
    L17:
        if (this.bizCloseDBBatchInit > 0) goto L19;
    L23:
        waitDBLoad(this);     // Catch: Throwable -> L29
        if (Logger.debug() == false) goto L26;
        Logger.globalDebug(TAG, "ensureDownloadCacheSyncSuccess", "Waiting end");     // Catch: Throwable -> L29
        goto L26
    L19:
        if (this.sqlDownloadCache == null) goto L23;
        if ((this.sqlDownloadCache instanceof SqlDownloadCache) == false) goto L23;
        ((SqlDownloadCache) this.sqlDownloadCache).resetNewBatchInit();     // Catch: Throwable -> L29
        goto L23
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        return this.downloadCache.getAllDownloadInfo();
    }

    public void resumeUnCompleteTask() {
        if (this.hasInitSqlDownloadCache == true) goto L6;
        return;
    L6:
        if (this.unCompleteTaskResumed == true) goto L8;
        this.unCompleteTaskResumed = true;
        if (DownloadHelper.isMainProcess() == true) goto L14;
        return;
    L14:
        IDownloadLaunchHandler r100 = DownloadComponentManager.getDownloadLaunchHandler();
        List<DownloadInfo> r101 = this.downloadCache.getAutoResumeList();
        if (r100 == null) goto L22;
        if (r101 != null) goto L18;
        return;
    L18:
        if (r101.isEmpty() == true) goto L24;
        r100.onLaunchResume(r101, 1);
        return;
    L24:
        return;
    L22:
        return;
    L8:
        if (Logger.debug() == false) goto L21;
        Logger.globalDebug(TAG, "resumeUnCompleteTask", "Has resumed, return");
        return;
    }

    public void resumeUnCompleteTaskMayDelayed() {
        Message r100 = this.weakHandler.obtainMessage(1);
        this.weakHandler.sendMessageDelayed(r100, 4000);
    }

    public void updateDownloadSpInfo() {
        if (this.hasInitSqlDownloadCache == true) goto L5;
        return;
    L5:
        final Context r100 = DownloadComponentManager.getAppContext();
        if (r100 != null) goto L8;
        return;
    L8:
        DownloadComponentManager.submitIOTask(new AnonymousClass7(this, r100));
    }

    public DefaultDownloadCache() {
        boolean r100 = false;
        this.mThreadLoadDownloadCacheOnlyOnce = false;
        this.mThreadDownloadCacheLoaded = new ThreadLocal();
        this.IHandler = new AnonymousClass1(this);
        this.weakHandler = null;
        boolean r101 = DownloadHelper.isMainProcess();
        if (DownloadUtils.isMultiProcessNoDBMode() == false) goto L7;
        if (r101 == true) goto L7;
        this.sqlDownloadCache = new EmptySqlDownloadCache();
    L22:
        this.hasInitSqlDownloadCache = false;
        this.weakHandler = new WeakDownloadHandler(Looper.getMainLooper(), this.IHandler);
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_LRU_DOWNLOAD_INFO_CACHE_ENABLE, 0) <= 0) goto L25;
    L28:
        boolean r102 = true;
    L30:
        if (r102 == false) goto L32;
        Logger.alogE(TAG, "Construct enableLru");
    L33:
        if (r102 == true) goto L37;
        if (DownloadComponentManager.isEnableLruCache() == true) goto L37;
    L39:
        this.downloadCache = new DownloadCache(this.sqlDownloadCache);
    L40:
        DownloadMonitorHelper.monitorLru(this.downloadCache instanceof LruDownloadCache);
        this.loadDBWaitTime = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.LOAD_DB_WAIT_TIME_MS, 5000);
        this.bizCloseDBBatchInit = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.BIZ_CLOSE_DB_BATCH_INIT, 0);
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.THREAD_LOAD_DOWNLOAD_CACHE_ONLY_ONCE) <= 0) goto L43;
        r100 = true;
    L43:
        this.mThreadLoadDownloadCacheOnlyOnce = r100;
        Runnable r103 = new AnonymousClass4(this);
        long r104 = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.DELAY_INIT_DOWNLOAD_CACHE_MS);
        if (r104 <= 0) goto L46;
        DownloadComponentManager.submitScheduleTask(r103, r104, TimeUnit.MILLISECONDS);
        return;
    L46:
        r103.run();
        return;
    L37:
        if ((this.sqlDownloadCache instanceof EmptySqlDownloadCache) == true) goto L39;
        this.downloadCache = new LruDownloadCache(this.sqlDownloadCache);
        goto L40
    L32:
        Logger.alogE(TAG, "Construct disableLru:" + Log.getStackTraceString(new Throwable("LruConstruct")));
        goto L33
    L25:
        if (DownloadHelper.getCacheSettingInt(DownloadSettingKeys.KEY_LRU_DOWNLOAD_INFO_CACHE_ENABLE) > 0) goto L28;
        r102 = false;
    L7:
        if (DownloadUtils.isMultiProcessNormalDBMode() == false) goto L13;
        if (r101 == true) goto L13;
        DownloadComponentManager.IndependentHolderCreator r105 = DownloadComponentManager.getNormalDBIndependentHolderCreator();
        if (r105 == null) goto L12;
        this.sqlDownloadCache = r105.createCache(new AnonymousClass2(this));
        goto L22
    L12:
        this.sqlDownloadCache = new SqlDownloadCache();
    L13:
        if (r101 == false) goto L15;
    L21:
        this.sqlDownloadCache = new SqlDownloadCache();
        goto L22
    L15:
        if (DownloadComponentManager.supportMultiProc() == false) goto L21;
        DownloadComponentManager.IndependentHolderCreator r106 = DownloadComponentManager.getIndependentHolderCreator();
        if (r106 == null) goto L20;
        this.sqlDownloadCache = r106.createCache(new AnonymousClass3(this));
        goto L22
    L20:
        this.sqlDownloadCache = new SqlDownloadCache();
        goto L22
    }

    private void newEnsureDownloadCacheSyncSuccess() {
        AbsDownloadEngine r100 = DownloadComponentManager.getDownloadEngine();
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.hasInitSqlDownloadCache == false) goto L7;
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.globalDebug(TAG, "newEnsureDownloadCacheSyncSuccess", "Waiting start");     // Catch: Throwable -> L14
    L9:
        initImmediately();     // Catch: Throwable -> L14
        waitDBLoad(r100);     // Catch: Throwable -> L14
        if (Logger.debug() == false) goto L12;
        Logger.globalDebug(TAG, "newEnsureDownloadCacheSyncSuccess", "Waiting end");     // Catch: Throwable -> L14
        goto L12
    }

    private void newOnDownloadCacheSyncSuccess() {
        AbsDownloadEngine r100 = DownloadComponentManager.getDownloadEngine();
        monitor-enter(r100);
        this.hasInitSqlDownloadCache = true;     // Catch: Throwable -> L8
        r100.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void onDownloadCacheSyncSuccess() {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "onDownloadCacheSyncSuccess", "Run");
    L6:
        if (this.downloadCache.isActiveLoadDownloadCache() == false) goto L9;
        newOnDownloadCacheSyncSuccess();
        return;
    L9:
        monitor-enter(this);
        this.hasInitSqlDownloadCache = true;     // Catch: Throwable -> L14
        notifyAll();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void initImmediately() {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "initImmediately", "Run isRunInit:" + isRunInit.get());
    L5:
        init(this.downloadCache instanceof LruDownloadCache);
    }

    public DownloadCache getDownloadCache() {
        return this.downloadCache;
    }

    public ISqlDownloadCache getSqlDownloadCache() {
        return this.sqlDownloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return this.hasInitSqlDownloadCache;
    }

    public static /* synthetic */ DownloadCache access$100(DefaultDownloadCache r100) {
        return r100.downloadCache;
    }

    public static /* synthetic */ void access$200(DefaultDownloadCache r100) {
        r100.initFinish();
    }

    private void updateDownloadInfoInDB(DownloadInfo r100) {
        updateDownloadInfoInDB(r100, true);
    }

    private void waitDBLoad(Object r100) {
        if (this.mThreadLoadDownloadCacheOnlyOnce == false) goto L9;
        if (this.mThreadDownloadCacheLoaded.get() == null) goto L7;
        return;
    L7:
        this.mThreadDownloadCacheLoaded.set(Boolean.TRUE);
    L9:
        if (Logger.debug() == false) goto L18;
        Logger.globalDebug(TAG, "waitDBLoad", "Run loadDBWaitTime:" + this.loadDBWaitTime);
    L18:
        int r101 = this.loadDBWaitTime;     // Catch: Throwable -> L15
        if (r101 <= 0) goto L20;
        r100.wait(r101);     // Catch: Throwable -> L15
        return;
    L20:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "waitDBLoad", "Error:" + th);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int r100) {
        DownloadInfo r101 = this.downloadCache.OnDownloadTaskIntercept(r100);
        updateDownloadInfoInDB(r101);
        return r101;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int r100) {
        DownloadInfo r101 = this.downloadCache.OnDownloadTaskPrepare(r100);
        updateDownloadInfoInDB(r101);
        return r101;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int r100) {
        DownloadInfo r101 = this.downloadCache.OnDownloadTaskRetry(r100);
        updateDownloadInfoInDB(r101);
        return r101;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int r100) {
        if (getDownloadInfo(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearMemoryCacheData(double r100) {
        this.downloadCache.clearMemoryCacheData(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int r100) {
        return this.downloadCache.getDownloadInfo(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String r100) {
        return this.downloadCache.getDownloadInfoList(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r100) {
        return this.downloadCache.getDownloadInfosByFileExtension(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r100) {
        return this.downloadCache.getDownloadInfosByMonitorScene(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int r100) {
        Map<Long, Segment> r101 = this.downloadCache.getSegmentMap(r100);
        if (r101 != null) goto L5;
    L6:
        Map<Long, Segment> r102 = this.sqlDownloadCache.getSegmentMap(r100);
        this.downloadCache.updateSegments(r100, r102);
        return r102;
    L5:
        if (r101.isEmpty() == true) goto L6;
        return r101;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<Segment> getSegments(int r100) {
        List<Segment> r101 = this.downloadCache.getSegments(r100);
        if (r101 == null) goto L7;
        if (r101.size() == 0) goto L7;
        return r101;
    L7:
        return this.sqlDownloadCache.getSegments(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r100) {
        return this.downloadCache.getSuccessedDownloadInfosWithMimeType(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r100) {
        return this.downloadCache.getUnCompletedDownloadInfosWithMimeType(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init(boolean r100) {
        if (isRunInit.compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.globalDebug(TAG, "init", "Run");
    L8:
        DownloadComponentManager.onDownloadCacheSyncCallback(DownloadCacheSyncStatus.SYNC_START);
        final SparseArray<DownloadInfo> r101 = new SparseArray();
        this.downloadCache.copyDownloadInfoMap(r101);
        this.sqlDownloadCache.init(r101, this.downloadCache.getUnreadDBSet(), this.downloadCache.getAutoResumeList(), this.downloadCache.getMimeTypes(), new AnonymousClass5(this, r101));
        int r102 = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.INIT_DOWNLOAD_CACHE_TIMEOUT_MS);
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug(TAG, "init", "InitTimeout:" + r102);
    L11:
        if (r102 > 0) goto L13;
        return;
    L13:
        DownloadComponentManager.submitScheduleTask(new AnonymousClass6(this), r102, TimeUnit.MILLISECONDS);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int r100) {
        DownloadInfo r101 = this.downloadCache.onDownloadTaskStart(r100);
        updateDownloadInfoInDB(r101);
        return r101;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int r100) {
    L12:
        e = move-exception;
        e.printStackTrace();
    L15:
        return this.downloadCache.removeDownloadInfo(r100);
    L3:
        if (DownloadHelper.needNotifyDownloaderProcess() == true) goto L5;
    L10:
        this.sqlDownloadCache.removeDownloadInfo(r100);     // Catch: SQLiteException -> L12
    L16:
        goto L15
    L5:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L10;
        IDownloadProxy r101 = DownloadProxy.get(true);     // Catch: SQLiteException -> L12
        if (r101 == null) goto L9;
        r101.removeDownloadInfo(r100);     // Catch: SQLiteException -> L12
        goto L16
    L9:
        this.sqlDownloadCache.removeDownloadInfo(r100);     // Catch: SQLiteException -> L12
        goto L16
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int r100) {
        if (DownloadHelper.needNotifyDownloaderProcess() == true) goto L5;
    L10:
        this.sqlDownloadCache.removeDownloadTaskData(r100);
    L12:
        return this.downloadCache.removeDownloadTaskData(r100);
    L5:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L10;
        IDownloadProxy r101 = DownloadProxy.get(true);
        if (r101 == null) goto L9;
        r101.removeDownloadTaskData(r100);
        goto L12
    L9:
        this.sqlDownloadCache.removeDownloadTaskData(r100);
        goto L12
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int r100) {
        this.downloadCache.removeSegments(r100);
        this.sqlDownloadCache.removeSegments(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.downloadCache.updateDownloadInfo(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int r100) {
        updateDownloadInfo(this.downloadCache.getDownloadInfo(r100));     // Catch: Exception -> L12
        if (DownloadHelper.needNotifyDownloaderProcess() == true) goto L5;
    L10:
        this.sqlDownloadCache.syncDownloadInfoFromOtherCache(r100);     // Catch: Exception -> L12
    L15:
        return;
    L5:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L10;
        IDownloadProxy r101 = DownloadProxy.get(true);     // Catch: Exception -> L12
        if (r101 == null) goto L9;
        r101.syncDownloadInfoFromOtherCache(r100);     // Catch: Exception -> L12
        goto L15
    L9:
        this.sqlDownloadCache.syncDownloadInfoFromOtherCache(r100);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = this.downloadCache.updateDownloadInfo(r100);
        updateDownloadInfoInDB(r100);
        return r101;
    }

    public static /* synthetic */ ISqlDownloadCache access$002(DefaultDownloadCache r100, ISqlDownloadCache r101) {
        r100.sqlDownloadCache = r101;
        return r101;
    }

    private void updateDownloadInfoInDB(DownloadInfo r100, boolean r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (DownloadHelper.needNotifyDownloaderProcess() == true) goto L7;
    L13:
        this.sqlDownloadCache.updateDownloadInfo(r100);
        return;
    L7:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L13;
        if (r101 == false) goto L15;
        IDownloadProxy r102 = DownloadProxy.get(true);
        if (r102 == null) goto L12;
        r102.updateDownloadInfo(r100);
        return;
    L12:
        this.sqlDownloadCache.updateDownloadInfo(r100);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int r100, long r101) {
        DownloadInfo r102 = this.downloadCache.OnDownloadTaskCancel(r100, r101);
        syncDownloadInfoFromOtherCache(r100);
        return r102;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int r100, long r101) {
        DownloadInfo r102 = this.downloadCache.OnDownloadTaskCompleted(r100, r101);
        syncDownloadInfoFromOtherCache(r100);
        return r102;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int r100, long r101) {
        DownloadInfo r102 = this.downloadCache.OnDownloadTaskError(r100, r101);
        syncDownloadInfoFromOtherCache(r100);
        return r102;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int r100, long r101) {
        DownloadInfo r102 = this.downloadCache.OnDownloadTaskPause(r100, r101);
        syncDownloadInfoFromOtherCache(r100);
        return r102;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int r100, long r101) {
        DownloadInfo r102 = this.downloadCache.OnDownloadTaskProgress(r100, r101);
        updateDownloadInfoInDB(r102, false);
        return r102;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFilters(String r100, String r101) {
        return this.downloadCache.getDownloadInfosByFilters(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int r100, Map<Long, Segment> r101) {
        this.downloadCache.updateSegments(r100, r101);
        this.sqlDownloadCache.updateSegments(r100, r101);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int r100, long r101, String r110, String r111) {
        DownloadInfo r102 = this.downloadCache.OnDownloadTaskConnected(r100, r101, r110, r111);
        updateDownloadInfoInDB(r102);
        return r102;
    }
}
