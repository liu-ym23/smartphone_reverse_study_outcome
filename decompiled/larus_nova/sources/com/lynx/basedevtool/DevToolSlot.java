package com.lynx.basedevtool;

import com.lynx.debugrouter.DebugRouterSlot;
import com.lynx.debugrouter.DebugRouterSlotDelegate;
import z4a.a;

/* JADX INFO: loaded from: classes32.dex */
public class DevToolSlot implements DebugRouterSlotDelegate {
    private static final int STATUS_UNINITIALIZED = -1;
    private DebugRouterSlot mDebugRouterSlot;
    private long mNativeHandler;
    private final Object mNativeHandlerLock;
    private String mTemplateUrl;

    private native void nativeOnSlotMessage(long r100, String r101, String r102);

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

    public void onNativeDestroyed() {
        Object r100 = this.mNativeHandlerLock;
        monitor-enter(r100);
        this.mNativeHandler = -1;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        DebugRouterSlot r101 = this.mDebugRouterSlot;
        if (r101 == null) goto L16;
        r101.pull();
        this.mDebugRouterSlot = null;
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void pull() {
        this.mDebugRouterSlot.pull();
    }

    @Override // com.lynx.debugrouter.DebugRouterSlotDelegate
    public String getTemplateUrl() {
        return this.mTemplateUrl;
    }

    private DevToolSlot(long r100) {
        this.mDebugRouterSlot = null;
        this.mTemplateUrl = "";
        this.mNativeHandlerLock = new Object();
        this.mNativeHandler = r100;
        this.mDebugRouterSlot = new DebugRouterSlot(this);
    }

    public static DevToolSlot createInstance(long r100) {
        return new DevToolSlot(r100);
    }

    public int plug(String r100) {
        this.mTemplateUrl = r100;
        return this.mDebugRouterSlot.plug();
    }

    @Override // com.lynx.debugrouter.DebugRouterSlotDelegate
    public void onMessage(String r100, String r101) {
        Object r102 = this.mNativeHandlerLock;
        monitor-enter(r102);
        long r103 = this.mNativeHandler;     // Catch: Throwable -> L11
        if (r103 != (-1)) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L11
        return;
    L8:
        nativeOnSlotMessage(r103, r100, r101);     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void sendMessage(String r100, String r101) {
        this.mDebugRouterSlot.sendDataAsync(r100, r101);
    }
}
