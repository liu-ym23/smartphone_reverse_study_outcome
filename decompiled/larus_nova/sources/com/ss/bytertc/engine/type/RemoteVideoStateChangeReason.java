package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RemoteVideoStateChangeReason extends Enum<RemoteVideoStateChangeReason> {
    private static final /* synthetic */ RemoteVideoStateChangeReason[] $VALUES = null;
    public static final RemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_INTERNAL = null;
    public static final RemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_MUTED = null;
    public static final RemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_UNMUTED = null;
    public static final RemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_CONGESTION = null;
    public static final RemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_RECOVERY = null;
    public static final RemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_MUTED = null;
    public static final RemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_OFFLINE = null;
    public static final RemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_UNMUTED = null;
    private int value;

    static {
        RemoteVideoStateChangeReason r100 = new RemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_INTERNAL", 0, 0);
        REMOTE_VIDEO_STATE_CHANGE_REASON_INTERNAL = r100;
        RemoteVideoStateChangeReason r101 = new RemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_CONGESTION", 1, 1);
        REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_CONGESTION = r101;
        RemoteVideoStateChangeReason r102 = new RemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_RECOVERY", 2, 2);
        REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_RECOVERY = r102;
        RemoteVideoStateChangeReason r103 = new RemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_MUTED", 3, 3);
        REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_MUTED = r103;
        RemoteVideoStateChangeReason r104 = new RemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_UNMUTED", 4, 4);
        REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_UNMUTED = r104;
        RemoteVideoStateChangeReason r105 = new RemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_MUTED", 5, 5);
        REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_MUTED = r105;
        RemoteVideoStateChangeReason r110 = new RemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_UNMUTED", 6, 6);
        REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_UNMUTED = r110;
        RemoteVideoStateChangeReason r111 = new RemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_OFFLINE", 7, 7);
        REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_OFFLINE = r111;
        $VALUES = new RemoteVideoStateChangeReason[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static RemoteVideoStateChangeReason[] values() {
        return (RemoteVideoStateChangeReason[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RemoteVideoStateChangeReason fromId(int r100) {
        RemoteVideoStateChangeReason[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        RemoteVideoStateChangeReason r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static RemoteVideoStateChangeReason valueOf(String r100) {
        return (RemoteVideoStateChangeReason) a.a(RemoteVideoStateChangeReason.class, r100);
    }

    private RemoteVideoStateChangeReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
