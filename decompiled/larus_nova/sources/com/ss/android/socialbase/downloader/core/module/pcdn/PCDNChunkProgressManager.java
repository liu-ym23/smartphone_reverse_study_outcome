package com.ss.android.socialbase.downloader.core.module.pcdn;

import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class PCDNChunkProgressManager {
    private Map<Integer, ChunkCacheItem> mCacheDownloadedSize;
    private int mChunkProgressIndex;
    private IDownloadCache mDownloadCache;
    private DownloadInfo mDownloadInfo;
    private IDownloadRunnableCallback mDownloadRunnableCallback;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.core.module.pcdn.PCDNChunkProgressManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class ChunkCacheItem {
        private long downloadSize;
        private boolean isFinished;
        final /* synthetic */ PCDNChunkProgressManager this$0;

        private ChunkCacheItem(PCDNChunkProgressManager r100) {
            this.this$0 = r100;
        }

        public static /* synthetic */ boolean access$000(ChunkCacheItem r100) {
            return r100.isFinished;
        }

        public static /* synthetic */ long access$100(ChunkCacheItem r100) {
            return r100.downloadSize;
        }

        public /* synthetic */ ChunkCacheItem(PCDNChunkProgressManager r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static /* synthetic */ boolean access$002(ChunkCacheItem r100, boolean r101) {
            r100.isFinished = r101;
            return r101;
        }

        public static /* synthetic */ long access$102(ChunkCacheItem r100, long r101) {
            r100.downloadSize = r101;
            return r101;
        }
    }

    public void onDownloadChunkFinish(int r100) {
        monitor-enter(this);
        int r101 = this.mChunkProgressIndex;     // Catch: Throwable -> L28
        if (r100 != r101) goto L6;
        this.mChunkProgressIndex = r101 + 1;     // Catch: Throwable -> L28
        long r102 = 0;
    L11:
        ChunkCacheItem r103 = this.mCacheDownloadedSize.get(Integer.valueOf(this.mChunkProgressIndex));     // Catch: Throwable -> L28
        if (r103 == null) goto L18;
        r102 = r102 + ChunkCacheItem.access$100(r103);     // Catch: Throwable -> L28
        if (ChunkCacheItem.access$000(r103) == false) goto L16;
        this.mCacheDownloadedSize.remove(Integer.valueOf(this.mChunkProgressIndex));     // Catch: Throwable -> L28
        this.mChunkProgressIndex++;     // Catch: Throwable -> L28
        goto L11
    L16:
        ChunkCacheItem.access$102(r103, 0);     // Catch: Throwable -> L28
        this.mCacheDownloadedSize.put(Integer.valueOf(this.mChunkProgressIndex), r103);     // Catch: Throwable -> L28
    L18:
        if (r102 > 0) goto L31;
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L31:
        this.mDownloadRunnableCallback.onProgress(r102);     // Catch: Throwable -> L23
        this.mDownloadInfo.updateRealDownloadTime(true);     // Catch: Throwable -> L23
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);     // Catch: Throwable -> L23
    L25:
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L23:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
        goto L25
    L6:
        if (this.mCacheDownloadedSize.containsKey(Integer.valueOf(r100)) == false) goto L8;
        ChunkCacheItem r104 = this.mCacheDownloadedSize.get(Integer.valueOf(r100));     // Catch: Throwable -> L28
        ChunkCacheItem.access$002(r104, true);     // Catch: Throwable -> L28
        this.mCacheDownloadedSize.put(Integer.valueOf(r100), r104);     // Catch: Throwable -> L28
    L8:
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public boolean onProgress(int r100, long r101) throws BaseException {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (r100 != this.mChunkProgressIndex) goto L8;
        boolean r102 = this.mDownloadRunnableCallback.onProgress(r101);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r102;
    L8:
        ChunkCacheItem r103 = this.mCacheDownloadedSize.get(Integer.valueOf(r100));     // Catch: Throwable -> L15
        if (r103 != null) goto L11;
        r103 = new ChunkCacheItem(this, null);     // Catch: Throwable -> L15
    L11:
        ChunkCacheItem.access$102(r103, ChunkCacheItem.access$100(r103) + r101);     // Catch: Throwable -> L15
        this.mCacheDownloadedSize.put(Integer.valueOf(r100), r103);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return false;
    }

    public PCDNChunkProgressManager(IDownloadRunnableCallback r100, IDownloadCache r101, DownloadInfo r102) {
        this.mCacheDownloadedSize = new HashMap();
        this.mDownloadRunnableCallback = r100;
        this.mDownloadCache = r101;
        this.mDownloadInfo = r102;
    }
}
