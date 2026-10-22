package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RecordingFileType extends Enum<RecordingFileType> {
    private static final /* synthetic */ RecordingFileType[] $VALUES = null;
    public static final RecordingFileType AAC = null;
    public static final RecordingFileType MP4 = null;
    private int value;

    static {
        RecordingFileType r100 = new RecordingFileType("AAC", 0, 0);
        AAC = r100;
        RecordingFileType r101 = new RecordingFileType("MP4", 1, 1);
        MP4 = r101;
        $VALUES = new RecordingFileType[]{r100, r101};
    }

    public static RecordingFileType[] values() {
        return (RecordingFileType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RecordingFileType fromId(int r100) {
        RecordingFileType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        RecordingFileType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return AAC;
    }

    public static RecordingFileType valueOf(String r100) {
        return (RecordingFileType) a.a(RecordingFileType.class, r100);
    }

    private RecordingFileType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
