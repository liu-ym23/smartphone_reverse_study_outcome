package com.bytedance.common.wschannel.event;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectEvent {
    public final ConnectionState connectionState;
    public final int mChannelId;
    public final ChannelType mType;

    public String toString() {
        return "ConnectEvent{mType=" + this.mType + ", connectionState=" + this.connectionState + ", mChannelId=" + this.mChannelId + '}';
    }

    public ConnectEvent(ConnectionState r100, ChannelType r101, int r102) {
        this.connectionState = r100;
        this.mType = r101;
        this.mChannelId = r102;
    }
}
