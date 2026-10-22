package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioRecordingState extends Enum<AudioRecordingState> {
    private static final /* synthetic */ AudioRecordingState[] $VALUES = null;
    public static final AudioRecordingState AUDIO_RECORDING_STATE_ERROR = null;
    public static final AudioRecordingState AUDIO_RECORDING_STATE_PROCESSING = null;
    public static final AudioRecordingState AUDIO_RECORDING_STATE_SUCCESS = null;
    private int value;

    static {
        AudioRecordingState r100 = new AudioRecordingState("AUDIO_RECORDING_STATE_ERROR", 0, 0);
        AUDIO_RECORDING_STATE_ERROR = r100;
        AudioRecordingState r101 = new AudioRecordingState("AUDIO_RECORDING_STATE_PROCESSING", 1, 1);
        AUDIO_RECORDING_STATE_PROCESSING = r101;
        AudioRecordingState r102 = new AudioRecordingState("AUDIO_RECORDING_STATE_SUCCESS", 2, 2);
        AUDIO_RECORDING_STATE_SUCCESS = r102;
        $VALUES = new AudioRecordingState[]{r100, r101, r102};
    }

    public static AudioRecordingState[] values() {
        return (AudioRecordingState[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static AudioRecordingState fromId(int r100) {
        AudioRecordingState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        AudioRecordingState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return AUDIO_RECORDING_STATE_ERROR;
    }

    public static AudioRecordingState valueOf(String r100) {
        return (AudioRecordingState) a.a(AudioRecordingState.class, r100);
    }

    private AudioRecordingState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
