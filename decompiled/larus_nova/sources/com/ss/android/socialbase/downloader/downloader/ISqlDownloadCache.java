package com.ss.android.socialbase.downloader.downloader;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl;
import com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public interface ISqlDownloadCache extends IDownloadCache {
    void init(SparseArray<DownloadInfo> r100, Set<Integer> r101, List<DownloadInfo> r102, List<String> r103, SqlCacheLoadCompleteCallback r104);

    void setInitCallback(ISqlCacheLoadCompleteCallbackAidl r100);
}
