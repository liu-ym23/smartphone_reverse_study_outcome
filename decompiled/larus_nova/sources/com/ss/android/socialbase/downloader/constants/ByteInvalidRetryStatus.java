package com.ss.android.socialbase.downloader.constants;

import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum ByteInvalidRetryStatus extends Enum<ByteInvalidRetryStatus> {
    private static final /* synthetic */ ByteInvalidRetryStatus[] $VALUES = null;
    public static final ByteInvalidRetryStatus BYTE_INVALID_RETRY_STATUS_DOWNLOADED = null;
    public static final ByteInvalidRetryStatus BYTE_INVALID_RETRY_STATUS_DOWNLOADING = null;
    public static final ByteInvalidRetryStatus BYTE_INVALID_RETRY_STATUS_NONE = null;
    public static final ByteInvalidRetryStatus BYTE_INVALID_RETRY_STATUS_RESTART = null;

    static {
        ByteInvalidRetryStatus r100 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_NONE", 0);
        BYTE_INVALID_RETRY_STATUS_NONE = r100;
        ByteInvalidRetryStatus r101 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_RESTART", 1);
        BYTE_INVALID_RETRY_STATUS_RESTART = r101;
        ByteInvalidRetryStatus r102 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_DOWNLOADING", 2);
        BYTE_INVALID_RETRY_STATUS_DOWNLOADING = r102;
        ByteInvalidRetryStatus r103 = new ByteInvalidRetryStatus("BYTE_INVALID_RETRY_STATUS_DOWNLOADED", 3);
        BYTE_INVALID_RETRY_STATUS_DOWNLOADED = r103;
        $VALUES = new ByteInvalidRetryStatus[]{r100, r101, r102, r103};
    }

    public static ByteInvalidRetryStatus[] values() {
        return (ByteInvalidRetryStatus[]) $VALUES.clone();
    }

    public static ByteInvalidRetryStatus valueOf(String r100) {
        return (ByteInvalidRetryStatus) a.a(ByteInvalidRetryStatus.class, r100);
    }

    private ByteInvalidRetryStatus(String r100, int r101) {
        super(r100, r101);
    }
}
