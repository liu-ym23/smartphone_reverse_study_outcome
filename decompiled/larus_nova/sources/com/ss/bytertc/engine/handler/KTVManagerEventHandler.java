package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.ktv.IKTVManagerEventHandler;
import com.ss.bytertc.ktv.data.DownloadResult;
import com.ss.bytertc.ktv.data.HotMusicInfo;
import com.ss.bytertc.ktv.data.KTVErrorCode;
import com.ss.bytertc.ktv.data.MusicInfo;

/* JADX INFO: loaded from: classes40.dex */
public class KTVManagerEventHandler extends IKTVManagerEventHandler {
    private static final String TAG = "KTVManagerEventHandler";
    private final IKTVManagerEventHandler mHandler;

    public IKTVManagerEventHandler getKTVHandler() {
        return this.mHandler;
    }

    public KTVManagerEventHandler(IKTVManagerEventHandler r100) {
        this.mHandler = r100;
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onClearCacheResult(KTVErrorCode r100) {
        LogUtil.d(TAG, "onClearCacheResult...errorCode: " + r100);
        IKTVManagerEventHandler r101 = this.mHandler;     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        r101.onClearCacheResult(r100);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.e(TAG, "onClearCacheResult callback catch exception.\n" + e.getMessage());
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onDownloadFailed(int r100, KTVErrorCode r101) {
        LogUtil.d(TAG, "onDownloadFailed...downloadId: " + r100 + ",errorCode:" + r101);
        IKTVManagerEventHandler r102 = this.mHandler;     // Catch: Exception -> L7
        if (r102 == null) goto L12;
        r102.onDownloadFailed(r100, r101);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.e(TAG, "onDownloadFailed callback catch exception.\n" + e.getMessage());
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onDownloadMusicProgress(int r100, int r101) {
        LogUtil.d(TAG, "onDownloadMusicProgress...downloadId: " + r100 + ",downloadProgress:" + r101);
        IKTVManagerEventHandler r102 = this.mHandler;     // Catch: Exception -> L7
        if (r102 == null) goto L12;
        r102.onDownloadMusicProgress(r100, r101);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.e(TAG, "onDownloadMusicProgress callback catch exception.\n" + e.getMessage());
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onDownloadSuccess(int r100, DownloadResult r101) {
        LogUtil.d(TAG, "onDownloadSuccess...downloadId: " + r100 + ",result:" + r101);
        IKTVManagerEventHandler r102 = this.mHandler;     // Catch: Exception -> L7
        if (r102 == null) goto L12;
        r102.onDownloadSuccess(r100, r101);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.e(TAG, "onDownloadSuccess callback catch exception.\n" + e.getMessage());
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onHotMusicResult(HotMusicInfo[] r100, KTVErrorCode r101) {
        LogUtil.d(TAG, "onHotMusicResult...errorCode: " + r101 + ",musicsLen:" + r100.length);
        IKTVManagerEventHandler r102 = this.mHandler;     // Catch: Exception -> L7
        if (r102 == null) goto L12;
        r102.onHotMusicResult(r100, r101);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.e(TAG, "onHotMusicResult callback catch exception.\n" + e.getMessage());
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onMusicDetailResult(MusicInfo r100, KTVErrorCode r101) {
        LogUtil.d(TAG, "onMusicDetailResult...errorCode: " + r101 + ",music:" + r100);
        IKTVManagerEventHandler r102 = this.mHandler;     // Catch: Exception -> L7
        if (r102 == null) goto L12;
        r102.onMusicDetailResult(r100, r101);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.e(TAG, "onMusicDetailResult callback catch exception.\n" + e.getMessage());
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onMusicListResult(MusicInfo[] r100, int r101, KTVErrorCode r102) {
        LogUtil.d(TAG, "onMusicListResult...errorCode: " + r102 + ",totalSize:" + r101 + ",musicsLen:" + r100.length);
        IKTVManagerEventHandler r103 = this.mHandler;     // Catch: Exception -> L7
        if (r103 == null) goto L12;
        r103.onMusicListResult(r100, r101, r102);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.e(TAG, "onMusicListResult callback catch exception.\n" + e.getMessage());
    }

    @Override // com.ss.bytertc.ktv.IKTVManagerEventHandler
    public void onSearchMusicResult(MusicInfo[] r100, int r101, KTVErrorCode r102) {
        LogUtil.d(TAG, "onSearchMusicResult...errorCode: " + r102 + ",totalSize:" + r101 + ",musicsLen:" + r100.length);
        IKTVManagerEventHandler r103 = this.mHandler;     // Catch: Exception -> L7
        if (r103 == null) goto L12;
        r103.onSearchMusicResult(r100, r101, r102);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.e(TAG, "onSearchMusicResult callback catch exception.\n" + e.getMessage());
    }
}
