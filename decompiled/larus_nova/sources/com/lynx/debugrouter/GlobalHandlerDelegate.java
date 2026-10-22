package com.lynx.debugrouter;

/* JADX INFO: loaded from: classes32.dex */
public class GlobalHandlerDelegate implements DebugRouterGlobalHandler {
    private DebugRouterGlobalHandler handler;

    public GlobalHandlerDelegate(DebugRouterGlobalHandler r100) {
        this.handler = r100;
    }

    @Override // com.lynx.debugrouter.DebugRouterGlobalHandler
    public void openCard(String r100) {
        DebugRouterGlobalHandler r101 = this.handler;
        if (r101 == null) goto L6;
        r101.openCard(r100);
        return;
    }

    @Override // com.lynx.debugrouter.DebugRouterGlobalHandler
    public void onMessage(String r100, int r101, String r102) {
        DebugRouterGlobalHandler r103 = this.handler;
        if (r103 == null) goto L6;
        r103.onMessage(r100, r101, r102);
        return;
    }
}
