package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioSelectionPriority extends Enum<AudioSelectionPriority> {
    private static final /* synthetic */ AudioSelectionPriority[] $VALUES = null;
    public static final AudioSelectionPriority AUDIO_SELECTION_PRIORITY_HIGIH = null;
    public static final AudioSelectionPriority AUDIO_SELECTION_PRIORITY_NORMAL = null;
    private int value;

    static {
        AudioSelectionPriority r100 = new AudioSelectionPriority("AUDIO_SELECTION_PRIORITY_NORMAL", 0, 0);
        AUDIO_SELECTION_PRIORITY_NORMAL = r100;
        AudioSelectionPriority r101 = new AudioSelectionPriority("AUDIO_SELECTION_PRIORITY_HIGIH", 1, 1);
        AUDIO_SELECTION_PRIORITY_HIGIH = r101;
        $VALUES = new AudioSelectionPriority[]{r100, r101};
    }

    public static AudioSelectionPriority[] values() {
        return (AudioSelectionPriority[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static AudioSelectionPriority valueOf(String r100) {
        return (AudioSelectionPriority) a.a(AudioSelectionPriority.class, r100);
    }

    private AudioSelectionPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
