package com.ss.android.socialbase.downloader.core.module.pcdn;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;

/* JADX INFO: loaded from: classes38.dex */
public class PCDNChunkAllocater {
    private DownloadInfo mDownloadInfo;
    private int mIndex;
    private long mMaxChunkLength;
    private long mStartOffset;

    public PCDNChunk obtainPCDNChunk() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mStartOffset < this.mDownloadInfo.getTotalBytes()) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L15
        return null;
    L8:
        PCDNChunk r100 = new PCDNChunk();     // Catch: Throwable -> L15
        r100.mIndex = this.mIndex;     // Catch: Throwable -> L15
        long r101 = this.mStartOffset;     // Catch: Throwable -> L15
        r100.mStartOffset = r101;     // Catch: Throwable -> L15
        long r102 = (r101 + this.mMaxChunkLength) - 1;     // Catch: Throwable -> L15
        if (r102 >= this.mDownloadInfo.getTotalBytes()) goto L11;
        r100.mEndOffset = r102;     // Catch: Throwable -> L15
    L12:
        this.mStartOffset += this.mMaxChunkLength;     // Catch: Throwable -> L15
        this.mIndex++;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r100;
    L11:
        r100.mEndOffset = (this.mDownloadInfo.getStartOffset() + this.mDownloadInfo.getTotalBytes()) - 1;     // Catch: Throwable -> L15
        goto L12
    }

    public PCDNChunkAllocater(DownloadInfo r100, long r101) {
        this.mDownloadInfo = r100;
        this.mMaxChunkLength = r101;
        this.mStartOffset = DownloadHelper.getFirstOffset(r100) + r100.getStartOffset();
    }
}
