package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.utils.LogUtil;

/* JADX INFO: loaded from: classes40.dex */
public class RTCEncryptHandler {
    private static final String TAG = "RtcEngineEncryptHandler";
    private IRTCEncryptionHandler mCustomizeEncryptHandler;

    public RTCEncryptHandler(IRTCEncryptionHandler r100) {
        this.mCustomizeEncryptHandler = r100;
    }

    public byte[] onDecryptData(byte[] r100) {
        LogUtil.d(TAG, "onDecryptData...");
        IRTCEncryptionHandler r101 = this.mCustomizeEncryptHandler;     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        return r101.onDecryptData(r100);
    L12:
        return null;
    L7:
        e = move-exception;
        LogUtil.d(TAG, "onDecryptData callback catch exception.\n" + e.getMessage());
        return null;
    }

    public byte[] onEncryptData(byte[] r100) {
        LogUtil.d(TAG, "onEncryptData...");
        IRTCEncryptionHandler r101 = this.mCustomizeEncryptHandler;     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        return r101.onEncryptData(r100);
    L12:
        return null;
    L7:
        e = move-exception;
        LogUtil.d(TAG, "onEncryptData callback catch exception.\n" + e.getMessage());
        return null;
    }
}
