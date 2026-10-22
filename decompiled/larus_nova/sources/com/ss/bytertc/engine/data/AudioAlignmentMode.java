package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioAlignmentMode extends Enum<AudioAlignmentMode> {
    private static final /* synthetic */ AudioAlignmentMode[] $VALUES = null;
    public static final AudioAlignmentMode AUDIO_ALIGNMENT_MODE_AUDIOMIXING = null;
    public static final AudioAlignmentMode AUDIO_ALIGNMENT_MODE_OFF = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioAlignmentMode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioAlignmentMode = null;

        static {
            int[] r100 = new int[AudioAlignmentMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioAlignmentMode = r100;
            r100[AudioAlignmentMode.AUDIO_ALIGNMENT_MODE_OFF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$engine$data$AudioAlignmentMode[AudioAlignmentMode.AUDIO_ALIGNMENT_MODE_AUDIOMIXING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        AudioAlignmentMode r100 = new AudioAlignmentMode("AUDIO_ALIGNMENT_MODE_OFF", 0, 0);
        AUDIO_ALIGNMENT_MODE_OFF = r100;
        AudioAlignmentMode r101 = new AudioAlignmentMode("AUDIO_ALIGNMENT_MODE_AUDIOMIXING", 1, 1);
        AUDIO_ALIGNMENT_MODE_AUDIOMIXING = r101;
        $VALUES = new AudioAlignmentMode[]{r100, r101};
    }

    public static AudioAlignmentMode[] values() {
        return (AudioAlignmentMode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioAlignmentMode[ordinal()];
        if (r100 != 1) goto L5;
        return "kAudioAlignmentModeOff";
    L5:
        if (r100 != 2) goto L10;
        return "kAudioAlignmentModeAudioMixing";
    L10:
        return "kAudioAlignmentModeOff";
    }

    public int value() {
        return this.value;
    }

    public static AudioAlignmentMode fromId(int r100) {
        AudioAlignmentMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioAlignmentMode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioAlignmentMode valueOf(String r100) {
        return (AudioAlignmentMode) a.a(AudioAlignmentMode.class, r100);
    }

    private AudioAlignmentMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
