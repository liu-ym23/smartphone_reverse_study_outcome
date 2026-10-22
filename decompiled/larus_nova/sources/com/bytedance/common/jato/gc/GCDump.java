package com.bytedance.common.jato.gc;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class GCDump {
    private boolean inited;

    private native String nativeClassLinker();

    private native String nativeDumpDeoptimization();

    private native String nativeDumpGCPerformance();

    private native String nativeDumpInternTable();

    private native boolean nativeInit();

    private GCDump() {
        boolean r100 = false;
        this.inited = false;
        if (JatoNativeLoader.loadLibrary() == true) goto L5;
    L7:
        this.inited = r100;
        return;
    L5:
        if (nativeInit() == false) goto L7;
        r100 = true;
        goto L7
    }
}
