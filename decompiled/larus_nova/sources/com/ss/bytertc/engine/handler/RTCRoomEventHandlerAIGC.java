package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.RTCRoomImpl;
import com.ss.bytertc.engine.UserInfo;
import com.ss.bytertc.engine.aigc.IRTCRoomEventHandlerAIGC;
import com.ss.bytertc.engine.aigc.StartSessionResult;
import com.ss.bytertc.engine.utils.LogUtil;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class RTCRoomEventHandlerAIGC {
    private static final String TAG = "RTCRoomEventHandlerAIGC";
    private RTCRoomImpl mRtcRoom;

    public RTCRoomEventHandlerAIGC(RTCRoomImpl r100) {
        this.mRtcRoom = r100;
    }

    public static ByteBuffer allocateDirectByteBuffer(int r100) {
        return ByteBuffer.allocateDirect(r100);
    }

    public void onStartSessionResult(StartSessionResult r100, UserInfo r101, ByteBuffer r102) {
        LogUtil.d(TAG, "onStartSessionResult result: " + r100 + ", uid: " + r101.getUid() + ", extraInfo: " + r101.getExtraInfo());
        IRTCRoomEventHandlerAIGC r103 = this.mRtcRoom.getRtcRoomHandlerAIGC();     // Catch: Exception -> L7
        if (r103 == null) goto L12;
        r103.onStartSessionResult(r100, r101, r102);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.d(TAG, "onStartSessionResult callback catch exception.\n" + e.getMessage());
    }

    public void onStartSessionResultWithErrorCode(StartSessionResult r100, int r101, UserInfo r102, ByteBuffer r103) {
        LogUtil.d(TAG, "onStartSessionResultWithErrorCode result: " + r100 + ", error_code: " + r101 + ", uid: " + r102.getUid() + ", extraInfo: " + r102.getExtraInfo());
        IRTCRoomEventHandlerAIGC r104 = this.mRtcRoom.getRtcRoomHandlerAIGC();     // Catch: Exception -> L7
        if (r104 == null) goto L12;
        r104.onStartSessionResultWithErrorCode(r100, r101, r102, r103);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        LogUtil.d(TAG, "onStartSessionResultWithErrorCode callback catch exception.\n" + e.getMessage());
    }
}
