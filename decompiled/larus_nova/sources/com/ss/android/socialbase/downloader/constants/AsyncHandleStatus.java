package com.ss.android.socialbase.downloader.constants;

import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum AsyncHandleStatus extends Enum<AsyncHandleStatus> {
    private static final /* synthetic */ AsyncHandleStatus[] $VALUES = null;
    public static final AsyncHandleStatus ASYNC_HANDLE_DOWNLOADED = null;
    public static final AsyncHandleStatus ASYNC_HANDLE_DOWNLOADING = null;
    public static final AsyncHandleStatus ASYNC_HANDLE_NONE = null;
    public static final AsyncHandleStatus ASYNC_HANDLE_RESTART = null;
    public static final AsyncHandleStatus ASYNC_HANDLE_WAITING = null;

    static {
        AsyncHandleStatus r100 = new AsyncHandleStatus("ASYNC_HANDLE_NONE", 0);
        ASYNC_HANDLE_NONE = r100;
        AsyncHandleStatus r101 = new AsyncHandleStatus("ASYNC_HANDLE_WAITING", 1);
        ASYNC_HANDLE_WAITING = r101;
        AsyncHandleStatus r102 = new AsyncHandleStatus("ASYNC_HANDLE_RESTART", 2);
        ASYNC_HANDLE_RESTART = r102;
        AsyncHandleStatus r103 = new AsyncHandleStatus("ASYNC_HANDLE_DOWNLOADING", 3);
        ASYNC_HANDLE_DOWNLOADING = r103;
        AsyncHandleStatus r104 = new AsyncHandleStatus("ASYNC_HANDLE_DOWNLOADED", 4);
        ASYNC_HANDLE_DOWNLOADED = r104;
        $VALUES = new AsyncHandleStatus[]{r100, r101, r102, r103, r104};
    }

    public static AsyncHandleStatus[] values() {
        return (AsyncHandleStatus[]) $VALUES.clone();
    }

    public static AsyncHandleStatus valueOf(String r100) {
        return (AsyncHandleStatus) a.a(AsyncHandleStatus.class, r100);
    }

    private AsyncHandleStatus(String r100, int r101) {
        super(r100, r101);
    }
}
