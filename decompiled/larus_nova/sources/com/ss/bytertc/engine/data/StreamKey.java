package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class StreamKey {
    private String roomId;
    private StreamIndex streamIndex;
    private String userId;

    public boolean hasNullProperty() {
        if (this.roomId != null) goto L5;
    L10:
        return true;
    L5:
        if (this.userId == null) goto L10;
        if (this.streamIndex == null) goto L10;
        return false;
    }

    public String toString() {
        return "RemoteStreamKey{roomId='" + this.roomId + "', userId='" + this.userId + "', streamIndex=" + this.streamIndex + '}';
    }

    public String getRoomId() {
        return this.roomId;
    }

    public StreamIndex getStreamIndex() {
        return this.streamIndex;
    }

    public String getUserId() {
        return this.userId;
    }

    public StreamKey(String r100, String r101, StreamIndex r102) {
        this.roomId = r100;
        this.userId = r101;
        this.streamIndex = r102;
    }

    public static StreamKey create(String r100, String r101, StreamIndex r102) {
        return new StreamKey(r100, r101, r102);
    }
}
