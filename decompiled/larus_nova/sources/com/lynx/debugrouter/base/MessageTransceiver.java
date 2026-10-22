package com.lynx.debugrouter.base;

/* JADX INFO: loaded from: classes32.dex */
public interface MessageTransceiver {
    boolean connect(String r100);

    void disconnect();

    long queueSize();

    void removeStateListener(MessageTransceiverStateListener r100);

    void send(String r100);

    void setStateListener(MessageTransceiverStateListener r100);
}
