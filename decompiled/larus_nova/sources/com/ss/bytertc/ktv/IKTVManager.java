package com.ss.bytertc.ktv;

import com.ss.bytertc.ktv.data.DownloadLyricType;
import com.ss.bytertc.ktv.data.MusicFilterType;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IKTVManager {
    public IKTVManager() {
    }

    public abstract void cancelDownload(int r100);

    public abstract void clearCache();

    public abstract int downloadLyric(String r100, DownloadLyricType r101);

    public abstract int downloadMidi(String r100);

    public abstract int downloadMusic(String r100);

    public abstract void getHotMusic(List<String> r100, MusicFilterType[] r101);

    public abstract IKTVPlayer getKTVPlayer();

    public abstract void getMusicDetail(String r100);

    public abstract void getMusicList(int r100, int r101, MusicFilterType[] r102);

    public abstract void searchMusic(String r100, int r101, int r102, MusicFilterType[] r103);

    public abstract void setKTVManagerEventHandler(IKTVManagerEventHandler r100);

    public abstract void setMaxCacheSize(int r100);
}
