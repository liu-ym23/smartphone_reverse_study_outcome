package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum FirstFramePlayState extends Enum<FirstFramePlayState> {
    private static final /* synthetic */ FirstFramePlayState[] $VALUES = null;
    public static final FirstFramePlayState FIRST_FRAME_PLAY_STATE_END = null;
    public static final FirstFramePlayState FIRST_FRAME_PLAY_STATE_PLAYED = null;
    public static final FirstFramePlayState FIRST_FRAME_PLAY_STATE_PLAYING = null;
    private int state;

    static {
        FirstFramePlayState r100 = new FirstFramePlayState("FIRST_FRAME_PLAY_STATE_PLAYING", 0, 0);
        FIRST_FRAME_PLAY_STATE_PLAYING = r100;
        FirstFramePlayState r101 = new FirstFramePlayState("FIRST_FRAME_PLAY_STATE_PLAYED", 1, 1);
        FIRST_FRAME_PLAY_STATE_PLAYED = r101;
        FirstFramePlayState r102 = new FirstFramePlayState("FIRST_FRAME_PLAY_STATE_END", 2, 2);
        FIRST_FRAME_PLAY_STATE_END = r102;
        $VALUES = new FirstFramePlayState[]{r100, r101, r102};
    }

    public static FirstFramePlayState[] values() {
        return (FirstFramePlayState[]) $VALUES.clone();
    }

    public int value() {
        return this.state;
    }

    public static FirstFramePlayState fromId(int r100) {
        FirstFramePlayState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        FirstFramePlayState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static FirstFramePlayState valueOf(String r100) {
        return (FirstFramePlayState) a.a(FirstFramePlayState.class, r100);
    }

    private FirstFramePlayState(String r100, int r101, int r102) {
        super(r100, r101);
        this.state = r102;
    }
}
