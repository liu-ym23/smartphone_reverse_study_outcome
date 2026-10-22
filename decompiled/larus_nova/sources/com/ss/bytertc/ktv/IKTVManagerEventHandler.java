package com.ss.bytertc.ktv;

import com.ss.bytertc.ktv.data.DownloadResult;
import com.ss.bytertc.ktv.data.HotMusicInfo;
import com.ss.bytertc.ktv.data.KTVErrorCode;
import com.ss.bytertc.ktv.data.MusicInfo;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IKTVManagerEventHandler {
    public IKTVManagerEventHandler() {
    }

    public abstract void onClearCacheResult(KTVErrorCode r100);

    public abstract void onDownloadFailed(int r100, KTVErrorCode r101);

    public abstract void onDownloadMusicProgress(int r100, int r101);

    public abstract void onDownloadSuccess(int r100, DownloadResult r101);

    public abstract void onHotMusicResult(HotMusicInfo[] r100, KTVErrorCode r101);

    public abstract void onMusicDetailResult(MusicInfo r100, KTVErrorCode r101);

    public abstract void onMusicListResult(MusicInfo[] r100, int r101, KTVErrorCode r102);

    public abstract void onSearchMusicResult(MusicInfo[] r100, int r101, KTVErrorCode r102);
}
