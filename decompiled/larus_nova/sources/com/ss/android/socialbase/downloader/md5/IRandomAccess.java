package com.ss.android.socialbase.downloader.md5;

import java.io.IOException;

/* JADX INFO: loaded from: classes38.dex */
public interface IRandomAccess {
    void close() throws IOException;

    long length() throws IOException;

    int read(byte[] r100, int r101, int r102) throws IOException;

    void seek(long r100, long r101) throws IOException;
}
