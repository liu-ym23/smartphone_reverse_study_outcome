package com.ss.android.socialbase.downloader.core.module.pcdn;

/* JADX INFO: loaded from: classes38.dex */
public class PCDNRetryPolicy {
    private int mCurrentRetryCount;
    private int mMaxRetryCount;

    public boolean isRetry() {
        if (this.mCurrentRetryCount <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public PCDNRetryPolicy(int r100) {
        this.mMaxRetryCount = r100;
    }

    public boolean canRetry(boolean r100) {
        int r101 = this.mCurrentRetryCount;
        if (r101 < this.mMaxRetryCount) goto L7;
        return false;
    L7:
        if (r100 == false) goto L9;
        this.mCurrentRetryCount = r101 + 1;
    L9:
        return true;
    }
}
