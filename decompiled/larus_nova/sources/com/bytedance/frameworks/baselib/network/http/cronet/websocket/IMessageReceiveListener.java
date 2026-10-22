package com.bytedance.frameworks.baselib.network.http.cronet.websocket;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public interface IMessageReceiveListener {
    void onConnection(int r100, String r101, JSONObject r102);

    void onFeedBackLog(String r100);

    void onMessage(byte[] r100, int r101);
}
