package com.lynx.debugrouter.base;

/* JADX INFO: loaded from: classes32.dex */
public interface MessageTransceiverStateListener {
    void onClose(MessageTransceiver r100, int r101, String r102);

    void onError(MessageTransceiver r100, Throwable r101);

    void onMessage(MessageTransceiver r100, String r101);

    void onOpen(MessageTransceiver r100);
}
