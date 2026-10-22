package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalRoomEventInfo {
    public long forbiddenTime;

    public InternalRoomEventInfo(long r100) {
        this.forbiddenTime = r100;
    }

    private static InternalRoomEventInfo create(long r100) {
        return new InternalRoomEventInfo(r100);
    }
}
