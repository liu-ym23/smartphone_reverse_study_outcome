package com.ss.bytertc.ktv.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum DownloadFileType extends Enum<DownloadFileType> {
    private static final /* synthetic */ DownloadFileType[] $VALUES = null;
    public static final DownloadFileType KRC = null;
    public static final DownloadFileType LRC = null;
    public static final DownloadFileType MIDI = null;
    public static final DownloadFileType MUSIC = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.ktv.data.DownloadFileType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$DownloadFileType = null;

        static {
            int[] r100 = new int[DownloadFileType.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$DownloadFileType = r100;
            r100[DownloadFileType.MUSIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$ktv$data$DownloadFileType[DownloadFileType.KRC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$ktv$data$DownloadFileType[DownloadFileType.LRC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$ktv$data$DownloadFileType[DownloadFileType.MIDI.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        DownloadFileType r100 = new DownloadFileType("MUSIC", 0, 1);
        MUSIC = r100;
        DownloadFileType r101 = new DownloadFileType("KRC", 1, 2);
        KRC = r101;
        DownloadFileType r102 = new DownloadFileType("LRC", 2, 3);
        LRC = r102;
        DownloadFileType r103 = new DownloadFileType("MIDI", 3, 4);
        MIDI = r103;
        $VALUES = new DownloadFileType[]{r100, r101, r102, r103};
    }

    public static DownloadFileType[] values() {
        return (DownloadFileType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$DownloadFileType[ordinal()];
        if (r100 != 1) goto L5;
        return "DOWNLOAD_FILE_TYPE_MUSIC";
    L5:
        if (r100 != 2) goto L7;
        return "DOWNLOAD_FILE_TYPE_KRC";
    L7:
        if (r100 != 3) goto L9;
        return "DOWNLOAD_FILE_TYPE_LRC";
    L9:
        if (r100 == 4) goto L11;
        return "";
    L11:
        return "DOWNLOAD_FILE_TYPE_MIDI";
    }

    public int value() {
        return this.value;
    }

    public static DownloadFileType fromId(int r100) {
        DownloadFileType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        DownloadFileType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static DownloadFileType valueOf(String r100) {
        return (DownloadFileType) a.a(DownloadFileType.class, r100);
    }

    private DownloadFileType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
