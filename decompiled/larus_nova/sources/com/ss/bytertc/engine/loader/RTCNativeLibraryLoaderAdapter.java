package com.ss.bytertc.engine.loader;

/* JADX INFO: loaded from: classes40.dex */
public class RTCNativeLibraryLoaderAdapter {
    protected static RTCNativeLibraryLoader mRtcNativeLibraryLoader;

    public RTCNativeLibraryLoaderAdapter() {
    }

    static {
        mRtcNativeLibraryLoader = new RTCNativeLibraryLoaderImpl();
    }

    public static RTCNativeLibraryLoader getRtcNativeLibraryLoader() {
        return mRtcNativeLibraryLoader;
    }

    public static void setRtcNativeLibraryLoader(RTCNativeLibraryLoader r100) {
        mRtcNativeLibraryLoader = r100;
    }
}
