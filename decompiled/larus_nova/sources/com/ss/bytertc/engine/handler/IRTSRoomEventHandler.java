package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.UserInfo;
import com.ss.bytertc.engine.type.RTCRoomStats;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IRTSRoomEventHandler {
    public IRTSRoomEventHandler() {
    }

    public void onLeaveRoom(RTCRoomStats r100) {
    }

    public void onRoomBinaryMessageReceived(long r100, String r101, ByteBuffer r102) {
    }

    public void onRoomBinaryMessageReceived(String r100, ByteBuffer r101) {
    }

    public void onRoomMessageReceived(long r100, String r101, String r102) {
    }

    public void onRoomMessageReceived(String r100, String r101) {
    }

    public void onRoomMessageSendResult(long r100, int r101) {
    }

    public void onRoomStateChanged(String r100, String r101, int r102, String r103) {
    }

    public void onUserBinaryMessageReceived(long r100, String r101, ByteBuffer r102) {
    }

    public void onUserBinaryMessageReceived(String r100, ByteBuffer r101) {
    }

    public void onUserJoined(UserInfo r100) {
    }

    public void onUserLeave(String r100, int r101) {
    }

    public void onUserMessageReceived(long r100, String r101, String r102) {
    }

    public void onUserMessageReceived(String r100, String r101) {
    }

    public void onUserMessageSendResult(long r100, int r101) {
    }
}
