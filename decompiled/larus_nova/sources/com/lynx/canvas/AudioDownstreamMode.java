package com.lynx.canvas;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum AudioDownstreamMode extends Enum<AudioDownstreamMode> {
    private static final /* synthetic */ AudioDownstreamMode[] $VALUES = null;
    public static final AudioDownstreamMode KEEP_PLAYBACK = null;
    public static final AudioDownstreamMode REPLACE_PLAYBACK = null;
    public final int value;

    static {
        AudioDownstreamMode r100 = new AudioDownstreamMode("KEEP_PLAYBACK", 0, 0);
        KEEP_PLAYBACK = r100;
        AudioDownstreamMode r101 = new AudioDownstreamMode("REPLACE_PLAYBACK", 1, 1);
        REPLACE_PLAYBACK = r101;
        $VALUES = new AudioDownstreamMode[]{r100, r101};
    }

    public static AudioDownstreamMode[] values() {
        return (AudioDownstreamMode[]) $VALUES.clone();
    }

    public static AudioDownstreamMode valueOf(String r100) {
        return (AudioDownstreamMode) a.a(AudioDownstreamMode.class, r100);
    }

    private AudioDownstreamMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
