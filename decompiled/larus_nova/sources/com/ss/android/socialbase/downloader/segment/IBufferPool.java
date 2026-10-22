package com.ss.android.socialbase.downloader.segment;

/* JADX INFO: loaded from: classes38.dex */
public interface IBufferPool {
    Buffer obtain() throws StreamClosedException, InterruptedException;

    void recycle(Buffer r100);
}
