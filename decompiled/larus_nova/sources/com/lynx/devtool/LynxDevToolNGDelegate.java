package com.lynx.devtool;

import com.lynx.devtoolwrapper.CDPEventListener;
import com.lynx.devtoolwrapper.CDPResultCallback;
import com.lynx.devtoolwrapper.MessageHandler;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes32.dex */
public class LynxDevToolNGDelegate {
    private final Object mDevToolLock;
    private final AtomicBoolean mHasDestroy;
    private long mLynxDevToolNGPtr;
    private int mSessionId;

    private native void nativeAddCDPEventListener(long r100, String r101, CDPEventListenerWrapper r102);

    private native int nativeAttachToDebug(long r100, String r101);

    private native long nativeCreateLynxDevToolNG(boolean r100);

    private native void nativeDestroy(long r100);

    private native void nativeDetachToDebug(long r100);

    private native void nativeInvokeCDPFromSDK(long r100, String r101, CDPResultCallbackWrapper r102);

    private native long nativeOnBackgroundRuntimeCreated(long r100, String r101);

    private native void nativeOnMTSRuntimeCreated(long r100, long r101);

    private native void nativeOnTasmCreated(long r100, long r101);

    private native void nativeRemoveCDPEventListener(long r100, String r101);

    private native void nativeSendMessageToDebugPlatform(long r100, String r101, String r102);

    private native void nativeSetDevToolPlatformAbility(long r100, long r101);

    private native void nativeSetTag(long r100, String r101);

    private native void nativeSubscribeMessage(long r100, String r101, DevToolMessageHandlerDelegate r102);

    private native void nativeUnSubscribeMessage(long r100, String r101);

    private native void nativeUpdateDevice(int r100, int r101, float r102);

    public void destroy() {
        if (this.mHasDestroy.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Object r100 = this.mDevToolLock;
        monitor-enter(r100);
        long r101 = this.mLynxDevToolNGPtr;     // Catch: Throwable -> L12
        if (r101 == 0) goto L10;
        nativeDestroy(r101);     // Catch: Throwable -> L12
        this.mLynxDevToolNGPtr = 0;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void detachToDebug() {
        long r100 = this.mLynxDevToolNGPtr;
        if (r100 == 0) goto L6;
        nativeDetachToDebug(r100);
        this.mSessionId = 0;
        return;
    }

    public boolean isAttachToDebugRouter() {
        if (this.mSessionId == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getSessionId() {
        return this.mSessionId;
    }

    public LynxDevToolNGDelegate(boolean r100) {
        this.mLynxDevToolNGPtr = 0;
        this.mSessionId = 0;
        this.mHasDestroy = new AtomicBoolean(false);
        this.mDevToolLock = new Object();
        this.mLynxDevToolNGPtr = nativeCreateLynxDevToolNG(r100);
    }

    public int attachToDebug(String r100) {
        long r101 = this.mLynxDevToolNGPtr;
        if (r101 == 0) goto L6;
        int r102 = nativeAttachToDebug(r101, r100);
        this.mSessionId = r102;
        return r102;
    L6:
        return 0;
    }

    public long onBackgroundRuntimeCreated(String r100) {
        long r101 = this.mLynxDevToolNGPtr;
        if (r101 != 0) goto L5;
        return 0;
    L5:
        return nativeOnBackgroundRuntimeCreated(r101, r100);
    }

    public void onMTSRuntimeCreated(long r100) {
        long r101 = this.mLynxDevToolNGPtr;
        if (r101 == 0) goto L6;
        nativeOnMTSRuntimeCreated(r101, r100);
        return;
    }

    public void onTASMCreated(long r100) {
        long r101 = this.mLynxDevToolNGPtr;
        if (r101 == 0) goto L6;
        nativeOnTasmCreated(r101, r100);
        return;
    }

    public void removeCDPEventListener(String r100) {
        nativeRemoveCDPEventListener(this.mLynxDevToolNGPtr, r100);
    }

    public void setDevToolPlatformAbility(long r100) {
        long r101 = this.mLynxDevToolNGPtr;
        if (r101 == 0) goto L6;
        nativeSetDevToolPlatformAbility(r101, r100);
        return;
    }

    public void setTag(String r100) {
        long r101 = this.mLynxDevToolNGPtr;
        if (r101 == 0) goto L6;
        nativeSetTag(r101, r100);
        return;
    }

    public void unSubscribeMessage(String r100) {
        nativeUnSubscribeMessage(this.mLynxDevToolNGPtr, r100);
    }

    public void addCDPEventListener(String r100, CDPEventListener r101) {
        nativeAddCDPEventListener(this.mLynxDevToolNGPtr, r100, new CDPEventListenerWrapper(r101));
    }

    public void invokeCDPFromSDK(String r100, CDPResultCallback r101) {
        nativeInvokeCDPFromSDK(this.mLynxDevToolNGPtr, r100, new CDPResultCallbackWrapper(r101));
    }

    public void sendMessageToDebugPlatform(String r100, String r101) {
        if (this.mHasDestroy.get() == false) goto L5;
        return;
    L5:
        Object r102 = this.mDevToolLock;
        monitor-enter(r102);
        long r103 = this.mLynxDevToolNGPtr;     // Catch: Throwable -> L12
        if (r103 == 0) goto L10;
        nativeSendMessageToDebugPlatform(r103, r100, r101);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void subscribeMessage(String r100, MessageHandler r101) {
        nativeSubscribeMessage(this.mLynxDevToolNGPtr, r100, new DevToolMessageHandlerDelegate(r101));
    }

    public void updateScreenMetrics(int r100, int r101, float r102) {
        nativeUpdateDevice(r100, r101, r102);
    }
}
