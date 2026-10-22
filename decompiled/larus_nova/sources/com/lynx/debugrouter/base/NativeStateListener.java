package com.lynx.debugrouter.base;

/* JADX INFO: loaded from: classes32.dex */
public interface NativeStateListener {
    void onClose();

    void onError(String r100);

    void onMessage(String r100);

    void onOpen();
}
