package com.lynx.jsbridge;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.WritableArray;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class CallbackImpl implements Callback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean mInvoked;
    private long mNativePtr;

    private native void nativeInvoke(long r100, WritableArray r101);

    private native void nativeReleaseNativePtr(long r100);

    public void resetNativePtr() {
        this.mNativePtr = 0;
    }

    public void finalize() throws Throwable {
        super.finalize();
        nativeReleaseNativePtr(this.mNativePtr);
    }

    static {
    }

    public CallbackImpl(long r100) {
        this.mNativePtr = r100;
        this.mInvoked = false;
    }

    @Override // com.lynx.react.bridge.Callback
    public void invoke(Object... r100) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.mInvoked == false) goto L8;
        LLog.report("LynxModule", "Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L8:
        this.mInvoked = true;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        long r101 = this.mNativePtr;
        if (r101 != 0) goto L14;
        LLog.e("LynxModule", "callback invoke failed: mNativePtr is NULL");
        return;
    L14:
        nativeInvoke(r101, JavaOnlyArray.of(r100));
    }

    public void invokeCallback(Object... r100) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.mInvoked == false) goto L8;
        LLog.report("LynxModule", "Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L8:
        this.mInvoked = true;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        long r101 = this.mNativePtr;
        if (r101 != 0) goto L14;
        LLog.e("LynxModule", "callback invoke failed: mNativePtr is NULL");
        return;
    L14:
        nativeInvoke(r101, JavaOnlyArray.of(r100));
    }
}
