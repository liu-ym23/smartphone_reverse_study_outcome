package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RecordingType extends Enum<RecordingType> {
    private static final /* synthetic */ RecordingType[] $VALUES = null;
    public static final RecordingType RECORD_AUDIO_ONLY = null;
    public static final RecordingType RECORD_VIDEO_AND_AUDIO = null;
    public static final RecordingType RECORD_VIDEO_ONLY = null;
    private int value;

    static {
        RecordingType r100 = new RecordingType("RECORD_AUDIO_ONLY", 0, 0);
        RECORD_AUDIO_ONLY = r100;
        RecordingType r101 = new RecordingType("RECORD_VIDEO_ONLY", 1, 1);
        RECORD_VIDEO_ONLY = r101;
        RecordingType r102 = new RecordingType("RECORD_VIDEO_AND_AUDIO", 2, 2);
        RECORD_VIDEO_AND_AUDIO = r102;
        $VALUES = new RecordingType[]{r100, r101, r102};
    }

    public static RecordingType[] values() {
        return (RecordingType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RecordingType fromId(int r100) {
        RecordingType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        RecordingType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static RecordingType valueOf(String r100) {
        return (RecordingType) a.a(RecordingType.class, r100);
    }

    private RecordingType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
