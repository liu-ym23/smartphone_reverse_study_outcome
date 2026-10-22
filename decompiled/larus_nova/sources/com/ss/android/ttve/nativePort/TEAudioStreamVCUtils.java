package com.ss.android.ttve.nativePort;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes38.dex */
public class TEAudioStreamVCUtils {
    public TEAudioStreamVCUtils() {
    }

    private static native int nativeCancelStreamVCConnet(long r100);

    private static native long nativeCreateStreamVCHandle(String r100, String r101, String r102, String r103, OnTEAudioStreamVCDataReceivedListener r104);

    private static native int nativeDestroyStreamVCHandle(long r100);

    private static native int nativeInitStreamVCTotalFile(long r100, String[] r101, long[] r102, long[] r103, String r104);

    private static native long nativeIsStreamVCAudioPath(String r100);

    private static native int nativeRestartStreamVCConnet(long r100);

    private static native int nativeStartStreamVCConnet(long r100, String r101);

    private static native int nativeStartStreamVCProcess(long r100, String r101, String r102, long r103, long r104);

    private static native int nativeStopStreamVCConnet(long r100, boolean r101);

    static {
        TENativeLibsLoader.loadLibrary();
    }

    public static int cancelStreamVCConnet(long r100) {
        if (r100 != (-1)) goto L7;
        return -1;
    L7:
        return nativeCancelStreamVCConnet(r100);
    }

    public static int destroyStreamVCHandle(long r100) {
        if (r100 != (-1)) goto L7;
        return -1;
    L7:
        return nativeDestroyStreamVCHandle(r100);
    }

    public static long isStreamVCAudioPath(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return -1;
    L7:
        return nativeIsStreamVCAudioPath(r100);
    }

    public static int restartStreamVCConnet(long r100) {
        if (r100 != (-1)) goto L7;
        return -1;
    L7:
        return restartStreamVCConnet(r100);
    }

    public static int startStreamVCConnet(long r100, String r101) {
        if (r100 != (-1)) goto L5;
        return -1;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return -1;
    L8:
        return nativeStartStreamVCConnet(r100, r101);
    }

    public static int stopStreamVCConnet(long r100, boolean r101) {
        if (r100 != (-1)) goto L7;
        return -1;
    L7:
        return nativeStopStreamVCConnet(r100, r101);
    }

    public static long createStreamVCHandle(String r100, String r101, String r102, String r103, OnTEAudioStreamVCDataReceivedListener r104) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return -1;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return -1;
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L10;
        return -1;
    L10:
        return nativeCreateStreamVCHandle(r100, r101, r102, r103, r104);
    }

    public static int initStreamVCTotalFile(long r100, String[] r101, long[] r102, long[] r103, String r104) {
        if (r100 != (-1)) goto L7;
        return -1;
    L7:
        return nativeInitStreamVCTotalFile(r100, r101, r102, r103, r104);
    }

    public static int startStreamVCProcess(long r100, String r101, String r102, long r103, long r104) {
        if (r100 != (-1)) goto L7;
        return -1;
    L7:
        return nativeStartStreamVCProcess(r100, r101, r102, r103, r104);
    }
}
