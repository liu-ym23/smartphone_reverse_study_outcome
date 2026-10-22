package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadHttpException extends BaseException {
    private final int httpStatusCode;

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public DownloadHttpException(int r100, int r101, String r102) {
        super(r100, r102);
        this.httpStatusCode = r101;
    }
}
