package com.ss.bytertc.ktv.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum DownloadLyricType extends Enum<DownloadLyricType> {
    private static final /* synthetic */ DownloadLyricType[] $VALUES = null;
    public static final DownloadLyricType KRC = null;
    public static final DownloadLyricType LRC = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.ktv.data.DownloadLyricType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$DownloadLyricType = null;

        static {
            int[] r100 = new int[DownloadLyricType.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$DownloadLyricType = r100;
            r100[DownloadLyricType.KRC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$ktv$data$DownloadLyricType[DownloadLyricType.LRC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        DownloadLyricType r100 = new DownloadLyricType("KRC", 0, 0);
        KRC = r100;
        DownloadLyricType r101 = new DownloadLyricType("LRC", 1, 1);
        LRC = r101;
        $VALUES = new DownloadLyricType[]{r100, r101};
    }

    public static DownloadLyricType[] values() {
        return (DownloadLyricType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$DownloadLyricType[ordinal()];
        if (r100 != 1) goto L5;
        return "DOWNLOAD_LYRIC_TYPE_KRC";
    L5:
        if (r100 == 2) goto L7;
        return "";
    L7:
        return "DOWNLOAD_LYRIC_TYPE_LRC";
    }

    public int value() {
        return this.value;
    }

    public static DownloadLyricType fromId(int r100) {
        DownloadLyricType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        DownloadLyricType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static DownloadLyricType valueOf(String r100) {
        return (DownloadLyricType) a.a(DownloadLyricType.class, r100);
    }

    private DownloadLyricType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
