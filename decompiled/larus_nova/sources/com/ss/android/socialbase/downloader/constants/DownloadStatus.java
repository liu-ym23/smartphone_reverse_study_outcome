package com.ss.android.socialbase.downloader.constants;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadStatus {
    public static final int CANCELED = -4;
    public static final int CONNECTED = 3;
    public static final int DOWNLOAD_COMPLETE_HANDLE = 11;
    public static final int FAILED = -1;
    public static final int FIRST_START = 6;
    public static final int FIRST_SUCCESS = -6;
    public static final int IDLE_STATUS = 0;
    public static final int INTERCEPT = -7;
    public static final int PAUSED = -2;
    public static final int PAUSED_BY_DB_INIT = -5;
    public static final int PREPARE = 1;
    public static final int PROGRESS = 4;
    public static final int RETRY = 5;
    public static final int RETRY_DELAY = 7;
    public static final int SINGLE_CHUNK_DELAY_RETRY = 10;
    public static final int SINGLE_CHUNK_RETRY = 9;
    public static final int START = 2;
    public static final int SUCCESSED = -3;
    public static final int WAITING_ASYNC_HANDLER = 8;

    public DownloadStatus() {
    }

    public static boolean isDownloadOver(int r100) {
        if (r100 < 0) goto L4;
    L8:
        return false;
    L4:
        if (r100 == (-2)) goto L8;
        if (r100 == (-5)) goto L8;
        return true;
    }

    public static boolean isDownloading(int r100) {
        if (r100 > 0) goto L4;
    L8:
        return false;
    L4:
        if (r100 == 8) goto L8;
        if (r100 == 10) goto L8;
        return true;
    }

    public static boolean isFailedStatus(int r100) {
        if (r100 != (-1)) goto L5;
    L8:
        return true;
    L5:
        if (r100 == (-7)) goto L8;
        return false;
    }

    public static boolean isMonitorStatus(int r100) {
        if (r100 != 2) goto L5;
    L17:
        return true;
    L5:
        if (r100 == (-3)) goto L17;
        if (r100 == (-1)) goto L17;
        if (r100 == (-4)) goto L17;
        if (r100 == (-2)) goto L17;
        if (r100 == 6) goto L17;
        if (r100 == 0) goto L17;
        return false;
    }

    public static boolean isRealTimeUploadStatus(int r100) {
        if (r100 != (-3)) goto L5;
    L16:
        return true;
    L5:
        if (r100 == (-1)) goto L16;
        if (r100 == (-4)) goto L16;
        if (r100 == (-2)) goto L16;
        if (r100 == 5) goto L16;
        if (r100 == 8) goto L16;
        return false;
    }

    public static boolean isTimeUploadStatus(int r100) {
        if (r100 != (-3)) goto L5;
    L10:
        return true;
    L5:
        if (r100 == (-1)) goto L10;
        if (r100 == (-4)) goto L10;
        return false;
    }

    public static boolean isUnCompletedStatus(int r100) {
        if (r100 != (-1)) goto L5;
    L14:
        return true;
    L5:
        if (r100 == (-2)) goto L14;
        if (r100 == (-7)) goto L14;
        if (r100 == (-4)) goto L14;
        if (r100 == (-5)) goto L14;
        return false;
    }
}
