package com.bytedance.realx.base;

/* JADX INFO: loaded from: classes21.dex */
public final class NativeNetworkFunctions {
    public NativeNetworkFunctions() {
    }

    public static native void nativeOnBlockedStatusChanged(String r100, boolean r101, long r102);

    public static native void nativeOnCapabilitiesChanged(String r100, String r101, long r102);

    public static native void nativeOnLinkPropertiesChanged(String r100, String r101, long r102);

    public static native void nativeOnNetworkAvailable(String r100, long r101);

    public static native void nativeOnNetworkLost(String r100, long r101);

    public static native void nativeOnNetworkResumed(String r100, long r101);

    public static native void nativeOnNetworkSuspended(String r100, long r101);

    public static native void nativeOnNetworkUnavailable(long r100);
}
