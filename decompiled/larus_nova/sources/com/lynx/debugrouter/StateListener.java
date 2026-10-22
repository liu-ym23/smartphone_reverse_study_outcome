package com.lynx.debugrouter;

/* JADX INFO: loaded from: classes32.dex */
public interface StateListener {
    void onClose(int r100, String r101);

    void onError(String r100);

    void onMessage(String r100);

    void onOpen(ConnectionType r100);
}
