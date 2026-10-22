package com.bytedance.frameworks.baselib.network.http.util;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadFileTooLargeException extends IOException {
    private static final long serialVersionUID = -1098012010869697449L;
    final long length;
    final int maxSize;

    public long getLength() {
        return this.length;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public DownloadFileTooLargeException(int r100, long r101) {
        super("Download file too large: " + r101 + " exceed maxsize: " + r100);
        this.maxSize = r100;
        this.length = r101;
    }
}
