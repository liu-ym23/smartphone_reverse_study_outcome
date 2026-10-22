package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.RTCRoomImpl;
import com.ss.bytertc.engine.SubscribeConfig;
import com.ss.bytertc.engine.data.AVSyncEvent;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.StreamKey;
import com.ss.bytertc.engine.type.MediaStreamType;
import com.ss.bytertc.engine.type.StreamRemoveReason;
import com.ss.bytertc.engine.utils.LogUtil;

/* JADX INFO: loaded from: classes40.dex */
public class RTCRoomEventHandlerEx {
    private static final String TAG = "RtcRoomEventHandlerEx";
    private RTCRoomImpl mRtcRoom;

    public RTCRoomEventHandlerEx(RTCRoomImpl r100) {
        this.mRtcRoom = r100;
    }

    public void onAVSyncEvent(StreamKey r100, AVSyncEvent r101) {
        LogUtil.d(TAG, "onAVSyncEvent...");
        IRTCRoomEventHandlerEx r102 = this.mRtcRoom.getRtcRoomHandlerEx();     // Catch: Exception -> L7
        if (r102 == null) goto L12;
        r102.onAVSyncEvent(r100, r101);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.d(TAG, "onAVSyncEvent callback catch exception.\n" + e.getMessage());
    }

    public void onStreamPublishSuccess(String r100, StreamIndex r101, boolean r102) {
        LogUtil.d(TAG, "onStreamPublishSuccess...");
        IRTCRoomEventHandlerEx r103 = this.mRtcRoom.getRtcRoomHandlerEx();     // Catch: Exception -> L7
        if (r103 == null) goto L12;
        r103.onStreamPublishSuccess(r100, r101, r102);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.d(TAG, "onStreamPublishSuccess callback catch exception.\n" + e.getMessage());
    }

    public void onStreamStateChanged(StreamKey r100, int r101, String r102) {
        LogUtil.d(TAG, "onStreamStateChanged streamIndex: " + r100.getStreamIndex());
        IRTCRoomEventHandlerEx r103 = this.mRtcRoom.getRtcRoomHandlerEx();     // Catch: Exception -> L7
        if (r103 == null) goto L12;
        r103.onStreamStateChanged(r100, r101, r102);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.d(TAG, "onStreamStateChanged callback catch exception.\n" + e.getMessage());
    }

    public void onUserPublishStream(RemoteStreamKey r100, boolean r101, int r102) {
        LogUtil.d(TAG, "onUserPublishStream streamIndex: " + r100.getStreamIndex());
        IRTCRoomEventHandlerEx r103 = this.mRtcRoom.getRtcRoomHandlerEx();     // Catch: Exception -> L7
        if (r103 == null) goto L12;
        r103.onUserPublishStream(r100, r101, MediaStreamType.valueOf(r102));     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.d(TAG, "onUserPublishStream callback catch exception.\n" + e.getMessage());
    }

    public void onUserUnpublishStream(RemoteStreamKey r100, int r101, int r102) {
        LogUtil.d(TAG, "onUserUnpublishStream streamIndex: " + r100.getStreamIndex());
        if (r102 >= 0) goto L16;
    L9:
        LogUtil.d(TAG, "onUserUnpublishStream callback reason invalid.\n");     // Catch: Exception -> L7
        r102 = 0;
    L10:
        IRTCRoomEventHandlerEx r103 = this.mRtcRoom.getRtcRoomHandlerEx();     // Catch: Exception -> L7
        if (r103 == null) goto L18;
        r103.onUserUnpublishStream(r100, MediaStreamType.valueOf(r101), StreamRemoveReason.values()[r102]);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        LogUtil.d(TAG, "onUserUnpublishStream callback catch exception.\n" + e.getMessage());
        return;
    L18:
        return;
    L16:
        if (r102 <= StreamRemoveReason.STREAM_REMOVE_REASON_PUBLISH_PRIVILEGE_TOKEN_EXPIRED.value()) goto L10;
        goto L10
    }

    public void onStreamSubscribed(int r100, String r101, StreamIndex r102, SubscribeConfig r103) {
        LogUtil.d(TAG, "onStreamSubscribed...");
        IRTCRoomEventHandlerEx r104 = this.mRtcRoom.getRtcRoomHandlerEx();     // Catch: Exception -> L7
        if (r104 == null) goto L12;
        r104.onStreamSubscribed(r100, r101, r102, r103);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.d(TAG, "onStreamSubscribed callback catch exception.\n" + e.getMessage());
    }
}
