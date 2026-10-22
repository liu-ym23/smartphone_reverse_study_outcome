package com.ss.android.socialbase.downloader.exception;

import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadOutOfSpaceException extends BaseException {
    private final long avaliableSpaceBytes;
    private final long requiredSpaceBytes;

    public long getAvaliableSpaceBytes() {
        return this.avaliableSpaceBytes;
    }

    public long getRequiredSpaceBytes() {
        return this.requiredSpaceBytes;
    }

    public DownloadOutOfSpaceException(long r100, long r101) {
        super(1006, String.format(Locale.US, "space is not enough required space is : %d but available space is :%d", new Object[]{Long.valueOf(r101), Long.valueOf(DownloadUtils.getReportableSpaceMB(r100) * 1048576)}));
        this.avaliableSpaceBytes = r100;
        this.requiredSpaceBytes = r101;
    }
}
