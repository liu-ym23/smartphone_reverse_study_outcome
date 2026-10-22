package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.SubscribeConfig;
import com.ss.bytertc.engine.data.AVSyncEvent;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.StreamKey;
import com.ss.bytertc.engine.type.MediaStreamType;
import com.ss.bytertc.engine.type.StreamRemoveReason;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IRTCRoomEventHandlerEx {
    public IRTCRoomEventHandlerEx() {
    }

    public void onAVSyncEvent(StreamKey r100, AVSyncEvent r101) {
    }

    public void onStreamPublishSuccess(String r100, StreamIndex r101, boolean r102) {
    }

    public void onStreamStateChanged(StreamKey r100, int r101, String r102) {
    }

    public void onStreamSubscribed(int r100, String r101, StreamIndex r102, SubscribeConfig r103) {
    }

    public void onUserPublishStream(RemoteStreamKey r100, boolean r101, MediaStreamType r102) {
    }

    public void onUserUnpublishStream(RemoteStreamKey r100, MediaStreamType r101, StreamRemoveReason r102) {
    }
}
