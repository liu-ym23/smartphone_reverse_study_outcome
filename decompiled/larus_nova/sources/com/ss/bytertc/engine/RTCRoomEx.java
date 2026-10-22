package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.RemoteVideoConfig;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.handler.IRTCRoomEventHandlerEx;
import com.ss.bytertc.engine.type.MediaStreamType;

/* JADX INFO: loaded from: classes40.dex */
public abstract class RTCRoomEx extends RTCRoom {
    public abstract int publishStream(StreamIndex r100, MediaStreamType r101);

    public abstract int setRTCRoomEventHandlerEx(IRTCRoomEventHandlerEx r100);

    public abstract int setRemoteVideoConfig(String r100, StreamIndex r101, RemoteVideoConfig r102);

    public abstract int subscribeStream(String r100, StreamIndex r101, MediaStreamType r102);

    public abstract int unpublishStream(StreamIndex r100, MediaStreamType r101);

    public abstract int unsubscribeStream(String r100, StreamIndex r101, MediaStreamType r102);

    public RTCRoomEx() {
    }
}
