package com.bytedance.crash.resource;

import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.p;

/* JADX INFO: loaded from: classes3.dex */
public class NativeResourceMonitor {
    public NativeResourceMonitor() {
    }

    private static native void nDumpNativeInfoThreads(String r100);

    private static native int nFakeOpen(String r100);

    private static native int nFdTrackDoCommand(int r100);

    private static native int nFdTrackDumpNative(int r100, String r101);

    private static native int nFdTrackGetFdCount(int r100);

    private static native int nNativeBridgeInit(int r100, int r101, String r102, String r103, String r104, String r105);

    private static native int nNativeDoCommnad(int r100);

    private static native long nNativeGetHeapLeakSize();

    private static native long nNativeGetHeapSize();

    private static native void nNativeNeedDumpMemInfo(int r100);

    private static native void nNativeSetDumpThreshold(long r100);

    private static native void nNativeSetMinSizeByte(long r100);

    private static native int nVmMonitorDoCommand(int r100, int r101);

    private static native void nVmMonitorDumpMaps(String r100);

    private static native int nVmMonitorDumpNative(int r100, int r101, String r102);

    private static native int nXasanInit(int r100, String r101, String r102);

    public static long g() {
        if (NativeBridge.H() == true) goto L7;
        return -1;
    L7:
        return nNativeGetHeapLeakSize();
    }

    public static long h() {
        if (NativeBridge.H() == true) goto L7;
        return -1;
    L7:
        return nNativeGetHeapSize();
    }

    public static void c(String r100) {
        if (NativeBridge.H() == false) goto L6;
        nDumpNativeInfoThreads(r100);
        return;
    }

    public static int d(int r100) {
        if (NativeBridge.H() == true) goto L7;
        return -1;
    L7:
        return nFdTrackDoCommand(r100);
    }

    public static int e(int r100) {
        if (NativeBridge.H() == true) goto L7;
        return -1;
    L7:
        return nFdTrackGetFdCount(r100);
    }

    public static int f(int r100) {
        if (NativeBridge.H() == true) goto L7;
        return -1;
    L7:
        return nNativeDoCommnad(r100);
    }

    public static void j(String r100) {
        if (NativeBridge.H() == true) goto L5;
        return;
    L5:
        nVmMonitorDumpMaps(r100);
    }

    public static int i(int r100, int r101) {
        if (NativeBridge.H() == true) goto L7;
        return -1;
    L7:
        return nVmMonitorDoCommand(r100, r101);
    }

    public static void b(int r100, String r101, String r102) {
        if (NativeBridge.H() == true) goto L6;
        p.c("xasan load so failed");
        return;
    L6:
        nXasanInit(r100, r101, r102);
    }

    public static int a(int r100, int r101, String r102, String r103, String r104, String r105) {
        if (NativeBridge.H() == true) goto L7;
        p.c("monitorType:" + r101 + " soName:" + r102);
        return -1;
    L7:
        return nNativeBridgeInit(r100, r101, r102, r103, r104, r105);
    }
}
