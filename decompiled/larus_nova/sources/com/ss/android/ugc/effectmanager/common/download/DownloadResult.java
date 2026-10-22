package com.ss.android.ugc.effectmanager.common.download;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/ss/android/ugc/effectmanager/common/download/DownloadResult;", "", "()V", "downloadException", "Lcom/ss/android/ugc/effectmanager/common/download/DownloadException;", "getDownloadException", "()Lcom/ss/android/ugc/effectmanager/common/download/DownloadException;", "setDownloadException", "(Lcom/ss/android/ugc/effectmanager/common/download/DownloadException;)V", "downloadTimeMillsCost", "", "getDownloadTimeMillsCost", "()J", "setDownloadTimeMillsCost", "(J)V", "fetchInputStreamTimeMillsCost", "getFetchInputStreamTimeMillsCost", "setFetchInputStreamTimeMillsCost", "fileSize", "getFileSize", "setFileSize", "unzipTimeMillsCost", "getUnzipTimeMillsCost", "setUnzipTimeMillsCost", "writeToDiskTimeMillsCost", "getWriteToDiskTimeMillsCost", "setWriteToDiskTimeMillsCost", "isSuccess", "", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class DownloadResult {
    private DownloadException downloadException;
    private long downloadTimeMillsCost;
    private long fetchInputStreamTimeMillsCost;
    private long fileSize;
    private long unzipTimeMillsCost;
    private long writeToDiskTimeMillsCost;

    public DownloadResult() {
    }

    public final boolean isSuccess() {
        if (this.downloadException != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final DownloadException getDownloadException() {
        return this.downloadException;
    }

    public final long getDownloadTimeMillsCost() {
        return this.downloadTimeMillsCost;
    }

    public final long getFetchInputStreamTimeMillsCost() {
        return this.fetchInputStreamTimeMillsCost;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final long getUnzipTimeMillsCost() {
        return this.unzipTimeMillsCost;
    }

    public final long getWriteToDiskTimeMillsCost() {
        return this.writeToDiskTimeMillsCost;
    }

    public final void setDownloadException(DownloadException r100) {
        this.downloadException = r100;
    }

    public final void setDownloadTimeMillsCost(long r100) {
        this.downloadTimeMillsCost = r100;
    }

    public final void setFetchInputStreamTimeMillsCost(long r100) {
        this.fetchInputStreamTimeMillsCost = r100;
    }

    public final void setFileSize(long r100) {
        this.fileSize = r100;
    }

    public final void setUnzipTimeMillsCost(long r100) {
        this.unzipTimeMillsCost = r100;
    }

    public final void setWriteToDiskTimeMillsCost(long r100) {
        this.writeToDiskTimeMillsCost = r100;
    }
}
