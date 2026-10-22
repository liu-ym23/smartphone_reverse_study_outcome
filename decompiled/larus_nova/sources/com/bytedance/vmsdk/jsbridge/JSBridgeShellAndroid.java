package com.bytedance.vmsdk.jsbridge;

/* JADX INFO: loaded from: classes22.dex */
public class JSBridgeShellAndroid {
    public JSBridgeShellAndroid() {
    }

    private static native long nativeCreateShellAndroid(JSModuleManager r100);

    private static native void nativeEvaluateJS(long r100, String r101);
}
