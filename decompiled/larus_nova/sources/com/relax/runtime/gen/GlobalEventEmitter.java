package com.relax.runtime.gen;

/* JADX INFO: loaded from: classes34.dex */
public class GlobalEventEmitter {
    private native long nativeCreate(long r100);

    private native void nativeDestroy(long r100);

    private native void nativeaddListener(long r100, String r101, GlobalEventCallback r102, String r103);

    private native void nativeremoveAllListeners(long r100, String r101);

    private native void nativeremoveListener(long r100, String r101, GlobalEventCallback r102);

    private native void nativetrigger(long r100, String r101, Object r102);

    public GlobalEventEmitter() {
    }

    public GlobalEventEmitter(long r100) {
        nativeCreate(r100);
    }
}
