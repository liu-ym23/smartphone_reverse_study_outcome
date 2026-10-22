package com.ss.android.lark.filedetail.impl.detail;

import com.ss.android.ugc.effectmanager.common.EffectConstants;

/* JADX INFO: loaded from: classes35.dex */
public final enum FileDownloadState extends Enum<FileDownloadState> {
    public static final FileDownloadState BURNED = null;
    public static final FileDownloadState DECRYPT_FAILED = null;
    public static final FileDownloadState DECRYPT_START = null;
    public static final FileDownloadState DLP_BLOCKED = null;
    public static final FileDownloadState DONE = null;
    public static final FileDownloadState DOWNLOADING = null;
    public static final FileDownloadState DOWNLOAD_FAILED = null;
    public static final FileDownloadState DOWNLOAD_NETWORK = null;
    public static final FileDownloadState NORMAL = null;
    public static final FileDownloadState PAUSE = null;
    public static final FileDownloadState RECALL = null;
    public static final FileDownloadState STOP = null;
    public static final FileDownloadState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileDownloadState[] f421567a = null;
    private final int value;

    static {
        FileDownloadState r100 = new FileDownloadState(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        FileDownloadState r101 = new FileDownloadState("PAUSE", 1, 1);
        PAUSE = r101;
        FileDownloadState r102 = new FileDownloadState("DOWNLOADING", 2, 2);
        DOWNLOADING = r102;
        FileDownloadState r103 = new FileDownloadState("DONE", 3, 3);
        DONE = r103;
        FileDownloadState r104 = new FileDownloadState("STOP", 4, 4);
        STOP = r104;
        FileDownloadState r105 = new FileDownloadState("RECALL", 5, 5);
        RECALL = r105;
        FileDownloadState r110 = new FileDownloadState("BURNED", 6, 6);
        BURNED = r110;
        FileDownloadState r111 = new FileDownloadState("DOWNLOAD_FAILED", 7, 7);
        DOWNLOAD_FAILED = r111;
        FileDownloadState r112 = new FileDownloadState("DECRYPT_START", 8, 8);
        DECRYPT_START = r112;
        FileDownloadState r113 = new FileDownloadState("DECRYPT_FAILED", 9, 9);
        DECRYPT_FAILED = r113;
        FileDownloadState r114 = new FileDownloadState("DLP_BLOCKED", 10, 10);
        DLP_BLOCKED = r114;
        FileDownloadState r115 = new FileDownloadState("DOWNLOAD_NETWORK", 11, 11);
        DOWNLOAD_NETWORK = r115;
        FileDownloadState r106 = new FileDownloadState("UNKNOWN", 12, -1);
        UNKNOWN = r106;
        f421567a = new FileDownloadState[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
    }

    public static FileDownloadState[] values() {
        return (FileDownloadState[]) f421567a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static FileDownloadState forNumber(int r100) {
        switch(r100) {
            case 0: goto L28;
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L22;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L16;
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
        return DOWNLOAD_NETWORK;
    L8:
        return DLP_BLOCKED;
    L10:
        return DECRYPT_FAILED;
    L12:
        return DECRYPT_START;
    L14:
        return DOWNLOAD_FAILED;
    L16:
        return BURNED;
    L18:
        return RECALL;
    L20:
        return STOP;
    L22:
        return DONE;
    L24:
        return DOWNLOADING;
    L26:
        return PAUSE;
    L28:
        return NORMAL;
    }

    public static FileDownloadState valueOf(String r100) {
        return (FileDownloadState) r27.a.a(FileDownloadState.class, r100);
    }

    public static FileDownloadState valueOf(int r100) {
        return forNumber(r100);
    }

    public FileDownloadState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
