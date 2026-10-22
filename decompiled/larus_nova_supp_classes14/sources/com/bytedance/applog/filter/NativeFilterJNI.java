package com.bytedance.applog.filter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class NativeFilterJNI {
    public NativeFilterJNI() {
    }

    public static native void nativeClearCache(String r0);

    public static native int nativeInitServerFilter(String r0, String r1);

    public static native boolean nativeIsEventAllowed(String r0, String r1);

    public static native boolean nativeIsServerFilterEmpty(String r0);

    public static native int nativeSetServerFilterConfig(String r0, String r1);
}
