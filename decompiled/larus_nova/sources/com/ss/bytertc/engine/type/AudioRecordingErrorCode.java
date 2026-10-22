package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioRecordingErrorCode extends Enum<AudioRecordingErrorCode> {
    private static final /* synthetic */ AudioRecordingErrorCode[] $VALUES = null;
    public static final AudioRecordingErrorCode AUDIO_RECORDING_ERROR_CODE_ALREADY_STARTED = null;
    public static final AudioRecordingErrorCode AUDIO_RECORDING_ERROR_CODE_NOT_IN_ROOM = null;
    public static final AudioRecordingErrorCode AUDIO_RECORDING_ERROR_CODE_NOT_STARTED = null;
    public static final AudioRecordingErrorCode AUDIO_RECORDING_ERROR_CODE_NOT_SUPPORT = null;
    public static final AudioRecordingErrorCode AUDIO_RECORDING_ERROR_CODE_NO_PERMISSION = null;
    public static final AudioRecordingErrorCode AUDIO_RECORDING_ERROR_CODE_OK = null;
    public static final AudioRecordingErrorCode AUDIO_RECORDING_ERROR_CODE_OTHER = null;
    private int value;

    static {
        AudioRecordingErrorCode r100 = new AudioRecordingErrorCode("AUDIO_RECORDING_ERROR_CODE_OK", 0, 0);
        AUDIO_RECORDING_ERROR_CODE_OK = r100;
        AudioRecordingErrorCode r101 = new AudioRecordingErrorCode("AUDIO_RECORDING_ERROR_CODE_NO_PERMISSION", 1, -1);
        AUDIO_RECORDING_ERROR_CODE_NO_PERMISSION = r101;
        AudioRecordingErrorCode r102 = new AudioRecordingErrorCode("AUDIO_RECORDING_ERROR_CODE_NOT_IN_ROOM", 2, -2);
        AUDIO_RECORDING_ERROR_CODE_NOT_IN_ROOM = r102;
        AudioRecordingErrorCode r103 = new AudioRecordingErrorCode("AUDIO_RECORDING_ERROR_CODE_ALREADY_STARTED", 3, -3);
        AUDIO_RECORDING_ERROR_CODE_ALREADY_STARTED = r103;
        AudioRecordingErrorCode r104 = new AudioRecordingErrorCode("AUDIO_RECORDING_ERROR_CODE_NOT_STARTED", 4, -4);
        AUDIO_RECORDING_ERROR_CODE_NOT_STARTED = r104;
        AudioRecordingErrorCode r105 = new AudioRecordingErrorCode("AUDIO_RECORDING_ERROR_CODE_NOT_SUPPORT", 5, -5);
        AUDIO_RECORDING_ERROR_CODE_NOT_SUPPORT = r105;
        AudioRecordingErrorCode r110 = new AudioRecordingErrorCode("AUDIO_RECORDING_ERROR_CODE_OTHER", 6, -6);
        AUDIO_RECORDING_ERROR_CODE_OTHER = r110;
        $VALUES = new AudioRecordingErrorCode[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static AudioRecordingErrorCode[] values() {
        return (AudioRecordingErrorCode[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static AudioRecordingErrorCode fromId(int r100) {
        AudioRecordingErrorCode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        AudioRecordingErrorCode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return AUDIO_RECORDING_ERROR_CODE_OTHER;
    }

    public static AudioRecordingErrorCode valueOf(String r100) {
        return (AudioRecordingErrorCode) a.a(AudioRecordingErrorCode.class, r100);
    }

    private AudioRecordingErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
