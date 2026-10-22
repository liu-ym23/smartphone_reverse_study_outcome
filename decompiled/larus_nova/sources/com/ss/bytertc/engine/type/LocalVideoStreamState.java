package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum LocalVideoStreamState extends Enum<LocalVideoStreamState> {
    private static final /* synthetic */ LocalVideoStreamState[] $VALUES = null;
    public static final LocalVideoStreamState LOCAL_VIDEO_STREAM_STATE_ENCODING = null;
    public static final LocalVideoStreamState LOCAL_VIDEO_STREAM_STATE_FAILED = null;
    public static final LocalVideoStreamState LOCAL_VIDEO_STREAM_STATE_RECORDING = null;
    public static final LocalVideoStreamState LOCAL_VIDEO_STREAM_STATE_STOPPED = null;
    private int value;

    static {
        LocalVideoStreamState r100 = new LocalVideoStreamState("LOCAL_VIDEO_STREAM_STATE_STOPPED", 0, 0);
        LOCAL_VIDEO_STREAM_STATE_STOPPED = r100;
        LocalVideoStreamState r101 = new LocalVideoStreamState("LOCAL_VIDEO_STREAM_STATE_RECORDING", 1, 1);
        LOCAL_VIDEO_STREAM_STATE_RECORDING = r101;
        LocalVideoStreamState r102 = new LocalVideoStreamState("LOCAL_VIDEO_STREAM_STATE_ENCODING", 2, 2);
        LOCAL_VIDEO_STREAM_STATE_ENCODING = r102;
        LocalVideoStreamState r103 = new LocalVideoStreamState("LOCAL_VIDEO_STREAM_STATE_FAILED", 3, 3);
        LOCAL_VIDEO_STREAM_STATE_FAILED = r103;
        $VALUES = new LocalVideoStreamState[]{r100, r101, r102, r103};
    }

    public static LocalVideoStreamState[] values() {
        return (LocalVideoStreamState[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static LocalVideoStreamState fromId(int r100) {
        LocalVideoStreamState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        LocalVideoStreamState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static LocalVideoStreamState valueOf(String r100) {
        return (LocalVideoStreamState) a.a(LocalVideoStreamState.class, r100);
    }

    private LocalVideoStreamState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
