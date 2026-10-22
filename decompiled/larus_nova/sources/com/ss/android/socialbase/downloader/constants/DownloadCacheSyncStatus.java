package com.ss.android.socialbase.downloader.constants;

import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum DownloadCacheSyncStatus extends Enum<DownloadCacheSyncStatus> {
    private static final /* synthetic */ DownloadCacheSyncStatus[] $VALUES = null;
    public static final DownloadCacheSyncStatus SYNC_NONE = null;
    public static final DownloadCacheSyncStatus SYNC_START = null;
    public static final DownloadCacheSyncStatus SYNC_SUCCESS = null;

    static {
        DownloadCacheSyncStatus r100 = new DownloadCacheSyncStatus("SYNC_NONE", 0);
        SYNC_NONE = r100;
        DownloadCacheSyncStatus r101 = new DownloadCacheSyncStatus("SYNC_START", 1);
        SYNC_START = r101;
        DownloadCacheSyncStatus r102 = new DownloadCacheSyncStatus("SYNC_SUCCESS", 2);
        SYNC_SUCCESS = r102;
        $VALUES = new DownloadCacheSyncStatus[]{r100, r101, r102};
    }

    public static DownloadCacheSyncStatus[] values() {
        return (DownloadCacheSyncStatus[]) $VALUES.clone();
    }

    public static DownloadCacheSyncStatus valueOf(String r100) {
        return (DownloadCacheSyncStatus) a.a(DownloadCacheSyncStatus.class, r100);
    }

    private DownloadCacheSyncStatus(String r100, int r101) {
        super(r100, r101);
    }
}
