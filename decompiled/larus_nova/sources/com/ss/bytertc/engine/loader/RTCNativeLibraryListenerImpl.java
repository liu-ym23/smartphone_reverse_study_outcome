package com.ss.bytertc.engine.loader;

import com.ss.bytertc.engine.utils.LogUtil;

/* JADX INFO: loaded from: classes40.dex */
public class RTCNativeLibraryListenerImpl implements RTCNativeLibraryLoaderListener {
    private static final String TAG = "RtcNativeLibraryLoaderListener";

    public RTCNativeLibraryListenerImpl() {
    }

    @Override // com.ss.bytertc.engine.loader.RTCNativeLibraryLoaderListener
    public void onLoadAlready(String r100) {
        LogUtil.i(TAG, "onLoadAlready : " + r100);
    }

    @Override // com.ss.bytertc.engine.loader.RTCNativeLibraryLoaderListener
    public void onLoadError(String r100) {
        LogUtil.i(TAG, "onLoadError : " + r100);
    }

    @Override // com.ss.bytertc.engine.loader.RTCNativeLibraryLoaderListener
    public void onLoadSuccess(String r100) {
        LogUtil.i(TAG, "onLoadSuccess : " + r100);
    }
}
