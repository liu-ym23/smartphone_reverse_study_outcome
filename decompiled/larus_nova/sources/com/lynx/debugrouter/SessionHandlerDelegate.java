package com.lynx.debugrouter;

/* JADX INFO: loaded from: classes32.dex */
public class SessionHandlerDelegate implements DebugRouterSessionHandler {
    private DebugRouterSessionHandler handler;

    public SessionHandlerDelegate(DebugRouterSessionHandler r100) {
        this.handler = r100;
    }

    @Override // com.lynx.debugrouter.DebugRouterSessionHandler
    public void onSessionDestroy(int r100) {
        DebugRouterSessionHandler r101 = this.handler;
        if (r101 == null) goto L6;
        r101.onSessionDestroy(r100);
        return;
    }

    @Override // com.lynx.debugrouter.DebugRouterSessionHandler
    public void onSessionCreate(int r100, String r101) {
        DebugRouterSessionHandler r102 = this.handler;
        if (r102 == null) goto L6;
        r102.onSessionCreate(r100, r101);
        return;
    }

    @Override // com.lynx.debugrouter.DebugRouterSessionHandler
    public void onMessage(String r100, String r101, int r102) {
        DebugRouterSessionHandler r103 = this.handler;
        if (r103 == null) goto L6;
        r103.onMessage(r100, r101, r102);
        return;
    }
}
