package com.bytedance.vmsdk.jsbridge;

import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;

/* JADX INFO: loaded from: classes3.dex */
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

    @Override // com.bytedance.vmsdk.jsbridge.utils.Callback
    public void invoke(Object... r100) {
        if (this.mInvoked == false) goto L5;
        return;
    L5:
        long r101 = this.mNativePtr;
        if (r101 != 0) goto L8;
        return;
    L8:
        nativeInvoke(r101, JavaOnlyArray.of(r100));
        this.mInvoked = true;
    }

    public void invokeCallback(Object... r100) {
        if (this.mInvoked == false) goto L5;
        return;
    L5:
        long r101 = this.mNativePtr;
        if (r101 != 0) goto L8;
        return;
    L8:
        nativeInvoke(r101, JavaOnlyArray.of(r100));
        this.mInvoked = true;
    }
}
