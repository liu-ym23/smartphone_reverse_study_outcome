package com.bytedance.sdk.xbridge.cn.websocket.utils;

/* JADX INFO: loaded from: classes22.dex */
public interface k {
    void onClosed(boolean r100);

    void onConnected();

    void onFailed(String r100);

    void onMessage(String r100);

    void onMessage(byte[] r100);
}
