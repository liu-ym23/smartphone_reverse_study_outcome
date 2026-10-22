package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioFrameSource extends Enum<AudioFrameSource> {
    private static final /* synthetic */ AudioFrameSource[] $VALUES = null;
    public static final AudioFrameSource AUDIO_FRAME_SOURCE_MIC = null;
    public static final AudioFrameSource AUDIO_FRAME_SOURCE_MIXED = null;
    public static final AudioFrameSource AUDIO_FRAME_SOURCE_PLAYBACK = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioFrameSource$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioFrameSource = null;

        static {
            int[] r100 = new int[AudioFrameSource.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioFrameSource = r100;
            r100[AudioFrameSource.AUDIO_FRAME_SOURCE_MIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$ss$bytertc$engine$data$AudioFrameSource[AudioFrameSource.AUDIO_FRAME_SOURCE_PLAYBACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$engine$data$AudioFrameSource[AudioFrameSource.AUDIO_FRAME_SOURCE_MIXED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        AudioFrameSource r100 = new AudioFrameSource("AUDIO_FRAME_SOURCE_MIC", 0, 0);
        AUDIO_FRAME_SOURCE_MIC = r100;
        AudioFrameSource r101 = new AudioFrameSource("AUDIO_FRAME_SOURCE_PLAYBACK", 1, 1);
        AUDIO_FRAME_SOURCE_PLAYBACK = r101;
        AudioFrameSource r102 = new AudioFrameSource("AUDIO_FRAME_SOURCE_MIXED", 2, 2);
        AUDIO_FRAME_SOURCE_MIXED = r102;
        $VALUES = new AudioFrameSource[]{r100, r101, r102};
    }

    public static AudioFrameSource[] values() {
        return (AudioFrameSource[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioFrameSource[ordinal()];
        if (r100 != 1) goto L5;
        return "kAudioFrameSourceMic";
    L5:
        if (r100 != 2) goto L7;
        return "kAudioFrameSourcePlayback";
    L7:
        if (r100 == 3) goto L9;
        return "";
    L9:
        return "kAudioFrameSourceMixed";
    }

    public int value() {
        return this.value;
    }

    public static AudioFrameSource fromId(int r100) {
        AudioFrameSource[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioFrameSource r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioFrameSource valueOf(String r100) {
        return (AudioFrameSource) a.a(AudioFrameSource.class, r100);
    }

    private AudioFrameSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
