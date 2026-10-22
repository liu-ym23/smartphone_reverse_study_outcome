package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RemoteVideoState extends Enum<RemoteVideoState> {
    private static final /* synthetic */ RemoteVideoState[] $VALUES = null;
    public static final RemoteVideoState REMOTE_VIDEO_STATE_DECODING = null;
    public static final RemoteVideoState REMOTE_VIDEO_STATE_FAILED = null;
    public static final RemoteVideoState REMOTE_VIDEO_STATE_FROZEN = null;
    public static final RemoteVideoState REMOTE_VIDEO_STATE_STARTING = null;
    public static final RemoteVideoState REMOTE_VIDEO_STATE_STOPPED = null;
    private int value;

    static {
        RemoteVideoState r100 = new RemoteVideoState("REMOTE_VIDEO_STATE_STOPPED", 0, 0);
        REMOTE_VIDEO_STATE_STOPPED = r100;
        RemoteVideoState r101 = new RemoteVideoState("REMOTE_VIDEO_STATE_STARTING", 1, 1);
        REMOTE_VIDEO_STATE_STARTING = r101;
        RemoteVideoState r102 = new RemoteVideoState("REMOTE_VIDEO_STATE_DECODING", 2, 2);
        REMOTE_VIDEO_STATE_DECODING = r102;
        RemoteVideoState r103 = new RemoteVideoState("REMOTE_VIDEO_STATE_FROZEN", 3, 3);
        REMOTE_VIDEO_STATE_FROZEN = r103;
        RemoteVideoState r104 = new RemoteVideoState("REMOTE_VIDEO_STATE_FAILED", 4, 4);
        REMOTE_VIDEO_STATE_FAILED = r104;
        $VALUES = new RemoteVideoState[]{r100, r101, r102, r103, r104};
    }

    public static RemoteVideoState[] values() {
        return (RemoteVideoState[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RemoteVideoState fromId(int r100) {
        RemoteVideoState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        RemoteVideoState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static RemoteVideoState valueOf(String r100) {
        return (RemoteVideoState) a.a(RemoteVideoState.class, r100);
    }

    private RemoteVideoState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
