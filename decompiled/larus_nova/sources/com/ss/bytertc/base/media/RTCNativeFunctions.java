package com.ss.bytertc.base.media;

/* JADX INFO: loaded from: classes40.dex */
public final class RTCNativeFunctions {
    public RTCNativeFunctions() {
    }

    public static native void nativeNotifyChoreographerDoFrame(long r100, Object r101, String r102);

    public static native void nativeNotifySurfaceAvailable(long r100, Object r101, String r102, boolean r103, boolean r104);

    public static native void nativeNotifySurfaceDestroyed(long r100, Object r101, String r102, boolean r103, boolean r104);

    public static native void nativeNotifySurfaceSizeChanged(long r100, String r101, boolean r102);

    public static native void nativeNotifyVSyncDoFrame(long r100, String r101);
}
