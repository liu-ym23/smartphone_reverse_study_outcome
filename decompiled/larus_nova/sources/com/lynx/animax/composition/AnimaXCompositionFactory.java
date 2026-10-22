package com.lynx.animax.composition;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXCompositionFactory {
    private native void nativeCreate(String r100, long r101);

    private native void nativeLoadJson(String r100, String r101, float r102, AnimaXCompositionNativeCallback r103);

    private native void nativeLoadUri(String r100, String r101, float r102, AnimaXCompositionNativeCallback r103);

    private native void nativeRelease();

    public AnimaXCompositionFactory() {
        new ConcurrentHashMap();
    }
}
