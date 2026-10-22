package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioDumpStatus extends Enum<AudioDumpStatus> {
    private static final /* synthetic */ AudioDumpStatus[] $VALUES = null;
    public static final AudioDumpStatus AUDIO_DUMP_RUNNING_FAILURE = null;
    public static final AudioDumpStatus AUDIO_DUMP_RUNNING_SUCCESS = null;
    public static final AudioDumpStatus AUDIO_DUMP_START_FAILURE = null;
    public static final AudioDumpStatus AUDIO_DUMP_START_SUCCESS = null;
    public static final AudioDumpStatus AUDIO_DUMP_STOP_FAILURE = null;
    public static final AudioDumpStatus AUDIO_DUMP_STOP_SUCCESS = null;
    private int value;

    static {
        AudioDumpStatus r100 = new AudioDumpStatus("AUDIO_DUMP_START_FAILURE", 0, 0);
        AUDIO_DUMP_START_FAILURE = r100;
        AudioDumpStatus r101 = new AudioDumpStatus("AUDIO_DUMP_START_SUCCESS", 1, 1);
        AUDIO_DUMP_START_SUCCESS = r101;
        AudioDumpStatus r102 = new AudioDumpStatus("AUDIO_DUMP_STOP_FAILURE", 2, 2);
        AUDIO_DUMP_STOP_FAILURE = r102;
        AudioDumpStatus r103 = new AudioDumpStatus("AUDIO_DUMP_STOP_SUCCESS", 3, 3);
        AUDIO_DUMP_STOP_SUCCESS = r103;
        AudioDumpStatus r104 = new AudioDumpStatus("AUDIO_DUMP_RUNNING_FAILURE", 4, 4);
        AUDIO_DUMP_RUNNING_FAILURE = r104;
        AudioDumpStatus r105 = new AudioDumpStatus("AUDIO_DUMP_RUNNING_SUCCESS", 5, 5);
        AUDIO_DUMP_RUNNING_SUCCESS = r105;
        $VALUES = new AudioDumpStatus[]{r100, r101, r102, r103, r104, r105};
    }

    public static AudioDumpStatus[] values() {
        return (AudioDumpStatus[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static AudioDumpStatus fromId(int r100) {
        AudioDumpStatus[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        AudioDumpStatus r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return AUDIO_DUMP_START_FAILURE;
    }

    public static AudioDumpStatus valueOf(String r100) {
        return (AudioDumpStatus) a.a(AudioDumpStatus.class, r100);
    }

    private AudioDumpStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
