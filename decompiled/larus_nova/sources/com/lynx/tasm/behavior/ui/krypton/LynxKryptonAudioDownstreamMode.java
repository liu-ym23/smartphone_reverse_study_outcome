package com.lynx.tasm.behavior.ui.krypton;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum LynxKryptonAudioDownstreamMode extends Enum<LynxKryptonAudioDownstreamMode> {
    private static final /* synthetic */ LynxKryptonAudioDownstreamMode[] $VALUES = null;
    public static final LynxKryptonAudioDownstreamMode KEEP_PLAYBACK = null;
    public static final LynxKryptonAudioDownstreamMode REPLACE_PLAYBACK = null;

    static {
        LynxKryptonAudioDownstreamMode r100 = new LynxKryptonAudioDownstreamMode("KEEP_PLAYBACK", 0);
        KEEP_PLAYBACK = r100;
        LynxKryptonAudioDownstreamMode r101 = new LynxKryptonAudioDownstreamMode("REPLACE_PLAYBACK", 1);
        REPLACE_PLAYBACK = r101;
        $VALUES = new LynxKryptonAudioDownstreamMode[]{r100, r101};
    }

    public static LynxKryptonAudioDownstreamMode[] values() {
        return (LynxKryptonAudioDownstreamMode[]) $VALUES.clone();
    }

    public static LynxKryptonAudioDownstreamMode valueOf(String r100) {
        return (LynxKryptonAudioDownstreamMode) a.a(LynxKryptonAudioDownstreamMode.class, r100);
    }

    private LynxKryptonAudioDownstreamMode(String r100, int r101) {
        super(r100, r101);
    }
}
