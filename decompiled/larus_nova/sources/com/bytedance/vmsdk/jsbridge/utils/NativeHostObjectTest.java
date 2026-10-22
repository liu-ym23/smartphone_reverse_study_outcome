package com.bytedance.vmsdk.jsbridge.utils;

/* JADX INFO: loaded from: classes22.dex */
public class NativeHostObjectTest implements NativeHostObject {
    public NativeHostObjectTest() {
    }

    public native long nativeGetHostObject(long r100);

    @Override // com.bytedance.vmsdk.jsbridge.utils.NativeHostObject
    public final long getPtr(long r100) {
        return nativeGetHostObject(r100);
    }
}
