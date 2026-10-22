package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioReportMode extends Enum<AudioReportMode> {
    private static final /* synthetic */ AudioReportMode[] $VALUES = null;
    public static final AudioReportMode AUDIO_REPORT_MODE_DISCONNECT = null;
    public static final AudioReportMode AUDIO_REPORT_MODE_NORMAL = null;
    public static final AudioReportMode AUDIO_REPORT_MODE_RESET = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioReportMode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioReportMode = null;

        static {
            int[] r100 = new int[AudioReportMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioReportMode = r100;
            r100[AudioReportMode.AUDIO_REPORT_MODE_NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$ss$bytertc$engine$data$AudioReportMode[AudioReportMode.AUDIO_REPORT_MODE_DISCONNECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$engine$data$AudioReportMode[AudioReportMode.AUDIO_REPORT_MODE_RESET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        AudioReportMode r100 = new AudioReportMode("AUDIO_REPORT_MODE_NORMAL", 0, 0);
        AUDIO_REPORT_MODE_NORMAL = r100;
        AudioReportMode r101 = new AudioReportMode("AUDIO_REPORT_MODE_DISCONNECT", 1, 1);
        AUDIO_REPORT_MODE_DISCONNECT = r101;
        AudioReportMode r102 = new AudioReportMode("AUDIO_REPORT_MODE_RESET", 2, 2);
        AUDIO_REPORT_MODE_RESET = r102;
        $VALUES = new AudioReportMode[]{r100, r101, r102};
    }

    public static AudioReportMode[] values() {
        return (AudioReportMode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioReportMode[ordinal()];
        if (r100 != 1) goto L5;
        return "AUDIO_REPORT_MODE_NORMAL";
    L5:
        if (r100 != 2) goto L7;
        return "AUDIO_REPORT_MODE_DISCONNECT";
    L7:
        if (r100 == 3) goto L9;
        return "";
    L9:
        return "AUDIO_REPORT_MODE_RESET";
    }

    public int value() {
        return this.value;
    }

    public static AudioReportMode fromId(int r100) {
        AudioReportMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioReportMode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioReportMode valueOf(String r100) {
        return (AudioReportMode) a.a(AudioReportMode.class, r100);
    }

    private AudioReportMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
