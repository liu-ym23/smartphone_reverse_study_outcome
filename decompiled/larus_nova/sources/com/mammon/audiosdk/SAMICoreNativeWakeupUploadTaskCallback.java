package com.mammon.audiosdk;

/* JADX INFO: loaded from: classes32.dex */
public class SAMICoreNativeWakeupUploadTaskCallback {
    private static SAMICoreWakeupUploadTaskCallback userCallback;

    public SAMICoreNativeWakeupUploadTaskCallback() {
    }

    public static void onWakeupUploadTask(byte[] r100) {
        SAMICoreWakeupUploadTaskCallback r101 = userCallback;
        if (r101 == null) goto L6;
        r101.onWakeupUploadTask(r100);
        return;
    }

    public static void setWakeupUploadTaskCallback(SAMICoreWakeupUploadTaskCallback r100) {
        userCallback = r100;
    }
}
