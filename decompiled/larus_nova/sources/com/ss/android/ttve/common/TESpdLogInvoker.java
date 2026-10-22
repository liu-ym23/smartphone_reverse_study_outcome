package com.ss.android.ttve.common;

import com.ss.android.ttve.nativePort.TECodecNativeLibsLoader;

/* JADX INFO: loaded from: classes38.dex */
public class TESpdLogInvoker {
    public TESpdLogInvoker() {
    }

    public native void close();

    public native int error(String r100);

    public native String getLogFiles(String r100);

    public native int info(int r100, String r101);

    public native int initSpdLog(String r100, int r101, int r102);

    public native void setLevel(int r100);

    public native int warn(String r100);

    static {
        TECodecNativeLibsLoader.d();
    }
}
