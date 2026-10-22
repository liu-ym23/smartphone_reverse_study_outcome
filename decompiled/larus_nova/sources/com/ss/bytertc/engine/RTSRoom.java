package com.ss.bytertc.engine;

import com.ss.bytertc.engine.handler.IRTSRoomEventHandler;
import com.ss.bytertc.engine.type.MessageConfig;

/* JADX INFO: loaded from: classes40.dex */
public abstract class RTSRoom {
    public RTSRoom() {
    }

    public abstract void destroy();

    public abstract int joinRTSRoom(String r100, UserInfo r101);

    public abstract int leaveRoom();

    public abstract long sendRoomBinaryMessage(byte[] r100);

    public abstract long sendRoomMessage(String r100);

    public abstract long sendUserBinaryMessage(String r100, byte[] r101, MessageConfig r102);

    public abstract long sendUserMessage(String r100, String r101, MessageConfig r102);

    public abstract int setRTSRoomEventHandler(IRTSRoomEventHandler r100);

    public abstract int updateToken(String r100);
}
