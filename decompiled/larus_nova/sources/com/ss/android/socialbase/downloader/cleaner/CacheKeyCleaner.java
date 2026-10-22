package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class CacheKeyCleaner implements CleanerImpl.CleanerHandler {
    private static final String TAG = "CacheKeyCleaner";
    private Map<Integer, List<Integer>> mCleanCacheKeyMaps;
    private CleanerConfig mCleanerConfig;
    private CleanerImpl mCleanerImpl;

    private void startImpl() {
        Iterator<Map.Entry<Integer, List<Integer>>> r100 = this.mCleanCacheKeyMaps.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L30;
        Map.Entry<Integer, List<Integer>> r101 = r100.next();
        int r102 = r101.getKey().intValue();
        Iterator<Integer> r103 = r101.getValue().iterator();
    L7:
        if (r103.hasNext() == false) goto L29;
        CleanerImpl r104 = this.mCleanerImpl;
        if (r104 != null) goto L11;
    L16:
        int r105 = r103.next().intValue();
        if (this.mCleanerConfig.isExistInCleanSet(r105) == false) goto L19;
        DownloadUtils.clearDownloadFile(this.mCleanerConfig.getSavePath(r105), this.mCleanerConfig.getTempSavePath(r105), this.mCleanerConfig.getName(r105));
        if (this.mCleanerConfig.isOnlyCleanFile(r105) == true) goto L26;
        DownloadComponentManager.getDownloadCache().removeDownloadTaskData(r105);
    L26:
        if (Logger.debug() == false) goto L28;
        Logger.globalDebug(TAG, "startImpl", "clean cache downloadId=" + r105);
    L28:
        r103.remove();
        this.mCleanerConfig.removeFromCleanDownloadIdSet(r105);
        goto L7
    L19:
        if (Logger.debug() == false) goto L21;
        Logger.globalDebug(TAG, "startImpl", "dwg888Find in visit history,can't do clean,downloadId=" + r105);
    L21:
        r103.remove();
        goto L7
    L11:
        if (r104.isStop() == false) goto L16;
        if (Logger.debug() == false) goto L39;
        Logger.globalDebug(TAG, "startImpl", "stop cleaning");
        return;
    L39:
        return;
    L29:
        r100.remove();
        this.mCleanerConfig.updateCleanSetting(r102);
        goto L4
    }

    public void batchStart() {
        if (this.mCleanCacheKeyMaps.isEmpty() == false) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.globalDebug(TAG, "loadDataAndStart", "Run" + this.mCleanCacheKeyMaps.size());
    L8:
        start();
        this.mCleanerConfig.clearData();
    }

    public void finish() {
        this.mCleanerConfig.finish();
    }

    @Override // com.ss.android.socialbase.downloader.cleaner.CleanerImpl.CleanerHandler
    public void start() {
        if (Logger.debug() == false) goto L20;
        Logger.globalDebug(TAG, "start", "Run");
    L20:
        startImpl();     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L14;
    L8:
        Logger.globalDebug(TAG, "start", "Run End");
        return;
    L14:
        return;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "start", "Error:" + th);     // Catch: Throwable -> L15
        if (Logger.debug() == true) goto L8;
        return;
    L15:
        th = move-exception;
        if (Logger.debug() == false) goto L19;
        Logger.globalDebug(TAG, "start", "Run End");
    L19:
        throw th;
    }

    public static boolean isEnabled(CleanerConfig r100) {
        if (r100.isNoCacheNeedClean() == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.getCleanCacheKeyMaps().isEmpty() == true) goto L7;
        return true;
    }

    public CacheKeyCleaner(CleanerImpl r100, CleanerConfig r101) {
        this.mCleanerImpl = r100;
        this.mCleanerConfig = r101;
        this.mCleanCacheKeyMaps = r101.getCleanCacheKeyMaps();
    }
}
