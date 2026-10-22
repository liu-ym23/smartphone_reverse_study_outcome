package com.ss.bytertc.engine.video;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RemoteVideoSinkPosition extends Enum<RemoteVideoSinkPosition> {
    private static final /* synthetic */ RemoteVideoSinkPosition[] $VALUES = null;
    public static final RemoteVideoSinkPosition AFTER_DECODER = null;
    public static final RemoteVideoSinkPosition AFTER_POST_PROCESS = null;
    private int value;

    static {
        RemoteVideoSinkPosition r100 = new RemoteVideoSinkPosition("AFTER_DECODER", 0, 0);
        AFTER_DECODER = r100;
        RemoteVideoSinkPosition r101 = new RemoteVideoSinkPosition("AFTER_POST_PROCESS", 1, 1);
        AFTER_POST_PROCESS = r101;
        $VALUES = new RemoteVideoSinkPosition[]{r100, r101};
    }

    public static RemoteVideoSinkPosition[] values() {
        return (RemoteVideoSinkPosition[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static RemoteVideoSinkPosition convertFromInt(int r100) {
        return values()[r100];
    }

    public static RemoteVideoSinkPosition valueOf(String r100) {
        return (RemoteVideoSinkPosition) a.a(RemoteVideoSinkPosition.class, r100);
    }

    private RemoteVideoSinkPosition(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
