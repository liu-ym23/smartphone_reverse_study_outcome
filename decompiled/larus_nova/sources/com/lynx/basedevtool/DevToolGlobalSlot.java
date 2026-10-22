package com.lynx.basedevtool;

import com.lynx.debugrouter.DebugRouter;
import com.lynx.debugrouter.DebugRouterGlobalHandler;
import z4a.a;

/* JADX INFO: loaded from: classes32.dex */
public class DevToolGlobalSlot implements DebugRouterGlobalHandler {
    private static final int GLOBAL_MESSAGE_SESSION_ID = -1;
    private static final int STATUS_UNINITIALIZED = -1;
    private long mNativeHandler;

    private native void nativeOnGlobalSlotMessage(long r100, String r101, String r102);

    @Override // com.lynx.debugrouter.DebugRouterGlobalHandler
    public void openCard(String r100) {
    }

    static {
        if (a.f570043a == true) goto L12;
        a.a();     // Catch: UnsatisfiedLinkError -> L7
        a.f570043a = true;     // Catch: UnsatisfiedLinkError -> L7
        return;
    L7:
        e = move-exception;
        e.getMessage();
        return;
    }

    private DevToolGlobalSlot(long r100) {
        this.mNativeHandler = r100;
        DebugRouter.getInstance().addGlobalHandler(this);
    }

    public static DevToolGlobalSlot createInstance(long r100) {
        return new DevToolGlobalSlot(r100);
    }

    public void sendMessage(String r100, String r101) {
        DebugRouter.getInstance().sendDataAsync(r100, -1, r101);
    }

    @Override // com.lynx.debugrouter.DebugRouterGlobalHandler
    public void onMessage(String r100, int r101, String r102) {
        nativeOnGlobalSlotMessage(this.mNativeHandler, r100, r102);
    }
}
