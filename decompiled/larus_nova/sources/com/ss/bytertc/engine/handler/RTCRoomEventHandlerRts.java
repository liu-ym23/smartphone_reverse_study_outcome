package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.InternalRTCStats;
import com.ss.bytertc.engine.RTSRoomImpl;
import com.ss.bytertc.engine.UserInfo;
import com.ss.bytertc.engine.type.RTCRoomStats;
import com.ss.bytertc.engine.utils.LogUtil;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class RTCRoomEventHandlerRts {
    private static final String TAG = "RtcRoomEventHandlerRts";
    private RTSRoomImpl mRtcRoom;

    public RTCRoomEventHandlerRts(RTSRoomImpl r100) {
        this.mRtcRoom = r100;
    }

    public static ByteBuffer allocateDirectByteBuffer(int r100) {
        return ByteBuffer.allocateDirect(r100);
    }

    public void onLeaveRoom(InternalRTCStats r100) {
        LogUtil.d(TAG, "onLeaveRoom...");
        RTSRoomImpl r101 = this.mRtcRoom;     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTSRoomEventHandler r102 = r101.getRtcRoomHandlerRts();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onLeaveRoom(new RTCRoomStats(r100));     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.d(TAG, "onLeaveRoom callback catch exception.\n" + e.getMessage());
    }

    public void onUserJoined(UserInfo r100) {
        LogUtil.d(TAG, "onUserJoined... uid: " + r100.getUid() + ", extraInfo: " + r100.getExtraInfo());
        RTSRoomImpl r101 = this.mRtcRoom;     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        IRTSRoomEventHandler r102 = r101.getRtcRoomHandlerRts();     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        r102.onUserJoined(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.d(TAG, "onUserJoined callback catch exception.\n" + e.getMessage());
    }

    public void onRoomMessageSendResult(long r100, int r101) {
        LogUtil.d(TAG, "onRoomMessageSendResult...");
        RTSRoomImpl r102 = this.mRtcRoom;     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTSRoomEventHandler r103 = r102.getRtcRoomHandlerRts();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onRoomMessageSendResult(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.d(TAG, "onRoomMessageSendResult callback catch exception.\n" + e.getMessage());
    }

    public void onUserLeave(String r100, int r101) {
        LogUtil.d(TAG, "onUserLeave... uid: " + r100 + ", reason: " + r101);
        RTSRoomImpl r102 = this.mRtcRoom;     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTSRoomEventHandler r103 = r102.getRtcRoomHandlerRts();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onUserLeave(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.d(TAG, "onUserLeave callback catch exception.\n" + e.getMessage());
    }

    public void onUserMessageSendResult(long r100, int r101) {
        LogUtil.d(TAG, "onUserMessageSendResult...");
        RTSRoomImpl r102 = this.mRtcRoom;     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        IRTSRoomEventHandler r103 = r102.getRtcRoomHandlerRts();     // Catch: Exception -> L9
        if (r103 == null) goto L15;
        r103.onUserMessageSendResult(r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.d(TAG, "onUserMessageSendResult callback catch exception.\n" + e.getMessage());
    }

    public void onRoomBinaryMessageReceived(String r100, ByteBuffer r101, long r102) {
        LogUtil.d(TAG, "onRoomBinaryMessageReceived, length: " + r101.capacity());
        RTSRoomImpl r103 = this.mRtcRoom;     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTSRoomEventHandler r104 = r103.getRtcRoomHandlerRts();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onRoomBinaryMessageReceived(r100, r101.duplicate());     // Catch: Exception -> L9
        r104.onRoomBinaryMessageReceived(r102, r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.d(TAG, "onRoomBinaryMessageReceived callback catch exception.\n" + e.getMessage());
    }

    public void onRoomMessageReceived(String r100, String r101, long r102) {
        LogUtil.d(TAG, "onRoomMessageReceived: " + r101);
        RTSRoomImpl r103 = this.mRtcRoom;     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTSRoomEventHandler r104 = r103.getRtcRoomHandlerRts();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onRoomMessageReceived(r100, r101);     // Catch: Exception -> L9
        r104.onRoomMessageReceived(r102, r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.d(TAG, "onRoomMessageReceived callback catch exception.\n" + e.getMessage());
    }

    public void onUserBinaryMessageReceived(String r100, ByteBuffer r101, long r102) {
        LogUtil.d(TAG, "onUserBinaryMessageReceived: uid:" + r100 + "binary message length" + r101.capacity());
        RTSRoomImpl r103 = this.mRtcRoom;     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTSRoomEventHandler r104 = r103.getRtcRoomHandlerRts();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onUserBinaryMessageReceived(r100, r101.duplicate());     // Catch: Exception -> L9
        r104.onUserBinaryMessageReceived(r102, r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.d(TAG, "onUserBinaryMessageReceived callback catch exception.\n" + e.getMessage());
    }

    public void onUserMessageReceived(String r100, String r101, long r102) {
        LogUtil.d(TAG, "onUserMessageReceived: uid:" + r100 + "message" + r101);
        RTSRoomImpl r103 = this.mRtcRoom;     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        IRTSRoomEventHandler r104 = r103.getRtcRoomHandlerRts();     // Catch: Exception -> L9
        if (r104 == null) goto L15;
        r104.onUserMessageReceived(r100, r101);     // Catch: Exception -> L9
        r104.onUserMessageReceived(r102, r100, r101);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.d(TAG, "onUserMessageReceived callback catch exception.\n" + e.getMessage());
    }

    public void onRoomStateChanged(String r100, String r101, int r102, String r103) {
        LogUtil.d(TAG, "onRoomStateChanged...");
        RTSRoomImpl r104 = this.mRtcRoom;     // Catch: Exception -> L9
        if (r104 == null) goto L14;
        IRTSRoomEventHandler r105 = r104.getRtcRoomHandlerRts();     // Catch: Exception -> L9
        if (r105 == null) goto L15;
        r105.onRoomStateChanged(r100, r101, r102, r103);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        LogUtil.d(TAG, "onRoomStateChanged callback catch exception.\n" + e.getMessage());
    }
}
