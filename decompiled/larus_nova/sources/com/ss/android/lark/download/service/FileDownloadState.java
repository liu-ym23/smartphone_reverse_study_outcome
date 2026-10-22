package com.ss.android.lark.download.service;

import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final enum FileDownloadState extends Enum<FileDownloadState> {
    public static final FileDownloadState DOWNLOADING = null;
    public static final FileDownloadState DOWNLOAD_CANCEL = null;
    public static final FileDownloadState DOWNLOAD_FAIL = null;
    public static final FileDownloadState DOWNLOAD_SUCCESS = null;
    public static final FileDownloadState DOWNLOAD_WAIT = null;
    public static final FileDownloadState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileDownloadState[] f420523a = null;
    private int value;

    static {
        FileDownloadState r100 = new FileDownloadState("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        FileDownloadState r101 = new FileDownloadState("DOWNLOAD_WAIT", 1, 7);
        DOWNLOAD_WAIT = r101;
        FileDownloadState r102 = new FileDownloadState("DOWNLOADING", 2, 8);
        DOWNLOADING = r102;
        FileDownloadState r103 = new FileDownloadState("DOWNLOAD_FAIL", 3, 9);
        DOWNLOAD_FAIL = r103;
        FileDownloadState r104 = new FileDownloadState("DOWNLOAD_CANCEL", 4, 10);
        DOWNLOAD_CANCEL = r104;
        FileDownloadState r105 = new FileDownloadState("DOWNLOAD_SUCCESS", 5, 11);
        DOWNLOAD_SUCCESS = r105;
        f420523a = new FileDownloadState[]{r100, r101, r102, r103, r104, r105};
    }

    public static FileDownloadState[] values() {
        return (FileDownloadState[]) f420523a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static FileDownloadState forNumber(int r100) {
        switch(r100) {
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L10;
            case 10: goto L8;
            case 11: goto L6;
            default: goto L4;
        };
    L4:
        return UNKNOWN;
    L6:
        return DOWNLOAD_SUCCESS;
    L8:
        return DOWNLOAD_CANCEL;
    L10:
        return DOWNLOAD_FAIL;
    L12:
        return DOWNLOADING;
    L14:
        return DOWNLOAD_WAIT;
    }

    public static FileDownloadState valueOf(String r100) {
        return (FileDownloadState) a.a(FileDownloadState.class, r100);
    }

    public static FileDownloadState valueOf(int r100) {
        return forNumber(r100);
    }

    public FileDownloadState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
