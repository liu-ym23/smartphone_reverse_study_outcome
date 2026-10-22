package com.lynx.debugrouter;

/* JADX INFO: loaded from: classes32.dex */
public interface DebugRouterSessionHandler {
    void onMessage(String r100, String r101, int r102);

    void onSessionCreate(int r100, String r101);

    void onSessionDestroy(int r100);
}
