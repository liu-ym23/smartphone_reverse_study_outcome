package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes3.dex */
public interface WsChannel {
    int getChannelId();

    boolean isConnected();

    void sendMsg(WsChannelMsg r100, MsgSendListener r101);

    void unregister();
}
