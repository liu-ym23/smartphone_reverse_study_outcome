package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RecordingState extends Enum<RecordingState> {
    private static final /* synthetic */ RecordingState[] $VALUES = null;
    public static final RecordingState RECORDING_STATE_ERROE = null;
    public static final RecordingState RECORDING_STATE_PROCESSING = null;
    public static final RecordingState RECORDING_STATE_SUCCESS = null;
    private int value;

    static {
        RecordingState r100 = new RecordingState("RECORDING_STATE_ERROE", 0, 0);
        RECORDING_STATE_ERROE = r100;
        RecordingState r101 = new RecordingState("RECORDING_STATE_PROCESSING", 1, 1);
        RECORDING_STATE_PROCESSING = r101;
        RecordingState r102 = new RecordingState("RECORDING_STATE_SUCCESS", 2, 2);
        RECORDING_STATE_SUCCESS = r102;
        $VALUES = new RecordingState[]{r100, r101, r102};
    }

    public static RecordingState[] values() {
        return (RecordingState[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RecordingState fromId(int r100) {
        RecordingState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        RecordingState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return RECORDING_STATE_ERROE;
    }

    public static RecordingState valueOf(String r100) {
        return (RecordingState) a.a(RecordingState.class, r100);
    }

    private RecordingState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
