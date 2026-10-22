package com.bytedance.common.wschannel.channel.impl.ok.ws;

import okhttp3.Response;
import okio.ByteString;

/* JADX INFO: loaded from: classes15.dex */
public abstract class WebSocketListener {
    public WebSocketListener() {
    }

    public abstract void onClosed(CustomHeartBeatWebSocket r100, int r101, String r102);

    public void onClosing(CustomHeartBeatWebSocket r100, int r101, String r102) {
    }

    public abstract void onFailure(CustomHeartBeatWebSocket r100, Throwable r101, Response r102);

    public abstract void onMessage(CustomHeartBeatWebSocket r100, String r101);

    public abstract void onMessage(CustomHeartBeatWebSocket r100, ByteString r101);

    public abstract void onOpen(CustomHeartBeatWebSocket r100, Response r101);

    public abstract void onPong(CustomHeartBeatWebSocket r100, ByteString r101);
}
