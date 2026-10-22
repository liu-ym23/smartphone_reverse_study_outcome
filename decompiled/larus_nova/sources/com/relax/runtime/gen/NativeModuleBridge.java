package com.relax.runtime.gen;

/* JADX INFO: loaded from: classes34.dex */
public class NativeModuleBridge {
    private native long nativeCreate(long r100);

    private native void nativeDestroy(long r100);

    private native Object nativegetNativeModuleInfo(long r100);

    private native Object nativeinvoke(long r100, String r101, Object r102, String r103);

    private native void nativeinvokeWithCallback(long r100, String r101, Object r102, NativeModuleBridgeCallback r103, String r104);

    public NativeModuleBridge() {
    }
}
