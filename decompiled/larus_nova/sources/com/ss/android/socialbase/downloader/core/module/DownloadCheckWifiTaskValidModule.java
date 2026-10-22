package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadCheckWifiTaskValidModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCheckWifiTaskValidModule";

    public DownloadCheckWifiTaskValidModule() {
    }

    public static void checkWifiTaskValid(DownloadInfo r100) throws DownloadRetryNeedlessException {
        if (r100.isFastDownload() == false) goto L5;
        return;
    L5:
        if (DeviceBandwidthSampler.isWifi() == false) goto L8;
        return;
    L8:
        if (r100.isOnlyWifi() == false) goto L15;
        DeviceBandwidthSampler.updateNetworkStatus();
        if (DeviceBandwidthSampler.isMobileNet() == false) goto L15;
        throw new DownloadOnlyWifiException();
    L15:
        if (r100.isDownloadFromReserveWifi() == true) goto L17;
        return;
    L17:
        if (r100.isPauseReserveOnWifi() == false) goto L25;
        DeviceBandwidthSampler.updateNetworkStatus();
        if (DeviceBandwidthSampler.isMobileNet() == true) goto L22;
        return;
    L22:
        throw new DownloadPauseReserveWifiException();
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams r100) {
        if (r100.mDownloadInfo.isFastDownload() == false) goto L7;
        return null;
    L7:
        return super.init(r100);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r100) throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
    L5:
        checkWifiTaskValid(this.mDownloadInfo);
        r100.proceed();
    }
}
