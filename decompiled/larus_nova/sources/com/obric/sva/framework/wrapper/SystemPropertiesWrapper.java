package com.obric.sva.framework.wrapper;

import android.os.SystemProperties;

/* JADX INFO: loaded from: classes34.dex */
public class SystemPropertiesWrapper {
    public SystemPropertiesWrapper() {
    }

    public static String get(String r100) {
        return SystemProperties.get(r100);
    }

    public static String get(String r100, String r101) {
        return SystemProperties.get(r100, r101);
    }

    public static boolean getBoolean(String r100, boolean r101) {
        return SystemProperties.getBoolean(r100, r101);
    }

    public static long getLong(String r100, long r101) {
        return SystemProperties.getLong(r100, r101);
    }

    public static void set(String r100, String r101) {
        SystemProperties.set(r100, r101);
    }
}
